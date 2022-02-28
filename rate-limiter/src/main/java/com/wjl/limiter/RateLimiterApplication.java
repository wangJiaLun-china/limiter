package com.wjl.limiter;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author wangJiaLun
 * @date 2022-02-28
 **/
@SpringBootApplication
public class RateLimiterApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RateLimiterApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
