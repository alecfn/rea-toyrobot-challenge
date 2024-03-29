package com.rea.toyrobot.boards;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.Test;

class SimpleBoardTest {

  // Define a basic 5x5 grid for testing a SimpleBoard.
  private int width = 4;
  private int height = 4;
  private SimpleBoard testSimpleBoard = new SimpleBoard(width, height);

  @Test
  void testIsValidPosition()
  {
    // Tests that a position is within the defined boundary.
    int xPos, yPos;
    xPos = yPos = 0;
    assertTrue(testSimpleBoard.isValidPosition(new Position(xPos, yPos)));
  }

  @Test
  void testIsInvalidPosition()
  {
    // Tests that a position outside the defined boundary is not valid.
    int xPos, yPos;
    xPos = yPos = 10;
    assertFalse(testSimpleBoard.isValidPosition(new Position(xPos, yPos)));
  }
}
