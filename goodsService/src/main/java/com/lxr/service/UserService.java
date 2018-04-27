package com.lxr.service;

import com.lxr.entity.User;
import com.lxr.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean singIn(User user) {
        user.setPkId(UUID.randomUUID().toString());
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setUserType(false);
        user.setState(true);

        User user1 = userRepository.save(user);

        return user1 == null ? false : true;
    }

    public List<User> getUser(String username) {
        List<User> users = userRepository.findAllByUsername(username);
        return users;
    }
}
