package com.zhuopeng.desigh_model.single_model;

import java.io.*;

/*
*   部分单例模式在序列化和反序列化后会产生多个实例，除非单例类中重写了readResolve（） 方法
* */
public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Single6 single6 = Single6.getInstance();

        FileOutputStream fileOutputStream = new FileOutputStream("o");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(single6);
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("o");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Single6 s1 = (Single6)objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        //结果显示是一个实例,因为Single6中重写了 readResolve（）方法，如果没有重写的话，就是两个不同的实例了
        System.out.println(single6);
        System.out.println(s1);


    }
}
