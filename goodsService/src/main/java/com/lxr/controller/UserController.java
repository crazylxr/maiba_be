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
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseWrapper signUp(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        if (userService.getUser(user.getPkId()).size() == 0)
            return ResponseWrapper.markSuccess("账号密码不匹配！");

        Map<String, Object> loginInfo = new HashMap<>();
        loginInfo.put("userId", user.getPkId());

        String jwt = JavaWebToken.createJavaWebToken(loginInfo);
       return ResponseWrapper.markSuccess(jwt);
    }

    @PostMapping("/user")
    public ResponseWrapper signIn(@RequestBody User user) {
        return ResponseWrapper.markSuccess(userService.singIn(user));
    }
}
