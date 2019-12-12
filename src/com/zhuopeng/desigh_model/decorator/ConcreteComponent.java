package com.zhuopeng.desigh_model.decorator;

public class ConcreteComponent implements Component{

    @Override
    public void doSomeThing() {
        System.out.println("ConcureteComponet");
    }
}
