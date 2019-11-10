package com.rea.toyrobot.commands;

import static com.rea.toyrobot.model.TestGameConstants.DEFAULT_UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReportCommandTest {

  private static Game testGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
  private ReportCommand testReportCommand = new ReportCommand(testGame);

  @BeforeAll
  static void setupGame() {
    testGame.getPlayerRobot().place(new Position(0, 0), Direction.EAST);
  }

  @Test
  void testReportCommand() {
    // As the report command is issued, the value of the report should reflect the robot position.
    final String expectedReportCommand = "0,0,EAST";
    testReportCommand.execute();
    assertEquals(expectedReportCommand, testGame.getPlayerRobot().report());

    testGame.getPlayerRobot().place(new Position(5,5), Direction.NORTH);
    final String nextExpectedReportCommand = "5,5,NORTH";
    testReportCommand.execute();
    assertEquals(nextExpectedReportCommand, testGame.getPlayerRobot().report());

  }
}
