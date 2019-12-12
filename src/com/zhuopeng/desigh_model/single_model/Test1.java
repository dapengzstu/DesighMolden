package com.zhuopeng.desigh_model.single_model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
*   除了枚举构造的单例模式，其他方法构造的单例模式都可以通过反射来进行破解
*
* */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //破解使用静态变量构造的单例模式
        Constructor cos = Single2.class.getDeclaredConstructor();
        //取消访问检查功能
        cos.setAccessible(true);
        Single2 s1 = (Single2) cos.newInstance();
        Single2 s2 = (Single2) cos.newInstance();

        //生成了四个实例
        System.out.println(s1);
        System.out.println(s1.getSingle2());
        System.out.println(s2);
        System.out.println(s2.getSingle2());

        //下面是升级版本的，防止破坏的单例模式
        Constructor constructor = Single6.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        //抛出异常，因为Single6的内部静态类已经new出一个实例了
        Single6 s6 = (Single6)constructor.newInstance();
        System.out.println("s6"+ s6);



    }
}
