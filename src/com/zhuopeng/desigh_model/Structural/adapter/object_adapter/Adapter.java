package com.zhuopeng.desigh_model.Structural.adapter.object_adapter;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 21:46 2020/2/12 0012
 */
public class Adapter implements Target {
    Adaptee a = new Adaptee();
    @Override
    public void request() {
        a.requestAdaptee();
    }
}
