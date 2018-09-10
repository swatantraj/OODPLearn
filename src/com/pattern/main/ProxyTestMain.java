package com.pattern.main;

import com.structural.proxy.CommandExecutorProxy;

public class ProxyTestMain {

	public static void main(String[] args) {
		
		CommandExecutorProxy proxy = new CommandExecutorProxy("ADMIN", "admin");
		try {
			proxy.executeCmd(new String[]{"cmd", "/K", "start", "dir", " del c:/vc_red.log"});
//			proxy.executeCmd(new String[]{"cmd","/K","start","dir","rm SingletonTestMain1.java"});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
