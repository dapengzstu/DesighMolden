package com.zhuopeng.desigh_model.behavior.chain_of_responsibility;

/**
 * @Author:Dapeng
 * @Discription:
 * @Date:Created in 下午 19:12 2020/2/19 0019
 */
public class Leave implements ILeave {
    private String name;
    private int num;
    private String content;

    public Leave(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getNum() {
        return this.num;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
