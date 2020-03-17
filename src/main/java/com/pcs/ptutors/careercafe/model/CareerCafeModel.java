
package com.pcs.ptutors.careercafe.model;

import com.pcs.ptutors.careercafe.vo.CareerCafeQuestionVO;
import com.pcs.ptutors.careercafe.vo.CareerCafeVO;
import com.pcs.ptutors.exception.ProfessionalTutorsException;

import com.pcs.ptutors.model.DbConnection;
import com.pcs.ptutors.vo.ResultVO;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author suvendu
 */
public class CareerCafeModel {

    public ResultVO careerCafeUserValidation(String userName, String password) throws Exception, ProfessionalTutorsException {
        ResultVO resultVO = new ResultVO();
        boolean userValidationFlag = false;
        String userCallName = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rst = null;
        try {
            DbConnection dbConnection = new DbConnection();
            conn = dbConnection.dbConnect();

            String tutorId = null;

            StringBuffer sqlQueryPart = new StringBuffer("select name,member_id from career_cafe where ");

            if (null != userName && userName.contains("@") && null != password) {
                sqlQueryPart.append(" email_address = '" + userName + "'");
                sqlQueryPart.append(" and password = '" + password + "'");

            } else if (null != userName && !(userName.contains("@")) && null != password) {
                sqlQueryPart.append(" user_login_name = '" + userName + "'");
                sqlQueryPart.append(" and password = '" + password + "'");

            }
            System.out.println(" sqlQueryPart :: " + sqlQueryPart);


            pstmt = conn.prepareStatement(sqlQueryPart.toString());
            rst = pstmt.executeQuery();
            if (rst.next()) {
                userCallName = rst.getString("NAME");
                resultVO.setMemberId(rst.getString("member_id"));
                userValidationFlag = true;

            } else {
                userValidationFlag = false;
                throw new ProfessionalTutorsException("DATABASE_ERROR_CODE_001", "Invalid User Credential !!");
            }

            resultVO.setUserValidationFlag(userValidationFlag);

            if (null != userCallName) {
                StringTokenizer st = new StringTokenizer(userCallName, " ");
                while (st.hasMoreTokens()) {
                    userCallName = st.nextToken();
                    break;
                }
                resultVO.setUserCallName(userCallName);
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

    public ResultVO registerCareerCafe(CareerCafeVO careerCafeVO) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ResultVO resultVO = new ResultVO();
        String memberId = null;
        String name;
        String userName;
        name = careerCafeVO.getName();
        userName = careerCafeVO.getUserName();
        String password = careerCafeVO.getPassword();
        String emailId = careerCafeVO.getEmail();
        DbConnection dbConnection = new DbConnection();
        try {
            Connection conn = dbConnection.dbConnect();
            String sqlStr = "insert into career_cafe(name,user_login_name,password,email_address) values('" + name + "','" + userName + "','" + password + "','" + emailId + "')";
            System.out.println(" Test Query : " + sqlStr);
            Statement stmt = conn.createStatement();
            int rowsUpdated = stmt.executeUpdate(sqlStr);
            System.out.println(" rowsUpdated : " + rowsUpdated);
            if (rowsUpdated > 0) {
                System.out.println(" inside if");
                String sqlQuery = "select member_id from career_cafe where email_address =?";
                System.out.println("sqlQuery :  " + sqlQuery);
                pstmt = conn.prepareStatement(sqlQuery);
                pstmt.setString(1, emailId);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    memberId = rs.getString("member_id");
                    System.out.println("memberId--------------------> " + memberId);
                }
                resultVO.setMemberId(memberId);
                resultVO.setReturnFlag(true);
            } else {
                System.out.println(" inside escle...");
                resultVO.setReturnFlag(false);
            }

        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());
            exception.printStackTrace();
        }

        return resultVO;
    }

