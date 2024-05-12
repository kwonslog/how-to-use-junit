package com.example.demo.case5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({Service5.class, Component5.class})
class Service5Test {

    @Autowired
    private Service5 service5;

    @Test
    @DisplayName("실제 Component5 를 사용한 테스트")
    public void case1() throws Exception {
        Assertions.assertEquals("Component5", service5.doSomething());
    }
}