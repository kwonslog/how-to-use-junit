package com.example.demo.case3;

import org.springframework.stereotype.Service;

@Service
public class Service3 {

    private final Component3 component3;

    public Service3(Component3 component3) {
        this.component3 = component3;
    }

    public String getName() {
        return "홍길동";
    }

    public int getAge() {
        return 28;
    }

    public String getInfo() {
        return this.getName() + this.getAge() + component3.getAddress();
    }
}
