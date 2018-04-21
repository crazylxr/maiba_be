package com.lxr.repo;

import com.lxr.entity.GoodsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsImageRepository extends JpaRepository<GoodsImage, String> {

   List<GoodsImage> findAllByGoodsIdAndType(String goodId, int type);

   List<GoodsImage> findAllByGoodsIdAndTypeAndResourcesId(String goodId, int type, String resourcesId);

}
