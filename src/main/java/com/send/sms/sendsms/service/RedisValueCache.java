package com.send.sms.sendsms.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisValueCache {
    private final ValueOperations<String , Object> valueOps;

    public RedisValueCache(final RedisTemplate<String , Object> redisTemplate) {
        valueOps = redisTemplate.opsForValue();
    }
    public void cache(final String key , final Object Data){
        valueOps.set(key, Data);
    }
    public Object getCachedValue(final String key){
        return valueOps.get(key);
    }
    public void deleteCachedValue( String key){
        valueOps.getOperations().delete(key);
    }
}
