package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author wjw
 * @Description 方法引用的使用
 * 使用格式：类(或对象) :: 方法名
 * @Date 2024/3/24 22:08
 */
public class MethodRefTest1 {
    /**
     * @Author wjw
     * @Description 情况一：对象 :: 实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     * @Date 2024/3/24 22:08
     */
    @Test
    public void test1() {
        //使用Lambda表达
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("中国");
        System.out.println("====================");

        //使用方法引用
        PrintStream ps = System.out;
        Consumer con2 = ps::println;
        con2.accept("China");
    }

    /**
     * @Author wjw
     * @Description Supplier中的T get()
     * Employee中的String getName()
     * @Date 2024/3/24 22:59
     */
    @Test
    public void test2() {
        //使用Lambda表达
        Employee emp = new Employee(1001, "Bruce", 34, 600);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());
        System.out.println("====================");

        //使用方法引用
        Supplier sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    /**
     * @Author wjw
     * @Description 情况二：类 :: 静态方法
     * Comparator中的int compare(T t1,T t2)
     * Integer中的int compare(T t1,T t2)
     * @Date 2024/3/24 23:00
     */
    @Test
    public void test3() {
        //使用Lambda表达
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(32, 45));
        System.out.println("====================");

        //使用方法引用
        Comparator<Integer> com2 = Integer::compareTo;
        System.out.println(com2.compare(43, 34));
    }

    /**
     * @Author wjw
     * @Description Function中的R apply(T t)
     * Math中的Long round(Double d)
     * @Date 2024/3/24 23:02
     */
    @Test
    public void test4() {
        //使用匿名内部类
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(func.apply(10.5));
        System.out.println("====================");

        //使用Lambda表达式
        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("====================");

        //使用方法引用
        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }

    /**
     * @Author wjw
     * @Description 情况三：类 :: 实例方法
     * Comparator中的int comapre(T t1,T t2)
     * String中的int t1.compareTo(t2)
     * @Date 2024/3/24 23:03
     */
    @Test
    public void test5() {
        //使用Lambda表达式
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abd", "aba"));
        System.out.println("====================");

        //使用方法引用
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "abc"));
    }

    /**
     * @Author wjw
     * @Description BiPredicate中的boolean test(T t1, T t2)
     * String中的boolean t1.equals(t2)
     * @Date 2024/3/24 23:04
     */
    @Test
    public void test6() {
        //使用Lambda表达式
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));
        System.out.println("====================");

        //使用方法引用
        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("abc", "abd"));

    }

    /**
     * @Author wjw
     * @Description Function中的R apply(T t)
     * Employee中的String getName();
     * @Date 2024/3/24 23:05
     */
    @Test
    public void test7() {
        //使用Lambda表达式
        Employee employee = new Employee(1001, "Tom", 45, 10000);
        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));
        System.out.println("====================");

        //使用方法引用
        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));
    }
}
