package com.lxr.repo;

import com.lxr.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderItemRepository extends JpaRepository<OrderItem, String> {

    @Query(value = "select order_item.pk_id AS itemPkId,\n" +
            "\torders.pk_id AS orderPkId,\n" +
            "\torder_item.goods_id,\n" +
            "\torder_item.price,\n" +
            "\torders.state,\n" +
            "\torder_item.number from Order_Item, Orders where order_item.order_Id = orders.pk_Id and orders.state = ?1",nativeQuery = true)
    List<Object> findAllByType(int state);

    @Query(value = "select order_item.pk_id AS itemPkId,\n" +
            "\torders.pk_id AS orderPkId,\n" +
            "\torder_item.goods_id,\n" +
            "\torder_item.price,\n" +
            "\torders.state,\n" +
            "\torder_item.number from Order_Item, Orders where order_item.order_Id = orders.pk_Id",nativeQuery = true)
    List<Object> getAll();
}
