package com.bobochang.apiinterface;

import com.bobochang.clientsdk.client.BobochangApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BobochangApiInterfaceApplicationTests {

    @Resource
    private BobochangApiClient bobochangApiClient;

    @Test
    void contextLoads() {
        System.out.println(bobochangApiClient.getNameByGet("bobochang"));
    }

}
