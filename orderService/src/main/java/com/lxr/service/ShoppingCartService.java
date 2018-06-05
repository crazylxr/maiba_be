package com.lxr.service;

import com.lxr.entity.Goods;
import com.lxr.entity.Resources;
import com.lxr.entity.ShoppingCart;
import com.lxr.repo.ShoppingCartRepository;
import com.lxr.util.ResponseWrapper;
import com.lxr.util.Tool;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ShoppingCartService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ShoppingCartISercice shoppingCartISercice;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @HystrixCommand(fallbackMethod = "fallback")
    public String shop() {
        return restTemplate.getForObject("http://goods-service/admin/classifications", String.class);
    }

    public String fallback() {
        return "fallback";
    }

    public ShoppingCart save(ShoppingCart shoppingCart, String userId) {
        shoppingCart.setGoodsId(shoppingCart.getPkId());
        shoppingCart.setPkId(UUID.randomUUID().toString());
        shoppingCart.setUserId(userId);
        shoppingCart.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return shoppingCartRepository.save(shoppingCart);
    }

    public List<Map<String, Object>> getShoppingCartByUserId(String userId) throws Exception {
        List<Map<String, Object>> res = new ArrayList<>();
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAllByUserId(userId);

        for(ShoppingCart s : shoppingCarts) {
            Map<String, Object> map = new HashMap<>();
            String goodsId = s.getGoodsId();

            ResponseWrapper responseWrapper = shoppingCartISercice.getGoodsById(goodsId);
            Map<String, Object> goodsMap = (Map<String, Object>) responseWrapper.getData();
            Map<String, Object> goods = (Map<String, Object>) goodsMap.get("goods");

            List<Map<String, Object>> imgs = (List<Map<String, Object>>) goodsMap.get("majorImages");

            map.put("pkId", s.getPkId());
            map.put("goodsId", goods.get("pkId"));
            map.put("imgUrl", imgs.get(0).get("path"));
            map.put("name", goods.get("name"));
            map.put("price", goods.get("price"));
            map.put("number", s.getNumber());

            res.add(map);
        }
        return res;
    }

    public void deleteByGoodsId(String goodsId, String userId) {
        int number = shoppingCartRepository.deleteByPkIdAndUserId(goodsId, userId);
        System.out.print(number);
    }
}
