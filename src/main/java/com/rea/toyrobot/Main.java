package com.rea.toyrobot;

import com.rea.toyrobot.commands.CommandParser;
import com.rea.toyrobot.model.Game;
import java.util.Scanner;

public class Main {

  private static final String EXIT_COMMAND_STRING = "EXIT";
  private static final Game game = new Game();

  /**
   * Program entry point. Reads in all commands from stdin while the program is running.
   * @param args Arguments supplied.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    CommandParser commandParser = new CommandParser(game);

    while (true) {
      String command = scanner.nextLine();
      // Just a basic exit case for now.
      if (command.equalsIgnoreCase(EXIT_COMMAND_STRING)) {
        System.out.println("Exiting Program.");
        break;
      }
      commandParser.executeCommand(command);
    }
  }
}
