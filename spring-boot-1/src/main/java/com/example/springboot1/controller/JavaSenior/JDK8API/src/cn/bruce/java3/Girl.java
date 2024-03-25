package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java3;

/**
 * @Description TODO
 * @Author wjw
 * @Date 2024/3/25 21:51
 */
public class Girl {
    private String name;
    public Girl() {
    }
    public Girl(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
