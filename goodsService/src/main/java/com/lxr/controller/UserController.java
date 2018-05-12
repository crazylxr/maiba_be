package com.lxr.controller;

import com.lxr.entity.User;
import com.lxr.service.UserService;
import com.lxr.util.JavaWebToken;
import com.lxr.util.ResponseWrapper;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseWrapper signUp(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        List<User> users = new ArrayList<>();
        users = userService.getUser(user.getUsername());
        if (users.size() == 0)
            return ResponseWrapper.markAccountError();

        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("userId", user.getPkId());

        String jwt = JavaWebToken.createJavaWebToken(loginInfo);

        Map<String, Object> returnInfo = new HashMap<>();
        returnInfo.put("jwt", jwt);
        returnInfo.put("userId", users.get(0).getPkId());
       return ResponseWrapper.markSuccess(returnInfo);
    }

    @PostMapping("/user")
    public ResponseWrapper signIn(@RequestBody User user) {
        return ResponseWrapper.markSuccess(userService.singIn(user));
    }

    @GetMapping("/users")
    public ResponseWrapper getUsers() {
        return ResponseWrapper.markSuccess(userService.getUsers());
    }
}
