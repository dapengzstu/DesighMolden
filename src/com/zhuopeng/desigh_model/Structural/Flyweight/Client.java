package com.zhuopeng.desigh_model.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 18:48 2020/2/29 0029
 */
public class Client {
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        IFlyWeight xxx = flyWeightFactory.getFlyWeight("xxx");

        IFlyWeight xxx2 = flyWeightFactory.getFlyWeight("xxx");
        //xxx 和 xxx2 共享了“xxx" 这个字符串
        xxx.operation("yyy");
    }

    //抽象享元角色
    interface IFlyWeight{
        void operation(String extrinsicState);
    }
    //具体享元角色
    static class ConcreteFlyWeight implements IFlyWeight{
        //内部那个不变的
        String intrinsicState;
        public ConcreteFlyWeight(String intrinsicState){
            this.intrinsicState = intrinsicState;
        }
        @Override   //传入一个可变的
        public void operation(String extrinsicState) {
            System.out.println("extrinsic State is " + extrinsicState);
        }
    }
    //工厂，常量池，连接池
    static class FlyWeightFactory {
        Map<String,IFlyWeight> pool = new HashMap<String,IFlyWeight>();
        public IFlyWeight getFlyWeight(String intrinsicState){
            //要一个内部不变的是xxx的东西
            if (!pool.containsKey(intrinsicState)){
                pool.put(intrinsicState,new ConcreteFlyWeight(intrinsicState));
            }
            return pool.get(intrinsicState);
        }
    }
}
