package com.example.springwebflux.step2;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

@Slf4j
public class WorldControllerEtc {

  @Test
  public void test_assumeTrue() {
    try {
      assumeTrue(true, "assumeTrue !");

      //false 로 설정 했기 때문에 throw 처리된다.
      assumeTrue(false, "assumeTrue !!");
    } catch (TestAbortedException e) {
      log.error("", e);
    }
  }

  @Test
  public void test_assumeFalse() {
    try {
      assumeFalse(false, "assumeTrue !");

      //true 로 설정 했기 때문에 throw 처리된다.
      assumeFalse(true, "assumeTrue !!");
    } catch (TestAbortedException e) {
      log.error("", e);
    }
  }
}
