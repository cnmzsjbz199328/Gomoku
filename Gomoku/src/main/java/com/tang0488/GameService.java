package com.tang0488;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private char[][] board = new char[15][15];
    private char currentPlayer = 'X';

    public GameService() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public GameMove processMove(GameMove move) throws Exception {
        if (board[move.getRow()][move.getColumn()] == ' ') {
            board[move.getRow()][move.getColumn()] = move.getPlayerSymbol().charAt(0);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            throw new Exception("Invalid move");
        }
        return move;
    }
}