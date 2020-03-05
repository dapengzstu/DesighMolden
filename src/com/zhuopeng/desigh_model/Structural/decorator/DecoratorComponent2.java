package com.zhuopeng.desigh_model.Structural.decorator;

public class DecoratorComponent2 extends Decorator {
    public DecoratorComponent2(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        System.out.println("DecoratorComponent2");
        super.doSomeThing();
    }
}
