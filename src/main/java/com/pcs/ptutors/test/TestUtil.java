/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.test;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author ibm
 */
public class TestUtil {

    public static void main(String[] args){
     Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        
        try {

            Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/professionaltutor?user=root");
       
          // String keyValue = "Class V-X";
           String keyValue = "BCA/MCA";

           Statement st  = conn.createStatement();

           rs = st.executeQuery("select tutor_id,teaching_segment_level from tutor_details");
         //  Map<String,String> tutorLevel = new TreeMap<String,String>() ;
           List<String> uniqueTutorList = new ArrayList<String>();
           while(rs.next()){
                  String tutorId = rs.getString("tutor_id");
                  String teachingLevel =  rs.getString("teaching_segment_level");   
                  
                  System.out.println("tutorId :: " + tutorId +" teachingLevel : "+ teachingLevel );
                 // StringTokenizer strToken = new StringTokenizer(teachingLevel, ",");
                 
              /*    while(strToken.hasMoreTokens()){
                    // System.out.println(" TutorId : " + tutorId  + " Level : " + strToken.nextToken());
                     if(keyValue.equalsIgnoreCase(strToken.nextToken())){

                           uniqueTutorList.add(tutorId);
                     }
                     // tutorLevel.put(tutorId, strToken.nextToken());
                  }*/


              
//             / System.out.println(" Tutor Id : "+ rs.getString("tutor_id")+ "   Level : "+ teachingLevel);
           }

            // System.out.println("Tutor Level Size : " +tutorLevel.size());
            //  tutorLevel.containsValue(keyValue);
        /*   for(String tutorId: uniqueTutorList){
               System.out.println("tutorId :: "+ tutorId);
           }*/

        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pstmt) {
                    pstmt.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

    }

}
