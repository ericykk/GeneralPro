package com.eric.general.core.aop;

import com.eric.general.core.annotation.SystemLog;
import com.eric.general.model.OperateLogInfo;
import com.eric.general.model.VoteUserPO;
import com.eric.general.service.IOperateLogInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 描述:
 * <p>
 * 系统日志切面，针对使用了SystemLog注释的方法进行拦截 将日志数据写入数据库
 *
 * @author eric
 * @create 2018-05-07 下午4:07
 */
@Component
@Aspect
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * 记录每个用户刚开始访问方法的时间
     */
    private static final ThreadLocal<Date> BEGIN_TIME_THREAD_LOCAL = new NamedThreadLocal<Date>("ThreadLocal beginTime");

    private static final ThreadLocal<OperateLogInfo> LOG_THREAD_LOCAL = new NamedThreadLocal<OperateLogInfo>("ThreadLocal log");


    @Resource
    private HttpServletRequest request;

    /**
     * spring框架自带的线程池
     */
    @Resource
    private ThreadPoolTaskExecutor taskExecutor;


    @Resource
    private IOperateLogInfoService operateLogInfoService;

    public SystemLogAspect() {
    }

    /**
     * 对使用SystemLog注释的方法进行拦截
     */
    @Pointcut("@annotation(com.eric.general.core.annotation.SystemLog)")
    public void systemLogAspectCtrl() {
    }

    /**
     * 前置通知 用于拦截记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("systemLogAspectCtrl()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {


        System.out.println("@Before-check!!!");
        System.out.println("@Before-目标对象为：" + joinPoint.getTarget());
        System.out.println("@Before-目标方法：" + joinPoint.getSignature().getName());
        System.out.println("@Before-目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));

        Date beginTime = new Date();

        BEGIN_TIME_THREAD_LOCAL.set(beginTime);

        logger.debug("开始计时: {}，URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(beginTime), request.getRequestURI());

    }

    /**
     * 后置通知 用于拦截用户操作
     *
     * @param joinPoint 切点
     */
    @After("systemLogAspectCtrl()")
    public void doAfter(JoinPoint joinPoint) {

        HttpSession session = request.getSession();
        VoteUserPO user = (VoteUserPO) session.getAttribute("user");

        if (user != null) {
            OperateLogInfo operateLogInfo = new OperateLogInfo();

            operateLogInfo.setOperateUid(user.getId());
            operateLogInfo.setOperateName(user.getUserName());
            operateLogInfo.setStatus((byte) 1);
            operateLogInfo.setFromIp(request.getRemoteAddr());
            operateLogInfo.setRequestMethod(request.getMethod());
            operateLogInfo.setRequestUri(request.getRequestURI());
            operateLogInfo.setLogType("info");
            operateLogInfo.setOperateDesc(getMethodDescription(joinPoint));
            operateLogInfo.setVisitMethod(getMethod(joinPoint));
            operateLogInfo.setCostTime(System.currentTimeMillis() - BEGIN_TIME_THREAD_LOCAL.get().getTime() + "");

            // 开启新线程进行日志记录
            taskExecutor.execute(new SaveLogThread(operateLogInfo, operateLogInfoService));

            LOG_THREAD_LOCAL.set(operateLogInfo);

            BEGIN_TIME_THREAD_LOCAL.remove();

        }

    }


    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return description
     */
    private String getMethodDescription(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemLog systemLog = method.getAnnotation(SystemLog.class);
        return systemLog.description();
    }

    private String getMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getName();
    }


    /**
     * 异常通知 记录操作报错日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "systemLogAspectCtrl()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

        OperateLogInfo operateLogInfo = LOG_THREAD_LOCAL.get();

        operateLogInfo.setLogType("error");
        operateLogInfo.setVisitMethodErrorInfo(e.getMessage());

        taskExecutor.execute(new UpdateLogThread(operateLogInfo, operateLogInfoService));

        LOG_THREAD_LOCAL.remove();
    }

    /**
     * 保存日志线程
     */
    private static class SaveLogThread implements Runnable {

        private OperateLogInfo operateLogInfo;
        private IOperateLogInfoService operateLogInfoService;


        public SaveLogThread(OperateLogInfo operateLogInfo, IOperateLogInfoService operateLogInfoService) {
            this.operateLogInfo = operateLogInfo;
            this.operateLogInfoService = operateLogInfoService;
        }

        @Override
        public void run() {
            operateLogInfoService.insertOperateLog(operateLogInfo);
        }
    }

    /**
     * 更新日志线程
     */
    private static class UpdateLogThread extends Thread {

        private OperateLogInfo operateLogInfo;
        private IOperateLogInfoService operateLogInfoService;

        public UpdateLogThread(OperateLogInfo operateLogInfo, IOperateLogInfoService operateLogInfoService) {
            super(UpdateLogThread.class.getSimpleName());
            this.operateLogInfo = operateLogInfo;
            this.operateLogInfoService = operateLogInfoService;
        }

        @Override
        public void run() {
            operateLogInfoService.updateOperateLog(operateLogInfo);
        }
    }


}
