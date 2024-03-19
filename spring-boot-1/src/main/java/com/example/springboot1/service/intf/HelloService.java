package com.example.springboot1.service.intf;

/***
 * @Author wjw
 * @Description test
 * @Date 2023/11/9 06:42
 */
public interface HelloService {
    /**
     * @return java.lang.String
     * @Author wjw
     * @Description CompletableFuture实现异步
     * @Date 2023/11/9 07:45
     * @Param
     */
    String completableFuture() throws InterruptedException;

    /***
     * @Author wjw
     * @Description java8 test
     * @Date 2023/11/14 07:11
     * @Param
     * @return java.lang.String
     */
    String getJava8();
}
