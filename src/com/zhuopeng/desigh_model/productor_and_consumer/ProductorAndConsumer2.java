package com.zhuopeng.desigh_model.productor_and_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
*   使用阻塞队列的生产者消费者模式
 *   需要注意：
 *   1. blockingQueue 有多种实现类方式
 *      a.  ArrayBlockingQueue
 *      b.  LinkedBlockingQueue
 *      c.  PriorityBlockingQueue   队列是一个有序的队列，使用这个必须实现Comparable接口,比较结果越大越靠后
 *      d.  SynChronousQueue        队列容量只有1
 *      e.  DelayQueue
 *   2. blockingQueue 在插入和获取的时候也有四种不同的方式
 *      a.  抛异，如果不能插入或者获取，就直接抛出异常   add() remove()
 *      b.  阻塞, put() take()
 *      c.  特定值，不能，就返回False offer() poll()
 *      d.  超时，如果不能，就阻塞，如果阻塞一定时间还是不行，就返回一个特定值 offer(time) poll(time)
* */
public class ProductorAndConsumer2 {

    private static BlockingQueue blockingQueue;
    private static BlockingQueue b2;
    public ProductorAndConsumer2(){
        blockingQueue = new LinkedBlockingQueue<String>(10);
        b2 = new PriorityBlockingQueue<Pro>();
    }

    public static void main(String[] args) {
        ProductorAndConsumer2 m = new ProductorAndConsumer2();
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
                    Thread.sleep(new Random().nextInt(10) * 800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put("#");
                    System.out.println(Thread.currentThread().getId() + ",放入一个，总数：" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                    String t = (String) blockingQueue.take();
                    System.out.println(Thread.currentThread().getId() + ",拿走一个，还剩：" + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Pro implements Comparable<Pro>{
        private int id;
        private String name;
        public Pro(int id,String name){
            this.id = id ;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Pro o) {
            return o.getName().compareTo(this.name);
        }
    }
}
