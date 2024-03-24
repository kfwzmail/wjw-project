package com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java2;

import com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1.Employee;
import com.example.springboot1.controller.JavaSenior.JDK8API.src.cn.bruce.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 * @Author wjw
 * @Description 测试Stream的实例化
 * Stream 关注的是对数据的运算，与 CPU 打交道;集合关注的是数据的存储，与内存打交道;
 * Java 8 提供了一套 api ，使用这套 api 可以对内存中的数据进行过滤、排序、映射、归约等操作。类似于 sql 对数据库中表的相关操作。
 * Stream 是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据， Stream讲的是计算！”
 * @Date 2024/3/24 23:29
 */
public class StreamAPITest1 {
    /**
     * @Author wjw
     * @Description 创建 Stream方式一：通过集合
     * @Date 2024/3/24 23:30
     */
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    /**
     * @Author wjw
     * @Description 创建 Stream方式二：通过数组
     * @Date 2024/3/24 23:31
     */
    @Test
    public void test2() {
        int[] arrs = {1, 2, 3, 6, 2};
        //调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arrs);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] employees = {e1, e2};
        Stream<Employee> stream1 = Arrays.stream(employees);
    }

    /**
     * @Author wjw
     * @Description 创建 Stream方式三：通过Stream的of()
     * @Date 2024/3/24 23:33
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(12, 34, 45, 65, 76);
    }

    /**
     * @Author wjw
     * @Description 创建 Stream方式四：创建无限流
     * @Date 2024/3/24 23:34
     */
    @Test
    public void test4() {
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
