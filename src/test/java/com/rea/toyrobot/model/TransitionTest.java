package com.rea.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import org.junit.jupiter.api.Test;

public class TransitionTest {

  // Start in the lower left corner.
  private Position testPosition = new Position(0, 0);

  @Test
  public void testDetermineNextPosition() {
    // Test the logic of each possible transition.
    Transition.determineNextPosition(testPosition, Direction.EAST);
    assertEquals(1, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());

    Transition.determineNextPosition(testPosition, Direction.WEST);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());

    Transition.determineNextPosition(testPosition, Direction.NORTH);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(1, testPosition.getYPosition());

    Transition.determineNextPosition(testPosition, Direction.SOUTH);
    assertEquals(0, testPosition.getXPosition());
    assertEquals(0, testPosition.getYPosition());
  }
}
