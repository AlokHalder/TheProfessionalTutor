/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.admin.tutors.vo;
/**
 *
 * @author ibm
 */
public class LoginVO implements java.io.Serializable{
    private String tutorId;
    private String tutorNameOrEmailAddress;
    private String tutorPassword;
    private String tutorEmailId;
    private String tutorSegment;

    private String studentId;
    private String studentNameOrEmailAddress;
    private String studentPassword;
   // private String  studentEmailId;
    private String  studentSegment;

    private String adminUserName;
    private String adminUserPassword;
    private String adminEmailId;

    

    

    /**
     * @return the tutorPassword
     */
    public String getTutorPassword() {
        return tutorPassword;
    }

    /**
     * @param tutorPassword the tutorPassword to set
     */
    public void setTutorPassword(String tutorPassword) {
        this.tutorPassword = tutorPassword;
    }

    /**
     * @return the tutorEmailId
     */
    public String getTutorEmailId() {
        return tutorEmailId;
    }

    /**
     * @param tutorEmailId the tutorEmailId to set
     */
    public void setTutorEmailId(String tutorEmailId) {
        this.tutorEmailId = tutorEmailId;
    }

    /**
     * @return the tutorSegment
     */
    public String getTutorSegment() {
        return tutorSegment;
    }

    /**
     * @param tutorSegment the tutorSegment to set
     */
    public void setTutorSegment(String tutorSegment) {
        this.tutorSegment = tutorSegment;
    }

   
    /**
     * @return the studentPassword
     */
    public String getStudentPassword() {
        return studentPassword;
    }

    /**
     * @param studentPassword the studentPassword to set
     */
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

  

    /**
     * @return the studentSegment
     */
    public String getStudentSegment() {
        return studentSegment;
    }

    /**
     * @param studentSegment the studentSegment to set
     */
    public void setStudentSegment(String studentSegment) {
        this.studentSegment = studentSegment;
    }

    /**
     * @return the adminUserName
     */
    public String getAdminUserName() {
        return adminUserName;
    }

    /**
     * @param adminUserName the adminUserName to set
     */
    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    /**
     * @return the adminUserPassword
     */
    public String getAdminUserPassword() {
        return adminUserPassword;
    }

    /**
     * @param adminUserPassword the adminUserPassword to set
     */
    public void setAdminUserPassword(String adminUserPassword) {
        this.adminUserPassword = adminUserPassword;
    }

    /**
     * @return the adminEmailId
     */
    public String getAdminEmailId() {
        return adminEmailId;
    }

    /**
     * @param adminEmailId the adminEmailId to set
     */
    public void setAdminEmailId(String adminEmailId) {
        this.adminEmailId = adminEmailId;
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
     * @return the studentNameOrEmailAddress
     */
    public String getStudentNameOrEmailAddress() {
        return studentNameOrEmailAddress;
    }

    /**
     * @param studentNameOrEmailAddress the studentNameOrEmailAddress to set
     */
    public void setStudentNameOrEmailAddress(String studentNameOrEmailAddress) {
        this.studentNameOrEmailAddress = studentNameOrEmailAddress;
    }

    /**
     * @return the tutorNameOrEmailAddress
     */
    public String getTutorNameOrEmailAddress() {
        return tutorNameOrEmailAddress;
    }

    /**
     * @param tutorNameOrEmailAddress the tutorNameOrEmailAddress to set
     */
    public void setTutorNameOrEmailAddress(String tutorNameOrEmailAddress) {
        this.tutorNameOrEmailAddress = tutorNameOrEmailAddress;
    }

}
