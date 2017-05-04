package ribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 18:14
 * Copyright:拓道金服 Copyright (c) 2017
 */
@FeignClient(value = "PROVIDER-A")
public interface TestService {

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage();
}
