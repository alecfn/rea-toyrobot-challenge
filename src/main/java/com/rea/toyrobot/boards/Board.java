package com.rea.toyrobot.boards;

public abstract class Board {

  private int width;
  private int height;

  /**
   * A board object should have at least a height and width boundary defined.
   * @param width   The x boundary value of the board.
   * @param height  The y boundary value of the board.
   */
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public abstract boolean isValidPosition(Position position);

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
