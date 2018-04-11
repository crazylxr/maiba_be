package com.lxr.service;

import com.lxr.entity.Goods;
import com.lxr.entity.GoodsImage;
import com.lxr.repo.GoodsImageRespository;
import com.lxr.repo.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsService {

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    GoodsImageRespository goodsImageRespository;

    public Page<Goods> getGoods(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> pages = goodsRepository.findAll(pageable);
        System.out.println(pages);
        return pages;
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
            gi.setPk_id(UUID.randomUUID().toString());
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoods_id(goodId);
            gi.setResources_id(majorIds.get(i));
            gi.setType(1);
            goodsImageRespository.save(gi);
        }

        for (String minor : minorIds) {
            GoodsImage gi = new GoodsImage();
            gi.setPk_id(UUID.randomUUID().toString());
            gi.setCreateTime(new Timestamp(System.currentTimeMillis()));
            gi.setGoods_id(goodId);
            gi.setResources_id(minor);
            gi.setType(0);
            goodsImageRespository.save(gi);
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
