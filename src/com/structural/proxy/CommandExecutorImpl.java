package com.structural.proxy;

import java.io.IOException;

public class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void executeCmd(String[] cmd) throws IOException {
		System.out.println("Trying to execute CMD = "+cmd);
		Runtime runTime = Runtime.getRuntime();
//		runTime.exec(new String[] {"cmd", "/K", "Start", "dir"});
//		runTime.exec("cmd /c start cmd.exe /K \"dir && ping localhost\"");
		runTime.exec(cmd);
		
		System.out.println("Execution complete of CMD = "+cmd);

	}

}
