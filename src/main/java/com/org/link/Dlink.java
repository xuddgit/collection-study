/*
 *company:jlc
 *author:xudd
 *date:2020/5/28:19:48
 *desc:{}
 **/


package com.org.link;

/**
 * @author:xudd
 * @date:2020/5/28 -19:48
 * @desc:
 **/
public class Dlink {

    public long dData;

    public Dlink next;

    public Dlink(long d){

        dData=d;
    }

    public void displayLink(){

        System.out.println(dData+"");

    }
}
