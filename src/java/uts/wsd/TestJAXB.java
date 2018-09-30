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
import java.io.*;
import javax.xml.bind.*;

public class TestJAXB implements Serializable {
    public static void main(String[] args) throws Exception{
        Users users = new Users();
        users.addUser(new User("12345@uts.com", "Test", "12345", "123456", "address"));
        JAXBContext jc = JAXBContext.newInstance(Users.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(users, System.out);
        
 //       Unmarshaller u = jc.createUnmarshaller();
 //       FileInputStream fin = new FileInputStream("web/WEB-INF/users.xml");
           // u.setSchema(schema);
           // u.setEventHandler(new XmlValidationEventHandler());
//        users = (Users)u.unmarshal(fin);
//        System.out.print(users);
    }
}
