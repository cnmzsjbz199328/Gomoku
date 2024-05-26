package com.tang0488;

import java.util.HashMap;
import java.util.Map;

public class GameState {
    private Map<String, String> board;

    public GameState() {
        board = new HashMap<>();
    }

    public boolean makeMove(int row, int column, String player) {
        String key = row + "," + column;
        if (board.containsKey(key)) {
            return false; // 移动无效
        }
        board.put(key, player);
        return true; // 移动有效
    }

    public Map<String, String> getBoard() {
        return board;
    }
}
