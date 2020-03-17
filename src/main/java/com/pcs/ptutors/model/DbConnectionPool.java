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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author ibm
 */
public class DbConnectionPool {

    private static Connection conn = null;
    private static final String propdest = "com.pcs.ptutors.properties.professionaltutors";
    private static ResourceBundle resource = ResourceBundle.getBundle(propdest);
    public static int counter = 0;
    /*public static List<Connection> listOfPooledConnection  = new ArrayList<Connection>();
    public  List<Connection> dbConnectPool(){
    
    try{
    Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
    for(int i=0;i<5;i++){
    
    conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
    counter++;
    System.out.println(" Inside Connection Pool :---> "+ counter);
    listOfPooledConnection.add(conn);
    }
    
    }
    catch(Exception e)
    {
    System.out.println("Exception occurs"+e.getMessage());
    }
    
    return listOfPooledConnection;
    }
     */

    /**
     * This connection is dedicated to populate city location in header section  :
     * @return
     */
    public static Connection dbConnectOne() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection - 1 : This connection is dedicated to populate city location in header section ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicated to populate country national flag
     * @return
     */
    public static Connection dbConnectTwo() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection - 2  : This connection is dedicated for populating country national flag ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicatd to populated list of tutorial centers for home page
     * @return
     */
    public static Connection dbConnectThree() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection -3 : This connection is dedicated to populated tutorial centers ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicated for populating tutor requirement list
     */
    public static Connection dbConnectFour() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection -4 : This connection is dedicated for populating tutor requirement list ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicated for populating Teaser section
     * @return
     */
    public static Connection dbConnectFive() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection - 5 : This connection is dedicated for populating Teaser section");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicated to populate List of Tutors in home page .
     * @return
     */
    public static Connection dbConnectSix() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection - 6 : This connection is dedicated to populate List of Tutors in home page . ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectSeven() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter seven ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectEight() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter eight ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectNine() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter nine ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    /**
     * This connection is dedicated for footer section subject wise tutors population
     * @return
     */
    public static Connection dbConnectTen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter ten " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectEleven() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectTwelve() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
           conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter ");
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectThirteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectFourteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectFifteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectSixteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectSeventeen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectEighteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }
        return conn;
    }

    public static Connection dbConnectNinteen() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }

        return conn;
    }

    public static Connection dbConnectTwenty() {

        try {
            Class.forName(resource.getString(ProfessionalTutorsConstant.DRIVER_NAME));
            conn = DriverManager.getConnection(resource.getString(ProfessionalTutorsConstant.DRIVER_URL));
            counter++;
            System.out.println(" Connection Counter " + counter);
        } catch (Exception e) {
            System.out.println("Exception occurs" + e.getMessage());
        }
        return conn;
    }
    /* Connection close by Chandan Kumar Sasmal */

    public static boolean dbClose(ResultSet resultSet, Statement statement, Connection connection) {
        boolean disConnect = false;
        if (null != resultSet) {
            try {
                resultSet.close();
                resultSet = null;
                statement.close();
                statement = null;
                connection.close();
                connection = null;
                disConnect = true;
            } catch (SQLException sQLException) {
                System.out.println("Exception occurs database claose: " + sQLException.getMessage());
            }
        } else {
            System.out.println("Exception occurs in database clase");
        }
        return disConnect;
    }
}
