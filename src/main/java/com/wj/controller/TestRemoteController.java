package com.wj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wj.controller.intf.TestRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestRemoteController {

    @Autowired
    private TestRemoteService testRemoteService;

    @RequestMapping("/h/test")
    //@HystrixCommand(fallbackMethod = "fallback")
    public Object test(String name, String sex) {
        return testRemoteService.test(name, sex);
    }

    @RequestMapping("/hii/test")
    //@HystrixCommand(fallbackMethod = "fallback")
    public Object hiTest(String name) {
        return testRemoteService.hiTest(name);
    }

    @RequestMapping("/rest/{name}")
    //@HystrixCommand(fallbackMethod = "fallback")
    public Object restTest(@PathVariable("name") String name) {
        return testRemoteService.restUrlTest("/hi/tgy/" ,name);
    }

    public Object fallback(Throwable throwable) {
        return "error";
    }

    @PostMapping("/post")
    public Object postTest(@RequestBody Map<String, Object> map) {
        testRemoteService.postTest(map);
        return "success";
    }
}
