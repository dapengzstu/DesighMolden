package com.zhuopeng.desigh_model.Structural.adapter.class_adapter;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 21:36 2020/2/12 0012
 */

//适配器，
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.requestAdaptee();
    }

}
