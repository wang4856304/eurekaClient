package com.wj.controller.intf;

import org.springframework.web.bind.annotation.RequestMapping;

public interface TestService {

    @RequestMapping(value = "/hello/test")
    String test();
}
