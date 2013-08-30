<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="yossi.web.ChatUsers" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
  if (session.getAttribute("username") == null) {
    session.invalidate();
    response.sendRedirect("login.jsp");
    return;
  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
Hello <%=session.getAttribute("username")%>!
 <a href="doLogoff.jsp">logoff</a><br>
<form method="POST" action='SendMessage'>
  <table border="0" cellspacing="5">
  	<tr>
  		<th align="right">Talk to:</th>
  		<td align="left">
			<select name="talkTo">
<%
	String[] users = ChatUsers.getUsers();
	for(String user: users) {
		out.print(String.format("<option value='%s'>%s</option>", user, user));
	}
%>
			</select>
  		</td>
  	</tr>
  
    <tr>
      <th align="right">Message:</th>
      <td align="left"><input type="text" name="msg"></td>
    </tr>
    <tr>
      <td align="right"><input type="submit" value="Send!"></td>
      <td align="left"><input type="reset"></td>
    </tr>
  </table>
</form>
<br>
<%
	String username = (String)session.getAttribute("username");
	String history = ChatUsers.getUser(username).formatMessages("mirri");
	out.print(history);
%>
</body>
</html>