
package com.pcs.ptutors.model;

import com.pcs.ptutors.vo.EmployeeRegistrationVo;
import com.pcs.ptutors.jobseekers.vo.JobSeekerVo;
import com.pcs.ptutors.jobseekers.vo.ResultVo;
import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import com.pcs.ptutors.exception.ProfessionalTutorsException;
import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import com.pcs.ptutors.util.DateConversion;
import com.pcs.ptutors.util.MailSend;
import com.pcs.ptutors.util.PasswordGenerator;
import com.pcs.ptutors.util.PostTutionEmailAlertToMembers;
import com.pcs.ptutors.util.RegistrationDateCalculation;
import com.pcs.ptutors.util.ZnetIndiaMailService;
import com.pcs.ptutors.vo.AssistanceVO;
import com.pcs.ptutors.vo.FeedbackVO;
import com.pcs.ptutors.vo.InstantTutorServiceVO;
import com.pcs.ptutors.vo.ListOfValuesVO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pcs.ptutors.vo.LocationVO;
import com.pcs.ptutors.vo.LoginVO;
import com.pcs.ptutors.vo.MembershipSubscriptionVO;
import com.pcs.ptutors.vo.PostAdvertisementVO;
import com.pcs.ptutors.vo.ResultVO;
import com.pcs.ptutors.vo.StudentRegistrationVO;
import com.pcs.ptutors.vo.TeaserVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import com.pcs.ptutors.vo.TutorSubjectVO;
import com.pcs.ptutors.vo.TutorTeachingArenaVO;
import com.pcs.ptutors.vo.TutorialCenterVo;
import com.pcs.ptutors.vo.TutorsInIndiaVO;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;


/**
 *
 * @author Dipayan Dasgupta
 */
public class TutorModel {

    private static final String propdest = "com.pcs.ptutors.properties.validation";
    private static ResourceBundle resource = ResourceBundle.getBundle(propdest);
    private static final String sqlPropFileDest = "com.pcs.ptutors.properties.professionaltutorsSQL";
    private static ResourceBundle sqlResource = ResourceBundle.getBundle(sqlPropFileDest);
    ArrayList list = new ArrayList();
    int empnum = 0;
    String Phone = null;

    /**
     *
     * @return
     */
    public List<LocationVO> populateLocation() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<LocationVO> listOfLocation = new ArrayList<LocationVO>();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String sqlQuery = "select * from location_name";
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                LocationVO locationVO = new LocationVO();
                locationVO.setCountryName(rs.getString("country_name"));
                locationVO.setCityName(rs.getString("location_name"));

