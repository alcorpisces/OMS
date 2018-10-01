package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.wsd.*;

public final class account_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Account</title>\n");
      out.write("    </head>\n");
      out.write("    ");
  
        String xmlFilePath = application.getRealPath("WEB-INF/users.xml");
        String xsdFilePath = application.getRealPath("WEB-INF/users.xsd");
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      uts.wsd.UserApplication userApp = null;
      synchronized (application) {
        userApp = (uts.wsd.UserApplication) _jspx_page_context.getAttribute("userApp", PageContext.APPLICATION_SCOPE);
        if (userApp == null){
          userApp = new uts.wsd.UserApplication();
          _jspx_page_context.setAttribute("userApp", userApp, PageContext.APPLICATION_SCOPE);
          out.write("\n");
          out.write("        ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("userApp"), "xmlFilePath",
xmlFilePath);
          out.write("\n");
          out.write("        ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("userApp"), "xsdFilePath",
xsdFilePath);
          out.write("\n");
          out.write("    ");
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            User loginuser = (User) session.getAttribute("user");
            if (loginuser != null) {
        
      out.write("\n");
      out.write("        Welcome, ");
      out.print(loginuser.getName());
      out.write("\n");
      out.write("        <a href=\"account.jsp\">Account</a>\n");
      out.write("        <a href=\"main.jsp\">Main</a>\n");
      out.write("        <a href=\"logout.jsp\">Logout</a>\n");
      out.write("\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"register.jsp\">Register</a>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <h1>My Account</h1>\n");
      out.write("        <form action=\"account.jsp\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Email</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( loginuser.getEmail() );
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Full Name</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"name\" value=\"");
      out.print( loginuser.getName() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Password</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"password\" name=\"password\" value=\"");
      out.print( loginuser.getPassword() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Phone Number</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"phoneNumber\" value=\"");
      out.print( loginuser.getPhoneNumber() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td>Address</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"address\" value=\"");
      out.print( loginuser.getAddress() );
      out.write("\" >\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("        ");


            if (request.getParameter("name") != null || request.getParameter("password") != null || request.getParameter("phoneNumber") != null || request.getParameter("address") != null)
            {
                    String name = request.getParameter("name");
                    String password = request.getParameter("password");
                    String phoneNumber = request.getParameter("phoneNumber");
                    String address = request.getParameter("address"); 

                    if(!name.equals("") && !password.equals("") && !phoneNumber.equals("") && !address.equals(""))
                    {
                        System.out.println("Test load XML");
                        Users users = userApp.loadXML();
                        System.out.println("Test update user");
                        users.updateUser(loginuser.getEmail(), name, password, phoneNumber, address);
                        loginuser.updateDetails(loginuser.getEmail(), name, password, phoneNumber, address);
                        userApp.updateXML(users);
                        response.sendRedirect("account.jsp");
                    }
                    else
                    {
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                            </td>\n");
      out.write("                            <td><font color=\"red\">\n");
      out.write("                                The personal details cannot be empty.\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");
 
                    }
            }
  
      out.write("\n");
      out.write("         <tr>\n");
      out.write("            <td>\n");
      out.write("                Delete Account\n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <input type =\"radio\" name=\"delete\" value=\"");
      out.print(loginuser.getEmail());
      out.write("\"/>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("                ");
 

            if (request.getParameter("delete") != null)
            {
                System.out.println("Delete user");
                Users users = userApp.loadXML();
                users.removeUser(loginuser.getEmail());
                userApp.updateXML(users);
                session.invalidate();
            }
            
        
      out.write("\n");
      out.write("        \n");
      out.write("  ");

        }
        else 
        response.sendRedirect("login.jsp");
        
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("        \n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Save\">\n");
      out.write("                    </td>\n");
      out.write("                    <td><button type=\"button\" onclick=\"history.back()\">Back</button></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("                            \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
