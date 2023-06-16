package com.example.springwebflux.step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WorldControllerNestedTest {

  @Nested
  @DisplayName("성공 케이스")
  class SuccessCase {

    @Test
    @DisplayName("결과값이 world 인 경우")
    void testGetWorld() {
      WorldController worldController = new WorldController();
      String world = worldController.getWorld();

      assertEquals("world", world);
    }
  }

  @Nested
  @DisplayName("실패 케이스")
  class FailureCase {

    @Test
    @DisplayName("결과값이 world 가 아닌 경우")
    void testGetWorld() {
      WorldController worldController = mock(WorldController.class);

      when(worldController.getWorld()).thenReturn("hello");

      String world = worldController.getWorld();

      assertNotEquals("world", world);
    }
  }
}