                listOfLocation.add(locationVO);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.getMessage();
            exception.printStackTrace();

        } finally {
            try {

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }
                if (null != conn) {
                    conn.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return listOfLocation;
    }

    /**
     *
     * @param countryChar
     * @return
     */
    public List<HashMap> populateCountryName(String countryChar) {
        List<HashMap> listOfCountryInfo = new ArrayList<HashMap>();
        Connection conn = null;
        Statement st = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select country_code,country_name from country_name where country_name like '" + countryChar + "%'";
            System.out.println(" sqlQuery ++++++++++ " + sqlQuery);
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                HashMap<String, List<ListOfValuesVO>> hashMap = new HashMap<String, List<ListOfValuesVO>>();
                List<ListOfValuesVO> listOfLocationValues = new ArrayList<ListOfValuesVO>();

                String countryCode = rs.getString("country_code");
                String countryName = rs.getString("country_name");

                String sqlQuery2 = "select location_id,location_name  from location_name where country_code=?";

                pstmt = conn.prepareStatement(sqlQuery2);
                pstmt.setString(1, countryCode);
                rs = pstmt.executeQuery();
                while (rs.next()) {
                    ListOfValuesVO listOfValuesVO = new ListOfValuesVO();
                    listOfValuesVO.setLabelValue(rs.getString("location_id"));
                    listOfValuesVO.setLabelName(rs.getString("location_name"));

                    listOfLocationValues.add(listOfValuesVO);
                }

                hashMap.put(countryName, listOfLocationValues);
                listOfCountryInfo.add(hashMap);
            }


            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.getMessage();
            exception.printStackTrace();

        } finally {
            try {

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }
                if (null != conn) {
                    conn.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return listOfCountryInfo;
    }

    /**
     *
     * @param listOfLocation
     * @return
     */
    public ResultVO createLocation(List<LocationVO> listOfLocation) {

        ResultVO resultVO = new ResultVO();
        String validationMessage = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        if (null != listOfLocation) {


            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                for (LocationVO location : listOfLocation) {
                    String countryName = location.getCountryName();
                    String cityName = location.getCityName();
                    String sqlQuery = "insert into location (country_name,city_location_name) values(?,?)";

                    PreparedStatement pst = conn.prepareStatement(sqlQuery);
                    pst.setString(1, countryName);
                    pst.setString(2, cityName);
                    int rowsAffected = pst.executeUpdate();
                    System.out.print(" rowsAffected  " + rowsAffected);

                    if (rowsAffected > 0) {
                        validationMessage = "Location added successfully ";
                        resultVO.setValidationMessage(validationMessage);
                    } else {
                        validationMessage = "Location add failed to save ";
                        resultVO.setValidationMessage(validationMessage);
                    }
                }
            } catch (Exception e) {
                validationMessage = e.getMessage();
                resultVO.setValidationMessage(validationMessage);
                System.out.print("validationMessage ::" + validationMessage);
            } finally {

                try {

                    if (null != pstmt) {
                        pstmt.close();
                    }

                    if (null != conn) {
                        conn.close();
                    }

                } catch (SQLException sqlException) {
                }
            }


        }
        return resultVO;
    }

    /**
     *
     * @return
     */
    public List<TeaserVO> getTeaserData() {
        List<TeaserVO> listOfTeaser = new ArrayList<TeaserVO>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //DbConnection dbConnection = new DbConnection();
            conn = conn = DbConnectionPool.dbConnectFive();


            String sqlQuery = "select * from teaser";
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            while (rs.next()) {
                TeaserVO teaserVO = new TeaserVO();

                teaserVO.setTeaserTitle(rs.getString("teaser_title"));

                teaserVO.setTeaserSubjectLine1(rs.getString("teaser_subject_line1"));
                teaserVO.setTeaserSubjectLine2(rs.getString("teaser_subject_line2"));
                teaserVO.setTeaserSubjectLine3(rs.getString("teaser_subject_line3"));
                teaserVO.setTeaserSubjectLine4(rs.getString("teaser_subject_line4"));
                teaserVO.setTeaserSubjectLine5(rs.getString("teaser_subject_line5"));
                listOfTeaser.add(teaserVO);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {

                if (null != st) {
                    st.close();
                }

                if (null != rs) {
                    rs.close();
                }
                if (null != conn) {
                    conn.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return listOfTeaser;
    }

	/*
	 * public ResultVO studentRegistrationcheck(StudentRegistrationVO
	 * studentRegistrationVO) throws Exception, ProfessionalTutorsException {
	 * Connection conn = null; PreparedStatement pst = null; ResultVO resultVO = new
	 * ResultVO();
	 * 
	 * 
	 * try{ Class.forName("com.mysql.jdbc.Driver"); Connection con =(Connection)
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi", "root", "");
	 * PreparedStatement ps = con.prepareStatement("SELECT  * FROM users WHERE " +
	 * "username = ?"); ps.setString(1,request.getParameter("username")); ResultSet
	 * res = ps.executeQuery(); if(res.first()){ out.print("User already exists");
	 * }else{ out.print("User name is valid"); } }catch (Exception e){
	 * System.out.println(e); }
	 * 
	 * 
	 * 
	 * }
	 */
        
    /**
     *
     * @param view
     * @return
     */
    public ResultVO studentRegistration(StudentRegistrationVO studentRegistrationVO) throws Exception, ProfessionalTutorsException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = new ResultVO();

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Login Information */
            String studentId = getAutogeneratedId();

            String name = studentRegistrationVO.getName();
            String userLoginName = studentRegistrationVO.getUserLoginName();
            String password = studentRegistrationVO.getPassword();
            String secretQuestion = studentRegistrationVO.getSecretQuestion();
            String secretQuestionAnswer = studentRegistrationVO.getSecretQuestionAnswer();

            /* Student Personal Details */
            String gender = studentRegistrationVO.getSex();
            String age = studentRegistrationVO.getAge();
            String countryName = studentRegistrationVO.getCountryName();
            String location = studentRegistrationVO.getCityName();
            String area = studentRegistrationVO.getArea();
            String landmark = studentRegistrationVO.getLandmark();
            String address = studentRegistrationVO.getAddress();
            String guardianName = studentRegistrationVO.getGuardianname();
            String contactNumber = studentRegistrationVO.getContactNumber();
            String emailAddress = studentRegistrationVO.getEmail();
            String preferredCallTime = studentRegistrationVO.getCalltime();

            /* Student Education Details */
            String schoolOrBoard = studentRegistrationVO.getSchoolOrBoard();
            System.out.println("school boar at service    == " + schoolOrBoard);
            String otherSchoolBoard = studentRegistrationVO.getOtherSchoolOrBoard();
            String universityOrInstitute = studentRegistrationVO.getUniversityOrInstitute();

            String otherUniversityOrInstitute = studentRegistrationVO.getOtherUniversityOrInstitute();

            String classStandard = studentRegistrationVO.getClassstandard();
            String otherClassStandard = studentRegistrationVO.getOtherClassstandard();
            String medium = studentRegistrationVO.getMedium();
            String otherMedium = studentRegistrationVO.getOtherMedium();


            /* Tutor Requirement Details */
            String tutionTitle = studentRegistrationVO.getTutionTitle();
            String tutionRequirement = studentRegistrationVO.getTutionRequirement();
            String otherTutionRequirement = studentRegistrationVO.getOtherTutitonRequirement();

            String segmentLevel = studentRegistrationVO.getSegmentLevel();
            String otherSegmentLevel = studentRegistrationVO.getOtherSegmentLevel();

            String tutionRemarks = studentRegistrationVO.getTutionRemarks();

            String sqlQuery = "insert into student_details(student_id,name,user_login_name,password,secret_question_id,secret_question_answer,"
                    + "gender,age,country_code,location_id,area,landmark,address,contact_number,guardian_name,email_address,call_time,school_board_id,other_school_board,"
                    + "university_institute_id,other_university_institute_name,education_segment_id,other_education_segment_name,medium_id,other_medium_name,tution_title,tution_required_subject_id,other_tution_required_subject_name,tution_segment_id,other_tution_segment_name, tution_remarks,registration_date,membership_category,registration_time)"
                    + "values(?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?"
                    + ",?,?,?,?,?,?,?,?,?"
                    + ",?,?,curdate(),'Free',curtime())";

            pst = conn.prepareStatement(sqlQuery);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, studentId);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, name);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, userLoginName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, password);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, secretQuestion);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, secretQuestionAnswer);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, gender);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, new Integer(age));
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, countryName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, location);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, area);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, landmark);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, address);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, contactNumber);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, guardianName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_16, emailAddress);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_17, preferredCallTime);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_18, schoolOrBoard);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_19, otherSchoolBoard);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_20, universityOrInstitute);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_21, otherUniversityOrInstitute);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_22, classStandard);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_23, otherClassStandard);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_24, medium);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_25, otherMedium);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_26, tutionTitle);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_27, tutionRequirement);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_28, otherTutionRequirement);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_29, segmentLevel);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_30, otherSegmentLevel);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_31, tutionRemarks);


            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {

                resultVO.setStudentId(studentId);
                resultVO.setUserCallName(name);
                resultVO.setUserLoginName(userLoginName);
                resultVO.setPassword(password);
                resultVO.setEmailId(emailAddress);
                resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));

                PostTutionEmailAlertToMembers postTutionEmailAlertToMembers = new PostTutionEmailAlertToMembers();
                if (null != studentId) {
                    if (null == tutionRequirement) {
                        tutionRequirement = otherTutionRequirement;
                    }
                    if (null == segmentLevel) {
                        segmentLevel = otherSegmentLevel;
                    }
                    //    postTutionEmailAlertToMembers.sendPostTutionAlertEmail(studentId, name, tutionTitle, tutionRequirement, segmentLevel);
                }

            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_002, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_002));
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmail(name, studentId, contactNumber, emailAddress, userLoginName, password);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ProfessionalTutorsException pte) {
            pte.printStackTrace();
            throw pte;

        } catch (Exception exception) {
            exception.getMessage();
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }

        return resultVO;
    }

    
    
    /**
     *
     * @param tutorRegistrationVO
     * @return
     */
    public ResultVO tutorProfileRegistration(TutorRegistrationVO tutorRegistrationVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            // Tutor Login Information
            String tutorId = getAutogeneratedId();
            resultVO.setTutorId(tutorId);

            String tutorLoginName = tutorRegistrationVO.getTutorLoginName();
            String tutorPassword = tutorRegistrationVO.getTutorPassword();
            String securityQuestionId = "0";
            String securityQuestionAnswer = "";

            if (null != tutorRegistrationVO.getTutorSecretQuestion() && !"".equalsIgnoreCase(tutorRegistrationVO.getTutorSecretQuestion())) {
                securityQuestionId = tutorRegistrationVO.getTutorSecretQuestion();
                securityQuestionAnswer = tutorRegistrationVO.getTutorSecretQuestionAnswer();
            }

            // File uploadInage = tutorRegistrationVO.getUploadImage();  Pending for Enhancement
            // Tutor Contact Information
            boolean imageFlag = tutorRegistrationVO.isImageFlag();
            String tutorName = tutorRegistrationVO.getTutorName();
            String tutorAge = tutorRegistrationVO.getTutorAge();
            String tutorSex = tutorRegistrationVO.getTutorSex();

            String tutorCountryId = tutorRegistrationVO.getTutorCountryLocation();
            String tutorPostalCode = tutorRegistrationVO.getTutorPostalCode();
            String tutorLocationId = tutorRegistrationVO.getTutorCityLocation();
            String tutorAddress = tutorRegistrationVO.getTutorAddress();
            String tutorArea = tutorRegistrationVO.getTutorArea();
            String tutorEmailId = tutorRegistrationVO.getTutorEmailId();
            String tutorContactNumber = tutorRegistrationVO.getContactNumber();


            String tutorProfileRegisterQuery = sqlResource.getString("TUTOR_QUERY001");
            /* String tutorDetailsInsertQuery = "insert  into tutor_details(tutor_id,name,user_login_name,password,secret_question,secret_question_answer,"
             + "gender,age,country_name,location_name,area_name,address,contact_number,email_address) values"
             + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/

            pst = conn.prepareStatement(tutorProfileRegisterQuery);
            /*  Login Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, tutorName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, tutorLoginName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, tutorPassword);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_5, new Integer(securityQuestionId));
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, securityQuestionAnswer);

            /* Tutor Personal Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, tutorSex);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, new Integer(tutorAge));

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, tutorCountryId);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, tutorLocationId);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, tutorArea);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, tutorPostalCode);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, tutorAddress);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, tutorContactNumber);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, tutorEmailId);
            pst.setBoolean(ProfessionalTutorsConstant.PARAMETER_INDEX_16, imageFlag);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                String retrieveTutorId = "select tutor_id from tutor_details where tutor_id =?";
                pst = conn.prepareStatement(retrieveTutorId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    resultVO.setTutorId(rs.getString("tutor_id"));
                    resultVO.setUserCallName(tutorName);
                    System.out.println("tutorName in service........" + tutorName);
                    resultVO.setEmailId(tutorEmailId);

                    resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));
                } else {
                    resultVO.setValidationMessage("Tutor Registration failed. Please inform help desk immediately about it .");
                }

            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmail(tutorName, tutorId, tutorContactNumber, tutorEmailId, tutorLoginName, tutorPassword);


//            String senderName = "helpdesk@ptutors.org";
//            ZnetIndiaMailService znetIndiaMailService = new ZnetIndiaMailService();
//            String emailMessage = znetIndiaMailService.sendEmail(senderName, tutorId, tutorEmailId, tutorLoginName, tutorPassword);
            /*
             if(null != emailMessage){
             throw new ProfessionalTutorsException(ProfessionalTutorsConstant.EMAIL_ERROR_CODE_001, resource.getString(ProfessionalTutorsConstant.EMAIL_ERROR_CODE_001));
             }

             */

        } catch (ProfessionalTutorsException professionalTutorsException) {
            throw professionalTutorsException;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    /**
     *
     * @param tutorRegistrationVO
     * @return
     */
    public ResultVO registerTutorEduAndTeachingProc(TutorRegistrationVO tutorRegistrationVO) throws ProfessionalTutorsException, Exception {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Tutor Login Information  */
            String tutorId = tutorRegistrationVO.getTutorId();

            String ugQualifyingDegree = null;
            String otherUgQualifyingDegree = null;

            if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getUgQualifyingDegree())) {
                ugQualifyingDegree = tutorRegistrationVO.getUgQualifyingDegree();
                otherUgQualifyingDegree = tutorRegistrationVO.getOtherUgQualifyingDegree();
            }


            String ugSpecialization = null;
            String otherUgSpecialization = null;

            if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getUgSpecialization())) {
                ugSpecialization = tutorRegistrationVO.getUgSpecialization();
                otherUgSpecialization = tutorRegistrationVO.getOtherUgSpecialization();
            }

            String ugBoardOrUniversity = null;
            String otherUgBoardOrUniversity = null;

            if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getUgBoardOrUniversity())) {
                ugBoardOrUniversity = tutorRegistrationVO.getUgBoardOrUniversity();
                otherUgBoardOrUniversity = tutorRegistrationVO.getOtherUgBoardOrUniversity();
            }

            Integer ugYearOfpassout = -1;
            if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getUgPassoutYear())) {
                ugYearOfpassout = new Integer(tutorRegistrationVO.getUgPassoutYear());
            }


            //   String tutorUgEduSql = sqlResource.getString("TUTOR_QUERY002");

            String tutorUgEduSql = "insert into tutor_ug_education(tutor_id,course_id,other_course_name,subject_id,other_subject_name,university_institute_id,other_university_name,year_of_passout) values (?,?,?,?,?,?,?,?)";

            conn = dbConnection.dbConnect();
            pst = conn.prepareStatement(tutorUgEduSql);

            if (null != tutorId) {

                /* Tutor UG Educational Qualification */
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, ugQualifyingDegree);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, otherUgQualifyingDegree);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, ugSpecialization);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, otherUgSpecialization);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, ugBoardOrUniversity);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, otherUgBoardOrUniversity);


                pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, ugYearOfpassout.intValue());


                int ugRowsAffected = pst.executeUpdate();

                if (ugRowsAffected > 0) {
                    System.out.println("ugRowsAffected : " + ugRowsAffected);
                }
            }
            if (null != tutorId) {

                String pgQualifyingDegree = null;
                String otherPgQualifyingDegree = null;

                if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getPgQualifyingDegree())) {
                    pgQualifyingDegree = tutorRegistrationVO.getPgQualifyingDegree();
                    otherPgQualifyingDegree = tutorRegistrationVO.getOtherPgQualifyingDegree();
                }

                String pgSpecialization = null;
                String otherPgSpecialization = null;

                if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getPgSpecialization())) {
                    pgSpecialization = tutorRegistrationVO.getPgSpecialization();
                    otherPgSpecialization = tutorRegistrationVO.getOtherPgSpecialization();
                }

                String pgBoardOrUniversity = null;
                String otherPgBoardOrUniversity = null;

                if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getPgBoardOrUniversity())) {
                    pgBoardOrUniversity = tutorRegistrationVO.getPgBoardOrUniversity();
                    otherPgBoardOrUniversity = tutorRegistrationVO.getOtherPgBoardOrUniversity();
                }


                Integer pgYearOfpassout = -1;
                if (!"-1".equalsIgnoreCase(tutorRegistrationVO.getPgPassoutYear())) {

                    pgYearOfpassout = new Integer(tutorRegistrationVO.getPgPassoutYear());

                }


                conn = dbConnection.dbConnect();
                String tutorPgEduSql = "insert into tutor_pg_education(tutor_id,course_id,other_course_name,subject_id,other_subject_name,university_institute_id,other_university_institute_name,year_of_passout) values (?,?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(tutorPgEduSql);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, pgQualifyingDegree);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, otherPgQualifyingDegree);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, pgSpecialization);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, otherPgSpecialization);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, pgBoardOrUniversity);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, otherPgBoardOrUniversity);


                pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, pgYearOfpassout.intValue());

                System.out.println("pgYearOfpassout  ::::::::::::::::: " + pgYearOfpassout);


                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println(" Tutor pg record updated");
                }
                
                else {
                    throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
                }
                 System.out.println("before start level medium func...service..");
             String[] teachingLevelList = tutorRegistrationVO.getTeachingLevelList();
             String[] teachingMedium = tutorRegistrationVO.getTeachingMediumLis();
             String[] teachingBoard = tutorRegistrationVO.getTeachingBoardList();
             String[] teachingsubject = tutorRegistrationVO.getTeachingSubjectList();
            //  String sqlQuery = sqlResource.getString("TUTOR_QUERY003");
            String sqlQuery = "insert into tutor_teaching_arena (tutor_id,education_segment_id,tutor_teaching_subjects,tutor_teaching_board,tutor_teaching_medium) values (?,?,?,?,?)";
            pst = conn.prepareStatement(sqlQuery);
            
            for (int i=0; i<teachingLevelList.length;i++) {
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorRegistrationVO.getTutorId());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, teachingLevelList[i]);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, teachingsubject[i]);
                System.out.println("tutorTeachingArenaVO.getTeachingSubjects() in service......"+teachingsubject[i]);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, teachingBoard[i]);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, teachingMedium[i]);
                pst.addBatch();
            }
            int[] rowsAffected1 = pst.executeBatch();


            if (rowsAffected1.length > 0) {
                resultVO.setValidationMessage("Teaching class & subjects inserted");
            } else {
                resultVO.setValidationMessage("Teaching class & subjects Submition failed");
            }

            }
           
            
            

        } catch (ProfessionalTutorsException professionalTutorsException) {
            throw professionalTutorsException;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    /**
     *
     * @param tutorRegistrationVO
     * @return
     */
    public ResultVO registerTutorTutoringProcedure(TutorRegistrationVO tutorRegistrationVO) throws ProfessionalTutorsException, Exception {

        Connection conn = null;
        PreparedStatement pst = null;
        Statement stmt = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Tutor Login Information  */
            String tutorId = tutorRegistrationVO.getTutorId();
            String tutorName = tutorRegistrationVO.getTutorName();
            resultVO.setUserCallName(tutorName);
            System.out.println(" Starting tutorId :: " + tutorId);
            /* Tutoring Procedure Details */

            String tutoringExperience = tutorRegistrationVO.getTutoringExperience();
            String[] preferenceToTeachingList = tutorRegistrationVO.getPreferenceToTeachingList();
            String otherPreferenceToTeaching = tutorRegistrationVO.getOtherPreferenceToTeaching();

            String[] teachingPatterenList = tutorRegistrationVO.getTeachingPatterenList();
            String otherTeachingPatteren = tutorRegistrationVO.getOtherTutorTeachingPatteren();

            String[] tutoringOptionList = tutorRegistrationVO.getTutoringOptionList();
            String otherTutoringOption = tutorRegistrationVO.getOtherTutoringOptions();

            String[] teachingMediumList = tutorRegistrationVO.getTeachingMediumLis();
            String otherTeachingMedium = tutorRegistrationVO.getOtherTeachingMedium();

            String[] teachingLevelList = tutorRegistrationVO.getTeachingLevelList();
            String otherTeachingLevel = tutorRegistrationVO.getOtherTeachingLevel();

            String tutorYearsOfExperience = tutorRegistrationVO.getTutorYearsOfExperience();
            String preferredTutoringArea = tutorRegistrationVO.getPreferredTutoringArea();

            String feeExpected = tutorRegistrationVO.getFeeExpected();

            String updateTutorDetailsSql = "update tutor_details set years_of_tutoring_experience = '" + tutorYearsOfExperience + "',preferred_tutoring_area ='" + preferredTutoringArea + "' , expected_fees = '" + feeExpected + "',tutoring_experience ='" + tutoringExperience + "',registration_date = curdate() ,membership_category ='Free',registration_time=curtime() where tutor_id ='" + tutorId + "'";
            System.out.println(" updateTutorDetailsSql :" + updateTutorDetailsSql);

            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.addBatch(updateTutorDetailsSql);

            if (null != preferenceToTeachingList) {
                for (int i = 0; i < preferenceToTeachingList.length; i++) {
                    if (!"".equalsIgnoreCase(preferenceToTeachingList[i]) && null != preferenceToTeachingList[i]) {
                        String prefToTeaching = "insert into tutor_subject(tutor_id,subject_id,other_subject_name) values ('" + tutorId + "'," + preferenceToTeachingList[i] + ",'" + otherPreferenceToTeaching + "')";
                        System.out.println("prefToTeaching : " + prefToTeaching);
                        stmt.addBatch(prefToTeaching);
                    }

                }
            }

            if (null != teachingPatterenList) {
                for (int j = 0; j < teachingPatterenList.length; j++) {
                    if (!"".equalsIgnoreCase(teachingPatterenList[j]) && null != teachingPatterenList[j]) {
                        String teachingPatteren = "insert into tutor_teaching_patteren(tutor_id,teaching_patteren_id,other_teaching_patteren_name) values('" + tutorId + "'," + teachingPatterenList[j] + ",'" + otherTeachingPatteren + "')";
                        System.out.println("teachingPatteren : " + teachingPatteren);
                        stmt.addBatch(teachingPatteren);
                    }
                }
            }

            if (null != tutoringOptionList) {
                for (int k = 0; k < tutoringOptionList.length; k++) {
                    if (!"".equalsIgnoreCase(tutoringOptionList[k]) && null != tutoringOptionList[k]) {
                        String tutoringOptions = "insert into tutor_teaching_option (tutor_id,teaching_option_id,other_teaching_option_name) values ('" + tutorId + "'," + tutoringOptionList[k] + ",'" + otherTutoringOption + "')";
                        System.out.println("tutoringOptions : " + tutoringOptions);
                        stmt.addBatch(tutoringOptions);
                    }
                }
            }

            if (null != teachingMediumList) {
                for (int l = 0; l < teachingMediumList.length; l++) {
                    if (!"".equalsIgnoreCase(teachingMediumList[l]) && null != teachingMediumList[l]) {
                        String teachingMedium = "insert into tutor_medium (tutor_id,medium_id,other_medium_name) values ('" + tutorId + "'," + teachingMediumList[l] + ",'" + otherTeachingMedium + "')";
                        System.out.print("teachingMedium :: " + teachingMedium);
                        stmt.addBatch(teachingMedium);
                    }
                }
            }

            if (null != teachingLevelList) {
                for (int m = 0; m < teachingLevelList.length; m++) {
                    if (!"".equalsIgnoreCase(teachingLevelList[m]) && null != teachingLevelList[m]) {
                        String teachingLevel = "insert into tutor_teaching_segment (tutor_id,education_segment_id,other_teaching_segment_name) values ('" + tutorId + "'," + teachingLevelList[m] + ",'" + otherTeachingLevel + "')";
                        System.out.print("teachingLevel :: " + teachingLevel);
                        stmt.addBatch(teachingLevel);
                    }
                }
            }

            int[] updatedRows = stmt.executeBatch();
            conn.commit();

            if (updatedRows.length > 0) {
                System.out.println(" Tutor record updated.........................");
            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }

        }/*catch (ProfessionalTutorsException professionalTutorsException) {
         throw professionalTutorsException;
         } catch (SQLException sqlException) {
         sqlException.printStackTrace();
         }*/ catch (Exception exception) {
            exception.printStackTrace();
            System.out.print("Message ::: " + exception.getMessage());
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    stmt.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    /**
     *
     * @param tutorRegistrationVO
     * @return
     */
    public ResultVO registerTutorProfile(TutorRegistrationVO tutorRegistrationVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Tutor Login Information  */
            String tutorId = getAutogeneratedId();
            resultVO.setTutorId(tutorId);
            String tutorName = tutorRegistrationVO.getTutorName();
            String tutorLoginName = tutorRegistrationVO.getTutorLoginName();
            String tutorPassword = tutorRegistrationVO.getTutorPassword();
            String securityQuestion = tutorRegistrationVO.getTutorSecretQuestion();
            String securityQuestionAnswer = tutorRegistrationVO.getTutorSecretQuestionAnswer();

            // File uploadInage = tutorRegistrationVO.getUploadImage();  Pending for Enhancement
            /* Tutor Contact Information */
            String tutorCountryLocation = tutorRegistrationVO.getTutorCountryLocation();
            String tutorCityLocation = tutorRegistrationVO.getTutorCityLocation();
            String tutorAddress = tutorRegistrationVO.getTutorAddress();
            String tutorArea = tutorRegistrationVO.getTutorArea();
            String tutorEmailId = tutorRegistrationVO.getTutorEmailId();
            String tutorContactNumber = tutorRegistrationVO.getContactNumber();

            String tutorSex = tutorRegistrationVO.getTutorSex();
            String tutorAge = tutorRegistrationVO.getTutorAge();


            /* Tutor Education Deatails   */
            String ugQualifyingDegree = tutorRegistrationVO.getUgQualifyingDegree();
            String ugSpecialization = tutorRegistrationVO.getUgSpecialization();
            String ugBoardOrUniversity = tutorRegistrationVO.getUgBoardOrUniversity();
            String ugYearOfpassout = tutorRegistrationVO.getUgPassoutYear();

            String pgQualifyingDegree = tutorRegistrationVO.getPgQualifyingDegree();
            String pgSpecialization = tutorRegistrationVO.getPgSpecialization();
            String pgBoardOrUniversity = tutorRegistrationVO.getPgBoardOrUniversity();
            String pgYearOfpassout = tutorRegistrationVO.getPgPassoutYear();


            /* Tutoring Procedure Details */
            String tutoringExperience = tutorRegistrationVO.getTutoringExperience();
            String preferenceToTeaching = tutorRegistrationVO.getPreferenceToTeaching();
            String tutorYearsOfExperience = tutorRegistrationVO.getTutorYearsOfExperience();
            String preferredTutoringArea = tutorRegistrationVO.getPreferredTutoringArea();
            String tutorTeachingPatteren = tutorRegistrationVO.getTutorTeachingPatteren();
            String tutoringOptions = tutorRegistrationVO.getTutoringOptions();
            String teachingMedium = tutorRegistrationVO.getTeachingMedium();


            String teachingLevel = tutorRegistrationVO.getTeachingLevel();


            String feeExpected = tutorRegistrationVO.getFeeExpected();


            String tutorDetailsInsertQuery = "insert  into tutor_details(tutor_id,name,user_login_name,password,secret_question,secret_question_answer,"
                    + "gender,age,country_name,location_name,address,contact_number,email_address,"
                    + "ug_basic_graduation_qualification,ug_specialization,ug_board_university_institute,ug_year_of_passout,"
                    + "pg_qualification,pg_specialization,pg_university_institute,pg_year_of_passout,"
                    + "pref_subject_to_teach,years_of_tutoring_experience,preferred_tutoring_area,teaching_patteren,tutoring_options,teaching_medium,"
                    + "teaching_segment_level,expected_fees,tutoring_experience,registration_date,membership_category"
                    + ") values"
                    + "(?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,"
                    + "curdate(),'Free')";



            pst = conn.prepareStatement(tutorDetailsInsertQuery);
            /*  Login Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, tutorName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, tutorLoginName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, tutorPassword);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, securityQuestion);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, securityQuestionAnswer);

            /* Tutor Personal Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, tutorSex);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, new Integer(tutorAge));
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, tutorCountryLocation);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, tutorCityLocation);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, tutorAddress);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, tutorContactNumber);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, tutorEmailId);

            /* Tutor Educational Qualification */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, ugQualifyingDegree);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, ugSpecialization);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_16, ugBoardOrUniversity);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_17, new Integer(ugYearOfpassout));

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_18, pgQualifyingDegree);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_19, pgSpecialization);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_20, pgBoardOrUniversity);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_21, new Integer(pgYearOfpassout));


            /* Tutor Teaching Information*/
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_22, preferenceToTeaching);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_23, new Integer(tutorYearsOfExperience));
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_24, preferredTutoringArea);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_25, tutorTeachingPatteren);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_26, tutoringOptions);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_27, teachingMedium);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_28, teachingLevel);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_29, feeExpected);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_30, tutoringExperience);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                String retrieveTutorId = "select tutor_id from tutor_details where tutor_id =?";
                pst = conn.prepareStatement(retrieveTutorId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    resultVO.setTutorId(rs.getString("tutor_id"));
                    resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));
                } else {
                    resultVO.setValidationMessage("Tutor Registration failed. Please inform help desk immediately about it .");
                }

            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }

        } catch (ProfessionalTutorsException professionalTutorsException) {
            throw professionalTutorsException;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    /**
     *
     * @param tutorRegistrationVO
     * @return
     * @throws ProfessionalTutorsException
     * @throws Exception
     */
    public ResultVO tutorMembershipUpgradation(MembershipSubscriptionVO membershipSubscriptionVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Tutor Login Information  */
            String tutorId = membershipSubscriptionVO.getUserId();
            System.out.println(" New Tutor Id :: " + tutorId);
            //String tutorId ="F11115";
            String membershipCategory = membershipSubscriptionVO.getMembershipCategory();
            String duration = membershipSubscriptionVO.getDuration();
            float paymentAmount = 0.0F;
            if ("3".equalsIgnoreCase(duration)) {
                paymentAmount = ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_THREE_MONTHS_DURATION_FEES;
            }
            if ("6".equalsIgnoreCase(duration)) {
                paymentAmount = ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_SIX_MONTHS_DURATION_FEES;
            }
            if ("9".equalsIgnoreCase(duration)) {
                paymentAmount = ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_NINE_MONTHS_DURATION_FEES;
            }
            if ("12".equalsIgnoreCase(duration)) {
                paymentAmount = ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_TWELVE_MONTHS_DURATION_FEES;
            }


            String membershipExpireDate = RegistrationDateCalculation.getExpiryDate(new Integer(duration));
            String membershipExpireWarningDate = RegistrationDateCalculation.getExpiryWarningDate(new Integer(duration));

            /*
             String tutorDetailsInsertQuery = "INSERT INTO TUTOR_DETAILS(MEMBERSHIP_CATEGORY,DURATION,PAYMENT_AMOUNT,MEMBERSHIP_BEGIN_DATE,MEMBERSHIP_EXPIRE_DATE) VALUES"
             + "(?,?,?,CURDATE(),CURDATE()) WHERE TUTOR_ID = ?";
             */

            String updateMembership = "update tutor_details set membership_category =?,duration =?,payment_amount=?,membership_begin_date=curdate(),membership_expire_date=curdate(),membership_expire_warning_date = ? where tutor_id =?";
            System.out.println(" updateMembership :: " + updateMembership);
            pst = conn.prepareStatement(updateMembership);

            /*  Login Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, membershipCategory);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, duration);
            pst.setFloat(ProfessionalTutorsConstant.PARAMETER_INDEX_3, paymentAmount);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, membershipExpireDate);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, membershipExpireWarningDate);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, tutorId);



            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                resultVO.setTutorId(tutorId);
                resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));
            } else {
                //throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }

        } /*catch(ProfessionalTutorsException professionalTutorsException){
         professionalTutorsException.printStackTrace();
         throw professionalTutorsException;
         }*/ catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public TutorRegistrationVO viewForEditTutorEducationalInformationService(String tutorId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        try {
            if (null != tutorId) {
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String query = "select course_id,subject_id,university_institute_id,year_of_passout from tutor_ug_education where tutor_id =? ";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    tutorRegistrationVO.setUgQualifyingDegree(rst.getString("course_id"));
                    tutorRegistrationVO.setUgSpecialization(rst.getString("subject_id"));
                    tutorRegistrationVO.setUgBoardOrUniversity(rst.getString("university_institute_id"));
                    tutorRegistrationVO.setUgPassoutYear(rst.getString("year_of_passout"));
                }
                String querytwo = "select course_id,subject_id,university_institute_id,year_of_passout from tutor_pg_education where tutor_id =?";
                pstmt = conn.prepareStatement(querytwo);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();
                while (rst.next()) {
                    tutorRegistrationVO.setPgQualifyingDegree(rst.getString("course_id"));
                    tutorRegistrationVO.setPgSpecialization(rst.getString("subject_id"));
                    tutorRegistrationVO.setPgBoardOrUniversity(rst.getString("university_institute_id"));
                    tutorRegistrationVO.setPgPassoutYear(rst.getString("year_of_passout"));

                }


            }
        } catch (SQLException exception) {
        }
        return tutorRegistrationVO;
    }

    public ResultVO tutorEduAndTeachingProcUpdateService(TutorRegistrationVO tutorRegistrationVO) {
        ResultVO resultVO = null;
        Connection conn = null;
        PreparedStatement pstmt = null;

        if (null != tutorRegistrationVO) {
            try {
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String queryUpdate = "update tutor_ug_education set course_id=?,subject_id=?,university_institute_id=?,year_of_passout=? where tutor_id=?";
                pstmt = conn.prepareStatement(queryUpdate);
                pstmt.setString(1, tutorRegistrationVO.getUgQualifyingDegree());
                pstmt.setString(2, tutorRegistrationVO.getUgSpecialization());
                pstmt.setString(3, tutorRegistrationVO.getUgBoardOrUniversity());
                pstmt.setString(4, tutorRegistrationVO.getUgPassoutYear());
                pstmt.setString(5, tutorRegistrationVO.getTutorId());
                int row1 = pstmt.executeUpdate();
                if (row1 > 0) {
                    resultVO = new ResultVO();
                    resultVO.setValidationMessage("update");
                } else {
                    resultVO = new ResultVO();
                    resultVO.setValidationMessage(" not update");
                }
                String queryUpdateNext = "update tutor_pg_education set course_id=?,subject_id=?,university_institute_id=?,year_of_passout=? where tutor_id=?";
                pstmt = conn.prepareStatement(queryUpdateNext);
                pstmt.setString(1, tutorRegistrationVO.getPgQualifyingDegree());
                pstmt.setString(2, tutorRegistrationVO.getPgSpecialization());
                pstmt.setString(3, tutorRegistrationVO.getPgBoardOrUniversity());
                pstmt.setString(4, tutorRegistrationVO.getPgPassoutYear());
                pstmt.setString(5, tutorRegistrationVO.getTutorId());

                System.out.println("tutorRegistrationVO.getTutorId() =" + tutorRegistrationVO.getTutorId());

                int row = pstmt.executeUpdate();
                if (row > 0) {
                    resultVO = new ResultVO();
                    resultVO.setValidationMessage("update");
                } else {
                    resultVO = new ResultVO();
                    resultVO.setValidationMessage(" not update");
                }
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }


        return resultVO;
    }

    public TutorRegistrationVO populateTutorProfileByTutorId(String tutorId) throws Exception, ProfessionalTutorsException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        if (null != tutorId) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                StringBuffer sqlQueryPart = new StringBuffer("select td.user_login_name,td.tutor_id ,td.name ,td.age,td.gender, cn.country_name,loc.location_name ,td.address ,td.contact_number ,td.email_address ,td.years_of_tutoring_experience,td.preferred_tutoring_area,td.expected_fees,td.tutoring_experience,td.registration_date,td.document_verification_flag,td.image_flag,td.membership_category,td.document_verification_flag from tutor_details  td ,country_name cn , location_name loc where td.country_code = cn.country_code and td.location_id = loc.location_id and td.tutor_id=?");
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
                    tutorRegistrationVO.setTutorLoginName(rst.getString("user_login_name"));
                    tutorRegistrationVO.setTutorCountryLocation(rst.getString("country_name"));
                    tutorRegistrationVO.setTutorCityLocation(rst.getString("location_name"));
                    tutorRegistrationVO.setTutorAddress(rst.getString("address"));
                    tutorRegistrationVO.setMembershipCategory(rst.getString("membership_category"));
                    tutorRegistrationVO.setContactNumber(rst.getString("contact_number"));
                    tutorRegistrationVO.setTutorEmailId(rst.getString("email_address"));


                    /* Tutor Tutoring Information */
                    tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("years_of_tutoring_experience"));
                    tutorRegistrationVO.setPreferredTutoringArea(rst.getString("preferred_tutoring_area"));
                    tutorRegistrationVO.setFeeExpected(rst.getString("expected_fees"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("tutoring_experience"));
                    tutorRegistrationVO.setImageFlag(rst.getBoolean("image_flag"));

                    tutorRegistrationVO.setRegistrationDate(rst.getString("registration_date"));
                    tutorRegistrationVO.setDocumentVerificationFlag(rst.getString("document_verification_flag"));


                    /* tutorRegistrationVO.setTutorTeachingPatteren(rst.getString("TEACHING_PATTEREN_ID"));
                     System.out.println("# Teaching Patteren :: " + rst.getString("TEACHING_PATTEREN_ID"));
                     tutorRegistrationVO.setTutoringOptions(rst.getString("TUTORING_OPTIONS_ID"));
                     tutorRegistrationVO.setTeachingMedium(rst.getString("TEACHING_MEDIUM_ID"));
                     tutorRegistrationVO.setTeachingLevel(rst.getString("EDUCATION_SEGMENT_LEVEL_ID"));
                     */
                } // End of While loop


                String selectUgQualification = "select cn.course_short_name ,sub.subject_name ,unv.university_institute_name , tue.year_of_passout from tutor_ug_education tue , course_name cn ,subject sub ,university_institute unv where tue.subject_id = sub.subject_id and  tue.course_id = cn.course_id and tue.university_institute_id = unv.university_institute_id and tue.tutor_id =?";

                pstmt = conn.prepareStatement(selectUgQualification);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    tutorRegistrationVO.setUgQualifyingDegree(rst.getString("course_short_name"));
                    tutorRegistrationVO.setUgSpecialization(rst.getString("subject_name"));
                    tutorRegistrationVO.setUgBoardOrUniversity(rst.getString("university_institute_name"));
                    if(rst.getString("year_of_passout").equalsIgnoreCase("-1")){
                        tutorRegistrationVO.setUgPassoutYear("NA");
                    }
                    else if(rst.getString("year_of_passout").equalsIgnoreCase("0")){
                        tutorRegistrationVO.setUgPassoutYear("Persuing");
                    }
                    else{
                        tutorRegistrationVO.setUgPassoutYear(rst.getString("year_of_passout"));
                    }
                } // End of While loop



                String selectPgQualification = "select cn.course_short_name , sub.subject_name,unv.university_institute_name , tpe.year_of_passout from tutor_pg_education tpe , course_name cn ,subject sub ,university_institute unv where tpe.subject_id = sub.subject_id and tpe.course_id = cn.course_id and tpe.university_institute_id = unv.university_institute_id and tpe.tutor_id =?";
                pstmt = conn.prepareStatement(selectPgQualification);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();

                if (rst.next()) {
                    tutorRegistrationVO.setPgQualifyingDegree(rst.getString("course_short_name"));
                    tutorRegistrationVO.setPgSpecialization(rst.getString("subject_name"));
                    tutorRegistrationVO.setPgBoardOrUniversity(rst.getString("university_institute_name"));
                    if(rst.getString("year_of_passout").equalsIgnoreCase("-1")){
                        tutorRegistrationVO.setPgPassoutYear("NA");
                    }
                    else if(rst.getString("year_of_passout").equalsIgnoreCase("0")){
                        tutorRegistrationVO.setPgPassoutYear("Persuing");
                    }
                    else{
                        tutorRegistrationVO.setPgPassoutYear(rst.getString("year_of_passout"));
                    }
                    
                }

                String selectSubject = "select sub.subject_name from tutor_subject ts, subject sub where ts.subject_id = sub.subject_id and ts.tutor_id =?";

                pstmt = conn.prepareStatement(selectSubject);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strSubject = new StringBuilder();
                while (rst.next()) {
                    strSubject.append(rst.getString("subject_name"));
                    strSubject.append(",");
                } // End of While loop


                String selectTeachingLevel = "select ecat.education_segment_name from tutor_teaching_segment tts, education_categories ecat where tts.education_segment_id = ecat.education_segment_id and tts.tutor_id =?";


                pstmt = conn.prepareStatement(selectTeachingLevel);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingLevel = new StringBuilder();
                while (rst.next()) {
                    strTeachingLevel.append(rst.getString("education_segment_name"));
                    strTeachingLevel.append(",");
                } // End of While loop


                String selectTeachingMedium = "select tmed.medium_name from tutor_medium tm, teaching_medium tmed where tm.medium_id = tmed.medium_id and tm.tutor_id =?";


                pstmt = conn.prepareStatement(selectTeachingMedium);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingMedium = new StringBuilder();
                while (rst.next()) {
                    strTeachingMedium.append(rst.getString("medium_name"));
                    strTeachingMedium.append(",");
                } // End of While loop


                String selectTeachingOption = "select teaching_option_name from teaching_option topt ,tutor_teaching_option tto where topt.teaching_option_id = tto.teaching_option_id and tutor_id =?";
                pstmt = conn.prepareStatement(selectTeachingOption);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTutoringOptions = new StringBuilder();
                while (rst.next()) {
                    strTutoringOptions.append(rst.getString("teaching_option_name"));
                    strTutoringOptions.append(",");
                } // End of While loop

                String selectTeachingPatteren = "select teaching_patteren_name from teaching_patteren tpat ,tutor_teaching_patteren ttp where tpat.teaching_patteren_id = ttp.teaching_patteren_id and ttp.tutor_id =?";
                pstmt = conn.prepareStatement(selectTeachingPatteren);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingPatteren = new StringBuilder();
                while (rst.next()) {
                    strTeachingPatteren.append(rst.getString("teaching_patteren_name"));
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


                String selectTeachingArena = "select ec.education_segment_name,tta.tutor_teaching_subjects,tta.tutor_teaching_board,tta.tutor_teaching_medium  from tutor_teaching_arena  tta , education_categories ec  where  ec.education_segment_id = tta.education_segment_id and tta.tutor_id=?";
                pstmt = conn.prepareStatement(selectTeachingArena);
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pstmt.executeQuery();
                List<TutorTeachingArenaVO> listOfTeachingArena = new ArrayList<TutorTeachingArenaVO>();

                while (rst.next()) {
                    TutorTeachingArenaVO tutorTeachingArenaVO = new TutorTeachingArenaVO();
                    tutorTeachingArenaVO.setTeachingClassLevel(rst.getString("education_segment_name"));
                    tutorTeachingArenaVO.setTeachingSubjects(rst.getString("tutor_teaching_subjects"));
                    tutorTeachingArenaVO.setTeachingBoard(rst.getString("tutor_teaching_board"));
                    tutorTeachingArenaVO.setTeachingMedium(rst.getString("tutor_teaching_medium"));
                    listOfTeachingArena.add(tutorTeachingArenaVO);
                } // End of While loop

                tutorRegistrationVO.setListOfTeachingArena(listOfTeachingArena);

            }// End of Try block.
            catch (SQLException sqlException) {
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
        }
        return tutorRegistrationVO;
    }

    /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public ResultVO tutorValidation(LoginVO loginVO) throws Exception, ProfessionalTutorsException {
        ResultVO resultVO = new ResultVO();
        boolean tutorValidationFlag = false;
        String tutorCallName = null;
        String membershipCategory;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String tutorId = null;
            tutorId = loginVO.getTutorId();
            StringBuffer sqlQueryPart = new StringBuffer("select TUTOR_ID,name,email_address,password,membership_category from tutor_details where");
            if (null != tutorId && !"".equalsIgnoreCase(tutorId)) {
                if (null != loginVO.getTutorNameOrEmailAddress() && loginVO.getTutorNameOrEmailAddress().contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" email_address = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getTutorPassword() + "'");
                    sqlQueryPart.append(" and tutor_id = '" + tutorId + "'");
                } else if (null != loginVO.getTutorNameOrEmailAddress() && !(loginVO.getTutorNameOrEmailAddress()).contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getTutorPassword() + "'");
                    sqlQueryPart.append(" and tutor_id = '" + tutorId + "'");
                }
            } else {

                if (null != loginVO.getTutorNameOrEmailAddress() && loginVO.getTutorNameOrEmailAddress().contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" email_address = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getTutorPassword() + "'");

                } else if (null != loginVO.getTutorNameOrEmailAddress() && !(loginVO.getTutorNameOrEmailAddress()).contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getTutorPassword() + "'");

                }
                System.out.println(" sqlQueryPart :: " + sqlQueryPart);
            }

            pstmt = conn.prepareStatement(sqlQueryPart.toString());
            rst = pstmt.executeQuery();
            if (rst.next()) {
                 tutorId=rst.getString("TUTOR_ID");
                tutorCallName = rst.getString("NAME");
                membershipCategory = rst.getString("membership_category");
                tutorValidationFlag = true;

            } else {
                tutorValidationFlag = false;
                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
            }

            resultVO.setUserValidationFlag(tutorValidationFlag);
            resultVO.setMembershipCategory(membershipCategory);
            resultVO.setTutorId(tutorId);
            if (null != tutorCallName) {
                StringTokenizer st = new StringTokenizer(tutorCallName, " ");
                while (st.hasMoreTokens()) {
                    tutorCallName = st.nextToken();
                    break;
                }
                resultVO.setUserCallName(tutorCallName);
            }
        } catch (ProfessionalTutorsException pte) {
            throw pte;
        } catch (SQLException sqlException) {
            throw sqlException;
        } catch (Exception exception) {
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
        return resultVO;
    }

    /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public String populateSignInTutorCallName(LoginVO loginVO) throws Exception, ProfessionalTutorsException {
        String signInTutorCallName = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String tutorId = null;
            tutorId = loginVO.getTutorId();
            StringBuffer sqlQueryPart = new StringBuffer("select name from tutor_details where");
            if (null != tutorId && !"".equalsIgnoreCase(tutorId)) {
                if (null != loginVO.getTutorNameOrEmailAddress() && loginVO.getTutorNameOrEmailAddress().contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" email = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");
                    sqlQueryPart.append(" and tutorid = '" + tutorId + "'");
                } else if (null != loginVO.getTutorNameOrEmailAddress() && !(loginVO.getTutorNameOrEmailAddress()).contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");
                    sqlQueryPart.append(" and tutorid = '" + tutorId + "'");
                }
            } else {

                if (null != loginVO.getTutorNameOrEmailAddress() && loginVO.getTutorNameOrEmailAddress().contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" email = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");

                } else if (null != loginVO.getTutorNameOrEmailAddress() && !(loginVO.getTutorNameOrEmailAddress()).contains("@") && null != loginVO.getTutorPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getTutorNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");

                }
            }
            System.out.println("sqlQueryPart : " + sqlQueryPart.toString());
            pstmt = conn.prepareStatement(sqlQueryPart.toString());
            rst = pstmt.executeQuery();
            if (rst.next()) {
                signInTutorCallName = rst.getString("NAME");
            } else {

                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
            }
        } catch (ProfessionalTutorsException pte) {
            throw pte;
        } catch (SQLException sqlException) {
            throw sqlException;
        } catch (Exception exception) {
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
        StringTokenizer st = new StringTokenizer(signInTutorCallName, " ");
        while (st.hasMoreTokens()) {
            signInTutorCallName = st.nextToken();
            break;
        }

        return signInTutorCallName;
    }

    /**
     *
     * @param studentId
     * @param studentRegistrationVO
     * @return
     */
    public ResultVO updateStudentProfile(String studentId, StudentRegistrationVO studentRegistrationVO) throws ProfessionalTutorsException, SQLException, Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultVO resultVO = new ResultVO();

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String name = studentRegistrationVO.getName();
            String userLoginName = studentRegistrationVO.getUserLoginName();
            String password = studentRegistrationVO.getPassword();
            String secretQuestion = studentRegistrationVO.getSecretQuestion();
            String secretQuestionAnswer = studentRegistrationVO.getSecretQuestionAnswer();

            String age = studentRegistrationVO.getAge();
            String countryName = studentRegistrationVO.getCountryName();
            String cityName = studentRegistrationVO.getCityName();
            String cityCode = studentRegistrationVO.getCityCode();
            String area = studentRegistrationVO.getArea();
            String landmark = studentRegistrationVO.getLandmark();
            String address = studentRegistrationVO.getAddress();
            String guardianName = studentRegistrationVO.getGuardianname();

            String contactNumber = studentRegistrationVO.getContactNumber();
            String emailAddress = studentRegistrationVO.getEmail();
            String calltime = studentRegistrationVO.getCalltime();

            String schoolBoard = studentRegistrationVO.getSchoolOrBoard();
            String universityInstitute = studentRegistrationVO.getUniversityOrInstitute();
            String classStandard = studentRegistrationVO.getClassstandard();
            String medium = studentRegistrationVO.getMedium();
            String subject = studentRegistrationVO.getSubject();


            String tutionTitle = studentRegistrationVO.getTutionTitle();
            String tutionRequirement = studentRegistrationVO.getTutionRequirement();
            String segmentLevel = studentRegistrationVO.getSegmentLevel();
            String tutionRemarks = studentRegistrationVO.getTutionRemarks();


            String sqlQuery = "update student_details set name=?,user_login_name =?,password =?,"
                    + "secret_question_id=?,secret_question_answer=?,age=?,"
                    + "country_code=?,location_id=?,area=?,landmark=?,address=?,guardian_name=?,"
                    + "contact_number=?,email_address=?,call_time=?,"
                    + "school_board_id = ?,university_institute_id=?,education_segment_id=?,"
                    + "medium_id=?,tution_required_subject_id=?,tution_title=?,tution_required_subject_id=?,"
                    + "tution_segment_id=?,tution_remarks=? where student_id=?";

            PreparedStatement pst = conn.prepareStatement(sqlQuery);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, name);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, userLoginName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, password);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, secretQuestion);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, secretQuestionAnswer);
            pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_6, Integer.parseInt(age));
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, countryName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, cityCode);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, area);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, landmark);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, address);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, guardianName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, contactNumber);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, emailAddress);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, calltime);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_16, schoolBoard);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_17, universityInstitute);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_18, classStandard);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_19, medium);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_20, subject);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_21, tutionTitle);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_22, tutionRequirement);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_23, segmentLevel);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_24, tutionRemarks);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_25, studentId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                resultVO.setValidationMessage("Congratulation !!  You have successfully updated your profile  .  Thank You .");
                resultVO.setResultFlag("");
            } else {
                resultVO.setValidationMessage("Sorry .  Please try again");
                resultVO.setResultFlag("");
            }
        } /* catch (ProfessionalTutorsException pte) {
         throw pte;

         }*/ catch (Exception exception) {
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

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    public String editTutorPersonalDetails(TutorRegistrationVO tutorRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        String message = null;
        try {
            //DbConnection obj = new DbConnection();
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String tutorId = tutorRegistrationVO.getTutorId();
            String tutorName = tutorRegistrationVO.getTutorName();
            String tutorLoginName = tutorRegistrationVO.getTutorLoginName();
            String tutorPassword = tutorRegistrationVO.getTutorPassword();
            String securityQuestion = tutorRegistrationVO.getTutorSecretQuestion();
            String securityQuestionAnswer = tutorRegistrationVO.getTutorSecretQuestionAnswer();
            String tutorAge = tutorRegistrationVO.getTutorAge();
            /* Tutor Contact Information */
            String tutorCountryLocation = tutorRegistrationVO.getTutorCountryLocation();
            String tutorCityLocationId = tutorRegistrationVO.getTutorCityLocationId();
            System.out.println("tutorCityLocationId in service--------" + tutorCityLocationId);
            String tutorAddress = tutorRegistrationVO.getTutorAddress();
            String tutorEmailId = tutorRegistrationVO.getTutorEmailId();
            String tutorContactNumber = tutorRegistrationVO.getContactNumber();
            try {
                String sqlQuery = "update tutor_details set name=?, user_login_name = ? ,password = ?, secret_question_id = ?,"
                        + "secret_question_answer=?,age =?,country_code=?,location_id=?, address=?,contact_number=?,email_address=? "
                        + " where tutor_id=?";

                pst = conn.prepareStatement(sqlQuery);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, tutorLoginName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, tutorPassword);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, securityQuestion);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, securityQuestionAnswer);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, tutorAge);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, tutorCountryLocation);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, tutorCityLocationId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, tutorAddress);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, tutorContactNumber);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, tutorEmailId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, tutorId);

                System.out.println(" tutorName : " + tutorName);
                System.out.println(" Loging Name : " + tutorLoginName);
                System.out.println("tutorPassword :" + tutorPassword);
                System.out.println("securityQuestion  " + securityQuestion);
                System.out.println("securityQuestionAnswer " + securityQuestionAnswer);
                System.out.println(" tutorAge : " + tutorAge);
                System.out.println("tutorCountryLocation : " + tutorCountryLocation);
                System.out.println(" tutorCityLocation : " + tutorCityLocationId);
                System.out.println(" tutorAddress : " + tutorAddress);
                System.out.println("tutorContactNumber: " + tutorContactNumber);
                System.out.println(" tutorEmailId : " + tutorEmailId);
                System.out.println(" tutorId : " + tutorId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    message = "You have successfully updated personal details";
                } else {
                    message = "Sorry .  Please try to registered again";
                }
            } catch (Exception e) {
                System.out.println(" E:--------------> " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception exception) {
            System.out.println("Exception Message : " + exception.getMessage());
            exception.printStackTrace();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return message;
    }

    public String editTutorTutoringProcedureDetails(TutorRegistrationVO tutorRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        String message = null;
        try {
            //DbConnection obj = new DbConnection();
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            //  Statement  st = conn.createStatement();
            String tutorId = tutorRegistrationVO.getTutorId();
            String tutorName = tutorRegistrationVO.getTutorName();
            String tutorLoginName = tutorRegistrationVO.getTutorLoginName();
            String tutorPassword = tutorRegistrationVO.getTutorPassword();
            String securityQuestion = tutorRegistrationVO.getTutorSecretQuestion();
            String securityQuestionAnswer = tutorRegistrationVO.getTutorSecretQuestionAnswer();
            // File uploadInage = tutorRegistrationVO.getUploadImage();  Pending for Enhancement

            String tutorAge = tutorRegistrationVO.getTutorAge();

            /* Tutoring Procedure Details */
            String tutoringExperience = tutorRegistrationVO.getTutoringExperience();
            String preferenceToTeaching = tutorRegistrationVO.getPreferenceToTeaching();
            String tutorYearsOfExperience = tutorRegistrationVO.getTutorYearsOfExperience();
            String preferredTutoringArea = tutorRegistrationVO.getPreferredTutoringArea();
            String tutorTeachingPatteren = tutorRegistrationVO.getTutorTeachingPatteren();
            String tutoringOptions = tutorRegistrationVO.getTutoringOptions();
            String teachingMedium = tutorRegistrationVO.getTeachingMedium();
            String teachingLevel = tutorRegistrationVO.getTeachingLevel();
            String tutoringApproach = tutorRegistrationVO.getTutoringApproach();

            /* Tutor Contact Information */
            String tutorCountryLocation = tutorRegistrationVO.getTutorCountryLocation();
            String tutorCityLocation = tutorRegistrationVO.getTutorCityLocation();
            String tutorAddress = tutorRegistrationVO.getTutorAddress();
            String tutorArea = tutorRegistrationVO.getTutorArea();
            String tutorEmailId = tutorRegistrationVO.getTutorEmailId();
            String tutorContactNumber = tutorRegistrationVO.getContactNumber();
            String feeExpected = tutorRegistrationVO.getFeeExpected();

            String sqlQuery = "update tutor_details set name=?, user_login_name = ? ,password = ?, secret_question = ?,"
                    + "secret_question_answer=?,age =?,country_name=?,location_name=?, address=?,contact_number=?,email_address=?,"
                    + "pref_subject_to_teach=?, years_of_tutoring_experience = ?,preferred_tutoring_area=?,teaching_patteren=?,tutoring_options=?,"
                    + "teaching_medium=?,teaching_segment_level=?,expected_fees=?,tutoring_experience=? where tutor_id=?";

            pst = conn.prepareStatement(sqlQuery);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, tutorLoginName);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, tutorPassword);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, securityQuestion);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, securityQuestionAnswer);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, tutorAge);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, tutorCountryLocation);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, tutorCityLocation);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, tutorAddress);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, tutorContactNumber);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, tutorEmailId);

            /* Educational Qualification */

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, preferenceToTeaching);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, tutorYearsOfExperience);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, preferredTutoringArea);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, tutorTeachingPatteren);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_16, tutoringOptions);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_17, teachingMedium);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_18, teachingLevel);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_19, feeExpected);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_20, tutoringExperience);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_21, tutorId);


            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                message = "Congratulation !!  You have successfully registered as profession tutor  .  Thank You .";
            } else {
                message = "Sorry .  Please try to registered again";
            }
        } catch (Exception exception) {
            exception.getMessage();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return message;
    }

    /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public StudentRegistrationVO populateStudentProfile(LoginVO loginVO) throws Exception, ProfessionalTutorsException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();

        if (null != loginVO) {
            try {

                ResultVO resultVO = studentValidation(loginVO);
                boolean studentValidationFlag = resultVO.isUserValidationFlag();
                if (studentValidationFlag) {

                    DbConnection dbConnection = new DbConnection();
                    conn = dbConnection.dbConnect();

                    StringBuffer sqlQueryPart = new StringBuffer("select * from student_details where");
                    if (null != loginVO.getStudentNameOrEmailAddress() && loginVO.getStudentNameOrEmailAddress().contains("@") && null != loginVO.getStudentPassword()) {
                        sqlQueryPart.append(" emailaddress = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                        sqlQueryPart.append(" and password = '" + loginVO.getStudentPassword() + "'");
                    } else if (null != loginVO.getStudentNameOrEmailAddress() && !loginVO.getStudentNameOrEmailAddress().contains("@") && null != loginVO.getStudentPassword()) {
                        sqlQueryPart.append(" user_login_name = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                        sqlQueryPart.append(" and password = '" + loginVO.getStudentPassword() + "'");
                    }

                    pstmt = conn.prepareStatement(sqlQueryPart.toString());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        /* Student login information */
                        studentRegistrationVO.setStudentId(rs.getString("STUDENT_ID"));
                        studentRegistrationVO.setName(rs.getString("NAME"));
                        studentRegistrationVO.setUserLoginName(rs.getString("USER_LOGIN_NAME"));
                        studentRegistrationVO.setPassword(rs.getString("PASSWORD"));
                        studentRegistrationVO.setSecretQuestion("SECRET_QUESTION");
                        studentRegistrationVO.setSecretQuestionAnswer("SECRET_QUESTION_ANSWER");

                        /* Student Personal Information */
                        studentRegistrationVO.setSex(rs.getString("GENDER"));
                        studentRegistrationVO.setAge(rs.getString("AGE"));
                        studentRegistrationVO.setCountryName(rs.getString("COUNTRY_NAME"));
                        studentRegistrationVO.setCityName(rs.getString("LOCATION_NAME"));
                        studentRegistrationVO.setArea(rs.getString("AREA"));
                        studentRegistrationVO.setLandmark(rs.getString("LAND_MARK"));
                        studentRegistrationVO.setAddress(rs.getString("ADDRESS"));
                        studentRegistrationVO.setGuardianname(rs.getString("GUARDIAN_NAME"));
                        studentRegistrationVO.setContactNumber(rs.getString("CONTACT_NUMBER"));
                        studentRegistrationVO.setEmail(rs.getString("EMAIL_ADDRESS"));
                        studentRegistrationVO.setCalltime(rs.getString("CALL_TIME"));

                        /* Student Education Information */
                        studentRegistrationVO.setSchoolOrBoard(rs.getString("SCHOOL_BOARD"));
                        studentRegistrationVO.setUniversityOrInstitute(rs.getString("UNIVERSITY_INSTITUTE"));
                        studentRegistrationVO.setClassstandard(rs.getString("CLASS_STANDARD"));
                        studentRegistrationVO.setMedium(rs.getString("MEDIUM"));
                        studentRegistrationVO.setSubject(rs.getString("SUBJECT"));

                        /* Student Post Tution Requirement Information */
                        studentRegistrationVO.setTutionTitle(rs.getString("TUTION_TITLE"));
                        studentRegistrationVO.setTutionRequirement(rs.getString("TUTION_REQUIRED_SEBJECT"));
                        studentRegistrationVO.setSegmentLevel(rs.getString("TUTION_SEGMENT_LEVEL"));
                        studentRegistrationVO.setTutionRemarks(rs.getString("TUTION_REMARKS"));

                        /* Internally Stored dat for Student */

                        studentRegistrationVO.setRegistrationDate(rs.getString("REGISTRATION_DATE"));
                        studentRegistrationVO.setImageFlag(rs.getBoolean("IMAGE_FLAG"));

                    }
                }
            } catch (ProfessionalTutorsException pte) {
                throw pte;
            } catch (SQLException sqlException) {
                throw sqlException;
            } catch (Exception exception) {
                throw exception;
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
                    throw sqlException;
                }
            }
        }
        return studentRegistrationVO;
    }

    /**
     *
     * @param loginVO
     * @return
     * @throws Exception
     * @throws ProfessionalTutorsException
     */
    public ResultVO studentValidation(LoginVO loginVO) throws Exception, ProfessionalTutorsException {
        ResultVO resultVO = new ResultVO();
        String studentCallName = null;
        boolean studentValidationFlag = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            StringBuffer sqlQueryPart = new StringBuffer("select STUDENT_ID, name , membership_category from student_details where");

            String studentId = null;

            studentId = loginVO.getStudentId();

            if (null != studentId && !"".equalsIgnoreCase(studentId)) {
                if (null != loginVO.getStudentNameOrEmailAddress() && loginVO.getStudentNameOrEmailAddress().contains("@") && null != loginVO.getStudentPassword()) {
                    sqlQueryPart.append(" email_address = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getStudentPassword() + "'");
                    sqlQueryPart.append(" and student_id = '" + studentId + "'");
                } else if (null != loginVO.getStudentNameOrEmailAddress() && !(loginVO.getStudentNameOrEmailAddress()).contains("@") && null != loginVO.getStudentPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getStudentPassword() + "'");
                    sqlQueryPart.append(" and student_id = '" + studentId + "'");
                }
            } else {
                if (null != loginVO.getStudentNameOrEmailAddress() && loginVO.getStudentNameOrEmailAddress().contains("@") && null != loginVO.getStudentPassword()) {
                    sqlQueryPart.append(" email_address = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getStudentPassword() + "'");
                } else if (null != loginVO.getStudentNameOrEmailAddress() && !(loginVO.getStudentNameOrEmailAddress()).contains("@") && null != loginVO.getStudentPassword()) {
                    sqlQueryPart.append(" user_login_name = '" + loginVO.getStudentNameOrEmailAddress() + "'");
                    sqlQueryPart.append(" and binary password = '" + loginVO.getStudentPassword() + "'");
                }
            }
            // System.out.println(" sqlQueryPart.toString() ################### " + sqlQueryPart.toString());
            pstmt = conn.prepareStatement(sqlQueryPart.toString());
            rst = pstmt.executeQuery();
            if (rst.next()) {
                studentValidationFlag = true;
                studentId=rst.getString("STUDENT_ID");
                studentCallName = rst.getString("name");
                resultVO.setMembershipCategory(rst.getString("membership_category"));
            } else {
                studentValidationFlag = false;
                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid Student Credential !!");
            }

            resultVO.setUserValidationFlag(studentValidationFlag);
             resultVO.setStudentId(studentId);
            if (null != studentCallName) {
                StringTokenizer st = new StringTokenizer(studentCallName, " ");
                while (st.hasMoreTokens()) {
                    studentCallName = st.nextToken();
                    break;
                }
                resultVO.setUserCallName(studentCallName);
            }


        } catch (ProfessionalTutorsException pte) {
            throw pte;
        } catch (SQLException sqlException) {
            throw sqlException;
        } catch (Exception exception) {
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
        return resultVO;
    }

    /**
     *
     * @param studentId
     * @return
     */
    public StudentRegistrationVO populateStudentProfileByStudentId(String studentId) {
        System.out.println(" Inside ....student full #################################");
        StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
        String subject = null;
        String countryName = null;
        String cityName = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (null != studentId) {

            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String sqlQuery = "select sd.student_id, sd.name,sd.gender,sd.age,cn.country_name,loc.location_name,sd.area,sd.landmark,sd.address,sd.guardian_name,sd.contact_number,sd.email_address,sd.call_time,sd.school_board_id,sb.school_board_name ,sd.other_school_board,sd.university_institute_id,univ.university_institute_name,sd.other_university_institute_name,sd.education_segment_id,education_segment_name,other_education_segment_name,sd.medium_id,tm.medium_name,sd.other_medium_name,sd.tution_title,sub.subject_id,sub.subject_name,sd.other_tution_required_subject_name,sd.tution_segment_id,ecat.education_segment_name ,sd.other_tution_segment_name,sd.tution_remarks,sd.registration_date,sd.image_flag,sd.membership_category from student_details sd , country_name cn ,location_name loc,school_board sb,university_institute univ , education_categories ecat,teaching_medium tm , subject sub where sd.country_code = cn.country_code  and sd.location_id = loc.location_id and cn.country_code = loc.country_code and sd.school_board_id = sb.school_board_id and sd.university_institute_id =univ.university_institute_id and sd.education_segment_id = ecat.education_segment_id and sd.medium_id = tm.medium_id and sd.tution_required_subject_id = sub.subject_id and sd.student_id=?";
                //  StringBuffer sqlQueryPart = new StringBuffer("select student_id, name,gender,age,country_name,location_name,area,landmark,address,guardian_name,contact_number,email_address,call_time,school_board_id,school_board_name ,other_school_board,university_institute_id,university_institute_name,other_university_institute_name,education_segment_id,education_segment_name,other_education_segment_name,medium_id,medium_name , other_medium_name,tution_title,subject_id,subject_name,other_tution_required_subject_name,tution_segment_id,education_segment_name ,other_tution_segment_name,tution_remarks,registration_date,image_flag,membership_category from student_details sd , country_name cn ,location_name loc,school_board sb,university_institute univ , education_categories ecat,teaching_medium tm , subject sub where sd.country_code = cn.country_code  and sd.location_id = loc.location_id and cn.country_code = loc.country_code and sd.school_board_id = sb.school_board_id and sd.university_institute_id =univ.university_institute_id and sd.education_segment_id = ecat.education_segment_id and sd.medium_id = tm.medium_id and sd.tution_required_subject_id = sub.subject_id and sd.student_id=?");

                //System.out.println("sqlQueryPart -->> "+ sqlQueryPart   +  " studentId  : "+ studentId);
                pst = conn.prepareStatement(sqlQuery);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, studentId);

                rs = pst.executeQuery();
                while (rs.next()) {
                    /* Student login information */
                    studentRegistrationVO.setStudentId(rs.getString("student_id"));
                    studentRegistrationVO.setName(rs.getString("name"));

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
                    String schoolBoardId = rs.getString("school_board_id");
                    String schoolBoardName = rs.getString("school_board_name");

                    if (schoolBoardName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setSchoolOrBoard(rs.getString("other_school_board"));
                    } else if (!schoolBoardId.equals("-1")) {
                        studentRegistrationVO.setSchoolOrBoard(schoolBoardName);
                    }

                    String universityInstituteId = rs.getString("university_institute_id");
                    String universityInstituteName = rs.getString("university_institute_name");

                    if (universityInstituteName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setUniversityOrInstitute(rs.getString("other_university_institute_name"));
                    } else if (!universityInstituteId.equals("-1")) {
                        studentRegistrationVO.setUniversityOrInstitute(universityInstituteName);
                    }
                    String educationSegmentName = rs.getString("education_segment_name");

                    String educationSegmentId = rs.getString("education_segment_id");
                    if (educationSegmentName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setClassstandard(rs.getString("other_education_segment_name"));
                    } else if (!educationSegmentId.equals("-1")) {
                        studentRegistrationVO.setClassstandard(educationSegmentName);
                    }
                    String mediumId = rs.getString("medium_id");
                    String mediumName = rs.getString("medium_name");
                    if (mediumName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setMedium(rs.getString("other_medium_name"));
                    } else if (!mediumId.equals("-1")) {
                        studentRegistrationVO.setMedium(mediumName);
                    }

                    /* Student Post Tution Requirement Information */
                    studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));


                    String subjectId = rs.getString("subject_id");
                    String subjectName = rs.getString("subject_name");
                    if (subjectName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setTutionRequirement(rs.getString("other_tution_required_subject_name"));
                    } else if (!subjectId.equals("-1")) {
                        studentRegistrationVO.setTutionRequirement(subjectName);
                    }
                    String tutionSegmentId = rs.getString("tution_segment_id");
                    String segmentLevel = rs.getString("education_segment_name");
                    if (segmentLevel.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setSegmentLevel(rs.getString("other_tution_segment_name"));
                    } else if (!tutionSegmentId.equals("-1")) {
                        studentRegistrationVO.setSegmentLevel(segmentLevel);
                    }
                    studentRegistrationVO.setTutionRemarks(rs.getString("tution_remarks"));

                    /* Internally Stored dat for Student */

                    studentRegistrationVO.setRegistrationDate(DateConversion.convertDate(rs.getString("registration_date")));
                    studentRegistrationVO.setImageFlag(rs.getBoolean("image_flag"));
                    studentRegistrationVO.setMembershipCategory(rs.getString("membership_category"));

                    // subject = rs.getString("subject");
                    //countryName = rs.getString("country");
                    //cityName = rs.getString("location");
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
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
                }
            }

