package com.example.demo.case1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping("/case1")
    public String case1() {
        return service.getText();
    }
    
    //TODO POST, PUT, DELETE 추가
}
