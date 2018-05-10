package com.eric.general.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 描述: 采用XML方式实现aop日志管理
 *
 * @author eric
 * @create 2018-05-10 下午3:36
 */
public class XmlLogAdvice {
    /**
     * 在核心业务逻辑之前执行 不能阻止核心业务逻辑的执行
     *
     * @param joinPoint
     */
    private void doBefore(JoinPoint joinPoint) {
        System.out.println("Start invoke doBefore method");
        System.out.println("end of doBefore method");
    }

    /**
     * 手动控制调用核心业务逻辑，在调用前和调用后做处理
     * 注意：
     * 当核心业务抛异常后，立即退出，转向After Advice，执行完毕After Advice，再转到Throwing Advice
     *
     * @throws Throwable
     */
    private Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Start invoke doAround method");
        Object returnObj = proceedingJoinPoint.proceed();
        System.out.println("end of doAround method");
        return returnObj;
    }

    /**
     * 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
     *
     * @param joinPoint
     */
    private void doAfter(JoinPoint joinPoint) {
        System.out.println("Start invoke doAfter method");
        System.out.println("end of doAfter method");
    }

    /**
     * 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     *
     * @param joinPoint
     */
    private void doReturn(JoinPoint joinPoint) {
        System.out.println("Start invoke doReturn method");
        System.out.println("end of doReturn method");
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     *
     * @param joinPoint
     * @param ex
     */
    private void doThrowing(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Start invoke doThrowing method");
        System.out.println("exception message:" + ex.getMessage());
        System.out.println("end of doThrowing method");
    }
}
