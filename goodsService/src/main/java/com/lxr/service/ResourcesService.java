package com.lxr.service;

import com.lxr.entity.Resources;
import com.lxr.repo.ResourcesRepository;
import com.lxr.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

    public Resources save(MultipartFile file) throws Exception {
        String filePath = "src/main/resources/static/";


        Resources resources = new Resources();
        resources.setPkId(UUID.randomUUID().toString());

        String path = filePath + resources.getPkId();
        String fileName = resources.getPkId();

        resources.setPath(path);
        resources.setName(fileName);
        resources.setCreateTime(new Timestamp(System.currentTimeMillis()));

        FileUtil.uploadFile(file.getBytes(), filePath, fileName);

        return resourcesRepository.save(resources);
    }
}
