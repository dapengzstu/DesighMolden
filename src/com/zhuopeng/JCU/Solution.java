package com.zhuopeng.JCU;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 17:27 2020/3/5 0005
 */
public class Solution {

    static class Dog1 implements Runnable {
        private int c = 0;
        private MyLOCK mutex;

        public Dog1(MyLOCK mutex) {
            this.mutex = mutex;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    while (mutex.count != 1) {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("a");
                    mutex.count = 2;
                    c++;
                    if (c == 3) {
                        break;
                    }
                    mutex.notifyAll();

                }
            }
        }
    }

    static class Dog2 implements Runnable {
        private int c = 0;
        private MyLOCK mutex;

        public Dog2(MyLOCK mutex) {
            this.mutex = mutex;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    while (mutex.count != 2) {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("b");
                    mutex.count = 3;
                    c++;
                    if (c == 3) {
                        break;
                    }
                    mutex.notifyAll();

                }
            }
        }
    }

    static class Dog3 implements Runnable {
        private int c = 0;
        private MyLOCK mutex;

        public Dog3(MyLOCK mutex) {
            this.mutex = mutex;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mutex) {
                    while (mutex.count != 3) {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("c");
                    mutex.count = 1;
                    c++;
                    if (c == 3) {
                        break;
                    }
                    mutex.notifyAll();

                }
            }
        }
    }

    static class MyLOCK {
        public int count;
    }

    public static void main(String[] args) throws InterruptedException {
        MyLOCK lock = new MyLOCK();
        lock.count = 1;
        new Thread(new Dog1(lock)).start();
        new Thread(new Dog2(lock)).start();
        new Thread(new Dog3(lock)).start();


    }
}
