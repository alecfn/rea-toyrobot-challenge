package com.rea.toyrobot.commands;

import com.rea.toyrobot.model.Game;

public class ReportCommand implements GameOperation {

  private Game game;

  public ReportCommand(Game game) {
    this.game = game;
  }

  public void execute() {
    game.getPlayerRobot().report();
  }
}
