package ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ribbon.service.TestService;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/4
 * Time: 11:31
 * Copyright:拓道金服 Copyright (c) 2017
 */
@RestController
public class TestControlelr {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage() {
        return testService.getMessage();
    }
}
