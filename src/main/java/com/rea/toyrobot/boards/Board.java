package com.rea.toyrobot.boards;

import com.rea.toyrobot.model.Position;

public abstract class Board {

  private int width;
  private int height;
  private int xLowerBound = 0;
  private int yLowerBound = 0;

  /**
   * A board object should have at least a height and width boundary defined.
   * @param width   The x boundary value of the board.
   * @param height  The y boundary value of the board.
   */
  public Board(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /**
   * By default, a board position will need to be within the bounds of the defined x,y co-ordinates.
   * If a passed in position exceeds the defined x,y boundary that is not a valid position.
   * @param position The position on the board being placed.
   * @return         True if a valid position on the board, false if not.
   */
  public boolean isValidPosition(Position position) {
    return position.xPosition >= xLowerBound && position.xPosition <= this.getWidth()
        && position.yPosition >= yLowerBound && position.yPosition <= this.getHeight();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
