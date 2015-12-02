<%--
  Created by IntelliJ IDEA.
  User: Dmytro.Palets
  Date: 10.11.2015
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form action="/LoginController" method = "post"/>
    Login: <br />
    <input type="text" name="login">
    <p></p>
    Password: <br />
    <input type="text" name="password" type="password">
    <p></p>
    <input type="submit" value="Submit" />
</form>


<a href =/jsp/registration.jsp>Not registered?</a>

</body>
</html>
