package com.lxr.service;

import com.lxr.entity.ShoppingCart;
import com.lxr.repo.ShoppingCartRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class ShoppingCartService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @HystrixCommand(fallbackMethod = "fallback")
    public String shop() {
        return restTemplate.getForObject("http://goods-service/admin/classifications", String.class);
    }

    public String fallback() {
        return "fallback";
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        shoppingCart.setPkId(UUID.randomUUID().toString());
        shoppingCart.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return shoppingCartRepository.save(shoppingCart);
    }
}