    public CareerCafeVO populateCareerCafeMemberInfo(String userName,String password) {
     
        CareerCafeVO careerCafeVO =null;
        DbConnection dbConnection = new DbConnection();
        try{
        Connection conn = dbConnection.dbConnect();
        String strSQL = "select * from career cafe where user_login_name ='"+userName+"' and password = '"+password +"'";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            careerCafeVO = new CareerCafeVO();
            careerCafeVO.setName(rs.getString("name"));
            careerCafeVO.setUserName(rs.getString("user_login_name"));
            careerCafeVO.setSecretQuetion(rs.getString("secret_question_id"));
            careerCafeVO.setSecretQuestionAnswer(rs.getString("secret_question_answer"));
            careerCafeVO.setGender(rs.getString("gender"));
            careerCafeVO.setAge(rs.getString("age"));
            careerCafeVO.setCountry(rs.getString("country_code"));
            careerCafeVO.setLocation(rs.getString("location_id"));
            careerCafeVO.setArea(rs.getString("area"));
            careerCafeVO.setPostalCode(rs.getString("postal_code"));
            careerCafeVO.setContactNumber(rs.getString("contact_number"));
            careerCafeVO.setEmail(rs.getString("email_address"));
            careerCafeVO.setRegistrationDate(rs.getString("registration_date"));


        }
        }
        catch(Exception ex){
            System.out.println(" Message : " + ex.getMessage());
            
        }

     
        return careerCafeVO;
    }

    public ResultVO postCareerCafeQuestion(String memberId, String question) {
        PreparedStatement pstmt = null;
        ResultVO resultVO = new ResultVO();


        DbConnection dbConnection = new DbConnection();
        try {
            Connection conn = dbConnection.dbConnect();
            String sqlStr = "insert into career_cafe_question(career_question_posted_by,career_question,career_question_posted_time)values(" + Integer.parseInt(memberId) + ",'" + question + "',now())";
            System.out.println(" Sql Str : " + sqlStr);
            pstmt = conn.prepareStatement(sqlStr);
            // pstmt.setInt(1,Integer.parseInt(memberId));
            //pstmt.setString(2, question);
            int rowsUpdated = pstmt.executeUpdate(sqlStr);
            System.out.println(" rowsUpdated : " + rowsUpdated);
            if (rowsUpdated > 0) {
                resultVO.setReturnFlag(true);
            } else {
                System.out.println(" inside escle...");
                resultVO.setReturnFlag(false);
            }

        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());
            exception.printStackTrace();
        }

        return resultVO;
    }

    public List<CareerCafeQuestionVO> viewCareerCafeQuestions(String memberId) {
        PreparedStatement pstmt = null;
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        CareerCafeQuestionVO careerCafeQuestionVO = null;

        List<CareerCafeQuestionVO> careerCafeQuestionList = new ArrayList<CareerCafeQuestionVO>();
        DbConnection dbConnection = new DbConnection();
        try {
            Connection conn = dbConnection.dbConnect();
            String sqlStr = "select career_question_posted_by, career_question_id,career_question ,date_format(career_question_posted_time, '%M %d %Y %r') as posted_time from  career_cafe_question where career_question_posted_by =" + memberId;
            System.out.println(" Sql Str : " + sqlStr);
            pstmt = conn.prepareStatement(sqlStr);
            // pstmt.setInt(1,Integer.parseInt(memberId));
            //pstmt.setString(2, question);
            rs = pstmt.executeQuery(sqlStr);
            while (rs.next()) {
                careerCafeQuestionVO = new CareerCafeQuestionVO();
                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_posted_by"));
                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_id"));
                careerCafeQuestionVO.setCareerQuestion(rs.getString("career_question"));
                careerCafeQuestionVO.setCareerQuestionPostedTime(rs.getString("posted_time"));
                careerCafeQuestionList.add(careerCafeQuestionVO);
            }

        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());
            exception.printStackTrace();
        }

        return careerCafeQuestionList;
    }

    public List<CareerCafeQuestionVO> viewCareerCafeMemberQuestionsAndAnswer(String memberId) {
        PreparedStatement pstmt = null;
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        CareerCafeQuestionVO careerCafeQuestionVO = null;

        List<CareerCafeQuestionVO> careerCafeQuestionList = new ArrayList<CareerCafeQuestionVO>();
        DbConnection dbConnection = new DbConnection();
        try {
            Connection conn = dbConnection.dbConnect();
            String sqlStr = "select ccq.career_question_posted_by, ccq.career_question_id,ccq.career_question ,cqa.career_question_answer ,date_format(cqa.career_question_replied_time, '%M %d %Y %r') as replied_time from  career_cafe_question ccq left outer join career_question_answers cqa on ccq.career_question_id =  cqa.career_question_id where ccq.career_question_posted_by =" + memberId;
            System.out.println(" Sql Str : " + sqlStr);
            pstmt = conn.prepareStatement(sqlStr);
            // pstmt.setInt(1,Integer.parseInt(memberId));
            //pstmt.setString(2, question);
            rs = pstmt.executeQuery(sqlStr);
            while (rs.next()) {
                careerCafeQuestionVO = new CareerCafeQuestionVO();
                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_posted_by"));
                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_id"));
                careerCafeQuestionVO.setCareerQuestion(rs.getString("career_question"));
                careerCafeQuestionVO.setCareerQuestionAnswer(rs.getString("career_question_answer"));
                careerCafeQuestionVO.setCareerQuestionRepliedTime(rs.getString("replied_time"));

                careerCafeQuestionList.add(careerCafeQuestionVO);
            }


        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());
            exception.printStackTrace();
        }

        return careerCafeQuestionList;
    }

    public List<CareerCafeQuestionVO> viewCareerCafeGeneralQuestionsAndAnswer() {
        PreparedStatement pstmt = null;
        ResultVO resultVO = new ResultVO();
        ResultSet rs = null;
        CareerCafeQuestionVO careerCafeQuestionVO = null;

        List<CareerCafeQuestionVO> careerCafeQuestionList = new ArrayList<CareerCafeQuestionVO>();
        DbConnection dbConnection = new DbConnection();
        try {
            Connection conn = dbConnection.dbConnect();
            String sqlStr = "select ccq.career_question_id,ccq.career_question,ccq.career_question_posted_by,cqa.career_question_replied_by,cqa.career_question_answer,date_format(ccq.career_question_posted_time, '%M %d %Y %r') as posted_time,date_format(cqa.career_question_replied_time, '%M %d %Y %r') as replied_time from  career_cafe_question ccq left outer join career_question_answers cqa on ccq.career_question_id =  cqa.career_question_id";
            System.out.println(" Sql Str : " + sqlStr);
            pstmt = conn.prepareStatement(sqlStr);
            // pstmt.setInt(1,Integer.parseInt(memberId));
            //pstmt.setString(2, question);
            rs = pstmt.executeQuery(sqlStr);
            while (rs.next()) {
                careerCafeQuestionVO = new CareerCafeQuestionVO();



                careerCafeQuestionVO.setCareerQuestionId(rs.getString("career_question_id"));
                careerCafeQuestionVO.setCareerQuestion(rs.getString("career_question"));
                careerCafeQuestionVO.setCareerQuestionAnswer(rs.getString("career_question_answer"));
                careerCafeQuestionVO.setCareerQuestionPostedTime(rs.getString("posted_time"));
                careerCafeQuestionVO.setCareerQuestionRepliedTime(rs.getString("replied_time"));

                String postedBy = rs.getString("career_question_posted_by");
                String repliedBy = rs.getString("career_question_replied_by");

                String sqlPostedBy = "select name from career_cafe where member_id =" + postedBy;
                pstmt = conn.prepareStatement(sqlPostedBy);
                ResultSet postedRs = pstmt.executeQuery();
                if (postedRs.next()) {
                    careerCafeQuestionVO.setCareerQuestionPostedBy(postedRs.getString("name"));
                }

                String sqlRepliedBy = "select name from career_cafe where member_id = " + repliedBy;
                pstmt = conn.prepareStatement(sqlRepliedBy);
                ResultSet repliedRs = pstmt.executeQuery();
                if (repliedRs.next()) {
                    careerCafeQuestionVO.setCareerQuestionRepliedBy(repliedRs.getString("name"));
                }


                careerCafeQuestionList.add(careerCafeQuestionVO);
            }


        } catch (Exception exception) {
            System.out.println(" Message : " + exception.getMessage());
            exception.printStackTrace();
        }

        return careerCafeQuestionList;
    }
}
