package com.example.springboot1.controller.JavaSenior.Generic.src.cn.bruce.exer;

import com.example.springboot1.controller.JavaSenior.Collection.src.cn.bruce.exer1.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/***
 * @Author wjw
 * @Description java8学习
 * @Date 2024/3/23 13:46
 */
public class EmployeeTest {
    /***
     * @Author wjw
     * @Description 问题二：按生日日期的先后排序
     * @Date 2024/3/23 13:44
     * @Param
     */
    @Test
    public void test2() {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee employee1 = (Employee) o1;
                    Employee employee2 = (Employee) o2;
                    MyDate b1 = employee1.getBrithday();
                    MyDate b2 = employee2.getBrithday();
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入的数据类型不一致");
            }
        });
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /***
     * @Author wjw
     * @Description 问题一：使用自然排序
     * @Date 2024/3/23 13:41
     * @Param
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("liudehua", 55, new MyDate(1965, 5, 4));
        Employee e2 = new Employee("zhangxueyou", 43, new MyDate(1987, 5, 4));
        Employee e3 = new Employee("guofucheng", 44, new MyDate(1987, 5, 9));
        Employee e4 = new Employee("liming", 51, new MyDate(1954, 8, 12));
        Employee e5 = new Employee("liangzhaowei", 21, new MyDate(1978, 12, 4));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
