package com.structural.proxy;

import java.io.IOException;

public class CommandExecutorProxy implements CommandExecutor {
	
	CommandExecutor executor;
	boolean valid;

	public CommandExecutorProxy(String user, String pass) {
		if(validateAdmin(user,pass)) {
			this.valid = validateAdmin(user,pass);
		}
			executor = new CommandExecutorImpl();
	}
	private boolean validateAdmin(String user, String pass) {
		if(user != null && pass != null) {
			if(user.equalsIgnoreCase("ADMIN") && pass.equals("admin")){
				return true;
			}
		}
		return false;
	}
	@Override
	public void executeCmd(String[] cmd) throws Exception {
		if(valid) {
			executor.executeCmd(cmd);
		}
		else {
			for(String c:cmd){
				if(c.trim().startsWith("del")) {
					System.out.println("NOT AUTHORIZED");
					return;
				}
			}				
				executor.executeCmd(cmd);
	}

	}

}
