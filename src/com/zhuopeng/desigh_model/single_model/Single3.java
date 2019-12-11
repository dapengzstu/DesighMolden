package com.zhuopeng.desigh_model.single_model;

/*
 *   一个懒汉，双重检查模式，推荐
 *   这个例子，对第一个错误的事例进行了改进。如果不使用双重检查模式，每次调用getInstance（）都直接进入同步代码块的话，性能不好
 *   注意：
 *       instance 使用了volatile修饰
 *   原因：代码的重排序，在进行 new Single3（）的 时候，需要执行以下的三个步骤
 *   memory=allocate(); //1：分配内存空间
 *   ctorInstance();   //2:初始化对象
 *   singleton=memory; //3:设置singleton指向刚排序的内存空间
 *   如果 2 和 3进行 了重排序， 1-3-2的顺序，如果线程A执行了3，这个时候线程B判断if（instance == null）结果为False，直接返回instance，
 *   就会返回一个没后初始化的instance
 * */
public class Single3 {
    private Single3() {
    }

    private static volatile Single3 instance;

    public Single3 getInstance() {
        if (instance == null) {
            synchronized (Single3.class) {
                if (instance == null) {
                    instance = new Single3();
                }
            }
        }
        return instance;
    }
}
