package com.zhuopeng.desigh_model.create.factory.f3.old;

public class IOSFactory implements Factory {
    @Override
    public OperationController createOperationController() {
        return new IOSOperationController();
    }

    @Override
    public UIController createUIController() {
        return new IOSUIController();
    }
}
