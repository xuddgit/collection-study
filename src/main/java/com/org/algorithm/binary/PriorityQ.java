/*
 *company:jlc
 *author:xudd
 *date:2020/5/27:19:56
 *desc:{}
 **/


package com.org.algorithm.binary;

/**
 * @author:xudd
 * @date:2020/5/27 -19:56
 * @desc:
 **/
public class PriorityQ {

    private int maxSize;

    private long[] queArray;

    private int nItems;

    public PriorityQ(int s){

        maxSize=s;
        queArray=new long[maxSize];
        nItems=0;
    }

    public void insert(long item){
        int j;
        if(nItems==0){
            /**if no items insert at 0*/
            queArray[nItems]=item;

        }else{
            /**start at end*/
            for(j=nItems-1;j>=0;j--){
                if(item>queArray[j]){
                    queArray[j+1]=queArray[j];

                }else{

                    break;
                }

            }
            queArray[j+1]=item;
            nItems++;

        }


    }

    /**remove minimum item*/
    public long remove(){
        return queArray[--nItems];

    }

    /**peek at minimum item*/
    public long peekMin(){
        return queArray[nItems-1];

    }

    public boolean isEmpty(){

        return (nItems==0);
    }

    public boolean isFull(){

        return (nItems==maxSize);

    }

}
