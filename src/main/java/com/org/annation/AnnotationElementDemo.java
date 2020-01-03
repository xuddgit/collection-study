/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:16
 *desc:{}
 **/


package com.org.annation;

/**
 * @author:xudd
 * @date:2020/1/3 -14:16
 * @desc:
 **/
public @interface AnnotationElementDemo {
    //枚举类型
    enum Status {FIXED,NORMAL};

    //声明枚举
    Status status() default Status.FIXED;

    //布尔类型
    boolean showSupport() default false;

    //String类型
    String name()default "";

    //class类型
    Class<?> testCase() default Void.class;

    //注解嵌套
    Reference reference() default @Reference(next=true);

    //数组类型
    long[] value();
}

