package com.rea.toyrobot.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.Test;

public class PlaceCommandTest {

  private static Game testGame = new Game();
  private Position testPosition = new Position(0, 0);
  private PlaceCommand testPlaceCommand = new PlaceCommand(testGame, testPosition, Direction.WEST);

  @Test
  void testPlaceCommandPlacesRobot() {
    // The position and direction values of the robot should be null before calling place.
    assertNull(testGame.getPlayerRobot().getCurrentPosition());
    assertNull(testGame.getPlayerRobot().getCurrentDirection());

    testPlaceCommand.execute();
    assertNotNull(testGame.getPlayerRobot().getCurrentPosition());
    assertNotNull(testGame.getPlayerRobot().getCurrentDirection());
  }

}
