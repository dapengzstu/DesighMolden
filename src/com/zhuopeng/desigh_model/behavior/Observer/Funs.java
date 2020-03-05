package com.zhuopeng.desigh_model.behavior.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 上午 11:16 2020/2/15 0015
 */
public class Funs implements Observer {
    private String name;
    public Funs(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Idol){
            Idol idol = (Idol) o;
            System.out.println(idol.getBall());
        }
    }
}
