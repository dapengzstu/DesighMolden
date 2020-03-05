package com.zhuopeng.desigh_model.Structural.proxy.JDKDynamic;


import java.lang.reflect.Proxy;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 22:53 2020/2/12 0012
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        MyInvocationHandler handler = new MyInvocationHandler(subject);
        Subject s = (Subject)Proxy.newProxyInstance(Main.class.getClassLoader(),
                subject.getClass().getInterfaces(), handler);


        s.sayGoodBye();

    }
}
