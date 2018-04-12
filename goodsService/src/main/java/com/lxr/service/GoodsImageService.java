package com.lxr.service;

import com.lxr.entity.GoodsImage;
import com.lxr.entity.Resources;
import com.lxr.repo.GoodsImageRepository;
import com.lxr.repo.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsImageService {

    @Autowired
    GoodsImageRepository goodsImageRepository;

    @Autowired
    ResourcesRepository resourcesRepository;

    public List<Resources> getImagesByGoodsId(String goodsId, int type) {
        return resourcesRepository.findAllByGoodsIdAnAndType(goodsId, type);
    }
}
