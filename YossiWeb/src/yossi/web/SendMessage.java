package yossi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yossi.web.ChatUser;


/**
 * Servlet implementation class ChatRouter
 */
@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessage() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);
	    
	    String username = (String)session.getAttribute("username");
	    if(username!=null) {
	    	String msgValue = request.getParameter("msg");
	    	String talkTo = request.getParameter("talkTo");
	    	ChatUser user = ChatUsers.getUser(talkTo);
	    	if(user!=null) {
	    		ChatMessage msg = new ChatMessage(username, msgValue);
		    	user.handleMessage(msg);
		    	response.sendRedirect("chat.jsp");
	    	} else {
	    		response.sendRedirect("login.jsp");
	    	}
	    } else {
	    	response.sendRedirect("login.jsp");
	    	
	    }
	    
	}

}
