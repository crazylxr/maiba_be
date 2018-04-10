package com.lxr.controller;

import com.lxr.entity.Goods;
import com.lxr.service.GoodsService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/goods")
    public ResponseWrapper save(@RequestBody Goods goods) {
        return ResponseWrapper.markSuccess(goodsService.save(goods));
    }

    @DeleteMapping("/goods")
    public ResponseWrapper deleteByIds(@RequestParam String ids) {
        return ResponseWrapper.markSuccess(goodsService.deleteByIds(ids));
    }

    @GetMapping("/goods")
    public ResponseWrapper getGoods(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseWrapper.markSuccess(goodsService.getGoods(page, size));
    }
}
