<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<html>
<head>
<title>Login Page for Chat</title>
<body bgcolor="white">
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
