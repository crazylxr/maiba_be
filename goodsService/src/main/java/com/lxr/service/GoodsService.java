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
import java.util.*;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsImageRepository goodsImageRepository;

    @Autowired
    ResourcesRepository resourcesRepository;


    // for 后台
    public Page<Goods> getGoods(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> pages = goodsRepository.findAll(pageable);

        return pages;
    }

    // for 前台
    public Page<Goods> getGoodsByCondition(int page, int size, double endPrice, double startPrice, String title) {
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> pages = null;
        if (title == null || title == "" || title.isEmpty() || title.trim() == "") {
            pages = goodsRepository.findAllByPriceIsLessThanAndPriceIsGreaterThan(pageable, endPrice, startPrice);
        }else {
            pages = goodsRepository.findAllByPriceIsLessThanAndPriceIsGreaterThanAndNameLike(pageable, endPrice, startPrice, "%" + title + "%");
        }

        return pages;
    }

    public Map<String, Object> getIndexGoods(int page, int size, String title, double startPrice, double endPrice) {
        Page<Goods> _goods = getGoodsByCondition(page, size, endPrice, startPrice, title);

        List<Map<String, Object>> list = new ArrayList<>();

        for (Goods goods: _goods) {
            Map<String, Object> map = new HashMap<>();
            List<List> _list = new ArrayList<>();
            _list = getGoodsImageByGoodsId(goods.getPkId());
            map.put("goods", goods);
            map.put("majorImage", _list.get(0));
            map.put("minorImage", _list.get(1));
            list.add(map);
        }

        Map<String, Object> res = new HashMap<>();
        res.put("content", list);
        res.put("totalElements", _goods.getTotalElements());
        res.put("totalPages", _goods.getTotalPages());

        return res;
    }

    public List<List> getGoodsImageByGoodsId(String goodId) {
        List<Resources> major = resourcesRepository.findAllByGoodsIdAnAndType(goodId, 0);
        List<Resources> minor = resourcesRepository.findAllByGoodsIdAnAndType(goodId, 1);

        List<List> list = new ArrayList<>();
        list.add(major);
        list.add(minor);
        return list;
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
