package com.example.demo.case3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
    junit 에서 spring test framework 의 기능을 사용하기 위해 설정한다.
 */
@ExtendWith(SpringExtension.class)

/*
  Service3 안에서 Component3 을 주입 받아서 사용하고 있기 때문에
  Component3 클래스도 Import 해야 한다.

  만약 Service3 클래스 안에서 다수의 bean 을 주입받아 사용한다고 가정하다면
  다수의 bean 안에서 또다시 다른 bean 을 사용하는 경우까지 고려해서
  모든 클래스들을 Import 해야 테스트가 가능하다.
 */
@Import({Service3.class, Component3.class})
class Service3Test {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private Service3 service3;

    @Test
    @DisplayName("getNameTest")
    public void getNameTest() throws Exception {
        Assertions.assertEquals("홍길동", service3.getName());
    }

    @Test
    @DisplayName("getAgeTest")
    public void getAgeTest() throws Exception {
        Assertions.assertNotEquals(20, service3.getAge());
    }

    @Test
    @DisplayName("getInfoTest")
    public void getInfoTest() throws Exception {
        Assertions.assertNotEquals("어쩌구 저쩌구", service3.getInfo());
    }
}