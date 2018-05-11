package com.lxr.service;

import com.lxr.entity.OrderItem;
import com.lxr.entity.Orders;
import com.lxr.repo.OrderItemRepository;
import com.lxr.repo.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Orders save(String userId, String addressId, List<Map<String, Object>> orderItems) {
        double totalPrice = 0L;
        Orders orders = new Orders();
        orders.setPkId(UUID.randomUUID().toString());
        orders.setOrderId(System.currentTimeMillis() + "");
        orders.setAddressId(addressId);
        orders.setUserId(userId);
        orders.setState(1);
        orders.setPaymentTime(new Timestamp(System.currentTimeMillis()));
        orders.setCreateTime(new Timestamp(System.currentTimeMillis()));

        for (Map<String, Object> item: orderItems) {
            OrderItem orderItem = new OrderItem();
            double price = (Integer) item.get("price");
            int number = (Integer) item.get("number");
            double itemTotalPrice = price * number;

            totalPrice += itemTotalPrice;

            orderItem.setPkId(UUID.randomUUID().toString());
            orderItem.setOrderId(orders.getPkId());
            orderItem.setGoodsId((String) item.get("goodsId"));
            orderItem.setNumber(number);
            orderItem.setCreateTime(new Timestamp(System.currentTimeMillis()));
            orderItem.setPrice(price);
            orderItem.setTotalPrice(itemTotalPrice);
            orderItemRepository.save(orderItem);
        }


        return ordersRepository.save(orders);
    }
}
