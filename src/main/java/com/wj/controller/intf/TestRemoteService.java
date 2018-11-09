package com.wj.controller.intf;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("test-eureka-service")
public interface TestRemoteService extends TestService {
}
