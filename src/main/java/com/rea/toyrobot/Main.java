package com.rea.toyrobot;

import com.rea.toyrobot.commands.CommandParser;
import com.rea.toyrobot.commands.MoveCommand;
import com.rea.toyrobot.model.Game;
import java.util.Scanner;

public class Main {


  private static final String EXIT_COMMAND = "EXIT";
  /**
   * Program entry point. Reads in all commands from stdin while the program is running.
   * @param args Arguments supplied.
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    CommandParser commandParser = new CommandParser();
    Game game = new Game();
    commandParser.addCommand(new MoveCommand(game));
    commandParser.executeGameCommands();

    System.out.println();

    while (true) {
      String command = scanner.next();

      // Just a basic exit case for now.
      if (command.equalsIgnoreCase(EXIT_COMMAND)) {
        System.out.println("Exiting Program.");
        break;
      }
    }
  }

}
