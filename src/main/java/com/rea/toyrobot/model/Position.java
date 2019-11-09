package com.rea.toyrobot.model;

/**
 * Defines a simple Position object, with an X,Y value to be used on a board.
 */
public class Position {

  public int xPosition;
  public int yPosition;

  /**
   * Constructor sets the X,Y position when initialised.
   * @param xPosition The X position on the Board.
   * @param yPosition The Y Position on the Board.
   */
  public Position(int xPosition, int yPosition)
  {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  public int getXPosition()
  {
    return this.xPosition;
  }

  public void setXPosition(int newXPosition)
  {
    this.xPosition = newXPosition;
  }

  public int getYPosition()
  {
    return this.yPosition;
  }

  public void setYPosition(int newYPosition)
  {
    this.yPosition = newYPosition;
  }
}
