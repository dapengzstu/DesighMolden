package com.zhuopeng.desigh_model.behavior.Pub_Sub;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 12:22 2020/2/15 0015
 */
public interface IPublisher {
    public boolean publish(Broker b,Message m, boolean isInstant);
}
