package com._2dland.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hello-service")
public interface HelloService {
    @RequestMapping("/hello")
    String hello(@RequestParam String name);
}
