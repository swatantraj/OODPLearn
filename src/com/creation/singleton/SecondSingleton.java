package com.creation.singleton;

import java.io.Serializable;

public class SecondSingleton implements Cloneable,Serializable{
	
	private static final long serialVersionUID = 2466286142169617053L;
	private static SecondSingleton secondSingleton;
	
	private SecondSingleton(){};
	
	public static SecondSingleton getInstance() {
		if(null == secondSingleton) {
			synchronized (SecondSingleton.class) {
				if(null == secondSingleton) {
					secondSingleton = new SecondSingleton();
				}
			}
		}
		return secondSingleton;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
//		return super.clone();
		return secondSingleton;
//		throw new CloneNotSupportedException("Singleton Class handling Cloning");

	}
	
	protected Object readResolve() {
		return secondSingleton;
	}
}
