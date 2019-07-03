package com.wj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wj.controller.intf.TestRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRemoteController {

    @Autowired
    private TestRemoteService testRemoteService;

    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "fallback")
    public Object test() {
        return testRemoteService.back();
    }

    public Object fallback(Throwable throwable) {
        return "error";
    }
}
