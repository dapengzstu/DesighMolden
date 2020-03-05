package com.zhuopeng.desigh_model.Structural.proxy.JDKDynamic;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 22:41 2020/2/12 0012
 */
public class SubjectImpl implements Subject {
    @Override
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public String sayGoodBye() {
        System.out.println("goodbye");
        return "goodbye";
    }
}
