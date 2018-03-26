package com.lxr.repo;

import com.lxr.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification, String>{

    List<Classification> findAllByParentId(String parent_id);
}
