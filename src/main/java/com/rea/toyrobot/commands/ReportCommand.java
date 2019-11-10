package com.rea.toyrobot.commands;

import com.rea.toyrobot.model.Game;

public class ReportCommand implements GameOperation {

  private Game game;

  public ReportCommand(Game game) {
    this.game = game;
  }

  public void execute() {
    // Just output the result of a report to System.out for now.
    System.out.println(game.getPlayerRobot().report());
  }
}
