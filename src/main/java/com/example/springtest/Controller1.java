package com.example.springtest;

import com.demo.starter.DemoService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @Autowired
    DemoService demoService;

    @GetMapping("a")
    @AspectCut
    public String aa () {
        return demoService.say();
    }
}
