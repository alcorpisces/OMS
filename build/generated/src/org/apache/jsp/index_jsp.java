package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import uts.wsd.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <title>Index</title>\n");
      out.write("    </head>\n");
      out.write("    ");
  
        String xmlFilePath = application.getRealPath("WEB-INF/movies.xml");
        String xsdFilePath = application.getRealPath("WEB-INF/movies.xsd");
    
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      uts.wsd.MovieApplication movieApp = null;
      synchronized (application) {
        movieApp = (uts.wsd.MovieApplication) _jspx_page_context.getAttribute("movieApp", PageContext.APPLICATION_SCOPE);
        if (movieApp == null){
          movieApp = new uts.wsd.MovieApplication();
          _jspx_page_context.setAttribute("movieApp", movieApp, PageContext.APPLICATION_SCOPE);
          out.write("\n");
          out.write("        ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("movieApp"), "xmlFilePath",
xmlFilePath);
          out.write("\n");
          out.write("        ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("movieApp"), "xsdFilePath",
xsdFilePath);
          out.write("\n");
          out.write("    ");
        }
      }
      out.write("\n");
      out.write("    \n");
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
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"register.jsp\">Register</a>\n");
      out.write("        <a href=\"login.jsp\">");
      out.print(loginuser == null ? "Login" : "");
      out.write("</a>\n");
      out.write("        \n");
      out.write("        <h1>Movie</h1>\n");
      out.write("        \n");
      out.write("            ");

            boolean enter = false;
            String title = "";
            String genre = "";
            String from = "";
            String to = "";

            if (request.getParameter("title") == null || request.getParameter("genre") == null
                    || request.getParameter("from") == null || request.getParameter("to") == null) 
            {
                enter = false;
            } 
            else 
            {
                enter = true; 
                title = request.getParameter("title");
                genre = request.getParameter("genre");
                from = request.getParameter("from");
                to = request.getParameter("to");
            }
        
      out.write("\n");
      out.write("        \n");
      out.write("            <form action=\"index.jsp\" method=\"post\">\n");
      out.write("                <table>\n");
      out.write("                    <tr><td>Title</tr>\n");
      out.write("                    <tr><td><input type=\"text\" name=\"title\" value=\"");
      out.print(title);
      out.write("\"></td></tr>\n");
      out.write("\n");
      out.write("                    <tr><td>Genre</tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <input list=\"genreList\" name=\"genre\" value=\"");
      out.print(genre);
      out.write("\">\n");
      out.write("                            <datalist id=\"genreList\">\n");
      out.write("                                <option value=\"Action\" />\n");
      out.write("                                <option value=\"Sci-Fi\" />\n");
      out.write("                                <option value=\"Horror\" />\n");
      out.write("                                <option value=\"Comedy\" />\n");
      out.write("                            </datalist>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr><td>Movie Release year</td></tr>\n");
      out.write("                    <tr><td>From: <input type=\"date\" name=\"from\" value=\"");
      out.print(from);
      out.write("\"></td></tr>\n");
      out.write("\n");
      out.write("                    <tr><td>To: <input type=\"date\" name=\"to\" value=\"");
      out.print(to);
      out.write("\"></td></tr>\n");
      out.write("                    \n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"submit\" value=\"Search\"</td>\n");
      out.write("                        <td><button type=\"button\" onclick=\"history.back()\">Back</button></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("        <h1>Result</h1>\n");
      out.write("        <p><font color=\"red\">");
      out.print(enter & session.getAttribute("user")==null ? "Login to order" : "");
      out.write("</font></p>\n");
      out.write("        <p><font color=\"red\">");
      out.print(enter & title.equals("") & genre.equals("") & from.equals("") & to.equals("") ? "No results. All parameters are empty." : "");
      out.write("</font></p>\n");
      out.write("        \n");
      out.write("        ");


            if (!title.equals("") || !genre.equals("") || !from.equals("") || !to.equals(""))
            {
                if (movieApp.loadXML()!=null)
                {
                    Movies movies = movieApp.loadXML();
                    if (movies.getMovies(title, genre, from, to) != null)
                    {
                        ArrayList<Movie> results = movies.getMovies(title, genre, from, to);

                        if (results.size() > 0)
                        {
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            
                        
                        
      out.write("\n");
      out.write("                            <form method=\"post\" action=\"checkout.jsp\">\n");
      out.write("                                <table>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Title</th>\n");
      out.write("                                        <th>Genre</th>\n");
      out.write("                                        <th>Release Date</th>\n");
      out.write("                                        <th>Price</th>\n");
      out.write("                                        <th>Available Copies</th>\n");
      out.write("                                        <th>Select</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
  for (Movie m : results) 
                                        { 
                                            String releaseDate = formatter.format(m.getMovieReleaseDate());
                                        
                                     
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("\n");
      out.write("                                        <td>");
      out.print(m.getTitle());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(m.getGenre());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(releaseDate);
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(m.getPrice());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print(m.getAvailableCopies());
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <input type=\"checkbox\" name=\"movieTitle\" value=");
      out.print("\""+m.getTitle()+"\"");
      out.print(session.getAttribute("user")!=null?"":" disabled");
      out.write(" />\n");
      out.write("                                        </td>\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");
  }   
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                         <td>\n");
      out.write("                                            <input type=\"submit\" name=\"Check out\" ");
      out.print(session.getAttribute("user")!=null?"":" disabled");
      out.write(" />\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("   \n");
      out.write("                            </form>\n");
      out.write("                        ");

                        }
                        else
                        {
                                
      out.write("\n");
      out.write("                                <font color=\"red\">No available movies.</font>\n");
      out.write("                                ");

                        }
                    }

                }
                else
                {
                        
      out.write("\n");
      out.write("                        <font color=\"red\">Check JAXB. </font>\n");
      out.write("                        ");

                }
            }
            
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
