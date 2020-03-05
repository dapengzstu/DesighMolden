package com.zhuopeng.desigh_model.behavior.Pub_Sub;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 12:28 2020/2/15 0015
 */
public class StringMessage implements Message {
    private String message;
    public StringMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
