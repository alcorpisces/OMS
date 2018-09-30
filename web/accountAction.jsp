<%-- 
    Document   : accountAction
    Created on : 29/09/2018, 6:07:09 PM
    Author     : Renwei
--%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <%   
            User loginuser = (User) session.getAttribute("user");
            if (loginuser == null) 
            {
                response.sendRedirect("login.jsp");
            }
            else
            {
               
                System.out.println("test1");
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
                         <h1>The personal details cannot be empty.</h1>
                         <p>Click <a href="account.jsp">here</a> to proceed to the account page.</p>
                         <% 
                    }
                }
                else
                    response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
