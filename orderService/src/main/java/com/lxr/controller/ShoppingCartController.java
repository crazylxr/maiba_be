package com.lxr.controller;

import com.lxr.entity.ShoppingCart;
import com.lxr.service.ShoppingCartService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartServvice;

    @GetMapping("/shoppingCart")
    public String shop() {
        return shoppingCartServvice.shop();
    }

    @PostMapping("/shoppingCart")
    public ResponseWrapper save(@RequestBody ShoppingCart shoppingCart, HttpRequest request) {
        request.getHeaders().getAccept();
        System.out.println(a);
        return null;
    }
}
