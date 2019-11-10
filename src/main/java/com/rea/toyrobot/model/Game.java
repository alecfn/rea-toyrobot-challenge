package com.rea.toyrobot.model;

import com.rea.toyrobot.boards.SimpleBoard;
import com.rea.toyrobot.robots.SimpleRobot;

/**
 * A representation of the game board.
 * Keeps track of the state of the game, input commands determine how to change it.
 *
 * For now, a game only represents a SimpleRobot on a SimpleBoard.
 */
public class Game {

  private SimpleBoard playerBoard;
  private SimpleRobot playerRobot;

  public Game(int xUpperBound, int yUpperBound) {
    // The player needs to define direction and position, so this is null at the beginning.
    this.playerBoard = new SimpleBoard(xUpperBound, yUpperBound);
    this.playerRobot = new SimpleRobot(null, null);
  }

  public SimpleBoard getPlayerBoard() {
    return this.playerBoard;
  }

  public SimpleRobot getPlayerRobot() {
    return this.playerRobot;
  }
}
