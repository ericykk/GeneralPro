package com.eric.general.core.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 描述:
 * 基于经典代理模式实现aop
 *
 * @author eric
 * @create 2018-05-14 上午11:24
 */
public class SystemLogHelper implements MethodBeforeAdvice, AfterReturningAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行方法" + method.getName() + "前执行逻辑！");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("方法" + method.getName() + "返回后执行逻辑！");
    }
}
