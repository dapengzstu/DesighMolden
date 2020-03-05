package com.zhuopeng.desigh_model.create.factory.f2;

public class TriangleFactory implements Facotry {
    @Override
    public Shape getShape() {
        return new Triangle();
    }
}
