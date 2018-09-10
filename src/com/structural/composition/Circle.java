package com.structural.composition;

public class Circle implements Shape{

	@Override
	public String draw(String color) {
		return "Drawing a CIRCLE with COLOR = " + color;
	}

}
