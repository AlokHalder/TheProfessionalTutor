/*
 * DbConnection.java
 *
 * Created on January 3, 2009, 9:51 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.pcs.ptutors.model;

import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 *
 * @author ibm
 */
public class DbConnection {
    /*
   private static Connection conn =null;
   private static final String propdest = "com.tutors.properties.professionaltutors";
   private static ResourceBundle resource = ResourceBundle.getBundle(propdest);
   public static int counter =0 ;
   public static Connection dbConnect(){
   
      try{
        Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));      
        conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
        counter++;
        System.out.println(" Connection Counter "+ counter);
       }
    catch(Exception e)
       {
        System.out.println("Exception occurs"+e.getMessage());                 
       }
    
        return conn;
    }
   */

   private  Connection conn =null;
   private static final String propdest = "com.pcs.ptutors.properties.professionaltutors";
   private static ResourceBundle resource = ResourceBundle.getBundle(propdest);
   public static int counter =0 ;
   public Connection dbConnect(){

      try{
        Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
        conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
        counter++;
        if(null != conn){
            System.out.println(" Connection Found");
        }else{
            System.out.println("Connection Not Found");
        }
       // System.out.println(" Connection Counter "+ counter);
       }
    catch(Exception e)
       {
        System.out.println("Exception occurs"+e.getMessage());
        e.printStackTrace();
       }

        return conn;
    }
}
