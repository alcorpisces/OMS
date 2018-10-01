<%-- 
    Document   : register
    Created on : 29/09/2018, 3:30:29 PM
    Author     : Renwei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.wsd.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
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
        
        <h1>Register</h1>
        
        <%
            boolean enter = false;
            String email = "";
            String name = "";
            String password = "";
            String phoneNumber = "";
            String address = "";

            if (request.getParameter("email") == null || request.getParameter("name") == null
                    || request.getParameter("password") == null || request.getParameter("phoneNumber") == null
                    || request.getParameter("address") == null) 
            {
                enter = false;
            } 
            else 
            {
                enter = true; 
                email = request.getParameter("email");
                name = request.getParameter("name");
                password = request.getParameter("password");
                phoneNumber = request.getParameter("phoneNumber");
                address = request.getParameter("address");
            }
        %>
        
        <form action="register.jsp" method="post">
            <table>
                <tr><td>Email</td></tr>
                <tr><td><input type="text" name="email" value="<%=email%>"></td></tr>
                <tr><td><font color="red"><%=enter & email.equals("") ? "The email address is invalid" : ""%></font></td></tr>
                <tr><td>Full Name</td></tr>
                <tr><td><input type="text" name="name" value="<%=name%>"></td></tr>
                <tr><td><font color="red"><%=enter & name.equals("") ? "The name is invalid" : ""%></font></td></tr>
                <tr><td>Password</td></tr>
                <tr><td><input type="password" name="password" value="<%=password%>"></td></tr>
                <tr><td><font color="red"><%=enter & password.equals("") ? "The password is invalid" : ""%></font></td></tr>
                <tr><td>Phone Number</td></tr>
                <tr><td><input type="text" name="phoneNumber" value="<%=phoneNumber%>"></td></tr>
                <tr><td><font color="red"><%=enter & phoneNumber.equals("") ? "The phone number is invalid" : ""%></font></td></tr>
                <tr><td>Address</td></tr>
                <tr><td><input type="text" name="address" value="<%=address%>"></td></tr>
                <tr><td><font color="red"><%=enter & address.equals("") ? "The address is invalid" : ""%></font></td></tr>
                
                <%
                    if (!email.equals("") && !name.equals("") && !password.equals("") && !phoneNumber.equals("") && !address.equals("")) 
                    {
                        if (userApp.loadXML()!=null)
                        {
                            User user = new User(email,name,password,phoneNumber,address);
                            Users users = userApp.loadXML();
                            if (users.allowAdd(email))
                            {
                                users.addUser(user);
                                userApp.updateXML(users);                        
                                session.setAttribute("user", user);
                                response.sendRedirect("main.jsp");
                            }
                %>    
                    <tr>
                        <td><font color="red"><%=!users.allowAdd(email) ? "The emaill address has been registered" : ""%></font></td>
                    </tr>
                
                   <%       
                        }
                    }
                  %>  
                
                <tr>
                    <td><input type="submit" value="Register"</td>
                    <td><button type="button" onclick="history.back()">Back</button></td>

                </tr>
            </table>
        </form>
    </body>
</html>
