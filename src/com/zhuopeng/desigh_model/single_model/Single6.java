package com.zhuopeng.desigh_model.single_model;

public class Single6 {
    //设置一个静态的flag，当类加载的时候这个flag就被创建了
    private static boolean flag = false;
    private static Single6 single6 = new Single6();
    private Single6(){
        if (!flag){
            flag = true;
        }else{
            throw new RuntimeException("单例被破坏");
        }
    }
    public Single6 getInstance(){
        return single6;
    }

}
