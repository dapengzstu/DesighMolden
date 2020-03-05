package com.zhuopeng.desigh_model.behavior.Observer;

import java.util.Observable;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 上午 11:17 2020/2/15 0015
 */
public class Idol extends Observable{
    private String name;
    private String ball;
    public Idol(String name){
        this.name = name;
        this.ball = "bb";
    }
    public void mychange(String changBall){
        this.ball = changBall;
        super.setChanged();
        super.notifyObservers();
    }
    public String getBall(){
        return this.ball;
    }
}
