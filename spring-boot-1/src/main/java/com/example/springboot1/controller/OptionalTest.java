package com.example.springboot1.controller;

import com.alibaba.fastjson2.JSON;
import com.example.springboot1.vo.StaffPublicVO;
import com.example.springboot1.vo.StaffVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description Optional 类的使用
 * @Author wjw
 * @Date 2023/11/14 07:27
 */
@Slf4j
public class OptionalTest {
    @Test
    public void test1() {
        //empty():创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        //Optional封装的数据是否包含数据, boolean isPresent()：判断是否包含对象
        if (!op1.isPresent()) {
            System.out.println("数据为空");
        }
        log.info("------op1:{},op1.isPresent():{}", op1, op1.isPresent());
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value.
        System.out.println(op1.get());
    }

    @Test
    public void test2() {
        //String str = null;
        String str = "hello";
        //of(T t):封装数据t生成Optional对象。要求t非空，否则报错。
        Optional<String> op1 = Optional.of(str);
        //get()通常与of()方法搭配使用。用于获取内部的封装的数据value
        String str1 = op1.get();
        System.out.println(str1);
    }

    @Test
    public void test3() {
        //String str = "Beijing";
        String str = null;
        //ofNullable(T t) ：封装数据t赋给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t1):如果Optional内部的value非空，则返回此value值。如果value为空，则返回t1
        String str2 = op1.orElse("shanghai");
        log.info("-----str2:{}------", JSON.toJSONString(str2));
    }

    @Test
    public void listMap() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        //Before Java8
        List<String> listUpper = new ArrayList<>();
        for (String s : list) {
            listUpper.add(s.toUpperCase());
        }
        //[a, b, c, d]
        System.out.println(list);
        //[A, B, C, D]
        System.out.println(listUpper);
        // Java 8
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        //[A, B, C, D]
        System.out.println(collect);
        // Extra, streams apply to any data type.
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        //[2, 4, 6, 8, 10]
        System.out.println(collect1);
    }

    @Test
    public void listMap1() {
        List<StaffVO> staffVOS = Arrays.asList(new StaffVO("mkYong", 30, new BigDecimal(10000)), new StaffVO("jack", 27, new BigDecimal(20000)), new StaffVO("lawrence", 33, new BigDecimal(30000)));
        //Before Java 8
        List<String> result = new ArrayList<>();
        for (StaffVO x : staffVOS) {
            result.add(x.getName());
        }
        //[mkYong, jack, lawrence]
        log.info("result:{}", JSON.toJSONString(result));
        //Java 8
        List<String> collect = staffVOS.stream().map(StaffVO::getName).collect(Collectors.toList());
        //[mkYong, jack, lawrence]
        log.info("collect:{}", JSON.toJSONString(collect));
    }

    @Test
    public void listMap2() {
        List<StaffVO> staffVOS = Arrays.asList(new StaffVO("mkYong", 30, new BigDecimal(10000)), new StaffVO("jack", 27, new BigDecimal(20000)), new StaffVO("lawrence", 33, new BigDecimal(30000)));
        // convert inside the map() method directly.
        List<StaffPublicVO> result = staffVOS.stream().map(i -> {
            //StaffPublicVO 创建的VO
            StaffPublicVO obj = new StaffPublicVO();
            obj.setName(i.getName());
            obj.setAge(i.getAge());
            String s = "mkYong";
            if (s.equals(i.getName())) {
                obj.setExtra("this field is for mkYong only!");
            }
            return obj;
        }).collect(Collectors.toList());
        log.info("------result:{}------", JSON.toJSONString(result));
    }

    @Test
    public void listMap3() {
        List<StaffVO> staffVOS = Arrays.asList(new StaffVO("mkYong", 30, new BigDecimal(10000)), new StaffVO("jack", 27, new BigDecimal(20000)), new StaffVO("lawrence", 33, new BigDecimal(30000)));
        List<StaffPublicVO> result = convertToStaffPublic(staffVOS);
        System.out.println(result);
    }

    private List<StaffPublicVO> convertToStaffPublic(List<StaffVO> staffVOS) {
        List<StaffPublicVO> result = new ArrayList<>();
        for (StaffVO temp : staffVOS) {
            StaffPublicVO obj = new StaffPublicVO();
            obj.setName(temp.getName());
            obj.setAge(temp.getAge());
            if ("mkYong".equals(temp.getName())) {
                obj.setExtra("this field is for mkYong only!");
            }
            result.add(obj);
        }
        return result;
    }

    /***
     * @Author wjw
     * @Description LocalDate的用法
     * @Date 2024/3/13 06:49
     * @Param
     */
    @Test
    public void testDate() {
        //格式化
        DateTimeFormatter fmDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //当天
        LocalDate today = LocalDate.now();
        //格式化后的时间
        String day = today.format(fmDate);
        log.info("-----today:{}-----", day);
        //加12天
        LocalDate t2 = today.plusDays(12);
        log.info("-----t2:{}-----", t2.format(fmDate));
        // 获取当前日期
        LocalDate now = LocalDate.now();
        // 设置日期
        LocalDate now2 = LocalDate.of(2099, 2, 28);
        // 解析日期，格式必须是yyyy-MM-dd
        LocalDate now3 = LocalDate.parse("2028-01-12");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatRs = now.format(dtf);
        // 取本月第一天
        LocalDate firstDay = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstDay2 = now.withDayOfMonth(1);
        // 取本月第2天
        LocalDate secondDay = now.withDayOfMonth(2);
        LocalDate nextMonthDay = now.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate nextYearDay = now.with(TemporalAdjusters.firstDayOfNextYear());
        // 明年的这一天
        LocalDate localDate = now.plusYears(1);
        // 当前日期加上往后推20天
        LocalDate plusDate = now.plus(20, ChronoUnit.DAYS);
        LocalDate plusYear = now.plus(10, ChronoUnit.YEARS);
        // 当前日期往前推10天
        LocalDate minusDay = now.minusDays(10);
        LocalDate minusYear = now.minus(10, ChronoUnit.YEARS);
        //localDate转Date
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = now.atStartOfDay(zoneId);
        Instant instant = zdt.toInstant();
        log.info("------instant:{}------", instant);
        //Date转LocalDate
        Date date = new Date();
        Instant instantToUse = date.toInstant();
        ZoneId zoneIdToUse = ZoneId.systemDefault();
        LocalDate localDateToShow = instantToUse.atZone(zoneIdToUse).toLocalDate();
        // 比较日期大小
        boolean b1 = localDateToShow.equals(LocalDate.of(2028, 04, 27));
        boolean b2 = localDateToShow.equals(LocalDate.of(2028, 04, 26));
        // 判断日期前后  -> false
        //false
        boolean b3 = localDateToShow.isAfter(LocalDate.of(2028, 04, 26));
        //true
        boolean b4 = localDateToShow.isAfter(LocalDate.of(2028, 04, 25));
        //false
        boolean b5 = localDateToShow.isBefore(LocalDate.of(2028, 04, 26));
        //false
        boolean b6 = localDateToShow.isBefore(LocalDate.of(2028, 04, 25));
        //true
        boolean b7 = localDateToShow.isBefore(LocalDate.of(2028, 04, 27));
        // 计算两个日期之间的时间间隔   格式为：x年x月x天
        Period between = Period.between(localDateToShow, LocalDate.of(2028, 05, 28));
        long bwDays = ChronoUnit.DAYS.between(localDateToShow, LocalDate.of(2028, 05, 28));
    }
}
