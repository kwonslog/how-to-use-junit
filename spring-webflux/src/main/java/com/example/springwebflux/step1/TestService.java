package com.example.springwebflux.step1;

import reactor.core.publisher.Mono;

public class TestService {

  public Mono<String> getHello() {
    return Mono.just("hello");
  }
}
