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
        goods.setPkId((String) form.get("pkId"));
        goods.setDescription((String) form.get("description"));
        goods.setName((String) form.get("name"));
        goods.setPrice(new Double(form.get("price").toString()));
        goods.setDiscountPrice(new Double(form.get("discountPrice").toString()));
        goods.setInventory((int) form.get("inventory"));
        goods.setClassificationId((String) form.get("classificationId"));

        List<Map<String, Object>> majorImagesList = (List<Map<String, Object>>)(form.get("majorImages"));
        List<Map<String, Object>> minorImagesList = (List<Map<String, Object>>) form.get("minorImages");

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

    @GetMapping("/admin/goods/{id}")
    public ResponseWrapper getGoodsById(@PathVariable(value = "id") String id) {
        return ResponseWrapper.markSuccess(goodsService.getGoodsById(id));
    }

    @PutMapping("/admin/goods/{id}")
    public ResponseWrapper updateGoodsById(@PathVariable(value = "id") String id, @RequestBody Goods goods) {
        return null;
    }

    @GetMapping("/goods")
    public ResponseWrapper getIndexGoods(@RequestParam(defaultValue = "0", required = false) int page, @RequestParam(defaultValue = "10", required = false) int size,
                                         @RequestParam(required = false) String title, @RequestParam(defaultValue = "0") double startPrice,
                                         @RequestParam(defaultValue = "999999") double endPrice) {
        return ResponseWrapper.markSuccess(goodsService.getIndexGoods(page, size, title, startPrice, endPrice));
    }
}
