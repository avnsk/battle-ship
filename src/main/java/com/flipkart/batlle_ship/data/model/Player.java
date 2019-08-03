package com.flipkart.batlle_ship.data.model;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
	
	private String id;
	private String name;
	private String email;
	private Board board;
	public static class PlayerBuilder {
		Board board = new Board(id);
	}

}
