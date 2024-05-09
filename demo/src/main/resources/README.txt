How to run:
Open terminal and run the following command: java -jar Documents/demo-0.0.1-SNAPSHOT.jar
After the server is up, use Postman according to the flow below.

- Basic Flow -

Initializing the Game:
A new game instance is created with an empty board and 'X' as the default player.
Player Makes a Move:
Client sends a POST request to /api/game/move with move coordinates.
GameController delegates to GameService to update the board and check for win/draw.
Server responds with game status or confirmation.

Getting Current Game State:
Client sends a GET request to /api/game/board to fetch the current board state.
GameController responds with the board state.

Resetting the Game:
Client sends a POST request to /api/game/reset to reset the game after a win or draw.
GameController delegates to GameService to reset the board and confirms reset.

- Game Structure and Entities -

Game Class (Model): Represents the game state, including the board, current player, and logic methods.
GameController (Controller): Handles HTTP requests and forwards them to the service methods.
GameService (Service): Contains game logic, interacts with the model, and performs game operations.