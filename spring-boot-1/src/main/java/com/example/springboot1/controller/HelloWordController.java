package com.example.springboot1.controller;

import com.example.springboot1.service.intf.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wjw
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloWordController {
    @Autowired
    HelloService helloService;

    /**
     * @return java.lang.String
     * @Author wjw
     * @Description
     * @Date 2023/11/8 07:50 @Param
     */
    @PostMapping("/getJava8")
    public String getHello() {
        return helloService.getJava8();
    }

    @PostMapping("/completableFuture")
    public String completableFuture() throws InterruptedException {
        return helloService.completableFuture();
    }
}