//            List<TutorRegistrationVO> listOfSubjectWiseTutor = populateSubjectWiseTutor(subject, countryName, cityName);

        }
        return studentRegistrationVO;
    }

    /**
     *
     * @param studentId
     * @return
     */
    public StudentRegistrationVO populateStudentFullProfile(LoginVO loginVO) {
        System.out.println(" Inside ....student full profile ..............----->");
        StudentRegistrationVO studentRegistrationVO = new StudentRegistrationVO();
        String subject = null;
        String countryName = null;
        String cityName = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        if (null != loginVO) {

            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String studentUserName = null;
                String studentPassword = null;
                String studentId = null;

                studentUserName = loginVO.getStudentNameOrEmailAddress(); // trim()  should not use here for all 3 cases
                studentPassword = loginVO.getStudentPassword();
                studentId = loginVO.getStudentId();

                System.out.println(" studentUserName  : " + studentUserName + " studentPassword : " + studentPassword + "studentId " + studentId);


                StringBuffer sqlQueryPart = new StringBuffer("select student_id, name,user_login_name,"
                        + "password,sd.secret_question_id,secret_question_value,secret_question_answer,"
                        + "gender,age,cn.country_code,country_name,loc.location_id,location_name,area,landmark,address,"
                        + "guardian_name,contact_number,email_address,call_time,school_board_name ,"
                        + "other_school_board,university_institute_name,other_university_institute_name, "
                        + "education_segment_name,other_education_segment_name ,medium_name , "
                        + "other_medium_name,tution_title,subject_name,other_tution_required_subject_name,"
                        + "education_segment_name ,other_tution_segment_name,tution_remarks,"
                        + "registration_date,image_flag ,profile_verification_status,"
                        + "profile_active_deactive_status,membership_category,duration mode_of_payment ,"
                        + "payment_amount,membership_begin_date,membership_expire_warning_date,"
                        + "membership_expire_date,sd.education_segment_id,sd.school_board_id,sd.university_institute_id,"
                        + "sd.medium_id,sd.tution_required_subject_id,sd.tution_segment_id from student_details sd , "
                        + "secret_question seq ,country_name cn ,location_name loc,school_board sb,"
                        + "university_institute univ , education_categories ecat,teaching_medium tm , "
                        + "subject sub where sd.secret_question_id = seq.secret_question_id and "
                        + "sd.country_code = cn.country_code  and sd.location_id = loc.location_id and "
                        + "cn.country_code = loc.country_code and sd.school_board_id = sb.school_board_id and "
                        + "sd.university_institute_id =univ.university_institute_id and "
                        + "sd.education_segment_id = ecat.education_segment_id and "
                        + "sd.medium_id = tm.medium_id and sd.tution_required_subject_id = sub.subject_id and ");


                if (null != studentUserName && studentUserName.contains("@") && null != studentPassword) {
                    sqlQueryPart.append(" email_address = '" + studentUserName + "'");
                    sqlQueryPart.append(" and password = '" + studentPassword + "'");
                } else if (null != studentUserName && !(studentUserName).contains("@") && null != studentPassword) {
                    sqlQueryPart.append(" user_login_name = '" + studentUserName + "'");
                    sqlQueryPart.append(" and password = '" + studentPassword + "'");
                }
                System.out.println("Student Sql ::  " + sqlQueryPart.toString());
                pst = conn.prepareStatement(sqlQueryPart.toString());


                rs = pst.executeQuery();
                while (rs.next()) {
                    /* Student login information */
                    studentRegistrationVO.setStudentId(rs.getString("student_id"));
                    studentRegistrationVO.setName(rs.getString("name"));
                    studentRegistrationVO.setUserLoginName(rs.getString("user_login_name"));
                    studentRegistrationVO.setPassword(rs.getString("password"));
                    studentRegistrationVO.setSecretQuestion(rs.getString("secret_question_id"));
                    studentRegistrationVO.setSecretQuestionAnswer(rs.getString("secret_question_answer"));
                    /* Student Personal Information */

                    studentRegistrationVO.setSex(rs.getString("gender"));
                    studentRegistrationVO.setAge(rs.getString("age"));
                    studentRegistrationVO.setCountryName(rs.getString("country_code"));
                    studentRegistrationVO.setCityName(rs.getString("location_name"));
                    studentRegistrationVO.setCityCode(rs.getString("location_id"));
                    studentRegistrationVO.setArea(rs.getString("area"));
                    studentRegistrationVO.setLandmark(rs.getString("landmark"));
                    studentRegistrationVO.setAddress(rs.getString("address"));
                    studentRegistrationVO.setGuardianname(rs.getString("guardian_name"));
                    studentRegistrationVO.setContactNumber(rs.getString("contact_number"));
                    studentRegistrationVO.setEmail(rs.getString("email_address"));
                    studentRegistrationVO.setCalltime(rs.getString("call_time"));

                    /* Student Education Information */

                    studentRegistrationVO.setSchoolOrBoardId(rs.getString("school_board_id"));
                    String schoolBoardName = rs.getString("school_board_name");

                    if (schoolBoardName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setSchoolOrBoard(rs.getString("other_school_board"));
                    } else {
                        studentRegistrationVO.setSchoolOrBoard(schoolBoardName);
                    }

                    studentRegistrationVO.setUniversityOrInstituteId(rs.getString("university_institute_id"));
                    String universityInstituteName = rs.getString("university_institute_name");
                    if (universityInstituteName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setUniversityOrInstitute(rs.getString("other_university_institute_name"));
                    } else {
                        studentRegistrationVO.setUniversityOrInstitute(universityInstituteName);

                    }
                    studentRegistrationVO.setClassstandardId(rs.getString("education_segment_id"));

                    String classStandard = rs.getString("education_segment_name");
                    if (classStandard.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setClassstandard(rs.getString("other_education_segment_name"));
                    } else {
                        studentRegistrationVO.setClassstandard(classStandard);
                    }

                    studentRegistrationVO.setMediumId(rs.getString("medium_id"));
                    String mediumName = rs.getString("medium_name");
                    if (mediumName.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setMedium(rs.getString("other_medium_name"));
                    } else {
                        studentRegistrationVO.setMedium(mediumName);
                    }


                    /* Student Post Tution Requirement Information */
                    studentRegistrationVO.setTutionTitle(rs.getString("tution_title"));

                    studentRegistrationVO.setTutionRequirementId(rs.getString("tution_required_subject_id"));
                    String tutionRequirement = rs.getString("subject_name");
                    if (tutionRequirement.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setTutionRequirement(rs.getString("other_tution_required_subject_name"));
                    } else {
                        studentRegistrationVO.setTutionRequirement(tutionRequirement);
                    }

                    studentRegistrationVO.setSegmentLevelId(rs.getString("tution_segment_id"));


                    String segmentLevel = rs.getString("education_segment_name");

                    if (segmentLevel.equalsIgnoreCase(ProfessionalTutorsConstant.OTHER_VALUE)) {
                        studentRegistrationVO.setSegmentLevel(rs.getString("other_tution_segment_name"));

                    } else {
                        studentRegistrationVO.setSegmentLevel(segmentLevel);
                    }


                    studentRegistrationVO.setTutionRemarks(rs.getString("tution_remarks"));

                    /* Internally Stored dat for Student */

                    studentRegistrationVO.setRegistrationDate(DateConversion.convertDate(rs.getString("registration_date")));
                    studentRegistrationVO.setImageFlag(rs.getBoolean("image_flag"));

                    studentRegistrationVO.setProfileVerificationStatus(rs.getString("profile_verification_status"));
                    studentRegistrationVO.setProfileActiveDeactiveStatus(rs.getString("profile_active_deactive_status"));

                    studentRegistrationVO.setMembershipCategory(rs.getString("membership_category"));
                    studentRegistrationVO.setDuration(rs.getString("duration"));

                    studentRegistrationVO.setModeOfPayment(rs.getString("mode_of_payment"));
                    studentRegistrationVO.setPaymentAmount(rs.getString("payment_amount"));
                    studentRegistrationVO.setMembershipBeginDate(rs.getString("membership_begin_date"));
                    studentRegistrationVO.setMembershipExpireWarningDate(rs.getString("membership_expire_warning_date"));
                    studentRegistrationVO.setMembershipExpireDate(rs.getString("membership_expire_date"));

                    subject = rs.getString("subject_name");
                    countryName = rs.getString("country_name");
                    cityName = rs.getString("location_name");

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
            //      List<TutorRegistrationVO> listOfSubjectWiseTutor = populateSubjectWiseTutor(subject, countryName, cityName);

        }
        return studentRegistrationVO;
    }

    /**
     *
     * @param loginVO
     * @return
     */
    public TutorRegistrationVO populateTutorFullProfile(LoginVO loginVO) {
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        if (null != loginVO) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String tutorUserName = null;
                String tutorPassword = null;
                String tutorId = null;

                tutorUserName = loginVO.getTutorNameOrEmailAddress(); // should not use trim() here
                tutorPassword = loginVO.getTutorPassword(); // should not use trim() here
                tutorId = loginVO.getTutorId(); // should not use trim() here
                
                System.out.println("tutorUserName = "+tutorUserName+", tutorPassword = "+tutorPassword+", tutorId = "+tutorId);

                StringBuffer sqlQueryPart = new StringBuffer("select td.tutor_id ,td.name ,td.user_login_name,td.password,td.secret_question_id,td.secret_question_answer,td.age,td.gender,td.country_code,cn.country_name,td.location_id,loc.location_name ,td.address ,td.contact_number ,td.email_address ,td.years_of_tutoring_experience,td.preferred_tutoring_area,td.expected_fees,td.tutoring_experience,td.registration_date,td.image_flag from tutor_details  td ,country_name cn , location_name loc where td.country_code = cn.country_code and td.location_id = loc.location_id and ");

                if (null != tutorUserName && tutorUserName.contains("@") && null != tutorPassword && null != tutorId) {
                    sqlQueryPart.append(" email_address = '" + tutorUserName + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");
                    sqlQueryPart.append(" and tutor_id = '" + tutorId + "'");
                } else if (null != tutorUserName && !(tutorUserName).contains("@") && null != tutorPassword && null != tutorId) {
                    sqlQueryPart.append(" user_login_name = '" + tutorUserName + "'");
                    sqlQueryPart.append(" and password = '" + tutorPassword + "'");
                    sqlQueryPart.append(" and tutor_id = '" + tutorId + "'");
                } else if (null == tutorUserName && null == tutorPassword && null != tutorId && !"".equalsIgnoreCase(tutorId)) {
                    sqlQueryPart.append("  tutor_id = '" + tutorId + "'");
                } else if (null != tutorUserName && tutorUserName.contains("@") && null != tutorPassword && null == tutorId) {
                    sqlQueryPart.append(" email_address = '" + tutorUserName + "'");
                    sqlQueryPart.append(" and password = '" + loginVO.getTutorPassword() + "'");
                } else if (null != tutorUserName && !(tutorUserName).contains("@") && null != tutorPassword && null == tutorId) {
                    sqlQueryPart.append(" user_login_name = '" + tutorUserName + "'");
                    sqlQueryPart.append(" and password = '" + tutorPassword + "'");
                }
                //SELECT * FROM TUTORDETAILS WHERE user_login_name = 'alok' and password = 'password' and tutorid = '50'

                System.out.println("sqlQueryPart.toString() :::: " + sqlQueryPart.toString());
                pst = conn.prepareStatement(sqlQueryPart.toString());
                rst = pst.executeQuery();
                while (rst.next()) {
                    tutorId = rst.getString("tutor_id");
                    System.out.println("Tutor Id ::::::::::::::::: -------------------> " + rst.getString("tutor_id"));
                    /* Tutor Login Information */
                    tutorRegistrationVO.setTutorId(rst.getString("tutor_id"));
                    tutorRegistrationVO.setTutorName(rst.getString("name"));
                    tutorRegistrationVO.setTutorLoginName(rst.getString("user_login_name"));
                    System.out.println("nnnnnnnme is                             =" + rst.getString("user_login_name"));
                    tutorRegistrationVO.setTutorPassword(rst.getString("password"));
                    tutorRegistrationVO.setTutorSecretQuestion(rst.getString("secret_question_id"));
                    tutorRegistrationVO.setTutorSecretQuestionAnswer(rst.getString("secret_question_answer"));

                    /* Tutor Personal Information */
                    tutorRegistrationVO.setTutorSex(rst.getString("gender"));
                    tutorRegistrationVO.setTutorAge(rst.getString("age"));
                    tutorRegistrationVO.setTutorCountryLocation(rst.getString("country_name"));
                    tutorRegistrationVO.setTutorCityLocation(rst.getString("location_name"));
                    System.out.println("service location name" + rst.getString("location_name"));
                    tutorRegistrationVO.setTutorCountryCode(rst.getString("country_code"));
                    tutorRegistrationVO.setTutorCityLocationId(rst.getString("location_id"));
                    System.out.println("service location id" + rst.getString("location_id"));
                    tutorRegistrationVO.setTutorAddress(rst.getString("address"));
                    tutorRegistrationVO.setContactNumber(rst.getString("contact_number"));
                    tutorRegistrationVO.setTutorEmailId(rst.getString("email_address"));


                    /* Tutor Tutoring Information */
                    tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("years_of_tutoring_experience"));
                    tutorRegistrationVO.setPreferredTutoringArea(rst.getString("preferred_tutoring_area"));
                    tutorRegistrationVO.setFeeExpected(rst.getString("expected_fees"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("tutoring_experience"));
                    tutorRegistrationVO.setImageFlag(rst.getBoolean("image_flag"));

                    tutorRegistrationVO.setRegistrationDate(rst.getString("registration_date"));


                } // End of While loop


                String selectUgQualification = "select cn.course_short_name , tue.other_course_name,sub.subject_name ,tue.other_subject_name,unv.university_institute_name ,tue.other_university_name, tue.year_of_passout from tutor_ug_education tue , course_name cn ,subject sub ,university_institute unv where tue.subject_id = sub.subject_id and  tue.course_id = cn.course_id and tue.university_institute_id = unv.university_institute_id and tue.tutor_id =?";

                pst = conn.prepareStatement(selectUgQualification);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();

                while (rst.next()) {
                    String courseName = rst.getString("course_short_name");
                    String otherCourseName = rst.getString("other_course_name");
                    String subjectName = rst.getString("subject_name");
                    String otherSubjectName = rst.getString("other_subject_name");
                    String universityInstituteName = rst.getString("university_institute_name");
                    String otherUniversityInstituteName = rst.getString("other_university_name");

                    if (courseName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setUgQualifyingDegree(otherCourseName);
                    } else {
                        tutorRegistrationVO.setUgQualifyingDegree(courseName);
                    }

                    if (subjectName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setUgSpecialization(otherSubjectName);
                    } else {
                        tutorRegistrationVO.setUgSpecialization(subjectName);
                    }

                    if (universityInstituteName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setUgBoardOrUniversity(otherUniversityInstituteName);
                    } else {
                        tutorRegistrationVO.setUgBoardOrUniversity(universityInstituteName);
                    }

                    tutorRegistrationVO.setUgPassoutYear(rst.getString("year_of_passout"));
                } // End of While loop



                String selectPgQualification = "select cn.course_short_name ,tpe.other_course_name, sub.subject_name,tpe.other_subject_name,unv.university_institute_name ,tpe.other_university_institute_name,tpe.year_of_passout from tutor_pg_education tpe , course_name cn ,subject sub ,university_institute unv where tpe.subject_id = sub.subject_id and tpe.course_id = cn.course_id and tpe.university_institute_id = unv.university_institute_id and tpe.tutor_id =?";
                pst = conn.prepareStatement(selectPgQualification);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();

                if (rst.next()) {
                    String courseName = rst.getString("course_short_name");
                    String otherCourseName = rst.getString("other_course_name");
                    String subjectName = rst.getString("subject_name");
                    String otherSubjectName = rst.getString("other_subject_name");
                    String universityInstituteName = rst.getString("university_institute_name");
                    String otherUniversityInstituteName = rst.getString("other_university_institute_name");

                    if (courseName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setPgQualifyingDegree(otherCourseName);
                    } else {
                        tutorRegistrationVO.setPgQualifyingDegree(courseName);
                    }

                    if (subjectName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setPgSpecialization(otherSubjectName);
                    } else {
                        tutorRegistrationVO.setPgSpecialization(subjectName);
                    }

                    if (universityInstituteName.equalsIgnoreCase("Other")) {
                        tutorRegistrationVO.setPgBoardOrUniversity(otherUniversityInstituteName);
                    } else {
                        tutorRegistrationVO.setPgBoardOrUniversity(universityInstituteName);
                    }

                    tutorRegistrationVO.setPgPassoutYear(rst.getString("year_of_passout"));
                }

                String selectSubject = "select sub.subject_name , ts.other_subject_name from tutor_subject ts, subject sub where ts.subject_id = sub.subject_id and ts.tutor_id =?";

                pst = conn.prepareStatement(selectSubject);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();
                StringBuilder strSubject = new StringBuilder();
                while (rst.next()) {
                    String subjectName = rst.getString("subject_name");
                    String otherSubjectName = rst.getString("other_subject_name");
                    if (subjectName.equalsIgnoreCase("Other")) {
                        strSubject.append(otherSubjectName);
                    } else {
                        strSubject.append(subjectName);
                        strSubject.append(",");
                    }

                } // End of While loop


                String selectTeachingLevel = "select ecat.education_segment_name,tts.other_teaching_segment_name from tutor_teaching_segment tts, education_categories ecat where tts.education_segment_id = ecat.education_segment_id and tts.tutor_id =?";


                pst = conn.prepareStatement(selectTeachingLevel);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();
                StringBuilder strTeachingLevel = new StringBuilder();
                while (rst.next()) {
                    String teachingLevel = rst.getString("education_segment_name");
                    String otherTeachingLevel = rst.getString("other_teaching_segment_name");
                    if (teachingLevel.equalsIgnoreCase("Other")) {
                        strTeachingLevel.append(otherTeachingLevel);
                    } else {
                        strTeachingLevel.append(teachingLevel);
                        strTeachingLevel.append(",");

                    }
                } // End of While loop


                String selectTeachingMedium = "select tmed.medium_name , tm.other_medium_name from tutor_medium tm, teaching_medium tmed where tm.medium_id = tmed.medium_id and tm.tutor_id =?";


                pst = conn.prepareStatement(selectTeachingMedium);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();
                StringBuilder strTeachingMedium = new StringBuilder();
                while (rst.next()) {
                    String mediumName = rst.getString("medium_name");
                    String otherMediumName = rst.getString("other_medium_name");
                    if (mediumName.equalsIgnoreCase("Other")) {
                        strTeachingMedium.append(otherMediumName);
                    } else {
                        strTeachingMedium.append(mediumName);
                        strTeachingMedium.append(",");
                    }
                } // End of While loop


                String selectTeachingOption = "select topt.teaching_option_name ,tto.other_teaching_option_name from teaching_option topt ,tutor_teaching_option tto where topt.teaching_option_id = tto.teaching_option_id and tutor_id =?";
                pst = conn.prepareStatement(selectTeachingOption);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();
                StringBuilder strTutoringOptions = new StringBuilder();
                while (rst.next()) {
                    String teachingOptionName = rst.getString("teaching_option_name");
                    String otherTeachingOptionName = rst.getString("other_teaching_option_name");
                    if (teachingOptionName.equalsIgnoreCase("Other")) {
                        strTutoringOptions.append(otherTeachingOptionName);
                    } else {
                        strTutoringOptions.append(teachingOptionName);
                        strTutoringOptions.append(",");

                    }
                } // End of While loop

                String selectTeachingPatteren = "select tpat.teaching_patteren_name,ttp.other_teaching_patteren_name from teaching_patteren tpat ,tutor_teaching_patteren ttp where tpat.teaching_patteren_id = ttp.teaching_patteren_id and ttp.tutor_id =?";
                pst = conn.prepareStatement(selectTeachingPatteren);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorId);
                rst = pst.executeQuery();
                StringBuilder strTeachingPatteren = new StringBuilder();
                while (rst.next()) {
                    String teachingPatterenName = rst.getString("teaching_patteren_name");
                    String otherTeachingPatterenName = rst.getString("other_teaching_patteren_name");
                    if (teachingPatterenName.equalsIgnoreCase("Other")) {
                        strTeachingPatteren.append(otherTeachingPatterenName);
                    } else {
                        strTeachingPatteren.append(teachingPatterenName);
                        strTeachingPatteren.append(",");
                    }
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

                System.out.println(" ______________________________Tutor Full Profile ---------------------");

            } catch (SQLException sqlExcdeption) {
                sqlExcdeption.printStackTrace();
            } catch (Exception exception) {
                System.out.println("Message : " + exception.getMessage());

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
        return tutorRegistrationVO;
    }

    /**
     *
     * @param subject
     * @param countryName
     * @param cityName
     * @return
     */
    public List<TutorRegistrationVO> populateSubjectWiseTutor(String subjectId, String countryCode, String locationId) throws Exception, ProfessionalTutorsException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        List<String> listOfSearchTutorIds = new ArrayList<String>();
        List<TutorRegistrationVO> listOfTutorSearchResult = new ArrayList<TutorRegistrationVO>();



        if (null != subjectId && null != countryCode) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String sqlQuery = "select distinct td.tutor_id  from tutor_details  td , tutor_subject ts  where td.tutor_id= ts.tutor_id   and ts.subject_id = ? and td.country_code = ? ";
                StringBuilder sb = new StringBuilder(sqlQuery);

                /* if (null != locationId) {
                 sb.append(" and td.location_id = ? ");
                 }*/
                System.out.println(" subjectId : " + subjectId + " countryCode : " + countryCode);
                System.out.print("sqlQuery ::::  " + sqlQuery);
                pst = conn.prepareStatement(sb.toString());

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, subjectId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, countryCode);

                /*if (null != locationId) {
                 pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, locationId);
                 } */


                rst = pst.executeQuery();

                while (rst.next()) {
                    listOfSearchTutorIds.add(rst.getString("tutor_id"));
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

        for (String tutorId : listOfSearchTutorIds) {
            listOfTutorSearchResult.add(populateTutorProfileByTutorId(tutorId));
        }

        return listOfTutorSearchResult;
    }

    public boolean checkStudentUserAvailability(String userLoginName) {
        int userCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select count(*) as user_name from student_details where user_login_name = '" + userLoginName + "'";

            System.out.println("check avivlbility methode called");
            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                userCount = rs.getInt("user_name");
            }
            if (userCount > 0) {
                availabilityFlag = false;
            } else {
                availabilityFlag = true;
            }


        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return availabilityFlag;
    }

    /**
     *
     */
    public boolean checkTutorUserAvailability(String userLoginName) {
        int userCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select count(*) as user_name from tutor_details where user_login_name = '" + userLoginName + "'";

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                userCount = rs.getInt("user_name");
            }
            if (userCount > 0) {
                availabilityFlag = false;
            } else {
                availabilityFlag = true;
            }


        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return availabilityFlag;
    }

    public boolean checkJobSeekerUserAvailability(String userLoginName) {
        int userCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select count(*) as user_name from jobseekers_details where user_login_name = '" + userLoginName + "'";

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                userCount = rs.getInt("user_name");
            }
            if (userCount > 0) {
                availabilityFlag = false;
            } else {
                availabilityFlag = true;
            }


        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return availabilityFlag;
    }

    /**
     * InstantTutorRequirements
     *
     * @param countryName
     * @return
     */
    public List<InstantTutorServiceVO> populateInstantTutorService(String countryName, String cityName) {
        List<InstantTutorServiceVO> listOfInstantTutorRequirements = new ArrayList<InstantTutorServiceVO>();

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select tution_requirement_id, contact_person , contact_number, email_id,tution_title,subject_title,class_standard,area_name,tution_posting_date,country_name ,location_name from instant_post_tutor_requirement iptr ,country_name cn ,location_name loc  where   iptr.country_code = cn.country_code and  iptr.location_id = loc.location_id    order by tution_posting_date desc";

            pst = conn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();

            while (rs.next()) {
                InstantTutorServiceVO instantTutorServiceVO = new InstantTutorServiceVO();
                instantTutorServiceVO.setContactPerson(rs.getString("contact_person"));
                instantTutorServiceVO.setContactNumber(rs.getString("contact_number"));
                instantTutorServiceVO.setEmailAddesss(rs.getString("email_id"));
                instantTutorServiceVO.setTutionTitle(rs.getString("tution_title"));
                instantTutorServiceVO.setSubjectTitle(rs.getString("subject_title"));
                instantTutorServiceVO.setClassStandard(rs.getString("class_standard"));
                instantTutorServiceVO.setLocationId(rs.getString("location_name"));
                instantTutorServiceVO.setAreaName(rs.getString("area_name"));
                instantTutorServiceVO.setCountryCode(rs.getString("country_name"));
                String convertDate = convertDate(rs.getString("tution_posting_date"));
                instantTutorServiceVO.setTutionPostingDate(convertDate);
                listOfInstantTutorRequirements.add(instantTutorServiceVO);

            }



        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

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


        return listOfInstantTutorRequirements;

    }

    /**
     *
     * @param countryName
     * @return
     */
    public ResultVO postTutionService(InstantTutorServiceVO instantTutorServiceVO) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ResultVO resultVO = new ResultVO();

        if (null != instantTutorServiceVO) {
            String tutionRequirementId = getAutogeneratedId();
            String contactPerson = instantTutorServiceVO.getContactPerson();
            String contactNumber = instantTutorServiceVO.getContactNumber();
            String emailAddesss = instantTutorServiceVO.getEmailAddesss();
            String tutionTitle = instantTutorServiceVO.getTutionTitle();
            String subjectTitle = instantTutorServiceVO.getSubjectTitle();
            String classStandard = instantTutorServiceVO.getClassStandard();
            String locationId = instantTutorServiceVO.getLocationId();
            String areaName = instantTutorServiceVO.getAreaName();
            String countryCode = instantTutorServiceVO.getCountryCode();


            try {
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String sqlQuery = "insert into instant_post_tutor_requirement (tution_requirement_id,contact_person,contact_number,email_id,tution_title,subject_title,class_standard,location_id,area_name,country_code,tution_posting_date) values(?,?,?,?,?,?,?,?,?,?,curdate())";

                pst = conn.prepareStatement(sqlQuery);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutionRequirementId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, contactPerson);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, contactNumber);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, emailAddesss);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, tutionTitle);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, subjectTitle);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, classStandard);
                pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_8, Integer.parseInt(locationId));
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, areaName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, countryCode);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    resultVO.setValidationMessage("Your tution requirement posted successfully");
                } else {
                    resultVO.setValidationMessage("Posting tution requirement failed..");
                }
            } catch (SQLException sqlExcdeption) {
                sqlExcdeption.printStackTrace();
            } catch (Exception exception) {
                System.out.println("Message : " + exception.getMessage());

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

        return resultVO;

    }

     public ResultVO postAdvertisementService(PostAdvertisementVO postAdvertisementVO) {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ResultVO resultVO = new ResultVO();
        
        System.out.println("entering service method of addver..");
        if (null != postAdvertisementVO) {
            System.out.println("bean is not null..");
            String advertisementId = getAutogeneratedId();
            resultVO.setAdvertisementId(advertisementId);
            String advertiserName = postAdvertisementVO.getAdvertiserName();
            String advertiserContactNumber = postAdvertisementVO.getAdvertiserContactNumber();
            String advertisementEmailAddress = postAdvertisementVO.getAdvertiserEmailAddress();
            String advertiserLocationName = postAdvertisementVO.getAdvertiserLocationName();
            //  String advertiserCountryName = postAdvertisementVO.getAdvertiserCountryName();
            //  String advertiserAddress = postAdvertisementVO.getAdvertiserAddress();
            // String advertisementType = postAdvertisementVO.getAdvertisementType();
            // String advertisementDuration = postAdvertisementVO.getAdvertisementDuration();
            // String advertisementModeOfPayment = postAdvertisementVO.getAdvertisementModeOfPayment();
            //  String advertisementPaymentAmount = postAdvertisementVO.getAdvertisementPaymentAmount();
            String advertisementCategory = postAdvertisementVO.getAdvertisementCategory();
            String advertisementTitle = postAdvertisementVO.getAdvertisementTitle();
            String advertisementCity = postAdvertisementVO.getAdvertisementCity();
            String advertisementDescription = postAdvertisementVO.getAdvertisementDescription();
            boolean imageFlag = postAdvertisementVO.isImageFlag();

            // String advertisementPostingDate = "";
            //String advertisementExpireWarningdate ="";
            //String advertisementExpireDate = "";

            try {
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String sqlQuery = "insert into post_advertisement (adver_id,adver_name,adver_contact_number,adver_email_address,adver_location_name,adver_posting_date,advr_expire_warning_date,advr_expire_date,adver_category,adver_title,adver_city_id,adver_description,image_flag,adver_time) values(?,?,?,?,?,curdate(),curdate(),curdate(),?,?,?,?,?,curtime())";

                pst = conn.prepareStatement(sqlQuery);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, advertisementId);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, advertiserName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, advertiserContactNumber);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, advertisementEmailAddress);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, advertiserLocationName);
                //  pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, advertiserCountryName);
                // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, advertiserAddress);
                // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, advertisementType);
                // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, advertisementDuration);
                // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, advertisementModeOfPayment);
                // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, advertisementPaymentAmount);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, advertisementCategory);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, advertisementTitle);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, advertisementCity);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, advertisementDescription);
                pst.setBoolean(ProfessionalTutorsConstant.PARAMETER_INDEX_10, imageFlag);
                System.out.println("before update...");
                int rowsAffected = pst.executeUpdate();
                System.out.println("Total rows affected.." + rowsAffected);
                if (rowsAffected > 0) {
                     resultVO.setValidationMessage("Your advertisement booking successfully submitted..");
                    String retriveadvertisementId = "select adver_id from post_advertisement where adver_id =?";
                    pst = conn.prepareStatement(retriveadvertisementId);
                    pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, advertisementId);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        resultVO.setAdvertisementId(rs.getString("adver_id"));
                       
                    } else {
                        resultVO.setValidationMessage("Your advertisement booking failed..");
                    }
                } else {
                    System.out.println("failed......");
                }
            } catch (SQLException sqlExcdeption) {
                sqlExcdeption.printStackTrace();
            } catch (Exception exception) {
                System.out.println("Message : " + exception.getMessage());

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

        return resultVO;

    }


    /**
     * public ResultVO postAdvertisementService(PostAdvertisementVO
     * postAdvertisementVO) { ResultVO resultVO = new ResultVO(); Connection
     * conn = null; PreparedStatement pst = null; try { DbConnection
     * dbConnection = new DbConnection(); conn = dbConnection.dbConnect();
     * String sqlQuery = sqlResource.getString("TUTOR_QUERY005");
     * System.out.println("sqlQuery :: " + sqlQuery); pst =
     * conn.prepareStatement(sqlQuery);
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1,
     * postAdvertisementVO.getAdvertiserName());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2,
     * postAdvertisementVO.getAdvertiserContactNumber());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3,
     * postAdvertisementVO.getAdvertiserEmailAddress());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4,
     * postAdvertisementVO.getAdvertiserLocationName());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5,
     * postAdvertisementVO.getAdvertiserCountryName());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6,
     * postAdvertisementVO.getAdvertiserAddress());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7,
     * postAdvertisementVO.getAdvertisementType());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8,
     * postAdvertisementVO.getAdvertisementDuration());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9,
     * postAdvertisementVO.getAdvertisementModeOfPayment());
     * pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10,
     * postAdvertisementVO.getAdvertisementPaymentAmount());
     *
     * int rowsAffected = pst.executeUpdate(); if (rowsAffected > 0) {
     * resultVO.setValidationMessage("Thank You for your Question.We will get
     * back to you immediately"); } else {
     * resultVO.setValidationMessage("adviser question submition failed"); }
     *
     * } catch (Exception e) { e.getMessage();
     *
     * } finally { try { if (null != conn) { conn.close(); }
     *
     * if (null != pst) { pst.close(); }
     *
     * } catch (SQLException sqlException) { } } return resultVO;
    }
     */
    /**
     *
     * @param countryName
     * @return
     */
    public List<TutorRegistrationVO> populateTutorList(String countryName) {
        List<TutorRegistrationVO> listOfSubjectWiseTutor = new ArrayList<TutorRegistrationVO>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        if (null != countryName) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String sqlQuery = "select * from tutor_details where country_name=?";
                StringBuilder sb = new StringBuilder(sqlQuery);
                pst = conn.prepareStatement(sb.toString());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, countryName);

                rst = pst.executeQuery();
                while (rst.next()) {
                    TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
                    /* Tutor Login Information */
                    tutorRegistrationVO.setTutorId(rst.getString("TUTOR_ID"));
                    tutorRegistrationVO.setTutorName(rst.getString("NAME"));
                    tutorRegistrationVO.setTutorLoginName(rst.getString("USER_LOGIN_NAME"));
                    tutorRegistrationVO.setTutorPassword(rst.getString("PASSWORD"));
                    tutorRegistrationVO.setTutorSecretQuestion(rst.getString("SECRET_QUESTION"));
                    tutorRegistrationVO.setTutorSecretQuestionAnswer(rst.getString("SECRET_QUESTION_ANSWER"));

                    /* Tutor Personal Information */
                    tutorRegistrationVO.setTutorSex(rst.getString("GENDER"));
                    tutorRegistrationVO.setTutorAge(rst.getString("AGE"));
                    tutorRegistrationVO.setTutorCountryLocation(rst.getString("COUNTRY_NAME"));
                    tutorRegistrationVO.setTutorCityLocation(rst.getString("LOCATION_NAME"));
                    tutorRegistrationVO.setTutorAddress(rst.getString("ADDRESS"));
                    tutorRegistrationVO.setContactNumber(rst.getString("CONTACT_NUMBER"));
                    tutorRegistrationVO.setTutorEmailId(rst.getString("EMAIL_ADDRESS"));

                    /* Tutor Educational Information */
                    tutorRegistrationVO.setUgQualifyingDegree(rst.getString("UG_BASIC_GRADUATION_QUALIFICATION"));
                    tutorRegistrationVO.setUgSpecialization(rst.getString("UG_SPECIALIZATION"));
                    tutorRegistrationVO.setUgBoardOrUniversity(rst.getString("UG_BOARD_UNIVERSITY_INSTITUTE"));
                    tutorRegistrationVO.setUgPassoutYear(rst.getString("UG_YEAR_OF_PASSOUT"));

                    tutorRegistrationVO.setPgQualifyingDegree(rst.getString("PG_QUALIFICATION"));
                    tutorRegistrationVO.setPgSpecialization(rst.getString("PG_SPECIALIZATION"));
                    tutorRegistrationVO.setPgBoardOrUniversity(rst.getString("PG_UNIVERSITY_INSTITUTE"));
                    tutorRegistrationVO.setPgPassoutYear(rst.getString("PG_YEAR_OF_PASSOUT"));

                    /* Tutor Tutoring Information */
                    tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("YEARS_OF_TUTORING_EXPERIENCE"));
                    tutorRegistrationVO.setPreferenceToTeaching(rst.getString("PREF_SUBJECT_TO_TEACH"));
                    tutorRegistrationVO.setPreferredTutoringArea(rst.getString("PREFERRED_TUTORING_AREA"));
                    tutorRegistrationVO.setTutorTeachingPatteren(rst.getString("TEACHING_PATTEREN"));
                    tutorRegistrationVO.setTutoringOptions(rst.getString("TUTORING_OPTIONS"));
                    tutorRegistrationVO.setTeachingMedium(rst.getString("TEACHING_MEDIUM"));
                    tutorRegistrationVO.setTeachingLevel(rst.getString("TEACHING_SEGMENT_LEVEL"));
                    tutorRegistrationVO.setFeeExpected(rst.getString("EXPECTED_FEES"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));
                    tutorRegistrationVO.setRegistrationDate(rst.getString("REGISTRATION_DATE"));
                    tutorRegistrationVO.setImageFlag(rst.getBoolean("IMAGE_FLAG"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));

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
        }
        return listOfSubjectWiseTutor;
    }

    public ResultVO postFeedback(FeedbackVO feedbackVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String sqlQuery = sqlResource.getString("TUTOR_QUERY003");
            pst = conn.prepareStatement(sqlQuery);

            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, feedbackVO.getPersonName());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, feedbackVO.getEmailAddress());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, feedbackVO.getComments());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                resultVO.setValidationMessage("Thank You for your feedback . Your feedback is valuable for us.");
            } else {
                resultVO.setValidationMessage("Feedback Submition failed");
            }

        } catch (Exception e) {
            e.getMessage();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO tutorTeachingArena(List<TutorTeachingArenaVO> listOfTeachingArena) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            conn.setAutoCommit(false);

            //  String sqlQuery = sqlResource.getString("TUTOR_QUERY003");
            String sqlQuery = "insert into tutor_teaching_arena (tutor_id,education_segment_id,tutor_teaching_subjects,tutor_teaching_board,tutor_teaching_medium) values (?,?,?,?,?)";
            pst = conn.prepareStatement(sqlQuery);

            for (TutorTeachingArenaVO tutorTeachingArenaVO : listOfTeachingArena) {

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, tutorTeachingArenaVO.getTutorId());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, tutorTeachingArenaVO.getTeachingClassLevel());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, tutorTeachingArenaVO.getTeachingSubjects());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, tutorTeachingArenaVO.getTeachingBoard());
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, tutorTeachingArenaVO.getTeachingMedium());
                pst.addBatch();
            }
            int[] rowsAffected = pst.executeBatch();


            if (rowsAffected.length > 0) {
                resultVO.setValidationMessage("Teaching class & subjects inserted");
            } else {
                resultVO.setValidationMessage("Teaching class & subjects Submition failed");
            }

        } catch (Exception e) {
            e.getMessage();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    /**
     * *
     *
     * @param feedbackVO
     * @return
     */
    public ResultVO postAssistance(AssistanceVO assistanceVO) {
        ResultVO resultVO = new ResultVO();
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String sqlQuery = sqlResource.getString("TUTOR_QUERY004");
            System.out.println("sqlQuery  :: " + sqlQuery);
            pst = conn.prepareStatement(sqlQuery);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, assistanceVO.getPersonName());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, assistanceVO.getContactNumber());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, assistanceVO.getEmailAddress());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_4, assistanceVO.getLocationName());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, assistanceVO.getCountryName());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, assistanceVO.getAddress());
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, assistanceVO.getDescription());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                resultVO.setValidationMessage("Thank You for your Question.We will get back to you immediately");
            } else {
                resultVO.setValidationMessage("Assiatance question submition failed");
            }

        } catch (Exception e) {
            e.getMessage();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    /**
     *
     * @return
     */
    public String getAutogeneratedId() {
        String autoGeneratedId = null;

        /**
         * Minimum length for a decent password
         */
        /**
         * The random number generator.
         */
        java.util.Random r = new java.util.Random();

        char[] goodChar = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
            'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int[] goodInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(goodChar[r.nextInt(goodChar.length)]);
        }
        for (int j = 1; j < 6; j++) {
            sb.append(goodInt[r.nextInt(j)]);
        }
        autoGeneratedId = sb.toString();
        System.out.println(" autoGeneratedId  :--> " + autoGeneratedId);
        return autoGeneratedId;
    }

    public List<TutorsInIndiaVO> populateTutorsInIndia(String countryCode) {
        List<TutorsInIndiaVO> listOfTutorsIndia = new ArrayList<TutorsInIndiaVO>();


        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        if (null != countryCode) {

            try {
                String sqlQuery001 = "select location_id from location_name";
                String sqlQuery = "select loc.location_id, loc.location_name , COUNT(*) AS tutors_count FROM tutor_details td , location_name loc,tutor_teaching_patteren ttp WHERE td.location_id = loc.location_id AND td.`TUTOR_ID`=ttp.`TUTOR_ID` AND  ttp.`TEACHING_PATTEREN_ID`=1 AND loc.location_id =?";
                List<Integer> listOfLocationIds = new ArrayList<Integer>();
                conn = DbConnectionPool.dbConnectOne();
                preparedStatement = conn.prepareStatement(sqlQuery001);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listOfLocationIds.add(resultSet.getInt("location_id"));
                }

                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                list.add(10);
                list.add(11);
                list.add(16);
                list.add(75);
                list.add(94);
                list.add(127);
                list.add(142);

                list.add(407);
                list.add(429);
                list.add(479);
                list.add(485);
                list.add(528);
                list.add(665);
                list.add(660);
                list.add(431);
                list.add(401);
                list.add(350);
                list.add(458);

                for (Integer locationId : listOfLocationIds) {
                    preparedStatement = conn.prepareStatement(sqlQuery);
                    preparedStatement.setInt(1, locationId);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        TutorsInIndiaVO tutorsInIndiaVO = new TutorsInIndiaVO();
                        tutorsInIndiaVO.setLocationId(resultSet.getInt("location_id"));
                        tutorsInIndiaVO.setLocationName(resultSet.getString("location_name"));
                        tutorsInIndiaVO.setTutorCount(resultSet.getInt("tutors_count"));
                        for (Integer i : list) {
                            if (i.toString().equals(String.valueOf(resultSet.getInt("location_id")))) {

                                listOfTutorsIndia.add(tutorsInIndiaVO);

                            }

                        }
                    }
                }

            } catch (Exception exception) {
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != preparedStatement) {
                        preparedStatement.close();
                    }

                    if (null != resultSet) {
                        resultSet.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        }
        return listOfTutorsIndia;
    }

    /*
     * created by chiranjit
     */
    public List<TutorSubjectVO> populateSubjectInIndia(String countryCode) {
        List<TutorSubjectVO> listofSubjectIndia = new ArrayList<TutorSubjectVO>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (null != countryCode) {
            try {
                String query = "select subject_id from subject";
                String query1 = "select sub.subject_id,s.subject_name,count(*)as tutors_count from tutor_details td , tutor_subject sub,subject s,tutor_teaching_patteren ttp where td.`TUTOR_ID`=ttp.`TUTOR_ID` AND  ttp.`TEACHING_PATTEREN_ID`=1 AND td.tutor_id = sub.tutor_id AND sub.subject_id=s.subject_id AND s.subject_id =?";
                System.out.println("sqlQuery1====" + query);
                System.out.println("sqlQuery2====" + query1);
                List<Integer> listOfSubjectIds = new ArrayList<Integer>();
                conn = DbConnectionPool.dbConnectOne();
                preparedStatement = conn.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    listOfSubjectIds.add(resultSet.getInt("subject_id"));
                }

                List<Integer> list = new ArrayList<Integer>();
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(6);
                list.add(7);
                list.add(8);
                list.add(9);
                list.add(10);
                list.add(11);
                list.add(12);
                list.add(13);
                list.add(14);
                list.add(15);
                list.add(32);
                list.add(31);
                list.add(33);
                list.add(34);

                for (Integer subjectId : listOfSubjectIds) {

                    System.out.println("model===" + subjectId);

                    preparedStatement = conn.prepareStatement(query1);
                    preparedStatement.setInt(1, subjectId);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {
                        TutorSubjectVO tutorSubjectVO = new TutorSubjectVO();
                        tutorSubjectVO.setSubjectId(resultSet.getString("subject_id"));
                        tutorSubjectVO.setSubjectname(resultSet.getString("subject_name"));
                        tutorSubjectVO.setTutorCount(resultSet.getInt("tutors_count"));

                        for (Integer i : list) {
                            if (i.toString().equals(String.valueOf(resultSet.getInt("subject_id")))) {

                                listofSubjectIndia.add(tutorSubjectVO);

                            }

                        }
                    }


                }


            } catch (Exception E) {
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != preparedStatement) {
                        preparedStatement.close();
                    }

                    if (null != resultSet) {
                        resultSet.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        }
        return listofSubjectIndia;

    }

    public List<TutorialCenterVo> populateTutorialCenterIndia(String countryCode) {
        List<TutorialCenterVo> listOfTutorialCenter = new ArrayList<TutorialCenterVo>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (null != countryCode) {

            try {
                String sqlQuery001 = "select location_id from location_name";
                String sqlQuery = "select loc.location_id, loc.location_name , count(*) as tutorial_Center_count from tutorial_center td , location_name loc where td.institute_location_id = loc.location_id and loc.location_id =?";
                List<Integer> listOfLocationIds = new ArrayList<Integer>();
                conn = DbConnectionPool.dbConnectOne();
                preparedStatement = conn.prepareStatement(sqlQuery001);

                resultSet = preparedStatement.executeQuery();
                System.out.println("instituteId biku====");
                while (resultSet.next()) {
                    listOfLocationIds.add(resultSet.getInt("location_id"));
                    //System.out.println("instituteId====" + resultSet.getString("institute_id"));
                }

                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                list.add(10);
                list.add(75);
                list.add(94);
                list.add(127);
                list.add(142);

                list.add(407);
                list.add(429);
                list.add(479);
                list.add(485);
                list.add(528);
                list.add(665);
                list.add(660);
                list.add(431);
                list.add(401);
                list.add(350);
                list.add(458);


                for (Integer locationId : listOfLocationIds) {

                    preparedStatement = conn.prepareStatement(sqlQuery);
                    preparedStatement.setInt(1, locationId);
                    resultSet = preparedStatement.executeQuery();


                    while (resultSet.next()) {


                        TutorialCenterVo tutorialCenterVo = new TutorialCenterVo();
                        tutorialCenterVo.setLocationId(resultSet.getInt("location_id"));
                        tutorialCenterVo.setLocationName(resultSet.getString("location_name"));
                        tutorialCenterVo.setTutorialCenterCount(resultSet.getInt("tutorial_Center_count"));

                        for (Integer i : list) {
                            if (i.toString().equals(String.valueOf(resultSet.getInt("location_id")))) {


                                listOfTutorialCenter.add(tutorialCenterVo);

                            }

                        }
                    }

                }
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                try {
                    if (null != conn) {
                        conn.close();
                    }

                    if (null != preparedStatement) {
                        preparedStatement.close();
                    }

                    if (null != resultSet) {
                        resultSet.close();
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }

            }
        }
        return listOfTutorialCenter;
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

    public TutorRegistrationVO viewForEditTutoringProcedureDetailsService(String tutorId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        try {
            if (null != tutorId) {
                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                String query = "SELECT `YEARS_OF_TUTORING_EXPERIENCE`,`PREFERRED_TUTORING_AREA`,`EXPECTED_FEES`,`TUTORING_EXPERIENCE`,`LOCATION_ID` FROM `tutor_details` WHERE tutor_id=?";
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    tutorRegistrationVO.setTutorYearsOfExperience(rst.getString("YEARS_OF_TUTORING_EXPERIENCE"));
                    tutorRegistrationVO.setPreferredTutoringArea(rst.getString("PREFERRED_TUTORING_AREA"));
                    tutorRegistrationVO.setFeeExpected(rst.getString("EXPECTED_FEES"));
                    tutorRegistrationVO.setTutoringExperience(rst.getString("TUTORING_EXPERIENCE"));
                    tutorRegistrationVO.setTutorCityLocation(rst.getString("LOCATION_ID"));

                }
//             System.out.println("tutorIddddddddddddd==================="+tutorId);
                String querytwo = "SELECT `subject_id` FROM `tutor_subject` WHERE `tutor_id`=?";
                pstmt = conn.prepareStatement(querytwo);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingSubject = new StringBuilder();
                while (rst.next()) {
                    strTeachingSubject.append(rst.getString("subject_id"));
                    strTeachingSubject.append(",");
                }
                if (!"".equalsIgnoreCase(strTeachingSubject.toString()) && null != strTeachingSubject.toString()) {
                    tutorRegistrationVO.setMainsubject(strTeachingSubject.toString().substring(0, strTeachingSubject.length() - 1));
                }

//            while(rst.next()){
//                tutorRegistrationVO.setMainsubject(rst.getString("subject_id"));
//            }

                String querythree = "SELECT `MEDIUM_ID` FROM `tutor_medium` WHERE tutor_id=?";
                pstmt = conn.prepareStatement(querythree);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingMedium = new StringBuilder();
                while (rst.next()) {
                    strTeachingMedium.append(rst.getString("MEDIUM_ID"));
                    strTeachingMedium.append(",");
                }
                if (!"".equalsIgnoreCase(strTeachingMedium.toString()) && null != strTeachingMedium.toString()) {
                    tutorRegistrationVO.setTeachingMedium(strTeachingMedium.toString().substring(0, strTeachingMedium.length() - 1));
                }


//            while(rst.next()){
//                tutorRegistrationVO.setTeachingMedium(rst.getString("MEDIUM_ID"));
//            }

                String sqlfour = "SELECT `EDUCATION_SEGMENT_ID` FROM `tutor_teaching_segment` WHERE tutor_id=?";
                pstmt = conn.prepareStatement(sqlfour);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingLevel = new StringBuilder();
                while (rst.next()) {
                    strTeachingLevel.append(rst.getString("EDUCATION_SEGMENT_ID"));
                    strTeachingLevel.append(",");
                }
                if (!"".equalsIgnoreCase(strTeachingLevel.toString()) && null != strTeachingLevel.toString()) {
                    tutorRegistrationVO.setTeachingLevel(strTeachingLevel.toString().substring(0, strTeachingLevel.length() - 1));
                }



//            while(rst.next()){
//                tutorRegistrationVO.setTutorTeachingLevel(rst.getString("EDUCATION_SEGMENT_ID"));
//            }

                String sqlfive = "SELECT `TEACHING_PATTEREN_ID` FROM `tutor_teaching_patteren` WHERE tutor_id=?";
                pstmt = conn.prepareStatement(sqlfive);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();

                StringBuilder strTeachingPatten = new StringBuilder();
                while (rst.next()) {
                    strTeachingPatten.append(rst.getString("TEACHING_PATTEREN_ID"));
                    strTeachingPatten.append(",");
                }
                if (!"".equalsIgnoreCase(strTeachingPatten.toString()) && null != strTeachingPatten.toString()) {
                    tutorRegistrationVO.setTutorTeachingParten(strTeachingPatten.toString().substring(0, strTeachingPatten.length() - 1));
                }
//            while(rst.next()){
//                tutorRegistrationVO.setTutorTeachingParten(rst.getString("TEACHING_PATTEREN_ID"));
//                
//            }

                String sqlsix = "SELECT `TEACHING_OPTION_ID` FROM `tutor_teaching_option` WHERE `tutor_id`=?";
                pstmt = conn.prepareStatement(sqlsix);
                pstmt.setString(1, tutorId);
                rst = pstmt.executeQuery();
                StringBuilder strTeachingOption = new StringBuilder();
                while (rst.next()) {
                    strTeachingOption.append(rst.getString("TEACHING_OPTION_ID"));
                    strTeachingOption.append(",");
                }
                if (!"".equalsIgnoreCase(strTeachingOption.toString()) && null != strTeachingOption.toString()) {
                    tutorRegistrationVO.setTutorTeachingOption(strTeachingOption.toString().substring(0, strTeachingOption.length() - 1));
                }
//            while(rst.next()){
//                tutorRegistrationVO.setTutorTeachingOption(rst.getString("TEACHING_OPTION_ID"));
//            }
            }
        } catch (SQLException exception) {
        }
        return tutorRegistrationVO;
    }

    public ResultVO updateTutorTutoringProcedure(TutorRegistrationVO tutorRegistrationVO) throws ProfessionalTutorsException, Exception {

        Connection conn = null;
        PreparedStatement pst = null;
        Statement stmt = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Tutor Login Information  */
            String tutorId = tutorRegistrationVO.getTutorId();
            String tutorName = tutorRegistrationVO.getTutorName();
            resultVO.setUserCallName(tutorName);
            System.out.println(" Starting tutorId :: " + tutorId);
            /* Tutoring Procedure Details */

            String tutoringExperience = tutorRegistrationVO.getTutoringExperience();
            String[] preferenceToTeachingList = tutorRegistrationVO.getPreferenceToTeachingList();
            String otherPreferenceToTeaching = tutorRegistrationVO.getOtherPreferenceToTeaching();

            String[] teachingPatterenList = tutorRegistrationVO.getTeachingPatterenList();
            String otherTeachingPatteren = tutorRegistrationVO.getOtherTutorTeachingPatteren();

            String[] tutoringOptionList = tutorRegistrationVO.getTutoringOptionList();
            String otherTutoringOption = tutorRegistrationVO.getOtherTutoringOptions();

            String[] teachingMediumList = tutorRegistrationVO.getTeachingMediumLis();
            String otherTeachingMedium = tutorRegistrationVO.getOtherTeachingMedium();

            String[] teachingLevelList = tutorRegistrationVO.getTeachingLevelList();
            String otherTeachingLevel = tutorRegistrationVO.getOtherTeachingLevel();

            String tutorYearsOfExperience = tutorRegistrationVO.getTutorYearsOfExperience();
            String preferredTutoringArea = tutorRegistrationVO.getPreferredTutoringArea();

            String feeExpected = tutorRegistrationVO.getFeeExpected();

            //delete tutor_subject data for tutor
            String deletPrefToTeaching = "DELETE FROM tutor_subject WHERE tutor_id ='" + tutorId + "'";
            System.out.println("dddddddddddddddddddddd=" + deletPrefToTeaching);
            stmt = conn.createStatement();
            int rowAffected = stmt.executeUpdate(deletPrefToTeaching);
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$=" + rowAffected);

            //delete tutor_subject data for tutor
            String deletTeachingPatten = "DELETE FROM tutor_teaching_patteren WHERE tutor_id ='" + tutorId + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(deletTeachingPatten);

            //delete tutor_subject data for tutor
            String deletTutoringOption = "DELETE FROM tutor_teaching_option WHERE tutor_id ='" + tutorId + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(deletTutoringOption);

            //delete tutor_subject data for tutor
            String deletTeachingMedium = "DELETE FROM tutor_medium WHERE tutor_id ='" + tutorId + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(deletTeachingMedium);

            //delete tutor_subject data for tutor
            String deletTutorTeachingLevel = "DELETE FROM tutor_teaching_segment WHERE tutor_id ='" + tutorId + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(deletTutorTeachingLevel);

            String updateTutorDetailsSql = "update tutor_details set years_of_tutoring_experience = '" + tutorYearsOfExperience + "',preferred_tutoring_area ='" + preferredTutoringArea + "' , expected_fees = '" + feeExpected + "',tutoring_experience ='" + tutoringExperience + "' where tutor_id ='" + tutorId + "'";
            System.out.println(" updateTutorDetailsSql :" + updateTutorDetailsSql);

            //conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.addBatch(updateTutorDetailsSql);


            //conn.commit();

            if (null != preferenceToTeachingList) {
                for (int i = 0; i < preferenceToTeachingList.length; i++) {
                    if (!"".equalsIgnoreCase(preferenceToTeachingList[i]) && null != preferenceToTeachingList[i]) {

                        String prefToTeaching = "insert into tutor_subject(tutor_id,subject_id,other_subject_name) values ('" + tutorId + "'," + preferenceToTeachingList[i] + ",'" + otherPreferenceToTeaching + "')";
                        System.out.println("prefToTeaching : " + prefToTeaching);
                        stmt.addBatch(prefToTeaching);
                    }

                }
            }

            //conn.commit();
            if (null != teachingPatterenList) {
                for (int j = 0; j < teachingPatterenList.length; j++) {
                    if (!"".equalsIgnoreCase(teachingPatterenList[j]) && null != teachingPatterenList[j]) {
                        String teachingPatteren = "insert into tutor_teaching_patteren(tutor_id,teaching_patteren_id,other_teaching_patteren_name) values('" + tutorId + "'," + teachingPatterenList[j] + ",'" + otherTeachingPatteren + "')";
                        System.out.println("teachingPatteren : " + teachingPatteren);
                        stmt.addBatch(teachingPatteren);
                    }
                }
            }

            //conn.commit();
            if (null != tutoringOptionList) {
                for (int k = 0; k < tutoringOptionList.length; k++) {
                    if (!"".equalsIgnoreCase(tutoringOptionList[k]) && null != tutoringOptionList[k]) {
                        String tutoringOptions = "insert into tutor_teaching_option (tutor_id,teaching_option_id,other_teaching_option_name) values ('" + tutorId + "'," + tutoringOptionList[k] + ",'" + otherTutoringOption + "')";
                        System.out.println("tutoringOptions : " + tutoringOptions);
                        stmt.addBatch(tutoringOptions);
                    }
                }
            }

            //conn.commit();
            if (null != teachingMediumList) {
                for (int l = 0; l < teachingMediumList.length; l++) {
                    if (!"".equalsIgnoreCase(teachingMediumList[l]) && null != teachingMediumList[l]) {
                        String teachingMedium = "insert into tutor_medium (tutor_id,medium_id,other_medium_name) values ('" + tutorId + "'," + teachingMediumList[l] + ",'" + otherTeachingMedium + "')";
                        System.out.print("teachingMedium :: " + teachingMedium);
                        stmt.addBatch(teachingMedium);
                    }
                }
            }

            //conn.commit();
            if (null != teachingLevelList) {
                for (int m = 0; m < teachingLevelList.length; m++) {
                    if (!"".equalsIgnoreCase(teachingLevelList[m]) && null != teachingLevelList[m]) {
                        String teachingLevel = "insert into tutor_teaching_segment (tutor_id,education_segment_id,other_teaching_segment_name) values ('" + tutorId + "'," + teachingLevelList[m] + ",'" + otherTeachingLevel + "')";
                        System.out.print("teachingLevel :: " + teachingLevel);
                        stmt.addBatch(teachingLevel);
                    }
                }
            }

            int[] updatedRows = stmt.executeBatch();
            //conn.commit();

            if (updatedRows.length > 0) {
                System.out.println(" Tutor record updated.........................");
            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }

        }/*catch (ProfessionalTutorsException professionalTutorsException) {
         throw professionalTutorsException;
         } catch (SQLException sqlException) {
         sqlException.printStackTrace();
         }*/ catch (Exception exception) {
            exception.printStackTrace();
            System.out.print("Message ::: " + exception.getMessage());
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    stmt.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    public ResultVO registerEmployeeJobs(EmployeeRegistrationVo employeeRegistrationVo) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ResultVO resultVO = new ResultVO();

        try {

            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            /* Employee Login Information  */
            String employeeId = getAutogeneratedId();
            resultVO.setEmployeeId(employeeId);
            String employeeName = employeeRegistrationVo.getName();
            String employeeLoginName = employeeRegistrationVo.getUserLoginName();
            String employeePassword = employeeRegistrationVo.getPassword();
            String securityQuestion = employeeRegistrationVo.getSecretQuestion();
            String securityQuestionAnswer = employeeRegistrationVo.getSecretQuestionAnswer();

            // File uploadInage = employeeRegistrationVo.getUploadImage();  Pending for Enhancement
            /* Employee company details and  Contact Information */
            String gender = employeeRegistrationVo.getGender();
            int age = employeeRegistrationVo.getAge();
            String companyName = employeeRegistrationVo.getCompanyName();
            int companyId = employeeRegistrationVo.getCompanyNameId();
            int industryId = Integer.parseInt(employeeRegistrationVo.getIndustryTypeId());
            String countryCode = employeeRegistrationVo.getCountryCode();
            String locationId = employeeRegistrationVo.getLocationId();
            String ZipCode = employeeRegistrationVo.getPostalCode();
            String state = employeeRegistrationVo.getStateProvince();
            String address = employeeRegistrationVo.getAddress();
            String contactPerson = employeeRegistrationVo.getContactPersonName();
            String contactNumber = employeeRegistrationVo.getContactNumber();
            String emialAddress = employeeRegistrationVo.getEmailAddress();

            String employeeDetailsInsertQuery = "insert into employers_details(employee_Id,name,user_login_name,password,secret_question,secret_question_answer,gender,age,company_name,company_name_id,industry_id,country_code,location_id,postal_code,state_province,address,contact_person_name,contact_number,email_address) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            System.out.println("SqlQuery=" + employeeDetailsInsertQuery);

            pst = conn.prepareStatement(employeeDetailsInsertQuery);
            /*  Login Information and company contact details */
            pst.setString(1, employeeId);
            pst.setString(2, employeeName);
            pst.setString(3, employeeLoginName);
            pst.setString(4, employeePassword);
            pst.setString(5, securityQuestion);
            pst.setString(6, securityQuestionAnswer);
            pst.setString(7, gender);
            pst.setInt(8, age);
            pst.setString(9, companyName);
            pst.setInt(10, companyId);
            pst.setInt(11, industryId);
            pst.setString(12, countryCode);
            pst.setString(13, locationId);
            pst.setString(14, ZipCode);
            pst.setString(15, state);
            pst.setString(16, address);
            pst.setString(17, contactPerson);
            pst.setString(18, contactNumber);
            pst.setString(19, emialAddress);


            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                String retrieveTutorId = "select employee_Id from employers_details where employee_Id =?";
                pst = conn.prepareStatement(retrieveTutorId);
                pst.setString(1, employeeId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    resultVO.setTutorId(rs.getString("employee_Id"));
                    resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));
                } else {
                    resultVO.setValidationMessage("Employers Registration failed. Please inform help desk immediately about it .");
                }

            } else {
                throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmail(employeeName, employeeId, contactNumber, emialAddress, employeeLoginName, employeePassword);

        } catch (ProfessionalTutorsException professionalTutorsException) {
            throw professionalTutorsException;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
                throw sqlException;
            }
        }
        return resultVO;
    }

    public boolean checkEmployersUserAvailability(String userLoginName) {
        int userCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "select count(*) as user_name from employers_details where user_login_name = '" + userLoginName + "'";

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                userCount = rs.getInt("user_name");
            }
            if (userCount > 0) {
                availabilityFlag = false;
            } else {
                availabilityFlag = true;
            }


        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return availabilityFlag;
    }

    public ResultVo employeeValidationService(LoginVO loginVO) throws Exception, ProfessionalTutorsException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        String employeeloginName = null;
        String emoployeePassword = null;
        String user = loginVO.getEmployeeLoginName();
        String password = loginVO.getEmoployeePassword();
        boolean flag = false;
        ResultVo resultVo = null;

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            //String query = "select user_login_name, password from employers_details where user_login_name=?";
            StringBuffer sqlQueryPart = new StringBuffer("select user_login_name, password from employers_details where");

            if (null != user && user.contains("@") && null != password) {
                sqlQueryPart.append(" email_address = '" + user + "'");
                sqlQueryPart.append(" and binary password = '" + password + "'");

            } else if (null != user && !(user).contains("@") && null != password) {
                sqlQueryPart.append(" user_login_name = '" + user + "'");
                sqlQueryPart.append(" and binary password = '" + password + "'");

            }
            
            pst = conn.prepareStatement(sqlQueryPart.toString());
            //pst.setString(1, user);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                employeeloginName = rs.getString("user_login_name");
                emoployeePassword = rs.getString("password");
                flag = true;
            } else {
                resultVo = new ResultVo();
                resultVo.setUserValidationFlag(false);
                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
            }
        } catch (ProfessionalTutorsException pte) {
            throw pte;
        } catch (SQLException sqlException) {
            throw sqlException;
        } catch (Exception exception) {
            throw exception;
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
                throw sqlException;
            }
        }
        if (password.equals(emoployeePassword)) {
            resultVo = new ResultVo();
            resultVo.setUserValidationFlag(true);
            resultVo.setEmployerLoginName(employeeloginName);
            resultVo.setEmployerPassword(emoployeePassword);
            
        } else {
            throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
        }
        return resultVo;

    }

    public EmployeeRegistrationVo populateEmployerProfileByTutorId(String userLoginName) throws Exception, ProfessionalTutorsException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        EmployeeRegistrationVo employerRegistrationVO = new EmployeeRegistrationVo();
        System.out.println("user login name in service model====" + userLoginName);
        if (null != userLoginName) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();
                StringBuffer sqlQueryPart = new StringBuffer("SELECT e.`employee_Id`,e.`name`,e.`user_login_name`,e.`password`,e.`gender`,e.`age`,e.`address`,e.`company_name`,e.`contact_number`,e.`contact_person_name`,e.`secret_question`,e.`secret_question_answer`,e.`email_address`,e.`postal_code`,e.`state_province`,ct.`company_name_type`,it.`industry_name`,cn.`COUNTRY_NAME`,loc.`LOCATION_NAME` FROM `employers_details` e,`company_type` ct,`industry_type` it, `country_name` cn, `location_name` loc WHERE e.`company_name_id`=ct.`company_name_id` AND e.`industry_id`=it.`industry_id`AND e.`country_code`=cn.`COUNTRY_CODE` AND e.`location_id`=loc.`LOCATION_ID` AND `user_login_name`=?");
                pstmt = conn.prepareStatement(sqlQueryPart.toString());
                pstmt.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, userLoginName);
                rst = pstmt.executeQuery();

                while (rst.next()) {
                    /* Tutor Login Information */
                    userLoginName = rst.getString("employee_id");
                    System.out.println("employers Id ::::::::::::::::: -------------------> " + rst.getString("employee_id"));
                    /* Getting Started with Professional Jobs: Employer's login information  */
                    employerRegistrationVO.setEmployeeId(rst.getString("employee_id"));

                    employerRegistrationVO.setUserLoginName(rst.getString("user_login_name"));
                    System.out.println("nnnnnnnme is=" + rst.getString("user_login_name"));
                    employerRegistrationVO.setPassword(rst.getString("password"));
                    //employerRegistrationVO.setSecretQuestion(rst.getString("secret_question"));
                    //employerRegistrationVO.setSecretQuestionAnswer(rst.getString("secret_question_answer"));

                    /* Company Deatils & Contact information  */
                    employerRegistrationVO.setGender(rst.getString("gender"));
                    employerRegistrationVO.setAge(rst.getInt("age"));
                    employerRegistrationVO.setName(rst.getString("name"));
                    employerRegistrationVO.setCompanyName(rst.getString("company_name"));
                    employerRegistrationVO.setCompanyTypeCode(rst.getString("company_name_type"));
                    employerRegistrationVO.setIndustryTypeId(rst.getString("industry_name"));
                    employerRegistrationVO.setCountryCode(rst.getString("COUNTRY_NAME"));
                    employerRegistrationVO.setLocationId(rst.getString("LOCATION_NAME"));
                    employerRegistrationVO.setPostalCode(rst.getString("postal_code"));
                    employerRegistrationVO.setStateProvince(rst.getString("state_province"));
                    employerRegistrationVO.setAddress(rst.getString("address"));
                    employerRegistrationVO.setContactPersonName(rst.getString("contact_person_name"));
                    employerRegistrationVO.setContactNumber(rst.getString("contact_number"));
                    employerRegistrationVO.setEmailAddress(rst.getString("email_address"));


                } // End of While loop
            }// End of Try block.
            catch (SQLException sqlException) {
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
        }
        return employerRegistrationVO;
    }

    public EmployeeRegistrationVo populateEmployersFullProfile(LoginVO loginVO) {
        EmployeeRegistrationVo employerRegistrationVO = new EmployeeRegistrationVo();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        if (null != loginVO) {
            try {

                DbConnection dbConnection = new DbConnection();
                conn = dbConnection.dbConnect();

                String employerUserName = null;
                String employerPassword = null;
                String employerId = null;

                employerUserName = loginVO.getEmployeeLoginName(); // should not use trim() here
                employerPassword = loginVO.getEmployeePassword(); // should not use trim() here
                employerId = loginVO.getEmployeeId(); // should not use trim() here

                String sql = "SELECT e.`employee_Id`,e.`name`,e.`password`,e.`country_code`,e.`location_id`, e.`industry_id`, e.`user_login_name`,e.`password`,e.`gender`,e.`age`,e.`address`,e.`company_name`,e.`company_name_id`, e.`contact_number`,e.`contact_person_name`,e.`secret_question`,e.`secret_question_answer`,e.`email_address`,e.`postal_code`,e.`state_province`,ct.`company_name_type`,it.`industry_name`,cn.`COUNTRY_NAME`,loc.`LOCATION_NAME` FROM `employers_details` e,`company_type` ct,`industry_type` it, `country_name` cn, `location_name` loc WHERE e.`company_name_id`=ct.`company_name_id` AND e.`industry_id`=it.`industry_id`AND e.`country_code`=cn.`COUNTRY_CODE` AND e.`location_id`=loc.`LOCATION_ID` AND `user_login_name`=?";

                System.out.println("sqlQueryPart.toString() :::: " + sql);
                pst = conn.prepareStatement(sql);
                pst.setString(1, employerUserName);
                rst = pst.executeQuery();
                while (rst.next()) {
                    /* Getting Started with Professional Jobs: Employer's login information  */
                    employerRegistrationVO.setEmployeeId(rst.getString("employee_id"));
                    employerRegistrationVO.setName(rst.getString("name"));
                    System.out.println("nameeeeeeeeeeeee service==" + rst.getString("name"));
                    employerRegistrationVO.setPassword(rst.getString("password"));
                    employerRegistrationVO.setCountryCode(rst.getString("country_code"));
                    employerRegistrationVO.setLocationId(rst.getString("location_id"));
                    employerRegistrationVO.setIndustryId(rst.getInt("industry_id"));

                    employerRegistrationVO.setUserLoginName(rst.getString("user_login_name"));
                    System.out.println("nnnnnnnme in serviceeee=" + rst.getString("user_login_name"));

//                    employerRegistrationVO.setPassword(rst.getString("password"));
//                    employerRegistrationVO.setSecretQuestion(rst.getString("secret_question"));
//                    employerRegistrationVO.setSecretQuestionAnswer(rst.getString("secret_question_answer"));

                    /* Company Deatils & Contact information  */

                    employerRegistrationVO.setPassword(rst.getString("password"));
                    employerRegistrationVO.setGender(rst.getString("gender"));
                    System.out.println("service layer gender======" + rst.getString("gender"));
                    employerRegistrationVO.setAge(rst.getInt("age"));
                    employerRegistrationVO.setCompanyName(rst.getString("company_name"));
                    employerRegistrationVO.setCompanyTypeCode(rst.getString("company_name"));
                    System.out.println("companyTYPE=======" + rst.getString("company_name"));
                    employerRegistrationVO.setIndustryTypeId(rst.getString("industry_name"));
                    employerRegistrationVO.setCompanyTypeId(rst.getString("company_name_id"));
                    employerRegistrationVO.setIndustryTypeCode(rst.getString("industry_id"));
                    employerRegistrationVO.setCountryCode(rst.getString("COUNTRY_NAME"));
                    employerRegistrationVO.setLocationId(rst.getString("LOCATION_NAME"));
                    employerRegistrationVO.setEmployerCountryLocation(rst.getString("country_code"));
                    employerRegistrationVO.setEmployerCityLocation(rst.getString("location_id"));

                    employerRegistrationVO.setPostalCode(rst.getString("postal_code"));
                    employerRegistrationVO.setStateProvince(rst.getString("state_province"));
                    employerRegistrationVO.setAddress(rst.getString("address"));
                    employerRegistrationVO.setContactPersonName(rst.getString("contact_person_name"));
                    employerRegistrationVO.setContactNumber(rst.getString("contact_number"));
                    employerRegistrationVO.setEmailAddress(rst.getString("email_address"));



                } // End of While loop
                System.out.println(" ______________________________employers Full Profile ---------------------");

            } catch (SQLException sqlExcdeption) {
                sqlExcdeption.printStackTrace();
            } catch (Exception exception) {
                System.out.println("Message : " + exception.getMessage());

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
        return employerRegistrationVO;
    }

    public ResultVo jobseekerLoginService(JobSeekerVo jobSeekerVo) throws Exception, ProfessionalTutorsException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ResultVo resultVo = null;
        try {
            String dbpass = null;
            String userpass = jobSeekerVo.getJobSeekerPassword();
            String name = jobSeekerVo.getJobSeekerLoginName();
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            //String query = "select PASSWORD from jobseekers_details where USER_LOGIN_NAME=?";
            StringBuffer sqlQueryPart = new StringBuffer("select user_login_name,password from jobseekers_details where");

            if (null != name && name.contains("@") && null != userpass) {
                sqlQueryPart.append(" email_address = '" + name + "'");
                sqlQueryPart.append(" and binary password = '" + userpass + "'");

            } else if (null != name && !(name).contains("@") && null != userpass) {
                sqlQueryPart.append(" user_login_name = '" + name + "'");
                sqlQueryPart.append(" and binary password = '" + userpass + "'");

            }
            System.out.println("bikash sqlQueryPart="+sqlQueryPart.toString());

            pst = conn.prepareStatement(sqlQueryPart.toString());
            //pst.setString(1, name);
            rs = pst.executeQuery();
            String loginName = null;
            if (rs.next()) {
                loginName = rs.getString("user_login_name");
                dbpass = rs.getString("password");
            }
            if (userpass.equals(dbpass)) {
                resultVo = new ResultVo();
                resultVo.setJobSeekerLoginName(loginName);
                resultVo.setUserValidationFlag(true);
            } else {
                resultVo = new ResultVo();
                resultVo.setUserValidationFlag(false);
                System.out.println("bikash in invalid credential...");
                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
            }
        } catch (SQLException exception) {
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
                throw sqlException;
            }
        }
        return resultVo;
    }

    public JobSeekerVo jobseekerViewService(String userLoginName) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("nnnnnnnnnnnnnnaaaaaaaaaaaammmmmme" + userLoginName);
        JobSeekerVo jobSeekerVo = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
