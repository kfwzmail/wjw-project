package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java3;

/**
 * @Description TODO
 * @Author wjw
 * @Date 2024/3/25 21:51
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" + "girl=" + girl + '}';
    }
}
