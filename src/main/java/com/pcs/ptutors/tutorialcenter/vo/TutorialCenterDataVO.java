/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.tutorialcenter.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ibm
 */
public class TutorialCenterDataVO implements Serializable{

    /* Tutorial Center Login Information */

    private String instituteLoginName;
    private String instituePassword;
    private String instituteConfirmPassword;
    private String instituterSecurityQuestion;
    private String instituteSecurityAnswer;

    /* Tutorial Center Basic Information */
    private String instituteId;
    private String instituteName;
    private String institutePrefaceInfo;
    private String instituteCountryName;
    private String instituteLocationName;
    private String instituteArea;
    private String instituteLandMark;
    private String instituteAddress;
    private String instituteContactPerson;
    private String instituteTelephone;
    private String instituteMobile;
    private String instituteEmail;
    private String instituteWebsiteAddress;
    private int imageFlag;
    private String instituteregistrationdate;

    /* Tutorial center academic information */

    private String instituteCoursesOffered;
    private String instituteFacultyDetails;
    private String instituteAchivement;


    private String message;
    private List<TutorialCenterDataVO> listOfTutorialCenter;
    
     private String password;
     private String newPassword;
    private String confirmPassword;

    /**
     * @return the instituteLoginName
     */
    public String getInstituteLoginName() {
        return instituteLoginName;
    }

    /**
     * @param instituteLoginName the instituteLoginName to set
     */
    public void setInstituteLoginName(String instituteLoginName) {
        this.instituteLoginName = instituteLoginName;
    }

    /**
     * @return the instituePassword
     */
    public String getInstituePassword() {
        return instituePassword;
    }

    /**
     * @param instituePassword the instituePassword to set
     */
    public void setInstituePassword(String instituePassword) {
        this.instituePassword = instituePassword;
    }

    /**
     * @return the instituteConfirmPassword
     */
    public String getInstituteConfirmPassword() {
        return instituteConfirmPassword;
    }

    /**
     * @param instituteConfirmPassword the instituteConfirmPassword to set
     */
    public void setInstituteConfirmPassword(String instituteConfirmPassword) {
        this.instituteConfirmPassword = instituteConfirmPassword;
    }

    /**
     * @return the instituterSecurityQuestion
     */
    public String getInstituterSecurityQuestion() {
        return instituterSecurityQuestion;
    }

    /**
     * @param instituterSecurityQuestion the instituterSecurityQuestion to set
     */
    public void setInstituterSecurityQuestion(String instituterSecurityQuestion) {
        this.instituterSecurityQuestion = instituterSecurityQuestion;
    }

    /**
     * @return the instituteSecurityAnswer
     */
    public String getInstituteSecurityAnswer() {
        return instituteSecurityAnswer;
    }

