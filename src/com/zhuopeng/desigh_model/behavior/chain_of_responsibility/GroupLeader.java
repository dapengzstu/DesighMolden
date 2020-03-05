package com.zhuopeng.desigh_model.behavior.chain_of_responsibility;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 19:15 2020/2/19 0019
 */
public class GroupLeader extends Handler {

    public GroupLeader(int start, int end) {
        super(start, end);
    }

    @Override
    protected void handleLeave(ILeave leave) {
        System.out.println("Groupleader agree");
    }
}
