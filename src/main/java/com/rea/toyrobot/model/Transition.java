package com.rea.toyrobot.model;

import com.rea.toyrobot.enums.Direction;

/**
 * Determines how to change a position when MOVE commands are issued.
 */
public class Transition {

  private Transition() {
    // Hidden Constructor.
  }

  /**
   * Change a position statically so we do not have to re-instantiate new position instances on
   * every MOVE command issued.
   * @param position The current position on the board.
   * @param direction The current direction.
   * @return The determined position that will be transitioned to.
   */
  public static Position determineNextPosition(Game game, Position position, Direction direction) {

    Position newPosition = new Position(0, 0);
    int currentX = position.getXPosition();
    int currentY = position.getYPosition();

    switch (direction) {
      case EAST:
        newPosition.setXPosition(currentX + 1);
        newPosition.setYPosition(currentY);
        break;
      case WEST:
        newPosition.setXPosition(currentX - 1);
        newPosition.setYPosition(currentY);
        break;
      case NORTH:
        newPosition.setYPosition(currentY + 1);
        newPosition.setXPosition(currentX);
        break;
      case SOUTH:
        newPosition.setYPosition(currentY - 1);
        newPosition.setXPosition(currentX);
        break;
    }
    if (game.getPlayerBoard().isValidPosition(newPosition)) {
      return newPosition;
    }
    // The transition was not valid, return the old position.
    System.out.println("That move would cause the robot to fall!");
    return position;
  }
}
