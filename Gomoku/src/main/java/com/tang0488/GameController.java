package com.tang0488;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class GameController {

	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	private GameState gameState = new GameState();

	@MessageMapping("/move")
	@SendTo("/topic/gameState")
	public GameMove processMove(GameMove move) {
		// 增加日志信息
		logger.info("Processing move: row = {}, column = {}", move.getRow(), move.getColumn());
		System.out.println("处理移动: 行 " + move.getRow() + ", 列 " + move.getColumn());

		// 处理游戏状态
		boolean isValidMove = gameState.makeMove(move.getRow(), move.getColumn(), "player1");
		if (!isValidMove) {
			logger.info("Invalid move: row = {}, column = {}", move.getRow(), move.getColumn());
			return null; // 或者返回一个表示无效移动的对象
		}

		// 假设每次移动都有效，并返回该移动
		return move;
	}
}
