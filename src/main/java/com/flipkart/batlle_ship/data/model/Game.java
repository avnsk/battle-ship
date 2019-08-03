package com.flipkart.batlle_ship.data.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Game {
	private String id;
	private List<Player> playerList;
	private int playerLimit;
	
	public Game(String id) {
		this.id = id;
		this.playerLimit = 2;
		this.playerList = new ArrayList<Player>(playerLimit);
	}
	
}
