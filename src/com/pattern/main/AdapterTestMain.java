package com.pattern.main;

import com.structural.adapter.SocketAdapter;
import com.structural.adapter.SocketAdapterImpl;
import com.structural.adapter.Volt;

public class AdapterTestMain {

	public static void main(String[] args) {
		testAdapter();
		System.out.println("XYZ volts using Object Adapter="+getVolt(new SocketAdapterImpl(), 12).getVolts());

	}

	private static void testAdapter() {
		
		SocketAdapter socket = new SocketAdapterImpl();			
		Volt v3 = socket.get3Volts();
		Volt v12 = socket.get12Volts();
		Volt v120 = socket.get120Volts();
		
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());
		
	}
	
	private static Volt getVolt(SocketAdapter soc, int i){
		switch(i) {
		case 3: return soc.get3Volts();
		case 12: return soc.get12Volts();
		case 120: return soc.get120Volts();
		default: return soc.get120Volts();
		}
		
		
	}

}
