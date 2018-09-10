package com.creation.factory;

public class PC extends Computer{
	
	private int ram;
	private int storage;
	private float processor;

	public PC(int ram, int storage, float processor){
		this.ram = ram;
		this.storage = storage;
		this.processor = processor;
	}
	@Override
	public int getRam() {
		return this.ram;
	}

	@Override
	public int getStorage() {
		return this.storage;
	}

	@Override
	public float getProcessor() {
		return this.processor;
	}
	
	

}
