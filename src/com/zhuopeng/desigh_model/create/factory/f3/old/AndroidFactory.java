package com.zhuopeng.desigh_model.create.factory.f3.old;

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
