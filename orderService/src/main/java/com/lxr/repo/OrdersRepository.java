package com.lxr.repo;

import com.lxr.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    Orders findByPkId(String id);
}
