package com.lxr.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShoppingCartServvice {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String shop() {
        return restTemplate.getForObject("http://goods-service/admin/classifications", String.class);
    }

    public String fallback() {
        return "fallback";
    }
}
