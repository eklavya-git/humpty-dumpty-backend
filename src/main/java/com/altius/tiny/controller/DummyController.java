package com.altius.tiny.controller;

import com.altius.tiny.model.UserInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DummyController {

    @CrossOrigin("http://localhost:3000/")
    @GetMapping ("dummy")
    public String dummy() {
        return "Hello world from SpringBoot application";
    }

    @CrossOrigin
    @GetMapping ("userInfo")
    public UserInfo userInfo() {
        return new UserInfo("John Doe", "1234567890", "john.doe@gmail.com");
    }
}
