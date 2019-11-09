package com.rea.toyrobot.boards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleBoardTest {

  // Define a basic 5x5 grid for testing a SimpleBoard.
  private int width = 5;
  private int height = 5;
  private SimpleBoard testsimpleBoard = new SimpleBoard(width, height);

  @Test
  public void testIsValidPosition()
  {
    // Tests that a position is within the defined boundary.
    int xPos, yPos;
    xPos = yPos = 0;
    assertTrue(testsimpleBoard.isValidPosition(new Position(xPos, yPos)));
  }

  @Test
  public void testIsInvalidPosition()
  {
    // Tests that a position outside the defined boundary is not valid.
    int xPos, yPos;
    xPos = yPos = 10;
    assertFalse(testsimpleBoard.isValidPosition(new Position(xPos, yPos)));
  }
}
