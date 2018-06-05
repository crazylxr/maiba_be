package com.lxr.service;

import com.lxr.util.ResponseWrapper;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "goods-service")
public interface ShoppingCartISercice {

    @GetMapping(value = "/admin/goods/{id}")
    public ResponseWrapper getGoodsById(@PathVariable("id") String id);

    @GetMapping("/admin/goodsImages")
    public ResponseWrapper getImagesByGoodsId(@RequestParam(value = "goodsId", required = true) String goodsId, @RequestParam(value = "type", required = true) int type);

}
