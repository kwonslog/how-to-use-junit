package com.example.springwebflux.step1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
 * - "hello" 문자열을 리턴하는 컨트롤러 테스트 진행.
 * - @Test 어노테이션만 사용하였다.
 *
 */
public class HelloControllerTest {

  @Test
  public void testHello() {
    HelloController helloController = new HelloController();

    String result = helloController.hello();

    assertEquals("hello", result);
  }

  @Test
  public void testHello2_useStepVerifier() {
    HelloController helloController = new HelloController();

    Mono<String> result = helloController.hello2();

    StepVerifier.create(result).expectNext("hello").verifyComplete();
  }

  @Test
  public void testHello3_useTestService() {
    HelloController helloController = new HelloController();
    Mono<String> result = helloController.hello3();

    StepVerifier.create(result).expectNext("hello").verifyComplete();
  }
}
