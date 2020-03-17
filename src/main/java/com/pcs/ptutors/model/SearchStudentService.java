/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.model;

import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import com.pcs.ptutors.util.DateConversion;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  hello
 * @author ibm
 */
public class SearchStudentService  {

  public List<StudentRegistrationVO> populateSearchStudentResult(String pageNumber, StudentRegistrationVO studentRegistration){
       Connection conn = null;
       PreparedStatement pst = null;
       ResultSet rs = null;


       List<StudentRegistrationVO> listOfStudentSearchResult = new ArrayList<StudentRegistrationVO>();
        if (null != studentRegistration) {
            try {
            int i=Integer.parseInt(pageNumber);
            int pagePosition = (i - 1) * 10;

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

                String studentId = null;
                String studentLocation = null;
                String studentSubject=null;
                String studentLevel=null;

                if(null!= studentRegistration.getStudentId() && !"".equalsIgnoreCase(studentRegistration.getStudentId())){
                    studentId =studentRegistration.getStudentId();
                 
                }

                if(null != studentRegistration.getCityName() && !"".equalsIgnoreCase(studentRegistration.getCityName())){
                    studentLocation= studentRegistration.getCityName();
                }

                if(null != studentRegistration.getSubject() && !"".equalsIgnoreCase(studentRegistration.getSubject())){
                    studentSubject = studentRegistration.getSubject();
                }

                if(null != studentRegistration.getSegmentLevel() && !"".equalsIgnoreCase(studentRegistration.getSegmentLevel())){
                    studentLevel =studentRegistration.getSegmentLevel();
                }

                 System.out.println(" Subjec  Passing  ---- > " + studentSubject );


                /* Future Implementation need to implemnt View for Faster query..*/

                /* Search Default Query
                 * Formula  4c4  = 0
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject  null
                 * tutorLevel null
                 */
                System.out.println(" studentId : "+ studentId + "studentLocation : "+ studentLocation + " studentSubject : "+ studentSubject + "studentLevel : "+ studentLevel);
                StringBuilder sqlQueryPart = new StringBuilder();

                 if (null == studentId && null == studentLocation && null == studentSubject && null == studentLevel) {
                   sqlQueryPart.append("select sd.student_id ,sd.name , sd.tution_title, sub.subject_name , sd.area, loc.location_name, sd.registration_date from  student_details  sd ,subject sub ,location_name loc  where sd.tution_required_subject_id = sub.subject_id and sd.location_id = loc.location_id and sd.profile_active_deactive_status = 1 order by sd.registration_date desc limit "+pagePosition +",10");
                 }
                
                /* Search Query : 1
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null != studentId && null == studentLocation && null == studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.student_id = '" + studentId + "'");
                   }

                /* Search Query : 2
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * studentId  null
                 * studentLocation not null
                 * studentSubject null
                 * studentLevel null
                 */
                if (null == studentId && null != studentLocation &&  null == studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.location_id =" + studentLocation);
                   }

                /* Search Query : 3
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel null
                 */
                if(null == studentLocation &&  null == studentId && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.tution_required_subject_id = " + studentSubject);
                   }

                /* Search Query : 4
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel not null
                 */
                if(null == studentId && null == studentLocation && null == studentSubject &&  null != studentLevel) {
                    sqlQueryPart.append(" and sd.tution_segment_id = " + studentLevel);
                  }

                /* Search Query : 5
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation not null
                 * tutorSubject null
                 * tutorLevel null
                 *
                 */

                if (null != studentId && null != studentLocation && null == studentSubject && null == studentLevel) {

                    sqlQueryPart.append(" and  sd.student_id= '" + studentId + "' and sd.location_id = "+studentLocation);
                }

                 /* Search Query : 6
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject not null
                 * tutorLevel null
                 *
                 */

                if (null == studentId && null != studentLocation && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id =  " + studentLocation + " and sd.tution_required_subject_id = "+studentSubject);
                }

                 /* Search Query : 7
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel not null
                 *
                 */

                if (null == studentId && null == studentLocation && null != studentSubject && null !=studentLevel) {
                    sqlQueryPart.append("  and  sd.tution_required_subject_id = " +studentSubject + " and sd.tution_segment_id = "+studentLevel);
                }

               /* Search Query : 8
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel  null
                 *
                 */

                if (null != studentId && null == studentLocation && null != studentSubject && null ==studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "'  and sd.tution_required_subject_id = "+studentSubject);
                }

                /* Search Query : 9
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject  null
                 * tutorLevel  not null
                 *
                 */

                if (null == studentId && null != studentLocation && null == studentSubject && null !=studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id = " + studentLocation + " and sd.tution_segment_id = "+ studentLevel);
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

                if (null != studentId && null != studentLocation && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id =  '" + studentId + "' and sd.location_id= "+studentLocation+"  and sd.tution_required_subject_id = "+studentSubject );
                }

                 /* Search Query : 12
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId   null
                 * tutorLocation not null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null == studentId && null != studentLocation && null != studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id= " + studentLocation + " and sd.tution_required_subject_id = "+studentSubject+"  and sd.education_segment_id = "+studentLevel );
                }

                 /* Search Query : 13
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null == studentLocation && null != studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "' and  sd.tution_required_subject_id = "+studentSubject+"  and sd.tution_segment_id = "+studentLevel );
                }

                /* Search Query : 14
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null != studentLocation && null == studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id  = '" + studentId + "' and sd.location_id = '" +studentLocation  + "' and sd.tution_segment_id = "+studentLevel );
                }

                /* Search Query : 15
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   not null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null != studentLocation && null != studentSubject && null != studentLevel) {

                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "' and sd.location_id = "+ studentLocation+"  and sd.tution_required_subject_id = "+studentSubject+" and sd.tution_segment_id = "+ studentLevel );
                }

                 if(null != studentId || null != studentLocation || null != studentSubject || null != studentLevel){
                  sqlQueryPart.append(" and sd.profile_active_deactive_status = 1 order by sd.registration_date desc limit "+pagePosition+",10");

                }

               
                
                System.out.println("Search Sql Query :: " + sqlQueryPart.toString());

                pst = conn.prepareStatement(sqlQueryPart.toString());
                rs = pst.executeQuery();
                int counter = 0;
                while (rs.next()) {
                      System.out.println(" Counter : "+ counter++ );
                   StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
                   
                    /* Student Personal Information */
                    studentRegistrationVO.setStudentId(rs.getString("student_id"));
                    studentRegistrationVO.setName(rs.getString("name"));
                   // studentRegistrationVO.setCountryName(rs.getString("country_name"));
                    studentRegistrationVO.setCityName(rs.getString("location_name"));
                    studentRegistrationVO.setArea(rs.getString("area"));
                   // studentRegistrationVO.setGuardianname(rs.getString("guardian_name"));
                   // studentRegistrationVO.setContactNumber(rs.getString("contact_number"));
                   // studentRegistrationVO.setEmail(rs.getString("email_address"));
                   // studentRegistrationVO.setCalltime(rs.getString("call_time"));

                    /* Student Education Information */

                   /* String schoolBoardName = rs.getString("school_board_name");

                    if (schoolBoardName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                      //  studentRegistrationVO.setSchoolOrBoard(rs.getString("other_school_board"));
                    } else {
                        studentRegistrationVO.setSchoolOrBoard(schoolBoardName);
                    }
                     */
                    /*
                    String universityInstituteName = rs.getString("university_institute_name");
                    if (universityInstituteName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setUniversityOrInstitute(rs.getString("other_university_institute_name"));
                    } else {
                        studentRegistrationVO.setUniversityOrInstitute(universityInstituteName);

                    }
                    */
                    /*
                    String classStandard = rs.getString("education_segment_name");
                    if (classStandard.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setClassstandard(rs.getString("other_education_segment_name"));
                    } else {
                        studentRegistrationVO.setClassstandard(classStandard);
                    }
                     */
                    /*
                    String mediumName = rs.getString("medium_name");
                    if (mediumName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setMedium(rs.getString("other_medium_name"));
                    } else {
                        studentRegistrationVO.setMedium(mediumName);
                    }
                      */

                    /* Student Post Tution Requirement Information */
                    studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));

                  
                    String tutionRequirement = rs.getString("subject_name");
                    if (tutionRequirement.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                      //  studentRegistrationVO.setTutionRequirement(rs.getString("other_tution_required_subject_name"));
                    } else {
                        studentRegistrationVO.setTutionRequirement(tutionRequirement);
                    }
                    
                    /*
                    String segmentLevel = rs.getString("education_segment_name");

                    if (segmentLevel.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setSegmentLevel(rs.getString("other_tution_segment_name"));
                    } else {
                        studentRegistrationVO.setSegmentLevel(segmentLevel);
                    }
                    */

                  //  studentRegistrationVO.setTutionRemarks(rs.getString("tution_remarks"));

                    /* Internally Stored dat for Student */

                    studentRegistrationVO.setRegistrationDate(DateConversion.convertDate(rs.getString("registration_date")));
                /*    studentRegistrationVO.setImageFlag(rs.getBoolean("image_flag"));

                    studentRegistrationVO.setProfileVerificationStatus(rs.getString("profile_verification_status"));
                    studentRegistrationVO.setProfileActiveDeactiveStatus(rs.getString("profile_active_deactive_status"));

                    studentRegistrationVO.setMembershipCategory(rs.getString("membership_category"));
                    studentRegistrationVO.setDuration(rs.getString("duration"));

                    studentRegistrationVO.setModeOfPayment(rs.getString("mode_of_payment"));
                    studentRegistrationVO.setPaymentAmount(rs.getString("payment_amount"));
                    studentRegistrationVO.setMembershipBeginDate(rs.getString("membership_begin_date"));
                    studentRegistrationVO.setMembershipExpireWarningDate(rs.getString("membership_expire_warning_date"));
                    studentRegistrationVO.setMembershipExpireDate(rs.getString("membership_expire_date"));
                    */
                   
                    
                    listOfStudentSearchResult.add(studentRegistrationVO);
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

                    if (null != rs) {
                        rs.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
        return listOfStudentSearchResult;
  }


   public int searchStudentTotalResultCount(StudentRegistrationVO studentRegistration){
       Connection conn = null;
       PreparedStatement pst = null;
       ResultSet rs = null;
       int totalStudentCount = 0;

       List<StudentRegistrationVO> listOfStudentSearchResult = new ArrayList<StudentRegistrationVO>();
        if (null != studentRegistration) {
            try {
           

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

                String studentId = null;
                String studentLocation = null;
                String studentSubject=null;
                String studentLevel=null;

                if(null!= studentRegistration.getStudentId() && !"".equalsIgnoreCase(studentRegistration.getStudentId())){
                    studentId =studentRegistration.getStudentId();

                }

                if(null != studentRegistration.getCityName() && !"".equalsIgnoreCase(studentRegistration.getCityName())){
                    studentLocation= studentRegistration.getCityName();
                }

                if(null != studentRegistration.getSubject() && !"".equalsIgnoreCase(studentRegistration.getSubject())){
                    studentSubject = studentRegistration.getSubject();
                }

                if(null != studentRegistration.getSegmentLevel() && !"".equalsIgnoreCase(studentRegistration.getSegmentLevel())){
                    studentLevel =studentRegistration.getSegmentLevel();
                }

                 System.out.println(" Subjec  Passing  ---- > " + studentSubject );


                /* Future Implementation need to implemnt View for Faster query..*/

                /* Search Default Query
                 * Formula  4c4  = 0
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject  null
                 * tutorLevel null
                 */
                System.out.println(" studentId : "+ studentId + "studentLocation : "+ studentLocation + " studentSubject : "+ studentSubject + "studentLevel : "+ studentLevel);
                StringBuilder sqlQueryPart = new StringBuilder();

                 if (null == studentId && null == studentLocation && null == studentSubject && null == studentLevel) {
                   sqlQueryPart.append("select count(*) as total_student from  student_details  sd ,subject sub ,location_name loc  where sd.tution_required_subject_id = sub.subject_id and sd.location_id = loc.location_id and sd.profile_active_deactive_status = 1 order by sd.registration_date desc ");
                 }

                /* Search Query : 1
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel null
                 */
                if (null != studentId && null == studentLocation && null == studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.student_id = '" + studentId + "'");
                   }

                /* Search Query : 2
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * studentId  null
                 * studentLocation not null
                 * studentSubject null
                 * studentLevel null
                 */
                if (null == studentId && null != studentLocation &&  null == studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.location_id =" + studentLocation);
                   }

                /* Search Query : 3
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel null
                 */
                if(null == studentLocation &&  null == studentId && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append(" and sd.tution_required_subject_id = " + studentSubject);
                   }

                /* Search Query : 4
                 * Formula  4c1  = 4.3.2/1.(4-3) = 4
                 * tutorId  null
                 * tutorLocation  null
                 * tutorSubject null
                 * tutorLevel not null
                 */
                if(null == studentId && null == studentLocation && null == studentSubject &&  null != studentLevel) {
                    sqlQueryPart.append(" and sd.tution_segment_id = " + studentLevel);
                  }

                /* Search Query : 5
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation not null
                 * tutorSubject null
                 * tutorLevel null
                 *
                 */

                if (null != studentId && null != studentLocation && null == studentSubject && null == studentLevel) {

                    sqlQueryPart.append(" and  sd.student_id= '" + studentId + "' and sd.location_id = "+studentLocation);
                }

                 /* Search Query : 6
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject not null
                 * tutorLevel null
                 *
                 */

                if (null == studentId && null != studentLocation && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id =  " + studentLocation + " and sd.tution_required_subject_id = "+studentSubject);
                }

                 /* Search Query : 7
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel not null
                 *
                 */

                if (null == studentId && null == studentLocation && null != studentSubject && null !=studentLevel) {
                    sqlQueryPart.append("  and  sd.tution_required_subject_id = " +studentSubject + " and sd.tution_segment_id = "+studentLevel);
                }

               /* Search Query : 8
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId not null
                 * tutorLocation  null
                 * tutorSubject not null
                 * tutorLevel  null
                 *
                 */

                if (null != studentId && null == studentLocation && null != studentSubject && null ==studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "'  and sd.tution_required_subject_id = "+studentSubject);
                }

                /* Search Query : 9
                 * Formula  nc2  = 4.3.2/2.(4-2) = 6
                 * tutorId  null
                 * tutorLocation not null
                 * tutorSubject  null
                 * tutorLevel  not null
                 *
                 */

                if (null == studentId && null != studentLocation && null == studentSubject && null !=studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id = " + studentLocation + " and sd.tution_segment_id = "+ studentLevel);
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

                if (null != studentId && null != studentLocation && null != studentSubject && null == studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id =  '" + studentId + "' and sd.location_id= "+studentLocation+"  and sd.tution_required_subject_id = "+studentSubject );
                }

                 /* Search Query : 12
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId   null
                 * tutorLocation not null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null == studentId && null != studentLocation && null != studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.location_id= " + studentLocation + " and sd.tution_required_subject_id = "+studentSubject+"  and sd.education_segment_id = "+studentLevel );
                }

                 /* Search Query : 13
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  null
                 * tutorSubject  not null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null == studentLocation && null != studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "' and  sd.tution_required_subject_id = "+studentSubject+"  and sd.tution_segment_id = "+studentLevel );
                }

                /* Search Query : 14
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null != studentLocation && null == studentSubject && null != studentLevel) {
                    sqlQueryPart.append("  and  sd.student_id  = '" + studentId + "' and sd.location_id = '" +studentLocation  + "' and sd.tution_segment_id = "+studentLevel );
                }

                /* Search Query : 15
                 * Formula  4c3  = 4.3.2/3!.(4-3) = 4
                 * tutorId  not  null
                 * tutorLocation  not null
                 * tutorSubject   not null
                 * tutorLevel  not null
                 *
                 */

                if (null != studentId && null != studentLocation && null != studentSubject && null != studentLevel) {

                    sqlQueryPart.append("  and  sd.student_id = '" + studentId + "' and sd.location_id = "+ studentLocation+"  and sd.tution_required_subject_id = "+studentSubject+" and sd.tution_segment_id = "+ studentLevel );
                }

                 if(null != studentId || null != studentLocation || null != studentSubject || null != studentLevel){
                  sqlQueryPart.append(" and sd.profile_active_deactive_status = 1 order by sd.registration_date desc ");

                }



                System.out.println("Search Sql Query :: " + sqlQueryPart.toString());

                pst = conn.prepareStatement(sqlQueryPart.toString());
                rs = pst.executeQuery();
                int counter = 0;
                while (rs.next()) {
                   totalStudentCount = rs.getInt("total_student");
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

                    if (null != rs) {
                        rs.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }
        return totalStudentCount;
  }



}
