/*
 *company:jlc
 *author:xudd
 *date:2019/12/11:17:32
 *desc:{}
 **/


package com.org.classs.dependency;

/**
 * @author:xudd
 * @date:2019/12/11 -17:32
 * @desc:
 **/
public class Chicken {
    private Egg e ;
    private int age ;
    public Chicken(){
        e = new Egg();
        setAge(10) ;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
