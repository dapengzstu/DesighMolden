package com.zhuopeng.desigh_model.decorator;

public class DecoratorComponent1 extends Decorator {

    public DecoratorComponent1(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        System.out.println("DecoratorCOmponent1");
        super.doSomeThing();
    }
}
