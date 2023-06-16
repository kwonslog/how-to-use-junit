package com.example.springwebflux.step2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
 * @RestController 와 @Service 를 사용하여 Bean 으로 등록된 객체에 대한 테스트 진행
 *
 * Bean 으로 등록된다는 것은 spring 컨테이너가 해당 객체의 라이프사이클을 관리 한다는
 * 뜻으로 new 연산자를 통해 해당 객체를 생성하는 행위는 문제가 없다.
 * 단, spring 컨테이너에 등록된 객체와 new 연산자를 통해 생성한 객체는 같지 않다.
 */
public class WorldControllerTest {

  @Test
  @DisplayName("결과값이 world 이면 성공")
  void testGetWorld() {
    /*
     * WorldController 는 Bean 으로 등록된 상태.
     * new 생성자를 통해 테스트가 가능한 것을 확인함.
     */
    WorldController worldController = new WorldController();
    String world = worldController.getWorld();

    assertEquals("world", world);
  }

  @Test
  @DisplayName("NullPointerException 이 발생하면 성공")
  void testGetWorld2_throwNullPointerException() {
    try {
      WorldController worldController = new WorldController();
      /*
       * new 생성하여 getWorld2() 호출할 경우
       * WorldService 객체가 null 이라서 오류가 발생한다.
       */
      assertThrows(
        NullPointerException.class,
        () -> {
          Mono<String> world = worldController.getWorld2();
        }
      );
      //StepVerifier.create(world).expectNext("world").verifyComplete();
    } catch (Exception e) {}
  }

  @Test
  @DisplayName("WorldService 를 생성하여 사용하면 성공")
  void testGetWorld2() {
    /*
     * WorldService 객체가 null 이 되지 않도록 생성해서 넘겨 준다.
     *
     * WorldController 는 멤버 WorldService 를 사용한다.
     * 만약 WorldService 도 내부에 멤버로써 다른 객체를 사용한다면 어떻게 될까?
     *  > 그것 역시 해당 객체를 생성해서 넘겨 줘야 한다.
     *
     */
    WorldController worldController = new WorldController(new WorldService());
    Mono<String> world = worldController.getWorld2();

    StepVerifier.create(world).expectNext("world").verifyComplete();
  }

  @Test
  @DisplayName("WorldService 모킹하여 결과값을 변경하면 성공")
  void testGetWorld2_changeResult() {
    WorldService worldServiceMock = Mockito.mock(WorldService.class);
    //WorldService worldServiceMock = Mockito.spy(new WorldService());

    when(worldServiceMock.getWorld()).thenReturn(Mono.just("changed"));

    WorldController worldController = new WorldController(worldServiceMock);
    Mono<String> world = worldController.getWorld2();

    StepVerifier.create(world).expectNext("changed").verifyComplete();
  }
}
