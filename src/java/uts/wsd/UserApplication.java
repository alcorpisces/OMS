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
public class UserApplication implements Serializable
{
    private String xmlFilePath;
    private String xsdFilePath;
    private Users users;
    
    public UserApplication()
    {
    }
    
    /**
     * @return the users
     */
    public Users loadXML() throws JAXBException, IOException, SAXException 
    {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        JAXBContext jc = JAXBContext.newInstance(new Class[]{Users.class});
      //  SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
      //  Schema schema = sf.newSchema(new File(xsdFilePath));
        Unmarshaller u = jc.createUnmarshaller();
        FileInputStream fin = new FileInputStream(xmlFilePath);
     //   u.setSchema(schema);
     //   u.setEventHandler(new XmlValidationEventHandler());
        this.users = (Users)u.unmarshal(fin);
        System.out.print("Load successfully");
        return users;
    }

    /**
     * @param users 
     */
    public void updateXML(Users users) throws JAXBException, IOException, SAXException  
    {
        this.users = users;
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        
        JAXBContext jc = JAXBContext.newInstance(Users.class);
     //   JAXBSource js = new JAXBSource(jc, users);
     //   SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
     //   Schema schema = sf.newSchema(new File(xsdFilePath));
     //   Validator validator = schema.newValidator();
    //    validator.validate(js);
        Marshaller m = jc.createMarshaller();
        
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        FileOutputStream fout = new FileOutputStream(xmlFilePath);
        m.marshal(users, fout);
//        System.out.print(users);
        System.out.print("Update successfully");
        fout.close();
       // return true;
    }
    
//    public User login(String email, String password) 
//    {
//        return users.login(email, password);
//    }
//    
    /**
     * @return the users
     */
    public Users getUsers()
    {
        return users;
    }

    /**
     * @param users 
     */
    public void setUsers(Users users)
    {
        this.users = users;
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
