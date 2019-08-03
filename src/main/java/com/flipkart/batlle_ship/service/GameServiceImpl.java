package com.flipkart.batlle_ship.service;

import java.util.List;

import com.flipkart.batlle_ship.data.model.BoardState;
import com.flipkart.batlle_ship.data.model.Game;
import com.flipkart.batlle_ship.data.model.Player;
import com.flipkart.batlle_ship.data.model.Position;
import com.flipkart.batlle_ship.util.BoradUtil;

public class GameServiceImpl {
	public String addPlayer(Game game , Player p) {
		String returnMessage = "";
		if(game.getPlayerList().size() >= game.getPlayerLimit()) {
			returnMessage = "Max allowed player limit reached for the game";
		}else {
			game.getPlayerList().add(p);
			returnMessage = "Player succesfully added to the game";
		}
		
		return returnMessage;
	}
	
	public BoardState hitShipOfOtherPlayer(Player p , Position pos, Game game) {
		Player opp = getOpponentPlayer(p, game);
		BoardState[][] b = getBoardOfOpponent(p, game);
		if(BoradUtil.isWithinBoundary(pos.getX(), pos.getY())) {
			if(b[pos.getX()][pos.getY()] == BoardState.SHIP) {
				b[pos.getX()][pos.getY()] = BoardState.HIT;
				opp.getBoard().setGameBoard(b);
				return BoardState.HIT;
			}
		}
		
		return BoardState.MISS;
	}

	private Player getOpponentPlayer(Player player, Game game) {
		List<Player> playerList = game.getPlayerList();
		for(Player p : playerList) {
			if(p.getId() != player.getId()) {
				return p;
			}
		}
		return null;
	}

	private BoardState[][] getBoardOfOpponent(Player player, Game game) {
		List<Player> playerList = game.getPlayerList();
		for(Player p : playerList) {
			if(p.getId() != player.getId()) {
				return p.getBoard().getGameBoard();
			}
		}
		return null;
	}
	
	public boolean hasPlayerWon(Player player, Game game) {
		BoardState[][] b = getBoardOfOpponent(player, game);
		for(int i = 0 ; i < b.length ; i++) {
			for(int j = 0 ; j < b[0].length; j++) {
				BoardState bs = b[i][j];
				if(bs == BoardState.SHIP) {
					return false;
				}
			}
			
		}
		
		return true;
		
	}
	
	public BoardState[][] getStateOfOthePlayerBoard(Player player, Game game) {
		BoardState[][]  bs = new BoardState[10][10];
		BoardState[][] b = getBoardOfOpponent(player, game);
		for(int i = 0 ; i < b.length ; i++) {
			for(int j = 0 ; j < b[0].length; j++) {
				if(b[i][j] == BoardState.HIT || b[i][j] == BoardState.MISS) {
					bs[i][j] = b[i][j];
				}else {
					bs[i][j] = BoardState.EMPTY;
				}
			}
			
			
	}
		return bs;
}
}
