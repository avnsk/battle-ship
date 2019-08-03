package com.flipkart.batlle_ship.util;

public class BoradUtil {
	public static boolean isWithinBoundary(int x , int y) {
		if(x < 10 && x >= 0 && y < 10 && y >= 0) {
			return true;
		}
		return false;
	}
}
