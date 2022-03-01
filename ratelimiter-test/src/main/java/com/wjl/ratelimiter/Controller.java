package com.wjl.ratelimiter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangJiaLun
 * @date 2022-03-01
 **/
@Slf4j
@RestController
public class Controller {

    @Autowired
    private AccessLimiter accessLimiter;

    @GetMapping("/test")
    public String test(){
        accessLimiter.limitAccess("rateLimiter-test", 1);
        return "success";
    }

}
