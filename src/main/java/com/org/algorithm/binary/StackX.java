/*
 *company:jlc
 *author:xudd
 *date:2020/5/27:12:01
 *desc:{}
 **/


package com.org.algorithm.binary;

/**
 * @author:xudd
 * @date:2020/5/27 -12:01
 * @desc:
 **/
public class StackX {

    /***size of stack array*/
    private int maxSize;

    private long[] stackArray;
    /**top of stack*/
    private int top;

    public StackX(int s){

        maxSize=s;
        stackArray= new long[s];
        top=-1;

    }

    /**put item on top of stack*/
    public void push(long j){
        /**increment top ,insert item*/
        stackArray[++top]=j;
    }


    public long pop(){
        /***tak itme form top of stack*/
        /**access item ,decrement top*/
        return stackArray[top--];

    }
    /**peek at top of stack*/
    public long peek(){
       return stackArray[top];

    }
    /**true if stack is empty*/
    public boolean isEmpty(){

        return (top==-1);
    }
    /**true if stack is full*/
    public boolean isFull(){

        return top==maxSize-1;

    }

}
