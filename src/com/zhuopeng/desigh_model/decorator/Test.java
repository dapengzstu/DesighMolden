package com.zhuopeng.desigh_model.decorator;

public class Test {
    public static void main(String[] args) {
        DecoratorComponent2 decoratorComponent2 = new DecoratorComponent2(new DecoratorComponent1(new ConcreteComponent()));
        decoratorComponent2.doSomeThing();
    }
}
