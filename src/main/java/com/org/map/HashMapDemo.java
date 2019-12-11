/*
 *company:jlc
 *author:xudd
 *date:2019/12/10:16:01
 *desc:{}
 **/


package com.org.map;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author:xudd
 * @date:2019/12/10 -16:01
 * @desc:
 **/
public class HashMapDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap();
                                map.put("1",2);
                                map.put("a",3);


       int result= tableSizeFor(8);
       System.out.println(result);
       System.out.println(1 << 30);
       String id=null;
       if(Objects.isNull(id)||id.length()>10){
          System.out.println("||短路了");
       }
       Integer hashCode=map.hashCode();
       System.out.println(hashCode);
       System.out.println(hashCode>>>16);
       System.out.println(hashCode^hashCode>>>16);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        if(n<0){
            return 1;
        }else{
            if(n>=MAXIMUM_CAPACITY){

                return MAXIMUM_CAPACITY;
            }else {
                return n + 1;
            }
        }
    }




}
