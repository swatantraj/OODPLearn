package com.pattern.main;

import java.util.List;

import com.creation.prototype.Users;

public class PrototypeTestMain {

	public static void main(String [] args) throws CloneNotSupportedException {
		Users user = new Users();
		user.loadData();
		
		Users user1 = (Users) user.clone();
		Users user2 = (Users) user.clone();
		
		List<String> list1 = user1.getUserList();
		list1.remove("First");
		List<String> list2 = user2.getUserList();
		list2.add("Eighth");
		System.out.println("Users List" + user.getUserList());
		System.out.println("User1 List" + user1.getUserList());
		System.out.println("User2 List" + user2.getUserList());
		
	}
}
