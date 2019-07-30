package com.wj.controller;

import com.alibaba.fastjson.JSONObject;
import com.wj.controller.intf.TestService;
import com.wj.exception.BusinessException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value = "/hello/test", method = RequestMethod.GET)
    public String test(String name, String sex) {
        //throw  new BusinessException("111111111111111111");
        System.out.println("name=" + name);
        System.out.println("sex=" + sex);
        return "success";
    }

    @RequestMapping(value = "/hi/test", method = RequestMethod.GET)
    public String hiTest(String name) {
        //throw  new BusinessException("111111111111111111");
        System.out.println("name=" + name);
        return "success";
    }

    @RequestMapping(value = "/hi/{name}", method = RequestMethod.POST)
    public String restTest(@PathVariable("name") String name) {
        //throw  new BusinessException("111111111111111111");
        System.out.println("name=" + name);
        return "success";
    }

    @RequestMapping(value = "/hi/tgy/{name}", method = RequestMethod.POST)
    public String restUrlTest(@PathVariable("name") String name) {
        //throw  new BusinessException("111111111111111111");
        System.out.println("name=" + name);
        return "success";
    }

    public Object postReq(@RequestBody JSONObject jsonObject) {
        return jsonObject;
    }

    /*
    @Override
    public String back() {
        throw  new BusinessException("111111111111111111");
    }*/

    //@Override

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public Object postTest(@RequestBody Map<String, Object> map) {
        //System.out.println(map);
        return map;
    }
}
