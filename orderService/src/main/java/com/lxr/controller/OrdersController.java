package com.lxr.controller;

import com.lxr.entity.OrderItem;
import com.lxr.service.OrdersService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

     @PostMapping("/orders")
    public ResponseWrapper save(@RequestBody Map<String, Object> order, HttpServletRequest request) {
        String userId = request.getHeader("userId");

        if (userId == null || userId.isEmpty()) {
            return ResponseWrapper.markAccountError();
        }

        List<Map<String, Object>> list = (List<Map<String, Object>>) order.get("orderItems");

        return ResponseWrapper.markSuccess(ordersService.save(userId, (String) order.get("addressId"), list));
    }

}
