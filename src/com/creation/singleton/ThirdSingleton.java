package com.creation.singleton;

public enum ThirdSingleton {
	INSTANCE;
	public void doStuff() {
		System.out.println(ThirdSingleton.values());
	}
}
