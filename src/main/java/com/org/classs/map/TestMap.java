/*
 *company:jlc
 *author:xudd
 *date:2019/12/30:11:24
 *desc:{}
 **/


package com.org.classs.map;

/**
 * @author:xudd
 * @date:2019/12/30 -11:24
 * @desc:
 **/
public class TestMap {


    public static void main(String[] args) {
        int [] table = new int[10];
        int [] old = null;
        int [] newtable = new int[10];
        for(int i=0;i<10;i++){
            table[i]=i;
        }
        old =table;
        table=newtable;



        System.out.println(old[1]);
    }

}
