package com.zhuopeng.desigh_model.create.factory.f1;

public class Factory {
    public Shape getShape(String name){
        switch (name){
            case "Circle":
                return  new Circle();
            case "Triangle":
                return new Triangle();
        }
        return null;
    }
}
