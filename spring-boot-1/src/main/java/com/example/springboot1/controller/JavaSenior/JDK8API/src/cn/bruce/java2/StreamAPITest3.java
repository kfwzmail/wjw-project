package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java2;

import com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1.Employee;
import com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description 测试Stream的终止操作
 * @Author wjw
 * @Date 2024/3/24 23:58
 */
public class StreamAPITest3 {
    /**
     * @Description 1-匹配与查找
     * @Author wjw
     * @Date 2024/3/24 23:58
     */
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)——检查是否匹配所有元素。
        //练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //anyMatch(Predicate p)——检查是否至少匹配一个元素。
        //练习：是否存在员工的工资大于 5000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println(anyMatch);

        //noneMatch(Predicate p)——检查是否没有匹配的元素。
        //练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAny——返回当前流中的任意元素
        Optional<Employee> employee = employees.parallelStream().findAny();
        System.out.println(employee);
    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        // count——返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary()>5000).count();
        System.out.println(count);

        //max(Comparator c)——返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compareTo);
        System.out.println(maxSalary);

        //min(Comparator c)——返回流中最小值
        //练习：返回最低工资的员工
        Optional<Double> minSalary = employees.stream().map(e -> e.getSalary()).min(Double::compareTo);
        System.out.println(minSalary);

        //forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
        System.out.println();

        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    /**
     * @Description 2-归约
     * @Author wjw
     * @Date 2024/3/25 00:04
     */
    @Test
    public void test3(){
        //reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sumSalary = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(sumSalary);
    }

    /**
     * @Description 3-收集
     * @Author wjw
     * @Date 2024/3/25 00:04
     */
    @Test
    public void test4(){
        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println("--------------------");

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
}
