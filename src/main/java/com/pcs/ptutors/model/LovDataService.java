/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.model;

import com.pcs.ptutors.careercafe.vo.CareerCafeQuestionVO;
import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import com.pcs.ptutors.util.DateConversion;
import com.pcs.ptutors.util.MailSend;
import com.pcs.ptutors.vo.CountryVO;
import com.pcs.ptutors.vo.HomePageServiceVO;
import com.pcs.ptutors.vo.ListOfValuesVO;
import com.pcs.ptutors.vo.LocationVO;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ibm
 */
public class LovDataService {

    public List<LocationVO> populateRandomCityOnCountryCode(String countryName) {

        LocationVO locationVO;

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<LocationVO> listOfCityOfCountry = new ArrayList<LocationVO>();

        try {

            String sqlQuery = "select location_id,location_name from location_name where country_code = '" + countryName + "' order by location_name";
            conn = DbConnectionPool.dbConnectThree();

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                locationVO = new LocationVO();
                locationVO.setCityName(rs.getString("location_name"));
                locationVO.setCityCode(rs.getString("location_id"));

                listOfCityOfCountry.add(locationVO);

            }
        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }


        return listOfCityOfCountry;
    }

    public List<LocationVO> populateRandomCityOnCountryCode2() {

        LocationVO locationVO;

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<LocationVO> listOfCityOfCountry = new ArrayList<LocationVO>();

        try {

            String sqlQuery = "select location_id,location_name from location_name order by location_name";
            conn = DbConnectionPool.dbConnectThree();

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                locationVO = new LocationVO();
                locationVO.setCityName(rs.getString("location_name"));
                locationVO.setCityCode(rs.getString("location_id"));

                listOfCityOfCountry.add(locationVO);

            }
        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

        return listOfCityOfCountry;
    }

    public CountryVO populateCountryInfo(String countryCode, String locationId) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        CountryVO countryVO = new CountryVO();

        if (null != countryCode && null != locationId) {
            try {

                String sqlQuery = "select distinct location_name , country_name , country_national_flag from location_name loc , country_name cn where loc.country_code = cn.country_code and cn.country_code =? and loc.location_id =?";
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryCode);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, locationId);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    countryVO.setCountryName(rs.getString("country_name"));
                    countryVO.setLocationName(rs.getString("location_name"));
                    countryVO.setNationalFlag(rs.getString("country_national_flag"));
                }

            } catch (Exception exception) {
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != st) {
                        st.close();
                    }

                    if (null != rs) {
                        rs.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        }
        return countryVO;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<String> populateCityOfCountry(String countryName) {
        String defaultCountry = "India";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<String> listOfCityOfCountry = new ArrayList<String>();
        if (null != countryName) {
            defaultCountry = countryName;
        }
        try {

            String sqlQuery = "select distinct location_name from location_name where country_name='" + defaultCountry + "'";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            // conn = DbConnection.dbConnect();
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                listOfCityOfCountry.add(rs.getString("location_name"));

            }
            //listOfCityOfCountry =  compareListOfValues(listOfCityOfCountry);


        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

        return listOfCityOfCountry;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public String storeCountryName(String countryName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String message = null;

        try {
            String sqlQuery = "insert into country_name(country_name) values(?)";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                message = "Country name successfully inserted";
            } else {
                message = "Country name successfully insertion failed";
            }
        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pstmt) {
                    pstmt.close();
                }



            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return message;
    }

    /**
     *
     * @return
     */
    public List<CountryVO> populateCountryList() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<CountryVO> listOfCountry = new ArrayList<CountryVO>();

        try {
            String sqlQuery = "select country_code,country_name,country_national_flag from country_name order by country_name";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                CountryVO countryVO = new CountryVO();
                countryVO.setCountryCode(rs.getString("country_code"));
                countryVO.setCountryName(rs.getString("country_name"));
                countryVO.setNationalFlag(rs.getString("country_national_flag"));
                listOfCountry.add(countryVO);
            }
        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

        return listOfCountry;
    }

    public List<CountryVO> populateCountryNationalFlagList() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<CountryVO> listOfCountry = new ArrayList<CountryVO>();

        try {
            String sqlQuery = "select country_name,country_national_flag from country_name order by rand() limit 5";
            // DbConnection dbConnection = new DbConnection();
            conn = conn = DbConnectionPool.dbConnectTwo();


            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                CountryVO countryVO = new CountryVO();
                countryVO.setCountryName(rs.getString("country_name"));
                countryVO.setNationalFlag(rs.getString("country_national_flag"));
                listOfCountry.add(countryVO);
            }
        } catch (SQLException sqlException) {
            System.out.println("Message : " + sqlException.getMessage());
        } catch (Exception exception) {
            System.out.println("Mesage : " + exception.getMessage());
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

        return listOfCountry;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateLocationsOfCountry(String countryCode) {
        System.out.println(" countryCode available  :: " + countryCode);
        String defaultCountry = "IND";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<ListOfValuesVO> listOfLocations = new ArrayList<ListOfValuesVO>();
        if (null != countryCode) {
            defaultCountry = countryCode;
        }
        try {
            String sqlQuery = "select location_id,location_name from location_name loc, country_name cn where loc.country_code = cn.country_code and cn.country_code='" + defaultCountry + "'";

            conn = DbConnectionPool.dbConnectOne();

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelValue(rs.getString("location_id"));
                listOfValuesVO.setLabelName(rs.getString("location_name"));
                listOfLocations.add(listOfValuesVO);

            }
            listOfLocations = compareListOfValues(listOfLocations);

        } catch (Exception exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

        }

        return listOfLocations;
    }

    /**
     *
     * @param educationLevelVO
     * @return
     */
    public List<String> populateLimitedEducationLevel(String countryName) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<String> listOfEducationLevel = new ArrayList<String>();
        try {
            String sqlQuery = "select distinct educational_segment_level from tutor_categories  where country_name =? limit 10";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                listOfEducationLevel.add(rs.getString("EDUCATIONAL_SEGMENT_LEVEL"));
            }

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
        return listOfEducationLevel;
    }

    /**
     *
     * @param educationLevelVO
     * @return
     */
    public List<ListOfValuesVO> populateEducationLevel(String countryName) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<ListOfValuesVO> listOfEducationLevel = new ArrayList<ListOfValuesVO>();
        try {
            String sqlQuery = "select distinct education_segment_id,education_segment_name from education_categories";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            //pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelValue(rs.getString("education_segment_id"));
                listOfValuesVO.setLabelName(rs.getString("education_segment_name"));
                listOfEducationLevel.add(listOfValuesVO);
            }

            listOfEducationLevel = compareListOfValues(listOfEducationLevel);

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
        return listOfEducationLevel;
    }

    /**
     *
     * @param countryName
     * @param cityName
     * @return
     */

    /*
     public List<String> populateEducationSubjectLevel(String countryName, String cityName, String educationLevel) {
     Connection conn = null;
     ResultSet rs = null;
     PreparedStatement pstmt = null;
     List<String> listOfEducationSubjectLevel = new ArrayList<String>();
     try {
     String sqlQuery = " select * from education_subject_level_lov where country_name =? and city_location_name =? and education_segment_or_level=?";
     // System.out.println("sqlQuery :: " + sqlQuery);
     conn = DbConnection.dbConnect();
     pstmt = conn.prepareStatement(sqlQuery);
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, cityName);
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, educationLevel);
     rs = pstmt.executeQuery();
     while (rs.next()) {
     listOfEducationSubjectLevel.add(rs.getString("SUBJECT_LEVEL"));
     }



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
     return listOfEducationSubjectLevel;
     }
     */
    /**
     *
     * @param educationLevelVO
     * @return
     */
    /* public ResultVO storeEducationLevel(EducationLevelVO educationLevelVO) {
     Connection conn = null;
     Statement st = null;
     ResultSet rs = null;
     PreparedStatement pstmt = null;
     ResultVO resultVO = new ResultVO();
     try {
     String countryName = educationLevelVO.getCountryName();
     String cityName = educationLevelVO.getCityName();
     String educationLevel = educationLevelVO.getEducationLevel();
     conn = DbConnection.dbConnect();

     pstmt = conn.prepareStatement("insert into education_level_lov (country_name,city_location_name,education_level) values(?,?,?)");
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, cityName);
     pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, educationLevel);
     int resultFlag = pstmt.executeUpdate();

     if (resultFlag > 0) {
     resultVO.setValidationMessage(" One set of education level record successsfully inserted");
     } else {
     resultVO.setValidationMessage(" One set of education level record successsfully insertion failed");
     }

     } catch (Exception exception) {
     System.out.println(" exception : " + exception.getMessage());
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
     return resultVO;
     }
     */
    public List<StudentRegistrationVO> populateLimitedRegisteredStudents() {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<StudentRegistrationVO> listOfResentRegisteredStudents = new ArrayList<StudentRegistrationVO>();

        try {

            String sqlQuery = "select student_id,name,registration_date from student_details  order by registration_date desc limit 7 ";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();

                // Student login information
                studentRegistrationVO.setStudentId(rs.getString("student_id"));
                studentRegistrationVO.setName(rs.getString("name"));
                String registrationDate = rs.getString("registration_date");
                String convertDate = convertDate(registrationDate);
                studentRegistrationVO.setRegistrationDate(convertDate);

                listOfResentRegisteredStudents.add(studentRegistrationVO);
            }

        } catch (Exception exception) {
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

        return listOfResentRegisteredStudents;
    }

    /**
     *
     * @return
     */
    public List<TutorRegistrationVO> populateLimitedResentRegisteredTutors() {
        Connection conn = null;
        ResultSet rst = null;
        PreparedStatement pstmt = null;
        List<TutorRegistrationVO> listOfResentRegisteredTutor = new ArrayList<TutorRegistrationVO>();
        try {

            String sqlQuery = "select tutor_id,name,location_name, registration_date from tutor_details td , location_name loc where td.location_id = loc.location_id and  profile_active_deactive_status = 1 and registration_date is not null order by registration_date desc limit 6";

            conn = DbConnectionPool.dbConnectSix();

            /*   java.util.Random rand = new java.util.Random();
             int size = DbConnectionPool.getInstance().dbConnectPool().size();
             int i = rand.nextInt(size);
             System.out.print(" Position of Connection object  ::--------------------------------> " + i);
             conn = DbConnectionPool.getInstance().dbConnectPool().get(i);
             */

            pstmt = conn.prepareStatement(sqlQuery);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();

                /* Tutor Login Information */
                tutorRegistrationVO.setTutorId(rst.getString("tutor_id"));
                tutorRegistrationVO.setTutorName(rst.getString("name"));
                tutorRegistrationVO.setTutorCityLocation(rst.getString("location_name"));
                String registrationDate = rst.getString("registration_date");

                String convertDate = convertDate(registrationDate);
                tutorRegistrationVO.setTutorRegistrationDate(convertDate);

                listOfResentRegisteredTutor.add(tutorRegistrationVO);
            }

        } catch (Exception exception) {
            System.out.println(" exception : " + exception.getMessage());
            exception.printStackTrace();
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
                sqlException.printStackTrace();
            }
        }
        System.out.println(" listOfResentRegisteredTutor size :  " + listOfResentRegisteredTutor.size());
        return listOfResentRegisteredTutor;
    }

    /**
     *
     * @return
     */
    public List<TutorRegistrationVO> populateFreeRegisteredTutors() {
        Connection conn = null;
        ResultSet rst = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;

        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;


        List<TutorRegistrationVO> listOfResentRegisteredTutor = new ArrayList<TutorRegistrationVO>();
        try {

            String sqlQuery = "select * from tutor_details where  profile_active_deactive_status = 1 and  membership_category = 'Free' and registration_date is not null  order by registration_date desc";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();

                /* Tutor Personal Information */
                tutorRegistrationVO.setTutorId(rst.getString("TUTOR_ID"));
                tutorRegistrationVO.setTutorName(rst.getString("NAME"));
                tutorRegistrationVO.setTutorSex(rst.getString("GENDER"));
                tutorRegistrationVO.setTutorAge(rst.getString("AGE"));
                tutorRegistrationVO.setPreferredTutoringArea(rst.getString("PREFERRED_TUTORING_AREA"));
                tutorRegistrationVO.setImageFlag(rst.getBoolean("IMAGE_FLAG"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));

                String registrationDate = rst.getString("REGISTRATION_DATE");

                String tutorId = rst.getString("TUTOR_ID");
                String selectSubject = "select sub.subject_name from tutor_subject ts, subject sub where ts.subject_id = sub.subject_id and ts.tutor_id =?";

                pstmt2 = conn.prepareStatement(selectSubject);
                pstmt2.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs2 = pstmt2.executeQuery();
                StringBuilder strSubject = new StringBuilder();
                while (rs2.next()) {
                    strSubject.append(rs2.getString("subject_name"));
                    strSubject.append(",");
                } // End of While loop


                if (!"".equalsIgnoreCase(strSubject.toString()) && null != strSubject.toString()) {
                    tutorRegistrationVO.setPreferenceToTeaching(strSubject.toString().substring(0, strSubject.length() - 1));
                }

                String selectUgQualification = "select cn.course_short_name ,sub.subject_name from tutor_ug_education tue , course_name cn ,subject sub  where tue.subject_id = sub.subject_id and  tue.course_id = cn.course_id and tue.tutor_id =?";
                pstmt3 = conn.prepareStatement(selectUgQualification);
                pstmt3.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs3 = pstmt3.executeQuery();

                if (rs3.next()) {
                    tutorRegistrationVO.setUgQualifyingDegree(rs3.getString("course_short_name"));
                    tutorRegistrationVO.setUgSpecialization(rs3.getString("subject_name"));

                }
                String selectPgQualification = "select cn.course_short_name , sub.subject_name from tutor_pg_education tpe , course_name cn ,subject sub where tpe.subject_id = sub.subject_id and tpe.course_id = cn.course_id and tpe.tutor_id =?";
                pstmt4 = conn.prepareStatement(selectPgQualification);
                pstmt4.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs4 = pstmt4.executeQuery();

                if (rs4.next()) {
                    tutorRegistrationVO.setPgQualifyingDegree(rs4.getString("course_short_name"));
                    tutorRegistrationVO.setPgSpecialization(rs4.getString("subject_name"));
                }


                String convertDate = convertDate(registrationDate);
                tutorRegistrationVO.setTutorRegistrationDate(convertDate);

                listOfResentRegisteredTutor.add(tutorRegistrationVO);
            }

        } catch (Exception exception) {
            System.out.println(" exception : " + exception.getMessage());
            exception.printStackTrace();
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
                sqlException.printStackTrace();
            }
        }
        return listOfResentRegisteredTutor;
    }

    /**
     *
     * @return
     */
    public List<TutorRegistrationVO> populatePaidRegisteredTutors() {
        Connection conn = null;
        ResultSet rst = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs4 = null;

        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;


        List<TutorRegistrationVO> listOfResentRegisteredTutor = new ArrayList<TutorRegistrationVO>();
        try {

            String sqlQuery = "select * from tutor_details where  profile_active_deactive_status = 1 and  membership_category = 'Paid' and registration_date is not null  order by registration_date desc";
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            rst = pstmt.executeQuery();
            while (rst.next()) {
                TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();

                /* Tutor Personal Information */
                tutorRegistrationVO.setTutorId(rst.getString("TUTOR_ID"));
                tutorRegistrationVO.setTutorName(rst.getString("NAME"));
                tutorRegistrationVO.setTutorSex(rst.getString("GENDER"));
                tutorRegistrationVO.setTutorAge(rst.getString("AGE"));
                tutorRegistrationVO.setPreferredTutoringArea(rst.getString("PREFERRED_TUTORING_AREA"));
                tutorRegistrationVO.setImageFlag(rst.getBoolean("IMAGE_FLAG"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));
                tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));
                tutorRegistrationVO.setContactNumber(rst.getString("CONTACT_NUMBER"));
                tutorRegistrationVO.setMembershipCategory(rst.getString("membership_category"));

                String registrationDate = rst.getString("REGISTRATION_DATE");

                String tutorId = rst.getString("TUTOR_ID");
                String selectSubject = "select sub.subject_name from tutor_subject ts, subject sub where ts.subject_id = sub.subject_id and ts.tutor_id =?";

                pstmt2 = conn.prepareStatement(selectSubject);
                pstmt2.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs2 = pstmt2.executeQuery();
                StringBuilder strSubject = new StringBuilder();
                while (rs2.next()) {
                    strSubject.append(rs2.getString("subject_name"));
                    strSubject.append(",");
                } // End of While loop


                if (!"".equalsIgnoreCase(strSubject.toString()) && null != strSubject.toString()) {
                    tutorRegistrationVO.setPreferenceToTeaching(strSubject.toString().substring(0, strSubject.length() - 1));
                }

                String selectUgQualification = "select cn.course_short_name ,sub.subject_name from tutor_ug_education tue , course_name cn ,subject sub  where tue.subject_id = sub.subject_id and  tue.course_id = cn.course_id and tue.tutor_id =?";
                pstmt3 = conn.prepareStatement(selectUgQualification);
                pstmt3.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs3 = pstmt3.executeQuery();

                if (rs3.next()) {
                    tutorRegistrationVO.setUgQualifyingDegree(rs3.getString("course_short_name"));
                    tutorRegistrationVO.setUgSpecialization(rs3.getString("subject_name"));

                }
                String selectPgQualification = "select cn.course_short_name , sub.subject_name from tutor_pg_education tpe , course_name cn ,subject sub where tpe.subject_id = sub.subject_id and tpe.course_id = cn.course_id and tpe.tutor_id =?";
                pstmt4 = conn.prepareStatement(selectPgQualification);
                pstmt4.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs4 = pstmt4.executeQuery();

                if (rs4.next()) {
                    tutorRegistrationVO.setPgQualifyingDegree(rs4.getString("course_short_name"));
                    tutorRegistrationVO.setPgSpecialization(rs4.getString("subject_name"));
                }


                String convertDate = convertDate(registrationDate);
                tutorRegistrationVO.setTutorRegistrationDate(convertDate);

                listOfResentRegisteredTutor.add(tutorRegistrationVO);
            }

        } catch (Exception exception) {
            System.out.println(" exception : " + exception.getMessage());
            exception.printStackTrace();
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
                sqlException.printStackTrace();
            }
        }
        return listOfResentRegisteredTutor;
    }

    /**
     *
     * @return
     */
    public List<StudentRegistrationVO> populateResentRegisteredStudents(String cityName) {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<StudentRegistrationVO> listOfResentRegisteredStudents = new ArrayList<StudentRegistrationVO>();
        // if (null != cityName) {
        try {

            String sqlQuery = "select student_id, name,gender,age,country_name,location_name,area,landmark,address,guardian_name,contact_number,email_address,call_time,school_board_name ,other_school_board,university_institute_name,other_university_institute_name, education_segment_name,other_education_segment_name ,medium_name , other_medium_name,tution_title,subject_name,other_tution_required_subject_name,education_segment_name ,other_tution_segment_name,tution_remarks,registration_date,image_flag from student_details sd , country_name cn ,location_name loc,school_board sb,university_institute univ , education_categories ecat,teaching_medium tm , subject sub where sd.country_code = cn.country_code  and sd.location_id = loc.location_id and cn.country_code = loc.country_code and sd.school_board_id = sb.school_board_id and sd.university_institute_id =univ.university_institute_id and sd.education_segment_id = ecat.education_segment_id and sd.medium_id = tm.medium_id and sd.tution_required_subject_id = sub.subject_id  order by registration_date desc ";
            System.out.println("sqlQuery : " + sqlQuery);
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            // pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, cityName);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();

                /* Student login information */
                studentRegistrationVO.setStudentId(rs.getString("student_id"));
                studentRegistrationVO.setName(rs.getString("name"));
                System.out.println("Name  ::::::::::::::::: " + rs.getString("name"));
                /* Student Personal Information */
                studentRegistrationVO.setSex(rs.getString("gender"));
                studentRegistrationVO.setAge(rs.getString("age"));
                studentRegistrationVO.setCountryName(rs.getString("country_name"));
                studentRegistrationVO.setCityName(rs.getString("location_name"));
                studentRegistrationVO.setArea(rs.getString("area"));
                studentRegistrationVO.setLandmark(rs.getString("landmark"));
                studentRegistrationVO.setAddress(rs.getString("address"));
                studentRegistrationVO.setGuardianname(rs.getString("guardian_name"));
                studentRegistrationVO.setContactNumber(rs.getString("contact_number"));
                studentRegistrationVO.setEmail(rs.getString("email_address"));
                studentRegistrationVO.setCalltime(rs.getString("call_time"));

                /* Student Education Information */
                studentRegistrationVO.setSchoolOrBoard(rs.getString("school_board_name"));
                String otherSchoolBoardName = rs.getString("other_school_board");

                studentRegistrationVO.setUniversityOrInstitute(rs.getString("university_institute_name"));
                String otherUniversityInstituteName = rs.getString("other_university_institute_name");

                studentRegistrationVO.setClassstandard(rs.getString("education_segment_name"));
                String otherSegmentName = rs.getString("other_education_segment_name");

                studentRegistrationVO.setMedium(rs.getString("medium_name"));
                String otherMediumName = rs.getString("other_medium_name");


                /* Student Post Tution Requirement Information */
                studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));
                studentRegistrationVO.setTutionRequirement(rs.getString("subject_name"));
                String otherTutionRequirementSubject = rs.getString("other_tution_required_subject_name");

                studentRegistrationVO.setSegmentLevel(rs.getString("education_segment_name"));
                String otherSegmentLevels = rs.getString("other_tution_segment_name");

                studentRegistrationVO.setTutionRemarks(rs.getString("tution_remarks"));

                /* Internally Stored dat for Student */

                studentRegistrationVO.setRegistrationDate(rs.getString("registration_date"));
                studentRegistrationVO.setImageFlag(rs.getBoolean("image_flag"));
                // subject = rs.getString("subject");
                //countryName = rs.getString("country");
                //cityName = rs.getString("location");

                listOfResentRegisteredStudents.add(studentRegistrationVO);
            }

        } catch (Exception exception) {
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
        // }
        System.out.println(" listOfResentRegisteredStudents  :: " + listOfResentRegisteredStudents.size());
        return listOfResentRegisteredStudents;
    }

    /**
     *
     * @return
     */
    public LocationVO populateRandomCitySelectionBasedOnDefaultCountry(String countryCode) {
        String randomSelectedCity = null;
        LocationVO locationVO = new LocationVO();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        if (null != countryCode) {

            List<String> listOfCityOfCountry = new ArrayList<String>();
            try {
                String sqlQuery = "select location_id,location_name from location_name loc, country_name cn where loc.country_code = cn.country_code='" + countryCode + "'";
                System.out.println(" sqlQuery ::  " + sqlQuery);
                //String sqlQuery = "select distinct location_name from location_name where country_name='" + countryName + "'";
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                st = conn.createStatement();
                rs = st.executeQuery(sqlQuery);
                while (rs.next()) {
                    listOfCityOfCountry.add(rs.getString("location_name"));

                }
            } catch (Exception exception) {
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != st) {
                        st.close();
                    }

                    if (null != rs) {
                        rs.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }



            /**
             * Minimum length for a decent password
             */
            /**
             * The random number generator.
             */
            java.util.Random r = new java.util.Random();

            if (listOfCityOfCountry.size() > 0) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < 1; i++) {
                    sb.append(listOfCityOfCountry.get(r.nextInt(listOfCityOfCountry.size())));
                }
                randomSelectedCity = sb.toString();
            }
            locationVO.setCountryName(countryCode);
            locationVO.setCityName(randomSelectedCity);
        }
        return locationVO;
    }

    /**
     *
     * @return
     */
    public LocationVO populateRandomCitySelection(String countryCode) {
        String defaultCountryCode = "IND";
        String randomSelectedCity = null;
        LocationVO locationVO = new LocationVO();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<String> listOfCityOfCountry = new ArrayList<String>();

        if (null != countryCode) {
            defaultCountryCode = countryCode;
        }

        try {
            /*   java.util.Random rand = new java.util.Random();
             int size = DbConnectionPool.getInstance().dbConnectPool().size();
             int i = rand.nextInt(size);
             System.out.print(" Position of Connection object  ::--------------------------------> " + i);
             conn = DbConnectionPool.getInstance().dbConnectPool().get(i);
             * */

            //DbConnectionPool dbConnectionPool = new DbConnectionPool();
            conn = conn = DbConnectionPool.dbConnectNine();
            //// conn = dbConnection.dbConnect();

            String selecCountryName = "select country_name from country_name where country_code='" + defaultCountryCode + "'";
            pstmt = conn.prepareStatement(selecCountryName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                locationVO.setCountryCode(defaultCountryCode);
                locationVO.setCountryName(rs.getString("country_name"));
            }

            String sqlQuery = "select distinct loc.location_id, loc.location_name ,cn.country_code,cn.country_name from location_name loc ,country_name cn where loc.country_code = cn.country_code and cn.country_code ='" + defaultCountryCode + "'";


            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                listOfCityOfCountry.add(rs.getString("location_name"));

            }


        } catch (Exception exception) {
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


        /**
         * Minimum length for a decent password
         */
        /**
         * The random number generator.
         */
        java.util.Random r = new java.util.Random();

        if (listOfCityOfCountry.size() > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 1; i++) {
                sb.append(listOfCityOfCountry.get(r.nextInt(listOfCityOfCountry.size())));
            }
            randomSelectedCity = sb.toString();
        }
        locationVO.setCityName(randomSelectedCity);


        return locationVO;
    }

    /**
     *
     * @param countryName
     * @param cityName
     * @return
     */
    public List<ListOfValuesVO> populateSubjectSubCategory(String countryName) {

        List<ListOfValuesVO> listOfSubjectSubCategory = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select subject_id,subject_name from subject";

            conn = DbConnectionPool.dbConnectTen();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("subject_name"));
                listOfValuesVO.setLabelValue(rs.getString("subject_id"));
                listOfSubjectSubCategory.add(listOfValuesVO);
            }
            listOfSubjectSubCategory = compareListOfValues(listOfSubjectSubCategory);

        } catch (Exception exception) {
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
        return listOfSubjectSubCategory;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfTeachingMedium(String countryName) {

        List<ListOfValuesVO> listOfTeachingMedium = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select teaching_medium_name from teaching_medium where";

            StringBuilder sb = new StringBuilder(sqlQuery);
            if (null != countryName) {
                sb.append(" country_name = '" + countryName + "'");
            } else {
                sb.append(" country_name = 'India'");
            }
            /* if(null != cityName){
             sb.append(" and CITY_NAME = '"+cityName+ "'");
             }*/
            System.out.println("sb.toString() " + sb.toString());
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("teaching_medium_name"));
                listOfValuesVO.setLabelValue(rs.getString("teaching_medium_name"));
                listOfTeachingMedium.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingMedium;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfSchoolBoard(String countryCode) {

        List<ListOfValuesVO> listOfSchoolBoard = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        if (null != countryCode) {
            try {
                String sqlQuery = "select school_board_id , school_board_name from school_board where country_code = ?";
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryCode);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                    listOfValuesVO.setLabelName(rs.getString("school_board_name"));
                    listOfValuesVO.setLabelValue(rs.getString("school_board_id"));
                    listOfSchoolBoard.add(listOfValuesVO);
                }
                listOfSchoolBoard = compareListOfValues(listOfSchoolBoard);

            } catch (Exception exception) {
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
        return listOfSchoolBoard;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfUniversityInstitute(String countryName) {

        List<ListOfValuesVO> listOfUniversityInstitute = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select university_institute_id,university_institute_name from university_institute";
            /*
             StringBuilder sb = new StringBuilder(sqlQuery);
             if (null != countryName) {
             sb.append(" country_name = '" + countryName + "'");
             } else {
             sb.append(" country_name = 'India'");
             }
             if(null != cityName){
             sb.append(" and CITY_NAME = '"+cityName+ "'");
             }*/

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("university_institute_name"));
                listOfValuesVO.setLabelValue(rs.getString("university_institute_id"));
                listOfUniversityInstitute.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfUniversityInstitute;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfClassStandard(String countryName) {

        List<ListOfValuesVO> listOfClassStandard = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select class_standard_name from student_class_standard where";

            StringBuilder sb = new StringBuilder(sqlQuery);
            if (null != countryName) {
                sb.append(" country_name = '" + countryName + "'");
            } else {
                sb.append(" country_name = 'India'");
            }
            /* if(null != cityName){
             sb.append(" and CITY_NAME = '"+cityName+ "'");
             }*/
            System.out.println("sb.toString() " + sb.toString());
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("class_standard_name"));
                listOfValuesVO.setLabelValue(rs.getString("class_standard_name"));
                listOfClassStandard.add(listOfValuesVO);
            }
            listOfClassStandard = compareListOfValues(listOfClassStandard);

        } catch (Exception exception) {
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
        return listOfClassStandard;
    }

    /**
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfTeachingSegmentLevel(String countryName) {

        List<ListOfValuesVO> listOfTeachingMedium = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select educational_segment_level from tutor_categories where";

            StringBuilder sb = new StringBuilder(sqlQuery);
            if (null != countryName) {
                sb.append(" country_name = '" + countryName + "'");
            } else {
                sb.append(" country_name = 'India'");
            }
            /* if(null != cityName){
             sb.append(" and CITY_NAME = '"+cityName+ "'");
             }*/
            System.out.println("sb.toString() " + sb.toString());
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("educational_segment_level"));
                listOfValuesVO.setLabelValue(rs.getString("educational_segment_level"));
                listOfTeachingMedium.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingMedium;
    }

    public HomePageServiceVO populateOnLoadServices(String countryCode, String locationId) {
        List<StudentRegistrationVO> listOfInstantTutorRequirements = new ArrayList<StudentRegistrationVO>();
        List<TutorRegistrationVO> listOfResentRegisteredTutor = new ArrayList<TutorRegistrationVO>();
        List<TutorialCenterDataVO> listOfResentRegisteredInstitutes = new ArrayList<TutorialCenterDataVO>();
        List<String> listOfTutorIds = new ArrayList<String>();
        List<CareerCafeQuestionVO> careerCafeQuestionList = new ArrayList<CareerCafeQuestionVO>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int viewCounter = 0;
        HomePageServiceVO homePageServiceVO = new HomePageServiceVO();
        CareerCafeQuestionVO careerCafeQuestionVO = null;
        try {

            conn = DbConnectionPool.dbConnectEighteen();
            String tutorialcenter = "select tc.institute_id,tc.institute_full_name,lnc.location_name,tc.institute_registration_date FROM tutorial_center tc,location_name lnc WHERE tc.institute_location_id=lnc.location_id  ORDER BY institute_registration_date DESC LIMIT 5";
            //  String retrieveTutorsRequirementQuery = "select * from instant_post_tutor_requirement where profile_active_status=1 order by tution_posting_date desc limit 6";
            String retrieveTutorsRequirementQuery = "select sd.student_id,sd.name,sd.registration_time,sd.other_education_segment_name,sd.other_tution_required_subject_name,lnc.location_name,sub.subject_name,ec.education_segment_name,curtime() as curtime from student_details sd,location_name lnc,education_categories ec,subject sub where sd.location_id=lnc.location_id and sd.tution_required_subject_id=sub.subject_id and ec.education_segment_id=sd.education_segment_id and Curdate()=registration_date and sd.profile_active_deactive_status=1 ORDER BY registration_date DESC,registration_time DESC LIMIT 5";
            pst = conn.prepareStatement(retrieveTutorsRequirementQuery);
            rs = pst.executeQuery();

            while (rs.next()) {
                StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
                studentRegistrationVO.setStudentId(rs.getString("student_id"));
                studentRegistrationVO.setName(rs.getString("name"));
                // studentRegistrationVO.setGuardianname(rs.getString("guardian_name"));
                // studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));
                if(rs.getString("subject_name").equalsIgnoreCase("Other")){
                    studentRegistrationVO.setSubject(rs.getString("other_tution_required_subject_name"));
                }else{
                    studentRegistrationVO.setSubject(rs.getString("subject_name"));
                }
                if(rs.getString("education_segment_name").equalsIgnoreCase("Other")){
                    studentRegistrationVO.setSegmentLevel(rs.getString("other_education_segment_name"));
                }else{
                    studentRegistrationVO.setSegmentLevel(rs.getString("education_segment_name"));
                }
                studentRegistrationVO.setCityName(rs.getString("location_name"));
                String register_time = rs.getString("registration_time");
                String curtime = rs.getString("curtime");
                int h = Integer.parseInt(curtime.substring(0, 2)) - Integer.parseInt(register_time.substring(0, 2));
                int m = Integer.parseInt(curtime.substring(3, 5)) - Integer.parseInt(register_time.substring(3, 5));
                int s = Integer.parseInt(curtime.substring(6, 8)) - Integer.parseInt(register_time.substring(6, 8));
                if (h > 0) {
                    if (m < 0 && h == 1) {
                        studentRegistrationVO.setRegistrationDate((String.valueOf(60 + m)) + " minutes ago");
                    } else {
                        studentRegistrationVO.setRegistrationDate(String.valueOf(h) + " hours ago");
                    }
                } else if (m > 0) {
                    if (s < 0 && m == 1) {
                        studentRegistrationVO.setRegistrationDate((String.valueOf(60 + s)) + " seconds ago");
                    } else {
                        studentRegistrationVO.setRegistrationDate(String.valueOf(m) + " minutes ago");
                    }
                } else {
                    studentRegistrationVO.setRegistrationDate(String.valueOf(s) + " seconds ago");
                }
                //studentRegistrationVO.setRegistrationDate(rs.getString("registration_time"));


                listOfInstantTutorRequirements.add(studentRegistrationVO);

            }


            //String retrieveTutorsRequirementQuery = "select student_id,tution_title,name,guardian_name,subject_name,other_tution_required_subject_name,education_segment_name,other_tution_segment_name ,location_name ,registration_date from student_details sd ,subject sub ,education_categories  ec,location_name loc  where sd.tution_required_subject_id = sub.subject_id and sd.tution_segment_id = ec.education_segment_id  and sd.location_id =loc.location_id and profile_active_deactive_status=1 order by registration_date desc limit 6";
            if (listOfInstantTutorRequirements.size() <= 5) 
            {
                retrieveTutorsRequirementQuery = "select sd.student_id,sd.name,sd.registration_date,sd.other_education_segment_name,sd.other_tution_required_subject_name,lnc.location_name,sub.subject_name,ec.education_segment_name FROM student_details sd,location_name lnc,education_categories ec,subject sub WHERE sd.location_id=lnc.location_id AND sd.tution_required_subject_id=sub.subject_id AND ec.education_segment_id=sd.education_segment_id AND Curdate()>registration_date and sd.profile_active_deactive_status=1 ORDER BY registration_date DESC,registration_time DESC LIMIT 5";


                pst = conn.prepareStatement(retrieveTutorsRequirementQuery);
                rs = pst.executeQuery();

                while (rs.next() && listOfInstantTutorRequirements.size() <= 5) {
                    StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
                    studentRegistrationVO.setStudentId(rs.getString("student_id"));
                    studentRegistrationVO.setName(rs.getString("name"));
                    // studentRegistrationVO.setGuardianname(rs.getString("guardian_name"));
                    // studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));
                    //studentRegistrationVO.setSubject(rs.getString("subject_name"));
                    //studentRegistrationVO.setSegmentLevel(rs.getString("education_segment_name"));
                    if(rs.getString("subject_name").equalsIgnoreCase("Other")){
                        studentRegistrationVO.setSubject(rs.getString("other_tution_required_subject_name"));
                    }else{
                        studentRegistrationVO.setSubject(rs.getString("subject_name"));
                    }
                    if(rs.getString("education_segment_name").equalsIgnoreCase("Other")){
                        studentRegistrationVO.setSegmentLevel(rs.getString("other_education_segment_name"));
                    }else{
                        studentRegistrationVO.setSegmentLevel(rs.getString("education_segment_name"));
                    }
                    studentRegistrationVO.setCityName(rs.getString("location_name"));
                    studentRegistrationVO.setRegistrationDate(convertDate(rs.getString("registration_date")));


                    listOfInstantTutorRequirements.add(studentRegistrationVO);

                }
            }
            pst = conn.prepareStatement(tutorialcenter);
            rs = pst.executeQuery();

            while (rs.next()) {
                TutorialCenterDataVO tutorialCenterDataVO = new TutorialCenterDataVO();
                tutorialCenterDataVO.setInstituteId(rs.getString("institute_id"));
                tutorialCenterDataVO.setInstituteName(rs.getString("institute_full_name"));
                tutorialCenterDataVO.setInstituteArea(rs.getString("location_name"));
                tutorialCenterDataVO.setInstituteregistrationdate(rs.getString("institute_registration_date"));

                listOfResentRegisteredInstitutes.add(tutorialCenterDataVO);
            }
            homePageServiceVO.setListOfResentRegisteredInstitutes(listOfResentRegisteredInstitutes);


            homePageServiceVO.setListOfInstantTutorRequirements(listOfInstantTutorRequirements);

            //String retrieveResentTutorsQuery = "select tutor_id  from tutor_details where profile_active_deactive_status = 1 and registration_date is not order by registration_date desc limit 6";
            String retrieveResentTutorsQuery = "Select tutor_id from tutor_details where profile_active_deactive_status=1 order by registration_date DESC,registration_time DESC limit 5";

            String viewCounterQuery = "select view_counter from view_count";
            String insertViewCounterQuery = "update view_count set view_counter =?";
            String careerCafeQA = "select career_question_id,career_question, career_question_posted_by,date_format(career_question_posted_time, '%W %M %Y') as posted_time from career_cafe_question order by career_question_posted_time desc limit 6";
            String weeklyMessage = "select message from weekly_message";
            pst = conn.prepareStatement(retrieveResentTutorsQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                listOfTutorIds.add(rs.getString("tutor_id"));
            }
            for (String tutorId : listOfTutorIds) {
                TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
                StringBuffer sqlQueryPart = new StringBuffer("select td.tutor_id ,td.registration_time, td.name, loc.location_name,td.registration_date,curdate() as date,curtime() as curtime from tutor_details td , country_name cn , location_name loc where td.location_id = loc.location_id and cn.country_code = loc.country_code and td.tutor_id=?");

                pst = conn.prepareStatement(sqlQueryPart.toString());
                pst.setString(1, tutorId);

                rs = pst.executeQuery();
                while (rs.next()) {
                    tutorRegistrationVO.setTutorId(rs.getString("tutor_id"));
                    tutorRegistrationVO.setTutorName(rs.getString("name"));
                    tutorRegistrationVO.setTutorCityLocation(rs.getString("location_name"));
                    if (rs.getString("date").equalsIgnoreCase(rs.getString("registration_date"))) {
                        String register_time = rs.getString("registration_time");
                        String curtime = rs.getString("curtime");
                        int h = Integer.parseInt(curtime.substring(0, 2)) - Integer.parseInt(register_time.substring(0, 2));
                        int m = Integer.parseInt(curtime.substring(3, 5)) - Integer.parseInt(register_time.substring(3, 5));
                        int s = Integer.parseInt(curtime.substring(6, 8)) - Integer.parseInt(register_time.substring(6, 8));
                        if (h > 0) {
                            if (m < 0 && h == 1) {
                                tutorRegistrationVO.setRegistrationDate((String.valueOf(60 + m)) + " minutes ago");
                            } else {
                                tutorRegistrationVO.setRegistrationDate(String.valueOf(h) + " hours ago");
                            }
                        } else if (m > 0) {
                            if (s < 0 && m == 1) {
                                tutorRegistrationVO.setRegistrationDate((String.valueOf(60 + s)) + " seconds ago");
                            } else {
                                tutorRegistrationVO.setRegistrationDate(String.valueOf(m) + " minutes ago");
                            }
                        } else {
                            tutorRegistrationVO.setRegistrationDate(String.valueOf(s) + " seconds ago");
                        }
                    } else {
                        tutorRegistrationVO.setRegistrationDate(DateConversion.convertDate(rs.getString("registration_date")));
                    }

                }
                String selectTeachingLevel = "select ecat.education_segment_name from tutor_teaching_segment tts, education_categories ecat where tts.education_segment_id = ecat.education_segment_id and tts.tutor_id =?";


                pst = conn.prepareStatement(selectTeachingLevel);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs = pst.executeQuery();
                StringBuilder strTeachingLevel = new StringBuilder();
                List<String> listOfTeachingLevel = new ArrayList<String>();
                while (rs.next()) {
                    strTeachingLevel.append(rs.getString("education_segment_name"));
                    strTeachingLevel.append(" ");
                    strTeachingLevel.append(",");
                    listOfTeachingLevel.add(rs.getString("education_segment_name"));


                } // End of While loop
                tutorRegistrationVO.setListOfTeachingLevel(listOfTeachingLevel);
                listOfResentRegisteredTutor.add(tutorRegistrationVO);
            }
            homePageServiceVO.setListOfResentRegisteredTutor(listOfResentRegisteredTutor);

            pst = conn.prepareStatement(viewCounterQuery);
            rs = pst.executeQuery();
            if (rs.next()) {
                homePageServiceVO.setViewCounter(rs.getString("view_counter"));
                viewCounter = rs.getInt("view_counter");
            }

            pst = conn.prepareStatement(insertViewCounterQuery);

            pst.setInt(1, viewCounter + 1);
            System.out.println("viewCounter :: " + viewCounter);
            int rowsAffected = pst.executeUpdate();
            System.out.println(" rowsAffected viewCount  " + rowsAffected);

            pst = conn.prepareStatement(careerCafeQA);
            rs = pst.executeQuery();
            while (rs.next()) {
                careerCafeQuestionVO = new CareerCafeQuestionVO();
                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_id"));
                careerCafeQuestionVO.setCareerQuestion(rs.getString("career_question"));
                // careerCafeQuestionVO.setCareerQuestionAnswer();
                String postedBy = rs.getString("career_question_posted_by");

                String sqlPostedBy = "select name from career_cafe where member_id =" + postedBy;
                pst = conn.prepareStatement(sqlPostedBy);
                ResultSet postedRs = pst.executeQuery();
                if (postedRs.next()) {
                    careerCafeQuestionVO.setCareerQuestionPostedBy(postedRs.getString("name"));
                }
                careerCafeQuestionVO.setCareerQuestionPostedTime(rs.getString("posted_time"));
                careerCafeQuestionList.add(careerCafeQuestionVO);
            }
            homePageServiceVO.setCareerCafeQuestionList(careerCafeQuestionList);

            pst = conn.prepareStatement(weeklyMessage);
            rs = pst.executeQuery();
            if (rs.next()) {
                homePageServiceVO.setWeeklyMessage(rs.getString("message"));
            }


        } catch (SQLException sqlExcdeption) {
            StringWriter errors = new StringWriter();
            sqlExcdeption.printStackTrace(new PrintWriter(errors));

            try{
                new MailSend().sendErrorLog("errorLog", "sen.bikash@gmail.com", sqlExcdeption.getErrorCode()+", "+sqlExcdeption.getMessage()+", "+errors.toString());
            }catch(Exception e){}
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            StringWriter errors = new StringWriter();
            exception.printStackTrace(new PrintWriter(errors));

            try{
                new MailSend().sendErrorLog("errorLog", "sen.bikash@gmail.com" , exception.getMessage()+", "+errors.toString());
            }catch(Exception e){}

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


        return homePageServiceVO;

    }

    /**
     * This method is required to populate List of Ug and Pg courses.
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfBasicUgCourses() {

        List<ListOfValuesVO> listOfBasicUgCourses = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select course_id,course_short_name from course_name where course_type ='UG' or course_type = 'BASIC' or course_type ='Other'";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelValue(rs.getString("course_id"));
                listOfValuesVO.setLabelName(rs.getString("course_short_name"));
                listOfBasicUgCourses.add(listOfValuesVO);
            }
            listOfBasicUgCourses = compareListOfValues(listOfBasicUgCourses);
        } catch (Exception exception) {
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
        return listOfBasicUgCourses;
    }

    /**
     * This method is required to populate List of Pg courses.
     *
     * @param countryName
     * @return
     */
    public List<ListOfValuesVO> populateListOfBasicPgCourses() {

        List<ListOfValuesVO> listOfBasicPgCourses = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select course_id,course_short_name from course_name where course_type ='PG' or course_type ='Other'";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelValue(rs.getString("course_id"));
                listOfValuesVO.setLabelName(rs.getString("course_short_name"));
                listOfBasicPgCourses.add(listOfValuesVO);
            }
            listOfBasicPgCourses = compareListOfValues(listOfBasicPgCourses);

        } catch (Exception exception) {
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
        return listOfBasicPgCourses;
    }

    /**
     *
     * @param countryName
     * @param cityName
     * @return
     */
    public List<ListOfValuesVO> populateListOfSubjects() {

        List<ListOfValuesVO> listOfSubjects = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select subject_id,subject_name from subject";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("subject_name"));
                listOfValuesVO.setLabelValue(rs.getString("subject_id"));
                listOfSubjects.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfSubjects;
    }

    /**
     *
     * @return
     */
    public List<ListOfValuesVO> populateListOfTeachingMediums() {

        List<ListOfValuesVO> listOfTeachingMedium = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select medium_id,medium_name from teaching_medium";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("medium_name"));
                listOfValuesVO.setLabelValue(rs.getString("medium_id"));
                listOfTeachingMedium.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingMedium;
    }

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

    public List compareListOfValues(List<ListOfValuesVO> list) {

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                ListOfValuesVO listOfValuesVO1 = (ListOfValuesVO) o1;
                ListOfValuesVO listOfValuesVO2 = (ListOfValuesVO) o2;
                return listOfValuesVO1.getLabelName().compareToIgnoreCase(listOfValuesVO2.getLabelName());
            }
        });


        return list;
    }

    public List<ListOfValuesVO> populateListOfTeachingLevel() {

        List<ListOfValuesVO> listOfTeachingLevel = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "SELECT `EDUCATION_SEGMENT_ID`,`EDUCATION_SEGMENT_NAME` FROM `education_categories`";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("EDUCATION_SEGMENT_NAME"));
                listOfValuesVO.setLabelValue(rs.getString("EDUCATION_SEGMENT_ID"));
                listOfTeachingLevel.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingLevel;
    }

    public List<ListOfValuesVO> populateListOfTutorteachingParten() {

        List<ListOfValuesVO> listOfTeachingParten = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "SELECT `TEACHING_PATTEREN_ID`,`TEACHING_PATTEREN_NAME` FROM `teaching_patteren`";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("TEACHING_PATTEREN_NAME"));
                listOfValuesVO.setLabelValue(rs.getString("TEACHING_PATTEREN_ID"));
                listOfTeachingParten.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingParten;
    }

    public List<ListOfValuesVO> populateListOfTutorteachingOption() {

        List<ListOfValuesVO> listOfTeachingOption = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "SELECT `TEACHING_OPTION_ID`,`TEACHING_OPTION_NAME` FROM`teaching_option`;";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("TEACHING_OPTION_NAME"));
                listOfValuesVO.setLabelValue(rs.getString("TEACHING_OPTION_ID"));
                listOfTeachingOption.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfTeachingOption;
    }

    public List<ListOfValuesVO> populateListOfCountryType() {

        List<ListOfValuesVO> listOfCompanyType = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select company_name_id,company_name_type from company_type";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("company_name_type"));
                listOfValuesVO.setLabelValue(rs.getString("company_name_id"));
                listOfCompanyType.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfCompanyType;
    }

    public List<ListOfValuesVO> populateListOfIndustryType() {

        List<ListOfValuesVO> listOfIndustryType = new ArrayList<ListOfValuesVO>();


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sqlQuery = "select industry_id,industry_name from industry_type";

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            pstmt = conn.prepareStatement(sqlQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                listOfValuesVO.setLabelName(rs.getString("industry_name"));
                listOfValuesVO.setLabelValue(rs.getString("industry_id"));
                listOfIndustryType.add(listOfValuesVO);
            }


        } catch (Exception exception) {
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
        return listOfIndustryType;
    }
}
