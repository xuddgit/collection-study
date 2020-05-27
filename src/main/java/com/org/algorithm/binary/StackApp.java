/*
 *company:jlc
 *author:xudd
 *date:2020/5/27:12:54
 *desc:{}
 **/


package com.org.algorithm.binary;

/**
 * @author:xudd
 * @date:2020/5/27 -12:54
 * @desc:
 **/
public class StackApp {

    public static void main(String[] args) {

        /**make new stack*/
        StackX theStack = new StackX(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        while(!theStack.isEmpty()){

            long value = theStack.pop();
            System.out.println(""+value);
        }

    }
}
