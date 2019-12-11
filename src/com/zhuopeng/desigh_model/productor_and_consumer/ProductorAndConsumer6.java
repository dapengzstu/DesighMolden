package com.zhuopeng.desigh_model.productor_and_consumer;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

/*
*   使用管道来做盘子PipedInputStream和PipOutputStream
*   将input 和output连个管道连接，然后就是一个生产者，消费者了
* */
public class ProductorAndConsumer6 {
    private Random random = new Random();
    final PipedOutputStream pipedOutputStream = new PipedOutputStream();
    final PipedInputStream pipedInputStream = new PipedInputStream(20);
    {
        //将两个管道进行连接
        try {
            pipedInputStream.connect(pipedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        *   第二种连接方法
        *   直接在创建管道的时候连接，并且设置容量
        *   PipedInputStream(PipedOutputStream src, int pipeSize)
        * */
    }


    public static void main(String[] args) {
        ProductorAndConsumer6 productorAndConsumer6 = new ProductorAndConsumer6();
        new Thread(productorAndConsumer6.new Productor()).start();
        new Thread(productorAndConsumer6.new Concumer()).start();
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
                    pipedOutputStream.write(random.nextInt(10));
                    pipedOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    class Concumer implements Runnable{

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(new Random().nextInt(10) * 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    int num ;
                    while ( (num = pipedInputStream.read()) != -1){
                        System.out.println("read from pipedinputstream:" + num);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
