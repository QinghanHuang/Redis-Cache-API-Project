package com.clement.rediscacheapiproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RedisCacheApiProjectApplicationTests {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //value的类型数

    //String 普通字符串             opsForValue()
    //list    列表                 opsForList()
    //set     集合                 opsForSett()
    //zset   有序集合               opsForZSet
    //hash value 是另一层map        opsForHash()

    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("clement","1234567");
        stringRedisTemplate.opsForList().rightPush("qqq","1");
        stringRedisTemplate.opsForList().rightPush("qqq","2");
        stringRedisTemplate.opsForList().rightPush("qqq","3");
        stringRedisTemplate.opsForList().rightPush("qqq","4");
        stringRedisTemplate.opsForSet().add("www","q");
        stringRedisTemplate.opsForSet().add("www","q");
    }
    @Test
    public void zsetTest(){
        stringRedisTemplate.opsForZSet().add("www","qweqwe",1);
        stringRedisTemplate.opsForZSet().add("www","qwfghfe",2);
        stringRedisTemplate.opsForZSet().add("www","fghqwe",3);

    }
    @Test
    public void hashTest(){
        stringRedisTemplate.opsForHash().put("rrrr","qqq","123asd1");
        stringRedisTemplate.opsForHash().put("rrrr","123","12asd31");
        stringRedisTemplate.opsForHash().put("rrrr","434","12asd31");
        stringRedisTemplate.opsForHash().put("rrrr","444","12asd31");

    }
    @Test
    public void outputTest(){
        System.out.println(stringRedisTemplate.opsForHash().get("rrrr", "123"));
    }

}
