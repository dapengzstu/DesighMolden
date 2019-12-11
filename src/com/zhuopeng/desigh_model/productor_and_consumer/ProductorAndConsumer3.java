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
public class ProductorAndConsumer3 {

    private BlockingQueue b2;
    private Random random;
    public ProductorAndConsumer3(){
        b2 = new PriorityBlockingQueue<Pro>(10);
        random = new Random();
    }

    public static void main(String[] args) {
        ProductorAndConsumer3 m = new ProductorAndConsumer3();
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
                    Thread.sleep(random.nextInt(10) * 800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Pro p = new Pro(random.nextInt(100),String.valueOf(random.nextInt(100)));
                    b2.put(p);
                    System.out.println(Thread.currentThread().getId() + ",放入一个" + p.getName() + "，总数：" + b2.size());
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
                    Pro p = (Pro)b2.take();
                    System.out.println(Thread.currentThread().getId() + ",拿走一个" + p.getName() + "，还剩：" + b2.size());
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
