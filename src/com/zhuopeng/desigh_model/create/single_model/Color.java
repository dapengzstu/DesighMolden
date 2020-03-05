package com.zhuopeng.desigh_model.create.single_model;


/*
*   枚举的练习
* */
public enum Color {

    INSTANCE,RED;   //RED("红色",1),GREEN("绿色",2),BLACK("黑色",3); 如果枚举后面有参数，需要构造函数是一个带参数的
    private String name;
    private int id;
    private String c;
    //枚举被设计成了单例模式

    private Color() {
        name = "name";
        id = 1;
        c = "hahhaa";
    }

    public String getC() {
        return c;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
