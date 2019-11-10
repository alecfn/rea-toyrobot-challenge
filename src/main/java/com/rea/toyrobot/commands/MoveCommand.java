package com.rea.toyrobot.commands;

import com.rea.toyrobot.model.Game;

/**
 * Defines a MOVE command according to Command Pattern.
 */
public class MoveCommand implements GameOperation {

  private Game game;

  MoveCommand(Game game) {
    this.game = game;
  }

  @Override
  public void execute() {
    game.getPlayerRobot().transition(game);
  }
}
