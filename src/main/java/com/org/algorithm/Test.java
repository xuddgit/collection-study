/*
 *company:jlc
 *author:xudd
 *date:2020/10/27:16:37
 *desc:{}
 **/


package com.org.algorithm;

import java.util.Random;

/**
 * @author:xudd
 * @date:2020/10/27 -16:37
 * @desc:
 **/
public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        for(int i=0;i<1000;i++){

            int ran1 = r.nextInt(9);
            System.out.println(ran1);

        }

    }
}
