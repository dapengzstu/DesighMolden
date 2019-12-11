package com.zhuopeng.desigh_model.productor_and_consumer;

import java.util.Random;
/**
*   生产者消费者模式，使用wait（）和notify（）实现
 *   注意点：
 *   1. wait（）以前需要获取对应的锁，wait（） 的时候就释放掉这个锁，进入锁的等待队列中
 *   2. wait（）需要放在一个while循环里面，这样线程醒来的时候还要再次检查条件，如果放在if里面，醒来就直接count++了
* */
public class ProductorAndConsumer1 {
    private static volatile int count = 5;
    private static String LOCK = "LOCK";
    private static int FULL = 10;
    private static int EMPTY = 0;
    public static void main(String[] args) {
        ProductorAndConsumer1 m = new ProductorAndConsumer1();
        for (int i = 0 ;i <3 ; i ++){
            new Thread(m.new Productor()).start();
            new Thread(m.new Consumer()).start();
            new Thread(m.new Consumer()).start();
        }
    }
    class Productor implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(new Random().nextInt(10) * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count ++;
                    System.out.println("创造一个，总数：" + count);
                    LOCK.notifyAll();
                }
            }

        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(new Random().nextInt(10) * 300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){

                    while (count == EMPTY){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count --;
                    System.out.println("拿走一个，还剩：" + count);
                    LOCK.notifyAll();
                }

            }

        }
    }
}
