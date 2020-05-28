/*
 *company:jlc
 *author:xudd
 *date:2020/5/28:19:17
 *desc:{}
 **/


package com.org.link;

/**
 * @author:xudd
 * @date:2020/5/28 -19:17
 * @desc:
 **/
public class Link {
    /**data item(key)*/
    public int iData;
    /**data item*/
    public double dData;
    /**next link in list*/
    public Link next;

    public Link(int id,double dd){

        iData=id;

        dData=dd;
    }


    public void displayLink(){

        System.out.println("{"+iData+"}"+dData);

    }

}
