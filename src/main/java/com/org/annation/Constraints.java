/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:45
 *desc:{}
 **/


package com.org.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:xudd
 * @date:2020/1/3 -14:45
 * @desc:
 **/
@Target( ElementType.FIELD)//只能应用在字段上
@Retention( RetentionPolicy.RUNTIME)
public @interface Constraints {
    //判断是否作为主键约束
    boolean primaryKey() default false;
    //判断是否允许为null
    boolean allowNull() default false;
    //判断是否唯一
    boolean unique() default false;
}
