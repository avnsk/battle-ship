package com.flipkart.batlle_ship.data.model;

import lombok.Data;

@Data
public class Submarine extends Ship {
	
	public Submarine(String id, int length, Position startPosition, Position endPosition) {
		super(id, startPosition, endPosition);
		this.length = length;
		this.shipType = ShipType.Submarine;
		
	}
	private int length;
	private ShipType shipType;

}
