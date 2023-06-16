package com.example.springwebflux.step1;

import reactor.core.publisher.Mono;

/*
 * @Service 와 같은 어노테이션을 사용하지 않는다.
 */
public class TestService {

  public Mono<String> getHello() {
    return Mono.just("hello");
  }
}
