package com.pcs.ptutors.admin.tutors.model;



import com.pcs.ptutors.admin.tutors.vo.UserProfilesVO;
import com.pcs.ptutors.model.DbConnection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Dipayan Dasgupta
 */
public class TutorAdminModel {

    private static final String propdest = "com.tutors.properties.validation";
    private static ResourceBundle resource = ResourceBundle.getBundle(propdest);

   private static final String sqlPropFileDest = "com.tutors.properties.professionaltutorsSQL";
   private static ResourceBundle sqlResource = ResourceBundle.getBundle(sqlPropFileDest);

    ArrayList list = new ArrayList();
    int empnum = 0;
    String cityName = null;
    String Phone = null;
    String message=null;
    String  insert=null;

    
    /**
     * 
     * @param date
     * @return
     */
    public String convertDate(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        String returnDate = day + "-" + month + "-" + year;
        return returnDate;
    }

     public String convertTODatabaseDate(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        String returnDate = year + "-" + month + "-" + day;
        return returnDate;
    }

  public boolean userValidation(UserProfilesVO userProfilesVO){
        String dbUser = null;
        String dbPassword = null;
        String dbRole = null;

        String user = userProfilesVO.getUsername();
        String password = userProfilesVO.getPassword();
        String role = userProfilesVO.getRole();
         try{
             DbConnection obj = new  DbConnection();
             Connection conn = obj.dbConnect();
             
             System.out.println(" User : " + user );
             System.out.println(" Password : "+ password);
             System.out.println(" Role : "+ role);
             
             String  sqlQuery = "select * from user_profiles where user_name =? and password =? and user_role =?";
             System.out.println(sqlQuery);
             PreparedStatement  pstmt = conn.prepareStatement(sqlQuery);
             pstmt.setString(1, user);
             pstmt.setString(2, password);
             pstmt.setString(3, role);
             ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
            dbUser = rs.getString("user_name");
            dbPassword = rs.getString("password");
            dbRole = rs.getString("user_role");

            }
            }
        catch(Exception  e){
            e.printStackTrace();
        }
        if(user.equals(dbUser)&& password.equals(dbPassword) && role.equals(dbRole))
            return  true;
        else
            return false;
        }

