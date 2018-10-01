<%-- 
    Document   : checkout
    Created on : 27/09/2018, 10:17:09 PM
    Author     : Renwei

--%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out Page</title>
    </head>
    <body>
        <%
            User loginuser = (User) session.getAttribute("user");
            if (loginuser != null) {
        %>
        Welcome, <%=loginuser.getName()%>
        <a href="account.jsp">Account</a>
        <a href="main.jsp">Main</a>
        <a href="logout.jsp">Logout</a>
        <%
            }
        %>
        <a href="index.jsp">Home</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp"><%=loginuser == null ? "Login" : ""%></a>
        
        <h1>Check out</h1>
        
    </body>
</html>
