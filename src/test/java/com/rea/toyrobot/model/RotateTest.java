package com.rea.toyrobot.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Command;
import com.rea.toyrobot.enums.Direction;
import org.junit.jupiter.api.Test;

class RotateTest {

  private Direction startDirection = Direction.EAST;

  @Test
  void testLeftRotation() {
    // Test that a command to move LEFT results in a rotation in the correct direction.

    Direction testDirection = changeDirectionLeft(startDirection);
    assertEquals(Direction.NORTH, testDirection);
    testDirection = changeDirectionLeft(testDirection);
    assertEquals(Direction.WEST, testDirection);
    testDirection = changeDirectionLeft(testDirection);
    assertEquals(Direction.SOUTH, testDirection);
    testDirection = changeDirectionLeft(testDirection);
    assertEquals(Direction.EAST, testDirection);
  }

  @Test
  void testRightRotation() {
    // Test that all Right rotations work as expected.
    Direction testDirection = changeDirectionRight(startDirection);
    assertEquals(Direction.SOUTH, testDirection);
    testDirection = changeDirectionRight(testDirection);
    assertEquals(Direction.WEST, testDirection);
    testDirection = changeDirectionRight(testDirection);
    assertEquals(Direction.NORTH, testDirection);
    testDirection = changeDirectionRight(testDirection);
    assertEquals(Direction.EAST, testDirection);
  }

  private Direction changeDirectionLeft(Direction currentDirection) {
    return Rotate.determineNewRotation(currentDirection, Command.LEFT);
  }

  private Direction changeDirectionRight(Direction currentDirection) {
    return Rotate.determineNewRotation(currentDirection, Command.RIGHT);
  }
}
