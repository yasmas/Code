<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ page import="yossi.web.ChatUsers" %>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(username!=null && password.equals(username)) {
		session.setAttribute("username",username);
		// Add the user to the ChatUsers
		ChatUsers.addUser(username);
		response.sendRedirect("chat.jsp");
		return;
	}
%>
<html>
<head>
<title>Login Page for Chat</title>
<body bgcolor="white">
Login failed!<br>
<form method="GET" action='doLogin.jsp'>
  <table border="0" cellspacing="5">
    <tr>
      <th align="right">Username:</th>
      <td align="left"><input type="text" name="username"></td>
    </tr>
    <tr>
      <th align="right">Password:</th>
      <td align="left"><input type="password" name="password"></td>
    </tr>
    <tr>
      <td align="right"><input type="submit" value="Log In"></td>
      <td align="left"><input type="reset"></td>
    </tr>
  </table>
</form>
</body>
</html>
