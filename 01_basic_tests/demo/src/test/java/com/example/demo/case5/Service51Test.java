package com.example.demo.case5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import({Service5.class})
class Service51Test {

    @Autowired
    private Service5 service5;

    /*
        @TestConfiguration 은 테스트 환경에서 사용할 Bean 이나 설정 값들을 정의 할 수 있다.
        아래 테스트 코드를 보면 Service5 에서 사용하는 Component5 를 테스트 환경에 맞게 새로 생성하여
        테스트를 성공적으로 실행하였다.

        사실 메소드 1개 때문에 이렇게 까지 할 필요는 없다.(@MockBean 을 쓰는게 훨씬 간단하다.)
        좀 더 테스트 환경에 맞게 복잡한 구성이 필요할 경우에 사용한다.
     */
    @org.springframework.boot.test.context.TestConfiguration
    static class TestConfiguration {
        // Service5 에서 사용하는 Component5 을 테스트 할때 원하는 값으로 설정하여 사용한다.
        @Bean
        public Component5 component5() {
            return new Component5() {
                @Override
                public String value() {
                    return "TestConfiguration";
                }
            };
        }
    }

    @Test
    @DisplayName("@TestConfiguration 사용한 테스트")
    public void case2() throws Exception {
        Assertions.assertEquals("TestConfiguration", service5.doSomething());
    }
}