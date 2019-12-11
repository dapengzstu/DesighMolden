package com.zhuopeng.desigh_model.productor_and_consumer;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*   使用ReentrantLock来实现的一个阻塞队列
*   特点：
*   1.  递归锁可重入锁，同一个线程，如果外层的函数获得锁，内层函数同样可以获得锁，
*   2.  锁的计数器，每次获得锁都要计数器+1，释放锁的次数和加锁的次数一样才能完全释放锁
*   3.  一个线程获得锁之后，别的线程不能获得锁
*
* */
public class ProductorAndConsumer4 {
    private static final  int FULL = 10;
    private static final int Empty = 0;
    private int count = 5;
    private Lock reentrantLock;
    private Condition notFull;
    private Condition notEmpty;
    public ProductorAndConsumer4(){
        reentrantLock = new ReentrantLock();
        notEmpty = reentrantLock.newCondition();
        notFull = reentrantLock.newCondition();
    }

    public static void main(String[] args) {
        ProductorAndConsumer4 m = new ProductorAndConsumer4();
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
                reentrantLock.lock();
                while(count == FULL){
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count ++;
                System.out.println(Thread.currentThread().getName() +"放入一个，总数：" + count);
                reentrantLock.unlock();
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
                reentrantLock.lock();
                while(count == Empty){
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count --;
                System.out.println(Thread.currentThread().getName() +"拿走一个，还剩：" + count);
                reentrantLock.unlock();
            }
        }
    }
}
