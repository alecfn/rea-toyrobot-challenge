package com.rea.toyrobot.commands;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;

/**
 * Rotates the robot on the board. The new direction will be determined by the CommandParser,
 * based on whether the user input LEFT or RIGHT.
 */
public class RotateCommand implements GameOperation {

  private Game game;
  private Direction newDirection;

  RotateCommand(Game game, Direction newDirection) {
    this.game = game;
    this.newDirection = newDirection;
  }

  public void execute() {
    game.getPlayerRobot().rotate(newDirection);
  }
}
