package com.zhuopeng.desigh_model.single_model;


import java.io.Serializable;

public enum  Single5 implements Serializable {
    INSTANCE;
    int id;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name +","+id;
    }
}
