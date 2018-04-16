package com.lxr.controller;

import com.lxr.entity.Goods;
import com.lxr.service.GoodsService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/admin/goods")
    public ResponseWrapper save(@RequestBody Map<String, Object> form) {
        Goods goods = new Goods();
        goods.setDescription((String) form.get("description"));
        goods.setName((String) form.get("name"));
        goods.setPrice(new Double(form.get("price").toString()));
        goods.setDiscountPrice(new Double(form.get("discountPrice").toString()));
        goods.setInventory((int) form.get("inventory"));

        List<String> majorImagesList = (List<String>)(form.get("majorImages"));
        List<String> minorImagesList = (List<String>) form.get("minorImages");

        return ResponseWrapper.markSuccess(goodsService.save(goods, majorImagesList, minorImagesList));
    }

    @DeleteMapping("/admin/goods")
    public ResponseWrapper deleteByIds(@RequestParam String ids) {
        return ResponseWrapper.markSuccess(goodsService.deleteByIds(ids));
    }

    @GetMapping("/admin/goods")
    public ResponseWrapper getGoods(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseWrapper.markSuccess(goodsService.getGoods(page, size));
    }

    @GetMapping("/goods")
    public ResponseWrapper getIndexGoods(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "10", required = false) int size,
                                         @RequestParam(required = false) String title, @RequestParam(defaultValue = "0") double startPrice,
                                         @RequestParam(defaultValue = "999999") double endPrice) {
        return ResponseWrapper.markSuccess(goodsService.getIndexGoods(page, size, title, startPrice, endPrice));
    }
}
