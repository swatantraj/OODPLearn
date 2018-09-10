package com.structural.adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volts() {
		return getVolt();
	}

	@Override
	public Volt get12Volts() {
		return convertTo(getVolt(),10);
	}

	@Override
	public Volt get3Volts() {
		return convertTo(getVolt(),40);
	}

	private Volt convertTo(Volt volt, int i) {
		volt.setVolts(volt.getVolts()/i);
		return volt;
	}
}
