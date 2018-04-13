package com.lxr.controller;

import com.lxr.entity.Classification;
import com.lxr.service.ClassificationService;
import com.lxr.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @PostMapping("/admin/classification")
    public ResponseWrapper saveClassfication(@RequestBody Classification classification) {
        try{
            Classification classification1 = classificationService.saveClassifiction(classification);
            return ResponseWrapper.markSuccess(classification1);
        }catch (Exception exception){
            System.out.println(exception);
            return ResponseWrapper.markError();
        }
    }

    @GetMapping("/admin/classifications")
    public ResponseWrapper getClassification() {
        List<Map<String, Object>> classifications = classificationService.getClassifications();
        return ResponseWrapper.markSuccess(classifications);
    }

    @DeleteMapping("/admin/classification/{id}")
    public ResponseWrapper deleteClassification(@PathVariable String id) {
        classificationService.deleteClassification(id);
        return ResponseWrapper.markSuccess(null);
    }
}
