/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.vo;

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

    /*
     * employer Created By sourav
     */
    private  String employeeEmailId;
    private String emoployeePassword;
    private String employeeLoginName;
     private String employeeId;
    private String employeeNameOrEmailAddress;
    private String employeePassword;
    

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

    /**
     * @return the employeeEmailId
     */
    public String getEmployeeEmailId() {
        return employeeEmailId;
    }

    /**
     * @param employeeEmailId the employeeEmailId to set
     */
    public void setEmployeeEmailId(String employeeEmailId) {
        this.employeeEmailId = employeeEmailId;
    }

    /**
     * @return the emoployeePassword
     */
    public String getEmoployeePassword() {
        return emoployeePassword;
    }

    /**
     * @param emoployeePassword the emoployeePassword to set
     */
    public void setEmoployeePassword(String emoployeePassword) {
        this.emoployeePassword = emoployeePassword;
    }

    /**
     * @return the employeeLoginName
     */
    public String getEmployeeLoginName() {
        return employeeLoginName;
    }

    /**
     * @param employeeLoginName the employeeLoginName to set
     */
    public void setEmployeeLoginName(String employeeLoginName) {
        this.employeeLoginName = employeeLoginName;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the employeeNameOrEmailAddress
     */
    public String getEmployeeNameOrEmailAddress() {
        return employeeNameOrEmailAddress;
    }

    /**
     * @param employeeNameOrEmailAddress the employeeNameOrEmailAddress to set
     */
    public void setEmployeeNameOrEmailAddress(String employeeNameOrEmailAddress) {
        this.employeeNameOrEmailAddress = employeeNameOrEmailAddress;
    }

    /**
     * @return the employeePassword
     */
    public String getEmployeePassword() {
        return employeePassword;
    }

    /**
     * @param employeePassword the employeePassword to set
     */
    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

}
