package com.example.demo.case2;

@org.springframework.stereotype.Service
public class Service2 {

    public UserDTO getUserDTO() {
        return new UserDTO("홍길동", 28);
    }
}