    /**
     * @param instituteSecurityAnswer the instituteSecurityAnswer to set
     */
    public void setInstituteSecurityAnswer(String instituteSecurityAnswer) {
        this.instituteSecurityAnswer = instituteSecurityAnswer;
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

    /**
     * @return the instituteName
     */
    public String getInstituteName() {
        return instituteName;
    }

    /**
     * @param instituteName the instituteName to set
     */
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    /**
     * @return the institutePrefaceInfo
     */
    public String getInstitutePrefaceInfo() {
        return institutePrefaceInfo;
    }

    /**
     * @param institutePrefaceInfo the institutePrefaceInfo to set
     */
    public void setInstitutePrefaceInfo(String institutePrefaceInfo) {
        this.institutePrefaceInfo = institutePrefaceInfo;
    }

    /**
     * @return the instituteCountryName
     */
    public String getInstituteCountryName() {
        return instituteCountryName;
    }

    /**
     * @param instituteCountryName the instituteCountryName to set
     */
    public void setInstituteCountryName(String instituteCountryName) {
        this.instituteCountryName = instituteCountryName;
    }

    /**
     * @return the instituteLocationName
     */
    public String getInstituteLocationName() {
        return instituteLocationName;
    }

    /**
     * @param instituteLocationName the instituteLocationName to set
     */
    public void setInstituteLocationName(String instituteLocationName) {
        this.instituteLocationName = instituteLocationName;
    }

    /**
     * @return the instituteArea
     */
    public String getInstituteArea() {
        return instituteArea;
    }

    /**
     * @param instituteArea the instituteArea to set
     */
    public void setInstituteArea(String instituteArea) {
        this.instituteArea = instituteArea;
    }

    /**
     * @return the instituteLandMark
     */
    public String getInstituteLandMark() {
        return instituteLandMark;
    }

    /**
     * @param instituteLandMark the instituteLandMark to set
     */
    public void setInstituteLandMark(String instituteLandMark) {
        this.instituteLandMark = instituteLandMark;
    }

    /**
     * @return the instituteAddress
     */
    public String getInstituteAddress() {
        return instituteAddress;
    }

    /**
     * @param instituteAddress the instituteAddress to set
     */
    public void setInstituteAddress(String instituteAddress) {
        this.instituteAddress = instituteAddress;
    }

    /**
     * @return the instituteContactPerson
     */
    public String getInstituteContactPerson() {
        return instituteContactPerson;
    }

    /**
     * @param instituteContactPerson the instituteContactPerson to set
     */
    public void setInstituteContactPerson(String instituteContactPerson) {
        this.instituteContactPerson = instituteContactPerson;
    }

    /**
     * @return the instituteTelephone
     */
    public String getInstituteTelephone() {
        return instituteTelephone;
    }

    /**
     * @param instituteTelephone the instituteTelephone to set
     */
    public void setInstituteTelephone(String instituteTelephone) {
        this.instituteTelephone = instituteTelephone;
    }

    /**
     * @return the instituteMobile
     */
    public String getInstituteMobile() {
        return instituteMobile;
    }

    /**
     * @param instituteMobile the instituteMobile to set
     */
    public void setInstituteMobile(String instituteMobile) {
        this.instituteMobile = instituteMobile;
    }

    /**
     * @return the instituteEmail
     */
    public String getInstituteEmail() {
        return instituteEmail;
    }

    /**
     * @param instituteEmail the instituteEmail to set
     */
    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    /**
     * @return the instituteWebsiteAddress
     */
    public String getInstituteWebsiteAddress() {
        return instituteWebsiteAddress;
    }

    /**
     * @param instituteWebsiteAddress the instituteWebsiteAddress to set
     */
    public void setInstituteWebsiteAddress(String instituteWebsiteAddress) {
        this.instituteWebsiteAddress = instituteWebsiteAddress;
    }

    /**
     * @return the instituteCoursesOffered
     */
    public String getInstituteCoursesOffered() {
        return instituteCoursesOffered;
    }

    /**
     * @param instituteCoursesOffered the instituteCoursesOffered to set
     */
    public void setInstituteCoursesOffered(String instituteCoursesOffered) {
        this.instituteCoursesOffered = instituteCoursesOffered;
    }

    /**
     * @return the instituteFacultyDetails
     */
    public String getInstituteFacultyDetails() {
        return instituteFacultyDetails;
    }

    /**
     * @param instituteFacultyDetails the instituteFacultyDetails to set
     */
    public void setInstituteFacultyDetails(String instituteFacultyDetails) {
        this.instituteFacultyDetails = instituteFacultyDetails;
    }

    /**
     * @return the instituteAchivement
     */
    public String getInstituteAchivement() {
        return instituteAchivement;
    }

    /**
     * @param instituteAchivement the instituteAchivement to set
     */
    public void setInstituteAchivement(String instituteAchivement) {
        this.instituteAchivement = instituteAchivement;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the listOfTutorialCenter
     */
    public List<TutorialCenterDataVO> getListOfTutorialCenter() {
        return listOfTutorialCenter;
    }

    /**
     * @param listOfTutorialCenter the listOfTutorialCenter to set
     */
    public void setListOfTutorialCenter(List<TutorialCenterDataVO> listOfTutorialCenter) {
        this.listOfTutorialCenter = listOfTutorialCenter;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the imageFlag
     */
    public int getImageFlag() {
        return imageFlag;
    }

    /**
     * @param imageFlag the imageFlag to set
     */
    public void setImageFlag(int imageFlag) {
        this.imageFlag = imageFlag;
    }

    /**
     * @return the instituteregistrationdate
     */
    public String getInstituteregistrationdate() {
        return instituteregistrationdate;
    }

    /**
     * @param instituteregistrationdate the instituteregistrationdate to set
     */
    public void setInstituteregistrationdate(String instituteregistrationdate) {
        this.instituteregistrationdate = instituteregistrationdate;
    }



 
}
