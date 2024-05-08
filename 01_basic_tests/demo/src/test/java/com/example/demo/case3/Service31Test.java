package com.example.demo.case3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)

/*
    Service3Test 와 비교해보면
    @MockBean 을 사용하여 Component3 을 Import 하지 않고 테스트가 가능하다.

    하지만 Mock 객체를 사용하게 되면 메소드 호출시 리턴하는 값을 정의해 주어야 하는데
    org.mockito.Mockito.when() 메소드를 사용하면 된다.
 */
@Import({Service3.class})
class Service31Test {

    @MockBean
    private Component3 component3;

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
        System.out.println(service3.getInfo());

        /*
            component3 는 mock 객체임으로 메소드 호출시 리턴되는 값을 설정해야 한다.
         */
        when(component3.getAddress()).thenReturn("서울");

        System.out.println(service3.getInfo());

        Assertions.assertNotEquals("어쩌구 저쩌구", service3.getInfo());
    }
}