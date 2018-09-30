/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;
/**
 *
 * @author Renwei
 */
import java.util.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movies", namespace = "http://learn.it.uts.edu.au/wsd")

public class Movies implements Serializable{
    @XmlElement(name = "movie")
    private ArrayList<Movie> list = new ArrayList<Movie>();
 
    public ArrayList<Movie> getList()
    {
        return list;
    }
    
    public Movies() {
    }

    public void addMovie(Movie movie)
    {
        list.add(movie);
    }
    
    public void removeMovie(Movie movie)
    {
        list.remove(movie);
        System.out.println("Remove successfully");
    }
    
    public boolean fromDate(Date from, Date movieReleaseDate)
    {
        if (from.compareTo(movieReleaseDate) <= 0)
            return true;
        return false;
    }
    
    public boolean toDate(Date to, Date movieReleaseDate)
    {
        if (to.compareTo(movieReleaseDate) >= 0)
            return true;
        return false;
    }
    
    public ArrayList<Movie> getMovies(String title, String genre, String from, String to) throws ParseException
    {
       ArrayList<Movie> searched = new ArrayList<Movie>();
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Date fromDate = null;
       Date toDate = null;

        for (Movie m : list)
        {
            if (title.equals(m.getTitle()) || genre.equals(m.getTitle()))
            {
                searched.add(m);
            }
            
            if (!from.equals("") && from != null)
            {
                fromDate = formatter.parse(from);
                if (fromDate(fromDate,m.getMovieReleaseDate()))
                    searched.add(m);
            }

            else if (!to.equals("") && to != null)
            {
                toDate = formatter.parse(to);
                if (toDate(toDate,m.getMovieReleaseDate()))
                    searched.add(m);
            }
            
            else if (!from.equals("") && from != null && !to.equals("") && to != null)
            {
                fromDate = formatter.parse(from);
                if (fromDate(fromDate,m.getMovieReleaseDate()) && toDate(toDate,m.getMovieReleaseDate()))
                    searched.add(m);
            }
        }
        return searched;
        
    }
}
