# REA Toy Robot Challenge

## Usage
A compiled JAR file is provided in the /target directory as 'toyrobot-1.0.jar'.  This can be run
through a terminal with:

    java -jar toyrobot-1.0.jar

The program will then wait for valid commands continuously until either an EXIT command is issued
or the program is interrupted.

Java 8 is required.

Valid commands are:

    PLACE X,Y,F 
    MOVE
    LEFT
    RIGHT
    REPORT
    
Where X is the x position on the board, Y is the y position  and F is the facing direction. 
A valid PLACE command must be run before any other commands will be accepted.
Invalid commands are ignored, including invalid values for X,Y and F.

Boards are currently only 5x5 grids, hence only 0-4 are acceptable X,Y commands, 0,0 being the
bottom left (southwest) corner of the grid. 

Acceptable directions are NORTH, SOUTH, EAST & WEST.
## Design
The application was designed with the intention of being extensible. As such, the following steps 
were taken during development:
### Commands
Commands are encapsulated via the command pattern. Additional commands can implement this interface
and their function determined in the relevant Robot object. Once support is added to recognise
the command in the CommandParser, the new command can be used easily.

Sanitisation of commands is performed in the CommandParser class. If a command is not an enumeration
in the Command enumeration, it is not valid. This avoids users being able to enter any possible 
string and facilitates feedback if the user enters something invalid.
### Robots
Robots inherit from an abstract Robot class, there currently being a single 'SimpleRobot' class.

This allows definition of custom Robot classes which behave differently to the default class. 
For example, a 'FastRobot' which moves two places at once could be defined by overriding the 
transition method and creating a new static transition class determining how it should behave.

### Boards 
As with Robots, we may want to define a board which is more complicated that a simple 5x5 grid
with no obstructions. As such all board objects inherit from an abstract Board object (currently 
just a SimpleBoard object is available). This allows the definition of boards with different 
dimensions, the addition of obstructions etc.

## Testing
The application was developed using TDD. That is, tests were written as the each class was created
as much as possible, following a 'bottom-up' approach. Essentially, lower level components such
as Robots, Boards and their associated tests were created first, working up to the entry point.

Test coverage is currently 100%. While not a perfect indication of program correctness, this helps
ensure that all parts of the program are tested in some way.

As this is a simple stdout/stdin in program, integration testing is performed by simulating user 
input using newline separated text files in the test resources/testdata directory. 
Test data is provided in these resources.

## Building
If necessary, a new build of the program can be created with maven. All tests will be run at 
compile time to ensure correctness. Simply run:

    mvn clean install