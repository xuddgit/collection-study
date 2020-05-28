/*
 *company:jlc
 *author:xudd
 *date:2020/5/27:17:30
 *desc:{}
 **/


package com.org.algorithm.binary;

import com.sun.org.apache.regexp.internal.REUtil;

/**
 * @author:xudd
 * @date:2020/5/27 -17:30
 * @desc:
 **/
public class QueueS {


    private int maxSize;

    private long[] queArray;

    private int front;

    private int rear;

    public QueueS(int s){
        maxSize=s+1;
        queArray=new long[maxSize];
        front=0;
        rear=-1;
    }

    /**put item at rear of queue*/
    public void insert(long j){

        if(rear==maxSize-1){
            rear=-1;


        }
         queArray[++rear]=j;
    }

   /**take item from front of queue*/
   public long remove(){
        long temp = queArray[front++];
        if(front==maxSize){
            front=0;
        }
        return temp;
   }

  /**peek at front of queue*/
   public long peek(){
       return queArray[front];
   }
    /**true if queue is empty*/
   public boolean isEmpty(){
       return (rear+1==front)||(front+maxSize-1==rear);

   }

 public boolean isFull(){
     return (rear+2==front ||(front+maxSize-2==rear))  ;


 }


 public int size(){

       if(rear>=front){
           //assumes queue not empty

           return rear-front+1;
       }else{

           return (maxSize-front)+(rear+1);
       }

 }
}
