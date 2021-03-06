package com.lxr.repo;

import com.lxr.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByUsername(String username);

    List<User> findAllByPkId(String userId);
}
