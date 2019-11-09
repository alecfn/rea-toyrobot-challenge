package com.rea.toyrobot.boards;

/**
 * Implementation of the most basic board type with default behaviour, with a simple height/width
 * boundary and no obstructions.
 */
public class SimpleBoard extends Board {

  /**
   * {@inheritDoc}
   *
   * A SimpleBoard defines a board with a simple x,y boundary and no obstructions.
   */
  public SimpleBoard(int width, int height) {
    super(width, height);
  }

}
