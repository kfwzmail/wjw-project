package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author wjw
 * @Description 构造器和数组的引用
 * 使用格式：
 * 方法引用：类名 ::new
 * 数组引用：数组类型 [] :: new
 * @Date 2024/3/24 23:07
 */
public class ConstructorRefTest2 {
    /**
     * @Author wjw
     * @Description 构造器引用
     * Supplier中的T get()
     * @Date 2024/3/24 23:10
     */
    @Test
    public void test1() {
        //使用匿名内部类
        Supplier<Employee> sup = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());
        System.out.println("====================");

        //使用Lambda表达式
        Supplier<Employee> sup1 = () -> new Employee(1001, "Tom", 43, 13333);
        System.out.println(sup1.get());

        //使用方法引用
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    /**
     * @Author wjw
     * @Description Function中的R apply(T t)
     * @Date 2024/3/24 23:14
     */
    @Test
    public void test2() {
        //使用Lambda表达式
        Function<Integer, Employee> func1 = id -> new Employee(id);
        Employee employee = func1.apply(1001);
        System.out.println(employee);
        System.out.println("====================");

        //使用方法引用
        Function<Integer, Employee> func2 = Employee::new;
        Employee employee1 = func2.apply(1002);
        System.out.println(employee1);
    }

    /**
     * @Author wjw
     * @Description BiFunction中的R apply(T t,U u)
     * @Date 2024/3/24 23:14
     */
    @Test
    public void test3() {
        //使用Lambda表达式
        BiFunction<Integer, String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(1001, "Tom"));
        System.out.println("====================");

        //使用方法引用
        BiFunction<Integer, String, Employee> func2 = Employee::new;
        System.out.println(func2.apply(1002, "Jarry"));
    }

    /**
     * @Author wjw
     * @Description 数组引用
     * Function中的R apply(T t)
     * @Date 2024/3/24 23:15
     */
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));
        System.out.println("====================");

        //使用方法引用
        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}
