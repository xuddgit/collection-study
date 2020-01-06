/*
 *company:jlc
 *author:xudd
 *date:2020/1/6:11:47
 *desc:{}
 **/


package com.org.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author:xudd
 * @date:2020/1/6 -11:47
 * @desc:
 **/
public class Consumer implements Runnable{
    private   ArrayBlockingQueue<Integer> blockingQueue;

    public Consumer(ArrayBlockingQueue<Integer> blockingQueue){
        this.blockingQueue=blockingQueue;

    }


    @Override
    public void run() {
        for(;;){
            try {
             int rest=   blockingQueue.take();

             System.out.println("消费者获取结果集"+rest+"当前队列的长度是"+blockingQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
