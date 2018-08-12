package com._2dland.consumer.feign;

import com._2dland.consumer.hystrix.HelloServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hello-service", fallback = HelloServiceHystrix.class)
public interface HelloService {
    @RequestMapping("/hello")
    String hello(@RequestParam String name);
}
