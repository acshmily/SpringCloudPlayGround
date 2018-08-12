package com._2dland.rediscache;

import lombok.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheApplicationTests implements Serializable {

    @Test
    public void contextLoads() {
    }
    @Test
    public void testStringRedisTemplate(){
        stringRedisTemplate.opsForValue().set("aaaa","bbb");
        Assert.assertEquals("bbb",stringRedisTemplate.opsForValue().get("aaaa"));
    }
    @Test
    public void testObjectRedisTemplate() throws Exception{
        UserBean user = new UserBean(1L,"张三",20);
        ValueOperations<String,UserBean> valueOperations = redisTemplate.opsForValue();
        //无过期时间
        valueOperations.set("com._2dland.redis1",user);
        //保持1秒
        valueOperations.set("com._2dland.redis.temp",user,5,TimeUnit.SECONDS);
        //线程等待1秒
        Thread.sleep(5000L);
        //断言
        Assert.assertEquals(user,redisTemplate.opsForValue().get("com._2dland.redis1"));
        Assert.assertEquals(false,redisTemplate.hasKey("com._2dland.redis.temp"));
        System.out.println(redisTemplate.opsForValue().get("com._2dland.redis1"));
    }
    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


}
