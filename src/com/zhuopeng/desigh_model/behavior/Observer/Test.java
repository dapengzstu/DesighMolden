package com.zhuopeng.desigh_model.behavior.Observer;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 上午 11:31 2020/2/15 0015
 */
public class Test {
    public static void main(String[] args) {
        Funs f1 = new Funs("zp");
        Funs f2 = new Funs("zb");
        Idol idol = new Idol("cc");
        idol.addObserver(f1);
        idol.addObserver(f2);
        idol.mychange("zuqiu");
    }
}
