package com.bizzlers.foundation.platform;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Business business = new Business();
		
		int bid[]={0};
		bid = business.getBusinessIds(7);
		String print = business.intArrayToString(bid);
		System.out.print("Hello");
		System.out.print(print);
		
	}

}
