package com.zhuopeng.desigh_model.behavior.chain_of_responsibility;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 21:20 2020/2/19 0019
 */
public class Test {
    public static void main(String[] args) {
        ILeave leave = new Leave("zhuopeng",9,"cc");
        Handler bigManager = new BigManager(7,15);
        Handler manager = new Manager(3,7);
        Handler groupleader = new GroupLeader(1,3);
        groupleader.setNextHandler(manager);
        manager.setNextHandler(bigManager);

        groupleader.submit(leave);
    }
}
