package com.dvir.demo.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Game {
    @Getter
    private final char[][] board;
    private char currentPlayer;

    public Game() {
        // initialize the game board
        board = new char[3][3];
        currentPlayer = 'X'; // player 'X' starts the game
        initializeBoard();
    }

    // initialize the game board with empty cells
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // make a move on the game board
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            return false; // Invalid move
        }

        // set the current player's symbol on the board
        board[row][col] = currentPlayer;

        // switch to the next player
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

        return true; // move successful
    }

    // check if the game has a winner
    public char checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0];
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2];
        }

        // if no winner yet
        return '-';
    }

    // check if the game board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // empty cell found
                }
            }
        }
        return true; // board is full
    }

    // reset the game board
    public void reset() {
        initializeBoard();
        currentPlayer = 'X';
    }
}

