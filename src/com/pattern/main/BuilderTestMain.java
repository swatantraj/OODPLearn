package com.pattern.main;

import com.creation.builder.Computer;

public class BuilderTestMain {

	public static void main(String[] args) {

		Computer comp = new Computer.ComputerBuilder(8, 512).setCryptoSecure(false).setGamingMode(true)
				.placeAt("Second_Floor").build();
		System.out.println(comp);
		System.out.println(comp.isCryptoSecure() + " " + comp.isGamingMode() + " " + comp.getFloorLocation() + " END");
		Computer comp1 = new Computer.ComputerBuilder(8, 512).build();
		System.out.println(comp1);
		System.out
				.println(comp1.isCryptoSecure() + " " + comp1.isGamingMode() + " " + comp1.getFloorLocation() + " END");
	}
}
