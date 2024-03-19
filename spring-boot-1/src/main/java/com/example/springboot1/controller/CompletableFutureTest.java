package com.example.springboot1.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

/**
 * @Description CompletableFuture学习
 * @Author wjw
 * @Date 2024/3/12 07:15
 */
@Slf4j
public class CompletableFutureTest {
    @Test
    public void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println("-----hello!-----"));
        future.get();// 输出 "hello!"
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "hello!");
        assertEquals("hello!", future2.get());
    }
}
