package com.example.springboot1.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HelloServiceImplTest {

    private HelloServiceImpl helloServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        helloServiceImplUnderTest = new HelloServiceImpl();
    }

    @Test
    void testCompletableFuture() throws InterruptedException {
        assertThat(helloServiceImplUnderTest.completableFuture()).isEqualTo("result");
    }
}
