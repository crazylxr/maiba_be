package com.lxr.repo;

import com.lxr.entity.Resources;
import com.lxr.entity.GoodsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources, String> {

    @Query("select r from com.lxr.entity.Resources r ,com.lxr.entity.GoodsImage gi  where r.pkId = gi.resourcesId and gi.goodsId = ?1 and  gi.type = ?2")
    List<Resources> findAllByGoodsIdAnAndType(String goodsId, int type);

    @Query("select r from com.lxr.entity.Resources r ,com.lxr.entity.GoodsImage gi  where r.pkId = gi.resourcesId and gi.goodsId = ?1")
    List<Resources> findAllByGoodsId(String goodsId);
}

