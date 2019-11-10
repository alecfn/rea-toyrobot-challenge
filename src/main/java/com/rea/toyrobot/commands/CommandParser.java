package com.rea.toyrobot.commands;

import static com.rea.toyrobot.enums.Command.LEFT;
import static com.rea.toyrobot.enums.Command.MOVE;
import static com.rea.toyrobot.enums.Command.PLACE;
import static com.rea.toyrobot.enums.Command.REPORT;
import static com.rea.toyrobot.enums.Command.RIGHT;

import com.rea.toyrobot.enums.Command;
import com.rea.toyrobot.enums.Direction;
import com.rea.toyrobot.model.Game;
import com.rea.toyrobot.model.Position;
import com.rea.toyrobot.model.Rotate;
import java.util.HashMap;

/**
 * This class is the Invoker in the command pattern.
 * It maintains a reference to the possible commands and runs their execution for each.
 * Sanitisation is also performed by ensuring commands are valid in the Command enumeration.
 */
public class CommandParser {
  private final HashMap<String, Command> gameCommands = new HashMap<>();
  private static final String PLACE_COMMAND_STRING = "PLACE";
  private static final String MOVE_COMMAND_STRING = "MOVE";
  private static final String LEFT_COMMAND_STRING = "LEFT";
  private static final String RIGHT_COMMAND_STRING = "RIGHT";
  private static final String REPORT_COMMAND_STRING = "REPORT";

  private final Game game;
  private boolean robotIsPlaced;

  public CommandParser(Game game) {
    this.game = game;
    robotIsPlaced = false;
    // Represent input strings by mapping them to the relevant command enumeration.
    gameCommands.put(PLACE_COMMAND_STRING, PLACE);
    gameCommands.put(MOVE_COMMAND_STRING, MOVE);
    gameCommands.put(LEFT_COMMAND_STRING, LEFT);
    gameCommands.put(RIGHT_COMMAND_STRING, RIGHT);
    gameCommands.put(REPORT_COMMAND_STRING, REPORT);
  }

  /**
   * Add the command to a list of commands to execute, provided it is a valid command,
   * i.e. it is in the Command enumeration class. This acts as sanitisation of commands as
   * anything that is not a defined command will return null from the HashMap of operations.
   * @param commandString The command input from the user, split by a new line.
   */
  public void executeCommand(String commandString) {
    try {
      Command command = gameCommands.get(commandString);
      // PLACE commands contain different variables so check that input matches the correct pattern.
      if (commandString.matches("PLACE [0-9],[0-9],[A-Z]{4,5}")) {
        command = gameCommands.get(PLACE_COMMAND_STRING);
        robotIsPlaced = true;
      }
      if (!robotIsPlaced) {
        System.out.println("A valid PLACE command must run before any other commands.");
        return;
      }

      GameOperation operation = null;
      switch (command) {
        case PLACE:
          // PLACE commands have additional parameters which need to be extracted from the string.
          String[] placeCommands = extractPlaceCommands(commandString);
          // As we know the PLACE command is in the correct format we can access by index.
          Position position = parsePlaceCommandPosition(placeCommands[1], placeCommands[2]);
          Direction direction = parseDirectionCommand(placeCommands[3]);
          operation = new PlaceCommand(game, position, direction);
          break;
        case MOVE:
          operation = new MoveCommand(game);
          break;
        case LEFT:
        case RIGHT:
          operation = new RotateCommand(game,
              Rotate.determineNewRotation(game.getPlayerRobot().getCurrentDirection(), command));
          break;
        case REPORT:
          operation = new ReportCommand(game);
          break;
      }
      executeGameCommand(operation);
      // A NullPointer will be thrown if the command does not exist in the command enumeration.
    } catch (NullPointerException e) {
      System.out.println(commandString + " is not a valid command.");
    }
  }

  /**
   * Execute all input commands via command objects after they are parsed.
   */
  private void executeGameCommand(GameOperation operation) {
    operation.execute();
  }

  private String[] extractPlaceCommands(String placeCommandString){
    return placeCommandString.split("\\s+|,");
  }

  private Position parsePlaceCommandPosition(String xPosition, String yPosition) {
    return new Position(Integer.parseInt(xPosition), Integer.parseInt(yPosition));
  }

  private Direction parseDirectionCommand(String placeCommandDirection) {
    return Enum.valueOf(Direction.class, placeCommandDirection);
  }
}
