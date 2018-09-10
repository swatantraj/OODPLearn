package com.pattern.main;

import com.creation.factory.Computer;
import com.creation.factory.FirstFactory;

public class FactoryTestMain {

	public static void main(String[] args) {
		
		Computer comp1;
		Computer comp2;
		FirstFactory factory = new FirstFactory();
		comp1 = factory.getComputer("PC", 8, 1024, 4.63f);
		System.out.println(comp1);
		comp2 = factory.getComputer("Server", 64, 9186, 7.23f);
		System.out.println(comp2);

	}

}
