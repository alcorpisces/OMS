/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd;

import java.text.DateFormat; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import javax.xml.bind.annotation.adapters.XmlAdapter; 

public final class XMLDateAdapter extends XmlAdapter<String,Date> { 
 
  public static final DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd"); 

  public XMLDateAdapter() {     
  } 
 
  @Override 
  public Date unmarshal(String v) throws Exception { 
    return dateFormater.parse(v); 
  } 
 
  @Override 
  public String marshal(Date v) throws Exception { 
   return dateFormater.format(v); 
  } 

 
}
