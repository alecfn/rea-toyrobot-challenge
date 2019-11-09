package com.rea.toyrobot.robots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.Test;

public class SimpleRobotTest {

  // Create a SimpleRobot placed in southwest corner, up one on the y axis.
  private int INITIAL_X_POS = 0;
  private int INITIAL_Y_POS = 1;
  private SimpleRobot testSimpleRobot = new SimpleRobot(new Position(INITIAL_X_POS, INITIAL_Y_POS),
                                                        Direction.EAST);

  @Test
  public void testRobotTransition() {

  }

  @Test
  public void testRobotPlacement() {

  }

  @Test
  public void testRobotRotation() {

    testSimpleRobot.rotate(Direction.WEST);
    assertEquals(Direction.WEST, testSimpleRobot.getCurrentDirection());
    testSimpleRobot.rotate(Direction.NORTH);
    assertEquals(Direction.NORTH, testSimpleRobot.getCurrentDirection());
    testSimpleRobot.rotate(Direction.SOUTH);
    assertEquals(Direction.SOUTH, testSimpleRobot.getCurrentDirection());
    testSimpleRobot.rotate(Direction.EAST);
    assertEquals(Direction.EAST, testSimpleRobot.getCurrentDirection());
  }

  @Test
  public void testRobotReport() {
    String expectedReportString = "0,1,EAST";
    assertEquals(expectedReportString, testSimpleRobot.report());
    testSimpleRobot.rotate(Direction.WEST);
    expectedReportString = "0,1,WEST";
    assertEquals(expectedReportString, testSimpleRobot.report());
  }

  @Test
  public void testRobotPlace() {
    Position currentPosition = testSimpleRobot.getCurrentPosition();
    assertEquals(INITIAL_X_POS, currentPosition.getXPosition());
    assertEquals(INITIAL_Y_POS, currentPosition.getYPosition());

    testSimpleRobot.place(new Position(1, 2));
    Position newPosition = testSimpleRobot.getCurrentPosition();
    assertEquals(1, newPosition.getXPosition());
    assertEquals(2, newPosition.getYPosition());
  }

}
