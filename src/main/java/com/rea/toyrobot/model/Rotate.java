package com.rea.toyrobot.model;

import com.rea.toyrobot.enums.Command;
import com.rea.toyrobot.enums.Direction;

/**
 * Determines which direction to rotate a robot from the command supplied.
 */
public class Rotate {

  private Rotate() {
    // Hidden Constructor.
  }

  public static Direction determineNewRotation(Direction direction, Command command) {

    if(command == Command.LEFT) {
      switch (direction) {
        case NORTH:
          direction = Direction.WEST;
          break;
        case WEST:
          direction = Direction.SOUTH;
          break;
        case SOUTH:
          direction = Direction.EAST;
          break;
        case EAST:
          direction = Direction.NORTH;
          break;
      }
    }
    else if(command == Command.RIGHT) {
      switch (direction) {
        case NORTH:
          direction = Direction.EAST;
          break;
        case WEST:
          direction = Direction.NORTH;
          break;
        case SOUTH:
          direction = Direction.WEST;
          break;
        case EAST:
          direction = Direction.SOUTH;
          break;
      }
    }
    return direction;
  }
}
