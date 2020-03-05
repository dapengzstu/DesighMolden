package com.zhuopeng.desigh_model.Structural.decorator;

public abstract class Decorator implements Component {
    private Component component;
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void doSomeThing() {
        component.doSomeThing();
    }
}
