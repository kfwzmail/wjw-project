package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author wjw
 * @Description 函数式接口:java内置的4大核心函数式接口
 * 消费型接口 Consumer<T>     void accept(T t)
 * 供给型接口 Supplier<T>     T get()
 * 函数型接口 Function<T,R>   R apply(T t)
 * 断定型接口 Predicate<T>    boolean test(T t)
 * @Date 2024/3/24 01:05
 */
public class LambdaTest3 {
    /**
     * @Author wjw
     * @Description 消费型接口 Consumer<T> void accept(T t)
     * @Date 2024/3/24 02:19
     */
    @Test
    public void test1() {
        //未使用Lambda表达式
        Learn("java", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("学习什么？ " + s);
            }
        });
        System.out.println("====================");

        //使用Lambda表达
        Learn("html", s -> System.out.println("学习什么？ " + s));
    }

    private void Learn(String s, Consumer<String> stringConsumer) {
        stringConsumer.accept(s);
    }

    /**
     * @Author wjw
     * @Description 供给型接口:返回类型为T的对象 Supplier<T> T get()
     * @Date 2024/3/24 02:00
     */
    @Test
    public void test2() {
        //未使用Lambda表达式
        Supplier<String> sp = new Supplier<String>() {
            @Override
            public String get() {
                return new String("我能提供东西ƒ");
            }
        };
        System.out.println(sp.get());
        System.out.println("====================");
        //使用Lambda表达
        Supplier<String> sp1 = () -> new String("我能通过lambda提供东西");
        System.out.println(sp1.get());
    }

    @Test
    public void test3() {
        //未使用Lambda表达
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStr = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStr);
        System.out.println("====================");

        //使用Lambda表达
        List<String> filterStr1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStr1);

    }

    /**
     * @param list
     * @param pre
     * @return List<String>
     * @Author wjw
     * @Description 根据p给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
     * @Date 2024/3/24 01:59
     */
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
