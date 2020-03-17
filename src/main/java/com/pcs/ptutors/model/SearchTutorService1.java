/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.model;

import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibm
 */
public class SearchTutorService1  {

  DbConnection db = new DbConnection();

  
  public List<TutorRegistrationVO> populateSearchTutorResult(TutorRegistrationVO tutorRegistration){
      List<TutorRegistrationVO> listOfTutorRegistrationVO = new ArrayList<TutorRegistrationVO>();
       Connection conn = null;
       PreparedStatement pst = null;
       ResultSet rst = null;

        if (null != tutorRegistration) {
            try {
                
                DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
                
                String tutorId = null;
                String tutorLocation = null;
                String tutorSubject=null;
                String tutorLevel=null;
                
                if(null!= tutorRegistration.getTutorId() && !"".equalsIgnoreCase(tutorRegistration.getTutorId())){
                    tutorId=tutorRegistration.getTutorId();
                }

                if(null != tutorRegistration.getTutorCityLocation() && !"".equalsIgnoreCase(tutorRegistration.getTutorCityLocation())){
                    tutorLocation=tutorRegistration.getTutorCityLocation();
                }

                if(null != tutorRegistration.getMainsubject() && !"".equalsIgnoreCase(tutorRegistration.getMainsubject())){
                    tutorSubject = tutorRegistration.getMainsubject();
                }

                if(null != tutorRegistration.getTeachingLevel() && !"".equalsIgnoreCase(tutorRegistration.getTeachingLevel())){
                    tutorLevel =tutorRegistration.getTeachingLevel();
                }
                
                System.out.println(" tutorId : " + tutorId);
                System.out.println("tutorLocation : "+ tutorLocation);
                System.out.println("tutorSubject : " + tutorSubject);
                System.out.println("tutorLevel :"+ tutorLevel);

                /* Future Implementation need to implemnt View for Faster query..*/

                /* Search Default Query
                 * Formula  4c4  = 0
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject  null
                 * tutorLevel null
                 *
                 */
                StringBuilder sqlQueryPart = new StringBuilder("select * from tutor_details");

                /* Search Query : 1
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null != tutorId && null == tutorLocation && null == tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "'");
                   }

                /* Search Query : 2
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null == tutorId && null != tutorLocation &&  null == tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where location_name = '" + tutorLocation + "'");
                   }

                /* Search Query : 3
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel null
                 */
                if(null == tutorLocation &&  null == tutorId && null != tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where pref_subject_to_teach = '" + tutorSubject + "'");
                   }

                /* Search Query : 4
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel not null
                 */
                if(null == tutorId && null == tutorLocation && null == tutorSubject &&  null != tutorLevel) {
                    sqlQueryPart.append(" where teaching_segment_level = '" + tutorLevel+ "'");
                  }

                /* Search Query : 5
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation not null
                 * tutorSubject null
                 * tutorLevel null
                 *
                 */

                if (null != tutorId && null != tutorLocation && null == tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and location_name ='"+tutorLocation+"'");
                }

                 /* Search Query : 6
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject not null
                 * tutorLevel null
                 *
                 */

                if (null == tutorId && null != tutorLocation && null != tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where location_name = '" + tutorLocation + "' and pref_subject_to_teach ='"+tutorSubject+"'");
                }

                 /* Search Query : 7
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel not null
                 *
                 */

                if (null == tutorId && null == tutorLocation && null != tutorSubject && null !=tutorLevel) {
                    sqlQueryPart.append(" where pref_subject_to_teach = '" + tutorSubject + "' and teaching_segment_level ='"+tutorLevel+"'");
                }




                /* Search Query : 8
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel  null
                 *
                 */

                if (null != tutorId && null == tutorLocation && null != tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and pref_subject_to_teach ='"+tutorSubject+"'");
                }

                /* Search Query : 9
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject  null
                 * tutorLevel  not null
                 *
                 */

                if (null == tutorId && null != tutorLocation && null == tutorSubject && null !=tutorLevel) {
                    sqlQueryPart.append(" where location_name = '" + tutorLocation + "' and teaching_segment_level ='"+tutorLevel+"'");
                }

                /* Search Query : 10
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  not null
                 * tutorLocation  null
                 * tutorSubject  null
                 * tutorLevel  not null
                 *
                 */

               /* if (null == tutorId && null != tutorLocation && null == tutorSubject && null !=tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and teaching_segment_level ='"+tutorLevel+"'");
                }*/

                 /* Search Query : 11
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not null
                 * tutorLocation not null
                 * tutorSubject  not null
                 * tutorLevel  null
                 *
                 */

                if (null != tutorId && null != tutorLocation && null != tutorSubject && null == tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and location_name ='"+tutorLocation+"' and pref_subject_to_teach ='"+tutorSubject+"' " );
                }

                 /* Search Query : 12
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId   null
                 * tutorLocation not null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null == tutorId && null != tutorLocation && null != tutorSubject && null != tutorLevel) {
                    sqlQueryPart.append(" where location_name = '" + tutorLocation + "' and pref_subject_to_teach ='"+tutorSubject+"' and teaching_segment_level='"+tutorLevel+"' " );
                }

                 /* Search Query : 13
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null != tutorId && null == tutorLocation && null != tutorSubject && null != tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and pref_subject_to_teach ='"+tutorSubject+"' and teaching_segment_level='"+tutorLevel+"' " );
                }
                
                /* Search Query : 14
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   null
                 * tutorLevel  not null
                 *
                 */

                if (null != tutorId && null != tutorLocation && null == tutorSubject && null != tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and location_name ='"+tutorLocation+"' and teaching_segment_level='"+tutorLevel+"' " );
                }
                
                /* Search Query : 15
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   not null
                 * tutorLevel  not null
                 *
                 */

                if (null != tutorId && null != tutorLocation && null != tutorSubject && null != tutorLevel) {
                    sqlQueryPart.append(" where tutor_id = '" + tutorId + "' and location_name ='"+tutorLocation+"'and pref_subject_to_teach ='"+tutorSubject+"' and teaching_segment_level='"+tutorLevel+"' " );
                }

                System.out.println("Search Sql Query :: " + sqlQueryPart.toString());
                
                pst = conn.prepareStatement(sqlQueryPart.toString());
                rst = pst.executeQuery();
                while (rst.next()) {
                    TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
                    
                 /* Tutor Login Information */
                tutorRegistrationVO.setTutorId(rst.getString("tutor_id"));
                tutorRegistrationVO.setTutorName(rst.getString("name"));
                tutorRegistrationVO.setTutorLoginName(rst.getString("user_login_name"));
                tutorRegistrationVO.setTutorPassword(rst.getString("password"));
                tutorRegistrationVO.setTutorSecretQuestion(rst.getString("secret_question"));
                tutorRegistrationVO.setTutorSecretQuestionAnswer(rst.getString("secret_question_answer"));

                /* Tutor Personal Information */
                tutorRegistrationVO.setTutorSex(rst.getString("gender"));
                tutorRegistrationVO.setTutorAge(rst.getString("age"));
                tutorRegistrationVO.setTutorCountryLocation(rst.getString("country_name"));
                tutorRegistrationVO.setTutorCityLocation(rst.getString("location_name"));
                tutorRegistrationVO.setTutorAddress(rst.getString("address"));
                tutorRegistrationVO.setContactNumber(rst.getString("contact_number"));
                tutorRegistrationVO.setTutorEmailId(rst.getString("email_address"));

                /* Tutor Educational Information */
                tutorRegistrationVO.setUgQualifyingDegree(rst.getString("ug_basic_graduation_qualification"));
                tutorRegistrationVO.setUgSpecialization(rst.getString("ug_specialization"));
                tutorRegistrationVO.setUgBoardOrUniversity(rst.getString("ug_board_university_institute"));
                tutorRegistrationVO.setUgPassoutYear(rst.getString("ug_year_of_passout"));

                tutorRegistrationVO.setPgQualifyingDegree(rst.getString("pg_qualification"));
                tutorRegistrationVO.setPgSpecialization(rst.getString("pg_specialization"));
                tutorRegistrationVO.setPgBoardOrUniversity(rst.getString("pg_university_institute"));
                tutorRegistrationVO.setPgPassoutYear(rst.getString("pg_year_of_passout"));

               /* Tutor Tutoring Information */
                tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("years_of_tutoring_experience"));
                tutorRegistrationVO.setPreferenceToTeaching(rst.getString("pref_subject_to_teach"));
                tutorRegistrationVO.setPreferredTutoringArea(rst.getString("preferred_tutoring_area"));
                tutorRegistrationVO.setTutorTeachingPatteren(rst.getString("teaching_patteren"));
                tutorRegistrationVO.setTutoringOptions(rst.getString("tutoring_options"));
                tutorRegistrationVO.setTeachingMedium(rst.getString("teaching_medium"));
                tutorRegistrationVO.setTeachingLevel(rst.getString("teaching_segment_level"));
                tutorRegistrationVO.setFeeExpected(rst.getString("expected_fees"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("tutoring_experience"));
                tutorRegistrationVO.setRegistrationDate(rst.getString("registration_date"));
                tutorRegistrationVO.setImageFlag(rst.getBoolean("image_flag"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("tutoring_experience"));

                listOfTutorRegistrationVO.add(tutorRegistrationVO);
                }


            }catch (Exception exception) {
                exception.printStackTrace();
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
                    sqlException.printStackTrace();
                }
            }
        }
        return listOfTutorRegistrationVO;


  }
}
