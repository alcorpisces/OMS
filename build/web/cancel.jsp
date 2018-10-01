<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.wsd.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cancel Page</title>
    </head>
    <body>
        <%
            User loginuser = (User) session.getAttribute("user");
            if (loginuser != null) {
        %>
        Welcome, <%=loginuser.getName()%>
        <a href="account.jsp">Account</a>
        <a href="main.jsp">Main</a>
        <a href="cancel.jsp">Cancel</a>
        <a href="logout.jsp">Logout</a>
        <%
            }
        %>
        <a href="index.jsp">Home</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp"><%=loginuser == null ? "Login" : ""%></a>
        <h1>Cancel order</h1>
    </body>
</html>
