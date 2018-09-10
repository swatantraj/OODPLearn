package com.structural.composition;

public class Triangle implements Shape {

	@Override
	public String draw(String color) {
		return "Drawing a TRIANGLE with COLOR = " + color;
	}

}
