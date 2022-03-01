package com.wjl.ratelimiter;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * @author wangJiaLun
 * @date 2022-03-01
 **/
@Component
public class AccessLimiter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisScript<Boolean> rateLimitLua;

    public void limitAccess(String key, Integer limit){

        boolean acquired = Boolean.TRUE.equals(stringRedisTemplate.execute(
                rateLimitLua, // Lua script
                Lists.newArrayList(), // Lua keys
                limit.toString() // Lua value 列表
        ));

        if (!acquired) {
             throw new RuntimeException("access is blocked");
        }
    }
}
