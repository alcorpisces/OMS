<%-- 
    Document   : main.jsp
    Created on : 29/09/2018, 3:26:27 PM
    Author     : Renwei
--%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            User loginuser = (User) session.getAttribute("user");
            if (loginuser != null) {
        %>
        Welcome, <%=loginuser.getName()%>
        <a href="account.jsp">Account</a>
        <a href="logout.jsp">Logout</a>
        <%
            }
        %>
        <a href="index.jsp">Index</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp"><%=loginuser == null ? "Login" : ""%></a>
       
        <h1>Hello World!</h1>
    </body>
</html>
