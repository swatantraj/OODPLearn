package com.creation.singleton;

public class FirstSingleton {
	
	private FirstSingleton(){};
	
	private static FirstSingleton instance;
	
	private int i = 1;
	private static int j;
	
	public int getJ(){
		System.out.println("j= " + j + " i=" + i);
		i++;
		return j;
	}
	
	public static synchronized FirstSingleton getInstance() {
		if(instance == null) {
			instance = new FirstSingleton();
		}
		j++;
		return instance;
	}
	
}
