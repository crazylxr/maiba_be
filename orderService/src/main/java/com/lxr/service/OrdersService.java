package com.lxr.service;

import com.lxr.entity.OrderItem;
import com.lxr.entity.Orders;
import com.lxr.repo.OrderItemRepository;
import com.lxr.repo.OrdersRepository;
import groovy.lang.ObjectRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrdersService {

    @Autowired
    private ShoppingCartISercice shoppingCartISercice;

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

    public List<Map<String, Object>> getOrdersByType(int type) {
        List<Object> orders = orderItemRepository.findAllByType(type);

        return arrayConvertMap(orders);
    }

    public List<Map<String, Object>> getOrders() {
        List<Object> orders = orderItemRepository.getAll();
        return arrayConvertMap(orders);
    }

    public List<Map<String, Object>> arrayConvertMap (List<Object> orders) {
        List<Map<String, Object>> results = new ArrayList<>();

        for (Object o: orders) {
            Map<String, Object> map = new HashMap<>();
            map.put("itemPkId", ((Object[]) o)[0]);
            map.put("orderPkId", ((Object[])o)[1]);
            map.put("goods", shoppingCartISercice.getGoodsById((String) ((Object[])o)[2]));
            map.put("price", ((Object[])o)[3]);
            map.put("state", ((Object[])o)[4]);
            map.put("number", ((Object[])o)[5]);
            results.add(map);
        }

        return results;
    }

    public Orders updateStateByOrderId(String orderId, int state) {
        Orders orders = new Orders();
        orders = ordersRepository.findByPkId(orderId);
        orders.setState(state);
        return ordersRepository.save(orders);
    }
}
