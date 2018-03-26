package com.lxr.service;

import com.lxr.entity.Classification;
import com.lxr.repo.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    public List<Map<String, Object>> getClassifications() {
        List<Classification> classifications = classificationRepository.findAll();
        return transformClassifications(classifications);
    }

    public Classification saveClassifiction(Classification classification) {
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        classification.setPkId(UUID.randomUUID().toString());
        classification.setCreateTime(createTime);
       return classificationRepository.save(classification);
    }

    public void deleteClassification(String id) {
        classificationRepository.delete(id);

        deleteChildren(id);
    }

    public void deleteChildren(String id) {
        List<Classification> classifications = classificationRepository.findAllByParentId(id);

        if(classifications.size() == 0) {
            return;
        }

        for (Classification c : classifications) {
            classificationRepository.delete(c.getPkId());
            deleteChildren(c.getPkId());
        }
    }

    // 先找出 parent_id 为 null 的, 转化成需要的 List Map，然后再把 parent_id 为 null 的从 classifications 去掉
    public List<Map<String, Object>> transformClassifications(List<Classification> classifications) {

        List<Map<String, Object>> list = new ArrayList<>();
        List<Classification> removeList = new ArrayList<>();

        List<Map<String, Object>> childrenList = new ArrayList<>();

        for (Classification classification : classifications) {
            Map<String, Object> map = new HashMap<>();

            if(classification.getParentId() == null) {
                map.put("id", classification.getPkId());
                map.put("label", classification.getName());
                map.put("children", childrenList);

                // 不重新赋值会导致所有的 children 引用都是一个，给一个 children 赋值，所有的 children 都会变
                childrenList = new ArrayList<>();
                list.add(map);
                removeList.add(classification);
            }
        }

        for (Classification c : removeList) {
            classifications.remove(c);
        }


        List<Map<String, Object>> returnList = otherClassification(classifications, list);
        return returnList;
    }

    public List<Map<String, Object>> otherClassification(List<Classification> classifications, List<Map<String, Object>> lists) {
        // 递归退出条件
        if (classifications.size() == 0) {
            return lists;
        }

        List<Classification> removeList = new ArrayList<>();

        for (Map<String, Object> map : lists) {
            for (Classification classification : classifications) {
                if (classification.getParentId().equals(map.get("id"))) {
                    Map<String, Object> tmp = new HashMap<>();
                    tmp.put("id", classification.getPkId());
                    tmp.put("label", classification.getName());
                    tmp.put("children", new ArrayList<Map<String, Object>>());
                    List<Map<String, Object>> children = (List<Map<String, Object>>) map.get("children");
                    children.add(tmp);
                    removeList.add(classification);
                }
            }
        }

        for (Classification c : removeList) {
            classifications.remove(c);
        }

        // 所有的 children 递归
        for (Map<String, Object> map : lists) {
            otherClassification(classifications, (List<Map<String, Object>>) map.get("children"));
        }
        return lists;
    }
}
