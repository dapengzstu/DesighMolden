package com.zhuopeng.desigh_model.factory.f3;

public class AndroidFactory implements Factory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public UIController createUIController() {
        return new AndroidUIController();
    }
}
