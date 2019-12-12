package com.zhuopeng.desigh_model.single_model;

import java.io.Serializable;

public class Single6 implements Serializable {
    //设置一个静态的flag，当类加载的时候这个flag就被创建了
    private static boolean flag = false;
    private static Single6 single6 = new Single6();
    private Single6(){
        //当上面那个静态变量new的时候flag就会改变，以后通过反射再次创建的时候，就不能创建了
        if (!flag){
            flag = true;
        }else{
            throw new RuntimeException("单例被破坏");
        }
    }
    public static Single6 getInstance(){
        return single6;
    }
    //用于序列化与反序列化的时候，可能会创建出不同的单例
    private Object readResolve(){
        return single6;
    }

}
