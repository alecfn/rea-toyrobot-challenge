package com.rea.toyrobot.commands;

import static com.rea.toyrobot.model.TestGameConstants.DEFAULT_UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.Test;

public class PlaceCommandTest {

  private static final int testXY = 0;
  private static Game testGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
  private Position testPosition = new Position(testXY, testXY);
  private PlaceCommand testPlaceCommand = new PlaceCommand(testGame, testPosition, Direction.WEST);

  @Test
  void testPlaceCommandPlacesRobot() {
    // The position and direction values of the robot should be null before calling place.
    assertNull(testGame.getPlayerRobot().getCurrentPosition());
    assertNull(testGame.getPlayerRobot().getCurrentDirection());

    testPlaceCommand.execute();
    Position robotPosition = testGame.getPlayerRobot().getCurrentPosition();
    assertNotNull(robotPosition);
    assertEquals(testXY, robotPosition.getXPosition());
    assertEquals(testXY, robotPosition.getYPosition());
    assertEquals(Direction.WEST, testGame.getPlayerRobot().getCurrentDirection());
  }

}
