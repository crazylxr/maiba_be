package com.lxr.controller;

import com.lxr.service.GoodsImageService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsImageController {

    @Autowired
    GoodsImageService goodsImageService;

    @GetMapping("/goodsImages")
    public ResponseWrapper getImagesByGoodsId(@RequestParam String goodsId, @RequestParam int type) {
        return ResponseWrapper.markSuccess(goodsImageService.getImagesByGoodsId(goodsId, type));
    }
}
