/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.admin.tutors.vo;
/**
 *
 * @author ibm
 */
public class ResultVO implements java.io.Serializable{

    private String resultFlag;
    private String validationMessage;
    private String userCallName;
    private boolean userValidationFlag;
    private String tutorId;
    private String studentId;
    private String instituteId;







    /**
     * @return the resultFlag
     */
    public String getResultFlag() {
        return resultFlag;
    }

    /**
     * @param resultFlag the resultFlag to set
     */
    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
    }

    /**
     * @return the validationMessage
     */
    public String getValidationMessage() {
        return validationMessage;
    }

    /**
     * @param validationMessage the validationMessage to set
     */
    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    /**
     * @return the userCallName
     */
    public String getUserCallName() {
        return userCallName;
    }

    /**
     * @param userCallName the userCallName to set
     */
    public void setUserCallName(String userCallName) {
        this.userCallName = userCallName;
    }

    /**
     * @return the userValidationFlag
     */
    public boolean isUserValidationFlag() {
        return userValidationFlag;
    }

    /**
     * @param userValidationFlag the userValidationFlag to set
     */
    public void setUserValidationFlag(boolean userValidationFlag) {
        this.userValidationFlag = userValidationFlag;
    }

    /**
     * @return the tutorId
     */
    public String getTutorId() {
        return tutorId;
    }

    /**
     * @param tutorId the tutorId to set
     */
    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the instituteId
     */
    public String getInstituteId() {
        return instituteId;
    }

    /**
     * @param instituteId the instituteId to set
     */
    public void setInstituteId(String instituteId) {
        this.instituteId = instituteId;
    }


}
