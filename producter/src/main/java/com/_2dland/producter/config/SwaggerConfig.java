package com._2dland.producter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 对外暴露接口描述
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com._2dland.producter.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    //创建版权声明
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("hello-service")
                .description("spring cloud swagger")
                .license("github.com/acshmily")
                .build();
    }
}
