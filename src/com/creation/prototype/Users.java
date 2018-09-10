package com.creation.prototype;

import java.util.ArrayList;
import java.util.List;

public class Users implements Cloneable{
	
	public List<String> userList;
	public Users() {
		userList = new ArrayList<String>();
	}
	
	public Users(List<String> list) {
		userList = list;
	}
	
	public void loadData() {
		userList.add("First");
		userList.add("Second");
		userList.add("Third");
		userList.add("Forth");
		userList.add("Fifth");
	}
	
	public List<String> getUserList() {
		return userList;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> tempUserList = new ArrayList<String>();
		for(String s:userList) {
			tempUserList.add(s);
		}
		return new Users(tempUserList);
	}

}
