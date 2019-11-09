package com.rea.toyrobot.robots;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Position;

/**
 * A concrete implementation of the most basic robot type, implementing only default behaviour.
 */
public class SimpleRobot extends Robot {

  /**
   * {@inheritDoc}
   *
   * Defines a basic robot with an initial position and direction as defined by a PLACE command.
   */
  public SimpleRobot(Position position, Direction direction) {
    super(position, direction);
  }
}
