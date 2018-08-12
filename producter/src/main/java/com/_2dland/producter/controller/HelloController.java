package com._2dland.producter.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController
public class HelloController {
    @ApiOperation(value = "hello服务",notes = "根据传入name返回一个信息",httpMethod = "GET")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name",dataType = "String",required = true,value = "用户名",paramType = "query")
    )
    @RequestMapping("/hello")
    public String index(@RequestParam String name){
        logger.info("收到请求:"+name);
        return "hello  " + name + ",this is a test service";
    }

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
}