public List<TutorRegistrationVO> populateDeactivatedTutorList() {
        List<TutorRegistrationVO> listOfSubjectWiseTutor = new ArrayList<TutorRegistrationVO>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

     
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String sqlQuery = "select tutor_id,name,gender,age,area_name,address,contact_number,email_address,registration_date,membership_category,document_verification_flag from tutor_details where profile_active_deactive_status=0 order by registration_date desc";
                StringBuilder sb = new StringBuilder(sqlQuery);
                pst = conn.prepareStatement(sb.toString());
               
                rst = pst.executeQuery();
                while (rst.next()) {
                    TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
                    /* Tutor Login Information */
                    tutorRegistrationVO.setTutorId(rst.getString("TUTOR_ID"));
                    tutorRegistrationVO.setTutorName(rst.getString("NAME"));
                   
                    /* Tutor Personal Information */
                    tutorRegistrationVO.setTutorSex(rst.getString("GENDER"));
                    tutorRegistrationVO.setTutorAge(rst.getString("AGE"));                    
                    tutorRegistrationVO.setTutorAddress(rst.getString("ADDRESS"));
                    tutorRegistrationVO.setContactNumber(rst.getString("CONTACT_NUMBER"));
                    tutorRegistrationVO.setTutorEmailId(rst.getString("EMAIL_ADDRESS"));  
                    tutorRegistrationVO.setMembershipCategory(rst.getString("membership_category"));                    
                    tutorRegistrationVO.setRegistrationDate(rst.getString("REGISTRATION_DATE"));
                   
                    listOfSubjectWiseTutor.add(tutorRegistrationVO);
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
                    if (null != rst) {
                        rst.close();
                    }


                } catch (SQLException sqlException) {
                }
            
        }
        return listOfSubjectWiseTutor;
    }


    public boolean activateTutor(String tutorId) {
        boolean returnFlag= false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
           if(tutorId != null){   
          
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String sqlQuery = "update tutor_details set profile_active_deactive_status =1 where tutor_id =?";              
                pst = conn.prepareStatement(sqlQuery);
                pst.setString(1, tutorId);
                int rowsAffected= pst.executeUpdate();
                if(rowsAffected>0){
                    returnFlag = true;
                }else{
                    returnFlag = false;
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
                    if (null != rst) {
                        rst.close();
                    }


                } catch (SQLException sqlException) {
                }
            }
        }
        return returnFlag;
    }

     public boolean deleteTutor(String tutorId) {
        boolean returnFlag= false;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
           if(tutorId != null){   
          
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                conn.setAutoCommit(false);
                String delTutorUgEducation = "delete from tutor_ug_education where tutor_id = '"+tutorId+"'";   
                String delTutorTeachingSegment = "delete from tutor_teaching_segment where tutor_id ='"+tutorId+"'";  
                String delTutorTeachingOption ="delete from  tutor_teaching_option where tutor_id ='"+tutorId+"'"; 
                String delTutorTeachingPatteren="delete from tutor_teaching_patteren where tutor_id='"+tutorId+"'";
                String delTutorTechingArena ="delete from tutor_teaching_arena where tutor_id= '"+tutorId+"'";  
                String delTutorSubjects = "delete from tutor_subject where tutor_id = '"+tutorId+"'";  
                String delTutorPgEducation ="delete from tutor_pg_education where tutor_id = '"+tutorId+"'";  
                String delTutorMembershipSubscription = "delete from tutor_membership_subscription where user_id ='"+tutorId+"'";  
                String delTutorTeachingMedium ="delete from tutor_medium where tutor_id ='"+tutorId+"'";  
                String delTutorDetails = "delete from tutor_details where tutor_id = '"+tutorId+"'";    
                System.out.println("delTutorDetails :----------> "+ delTutorDetails);
                stmt = conn.createStatement();
                
                stmt.addBatch(delTutorUgEducation);
                stmt.addBatch(delTutorTeachingSegment);
                stmt.addBatch(delTutorTeachingOption);
                stmt.addBatch(delTutorTeachingPatteren);
                stmt.addBatch(delTutorTechingArena);
                stmt.addBatch(delTutorSubjects);
                stmt.addBatch(delTutorPgEducation);
                stmt.addBatch(delTutorMembershipSubscription);
                stmt.addBatch(delTutorTeachingMedium);
                stmt.addBatch(delTutorDetails);
                
                int[] rowsAffected= stmt.executeBatch();
                conn.commit();
                if(rowsAffected.length>0){
                    returnFlag=true;
                }
                System.out.println(" Length :------------->"+rowsAffected.length);


            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    if (null != conn) {
                      
                        conn.close();
                    }

                    if (null != stmt) {
                        stmt.close();
                    }
                    if (null != rst) {
                        rst.close();
                    }


                } catch (SQLException sqlException) {
                }
            }
        }
        return returnFlag;
    }
 public boolean deactivateSingleTutorService(String tutorId) {
        boolean returnFlag = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        System.out.println("tutorId in service...." + tutorId);
        if (tutorId != null) {

            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String sqlQuery = "update tutor_details set profile_active_deactive_status =0 where tutor_id =?";
                pst = conn.prepareStatement(sqlQuery);
                pst.setString(1, tutorId);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    returnFlag = true;
                } else {
                    returnFlag = false;
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
                    if (null != rst) {
                        rst.close();
                    }


                } catch (SQLException sqlException) {
                }
            }
        }
        System.out.println("returnFlag in service   .." + returnFlag);
        return returnFlag;
    }




    

   }
