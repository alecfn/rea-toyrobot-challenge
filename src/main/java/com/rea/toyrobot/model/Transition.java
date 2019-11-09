package com.rea.toyrobot.model;

import com.rea.toyrobot.enums.Direction;

/**
 * Determines how to change a position when MOVE commands are issued.
 */
public class Transition {

  /**
   * Change a position statically so we do not have to re-instantiate new position instances on
   * every MOVE command issued.
   * @param position The current position on the board.
   * @param direction The current direction.
   * @return The determined position that will be transitioned to.
   */
  public static Position determineNextPosition(Position position, Direction direction) {

    int currentX = position.getXPosition();
    int currentY = position.getYPosition();

    switch (direction) {
      case EAST:
        position.setXPosition(currentX + 1);
        break;
      case WEST:
        position.setXPosition(currentX - 1);
        break;
      case NORTH:
        position.setYPosition(currentY + 1);
        break;
      case SOUTH:
        position.setYPosition(currentY - 1);
        break;
    }
    return position;
  }
}
