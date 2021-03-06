/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.model;

import com.pcs.ptutors.exception.ProfessionalTutorsException;
import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
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
public class SearchTutorService_1  {

  DbConnection db = new DbConnection();

   public List<TutorRegistrationVO> populateSearchTutorResult(TutorRegistrationVO tutorRegistrationVO) throws Exception, ProfessionalTutorsException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;

       List<TutorRegistrationVO> listOfTutorSearchResult = new ArrayList<TutorRegistrationVO>();

       List<String> listOfTutorIds = populateSearchTutorIds(tutorRegistrationVO);

       try{

       conn = DbSearchConnectionPool.paidTutorDbSearchConnection();
       for(String tutorId :listOfTutorIds){
            
         listOfTutorSearchResult.add( populateTutorProfileByTutorId(tutorId,conn,pstmt,rst));
       }
       }   catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.getMessage();
                throw exception;
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != pstmt) {
                        pstmt.close();
                    }
                    if (null != rst) {
                        rst.close();
                    }


                } catch (SQLException sqlException) {
                    throw sqlException;
                }
            }


       return listOfTutorSearchResult;
   }

  
  public List<String> populateSearchTutorIds(TutorRegistrationVO tutorRegistration){
       Connection conn = null;
       PreparedStatement pst = null;
       ResultSet rst = null;
       List<String> listOfSearchTutorIds = new ArrayList<String>();
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
                
               

                /* Future Implementation need to implemnt View for Faster query..*/

                /* Search Default Query
                 * Formula  4c4  = 0
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject  null
                 * tutorLevel null
                 *
                 */
                StringBuilder sqlQueryPart = new StringBuilder();

                /* Search Query : 1
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null != tutorId && null == tutorLocation && null == tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" select distinct td.tutor_id  from tutor_details  td where td.tutor_id = '" + tutorId + "'");
                   }

                /* Search Query : 2
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null == tutorId && null != tutorLocation &&  null == tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append(" select distinct td.tutor_id  from tutor_details  td  where td.location_id = " + tutorLocation);
                   }

                /* Search Query : 3
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel null
                 */
                if(null == tutorLocation &&  null == tutorId && null != tutorSubject && null ==tutorLevel) {
                    sqlQueryPart.append("select distinct ts.tutor_id  from tutor_subject ts where ts.subject_id = " + tutorSubject);
                   }

                /* Search Query : 4
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel not null
                 */
                if(null == tutorId && null == tutorLocation && null == tutorSubject &&  null != tutorLevel) {
                    sqlQueryPart.append(" select distinct tts.tutor_id from tutor_teaching_segment tts where tts.education_segment_id = " + tutorLevel);
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

                    sqlQueryPart.append(" select distinct td.tutor_id  from tutor_details  td  where td.tutor_id= '" + tutorId + "' and td.location_id = "+tutorLocation);
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
                    sqlQueryPart.append("select distinct td.tutor_id  from tutor_details  td , tutor_subject ts  where td.tutor_id= ts.tutor_id  and td.location_id =  " + tutorLocation + " and ts.subject_id = "+tutorSubject);
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
                    sqlQueryPart.append(" select distinct td.tutor_id  from tutor_details  td , tutor_subject ts ,tutor_teaching_segment tts  where td.tutor_id= ts.tutor_id  and td.tutor_id = tts.tutor_id and ts.subject_id = " + tutorSubject + " and tts.education_segment_id = "+tutorLevel);
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
                    sqlQueryPart.append("select distinct tutor_id  from tutor_subject where tutor_id = '" + tutorId + "'  and subject_id = "+tutorSubject);
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
                    sqlQueryPart.append("  select distinct td.tutor_id  from tutor_details  td , tutor_teaching_segment tts  where td.tutor_id = tts.tutor_id  and td.location_id = " + tutorLocation + " and tts.education_segment_id = "+tutorLevel);
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
                    sqlQueryPart.append("select distinct td.tutor_id from tutor_details td , tutor_subject ts where td.tutor_id = ts.tutor_id  and td.tutor_id=  '" + tutorId + "' and td.location_id= "+tutorLocation+"  and ts.subject_id = "+tutorSubject );
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
                    sqlQueryPart.append("select distinct td.tutor_id from tutor_details td , tutor_subject ts , tutor_teaching_segment tts where td.tutor_id = ts.tutor_id  and td.tutor_id = tts.tutor_id and td.location_id= " + tutorLocation + " and ts.subject_id = "+tutorSubject+"  and tts.education_segment_id = "+tutorLevel );
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
                    sqlQueryPart.append("select distinct td.tutor_id from tutor_details td , tutor_subject ts , tutor_teaching_segment tts where td.tutor_id = ts.tutor_id  and td.tutor_id = tts.tutor_id and td.tutor_id = '" + tutorId + "' and ts.subject_id = "+tutorSubject+"  and tts.education_segment_id = "+tutorLevel );
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
                    sqlQueryPart.append("select distinct td.tutor_id from tutor_details td, tutor_teaching_segment tts where  td.tutor_id = tts.tutor_id and td.tutor_id = '" + tutorId + "' and td.location_id = '" +tutorLocation  + "' and tts.education_segment_id = "+tutorLevel );
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

                    sqlQueryPart.append("select distinct td.tutor_id from tutor_details td, tutor_subject ts,tutor_teaching_segment tts where td.tutor_id = ts.tutor_id and td.tutor_id = tts.tutor_id and td.tutor_id = '" + tutorId + "' and td.location_id = "+tutorLocation+"  and ts.subject_id = "+tutorSubject+" and tts.education_segment_id = "+tutorLevel );
                }

                System.out.println("Search Sql Query :: " + sqlQueryPart.toString());
                
                pst = conn.prepareStatement(sqlQueryPart.toString());
                rst = pst.executeQuery();
                while (rst.next()) {            
                    listOfSearchTutorIds.add(rst.getString("tutor_id"));
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
        return listOfSearchTutorIds;
  }

  /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public TutorRegistrationVO populateTutorProfileByTutorId(String tutorId,Connection conn,PreparedStatement pstmt,ResultSet rst) throws Exception, ProfessionalTutorsException {
       // Connection conn = null;
        //PreparedStatement pstmt = null;
        //ResultSet rst = null;

        
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        if (null != tutorId) {
            try {

              //  conn = DbSearchConnectionPool.paidTutorDbSearchConnection();

                StringBuffer sqlQueryPart = new StringBuffer("select td.tutor_id ,td.name ,td.age,td.gender, cn.country_name,loc.location_name ,td.address ,td.contact_number ,td.email_address ,td.years_of_tutoring_experience,td.preferred_tutoring_area,td.expected_fees,td.tutoring_experience,td.registration_date,td.image_flag,td.membership_category from tutor_details  td ,country_name cn , location_name loc where td.country_code = cn.country_code and td.location_id = loc.location_id and td.tutor_id=?");
                System.out.println("tutorId--> "+ tutorId);
                pstmt = conn.prepareStatement(sqlQueryPart.toString());
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    /* Tutor Login Information */
                    tutorRegistrationVO.setTutorId(rst.getString("tutor_id"));
                    tutorRegistrationVO.setTutorName(rst.getString("name"));


                    /* Tutor Personal Information */
                    tutorRegistrationVO.setTutorSex(rst.getString("gender"));
                    tutorRegistrationVO.setTutorAge(rst.getString("age"));
                    tutorRegistrationVO.setTutorCountryLocation(rst.getString("country_name"));
                    tutorRegistrationVO.setTutorCityLocation(rst.getString("location_name"));
                    tutorRegistrationVO.setTutorAddress(rst.getString("address"));
                    tutorRegistrationVO.setContactNumber(rst.getString("contact_number"));
                    tutorRegistrationVO.setTutorEmailId(rst.getString("email_address"));


                    /* Tutor Tutoring Information */
                    tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("years_of_tutoring_experience"));
                    tutorRegistrationVO.setPreferredTutoringArea(rst.getString("preferred_tutoring_area"));
                    tutorRegistrationVO.setFeeExpected(rst.getString("expected_fees"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("tutoring_experience"));
                    tutorRegistrationVO.setImageFlag(rst.getBoolean("image_flag"));
                    tutorRegistrationVO.setMembershipCategory(rst.getString("membership_category"));
                    System.out.println("MembershipCategory ::  " + rst.getString("membership_category"));
                    tutorRegistrationVO.setRegistrationDate(rst.getString("registration_date"));
                   
                } // End of While loop


                String selectUgQualification = "select cn.course_short_name ,sub.subject_name ,unv.university_institute_name , tue.year_of_passout from tutor_ug_education tue , course_name cn ,subject sub ,university_institute unv where tue.subject_id = sub.subject_id and  tue.course_id = cn.course_id and tue.university_institute_id = unv.university_institute_id and tue.tutor_id =?";

                pstmt = conn.prepareStatement(selectUgQualification);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    tutorRegistrationVO.setUgQualifyingDegree(rst.getString("course_short_name"));
                    tutorRegistrationVO.setUgSpecialization(rst.getString("subject_name"));
                    tutorRegistrationVO.setUgBoardOrUniversity(rst.getString("university_institute_name"));
                    tutorRegistrationVO.setUgPassoutYear(rst.getString("year_of_passout"));
                } // End of While loop



                String selectPgQualification = "select cn.course_short_name , sub.subject_name,unv.university_institute_name , tpe.year_of_passout from tutor_pg_education tpe , course_name cn ,subject sub ,university_institute unv where tpe.subject_id = sub.subject_id and tpe.course_id = cn.course_id and tpe.university_institute_id = unv.university_institute_id and tpe.tutor_id =?";
                pstmt = conn.prepareStatement(selectPgQualification);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();

                if (rst.next()) {
                    tutorRegistrationVO.setPgQualifyingDegree(rst.getString("course_short_name"));
                    tutorRegistrationVO.setPgSpecialization(rst.getString("subject_name"));
                    tutorRegistrationVO.setPgBoardOrUniversity(rst.getString("university_institute_name"));
                    tutorRegistrationVO.setPgPassoutYear(rst.getString("year_of_passout"));
                }

                String selectSubject = "select sub.subject_name from tutor_subject ts, subject sub where ts.subject_id = sub.subject_id and ts.tutor_id =?";

                pstmt = conn.prepareStatement(selectSubject);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strSubject = new StringBuilder();
                List<String> listOfTeachingSubjects = new ArrayList<String>();
                while (rst.next()) {
                    strSubject.append(rst.getString("subject_name"));
                    strSubject.append(" ");
                    strSubject.append(",");
                    listOfTeachingSubjects.add(rst.getString("subject_name"));
                   
                } // End of While loop
                tutorRegistrationVO.setListOfTeachingSubjects(listOfTeachingSubjects);

                String selectTeachingLevel = "select ecat.education_segment_name from tutor_teaching_segment tts, education_categories ecat where tts.education_segment_id = ecat.education_segment_id and tts.tutor_id =?";


                pstmt = conn.prepareStatement(selectTeachingLevel);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingLevel = new StringBuilder();
                List<String> listOfTeachingLevel = new ArrayList<String>();
                while (rst.next()) {
                    strTeachingLevel.append(rst.getString("education_segment_name"));
                    strTeachingLevel.append(" ");
                    strTeachingLevel.append(",");
                    listOfTeachingLevel.add(rst.getString("education_segment_name"));
                   
                   
                } // End of While loop
                tutorRegistrationVO.setListOfTeachingLevel(listOfTeachingLevel);
             

                String selectTeachingMedium = "select tmed.medium_name from tutor_medium tm, teaching_medium tmed where tm.medium_id = tmed.medium_id and tm.tutor_id =?";


                pstmt = conn.prepareStatement(selectTeachingMedium);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingMedium = new StringBuilder();
                while (rst.next()) {
                    strTeachingMedium.append(rst.getString("medium_name"));
                    strTeachingMedium.append(" ");
                    strTeachingMedium.append(",");
                    
                } // End of While loop


                String selectTeachingOption = "select teaching_option_name from teaching_option topt ,tutor_teaching_option tto where topt.teaching_option_id = tto.teaching_option_id and tutor_id =?";
                pstmt = conn.prepareStatement(selectTeachingOption);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTutoringOptions = new StringBuilder();
                while (rst.next()) {
                    strTutoringOptions.append(rst.getString("teaching_option_name"));
                    strTutoringOptions.append(" ");
                    strTutoringOptions.append(",");
                    
                } // End of While loop

                String selectTeachingPatteren = "select teaching_patteren_name from teaching_patteren tpat ,tutor_teaching_patteren ttp where tpat.teaching_patteren_id = ttp.teaching_patteren_id and ttp.tutor_id =?";
                pstmt = conn.prepareStatement(selectTeachingPatteren);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingPatteren = new StringBuilder();
                while (rst.next()) {
                    strTeachingPatteren.append(rst.getString("teaching_patteren_name"));
                    strTeachingPatteren.append(" ");
                    strTeachingPatteren.append(",");
                    
                } // End of While loop



                if (!"".equalsIgnoreCase(strSubject.toString()) && null != strSubject.toString()) {
                    tutorRegistrationVO.setPreferenceToTeaching(strSubject.toString().substring(0, strSubject.length() - 1));
                }

                if (!"".equalsIgnoreCase(strTeachingLevel.toString()) && null != strTeachingLevel.toString()) {
                    tutorRegistrationVO.setTeachingLevel(strTeachingLevel.toString().substring(0, strTeachingLevel.length() - 1));
                }

                if (!"".equalsIgnoreCase(strTeachingMedium.toString()) && null != strTeachingMedium.toString()) {
                    tutorRegistrationVO.setTeachingMedium(strTeachingMedium.toString().substring(0, strTeachingMedium.length() - 1));
                }

                if (!"".equalsIgnoreCase(strTutoringOptions.toString()) && null != strTutoringOptions.toString()) {
                    tutorRegistrationVO.setTutoringOptions(strTutoringOptions.toString().substring(0, strTutoringOptions.length() - 1));
                }

                if (!"".equalsIgnoreCase(strTeachingPatteren.toString()) && null != strTeachingPatteren.toString()) {
                    tutorRegistrationVO.setTutorTeachingPatteren(strTeachingPatteren.toString().substring(0, strTeachingPatteren.length() - 1));
                }



            }// End of Try block.
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.getMessage();
                throw exception;
            }
        }
        return tutorRegistrationVO;
    }

}
