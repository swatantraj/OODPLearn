package com.pattern.main;

import com.structural.composition.Circle;
import com.structural.composition.Drawing;
import com.structural.composition.Polygon;
import com.structural.composition.Shape;
import com.structural.composition.Triangle;

public class CompositionTestMain {
	public static void main (String args[]) {
		
		Shape circle = new Circle();
		Shape tri = new Triangle();
		Shape poly = new Polygon();
		Shape tri1 = new Triangle();
		
		Drawing drawing = new Drawing();
		
		drawing.add(circle);
		drawing.add(tri);
		drawing.add(poly);
		drawing.add(tri1);
		System.out.println(drawing.draw("BLUE"));
		drawing.remove(tri1);
		System.out.println(drawing.draw("GREEN"));
		drawing.clear();
		drawing.add(tri);
		drawing.add(poly);
		System.out.println(drawing.draw("ORANGE"));
	}

}
