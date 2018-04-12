package com.lxr.service;

import com.lxr.entity.Goods;
import com.lxr.entity.GoodsImage;
import com.lxr.entity.Resources;
import com.lxr.repo.GoodsImageRepository;
import com.lxr.repo.GoodsRepository;
import com.lxr.repo.ResourcesRepository;
import com.lxr.util.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsImageRepository goodsImageRepository;

    @Autowired
    ResourcesRepository resourcesRepository;

    public Page<Goods> getGoods(int page, int size) throws Exception {
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> pages = goodsRepository.findAll(pageable);

        for (Goods goods: pages) {
            Map<String, Object> map = new HashMap<>();
            map = Tool.convertBean(goods);
        }
        System.out.println(pages);
        return pages;
    }

    public Map<String, Object> getGoodsImageByGoodsId(String goodId) {
        List<Resources> major = resourcesRepository.findAllByGoodsIdAnAndType(goodId, 0);
        List<Resources> minor = resourcesRepository.findAllByGoodsIdAnAndType(goodId, 1);

        Map<String, Object> map = new HashMap<>();
        map.put("majorImages", major);
        map.put("minorImages", minor);

        return map;
    }

    public Goods save(Goods goods, List<String> majorIds, List<String> minorIds) {
        String id = UUID.randomUUID().toString();
        goods.setPkId(id);
        goods.setVolume(0);
        goods.setGoodsId("" + System.currentTimeMillis());
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));

        saveGoodsImages(goods.getPkId(),majorIds, minorIds);

        return goodsRepository.save(goods);
    }

    public void saveGoodsImages(String goodId, List<String> majorIds, List<String> minorIds) {
        for (int i = 0; i < majorIds.size(); i++) {
            GoodsImage gi = new GoodsImage();
            gi.setPkId(UUID.randomUUID().toString());
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoodsId(goodId);
            gi.setResourcesId(majorIds.get(i));
            gi.setType(1);
            goodsImageRepository.save(gi);
        }

        for (String minor : minorIds) {
            GoodsImage gi = new GoodsImage();
            gi.setPkId(UUID.randomUUID().toString());
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoodsId(goodId);
            gi.setResourcesId(minor);
            gi.setType(0);
            goodsImageRepository.save(gi);
        }
    }

    public int deleteByIds(String ids) {
        String[] _ids = ids.split(",");

        for (int i = 0; i < _ids.length ; i++) {
            goodsRepository.delete(_ids[i]);
        }

        return _ids.length;
    }
}
