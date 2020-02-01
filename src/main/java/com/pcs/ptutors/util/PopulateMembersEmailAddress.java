/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.util;

import com.pcs.ptutors.model.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALOK
 */
public class PopulateMembersEmailAddress {

     public List<String> populateMembersEmailAddress() {
        List<String> listOfMembersEmailAddress = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String sqlQuery = "select email_address from tutor_details";
                StringBuilder sb = new StringBuilder(sqlQuery);
                pst = conn.prepareStatement(sb.toString());               
                rs = pst.executeQuery();
                while (rs.next()) {
                  String emailId =  rs.getString("email_address");
                  if(null!= emailId && !emailId.equalsIgnoreCase("")) {
                    listOfMembersEmailAddress.add(emailId);
                  }
                }


            } catch (SQLException sqlException) {
            } catch (Exception exception) {
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != pst) {
                        pst.close();
                    }
                    if (null != rs) {
                        rs.close();
                    }


                } catch (SQLException sqlException) {
                }
            }

            listOfMembersEmailAddress.add("helpdesk@theprofessionaltutors.com");
             listOfMembersEmailAddress.add("admin@theprofessionaltutors.com");
             listOfMembersEmailAddress.add("alokhalder@gmail.com");
        return listOfMembersEmailAddress;
    }


}
