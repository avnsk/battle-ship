package com.flipkart.batlle_ship.service;

import com.flipkart.batlle_ship.data.model.BoardState;
import com.flipkart.batlle_ship.data.model.Player;
import com.flipkart.batlle_ship.data.model.Position;
import com.flipkart.batlle_ship.data.model.Ship;

public class PlayerServiceImpl {
	public String placeShipToBoard(Player p , Ship ship) {
		String returnMessage = "";
		BoardState[][] boardState = p.getBoard().getGameBoard();
		boolean flag = isPositionSafeToPlaceShip(boardState, ship);
		if(flag) {
			populateShipForBoard(boardState, ship);
			returnMessage = "Ship Placed succesfully";
		}else {
			returnMessage = "Ship cannot be placed in these postion";
		}
		return returnMessage;
	}

	private void populateShipForBoard(BoardState[][] boardState, Ship ship) {
		Position start = ship.getStartPosition();
		Position end = ship.getEndPosition();
		int counter = 0;
		if(start.getX() == end.getX()) {
			int x = start.getX();
			int y1 = start.getY();
			int y2 = end.getY();
			counter = y1 > y2 ? -1 : 1;
			int i = y1;
			
			while(i != y2) {
				boardState[x][i] = BoardState.SHIP;
					i += counter;
				}
			
		} else {
				int y = start.getY();
				int x1 = start.getX();
				int x2 = end.getX();
				counter = x1 > x2 ? -1 : 1;
				int i = x1;
				
				while(i != x2) {
					boardState[i][y] = BoardState.SHIP;
				    i += counter;
				    }
			}
		
	}

	private boolean isPositionSafeToPlaceShip(BoardState[][] boardState, Ship ship) {
		Position start = ship.getStartPosition();
		Position end = ship.getEndPosition();
		int counter = 0;
		if(start.getX() == end.getX()) {
			int x = start.getX();
			int y1 = start.getY();
			int y2 = end.getY();
			counter = y1 > y2 ? -1 : 1;
			int i = y1;
			
			while(i != y2) {
				if(boardState[x][i] == BoardState.EMPTY) {
					i += counter;
				}else {
					return false;
				}
			}
			
		} else {
				int y = start.getY();
				int x1 = start.getX();
				int x2 = end.getX();
				counter = x1 > x2 ? -1 : 1;
				int i = x1;
				
				while(i != x2) {
					if(boardState[i][y] == BoardState.EMPTY) {
						i += counter;
					}else {
						return false;
					}
				}
				
			
		}
		
		
		
		return true;
	}
}
