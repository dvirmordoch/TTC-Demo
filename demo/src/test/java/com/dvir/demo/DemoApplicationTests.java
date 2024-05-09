package com.dvir.demo;

import com.dvir.demo.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testWinConditions() {
		// create a new game
		Game game = new Game();

		// test horizontal win condition
		game.makeMove(0, 0); // X
		game.makeMove(1, 0); // O
		game.makeMove(0, 1); // X
		game.makeMove(1, 1); // O
		assertEquals('-', game.checkWinner()); // no winner yet
		game.makeMove(0, 2); // X
		assertEquals('X', game.checkWinner()); // X wins horizontally

		// test vertical win condition
		game = new Game(); // reset the game
		game.makeMove(0, 0); // X
		game.makeMove(0, 1); // O
		game.makeMove(1, 0); // X
		game.makeMove(1, 1); // O
		assertEquals('-', game.checkWinner()); // no winner yet
		game.makeMove(2, 0); // X
		assertEquals('X', game.checkWinner()); // X wins vertically

		// test diagonal win condition
		game = new Game();
		game.makeMove(0, 0); // X
		game.makeMove(0, 1); // O
		game.makeMove(1, 1); // X
		game.makeMove(1, 0); // O
		assertEquals('-', game.checkWinner()); // no winner yet
		game.makeMove(2, 2); // X
		assertEquals('X', game.checkWinner()); // X wins diagonally
	}
}
