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
        <title>Logout Page</title>
    </head>
    <%
        session.invalidate();
        response.sendRedirect("index.jsp");
    %>
    <body>

    </body>
</html>
