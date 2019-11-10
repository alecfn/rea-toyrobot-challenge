package com.rea.toyrobot.commands;

import static com.rea.toyrobot.commands.TestCommandConstants.TEST_LEFT_COMMAND;
import static com.rea.toyrobot.commands.TestCommandConstants.TEST_MOVE_COMMAND;
import static com.rea.toyrobot.commands.TestCommandConstants.TEST_PLACE_COMMAND;
import static com.rea.toyrobot.commands.TestCommandConstants.TEST_REPORT_COMMAND;
import static com.rea.toyrobot.commands.TestCommandConstants.TEST_RIGHT_COMMAND;
import static com.rea.toyrobot.model.TestGameConstants.DEFAULT_UPPER_BOUND;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rea.toyrobot.model.Game;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CommandParserTest {

  // Some tests need to check stdout for correctness.
  private ByteArrayOutputStream stdoutOutput = new ByteArrayOutputStream();

  private static Game testGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
  private static CommandParser testCommandParser = new CommandParser(testGame);

  @Test
  void testExecuteCommand() {
    // Test running a couple of commands in sequence.
    testCommandParser.executeCommand(TEST_PLACE_COMMAND);
    assertEquals("0,0,EAST",testGame.getPlayerRobot().report());

    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("1,0,EAST", testGame.getPlayerRobot().report());

    // Test running a few commands at once.
    testCommandParser.executeCommand(TEST_LEFT_COMMAND);
    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    testCommandParser.executeCommand(TEST_RIGHT_COMMAND);
    testCommandParser.executeCommand(TEST_REPORT_COMMAND);
    assertEquals("1,1,EAST", testGame.getPlayerRobot().report());
  }

  @Test
  void testPlaceMustBeRunFirst() {
    // Separate instances to simulate a new instance of the simulator.
    Game newTestGame = new Game(DEFAULT_UPPER_BOUND, DEFAULT_UPPER_BOUND);
    CommandParser newTestParser = new CommandParser(newTestGame);

    // Position and direction should be null until a place command is issued.
    newTestParser.executeCommand(TEST_MOVE_COMMAND);
    newTestParser.executeCommand(TEST_RIGHT_COMMAND);
    newTestParser.executeCommand(TEST_LEFT_COMMAND);
    assertNull(newTestGame.getPlayerRobot().getCurrentDirection());
    assertNull(newTestGame.getPlayerRobot().getCurrentPosition());

    newTestParser.executeCommand(TEST_PLACE_COMMAND);
    newTestParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("1,0,EAST", newTestGame.getPlayerRobot().report());
  }

  @Test
  void testPlaceCannotPlaceRobotOutsideBounds() {
    // PLACE commands should not be valid if they are outside the board bounds.
    testCommandParser.executeCommand(TEST_PLACE_COMMAND);
    testCommandParser.executeCommand("PLACE 10,10,NORTH");
    assertEquals("0,0,EAST", testGame.getPlayerRobot().report());
  }

  @Test
  void testRobotCannotFall() {
    // Test instances where the robot may fall, along the bottom, top, left and right of the board.

    // This command will send the robot out of bottom bounds, it should stay in place.
    testCommandParser.executeCommand("PLACE 0,0,SOUTH");
    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("0,0,SOUTH", testGame.getPlayerRobot().report());

    // Now try going out of the left bound.
    testCommandParser.executeCommand("RIGHT");
    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("0,0,WEST", testGame.getPlayerRobot().report());

    // Top bound.
    testCommandParser.executeCommand("PLACE 4,4,NORTH");
    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("4,4,NORTH", testGame.getPlayerRobot().report());

    // Right bound.
    testCommandParser.executeCommand("RIGHT");
    testCommandParser.executeCommand(TEST_MOVE_COMMAND);
    assertEquals("4,4,EAST", testGame.getPlayerRobot().report());
  }

  @Test
  void testInvalidCommandsIgnored() {
    System.setOut(new PrintStream(stdoutOutput));
    // Create a list of commands that would be invalid and test they print invalid command.
    // This is a little messy because we are printing to stdout.
    List<String> invalidCommands = Arrays.asList("Invalid Command", "PLACE somewhere", "move",
                                                 "up", "pLaCe", "0,0 ROTATE");

    for (String command: invalidCommands) {
      String expectedOutput = command + " is not a valid command.";
      testCommandParser.executeCommand(command);
      String stdOut = stdoutOutput.toString();
      // As we print to stdout line separators may be added by the system, so check contains.
      assertTrue(stdOut.contains(expectedOutput));
    }
  }
}
