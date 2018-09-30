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
 
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users", namespace = "http://learn.it.uts.edu.au/wsd")
public class Users implements Serializable
{
    @XmlElement(name = "user")
    private ArrayList<User> list = new ArrayList<User>();
 
    public ArrayList<User> getList()
    {
        return list;
    }
    
    public Users() {
    }

    public void addUser(User user)
    {
        list.add(user);
    }
    
    public void removeUser(String email)
    {
        for (int i = 0; i < getList().size(); i++)
        {
                if (getList().get(i).getEmail().equals(email))
                        getList().remove(i);
        }
        
//       for(User current: list)
//        {
//            if(current.getEmail().equals(email))
//            {
//                list.remove(current)
//                //System.out.println(current.getAddress());
//            }
//        }
    }
    
    public User login(String email, String password)
    {
        // For each user in the list...
        for (User user : list) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return user; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
    
    public void updateUser(String email, String name, String password, String phoneNumber, String address)
    {
        for(User current: list)
        {
            if(current.getEmail().equals(email))
            {
                current.setName(name);
                current.setPassword(password);
                current.setPhoneNumber(phoneNumber);
                current.setAddress(address);
                //System.out.println(current.getAddress());
            }
        }
    }
    
    public User matchUser(String email)
    {
        for(User current: list)
        {
            if(current.getEmail().equals(email))
            {
                return current;
            }
        }
        return null;
    }
    
}
