package com.rea.toyrobot.model;

/**
 * Defines a simple Position object, with an X,Y value to be used on a board.
 */
public class Position {

  public int xPos;
  public int yPos;

  /**
   * Constructor sets the X,Y position when initialised.
   * @param xPos The X position on the Board.
   * @param yPos The Y Position on the Board.
   */
  public Position(int xPos, int yPos)
  {
    this.xPos = xPos;
    this.yPos = yPos;
  }
}