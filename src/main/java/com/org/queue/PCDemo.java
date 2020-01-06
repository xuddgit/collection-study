/*
 *company:jlc
 *author:xudd
 *date:2020/1/6:11:47
 *desc:{}
 **/


package com.org.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author:xudd
 * @date:2020/1/6 -11:47
 * @desc:
 **/
public class PCDemo {

    private static BlockingQueue<Integer> blockingQueue= new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        Producer producer= new Producer(blockingQueue);
        Consumer consumer= new Consumer(blockingQueue);

        for(int i=0;i<10;i++){
            new Thread(producer).start();
           if(i<5){
               new Thread(consumer).start();

           }
        }



    }


}
