package com.rea.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import org.junit.jupiter.api.Test;

public class TransitionTest {

  // Start in the lower left corner.
  private Position testPosition = new Position(0, 0);
  private static final Game testGame = new Game();

  @Test
  public void testDetermineNextPosition() {
    // Test the logic of each possible transition.
    testPosition = Transition.determineNextPosition(testGame, testPosition, Direction.EAST);
    assertEquals(1, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());

    testPosition = Transition.determineNextPosition(testGame, testPosition, Direction.WEST);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());

    testPosition = Transition.determineNextPosition(testGame, testPosition, Direction.NORTH);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(1, testPosition.getYPosition());

    testPosition = Transition.determineNextPosition(testGame, testPosition, Direction.SOUTH);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());
  }
}
