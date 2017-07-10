package provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:57
 */
@RestController
public class TestCComtroller {

    private static final Logger log = LoggerFactory.getLogger(TestCComtroller.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage() {
        Long s = System.currentTimeMillis();
        String m = restTemplate.getForEntity("http://PROVIDER-D/getMessage", String.class).getBody();
        Long e = System.currentTimeMillis();
        log.info("provider-C : startTime = {},endTime={},expend = {}", s, e, e - s);
        return m;
    }
}
