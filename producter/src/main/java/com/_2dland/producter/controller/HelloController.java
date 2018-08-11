package com._2dland.producter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        logger.info("收到请求:"+name);
        return "hello  " + name + ",this is a test service";
    }

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
}
