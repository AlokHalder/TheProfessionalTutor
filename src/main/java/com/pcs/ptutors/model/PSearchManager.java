
package com.pcs.ptutors.model;

import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import com.pcs.ptutors.model.DbConnection;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.model.DbConnectionPool;
import com.pcs.ptutors.vo.SearchResultVO;
import com.pcs.ptutors.model.SearchVO;
import com.pcs.ptutors.util.DateConversion;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHANDAN
 */
public class PSearchManager {
    
    public static String generateQuery(SearchVO searchVO) {
        StringBuilder generateQuery = null;
        int searchOption = Integer.parseInt(searchVO.getSearchoptions());
        String searchInLocation = searchVO.getTutorCityLocation();
        String searchForSubject = searchVO.getMainsubject();
        String searchOfLavel = searchVO.getTeachingLevel();
        switch (searchOption) {
            case 1:
            
            case 2:
                generateQuery = new StringBuilder("select IMAGE_FLAG, STUDENT_ID,GENDER,REGISTRATION_DATE,tution_remarks,NAME,AREA,LOCATION_NAME,SUBJECT_NAME,EDUCATION_SEGMENT_NAME from education_categories educ,student_details stud,location_name locn,subject sbjt where educ.EDUCATION_SEGMENT_ID=stud.EDUCATION_SEGMENT_ID and sbjt.SUBJECT_ID= stud.TUTION_REQUIRED_SUBJECT_ID and locn.LOCATION_ID=stud.LOCATION_ID and ");
                 if(searchOfLavel.equals("0")&&searchForSubject.equals("0") &&searchInLocation.equals("0")){
                    generateQuery.append("locn.COUNTRY_CODE=stud.COUNTRY_CODE").append(" and ");
                    System.out.println("COUNTRY_CODECOUNTRY_CODECOUNTRY_CODE in service....");
               }
                 else{
                generateQuery.append("stud.LOCATION_ID=").append(searchInLocation).append(" and ");
                if (!searchForSubject.equals("-1")) {
                    generateQuery.append("stud.TUTION_REQUIRED_SUBJECT_ID=").append(searchForSubject).append(" and ");
                }
                
                if (!searchOfLavel.equals("-1")) {
                    generateQuery.append("stud.TUTION_SEGMENT_ID=").append(searchOfLavel).append(" and ");
                }
                 }
                break;
            case 3:
                 generateQuery = new StringBuilder("SELECT distinct td.`TUTOR_ID`,td.`NAME`,td.`GENDER`,td.`AGE`,td.`AREA_NAME`,tp.`TEACHING_PATTEREN_NAME`,td.`YEARS_OF_TUTORING_EXPERIENCE`,td.`REGISTRATION_DATE`,sub.`SUBJECT_NAME`,locn.`LOCATION_NAME`,tp.`TEACHING_PATTEREN_NAME` FROM `location_name` locn, `tutor_teaching_patteren` ttp ,`tutor_details` td, `teaching_patteren` tp, `subject` sub, `tutor_subject` tsub,`tutor_teaching_segment` tts WHERE tp.`TEACHING_PATTEREN_ID` = ttp.`TEACHING_PATTEREN_ID` AND tsub.`SUBJECT_ID`=sub.`SUBJECT_ID` and locn.`LOCATION_ID`=td.`LOCATION_ID` AND ttp.`TUTOR_ID`=td.`TUTOR_ID` AND tts.`TUTOR_ID`=td.`TUTOR_ID` AND td.`TUTOR_ID`=tsub.`TUTOR_ID` and ttp.TEACHING_PATTEREN_ID=3 AND ");
                if (searchOfLavel.equals("0") && searchForSubject.equals("0") && searchInLocation.equals("0")) {
                    generateQuery.append("locn.COUNTRY_CODE=td.COUNTRY_CODE").append(" and ");

                } else {
                    generateQuery.append("td.LOCATION_ID=").append(searchInLocation).append(" and ");
                    if (!searchForSubject.equals("-1")) {
                        generateQuery.append("tsub.SUBJECT_ID=").append(searchForSubject).append(" and ");
                    }

                    if (!searchOfLavel.equals("-1")) {
                        generateQuery.append("tts.`EDUCATION_SEGMENT_ID`=").append(searchOfLavel).append(" and ");
                    }
                }
               
                break;
            case 4:
                
                generateQuery = new StringBuilder("SELECT tc.INSTITUTE_ID,tc.INSTITUTE_FULL_NAME,tc.INSTITUTE_AREA,tc.INSTITUTE_WEBSITE,tc.INSTITUTE_COURSES,tc.INSTITUTE_FACULTY,tc.INSTITUTE_ACHIVEMENT,locn.LOCATION_NAME FROM tutorial_center tc,location_name locn WHERE tc.INSTITUTE_LOCATION_ID=locn.LOCATION_ID and ");
                //generateQuery.append("tc.INSTITUTE_LOCATION_ID =").append(searchInLocation);
                 if (searchInLocation.equals("0")) {
                     System.out.println("contry====================================");
                    generateQuery.append("locn.COUNTRY_CODE=tc.INSTITUTE_COUNTRY_CODE").append(" and ");

                } else {
                    generateQuery.append("tc.INSTITUTE_LOCATION_ID=").append(searchInLocation).append(" and ");
                     System.out.println("else  #######################################");
                    if (!searchInLocation.equals("-1")) {
                       generateQuery.append("tc.INSTITUTE_LOCATION_ID=").append(searchInLocation).append(" and ");
                    }

                    if (!searchInLocation.equals("-1")) {
                        generateQuery.append("tc.INSTITUTE_LOCATION_ID=").append(searchInLocation).append(" and ");
                    }
                }
                break;
            case 5:
                 generateQuery = new StringBuilder("SELECT distinct td.`TUTOR_ID`,td.`NAME`,td.`GENDER`,td.`AGE`,td.`AREA_NAME`,tp.`TEACHING_PATTEREN_NAME`,td.`YEARS_OF_TUTORING_EXPERIENCE`,td.`REGISTRATION_DATE`,sub.`SUBJECT_NAME`,locn.`location_name` FROM `tutor_teaching_patteren` ttp ,`tutor_details` td, `teaching_patteren` tp, `subject` sub, `tutor_subject` tsub,`tutor_teaching_segment` tts, `location_name` locn WHERE tp.`TEACHING_PATTEREN_ID` = ttp.`TEACHING_PATTEREN_ID` AND tsub.`SUBJECT_ID`=sub.`SUBJECT_ID` AND ttp.`TUTOR_ID`=td.`TUTOR_ID` AND tts.`TUTOR_ID`=td.`TUTOR_ID` AND td.`TUTOR_ID`=tsub.`TUTOR_ID` AND td.`location_id`=locn.`location_id` and ttp.TEACHING_PATTEREN_ID=5 and ");
                if (searchOfLavel.equals("0") && searchForSubject.equals("0") && searchInLocation.equals("0")) {
                    generateQuery.append("locn.COUNTRY_CODE=td.COUNTRY_CODE").append(" and ");

                } else {
                    generateQuery.append("td.LOCATION_ID=").append(searchInLocation).append(" and ");
                    if (!searchForSubject.equals("-1")) {
                        generateQuery.append("tsub.SUBJECT_ID=").append(searchForSubject).append(" and ");
                    }

                    if (!searchOfLavel.equals("-1")) {
                        generateQuery.append("tts.`EDUCATION_SEGMENT_ID`=").append(searchOfLavel).append(" and ");
                    }
                }
            case 6:
                break;
            case 7:
                break;
        }
        return generateQuery.substring(0, generateQuery.lastIndexOf(" and "));
    }
     public static int getSearchedTotalStudents(SearchVO  searchVO){
        int totalStudentCount=0;
         StringBuilder query=null;
         String searchInLocation = searchVO.getTutorCityLocation();
         System.out.println("searchInLocation in service....."+searchInLocation);
        String searchForSubject = searchVO.getMainsubject();
         System.out.println("searchForSubject in service....."+searchForSubject);
        String searchOfLavel = searchVO.getTeachingLevel();
         System.out.println("searchOfLavel in service....."+searchOfLavel);
           Connection conn = null;
        PreparedStatement pst = null;
        try{
           DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect(); 
            String countryCode="IND";
           query=new StringBuilder("select count(*) as total_student  FROM student_details  WHERE  ");
           if(searchOfLavel.equals("0")&&searchForSubject.equals("0") &&searchInLocation.equals("0")){
            String searchQuery=query.toString()+"COUNTRY_CODE=?";
            System.out.println("searchQuery in service if condition............."+searchQuery);
           pst=conn.prepareStatement(searchQuery);
           pst.setString(1, countryCode);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                   totalStudentCount = rs.getInt("total_student");
                   System.out.println("totalTutorCount in service............"+totalStudentCount);
            }
               }
           else{
            query.append("LOCATION_ID=").append(searchInLocation).append(" and ");
                if (!searchForSubject.equals("-1")) {
                    query.append("TUTION_REQUIRED_SUBJECT_ID=").append(searchForSubject).append(" and ");
                }
                
                if (!searchOfLavel.equals("-1")) {
                    query.append("TUTION_SEGMENT_ID=").append(searchOfLavel).append(" and ");
                }
           
           String searchQuery1=query.substring(0, query.lastIndexOf(" and ")).toString();
            System.out.println("searchQuery in service........"+searchQuery1);
           pst=conn.prepareStatement(searchQuery1);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                   totalStudentCount = rs.getInt("total_student");
                   System.out.println("totalTutorCount in service............"+totalStudentCount);
            }
            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.getMessage();
            exception.printStackTrace();

        } finally {
            try {

                if (null != pst) {
                    pst.close();
                }

                if (null != conn) {
                    conn.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        
        return totalStudentCount;
    }
    
    
    
    public static SearchResultVO getSearchedStudentsDetails(String searchQuery) {
        SearchResultVO searchResultVO = new SearchResultVO();
        Connection conection = DbConnectionPool.dbConnectOne();
        Statement statement = null;
        ResultSet resultSet = null;
        List<StudentRegistrationVO> listOfStudent = new ArrayList<StudentRegistrationVO>();
        try {
            statement = conection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()) {
                StudentRegistrationVO student = new StudentRegistrationVO();
                student.setImageFlag(resultSet.getBoolean("IMAGE_FLAG"));
                student.setStudentId(resultSet.getString("STUDENT_ID"));
                student.setName(resultSet.getString("NAME"));
                student.setArea(resultSet.getString("AREA"));
                student.setLandmark(resultSet.getString("LOCATION_NAME"));
                student.setSubject(resultSet.getString("SUBJECT_NAME"));
                student.setSegmentLevel(resultSet.getString("EDUCATION_SEGMENT_NAME"));
                student.setSex(resultSet.getString("GENDER"));
                student.setRegistrationDate(DateConversion.convertDate(resultSet.getString("REGISTRATION_DATE")));
                student.setClassstandard(resultSet.getString("EDUCATION_SEGMENT_NAME"));
                student.setTutionRemarks(resultSet.getString("tution_remarks"));
                
                listOfStudent.add(student);
            }
            searchResultVO.setListOfSearchedStudent(listOfStudent);
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        }finally{
            DbConnectionPool.dbClose(resultSet, statement, conection);
        }
        return searchResultVO;
    }
     public static List getneratePagination(List list, int pageNo) {
        List getnerateList = new ArrayList();
        int listSize = list.size();
        if (listSize > 0) {
            int min = ((pageNo - 1) * 10);
            int max = (min + 9);
            if (max > listSize || max == listSize) {
                max = (listSize - 1);
            }
            for (int index = min; index <= max; index++) {
                getnerateList.add(list.get(index));
            }
        }
        return getnerateList;
    }
     
     
     /**
  *  created by Ranjit for tutoring Job
  */
    
      public static SearchResultVO getSearchedTutoringJobsDetails(String searchQuery) {
        SearchResultVO searchResultVO = new SearchResultVO();
        Connection conection = DbConnectionPool.dbConnectOne();
        Statement statement = null;
        ResultSet resultSet = null;
        List<TutorRegistrationVO> listOfTutoringjobs = new ArrayList<TutorRegistrationVO>();
        List<String> listOfTeachingSubjects=new ArrayList<String>();
        TutorRegistrationVO tutoringJobs = new TutorRegistrationVO();
        try {
            statement = conection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()) {
                if(resultSet.getString("tutor_id")!=null && resultSet.getString("tutor_id").equalsIgnoreCase(tutoringJobs.getTutorId())){
                    tutoringJobs.setTeachingSubject(resultSet.getString("SUBJECT_NAME"));

                    listOfTeachingSubjects.add(resultSet.getString("SUBJECT_NAME"));

                }else{
                tutoringJobs = new TutorRegistrationVO();
                tutoringJobs.setTutorId(resultSet.getString("tutor_id"));
                tutoringJobs.setTutorName(resultSet.getString("name"));
                tutoringJobs.setTutorArea(resultSet.getString("area_name"));
                tutoringJobs.setTutorCityLocation(resultSet.getString("LOCATION_NAME"));
                //tutoringJobs.setTeachingSubject(resultSet.getString("SUBJECT_NAME"));
                listOfTeachingSubjects=new ArrayList<String>();
                listOfTeachingSubjects.add(resultSet.getString("SUBJECT_NAME"));
                tutoringJobs.setListOfTeachingSubjects(listOfTeachingSubjects);
                tutoringJobs.setTutorYearsOfExperience(resultSet.getString("years_of_tutoring_experience"));
                tutoringJobs.setTutorSex(resultSet.getString("GENDER"));
                tutoringJobs.setRegistrationDate(DateConversion.convertDate(resultSet.getString("REGISTRATION_DATE")));
                tutoringJobs.setTeachingLevel(resultSet.getString("TEACHING_PATTEREN_NAME"));

                listOfTutoringjobs.add(tutoringJobs);
                }
            }
            searchResultVO.setListOfSearchedTutoringJobs(listOfTutoringjobs);
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        } finally {
            DbConnectionPool.dbClose(resultSet, statement, conection);
        }
        return searchResultVO;
    }
      
        
      /**
       *  created by ranjit for online tutors
       */
 public static SearchResultVO getSearchedOnlineTutorsDetails(String searchQuery) {
        SearchResultVO searchResultVO = new SearchResultVO();
        Connection conection = DbConnectionPool.dbConnectOne();
        Statement statement = null;
        ResultSet resultSet = null;
        List<TutorRegistrationVO> listOfOnlineTutors = new ArrayList<TutorRegistrationVO>();
        TutorRegistrationVO onlineTutors = new TutorRegistrationVO();
         List<String> listOfTeachingSubjects=new ArrayList<String>();
        try {
            statement = conection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()) {
                 if(resultSet.getString("tutor_id")!=null && resultSet.getString("tutor_id").equalsIgnoreCase(onlineTutors.getTutorId())){
                    onlineTutors.setTeachingSubject(resultSet.getString("SUBJECT_NAME"));

                    listOfTeachingSubjects.add(resultSet.getString("SUBJECT_NAME"));

                }else{
                onlineTutors = new TutorRegistrationVO();
                onlineTutors.setTutorId(resultSet.getString("tutor_id"));
                onlineTutors.setTutorName(resultSet.getString("name"));
                onlineTutors.setTutorArea(resultSet.getString("area_name"));
                onlineTutors.setTutorCityLocation(resultSet.getString("LOCATION_NAME"));
                //onlineTutors.setTeachingSubject(resultSet.getString("SUBJECT_NAME"));
                  listOfTeachingSubjects=new ArrayList<String>();
                listOfTeachingSubjects.add(resultSet.getString("SUBJECT_NAME"));
                onlineTutors.setListOfTeachingSubjects(listOfTeachingSubjects);
                onlineTutors.setTutorYearsOfExperience(resultSet.getString("years_of_tutoring_experience"));
                onlineTutors.setTutorSex(resultSet.getString("GENDER"));
                onlineTutors.setRegistrationDate(DateConversion.convertDate(resultSet.getString("REGISTRATION_DATE")));
                onlineTutors.setTeachingLevel(resultSet.getString("TEACHING_PATTEREN_NAME"));

                listOfOnlineTutors.add(onlineTutors);
            }
            }
            searchResultVO.setListOfSearchedOnlineTutors(listOfOnlineTutors);
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        } finally {
            DbConnectionPool.dbClose(resultSet, statement, conection);
        }
        return searchResultVO;
    }
 
 
 public static SearchResultVO getSearchedTutorialDetails(String searchQuery) {
        SearchResultVO searchResultVO = new SearchResultVO();
        Connection conection = DbConnectionPool.dbConnectOne();
        Statement statement = null;
        ResultSet resultSet = null;
        List<TutorialCenterDataVO> listOfTutorial = new ArrayList<TutorialCenterDataVO>();
        try {
            statement = conection.createStatement();
            resultSet = statement.executeQuery(searchQuery);
            while (resultSet.next()) {
                TutorialCenterDataVO tutorialCenter = new TutorialCenterDataVO();
                tutorialCenter.setInstituteId(resultSet.getString("institute_Id"));
                tutorialCenter.setInstituteName(resultSet.getString("INSTITUTE_FULL_NAME"));
                tutorialCenter.setInstituteArea(resultSet.getString("INSTITUTE_AREA"));
                tutorialCenter.setInstituteWebsiteAddress(resultSet.getString("INSTITUTE_WEBSITE"));
                tutorialCenter.setInstituteCoursesOffered(resultSet.getString("INSTITUTE_COURSES"));
                tutorialCenter.setInstituteFacultyDetails(resultSet.getString("INSTITUTE_FACULTY"));
                tutorialCenter.setInstituteAchivement(resultSet.getString("INSTITUTE_ACHIVEMENT"));

                listOfTutorial.add(tutorialCenter);
            }
            searchResultVO.setListofsearchedTutorial(listOfTutorial);
        } catch (SQLException sQLException) {
            System.out.println(sQLException.getMessage());
        } finally {
            DbConnectionPool.dbClose(resultSet, statement, conection);
        }
        return searchResultVO;
    }

}

