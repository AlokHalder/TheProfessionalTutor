/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.model;

import com.pcs.ptutors.vo.EmployeeRegistrationVo;
import com.pcs.ptutors.exception.ProfessionalTutorsException;
import com.pcs.ptutors.constant.ProfessionalTutorsConstant;
import com.pcs.ptutors.util.EmailService;
import com.pcs.ptutors.util.GodaddyEmailService;
import com.pcs.ptutors.util.RegistrationDateCalculation;
import com.pcs.ptutors.vo.MembershipSubscriptionVO;
import com.pcs.ptutors.vo.ResultVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author ibm
 */
public class MemberShipPaymentModel {

    private static final String propdest = "com.tutors.properties.validation";
    private static ResourceBundle resource = ResourceBundle.getBundle(propdest);

    /**
     *
     * @param membershipSubscriptionVO
     * @return
     * @throws ProfessionalTutorsException
     * @throws Exception
     */
    public TutorRegistrationVO tutorMembershipPayment(MembershipSubscriptionVO membershipSubscriptionVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        // ResultVO resultVO = new ResultVO();

        try {
            DbConnection obj = new DbConnection();
            conn = obj.dbConnect();
            if (null != conn) {
                /* Tutor Login Information  */
                String tutorId = membershipSubscriptionVO.getUserId();
                String userLoginName = membershipSubscriptionVO.getUserLoginName();
                String password = membershipSubscriptionVO.getPassword();
                String emailAddress = membershipSubscriptionVO.getEmailAddress();

                String membershipCategory ="Free";
                System.out.println("membershipCategory in servicee====="+membershipCategory);
                String duration = membershipSubscriptionVO.getDuration();
                System.out.println("duration is====="+duration);


                long paymentAmount =0;
                if ("3".equalsIgnoreCase(duration)) {
                    paymentAmount = (long)ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_THREE_MONTHS_DURATION_FEES;
                }
                if ("6".equalsIgnoreCase(duration)) {
                    paymentAmount =(long) ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_SIX_MONTHS_DURATION_FEES;
                }
                if ("9".equalsIgnoreCase(duration)) {
                    paymentAmount =(long) ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_NINE_MONTHS_DURATION_FEES;
                }
                if ("12".equalsIgnoreCase(duration)) {
                    paymentAmount =(long) ProfessionalTutorsConstant.TUTOR_SUBSCRIPTION_TWELVE_MONTHS_DURATION_FEES;
                }

                String paymentMode = membershipSubscriptionVO.getPaymentMode();
                String membershipExpireDate = RegistrationDateCalculation.getExpiryDate(new Integer(duration));
                System.out.println("membershipExpireDate in serviceee"+membershipExpireDate);
                String membershipExpireWarningDate = RegistrationDateCalculation.getExpiryWarningDate(new Integer(duration));
                System.out.println("membershipExpireWarningDate in serviceee===="+membershipExpireWarningDate);

                String updateMembership = "update tutor_details set membership_category =?,duration =?,mode_of_payment=?,payment_amount=?,membership_begin_date=curdate(),membership_expire_date=?,membership_expire_warning_date = ? where tutor_id =?";

                pst = conn.prepareStatement(updateMembership);

                /*  Login Information */
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, membershipCategory);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, duration);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, paymentMode);
                pst.setFloat(ProfessionalTutorsConstant.PARAMETER_INDEX_4, paymentAmount);
                System.out.println("paymentAmount in service........."+paymentAmount);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, membershipExpireDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, membershipExpireWarningDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, tutorId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {

                    tutorRegistrationVO.setTutorId(tutorId);
                    tutorRegistrationVO.setTutorSubscriptionDuration(duration);
                    tutorRegistrationVO.setTutorSubscriptionAmount(String.valueOf(paymentAmount));
                    tutorRegistrationVO.setTutorSubscriptionMode(paymentMode);

                    if (null != emailAddress) {
                    try {
                        System.out.println(" Before Sending Email");
                      //  EmailService emailService = new EmailService();
                      
                        //String senderName = "admin@theprofessionaltutors.com";

                       // emailService.sendEmail(senderName,tutorId,emailAddress, userLoginName, password);

                        GodaddyEmailService godaddyEmailService = new GodaddyEmailService();
                         String senderName = "admin@theprofessionaltutors.com";
                         godaddyEmailService.sendEmail(senderName,tutorId,emailAddress, userLoginName, password);

                        System.out.println(" After Sending Email");
                    } catch (Exception exception) {
                        System.out.println(" Email Exception Message : " + exception.getMessage());
                        //exception.printStackTrace();
                    }
                }

                   }
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
        return tutorRegistrationVO;
    }

    /**
     *
     * @param membershipSubscriptionVO
     * @return
     * @throws ProfessionalTutorsException
     * @throws Exception
     */
    public ResultVO studentMembershipPayment(MembershipSubscriptionVO membershipSubscriptionVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = new ResultVO();

        try {
            DbConnection obj = new DbConnection();
            conn = obj.dbConnect();

            /* Tutor Login Information  */
            String studentId = membershipSubscriptionVO.getUserId();
            String userLoginName = membershipSubscriptionVO.getUserLoginName();
            String password = membershipSubscriptionVO.getPassword();
            String emailAddress = membershipSubscriptionVO.getEmailAddress();

            String membershipCategory ="Free";
            String duration = membershipSubscriptionVO.getDuration();


            long paymentAmount = 0;
            if ("3".equalsIgnoreCase(duration)) {
                paymentAmount =(long) ProfessionalTutorsConstant.SUDENT_SUBSCRIPTION_THREE_MONTHS_DURATION_FEES;
            }
            if ("6".equalsIgnoreCase(duration)) {
                paymentAmount =(long) ProfessionalTutorsConstant.SUDENT_SUBSCRIPTION_SIX_MONTHS_DURATION_FEES;
            }
            if ("9".equalsIgnoreCase(duration)) {
                paymentAmount =(long) ProfessionalTutorsConstant.SUDENT_SUBSCRIPTION_NINE_MONTHS_DURATION_FEES;
            }
            if ("12".equalsIgnoreCase(duration)) {
                paymentAmount = (long)ProfessionalTutorsConstant.SUDENT_SUBSCRIPTION_TWELVE_MONTHS_DURATION_FEES;
            }

            String paymentMode = membershipSubscriptionVO.getPaymentMode();

            String membershipExpireWarningDate = RegistrationDateCalculation.getExpiryWarningDate(new Integer(duration));
            String membershipExpireDate = RegistrationDateCalculation.getExpiryDate(new Integer(duration));


            System.out.println(" ************************************");
            System.out.println(" studentId : " + studentId);
            System.out.println(" membershipCategory : " + membershipCategory);
            System.out.println(" duration : " + duration);
            System.out.println(" paymentMode : " + paymentMode);
            System.out.println(" paymentAmount : " + paymentAmount);
            System.out.println("***************************************");

            String updateMembership = "update student_details set membership_category =?,duration =?,mode_of_payment=?,payment_amount=?,membership_begin_date=curdate(),membership_expire_warning_date = ?,membership_expire_date=? where student_id =?";

            pst = conn.prepareStatement(updateMembership);

            /*  Login Information */
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, membershipCategory);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, duration);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, paymentMode);
            pst.setFloat(ProfessionalTutorsConstant.PARAMETER_INDEX_4, paymentAmount);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, membershipExpireWarningDate);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, membershipExpireDate);
            pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, studentId);



            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("A");
                resultVO.setStudentId(studentId);
                resultVO.setDuration(duration);
                resultVO.setPaymentAmount((String.valueOf(paymentAmount)));
                resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));

                if (null != emailAddress) {
                    try {
                        System.out.println(" Before Sending Email");
                       // EmailService emailService = new EmailService();
                        GodaddyEmailService godaddyEmailService = new GodaddyEmailService();
                         String senderName = "admin@theprofessionaltutors.com";
                         godaddyEmailService.sendEmail(senderName,studentId,emailAddress, userLoginName, password);

                        System.out.println(" After Sending Email");
                    } catch (Exception exception) {
                        System.out.println(" Email Exception Message : " + exception.getMessage());
                        //exception.printStackTrace();
                    }
                }
            } else {
                System.out.println("B");
                resultVO.setValidationMessage(resource.getString("Registration Failed"));
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
     * @param membershipSubscriptionVO
     * @return
     * @throws ProfessionalTutorsException
     * @throws Exception
     */
    public ResultVO tutorialCenterMembershipPayment(MembershipSubscriptionVO membershipSubscriptionVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultVO resultVO = new ResultVO();

        try {
            DbConnection obj = new DbConnection();
            conn = obj.dbConnect();
            if (null != conn) {

                /* Tutor Login Information  */
                String instituteId = membershipSubscriptionVO.getUserId();


                String membershipCategory ="Free";
                String duration = membershipSubscriptionVO.getDuration();
                String modeOfPayment = membershipSubscriptionVO.getPaymentMode();
                long paymentAmount =0;
                if ("3".equalsIgnoreCase(duration)) {
                    paymentAmount = (long)ProfessionalTutorsConstant.TUTORIAL_CENTER_SUBSCRIPTION_THREE_MONTHS_DURATION_FEES;
                }
                if ("6".equalsIgnoreCase(duration)) {
                    paymentAmount = (long)ProfessionalTutorsConstant.TUTORIAL_CENTER_SUBSCRIPTION_SIX_MONTHS_DURATION_FEES;
                }

                if ("12".equalsIgnoreCase(duration)) {
                    paymentAmount =(long) ProfessionalTutorsConstant.TUTORIAL_CENTER_SUBSCRIPTION_TWELVE_MONTHS_DURATION_FEES;
                }

                String membershipExpireWarningDate = RegistrationDateCalculation.getExpiryWarningDate(new Integer(duration));
                String membershipExpireDate = RegistrationDateCalculation.getExpiryDate(new Integer(duration));



                String updateMembership = "update tutorial_center set institute_membership_category =?,institute_membership_duration =?,institute_mode_of_payment=?,institute_payment_amount=?,institute_membership_begin_date=curdate(),institute_membership_expire_warning_date=?,institute_membership_expire_date=? where institute_id =?";

                pst = conn.prepareStatement(updateMembership);

                /*  Login Information */
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, membershipCategory);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, duration);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, modeOfPayment);
                pst.setFloat(ProfessionalTutorsConstant.PARAMETER_INDEX_4, paymentAmount);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, membershipExpireWarningDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, membershipExpireDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, instituteId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("A");
                    resultVO.setInstituteId(instituteId);
                    resultVO.setDuration(duration);
                    resultVO.setPaymentAmount((String.valueOf(paymentAmount)));
                    resultVO.setValidationMessage(resource.getString("DATABASE_VALIDATION_SUCCESSFUL_MESSAGE_002"));
                } else {
                    System.out.println("B");
                    //throw new ProfessionalTutorsException(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003, resource.getString(ProfessionalTutorsConstant.DATABASE_ERROR_CODE_003));
                }

            } else {
                System.out.println(" No Connection Found");
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
     * created by ranjit paymentmembership
     * 
     */
    
    public EmployeeRegistrationVo employeeMembershipPayment(MembershipSubscriptionVO membershipSubscriptionVO) throws ProfessionalTutorsException, Exception {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        EmployeeRegistrationVo employeeRegistrationVo=new EmployeeRegistrationVo();
       //TutorRegistrationVO tutorRegistrationVO = new TutorRegistrationVO();
        // ResultVO resultVO = new ResultVO();

        try {
            DbConnection obj = new DbConnection();
            conn = obj.dbConnect();
            if (null != conn) {
                /* Tutor Login Information  */
                String employeeId = membershipSubscriptionVO.getUserId();
                String userLoginName = membershipSubscriptionVO.getUserLoginName();
                String password = membershipSubscriptionVO.getPassword();
                String emailAddress = membershipSubscriptionVO.getEmailAddress();

                String membershipCategory ="Free";
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

                String paymentMode = membershipSubscriptionVO.getPaymentMode();
                String membershipExpireDate = RegistrationDateCalculation.getExpiryDate(new Integer(duration));
                String membershipExpireWarningDate = RegistrationDateCalculation.getExpiryWarningDate(new Integer(duration));


                String updateMembership = "update employers_details set membership_category =?,duration =?,mode_of_payment=?,payment_amount=?,membership_begin_date=curdate(),membership_expire_date=?,membership_expire_warning_date = ? where employee_id =?";

                pst = conn.prepareStatement(updateMembership);

                /*  Login Information */
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_1, membershipCategory);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_2, duration);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_3, paymentMode);
                pst.setFloat(ProfessionalTutorsConstant.PARAMETER_INDEX_4, paymentAmount);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_5, membershipExpireDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_6, membershipExpireWarningDate);
                pst.setString(ProfessionalTutorsConstant.PARAMETER_INDEX_7, employeeId);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {

                    employeeRegistrationVo.setEmployeeId(employeeId);
                    employeeRegistrationVo.setTutorSubscriptionDuration(duration);
                    employeeRegistrationVo.setTutorSubscriptionAmount( (new Float(paymentAmount)).toString());
                    employeeRegistrationVo.setTutorSubscriptionMode(paymentMode);

                    if (null != emailAddress) {
                    try {
                        System.out.println(" Before Sending Email");
                      //  EmailService emailService = new EmailService();
                      
                        //String senderName = "admin@theprofessionaltutors.com";

                       // emailService.sendEmail(senderName,tutorId,emailAddress, userLoginName, password);

                        GodaddyEmailService godaddyEmailService = new GodaddyEmailService();
                         String senderName = "admin@theprofessionaltutors.com";
                         godaddyEmailService.sendEmail(senderName,employeeId,emailAddress, userLoginName, password);

                        System.out.println(" After Sending Email");
                    } catch (Exception exception) {
                        System.out.println(" Email Exception Message : " + exception.getMessage());
                        //exception.printStackTrace();
                    }
                }

                   }
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
        return employeeRegistrationVo;
    }
  
}
