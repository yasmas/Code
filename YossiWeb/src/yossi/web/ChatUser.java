package yossi.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import yossi.web.ChatMessage;

public class ChatUser {
	protected String name;
	protected HashMap<String, ArrayList<ChatMessage>> chats = new HashMap<String, ArrayList<ChatMessage>>(); 
	
	public ChatUser(String name) {
		this.name = name;
	}
	
	public void handleMessage(ChatMessage msg) {
		System.out.format("[%s] Recieved: %s\n", name, msg.message);
		
		ArrayList<ChatMessage> stream = chats.get(msg.from);
		if(stream==null) {
			stream = new ArrayList<ChatMessage>();
			chats.put(msg.from,stream);
		}
		
		stream.add(0, msg);
	}
	
	public String formatMessages(String from) {
		ArrayList<ChatMessage> stream = chats.get(from);
		
		if(stream!=null) {
			DateFormat df = new SimpleDateFormat("HH:mm:ss");
			String buffer = "<table>\n";
			
			for(ChatMessage msg: stream) {
				buffer += "<tr>\n";
				buffer += "<td>" + df.format(msg.datetime) + "</td>\n";
				buffer += "<td>" + msg.message + "</td>\n";
				buffer += "</tr>\n";
			}
			buffer += "</table><br>";
			
			return buffer;
		} else {
			return "No messages!<br>";
		}
	}
}
