<%--
  Created by IntelliJ IDEA.
  User: Dmytro.Palets
  Date: 14.11.2015
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:useBean id="currentUser" scope = "session" class = "User"/> --%>


<body>

<form action="../SlowNewsServlet" method = "post"/>
    First name: <br />
    <input type="text" name="firstName">
    <p></p>
    Last Name: <br />
    <input type="text" name="lastName">
    <p></p>
    Login: <br />
    <input type="text" name="login">
    <p></p>
    Password: <br />
    <input type="text" name="password" type="password">
    <p></p>
    <input type="submit" value="Submit" />

</form>

<p></p>
<p></p><a href =/WEB-INF/view/login.jsp>Already registered? Please log in.</a></p>

</body>
</html>
