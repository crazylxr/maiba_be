package com.lxr.repo;

import com.lxr.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GoodsRepository extends JpaRepository<Goods, String> {
   Page<Goods> findAll(Pageable pageable);
}
