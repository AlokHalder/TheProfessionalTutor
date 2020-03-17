/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.model;

import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
/**
 *
 * @author ALOK
 */
public class DbSearchConnectionPool {

    private static Connection conn =null;
   private static final String propdest = "com.tutors.properties.professionaltutors";
   private static ResourceBundle resource = ResourceBundle.getBundle(propdest);
   public static int counter =0 ;

     /**
    * This connection is dedicatd to populated list of tutorial centers for home page
    * @return
    */
   public static  Connection paidTutorDbSearchConnection(){

      try{
        Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
        conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
        counter++;
        System.out.println(" Paid Tutor Db Search Connection ");
       }
    catch(Exception e)
       {
        System.out.println("Exception occurs"+e.getMessage());
       }

        return conn;
    }

   public static  Connection freeTutorDbSearchConnection(){

      try{
        Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
        conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
        counter++;
        System.out.println(" Free Tutor Db Search Connection ");
       }
    catch(Exception e)
       {
        System.out.println("Exception occurs"+e.getMessage());
       }

        return conn;
    }


}
