package com.lxr.maiba_be;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didipace.com");
        return "index";
    }

}
