package com.zhuopeng.desigh_model.create.single_model;

/*
*   一个有问题的单例模式
* */
public class Single1 {
    private Single1(){}
    private Single1 s = null;

    public Single1 getSingle1(){
        //这样子写有问题
        if (s == null){
            //如果两个程序同时走到这里，就会返回两个实例
            return new Single1();
        }else{
            return s;
        }
    }
}
