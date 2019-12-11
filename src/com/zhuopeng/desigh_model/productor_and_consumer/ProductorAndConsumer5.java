package com.zhuopeng.desigh_model.productor_and_consumer;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*   使用信号量 Semaphore
*   使用一个互斥的信号量操作count的加减
*   使用notFull 和 notEmpty 表示盘子中的产品
*   notFull + notEmpty = N （最多容量）
*
* */
public class ProductorAndConsumer5 {
    private int count = 0;
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);
    public ProductorAndConsumer5(){

    }

    public static void main(String[] args) {
        ProductorAndConsumer5 m = new ProductorAndConsumer5();
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
                try {
                    //如果不满，获取信号量一个
                    notFull.acquire();
                    //互斥信号量
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName() +"放入一个，总数：" + count);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(new Random().nextInt(10) * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName() +"拿走一个，还剩：" + count);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}
