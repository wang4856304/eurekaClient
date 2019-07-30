package com.wj.controller.intf;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface TestService {

    @RequestMapping(value = "/hello/test", method = RequestMethod.GET)
    String test(@RequestParam("name") String name, @RequestParam("sex") String sex);

    @RequestMapping(value = "/hi/test", method = RequestMethod.GET)
    String hiTest(@RequestParam("name") String name);

    @RequestMapping(value = "/hi/{name}", method = RequestMethod.POST)
    String restTest(@PathVariable("name") String name);

    @RequestMapping(value = "/{url}/{name}", method = RequestMethod.POST)
    String restUrlTest(@PathVariable("url") String url, @PathVariable("name") String name);

    @RequestMapping("/back")
    String back();

    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    Map<String, Object> postTest(@RequestBody Map<String, Object> map);
}
