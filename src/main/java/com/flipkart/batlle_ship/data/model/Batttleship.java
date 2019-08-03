package com.flipkart.batlle_ship.data.model;

import lombok.Data;

@Data
public class Batttleship extends Ship{
	public Batttleship(String id, int length, Position startPosition, Position endPosition) {
		super(id, startPosition, endPosition);
		this.length = length;
		this.shipType = ShipType.Battleship;
		
	}
	private int length;
	private ShipType shipType;
}
