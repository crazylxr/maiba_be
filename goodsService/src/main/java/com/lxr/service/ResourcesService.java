package com.lxr.service;

import com.lxr.entity.Resources;
import com.lxr.repo.ResourcesRepository;
import com.lxr.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.UUID;

@Service
public class ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

    @Value("${web.upload-path}")
    private String filePath;

    public Resources save(MultipartFile file) throws Exception {

        Resources resources = new Resources();
        resources.setPkId(UUID.randomUUID().toString());

        String fileName = resources.getPkId();
        String savePath = "localhost:8081//" + resources.getPkId() + ".png";

        resources.setPath(savePath);
        resources.setName(fileName);
        resources.setCreateTime(new Timestamp(System.currentTimeMillis()));

        FileUtil.uploadFile(file.getBytes(), filePath, fileName);

        return resourcesRepository.save(resources);
    }
}
