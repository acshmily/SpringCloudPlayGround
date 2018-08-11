package com._2dland.consumer.controller;

import com._2dland.consumer.feign.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloClient {
    @RequestMapping("hello/{name}")
    public String index(@PathVariable(name = "name") String name){
        return helloService.hello(name);
    }
    @Resource
    private HelloService helloService;
}
