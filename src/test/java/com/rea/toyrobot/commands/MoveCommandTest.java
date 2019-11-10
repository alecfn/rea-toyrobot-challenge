package com.rea.toyrobot.commands;

import static com.rea.toyrobot.model.TestGameConstants.DEFAULT_UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MoveCommandTest {

  private static Game testGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
  private MoveCommand testMoveCommand = new MoveCommand(testGame);

  @BeforeAll
  static void setupGame() {
    // We need to initialise a position for the robot before a move can be issued.
    testGame.getPlayerRobot().place(new Position(0, 0), Direction.EAST);
  }

  @Test
  void testMoveCommandMovesRobot() {
    // Test that a move command indeed moves the robot as expected.
    Position testRobotPosition = testGame.getPlayerRobot().getCurrentPosition();
    assertEquals(0, testRobotPosition.getXPosition());
    assertEquals(0, testRobotPosition.getXPosition());

    // We should be one position to the east, so X should be 1 and Y 0.
    testMoveCommand.execute();
    Position testRobotNewPosition = testGame.getPlayerRobot().getCurrentPosition();
    assertEquals(1, testRobotNewPosition.getXPosition());
    assertEquals(0, testRobotNewPosition.getYPosition());
  }
}
