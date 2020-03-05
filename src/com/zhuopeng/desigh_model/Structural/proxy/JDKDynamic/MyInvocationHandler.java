package com.zhuopeng.desigh_model.Structural.proxy.JDKDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 22:51 2020/2/12 0012
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object ob;
    public MyInvocationHandler(Object ob){
        this.ob = ob;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(ob, args);
        System.out.println("after");
        return invoke;
    }
}
