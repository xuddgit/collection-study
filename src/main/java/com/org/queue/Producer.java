/*
 *company:jlc
 *author:xudd
 *date:2020/1/6:11:47
 *desc:{}
 **/


package com.org.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author:xudd
 * @date:2020/1/6 -11:47
 * @desc:
 **/
public class Producer implements Runnable{
    private   BlockingQueue<Integer> blockingQueue;
    private   Random random = new Random();

  public   Producer( BlockingQueue<Integer> blockingQueue){

        this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
      for(;;){

          try {
              int temp=random.nextInt();
              blockingQueue.put(temp);
              System.out.println("生产者放入阻塞队列数据"+temp+"队列的当前长度是"+blockingQueue.size());
          } catch (InterruptedException e) {
              e.printStackTrace();
          }

      }
    }
}
