/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.util.*;
import javax.xml.validation.*;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
/**
 *
 * @author Renwei
 */
public class MovieApplication implements Serializable
{
    private String xmlFilePath;
    private String xsdFilePath;
    private Movies movies;

    public MovieApplication() {
    }
    

    /**
     * @return the users
     */
    public Movies loadXML() throws JAXBException, IOException, SAXException 
    {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        JAXBContext jc = JAXBContext.newInstance(new Class[]{Movies.class});
      //  SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
      //  Schema schema = sf.newSchema(new File(xsdFilePath));
        Unmarshaller u = jc.createUnmarshaller();
        FileInputStream fin = new FileInputStream(xmlFilePath);
     //   u.setSchema(schema);
     //   u.setEventHandler(new XmlValidationEventHandler());
        this.movies = (Movies)u.unmarshal(fin);
        System.out.print("Load successfully");
        return movies;
    }

    /**
     * @param users 
     */
    public void updateXML(Movies movies) throws JAXBException, IOException, SAXException  
    {
        this.movies = movies;
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
     //   JAXBSource js = new JAXBSource(jc, users);
     //   SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
     //   Schema schema = sf.newSchema(new File(xsdFilePath));
     //   Validator validator = schema.newValidator();
    //    validator.validate(js);
        Marshaller m = jc.createMarshaller();
        
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(xmlFilePath);
        m.marshal(movies, fout);
//        System.out.print(users);
        System.out.print("Update successfully");
        fout.close();
       // return true;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }
    /**
     *
     * @return the XML file path
     */
    public String getXmlFilePath() 
    {
        return xmlFilePath;
    }

    /**
     *
     * @param xmlFilePath
     */
    public void setXmlFilePath(String xmlFilePath) 
    {
        this.xmlFilePath = xmlFilePath;
    }

    /**
     *
     * @return the XSD file path
     */
    public String getXsdFilePath() 
    {
        return xsdFilePath;
    }

    /**
     *
     * @param xsdFilePath
     */
    public void setXsdFilePath(String xsdFilePath) 
    {
        this.xsdFilePath = xsdFilePath;
    }

}
