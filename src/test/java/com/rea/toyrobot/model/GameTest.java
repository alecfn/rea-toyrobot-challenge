package com.rea.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class GameTest {

  private Game testGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
  private static final int DEFAULT_UPPER_BOUND = 4;

  @Test
  void testGameSetup() {
    // Test that game and robot instances are set up correctly.
    assertNotNull(testGame.getPlayerBoard());
    assertEquals(DEFAULT_UPPER_BOUND, testGame.getPlayerBoard().getHeight());
    assertEquals(DEFAULT_UPPER_BOUND, testGame.getPlayerBoard().getWidth());

    assertNotNull(testGame.getPlayerRobot());
  }
}
