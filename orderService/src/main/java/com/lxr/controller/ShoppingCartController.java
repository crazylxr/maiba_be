package com.lxr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingCartController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/shop")
    public String shop() {
        return restTemplate.getForObject("http://goods-service/admin/classifications", String.class);
    }
}
