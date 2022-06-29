package com.send.sms.sendsms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class RedisListCache {
    private RedisTemplate<String , Object> redisTemplate;

    private ListOperations<String , Object> listOperations;

    public RedisListCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
    }
    @EventListener(ApplicationReadyEvent.class)
    public void setUp(){
        listOperations.leftPush("name" , "mugisha pacifique software developer");
        System.out.println("here is the key : " + listOperations.rightPop("name"));
        System.out.println("testing if the message is invoked");
    }
}
