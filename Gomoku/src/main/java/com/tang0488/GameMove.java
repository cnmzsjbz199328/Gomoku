package com.tang0488;

public class GameMove {
    private int row;
    private int column;
    private char playerSymbol;

    public GameMove() {
    }

    public GameMove(int row, int column, String playerSymbol) {
        this.row = row;
        this.column = column;
        this.playerSymbol = playerSymbol.charAt(0);
    }

    // Getter and Setter methods
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
