package com.flipkart.batlle_ship.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract public class Ship {
	private String id;
	Position startPosition;
	Position endPosition;
}
