/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.jobseekers.vo;

/**
 *
 * @author pcs
 */
public class ResultVo {
    private String jobSeekerId;
    private String msg;
    private String jobSeekerLoginName;
    private String jobSeekerPassword;
     private boolean userValidationFlag;
    private String employerLoginName;
    private String employerPassword;
     
    public String getJobSeekerLoginName() {
        return jobSeekerLoginName;
    }

    public void setJobSeekerLoginName(String jobSeekerLoginName) {
        this.jobSeekerLoginName = jobSeekerLoginName;
    }

    public String getJobSeekerPassword() {
        return jobSeekerPassword;
    }

    public void setJobSeekerPassword(String jobSeekerPassword) {
        this.jobSeekerPassword = jobSeekerPassword;
    }

    public String getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(String jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
     * @return the employerLoginName
     */
    public String getEmployerLoginName() {
        return employerLoginName;
    }

    /**
     * @param employerLoginName the employerLoginName to set
     */
    public void setEmployerLoginName(String employerLoginName) {
        this.employerLoginName = employerLoginName;
    }

    /**
     * @return the employerPassword
     */
    public String getEmployerPassword() {
        return employerPassword;
    }

    /**
     * @param employerPassword the employerPassword to set
     */
    public void setEmployerPassword(String employerPassword) {
        this.employerPassword = employerPassword;
    }
}
