package com.rea.toyrobot.robots;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import com.rea.toyrobot.model.Transition;

/**
 * An Abstract representation of a Robot.
 */
public abstract class Robot {

  private Position currentPosition;
  private Direction currentDirection;

  public Robot(Position position, Direction direction) {
    // The initial placement from the first PLACE command will be set in the constructor.
    this.currentPosition = position;
    this.currentDirection = direction;
  }

  /**
   * Handles movement of the Robot to a new position.
   */
  public void transition(Game game) {
    this.currentPosition =
        Transition.determineNextPosition(game, this.currentPosition, this.currentDirection);
  }

  /**
   * Handles any subsequent PLACE commands to a new position other than the initial PLACE.
   * @param newPosition The new position on which to place the robot.
   */
  public void place(Position newPosition, Direction newDirection) {
    this.currentPosition = newPosition;

    // No need to reassign the direction if it is the same as the new one.
    if (newDirection != this.currentDirection) {
      this.currentDirection = newDirection;
    }
  }

  /**
   * Handles rotation of the robot to a new direction.
   * @param newDirection The new direction to rotate to (EAST, WEST, NORTH or SOUTH).
   */
  public void rotate(Direction newDirection) {
    this.currentDirection = newDirection;
  }

  /**
   * Handles reporting the current position of the robot.
   * @return A concatenated String of the X,Y position and direction.
   */
  public String report() {
    StringBuilder reportBuilder = new StringBuilder();
    return reportBuilder.append(this.currentPosition.getXPosition())
                        .append(",")
                        .append(this.currentPosition.getYPosition())
                        .append(",")
                        .append(this.currentDirection).toString();
  }

  public Direction getCurrentDirection() {
   return currentDirection;
  }

  public Position getCurrentPosition() {
    return currentPosition;
  }
}
