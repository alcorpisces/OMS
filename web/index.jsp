<%-- 
    Document   : index
    Created on : 27/09/2018, 9:34:24 PM
    Author     : Renwei
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="uts.wsd.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title>Index</title>
    </head>
    <%  
        String xmlFilePath = application.getRealPath("WEB-INF/movies.xml");
        String xsdFilePath = application.getRealPath("WEB-INF/movies.xsd");
    %>
    
    <jsp:useBean id="movieApp" class="uts.wsd.MovieApplication" scope="application">
        <jsp:setProperty name="movieApp" property="xmlFilePath" value="<%=xmlFilePath%>" />
        <jsp:setProperty name="movieApp" property="xsdFilePath" value="<%=xsdFilePath%>" />
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
        
        <h1>Movie</h1>
        
            <%
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
        %>
        
            <form action="index.jsp" method="post">
                <table>
                    <tr><td>Title</tr>
                    <tr><td><input type="text" name="title" value="<%=title%>"></td></tr>

                    <tr><td>Genre</tr>
                    <tr>
                        <td>
                            <input list="genreList" name="genre">
                            <datalist id="genreList">
                                <option value="Action" />
                                <option value="Sci-Fi" />
                                <option value="Horror" />
                                <option value="Comedy" />
                            </datalist>
                        </td>
                    </tr>

                    <tr><td>Movie Release year</td></tr>
                    <tr><td>From: <input type="date" name="from" value="<%=from%>"></td></tr>

                    <tr><td>To: <input type="date" name="to" value="<%=to%>"></td></tr>
                    
                    <tr>
                        <td><input type="submit" value="Search"</td>
                        <td><button type="button" onclick="history.back()">Back</button></td>
                    </tr>
                </table>
            </form>
        
        <h1>Result</h1>
        <p><font color="red"><%=enter & session.getAttribute("user")==null ? "Login to order" : ""%></font></p>
        <p><font color="red"><%=enter & title.equals("") & genre.equals("") & from.equals("") & to.equals("") ? "No results. All parameters are empty." : ""%></font></p>
        
        <%

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
                            
                        
                        %>
                            <form method="post" action="checkout.jsp">
                                <table>
                                    <tr>
                                        <th>Title</th>
                                        <th>Genre</th>
                                        <th>Release Date</th>
                                        <th>Price</th>
                                        <th>Available Copies</th>
                                        <th>Select</th>
                                    </tr>
                                    <%  for (Movie m : results) 
                                        { 
                                            String releaseDate = formatter.format(m.getMovieReleaseDate());
                                        
                                     %>
                                    <tr>

                                        <td><%=m.getTitle()%></td>
                                        <td><%=m.getGenre()%></td>
                                        <td><%=releaseDate%></td>
                                        <td><%=m.getPrice()%></td>
                                        <td><%=m.getAvailableCopies()%></td>
                                        <td>
                                            <input type="checkbox" name="movieTitle" value=<%="\""+m.getTitle()+"\""%><%=session.getAttribute("user")!=null?"":" disabled"%> />
                                        </td>

                                    </tr>
                                    <%  }   %>
                                    <tr>
                                         <td>
                                            <input type="submit" name="Check out" <%=session.getAttribute("user")!=null?"":" disabled"%> />
                                        </td>
                                    </tr>
                                </table>
   
                            </form>
                        <%
                        }
                        else
                        {
                                %>
                                <font color="red">No available movies.</font>
                                <%
                        }
                    }

                }
                else
                {
                        %>
                        <font color="red">Check JAXB. </font>
                        <%
                }
            }
            
        %>
    </body>
</html>