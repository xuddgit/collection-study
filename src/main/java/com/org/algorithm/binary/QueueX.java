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
public class QueueX {


    private int maxSize;
    private long[] queArray;

    private int front;
    /**后方的*/
    private int rear;

    private int nItems;
    /**构造函数*/
    public QueueX(int s){
    maxSize=s;
    queArray= new long[maxSize];

    }
    /**
     * @author: xudd
     * @desc: //TODO
     * @date: 16:13 2020/5/27
     * @param:
     * @return:
     **/
    public void insert(long j){
     /**put item at rear of queue*/

     if(rear==maxSize-1){
       //deal with wraparound
       rear=-1;
       //increment rear and insert
       queArray[++rear]=j;
       //one more item
     nItems++;
     }


    }

    /**take item from front of queue*/
    public long remove(){
        /**get value and incr front*/
        long temp = queArray[front++];
        //deal with wraparound
        if(front==maxSize){
            front=0;
        }
        nItems--;
        //one less item;
        return temp;
    }
    /**peek at front of queue*/
    public long peekFront(){

        return queArray[front];

    }

    /**ture if queue is empty*/
    public boolean isEmpty(){
        return (nItems==0);

    }


   public boolean  isFull(){

        return (nItems==maxSize);

    }

    public int size(){

        return nItems;
    }

    public static void main(String[] args) {

        Queue queue = new ArrayBlockingQueue(5);
    }


}
