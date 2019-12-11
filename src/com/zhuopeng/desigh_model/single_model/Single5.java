package com.zhuopeng.desigh_model.single_model;


public class Single5{
    private Single5(){}
    public Single5 getInstance(){
        return S.INSTANCE.getInstance();
    }
    private enum S{
        INSTANCE;
        private Single5 instance;
        private S(){
            instance = new Single5();
        }
        private Single5 getInstance(){
            return instance;
        }
    }
}
