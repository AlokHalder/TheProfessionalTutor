/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.vo;

import java.io.Serializable;

/**
 *
 * @author ibm
 */
public class InstantTutorServiceVO implements Serializable {

    private String contactPerson;
    private String contactNumber;
    private String emailAddesss;
    private String tutionTitle;
    private String subjectTitle;
    private String classStandard;
    private String locationId;
    private String areaName;
    private String countryCode;
    private String tutionPostingDate;


    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the tutionTitle
     */
    public String getTutionTitle() {
        return tutionTitle;
    }

    /**
     * @param tutionTitle the tutionTitle to set
     */
    public void setTutionTitle(String tutionTitle) {
        this.tutionTitle = tutionTitle;
    }

    /**
     * @return the subjectTitle
     */
    public String getSubjectTitle() {
        return subjectTitle;
    }

    /**
     * @param subjectTitle the subjectTitle to set
     */
    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    /**
     * @return the classStandard
     */
    public String getClassStandard() {
        return classStandard;
    }

    /**
     * @param classStandard the classStandard to set
     */
    public void setClassStandard(String classStandard) {
        this.classStandard = classStandard;
    }

   

    /**
     * @return the tutionPostingDate
     */
    public String getTutionPostingDate() {
        return tutionPostingDate;
    }

    /**
     * @param tutionPostingDate the tutionPostingDate to set
     */
    public void setTutionPostingDate(String tutionPostingDate) {
        this.tutionPostingDate = tutionPostingDate;
    }

    /**
     * @return the emailAddesss
     */
    public String getEmailAddesss() {
        return emailAddesss;
    }

    /**
     * @param emailAddesss the emailAddesss to set
     */
    public void setEmailAddesss(String emailAddesss) {
        this.emailAddesss = emailAddesss;
    }

   
    /**
     * @return the contactPerson
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson the contactPerson to set
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * @return the locationId
     */
    public String getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName the areaName to set
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    
}
