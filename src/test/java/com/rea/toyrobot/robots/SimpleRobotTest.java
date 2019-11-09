package com.rea.toyrobot.robots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.Test;

public class SimpleRobotTest {

  // Create a SimpleRobot placed in southwest corner, up one on the y axis.
  private int INITIAL_X_POS = 0;
  private int INITIAL_Y_POS = 1;
  private Direction INITIAL_DIRECTION = Direction.EAST;
  private SimpleRobot testSimpleRobot = new SimpleRobot(new Position(INITIAL_X_POS, INITIAL_Y_POS),
                                                        INITIAL_DIRECTION);

  @Test
  public void testRobotTransition() {
    // By default the position is EAST, so x should increment by 1.
    testSimpleRobot.transition();
    assertEquals(1, testSimpleRobot.getCurrentPosition().getXPosition());
    assertEquals(INITIAL_Y_POS, testSimpleRobot.getCurrentPosition().getYPosition());
    // Direction didn't change, robot should now be 2 positions to the east.
    testSimpleRobot.transition();
    assertEquals(2, testSimpleRobot.getCurrentPosition().getXPosition());
    assertEquals(INITIAL_Y_POS, testSimpleRobot.getCurrentPosition().getYPosition());

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
    // Test reporting after rotation.
    String expectedEastReportString = "0,1,EAST";
    assertEquals(expectedEastReportString, testSimpleRobot.report());

    String expectedWestReportString = "0,1,WEST";
    testSimpleRobot.rotate(Direction.WEST);
    assertEquals(expectedWestReportString, testSimpleRobot.report());

    // Test reporting after new placement. Rotation should be the same.
    String expectedNewPositionReportString = "1,3,WEST";
    testSimpleRobot.place(new Position(1,3), Direction.WEST);
    assertEquals(expectedNewPositionReportString, testSimpleRobot.report());
  }

  @Test
  public void testRobotPlace() {
    Position currentPosition = testSimpleRobot.getCurrentPosition();
    assertEquals(INITIAL_X_POS, currentPosition.getXPosition());
    assertEquals(INITIAL_Y_POS, currentPosition.getYPosition());
    assertEquals(INITIAL_DIRECTION, testSimpleRobot.getCurrentDirection());

    testSimpleRobot.place(new Position(1, 2), Direction.WEST);
    Position newPosition = testSimpleRobot.getCurrentPosition();
    assertEquals(1, newPosition.getXPosition());
    assertEquals(2, newPosition.getYPosition());
    assertEquals(Direction.WEST, testSimpleRobot.getCurrentDirection());
  }

}
