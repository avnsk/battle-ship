package com.flipkart.batlle_ship.data.model;

import lombok.Data;

@Data
public class Cruiser extends Ship{
	public Cruiser(String id, int length, Position startPosition, Position endPosition) {
		super(id, startPosition, endPosition);
		this.length = length;
		this.shipType = ShipType.Cruiser;
		
	}
	private int length;
	private ShipType shipType;

}
