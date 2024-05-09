package com.example.demo.case4;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@Setter
@Getter
@Entity(name = "Users")

// jpa entity 는 기본 생성자가 반드시 있어야 한다. jpa는 기본 생성자로 객체를 생성하고 나서 필드에 값을 설정한다.
@NoArgsConstructor

// Builder 가 동작하려면 모든 필드를 초기화 하기 위한 생성자가 필요하기 때문에 AllArgsConstructor 과 같이 사용했다.
@Builder
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
