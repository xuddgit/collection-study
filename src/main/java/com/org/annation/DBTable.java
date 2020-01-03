/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:42
 *desc:{}
 **/


package com.org.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:xudd
 * @date:2020/1/3 -14:42
 * @desc:
 **/
@Target( ElementType.TYPE)
//只能应用于类上
@Retention( RetentionPolicy.RUNTIME)
//保存到运行时
public @interface DBTable {
    String name() default "";
}
