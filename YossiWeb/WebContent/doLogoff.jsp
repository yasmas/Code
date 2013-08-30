<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ page import="yossi.web.ChatUsers" %>
<%
	if (session.getAttribute("username") != null) {
		String username =(String)session.getAttribute("username");
		ChatUsers.removeUser(username);
	}
	session.invalidate();
	response.sendRedirect("login.jsp");
%>
