package com.wjl.limiter.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangJiaLun
 * @date 2022-02-28
 **/
@Slf4j
@RestController
public class RateLimiterController {

    RateLimiter limiter = RateLimiter.create(2.0);

    // 非阻塞限流
    @GetMapping("/tryAcquire")
    public String tryAcquire(Integer count){
        if (limiter.tryAcquire(count)) {
            log.info("success, rate is {}", limiter.getRate());
            return "success";
        }else {
            log.info("fail is {}", limiter.getRate());
            return "fail";
        }
    }

}
