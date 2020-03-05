package com.zhuopeng.desigh_model.behavior.Pub_Sub;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 12:24 2020/2/15 0015
 */
public interface ISubcriber {
    void subcribe(Broker broker);
    void unSubcribe(Broker broker);
    void update(String publisher,Message message);
}
