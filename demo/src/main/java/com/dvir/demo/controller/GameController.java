package com.dvir.demo.controller;


import com.dvir.demo.model.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/game")
public class GameController {

    private final Game game;

    @Autowired
    public GameController(Game game) {
        this.game = game;
    }

    // endpoint to make a move
    @PostMapping("/move")
    public String makeMove(@RequestParam int row, @RequestParam int col) {
        log.info("request to make a move to row {} and col {}", row, col);
        if (game.makeMove(row, col)) {
            char winner = game.checkWinner();
            if (winner != '-') {
                return "Player " + winner + " wins!";
            } else if (game.isBoardFull()) {
                return "It's a draw!";
            } else {
                return "Move successful.";
            }
        } else {
            return "Invalid move. Please try again.";
        }
    }

    // endpoint to get the current state of the game board
    @GetMapping("/board")
    public char[][] getBoard() {
        log.info("got request to get current state of board");
        return game.getBoard();
    }

    // endpoint to reset the game
    @PostMapping("/reset")
    public String resetGame() {
        log.info("got request to reset game");
        game.reset(); // Reset the game board
        return "Game reset. Let's play again!";
    }
}

