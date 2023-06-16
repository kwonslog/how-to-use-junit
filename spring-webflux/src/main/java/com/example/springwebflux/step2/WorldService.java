package com.example.springwebflux.step2;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WorldService {

  public Mono<String> getWorld() {
    return Mono.just("world");
  }
}
