package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的使用
 * Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t)：t可以为null
 *
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java3
 * @create 2020-05-08 10:05
 */
public class OptionalTest {
    @Test
    public void test1() {
        //empty():创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        //Optional封装的数据是否包含数据
        if (!op1.isPresent()) {
            System.out.println("数据为空");
        }
        System.out.println(op1);
        System.out.println(op1.isPresent());

        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value.
        System.out.println(op1.get());
    }

    @Test
    public void test2() {
        String str = "hello";
        //str = null;
        //of(T t):封装数据t生成Optional对象。要求t非空，否则报错。
        Optional<String> op1 = Optional.of(str);
        //get()通常与of()方法搭配使用。用于获取内部的封装的数据value
        String str1 = op1.get();
        System.out.println(str1);
    }

    @Test
    public void test3() {
        String str = "Beijing";
        str = null;
        //ofNullable(T t) ：封装数据t赋给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);
        System.out.println(op1);
        //orElse(T t1):如果Optional内部的value非空，则返回此value值。如果
        //value为空，则返回t1.
        String str2 = op1.orElse("shanghai");
        System.out.println(str2);
    }
}
