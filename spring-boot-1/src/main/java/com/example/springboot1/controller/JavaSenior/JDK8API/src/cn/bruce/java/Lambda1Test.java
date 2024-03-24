package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java;

import org.junit.Test;

import java.util.Comparator;

/***
 * @Author wjw
 * @Description 使用Lambda表达式前后对比
 * @Date 2024/3/14 07:13
 */
public class Lambda1Test {
    /***
     * @Author wjw
     * @Description 调用 Runnable 接口
     * @Date 2024/3/23 19:28
     * @Param
     */
    @Test
    public void test1() {
        //未使用Lambda表达式的写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lambda!");
            }
        };
        r1.run();
        System.out.println("========================");

        //Lambda表达式写法
        Runnable r2 = () -> System.out.println("hi Lambda!");
        r2.run();
    }

    @Test
    public void test2() {
        //未使用Lambda表达式的写法
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 32);
        //结果：-1
        System.out.println(compare1);
        System.out.println("===================");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(54, 21);
        //结果：1
        System.out.println(compare2);
        System.out.println("===================");

        //方法引用
        Comparator<Integer> cpm3 = Integer::compareTo;
        int compare3 = cpm3.compare(12, 12);
        //结果：0
        System.out.println(compare3);
    }
}
