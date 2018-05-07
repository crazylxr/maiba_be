package com.lxr.controller;

import com.lxr.entity.ShoppingCart;
import com.lxr.service.ShoppingCartService;
import com.lxr.util.ResponseWrapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartServvice;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/shoppingCart")
    public String shop() {
        return shoppingCartServvice.shop();
    }

    @PostMapping("/shoppingCart/{userId}")
    public ResponseWrapper save(@RequestBody ShoppingCart shoppingCart, @PathVariable String userId) {
        System.out.println(httpServletRequest.getHeader("Authorization"));
        return ResponseWrapper.markSuccess(shoppingCartServvice.save(shoppingCart, userId));
    }

    @GetMapping("/shoppingCart/{userId}")
    public ResponseWrapper getShoppingCartByUserId(@PathVariable String userId) throws Exception {
        return ResponseWrapper.markSuccess(shoppingCartServvice.getShoppingCartByUserId(userId));
    }
}
