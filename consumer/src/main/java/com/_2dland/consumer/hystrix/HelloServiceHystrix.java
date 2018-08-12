package com._2dland.consumer.hystrix;

import com._2dland.consumer.feign.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String hello(@RequestParam(name = "name") String name) {
        return "hello "+name+",now service is down";
    }
}
