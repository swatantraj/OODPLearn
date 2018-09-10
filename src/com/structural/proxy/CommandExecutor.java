package com.structural.proxy;

import java.io.IOException;

public interface CommandExecutor {
	
	public void executeCmd(String[] cmd) throws Exception;

}
