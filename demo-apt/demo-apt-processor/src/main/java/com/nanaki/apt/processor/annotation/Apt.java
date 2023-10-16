package com.nanaki.apt.processor.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/26
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface Apt {

    String version() default "";

    String value() default "";

    boolean flag() default false;

}
