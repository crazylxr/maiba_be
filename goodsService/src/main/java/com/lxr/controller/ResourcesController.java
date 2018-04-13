package com.lxr.controller;

import com.lxr.service.ResourcesService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ResourcesController {

    @Autowired
    ResourcesService resourcesService;

    @PostMapping("/admin/resources")
    public ResponseWrapper save(@RequestParam("fileName") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return ResponseWrapper.markParamError();
        }

        return ResponseWrapper.markSuccess(resourcesService.save(file));
    }
}
