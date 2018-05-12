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

    public boolean save(User user) {
        if (user.getPkId().isEmpty()) {
            user.setPkId(UUID.randomUUID().toString());
            user.setCreateTime(new Timestamp(System.currentTimeMillis()));
            user.setUserType(false);
            user.setState(true);
        } else {
            user.setModifyTime(new Timestamp(System.currentTimeMillis()));
        }
        User user1 = userRepository.save(user);
        return user1 == null ? false : true;
    }

    public List<User> getUser(String username) {
        List<User> users = userRepository.findAllByUsername(username);
        return users;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {

       List<User> users = userRepository.findAllByPkId(userId);
       if (users.size() > 0) {
           return users.get(0);
       }

       return null;
    }
}
