package com.wj.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author jun.wang
 * @title: TestInterceptor
 * @projectName ownerpro
 * @description: TODO
 * @date 2019/7/12 16:29
 */

@Component
public class TestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("ccccccccccccccccc");
    }
}
