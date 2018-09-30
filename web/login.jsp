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
        //String filePath = application.getRealPath("WEB-INF/users.xml");
    %>
    
    <jsp:useBean id="userApp" class="uts.wsd.UserApplication" scope="application">
        <jsp:setProperty name="userApp" property="xmlFilePath" value="<%=xmlFilePath%>" />
        <jsp:setProperty name="userApp" property="xsdFilePath" value="<%=xsdFilePath%>" />
    </jsp:useBean>
    
    
    <body>
        <a href="index.jsp">Index</a>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
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
                    <tr><td><font color="red"><%=enter & email.equals("") ? "The email address is invalid" : ""%></font></td></tr>
                    <tr><td>Password</td></tr>
                    <tr><td><input type="password" name="password" value="<%=password%>"></td></tr>
                    <tr><td><font color="red"><%=enter & password.equals("") ? "The password is invalid" : ""%></font></td></tr>
        
                <%
                    if (!email.equals("") && !password.equals("")) 
                    {
                        //Users users = userApp.loadXML();
                        if (userApp.loadXML()!=null)
                        {
                           // Users users = userApp.loadXML();
                            Users users = userApp.loadXML();
                            User user = users.login(email, password);
                                                    
                        if (user != null) {
                            session.setAttribute("user", user);
                            response.sendRedirect("main.jsp");
                        } else { 
                %>    
                    <tr>
                        <td><font color="red"><%=user == null ? "The user is not exist or the password is incorrect" : ""%></td>
                    </tr>
                
                <%       }
                        }
                        else { 
                %>    
                    <tr>
                        <td><font color="red"><%=userApp.getUsers() == null ? "Check the JAXB" : ""%></td>
                    </tr>
                
                <%       }
                    }  
                %>
                

                      

                    <tr>
                        <td><button type="button" onclick="history.back()">Back</button></td>
                        <td><input type="submit" value="Login"></td>
                    </tr>
            </table>
        </form>
    </body>
</html>
