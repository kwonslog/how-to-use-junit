package com.example.springwebflux.step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
 * - "hello" 문자열을 리턴하는 컨트롤러 테스트 진행.
 * - @Test 어노테이션만 사용하였다.
 *
 */
@Slf4j
public class HelloControllerTest {

  @Test
  @DisplayName("hello 문자열값 검증")
  public void testHello() {
    HelloController helloController = new HelloController();
    String result = helloController.hello();

    assertEquals("hello", result);
  }

  @Test
  @DisplayName("hello 문자열값 StepVerifier 로 검증")
  public void testHello2_useStepVerifier() {
    HelloController helloController = new HelloController();

    Mono<String> result = helloController.hello2();

    StepVerifier.create(result).expectNext("hello").verifyComplete();
  }
}
