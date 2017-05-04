package provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:51
 * Copyright:拓道金服 Copyright (c) 2017
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PCAPP {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(PCAPP.class, args);
    }
}
