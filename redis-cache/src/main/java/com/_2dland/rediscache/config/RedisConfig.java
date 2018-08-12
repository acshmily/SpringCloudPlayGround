package com._2dland.rediscache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


/**
 * 开启Redis缓存
 */
@Configurable
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    /**
     * 构造redis中的key方法生成器
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (o, method, objects) -> {
            StringBuffer sb = new StringBuffer();
            sb.append(o.getClass().getName());//获取目标类的类对象的类名
            sb.append(method.getName()); //获取类的类对象里的方法名
            for (Object obj : objects){
                sb.append(obj.toString());
            }
            return sb;
        };
    }

    /**
     * 构造redisTemplate
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String,String> redisTemplate(LettuceConnectionFactory factory){
       StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(factory); // 创建StringRedisTemplate
       Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
       ObjectMapper om = new ObjectMapper();
       om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
       om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
       jackson2JsonRedisSerializer.setObjectMapper(om);
       stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
       stringRedisTemplate.afterPropertiesSet();
       return stringRedisTemplate;
    }

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory factory) {
       RedisCacheManager redisCacheManager = RedisCacheManager.create(factory);


       return redisCacheManager;
    }

}
