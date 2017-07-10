package provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author: mif
 * Date: 2017/5/3
 * Time: 17:58
 */
@RestController
public class TestDController {

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public String getMessage() {
        return "this is from provider-D";
    }
}
