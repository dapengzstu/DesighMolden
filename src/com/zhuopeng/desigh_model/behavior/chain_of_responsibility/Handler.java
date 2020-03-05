package com.zhuopeng.desigh_model.behavior.chain_of_responsibility;

import java.util.logging.Level;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 19:14 2020/2/19 0019
 */
public abstract class Handler {
    protected final static int ONE = 1;
    protected final static int THREE = 3;
    protected final static int SEVEN = 7;

    //领导请假的权限区间
    private int start = 0;
    private int end = 0;
    //领导的领导
    private Handler nextHandler;

    public Handler(int start){
        this.start = start;
    }
    public Handler(int start,int end){
        this.start = start;
        this.end = end;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final void submit(ILeave leave){
        if (this.start == 0){
            return;
        }
        if (leave.getNum() >= start){
            this.handleLeave(leave);
            if (this.nextHandler != null && leave.getNum() > end){
                this.nextHandler.submit(leave);
            }
        }

    }

    protected abstract void handleLeave(ILeave leave);
}
