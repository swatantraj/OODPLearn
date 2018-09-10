package com.creation.builder;

public class Computer {
	
	private int ram;
	private int storage;
	
	//optional
	private boolean isGamingMode;
	private boolean isCryptoSecure;
	private String floorLocation;

	public int getRam() {
		return ram;
	}
	public int getStorage() {
		return storage;
	}
	public boolean isGamingMode() {
		return isGamingMode;
	}
	public boolean isCryptoSecure() {
		return isCryptoSecure;
	}
	public String getFloorLocation() {
		return floorLocation;
	}

	private Computer(ComputerBuilder builder) {
		this.ram = builder.ram;
		this.storage = builder.storage;
		
		this.isGamingMode = builder.isGamingMode;
		this.isCryptoSecure= builder.isCryptoSecure;
		this.floorLocation = builder.floorLocation;
	}
	
	public static class ComputerBuilder {
		private int ram;
		private int storage;
		
		//optional
		private boolean isGamingMode;
		private boolean isCryptoSecure;
		private String floorLocation = "Storage_Room";
		
		public ComputerBuilder(int ram, int storage) {
			this.ram = ram;
			this.storage = storage;
		}
		
		public ComputerBuilder setGamingMode(boolean val) {
			this.isGamingMode = val;
			return this;
		}
		public ComputerBuilder setCryptoSecure(boolean val) {
			this.isCryptoSecure= val;
			return this;
		}
		public ComputerBuilder placeAt(String floorLoc) {
			this.floorLocation= floorLoc;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}

	}

}
