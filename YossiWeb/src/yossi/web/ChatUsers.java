package yossi.web;

import java.util.HashMap;

public class ChatUsers {
	protected static HashMap<String,ChatUser> users = new HashMap<String,ChatUser>();

	public static void addUser(String name) {
		if(users.get(name)==null) {
			users.put(name, new ChatUser(name));
		}
	}
	
	public static void removeUser(String name) {
		users.remove(name);
	}
	
	public static ChatUser getUser(String name) {
		return users.get(name);
	}
	
	public static String[] getUsers() {
		String[] userList = new String[1];
		return users.keySet().toArray(userList);
	}
	
}
