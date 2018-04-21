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

    public Goods updateGoodsById(String id, Goods goods) {
        return null;
    }

    public Map<String, Object> getGoodsById(String id) {
        Goods goods = goodsRepository.findOne(id);
        List<Resources> majorImages =  resourcesRepository.findAllByGoodsIdAnAndType(id, 1);
        List<Resources> minorImages =  resourcesRepository.findAllByGoodsIdAnAndType(id, 0);

        Map<String, Object> map = new HashMap<>();
        map.put("goods", goods);
        map.put("majorImages", majorImages);
        map.put("minorImages", minorImages);
        return map;
    }

    public Map<String, Object> getIndexGoods(int page, int size, String title, double startPrice, double endPrice) {
        Page<Goods> _goods = getGoodsByCondition(page, size, endPrice, startPrice, title);

        List<Map<String, Object>> list = new ArrayList<>();

        for (Goods goods: _goods) {
            Map<String, Object> map = new HashMap<>();
            List<List> _list;
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

    public Goods save(Goods goods, List<Map<String, Object>> majorIds, List<Map<String, Object>> minorIds) {
        String id;

        // 如果是更新操作直接根据主键相同直接更新
        if(goods.getPkId() == null || goods.getPkId().isEmpty()) {
            id = UUID.randomUUID().toString();
        }else {
            id = goods.getPkId();
        }

        goods.setPkId(id);
        goods.setVolume(0);
        goods.setGoodsId("" + System.currentTimeMillis());
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));

        saveGoodsImages(goods.getPkId(),majorIds, minorIds);

        return goodsRepository.save(goods);
    }

    public void saveGoodsImages(String goodId, List<Map<String, Object>> majorIds, List<Map<String, Object>> minorIds) {
        for (int i = 0; i < majorIds.size(); i++) {
            GoodsImage gi = new GoodsImage();
            String id;

            // 用于判断是否已经存在该图片了，如果存在执行更新，不存在，执行新增
            String resourcesId = (String) majorIds.get(i).get("pkId");
            List<GoodsImage> goodsImageList = goodsImageRepository.findAllByGoodsIdAndTypeAndResourcesId(goodId, 1, resourcesId);

            if(goodsImageList.size() != 0) {
                id = goodsImageList.get(0).getPkId();
            }else {
                id = UUID.randomUUID().toString();
            }

            gi.setPkId(id);
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoodsId(goodId);
            gi.setResourcesId((String) majorIds.get(i).get("pkId"));
            gi.setType(1);
            goodsImageRepository.save(gi);
        }

        for (Map<String, Object> minor : minorIds) {
            GoodsImage gi = new GoodsImage();

            String id;

            List<GoodsImage> goodsImageList = goodsImageRepository.findAllByGoodsIdAndTypeAndResourcesId(goodId, 0, (String) minor.get("pkId"));

            if(goodsImageList.size() != 0) {
                id = goodsImageList.get(0).getPkId();
            }else {
                id = UUID.randomUUID().toString();
            }

            gi.setPkId(id);
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoodsId(goodId);
            gi.setResourcesId((String) minor.get("pkId"));
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
