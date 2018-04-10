package com.lxr.service;

import com.lxr.entity.Goods;
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

    public Page<Goods> getGoods(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<Goods> pages = goodsRepository.findAll(pageable);
        System.out.println(pages);
        return pages;
    }

    public Goods save(Goods goods) {
        String id = UUID.randomUUID().toString();
        goods.setPkId(id);
        goods.setVolume(0);
        goods.setGoodsId("" + System.currentTimeMillis());
        goods.setCreateTime(new Timestamp(System.currentTimeMillis()));

        return goodsRepository.save(goods);
    }

    public int deleteByIds(String ids) {
        String[] _ids = ids.split(",");

        for (int i = 0; i < _ids.length ; i++) {
            goodsRepository.delete(_ids[i]);
        }

        return _ids.length;
    }
}
