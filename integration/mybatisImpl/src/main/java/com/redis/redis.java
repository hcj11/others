package com.redis;

import com.Service.Cache.RedisCacheService;
import com.redis.redisTemplate.HashUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by hcj on 18-7-25
 */
@Configuration
public class redis {
  @Bean
  public RedisConnectionFactory factory(){
    JedisConnectionFactory factory = new JedisConnectionFactory();
    factory.setDatabase(7);
    return factory;
  }


  @Bean("redisTemplate")
  public RedisTemplate<String,Object> redisTemplate(){
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new JdkSerializationRedisSerializer());
    return template;
  }

  @Bean("redisTemplateX")
  public RedisTemplate<String,Object> redisTemplateX(){
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new JdkSerializationRedisSerializer());
    return template;
  }
  @Bean("redisTemplateY")
  public RedisTemplate<String,Object> redisTemplateY(){
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
    return template;
  }
  @Bean("redisTemplateYZ")
  public RedisTemplate<String,Object> redisTemplateYZ(){
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new JdkSerializationRedisSerializer());
    template.setHashValueSerializer(new JdkSerializationRedisSerializer());
    return template;
  }


  @Bean("redisTemplateZ")
  public RedisTemplate<String,Object> redisTemplateZ(){
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(factory());
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new StringRedisSerializer());
    return template;
  }
}
