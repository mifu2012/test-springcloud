package ribbon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import ribbon.service.TestService;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 18:13
 * Copyright:拓道金服 Copyright (c) 2017
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApp {

    private static final Logger log = LoggerFactory.getLogger(FeignApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FeignApp.class, args);
        log.info("message is {}", run.getBean(TestService.class).getMessage());
    }
}
