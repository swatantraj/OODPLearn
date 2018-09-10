package com.creation.factory;

public abstract class Computer {
	int ram;
	int storage;
	float processor;
	/**
	 * @return the ram
	 */
	public abstract int getRam();
	/**
	 * @return the storage
	 */
	public abstract int getStorage();
	/**
	 * @return the processor
	 */
	public abstract float getProcessor();

	public String toString() {
		return "The CONFIG is RAM = " + getRam() + ", STORAGE = " + getStorage() + ", PROCESSOR = " + getProcessor(); 
	}
	
}
