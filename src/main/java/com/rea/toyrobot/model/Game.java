package com.rea.toyrobot.model;

import com.rea.toyrobot.boards.SimpleBoard;
import com.rea.toyrobot.robots.SimpleRobot;

/**
 * A representation of the game board.
 * Keeps track of the state of the game and uses input commands to determine how to change it.
 *
 * For now, a game only represents a SimpleRobot on a SimpleBoard.
 * Parameters for a board such as height/width are not provided so are defined here.
 */
public class Game {

  private SimpleBoard playerBoard;
  private SimpleRobot playerRobot;

  // Board positions begin at 0, so an upper of 4 is 5 positions.
  private static final int DEFAULT_UPPER_BOUND = 4;

  public Game() {
    this.playerBoard = new SimpleBoard(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
    // The player needs to define direction and position, so this is null at the beginning.
    this.playerRobot = new SimpleRobot(null, null);
  }

  public SimpleBoard getPlayerBoard() {
    return this.playerBoard;
  }

  public SimpleRobot getPlayerRobot() {
    return this.playerRobot;
  }
}
