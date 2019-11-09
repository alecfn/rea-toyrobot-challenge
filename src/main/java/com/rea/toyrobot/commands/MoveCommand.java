package com.rea.toyrobot.commands;

import com.rea.toyrobot.model.Game;

public class MoveCommand implements GameOperation {

  private Game game;

  public MoveCommand(Game game) {
    this.game = game;
  }

  @Override
  public void execute() {
    game.getPlayerRobot().transition();
  }
}
