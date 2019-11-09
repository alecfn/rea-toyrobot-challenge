package com.rea.toyrobot.commands;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;

public class PlaceCommand implements GameOperation {

  private Game game;
  private Position position;
  private Direction direction;

  public PlaceCommand(Game game, Position position, Direction direction) {
    this.game = game;
    this.position = position;
    this.direction = direction;
  }

  public void execute() {
    game.getPlayerRobot().place(position, direction);
  }
}