//            String viewQuery = "select jd.JOBSEEKER_ID,jd.NAME,jd.USER_LOGIN_NAME,jd.PASSWORD,jd.GENDER,jd.AGE,cn.COUNTRY_NAME,ln.LOCATION_NAME,jd.AREA_NAME,jd.POSTAL_CODE,jd.ADDRESS,jd.CONTACT_NUMBER,jd.EMAIL_ADDRESS from jobseekers_details jd,country_name cn,location_name ln where cn.COUNTRY_CODE=jd.COUNTRY_CODE and ln.LOCATION_ID=jd.LOCATION_ID and USER_LOGIN_NAME=?";
            String viewQuery = "SELECT jd.JOBSEEKER_ID,jd.NAME,jd.USER_LOGIN_NAME,jd.PASSWORD,jd.GENDER,jd.AGE,cn.COUNTRY_NAME,ln.LOCATION_NAME,jd.AREA_NAME,jd.POSTAL_CODE,jd.ADDRESS,jd.CONTACT_NUMBER,jd.EMAIL_ADDRESS,jd.`YEARS_OF_TUTORING_EXPERIENCE`,jd.`SALARY_IN_THOUSAND`,it.industry_name, jd.KEY_SKILLS FROM jobseekers_details jd,country_name cn,location_name LN,industry_type it WHERE cn.COUNTRY_CODE=jd.COUNTRY_CODE AND ln.LOCATION_ID=jd.LOCATION_ID  AND it.`industry_id`=jd.`INDUSTRY_TYPE` AND USER_LOGIN_NAME=?";
            pst = conn.prepareStatement(viewQuery);
            pst.setString(1, userLoginName);
            rs = pst.executeQuery();
            while (rs.next()) {
                jobSeekerVo = new JobSeekerVo();
                jobSeekerVo.setJobSeekerId(rs.getString("JOBSEEKER_ID"));
                System.out.println("iiiiiiiiiiiiddddddddddddddddddddd" + rs.getString("JOBSEEKER_ID"));
                jobSeekerVo.setJobSeekerName(rs.getString("NAME"));
                jobSeekerVo.setJobSeekerLoginName(rs.getString("USER_LOGIN_NAME"));
                jobSeekerVo.setJobSeekerPassword(rs.getString("PASSWORD"));
                jobSeekerVo.setJobSeekerSex(rs.getString("GENDER"));
                jobSeekerVo.setJobSeekerAge(rs.getInt("AGE"));
                jobSeekerVo.setCountryName(rs.getString("COUNTRY_NAME"));
                jobSeekerVo.setLocationName(rs.getString("LOCATION_NAME"));
                jobSeekerVo.setJobSeekerArea(rs.getString("AREA_NAME"));
                jobSeekerVo.setJobSeekerPostalCode(rs.getString("POSTAL_CODE"));
                jobSeekerVo.setJobSeekerAddress(rs.getString("ADDRESS"));
                jobSeekerVo.setJobSeekerContactNumber(rs.getString("CONTACT_NUMBER"));
                jobSeekerVo.setJobSeekerEmailId(rs.getString("EMAIL_ADDRESS"));
                jobSeekerVo.setJobSeekerMonthOfExp(rs.getInt("YEARS_OF_TUTORING_EXPERIENCE"));
                jobSeekerVo.setJobSeekerAnualSalInThousands(rs.getInt("SALARY_IN_THOUSAND"));
                jobSeekerVo.setJobSeekerCurrentIndustryName(rs.getString("industry_name"));
                jobSeekerVo.setJobSeekerKeySkills(rs.getString("KEY_SKILLS"));
            }
        } catch (Exception exception) {
        } finally {
            try {
                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException exception) {
            }
        }
        return jobSeekerVo;
    }

    public String editEmployerDetails(EmployeeRegistrationVo employeeRegistrationVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        String message = null;
        LoginVO loginVO = new LoginVO();
        String employee_Id = loginVO.getEmployeeId();
        try {
            //DbConnection obj = new DbConnection();
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String employeeId = employeeRegistrationVo.getEmployeeId();
            String employeeName = employeeRegistrationVo.getName();
           // String password = employeeRegistrationVo.getPassword();
            String employerLoginUserName = employeeRegistrationVo.getUserLoginName();
            String address = employeeRegistrationVo.getAddress();

            String gender = employeeRegistrationVo.getGender();
            Integer age = employeeRegistrationVo.getAge();

            String contactNumber = employeeRegistrationVo.getContactNumber();
            String emailAddress = employeeRegistrationVo.getEmailAddress();
            String country = employeeRegistrationVo.getCountryCode();
            System.out.println("country code in service===" + country);
            String location = employeeRegistrationVo.getLocationId();
            String companyName = employeeRegistrationVo.getCompanyName();
            String industryType = employeeRegistrationVo.getIndustryTypeId();
            String companyType = employeeRegistrationVo.getCompanyTypeCode();
            String contactPerson = employeeRegistrationVo.getContactPersonName();
            String postalcode = employeeRegistrationVo.getPostalCode();
            String state = employeeRegistrationVo.getStateProvince();
            /* Tutor Contact Information */

            try {
                String sqlQuery = "update employers_details set name=?, user_login_name = ? ,gender=?, age=?, country_code=?,location_id=?,postal_code=?,state_province=?,address=?,company_name=?,company_name_id=?,industry_id=?,contact_person_name=?,contact_number=?,email_address=? where employee_Id=?";

                pst = conn.prepareStatement(sqlQuery);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, employeeName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, employerLoginUserName);
               // pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, password);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, gender);

                pst.setInt(ProfessionalTutorsConstant.PARAMETER_INDEX_4, age);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, country);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, location);

                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, postalcode);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_8, state);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_9, address);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_10, companyName);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_11, companyType);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_12, industryType);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_13, contactPerson);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_14, contactNumber);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_15, emailAddress);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_16, employeeId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    message = "You have successfully updated employer details";
                } else {
                    message = "Sorry .  Please try to registered again";
                }
            } catch (Exception e) {
                System.out.println(" E:--------------> " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception exception) {
            System.out.println("Exception Message : " + exception.getMessage());
            exception.printStackTrace();

        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return message;
    }

    public JobSeekerVo jobseekerViewEditService(String jobSeekersid) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("nnnnnnnnnnnnnnaaaaaaaaaaaammmmmme" + jobSeekersid);
        JobSeekerVo jobSeekerVo = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String viewForEditQuery = "SELECT jd.JOBSEEKER_ID,jd.NAME,jd.USER_LOGIN_NAME,jd.PASSWORD,jd.GENDER,jd.AGE,jd.`COUNTRY_CODE`,jd.`LOCATION_ID`,jd.AREA_NAME,jd.POSTAL_CODE,jd.ADDRESS,jd.CONTACT_NUMBER,jd.EMAIL_ADDRESS,jd.`YEARS_OF_TUTORING_EXPERIENCE`,jd.`SALARY_IN_THOUSAND`,jd.`INDUSTRY_TYPE`, jd.KEY_SKILLS FROM jobseekers_details jd WHERE jd.`JOBSEEKER_ID`=?";
            pst = conn.prepareStatement(viewForEditQuery);
            pst.setString(1, jobSeekersid);
            rs = pst.executeQuery();
            if (rs.next()) {
                jobSeekerVo = new JobSeekerVo();
                jobSeekerVo.setJobSeekerId(rs.getString("JOBSEEKER_ID"));
                System.out.println("jobseeker id in modellllllllll" + rs.getString("JOBSEEKER_ID"));
                jobSeekerVo.setJobSeekerName(rs.getString("NAME"));
                jobSeekerVo.setJobSeekerLoginName(rs.getString("USER_LOGIN_NAME"));
                jobSeekerVo.setJobSeekerPassword(rs.getString("PASSWORD"));
                jobSeekerVo.setJobSeekerSex(rs.getString("GENDER"));
                jobSeekerVo.setJobSeekerAge(rs.getInt("AGE"));
                jobSeekerVo.setJobSeekerCountryLocation(rs.getString("COUNTRY_CODE"));
                jobSeekerVo.setJobSeekerCityLocation(rs.getInt("LOCATION_ID"));
                jobSeekerVo.setJobSeekerArea(rs.getString("AREA_NAME"));
                jobSeekerVo.setJobSeekerPostalCode(rs.getString("POSTAL_CODE"));
                jobSeekerVo.setJobSeekerAddress(rs.getString("ADDRESS"));
                jobSeekerVo.setJobSeekerContactNumber(rs.getString("CONTACT_NUMBER"));
                jobSeekerVo.setJobSeekerEmailId(rs.getString("EMAIL_ADDRESS"));
                jobSeekerVo.setJobSeekerMonthOfExp(rs.getShort("YEARS_OF_TUTORING_EXPERIENCE"));
                jobSeekerVo.setJobSeekerAnualSalInThousands(rs.getInt("SALARY_IN_THOUSAND"));
                jobSeekerVo.setJobSeekerCurrentIndustryType(rs.getInt("INDUSTRY_TYPE"));
                jobSeekerVo.setJobSeekerKeySkills(rs.getString("KEY_SKILLS"));
            }
        } catch (SQLException exception) {
        }
        return jobSeekerVo;
    }

    public ResultVo editForJobSeekersProfileService(JobSeekerVo jobSeekerVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVo resultVo = null;
        int yrexp = jobSeekerVo.getJobSeekerYearsOfExp();
        int monthOfTutorinexp = ((jobSeekerVo.getJobSeekerYearsOfExp() * 12) + jobSeekerVo.getJobSeekerMonthOfExp());
        int totSalary = ((jobSeekerVo.getJobSeekerAnualSalInLacks() * 100) + jobSeekerVo.getJobSeekerAnualSalInThousands());
        int postalCode = Integer.parseInt(jobSeekerVo.getJobSeekerPostalCode());
        long contactNumber = Long.parseLong(jobSeekerVo.getJobSeekerContactNumber());
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updateQuery = "UPDATE jobseekers_details SET NAME=?,GENDER=?,AGE=?,COUNTRY_CODE=?,LOCATION_ID=?,AREA_NAME=?,POSTAL_CODE=?,ADDRESS=?,CONTACT_NUMBER=?,EMAIL_ADDRESS=?,YEARS_OF_TUTORING_EXPERIENCE=?,INDUSTRY_TYPE=?,SALARY_IN_THOUSAND=?,KEY_SKILLS=? WHERE JOBSEEKER_ID=?";
            pst = conn.prepareStatement(updateQuery);
            pst.setString(1, jobSeekerVo.getJobSeekerName());
            pst.setString(2, jobSeekerVo.getJobSeekerSex());
            pst.setInt(3, jobSeekerVo.getJobSeekerAge());
            pst.setString(4, jobSeekerVo.getJobSeekerCountryLocation());
            pst.setInt(5, jobSeekerVo.getJobSeekerCityLocation());
            pst.setString(6, jobSeekerVo.getJobSeekerArea());
            pst.setInt(7, postalCode);
            pst.setString(8, jobSeekerVo.getJobSeekerAddress());
            pst.setLong(9, contactNumber);
            pst.setString(10, jobSeekerVo.getJobSeekerEmailId());
            pst.setInt(11, monthOfTutorinexp);
            pst.setInt(12, jobSeekerVo.getJobSeekerCurrentIndustryType());
            pst.setInt(13, totSalary);
            pst.setString(14, jobSeekerVo.getJobSeekerKeySkills());
            pst.setString(15, jobSeekerVo.getJobSeekerId());
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVo = new ResultVo();
                resultVo.setMsg("Data Updated");
            } else {
                resultVo = new ResultVo();
                resultVo.setMsg("Data Not Update");
            }

        } catch (SQLException exception) {
        }
        return resultVo;
    }

    //Change Password created by ranjit
    public boolean checkStudentPass(StudentRegistrationVO studentRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        String studentId = studentRegistrationVO.getStudentId();
        String stuPass = studentRegistrationVO.getPassword();
        System.out.println("studentId in service===" + studentId);
        System.out.println("stuPass in service===" + stuPass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String checkpass = "SELECT PASSWORD FROM `student_details` WHERE `STUDENT_ID`=?";
            pst = conn.prepareStatement(checkpass);
            pst.setString(1, studentId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dbpass = rs.getString("password");
                if (stuPass.equals(dbpass)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (SQLException exception) {
        }
        return flag;
    }

    public ResultVO updateStudentPassword(StudentRegistrationVO studentRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String studentId = studentRegistrationVO.getStudentId();
        String newpass = studentRegistrationVO.getNewPassword();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updatepass = "UPDATE `student_details` SET PASSWORD=? WHERE `STUDENT_ID`=?";
            pst = conn.prepareStatement(updatepass);
            pst.setString(1, newpass);
            pst.setString(2, studentId);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("password update");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("not update");
            }
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public boolean checkTutorPass(TutorRegistrationVO tutorRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        String tutorId = tutorRegistrationVO.getTutorId();
        String tutorPass = tutorRegistrationVO.getTutorPassword();
        System.out.println("studentId in service===" + tutorId);
        System.out.println("stuPass in service===" + tutorPass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String checkpass = "SELECT PASSWORD FROM `tutor_details` WHERE `tutor_id`=?";
            pst = conn.prepareStatement(checkpass);
            pst.setString(1, tutorId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dbpass = rs.getString("password");
                if (tutorPass.equals(dbpass)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (SQLException exception) {
        }
        return flag;
    }

    public ResultVO updateTutorPassword(TutorRegistrationVO tutorRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String tutorId = tutorRegistrationVO.getTutorId();
        String newpass = tutorRegistrationVO.getNewPassword();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updatepass = "UPDATE `tutor_details` SET PASSWORD=? WHERE `tutor_id`=?";
            pst = conn.prepareStatement(updatepass);
            pst.setString(1, newpass);
            pst.setString(2, tutorId);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("password update");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("not update");
            }
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public boolean checkEmployeePass(EmployeeRegistrationVo employeeRegistrationVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        String employeeId = employeeRegistrationVo.getEmployeeId();
        String stuPass = employeeRegistrationVo.getPassword();
        System.out.println("studentId in service===" + employeeId);
        System.out.println("stuPass in service===" + stuPass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String checkpass = "SELECT PASSWORD FROM `employers_details` WHERE `employee_Id`=?";
            pst = conn.prepareStatement(checkpass);
            pst.setString(1, employeeId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dbpass = rs.getString("password");
                if (stuPass.equals(dbpass)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (SQLException exception) {
        }
        return flag;
    }

    public ResultVO updateEmployeePassword(EmployeeRegistrationVo employeeRegistrationVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String employeeId = employeeRegistrationVo.getEmployeeId();
        String newpass = employeeRegistrationVo.getNewPassword();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updatepass = "UPDATE `employers_details` SET PASSWORD=? WHERE `employee_Id`=?";
            pst = conn.prepareStatement(updatepass);
            pst.setString(1, newpass);
            pst.setString(2, employeeId);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("password update");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("not update");
            }
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public boolean checkTutorialCenterPass(TutorialCenterDataVO tutorialCenterDataVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        String instituteId = tutorialCenterDataVO.getInstituteId();
        String institutePass = tutorialCenterDataVO.getPassword();
        System.out.println("studentId in service===" + instituteId);
        System.out.println("stuPass in service===" + institutePass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String checkpass = "select INSTITUTE_LOGIN_PASSWORD FROM tutorial_center WHERE INSTITUTE_ID=?";
            pst = conn.prepareStatement(checkpass);
            pst.setString(1, instituteId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dbpass = rs.getString("INSTITUTE_LOGIN_PASSWORD");

                if (institutePass.equals(dbpass)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (SQLException exception) {
        }
        return flag;
    }

    public ResultVO updateTutorialCenterPassword(TutorialCenterDataVO tutorialCenterDataVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String instituteId = tutorialCenterDataVO.getInstituteId();
        String newpass = tutorialCenterDataVO.getNewPassword();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updatepass = "UPDATE tutorial_center SET INSTITUTE_LOGIN_PASSWORD=? WHERE INSTITUTE_ID=?";
            pst = conn.prepareStatement(updatepass);
            pst.setString(1, newpass);
            pst.setString(2, instituteId);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("password update");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("not update");
            }
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public boolean checkJobseekerPass(JobSeekerVo jobSeekerVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        String jobseekerId = jobSeekerVo.getJobSeekerId();
        String stuPass = jobSeekerVo.getPassword();
        System.out.println("studentId in service===" + jobseekerId);
        System.out.println("stuPass in service===" + stuPass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String checkpass = "SELECT PASSWORD FROM `jobseekers_details` WHERE `JOBSEEKER_ID`=?";
            pst = conn.prepareStatement(checkpass);
            pst.setString(1, jobseekerId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String dbpass = rs.getString("password");
                if (stuPass.equals(dbpass)) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        } catch (SQLException exception) {
        }
        return flag;
    }

    public ResultVO updateJobseekerPassword(JobSeekerVo jobSeekerVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String jobseekerId = jobSeekerVo.getJobSeekerId();
        String newpass = jobSeekerVo.getNewPassword();
        System.out.println("jobseeker IIIDDDD==" + jobseekerId);
        System.out.println("jobseeker IIIDDDD==" + newpass);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String updatepass = "UPDATE jobseekers_details SET PASSWORD=? WHERE JOBSEEKER_ID=?";
            pst = conn.prepareStatement(updatepass);
            pst.setString(1, newpass);
            pst.setString(2, jobseekerId);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("password update");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("not update");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultVO;
    }

    public ResultVO checkStudentConfirmatin(StudentRegistrationVO studentRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        boolean flag = false;
        String dbUserName = null;
        String dbUserEmail = null;
       // String studentLoginName = studentRegistrationVO.getUserLoginName();
        String studentEmail = studentRegistrationVO.getEmail();
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "SELECT user_login_name, `EMAIL_ADDRESS` FROM `student_details` WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, studentEmail);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dbUserName = rs.getString("user_login_name");
                dbUserEmail = rs.getString("EMAIL_ADDRESS");
            }
            if (studentEmail.equals(dbUserEmail)) {
                flag = true;
                resultVO=new ResultVO();
                resultVO.setUserCallName(dbUserName);
                resultVO.setEmailId(dbUserEmail);
                resultVO.setUserValidationFlag(flag);
            } else {
                resultVO=new ResultVO();
                resultVO.setUserValidationFlag(flag);
            }
        } catch (SQLException exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO changeStudentPassword(StudentRegistrationVO studentRegistrationVO) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String userName = studentRegistrationVO.getUserLoginName();
        System.out.println("userName to change student pass -----"+userName);
        String email = studentRegistrationVO.getEmail();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.getRandomPassword();
        System.out.println("autogenerated  password  in service=====" + password);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "update student_details set PASSWORD=? where EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Your new Password is created Please check your email");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Password Change Fail");
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmailPassword(userName, email, password);
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public ResultVO checkTutorConfirmatin(TutorRegistrationVO tutorRegistrationVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean flag = false;
        String dbUserName = null;
        String dbUserEmail = null;
        ResultVO resultVO=null;
       // String tutorLoginName = tutorRegistrationVO.getTutorLoginName();
        String Email = tutorRegistrationVO.getTutorEmailId();
        System.out.println("Email===" + Email);
      //  System.out.println("tutorLoginName===" + tutorLoginName);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "SELECT  `user_login_name`, `EMAIL_ADDRESS` FROM `tutor_details` WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dbUserName = rs.getString("user_login_name");
                dbUserEmail = rs.getString("EMAIL_ADDRESS");
            }
            if (Email.equals(dbUserEmail)) {
                resultVO=new ResultVO();
                flag=true;
                resultVO.setUserCallName(dbUserName);
                resultVO.setEmailId(dbUserEmail);
            } else {
            resultVO=new ResultVO();
                resultVO.setValidationMessage("false");
            }
             resultVO.setUserValidationFlag(flag);
        } catch (SQLException exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO changeTutorPassword(TutorRegistrationVO tutorRegistrationVO) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String userName = tutorRegistrationVO.getTutorLoginName();
        System.out.println("userName for change turtor name service...."+userName);
        String email = tutorRegistrationVO.getTutorEmailId();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.getRandomPassword();
        System.out.println("autogenerated  password  in service=====" + password);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "UPDATE tutor_details SET PASSWORD=? WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Your new Password is created Please check your email");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Password Change Fail");
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmailPassword(userName, email, password);
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public ResultVO checkTutorialcenterConfirmatin(TutorialCenterDataVO tutorialCenterDataVO) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean flag = false;
        ResultVO resultVO=null;
        String dbUserName = null;
        String dbUserEmail = null;
       // String LoginName = tutorialCenterDataVO.getInstituteLoginName();
        String Email = tutorialCenterDataVO.getInstituteEmail();
        System.out.println("Email===" + Email);
       // System.out.println("tutorLoginName===" + LoginName);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "SELECT  `INSTITUTE_LOGIN_NAME`, `INSTITUTE_EMAIL` FROM `tutorial_center` WHERE INSTITUTE_EMAIL=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dbUserName = rs.getString("INSTITUTE_LOGIN_NAME");
                dbUserEmail = rs.getString("INSTITUTE_EMAIL");
            }
            if (Email.equals(dbUserEmail)) {
                flag = true;
                resultVO=new ResultVO();
                resultVO.setUserCallName(dbUserName);
                resultVO.setEmailId(Email);
                resultVO.setUserValidationFlag(flag);
            } else {
                resultVO=new ResultVO();
            resultVO.setUserValidationFlag(false);
            }
        } catch (SQLException exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO changeTutorialcenterPassword(TutorialCenterDataVO tutorialCenterDataVO) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String userName = tutorialCenterDataVO.getInstituteLoginName();
        System.out.println("userName in change service....."+userName);
        String email = tutorialCenterDataVO.getInstituteEmail();
        System.out.println("email in serviceeeeeeeeeee"+email);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.getRandomPassword();
        System.out.println("autogenerated  password  in service=====" + password);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "UPDATE tutorial_center SET INSTITUTE_LOGIN_PASSWORD=? WHERE INSTITUTE_EMAIL=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Your new Password is created Please check your email");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Password Change Fail");
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmailPassword(userName, email, password);
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public ResultVO checkJobseekersConfirmatin(JobSeekerVo jobSeekerVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean flag = false;
        ResultVO resultVO=null;
        String dbUserName = null;
        String dbUserEmail = null;
      //  String LoginName = jobSeekerVo.getJobSeekerLoginName();
        String Email = jobSeekerVo.getJobSeekerEmailId();
        System.out.println("Email===" + Email);
        //System.out.println("tutorLoginName===" + LoginName);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "SELECT  `user_login_name`, `EMAIL_ADDRESS` FROM `jobseekers_details` WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dbUserName = rs.getString("user_login_name");
                dbUserEmail = rs.getString("EMAIL_ADDRESS");
            }
            if (Email.equals(dbUserEmail)) {
                flag = true;
                resultVO=new ResultVO();
                resultVO.setUserCallName(dbUserName);
                resultVO.setEmailId(dbUserEmail);
                resultVO.setUserValidationFlag(flag);
            } else {
                flag = false;
                resultVO=new ResultVO();
                resultVO.setUserValidationFlag(flag);
            }
        } catch (SQLException exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO changeJobseekersPassword(JobSeekerVo jobSeekerVo) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String userName = jobSeekerVo.getJobSeekerLoginName();
        System.out.println("userName to change for gor pass name---"+userName);
        String email = jobSeekerVo.getJobSeekerEmailId();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.getRandomPassword();
        System.out.println("autogenerated  password  in service=====" + password);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "UPDATE jobseekers_details SET PASSWORD=? WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Your new Password is created Please check your email");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Password Change Fail");
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmailPassword(userName, email, password);
        } catch (SQLException exception) {
        }
        return resultVO;
    }

    public ResultVO checkEmployerConfirmatin(EmployeeRegistrationVo employeeRegistrationVo) {
        Connection conn = null;
        PreparedStatement pst = null;
        boolean flag = false;
        ResultVO resultVO=null;
        String dbUserName = null;
        String dbUserEmail = null;
       // String LoginName = employeeRegistrationVo.getUserLoginName();
        String Email = employeeRegistrationVo.getEmailAddress();
        System.out.println("Email=== in service..........." + Email);
       // System.out.println("tutorLoginName===" + LoginName);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "SELECT  `user_login_name`, `EMAIL_ADDRESS` FROM `employers_details` WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, Email);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dbUserName = rs.getString("user_login_name");
                dbUserEmail = rs.getString("EMAIL_ADDRESS");
            }
            if (Email.equals(dbUserEmail)) {
                flag = true;
                resultVO=new ResultVO();
                resultVO.setUserCallName(dbUserName);
                resultVO.setEmailId(Email);
                resultVO.setUserValidationFlag(flag);
            } else {
                 resultVO=new ResultVO();
                resultVO.setUserValidationFlag(false); 
            }
        } catch (SQLException exception) {
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != pst) {
                    pst.close();
                }

            } catch (SQLException sqlException) {
            }
        }
        return resultVO;
    }

    public ResultVO changeEmployerPassword(EmployeeRegistrationVo employeeRegistrationVo) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = null;
        String userName = employeeRegistrationVo.getUserLoginName();
        System.out.println("userName to forgot pass......"+userName);
        String email = employeeRegistrationVo.getEmailAddress();
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.getRandomPassword();
        System.out.println("autogenerated  password  in service=====" + password);
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();
            String query = "UPDATE employers_details SET PASSWORD=? WHERE EMAIL_ADDRESS=?";
            pst = conn.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);
            int row = pst.executeUpdate();
            if (row > 0) {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Your new Password is created Please check your email");
            } else {
                resultVO = new ResultVO();
                resultVO.setValidationMessage("Password Change Fail");
            }
            MailSend mailSend = new MailSend();
            mailSend.sendEmailPassword(userName, email, password);
        } catch (SQLException exception) {
        }
        return resultVO;
    }
    public boolean checkTutorialCenterAvailability(String userLoginName) {
        int instituteCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "SELECT COUNT(*) AS institute_name FROM tutorial_center WHERE institute_login_name = '"+userLoginName+"';";

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);

            if (rs.next()) {
                instituteCount = rs.getInt("institute_name");
            }
            if (instituteCount > 0) {
                availabilityFlag = false;
            } else {
                availabilityFlag = true;
            }


        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return availabilityFlag;
    }
    
    
    public ArrayList<EducationalCategories> checkEducationCategories() {
        int userCount = 0;
        boolean availabilityFlag = false;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<EducationalCategories> al = new ArrayList<EducationalCategories>();

        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String sqlQuery = "SELECT education_segment_id,education_segment_name FROM education_categories";

            st = conn.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                EducationalCategories e = new EducationalCategories();
                e.setEducation_segment_id(rs.getString("education_segment_id"));
                e.setEducation_segment_name(rs.getString("education_segment_name"));
                al.add(e);

            }



        } catch (SQLException sqlExcdeption) {
            sqlExcdeption.printStackTrace();
        } catch (Exception exception) {
            System.out.println("Message : " + exception.getMessage());

            exception.printStackTrace();
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }

                if (null != st) {
                    st.close();
                }

                if (null != st) {
                    st.close();
                }

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return al;
    }
}
