<%--
  Created by IntelliJ IDEA.
  User: Dmytro.Palets
  Date: 15.11.2015
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- <jsp:useBean id="currentUser" scope = "session" class = "User"/> --%>

<html>
<body>
Welcome, ${currentUser.getFirstName()} ${currentUser.getLastName()}!

</body>
</html>
