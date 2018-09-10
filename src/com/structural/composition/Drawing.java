package com.structural.composition;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

	List<Shape> shapes = new ArrayList<Shape>();
	
	@Override
	public String draw(String color) {
		StringBuilder result = new StringBuilder(); 
		for(Shape s: shapes) {
			result.append(s.draw(color).toString());
			result.append("\n");
		}
		return result.toString();
	}
	
	public void add(Shape s) {
		this.shapes.add(s);
	}

	public void remove(Shape s) {
		this.shapes.remove(s);
	}
	
	public void clear() {
		System.out.println("CLEARING all the drawn shapes");
		this.shapes.clear();
	}
}
