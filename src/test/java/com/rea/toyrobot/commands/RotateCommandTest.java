package com.rea.toyrobot.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RotateCommandTest {

  private static Game testGame = new Game();
  private RotateCommand testRotateCommand = new RotateCommand(testGame, Direction.NORTH);

  @BeforeAll
  static void setupGame() {
    // Initialise a robot position before rotating the robot.
    testGame.getPlayerRobot().place(new Position(0, 0), Direction.EAST);
  }

  @Test
  void testRotateCommandRotatesRobot() {
    assertEquals(Direction.EAST, testGame.getPlayerRobot().getCurrentDirection());
    // Rotating from EAST to NORTH represents a LEFT command rotation.
    testRotateCommand.execute();
    assertEquals(Direction.NORTH, testGame.getPlayerRobot().getCurrentDirection());
    // NORTH to EAST represents a RIGHT rotation.
    testRotateCommand = new RotateCommand(testGame, Direction.EAST);
    testRotateCommand.execute();
    assertEquals(Direction.EAST, testGame.getPlayerRobot().getCurrentDirection());
  }

}
