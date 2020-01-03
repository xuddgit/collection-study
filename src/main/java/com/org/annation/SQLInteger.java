/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:43
 *desc:{}
 **/


package com.org.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:xudd
 * @date:2020/1/3 -14:43
 * @desc:
 **/
@Target( ElementType.FIELD)
@Retention( RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    //该字段对应数据库表列名
    String name() default "";
    //嵌套注解
    Constraints constraint() default @Constraints;
}

