<%-- 
    Document   : logout
    Created on : 29/09/2018, 4:18:15 PM
    Author     : Renwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        session.invalidate();
    %>
    <body>
        <a href="index.jsp">Index</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <h1>You have been logged out. Click <a href="index.jsp">here</a> to return to the index page.</h1>
    </body>
</html>
