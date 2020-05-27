/*
 *company:jlc
 *author:xudd
 *date:2020/5/27:15:28
 *desc:{}
 **/


package com.org.algorithm.binary;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author:xudd
 * @date:2020/5/27 -15:28
 * @desc:
 **/
public class QueueX<E> {


    private int maxSize;
    private Object[] queArray;

    private int front;
    /**后方的*/
    private int rear;

    private int nItems;
    /**构造函数*/
    public QueueX(int s){
    maxSize=s;
    queArray= new Object[maxSize];

    }

    public static void main(String[] args) {
        Queue queue = new ArrayBlockingQueue(5);
    }


}
