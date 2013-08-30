package yossi.web;

import java.util.Calendar;
import java.util.Date;

public class ChatMessage {
	public Date 		datetime;
	public String 		from;
	public String		message;
	
	public ChatMessage(String from, String msg) {
		datetime = Calendar.getInstance().getTime();
		this.from = from;
		this.message = msg;
	}
}
