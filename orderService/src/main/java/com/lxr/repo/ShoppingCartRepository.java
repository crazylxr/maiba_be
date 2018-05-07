package com.lxr.repo;

import com.lxr.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String> {
    List<ShoppingCart> findAllByUserId(String userId);
}
