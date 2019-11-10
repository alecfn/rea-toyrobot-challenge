package com.rea.toyrobot.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rea.toyrobot.Main;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ToyRobotGameIT {

  private static File happyPathData;
  private static File boundaryTestData;
  private static File badInputTestData;

  // Define lists of the output we expect to see when running test input through.
  private static final List<String> expectedHappyOutput = Arrays.asList("0,0,EAST", "1,0,EAST",
      "1,0,NORTH", "2,3,NORTH", "2,3,EAST", "Exiting Program.");
  private static final List<String> expectedBoundaryOutput = Arrays.asList(
      "That move would cause the robot to fall!", "0,0,SOUTH", "1,0,EAST", "Exiting Program.");
  private static final List<String> expectedBadOutput = Arrays.asList(
      "WEAST is not a valid direction.", "move is not a valid command.",
      "rotate is not a valid command.", "3,3,SOUTH", "Exiting Program.");

  private static final ByteArrayOutputStream stdOutContent = new ByteArrayOutputStream();

  @BeforeAll
  static void setupToyRobotGameITData() throws IOException {
    happyPathData = getTestFile("testdata/HappyPathTest.txt");
    boundaryTestData = getTestFile("testdata/BoundaryTest.txt");
    badInputTestData = getTestFile("testdata/BadInputTest.txt");
    System.setOut(new PrintStream(stdOutContent));
  }

  @Test
  void testHappyPathInput() throws FileNotFoundException {
    // Test sequences of commands by reading them into the program via setting the files as stdin.
    final FileInputStream testFileStream = new FileInputStream(happyPathData);
    System.setIn(testFileStream);
    Main.main(null);
    // Assert that stdout contains all the values from that we expect to see from these commands.
    assertStdOutContains(expectedHappyOutput);
  }

  @Test
  void testBoundaryInput() throws FileNotFoundException {
    final FileInputStream testFileStream = new FileInputStream(boundaryTestData);
    System.setIn(testFileStream);
    Main.main(null);
    assertStdOutContains(expectedBoundaryOutput);
  }

  @Test
  void testBadInput() throws FileNotFoundException {
    final FileInputStream testFileStream = new FileInputStream(badInputTestData);
    System.setIn(testFileStream);
    Main.main(null);
    assertStdOutContains(expectedBadOutput);
  }

  @AfterEach
  void clearStdout() {
    // Empty the test output so we don't have any data left over from previous tests.
    stdOutContent.reset();
  }

  private static void assertStdOutContains(List<String> expected) {
    for (String value : expected) {
      assertTrue(stdOutContent.toString().contains(value));
    }
  }

  private static File getTestFile(String fileName) {
    ClassLoader classLoader = ToyRobotGameIT.class.getClassLoader();
    return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
  }
}
