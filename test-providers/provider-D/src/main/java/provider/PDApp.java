package provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:52
 * Copyright:拓道金服 Copyright (c) 2017
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PDApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(PDApp.class).run(args);
    }
}
