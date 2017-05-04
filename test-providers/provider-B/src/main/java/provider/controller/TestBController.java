package provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:53
 * Copyright:拓道金服 Copyright (c) 2017
 */
@RestController
public class TestBController {

    private static final Logger log = LoggerFactory.getLogger(TestBController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage() {
        Long s = System.currentTimeMillis();
        String m = restTemplate.getForEntity("http://PROVIDER-C/getMessage", String.class).getBody();
        Long e = System.currentTimeMillis();
        log.info("provider-B : startTime = {},endTime={},expend = {}", s, e, e - s);
        return m;
    }
}
