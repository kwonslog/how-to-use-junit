package com.example.demo.case5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service5 {

    private final Component5 component5;

    public String doSomething() {
        return component5.value();
    }
}
