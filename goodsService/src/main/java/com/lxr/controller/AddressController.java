package com.lxr.controller;

import com.lxr.entity.Address;
import com.lxr.service.AddressService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/address")
    public ResponseWrapper save(@RequestBody Address address, HttpServletRequest request) {
        String userId = request.getHeader("userId");

        if (userId == null || userId.isEmpty()) {
            return ResponseWrapper.markAccountError();
        }
        return ResponseWrapper.markSuccess(addressService.save(address, userId));
    }

    @GetMapping("/address")
    public ResponseWrapper getAll(HttpServletRequest request) {
        String userId = request.getHeader("userId");

        if (userId == null || userId.isEmpty()) {
            return ResponseWrapper.markAccountError();
        }

        return ResponseWrapper.markSuccess(addressService.findAll(userId));
    }
}
