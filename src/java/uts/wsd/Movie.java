/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Renwei
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "movie")
public class Movie 
{
    @XmlElement(name = "movieTitle")
    private String title;
    @XmlElement(name = "movieGenre")
    private String genre;
    @XmlElement(name = "movieReleaseDate")
    @XmlJavaTypeAdapter(XMLDateAdapter.class)
    private Date movieReleaseDate;
    @XmlElement(name = "moviePrice")
    private String price;
    @XmlElement(name = "availableCopies")
    private int availableCopies;    
    
    public Movie() 
    {
    }

    public Movie(String title, String genre, Date movieReleaseDate, String price, int availableCopies) 
    {
        this.title = title;
        this.genre = genre;
        this.movieReleaseDate = movieReleaseDate;
        this.price = price;
        this.availableCopies = availableCopies;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getMovieReleaseDate() {        
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
    
    public boolean isAvailable(String title) {
        if (availableCopies == 0) {
            return false;
        }
        return true;
    }

}
