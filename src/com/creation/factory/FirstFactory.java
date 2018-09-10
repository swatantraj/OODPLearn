package com.creation.factory;

public class FirstFactory {
	
	public static Computer getComputer(String type, int r, int s, float p){
		if(type.equalsIgnoreCase("PC")) {
			return new PC(r, s, p);
		}
		else if (type.equalsIgnoreCase("SERVER")) {
			return new Server(r, s, p);
		}
		else {
			System.out.println("INVALID TYPE");
			return null;
		}
	}
	
}
