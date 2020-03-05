package com.zhuopeng.desigh_model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 22:44 2020/3/4 0004
 */
public class Solution {
    public static void main(String[] args) {
        Thread[] t = new Thread[3];
        Test tes = Test.getInstance();
        for (int i = 0; i < 3; ++i) {
            t[i] = new Thread(tes);
        }

        for (int i = 0; i < 3; ++i) {
            t[i].start();
        }
    }
}
class Test implements Runnable {
    static int a = 0;
    private Test(){}
    private static final Test instance =  new Test();
    public static Test getInstance() {
        return instance;
    }
    @Override
    public void run() {

            ++a;
            System.out.println(a);

    }
}
