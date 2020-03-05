package com.zhuopeng.desigh_model.behavior.Pub_Sub;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 12:23 2020/2/15 0015
 */
public  abstract class Broker<Message> {
    public String brokerName;
    private CopyOnWriteArrayList<ISubcriber> array = new CopyOnWriteArrayList<ISubcriber>();
    

}
