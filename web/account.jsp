<%-- 
    Document   : account
    Created on : 29/09/2018, 4:24:57 PM
    Author     : Renwei
--%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
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
        <%
//            User loginuser = (User) session.getAttribute("user");
//            if (loginuser == null) {
//                response.sendRedirect("login.jsp");
//            }
        %>
    <body>
        
        <%
            User loginuser = (User) session.getAttribute("user");
            if (loginuser == null) 
            {
                response.sendRedirect("login.jsp");
            }
            else
            {
               
                System.out.println("test1");
           // User loginuser = (User) session.getAttribute("user");
        %>
        Welcome, <%=loginuser.getName()%>
        <a href="account.jsp">Account</a>
        <a href="logout.jsp">Logout</a>
        <a href="index.jsp">Index</a>
        <a href="register.jsp">Register</a>
        
        <h1>My Account</h1>
        <form action="account.jsp" method="post">
            <table>
                <tr>
                    <td>Email</td>
                    <td>
                        <%= loginuser.getEmail() %>
                    </td>
                </tr>
                
                <tr>
                    <td>Full Name</td>
                    <td>
                        <input type="text" name="name" value="<%= loginuser.getName() %>" >
                    </td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="password" value="<%= loginuser.getPassword() %>" >
                    </td>
                </tr>
                
                <tr>
                    <td>Phone Number</td>
                    <td>
                        <input type="text" name="phoneNumber" value="<%= loginuser.getPhoneNumber() %>" >
                    </td>
                </tr>
                
                <tr>
                    <td>Address</td>
                    <td>
                        <input type="text" name="address" value="<%= loginuser.getAddress() %>" >
                    </td>
                </tr>
        <%

            if (request.getParameter("name") != null || request.getParameter("password") != null || request.getParameter("phoneNumber") != null || request.getParameter("address") != null)
            {
                    String email = loginuser.getEmail();    
                    String name = request.getParameter("name");
                    String password = request.getParameter("password");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String address = request.getParameter("address"); 
                    System.out.println(password);

                    if(!name.equals("") && !password.equals("") && !phoneNumber.equals("") && !address.equals(""))
                    {
                        System.out.println("test232");
                        Users users = userApp.loadXML();
                        System.out.println("test2");
                        users.updateUser(loginuser.getEmail(), name, password, phoneNumber, address);
                        loginuser.updateDetails(loginuser.getEmail(), name, password, phoneNumber, address);
                        userApp.updateXML(users);
                        response.sendRedirect("account.jsp");
                    }
                    else
                    {
                        %>

                <tr>
                    <td>
                    </td>
                    <td><font color="red">
                        The personal details cannot be empty.
                    </td>
                </tr>

                        <% 
                    }
            }
  %>
         <tr>
            <td>
                Delete Account
            </td>
            <td>
                <input type ="radio" name="delete" value="<%=loginuser.getEmail()%>"/>
            </td>
        </tr>
                <% 

            if (request.getParameter("delete") != null)
            {
                System.out.println("testddd");
                Users users = userApp.loadXML();
               // User user = users.matchUser(loginuser.getEmail());
                users.removeUser(loginuser.getEmail());
                userApp.updateXML(users);
                session.invalidate();
                //response.sendRedirect("logout.jsp");
            }
            
        %>
        
  <%
        }

           // User loginuser = (User) session.getAttribute("user");
        %>
                

 

        
                <tr>

                    <td>
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
                            

    </body>
</html>
