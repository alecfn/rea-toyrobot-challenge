package com.rea.toyrobot.boards;

public class SimpleBoard extends Board {

  // Define the lower bounds of the axis, assuming they cannot be lower than 0 in any instance.
  private int xLowerBound = 0;
  private int yLowerBound = 0;

  /**
   * {@inheritDoc}
   *
   * A SimpleBoard defines a board with a simple x,y boundary and no obstructions.
   */
  public SimpleBoard(int width, int height) {
    super(width, height);
  }

  /**
   * If a passed in position exceeds the defined x,y boundary that is not a valid position.
   * @param position The position on the board being placed.
   * @return         True if a valid position on the board, false if not.
   */
  @Override
  public boolean isValidPosition(Position position) {
    return position.xPos >= xLowerBound && position.xPos <= this.getWidth()
        && position.yPos >= yLowerBound && position.yPos <= this.getHeight();
  }
}
