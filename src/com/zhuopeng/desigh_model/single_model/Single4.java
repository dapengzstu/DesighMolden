package com.zhuopeng.desigh_model.single_model;
/*
*   懒汉模式，在调用getInstance（） 的时候才初始化一个实例，推荐
*   外部的静态变量，静态代码块在加载类的时候就运行了
*   但是内部的静态类，在外部调用的时候才开始执行静态变量，静态代码块
* */
public class Single4 {
    private Single4(){}
    public Single4 getInstance(){
        return Inner.s;
    }
    private static class Inner{
        private static final Single4 s = new Single4();
    }
}
