package com.example.demo.case3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

/*
    MockitoExtension.class 를 사용하여 Mock 객체를 주입하여 테스트 할 수 있다.
    Service31Test 와 비교해 보면
     - @Import 를 사용하지 않았다.
     - @InjectMocks 을 사용하여 Service3 목 객체를 주입했다.
     - @Mock 을 사용하여 Service3 이 의존하는 Component3 에 목 객체를 주입했다.

     인사이트.
      1. 복잡한 의존관계가 얽혀 있는 경우 테스트 케이스 작성이 어려울수 있다.
         왜냐하면 사용하는 모든 객체에 대한 정보를 제공하거나 목 객체를 주입해야 하기 때문이다.
      2. 그러므로 하나의 클래스가 의존하는 것들의 개수를 최소화 하는 것이 테스트 케이스 작성에 도움이 될 것으로 생각한다.
*/
@ExtendWith(MockitoExtension.class)
class Service32Test {

    @Mock
    private Component3 component3;

    /*
        @InjectMocks 은 테스트 할 클래스에 지정하고,
        해당 클래스가 의존하는 클래스들은 @Mock 을 사용하여 주입 되도록 처리한다.

        Service3 목 객체가 생성될때 Component3 목 객체가 주입 된다고 이해 할수 있다.
     */
    @InjectMocks
    private Service3 service3;

    @Test
    @DisplayName("getNameTest")
    public void getNameTest() throws Exception {
        System.out.println(service3.getName());
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
        System.out.println(service3.getInfo());

        /*
            component3 는 mock 객체임으로 메소드 호출시 리턴되는 값을 설정해야 한다.
         */
        when(component3.getAddress()).thenReturn("서울");

        System.out.println(service3.getInfo());

        Assertions.assertNotEquals("어쩌구 저쩌구", service3.getInfo());
    }
}