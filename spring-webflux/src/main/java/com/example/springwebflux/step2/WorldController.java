package com.example.springwebflux.step2;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WorldController {

  private WorldService worldService;

  public WorldController() {}

  public WorldController(WorldService worldService) {
    this.worldService = worldService;
  }

  public String getWorld() {
    return "world";
  }

  public Mono<String> getWorld2() {
    return worldService.getWorld();
  }
}
