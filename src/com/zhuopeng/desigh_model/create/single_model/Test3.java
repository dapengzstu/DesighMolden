package com.zhuopeng.desigh_model.create.single_model;

public class Test3 {
    public static void main(String[] args) {
        Single5 s = Single5.INSTANCE;
        s.setName("zhuopeng");
        s.setId(1);
        System.out.println(s);
        Single5 ss = Single5.INSTANCE;
        ss.setName("zzz");

        System.out.println(s);
        System.out.println(ss);
    }
}
