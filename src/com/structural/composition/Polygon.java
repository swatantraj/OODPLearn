package com.structural.composition;

public class Polygon implements Shape {

	@Override
	public String draw(String color) {
		return "Drawing a POLYGON with COLOR = " + color;
	}

}
