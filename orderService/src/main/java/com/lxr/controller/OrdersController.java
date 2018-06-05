package com.lxr.controller;

import com.lxr.entity.OrderItem;
import com.lxr.service.OrdersService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin/orders/{state}")
    public ResponseWrapper getAllOrdersByState(@PathVariable int state,HttpServletRequest request) {
         return ResponseWrapper.markSuccess(ordersService.getOrdersByType(state));
    }

    @GetMapping("/admin/orders")
    public ResponseWrapper getAllOrders(HttpServletRequest request) {
        return ResponseWrapper.markSuccess(ordersService.getOrders());
    }

    @PutMapping("/admin/orders/{orderId}")
    public ResponseWrapper updateStateByOrderId(@PathVariable String orderId, @RequestParam int state) {
         return ResponseWrapper.markSuccess(ordersService.updateStateByOrderId(orderId, state));
    }
}
