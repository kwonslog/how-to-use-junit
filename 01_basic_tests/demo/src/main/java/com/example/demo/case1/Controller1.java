package com.example.demo.case1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Controller1 {

    private final Service1 service;

    @GetMapping("/case1")
    public String case1() {
        return service.getCase1Text();
    }

    @PostMapping("/case2")
    public String case2() {
        return service.getCase2Text();
    }

    @PutMapping("/case3")
    public String case3() {
        return service.getCase3Text();
    }

    @DeleteMapping("/case4")
    public String case4() {
        return service.getCase4Text();
    }
}
