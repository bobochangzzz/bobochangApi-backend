package com.bobochang.clientsdk;

import com.bobochang.clientsdk.client.BobochangApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: bobochang
 * @description: API接口客户端配置类
 * @date: 2022/11/10 05:02
 */
@Configuration
@ConfigurationProperties(prefix = "bobochang.client")
@ComponentScan
@Data
public class bobochangApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public BobochangApiClient bobochangApiClient() {
        return new BobochangApiClient(accessKey, secretKey);
    }
}
