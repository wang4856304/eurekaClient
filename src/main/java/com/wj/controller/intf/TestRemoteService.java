package com.wj.controller.intf;

import com.wj.config.FeignClientConfig;
import com.wj.interceptor.FeignClientInterceptor;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "test-eureka-service", configuration = {FeignClientInterceptor.class, FeignClientConfig.class})
public interface TestRemoteService extends TestService {
}
