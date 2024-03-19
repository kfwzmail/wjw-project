package com.example.springboot1.service.impl;

import com.alibaba.fastjson2.JSON;
import com.example.springboot1.service.intf.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * @Description
 * @Author wjw
 * @Date 2023/11/9 06:36
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String completableFuture() throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        Thread.sleep(500);
        list.add("a");
        log.info("----主线程:{}-----", "Thread.sleep(500);");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(200);
                list.add("b");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add("c");
            return JSON.toJSONString("------Hello, world!--------");
        });
        future.thenAccept(e -> System.out.println(e));
        log.info("-----future:{}------", JSON.toJSONString(future));
        list.add("d");
        log.info("list:{}",JSON.toJSONString(list));
        return JSON.toJSONString(future);
    }

    /***
     * @Author wjw
     * @Description java8 test
     * @Date 2023/11/14 07:11
     * @Param
     * @return java.lang.String
     */
    @Override
    public String getJava8() {
        return null;
    }
}