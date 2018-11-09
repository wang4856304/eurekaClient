package com.wj.controller;

import com.wj.controller.intf.TestService;
import com.wj.exception.BusinessException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestService {
    @Override
    public String test() {
        //throw  new BusinessException("111111111111111111");
        return "success";
    }
}
