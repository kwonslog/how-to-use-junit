package com.example.demo.case2;

@org.springframework.stereotype.Service
public class Service2 {

    public UserDTO getUserDTO() {
//        return UserDTO.builder()
//                .name("홍길동")
//                .age(28)
//                .build();
        return new UserDTO("홍길동", 28);
    }
}