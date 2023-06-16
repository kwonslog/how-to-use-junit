package com.example.springwebflux.step1;

import reactor.core.publisher.Mono;

/*
 * @RestController 과 같은 어노테이션을 사용하지 않는다.
 */
public class HelloController {

  public String hello() {
    return "hello";
  }

  public Mono<String> hello2() {
    return Mono.just("hello");
  }

  public Mono<String> hello3() {
    TestService testService = new TestService();
    return testService.getHello();
  }
}
