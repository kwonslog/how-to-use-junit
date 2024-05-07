package com.example.demo.case2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller2 {

    private final Service2 service;

    @GetMapping("/json1")
    public String json1() {
        return "json1";
    }

    @GetMapping("/json2")
    public UserDTO json2() {
        return service.getUserDTO();
    }
}
