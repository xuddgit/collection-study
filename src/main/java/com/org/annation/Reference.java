/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:15
 *desc:{}
 **/


package com.org.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:xudd
 * @date:2020/1/3 -14:15
 * @desc:
 **/
@Target( ElementType.TYPE)
@Retention( RetentionPolicy.RUNTIME)
@interface Reference{
    boolean next() default false;
}

