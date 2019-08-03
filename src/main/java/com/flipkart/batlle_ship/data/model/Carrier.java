package com.flipkart.batlle_ship.data.model;

import lombok.Data;
@Data
public class Carrier extends Ship{
	
	public Carrier(String id, int length, Position startPosition, Position endPosition) {
		super(id, startPosition, endPosition);
		this.length = length;
		this.shipType = ShipType.Carrier;
		
	}
	private int length;
	private ShipType shipType;

}
