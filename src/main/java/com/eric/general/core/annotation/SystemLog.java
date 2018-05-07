package com.eric.general.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述:
 * 系统日志注解 用于记录操作日志
 *
 * @author eric
 * @create 2018-05-07 下午4:03
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    /**
     * 描述业务操作功能
     *
     * @return
     */
    String description() default "";
}
