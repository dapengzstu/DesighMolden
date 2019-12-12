package com.zhuopeng.desigh_model.single_model;

import java.io.Serializable;

/*
*   一个饿汉，安全的单例模式，推荐
* */
public class Single2 implements Serializable {
    private static Single2 s = new Single2();
    private Single2(){}
    public static Single2 getSingle2(){
        return s;
    }
}
