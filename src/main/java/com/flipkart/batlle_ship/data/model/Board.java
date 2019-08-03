package com.flipkart.batlle_ship.data.model;

import java.util.Arrays;

import lombok.Data;

@Data
public class Board {
	private BoardState[][] gameBoard;
	
	private String playerId;

	public Board(String playerId) {
		gameBoard = new BoardState[10][10];
		for(int i = 0 ; i < 10 ; i++) {
			Arrays.fill(gameBoard[i], BoardState.EMPTY);
		}
		this.playerId = playerId;
	}
	
}
