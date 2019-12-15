package com.zhuopeng.desigh_model.factory.f3;

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
