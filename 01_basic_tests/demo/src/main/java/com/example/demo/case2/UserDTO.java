package com.example.demo.case2;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter @Setter
public class UserDTO {

    private String name;
    private int age;

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
