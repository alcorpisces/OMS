<%-- 
    Document   : login
    Created on : 29/09/2018, 2:31:26 PM
    Author     : Renwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.wsd.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
    <%  
        String xmlFilePath = application.getRealPath("WEB-INF/users.xml");
        String xsdFilePath = application.getRealPath("WEB-INF/users.xsd");
    %>
    
    <jsp:useBean id="userApp" class="uts.wsd.UserApplication" scope="application">
        <jsp:setProperty name="userApp" property="xmlFilePath" value="<%=xmlFilePath%>" />
        <jsp:setProperty name="userApp" property="xsdFilePath" value="<%=xsdFilePath%>" />
    </jsp:useBean>
    
    
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
        
        <h1>Login</h1>
        
        <%
            boolean enter = false;
            String email = "";
            String password = "";

            if (request.getParameter("email") == null || request.getParameter("password") == null) 
            {
                enter = false;
            } 
            else 
            {
                enter = true; 
                email = request.getParameter("email");
                password = request.getParameter("password");
            }
        %>
        
        <form action="login.jsp" method="post">
            <table>
                    <tr><td>Email</tr>
                    <tr><td><input type="text" name="email" value="<%=email%>"></td></tr>
                    <tr><td><font color="red"><%=enter & email.equals("") ? "The email address is empty" : ""%></font></td></tr>
                    <tr><td>Password</td></tr>
                    <tr><td><input type="password" name="password" value="<%=password%>"></td></tr>
                    <tr><td><font color="red"><%=enter & password.equals("") ? "The password is empty" : ""%></font></td></tr>
        
                <%
                    if (!email.equals("") && !password.equals("")) 
                    {
                        if (userApp.loadXML()!=null)
                        {
                            Users users = userApp.loadXML();
                            User user = users.login(email, password);
                                                    
                            if (user != null) 
                            {
                                session.setAttribute("user", user);
                                response.sendRedirect("main.jsp");
                            } 
                    %>      
                            <tr>
                                <td><font color="red"><%=!users.matchUser(email) & user==null ? "The user does not exist" : ""%></td>
                            </tr>
                            <tr>
                                <td><font color="red"><%=users.matchUser(email) & user==null ? "The password is incorrect" : ""%></td>
                            </tr>

                    <%  }
                    
                        else 
                        { 
                    %>    
                        <tr>
                            <td><font color="red">Check the JAXB</td>
                        </tr>

                    <%  }
                    }
                %>
                    <tr>
                        <td><input type="submit" value="Login"></td>
                        <td><button type="button" onclick="history.back()">Back</button></td>
                        
                    </tr>
            </table>
        </form>
    </body>
</html>
