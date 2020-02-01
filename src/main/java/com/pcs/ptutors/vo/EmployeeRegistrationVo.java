/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.vo;

import java.io.Serializable;

/**
 *
 * @author PCSGlobal123
 */
public class EmployeeRegistrationVo implements Serializable {

    private String companyTypeCode;
    private String employeeId;
    private String name;
    private String userLoginName;
    private String password;
    private int secretQuestionId;
    private String secretQuestion;
    private String secretQuestionAnswer;
    private String gender;
    private int age;
    private String countryCode;
    private String locationId;
    private String postalCode;
    private String stateProvince;
    private String address;
    private String companyName;
    private int companyNameId;
    private int industryId;
    private String contactPersonName;
    private String contactNumber;
    private String emailAddress;
    private String industryTypeId;
    private String tutorSubscriptionDuration;
    private String tutorSubscriptionAmount;
    private String tutorSubscriptionMode;
    private String membershipCategory;
    private String employerCountryLocation;
    private String employerCityLocation;
    private String companyTypeId;
    private String industryTypeCode;
    
    private String newPassword;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the userLoginName
     */
    public String getUserLoginName() {
        return userLoginName;
    }

    /**
     * @param userLoginName the userLoginName to set
     */
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
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
     * @return the secretQuestionId
     */
    public int getSecretQuestionId() {
        return secretQuestionId;
    }

    /**
     * @param secretQuestionId the secretQuestionId to set
     */
    public void setSecretQuestionId(int secretQuestionId) {
        this.secretQuestionId = secretQuestionId;
    }

    /**
     * @return the secretQuestionAnswer
     */
    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    /**
     * @param secretQuestionAnswer the secretQuestionAnswer to set
     */
    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
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
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the stateProvince
     */
    public String getStateProvince() {
        return stateProvince;
    }

    /**
     * @param stateProvince the stateProvince to set
     */
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyNameId
     */
    public int getCompanyNameId() {
        return companyNameId;
    }

    /**
     * @param companyNameId the companyNameId to set
     */
    public void setCompanyNameId(int companyNameId) {
        this.companyNameId = companyNameId;
    }

    /**
     * @return the industryId
     */
    public int getIndustryId() {
        return industryId;
    }

    /**
     * @param industryId the industryId to set
     */
    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    /**
     * @return the contactPersonName
     */
    public String getContactPersonName() {
        return contactPersonName;
    }

    /**
     * @param contactPersonName the contactPersonName to set
     */
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

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
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the secretQuestion
     */
    public String getSecretQuestion() {
        return secretQuestion;
    }

    /**
     * @param secretQuestion the secretQuestion to set
     */
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    /**
     * @return the tutorSubscriptionDuration
     */
    public String getTutorSubscriptionDuration() {
        return tutorSubscriptionDuration;
    }

    /**
     * @param tutorSubscriptionDuration the tutorSubscriptionDuration to set
     */
    public void setTutorSubscriptionDuration(String tutorSubscriptionDuration) {
        this.tutorSubscriptionDuration = tutorSubscriptionDuration;
    }

    /**
     * @return the tutorSubscriptionAmount
     */
    public String getTutorSubscriptionAmount() {
        return tutorSubscriptionAmount;
    }

    /**
     * @param tutorSubscriptionAmount the tutorSubscriptionAmount to set
     */
    public void setTutorSubscriptionAmount(String tutorSubscriptionAmount) {
        this.tutorSubscriptionAmount = tutorSubscriptionAmount;
    }

    /**
     * @return the tutorSubscriptionMode
     */
    public String getTutorSubscriptionMode() {
        return tutorSubscriptionMode;
    }

    /**
     * @param tutorSubscriptionMode the tutorSubscriptionMode to set
     */
    public void setTutorSubscriptionMode(String tutorSubscriptionMode) {
        this.tutorSubscriptionMode = tutorSubscriptionMode;
    }

    /**
     * @return the industryTypeId
     */
    public String getIndustryTypeId() {
        return industryTypeId;
    }

    /**
     * @param industryTypeId the industryTypeId to set
     */
    public void setIndustryTypeId(String industryTypeId) {
        this.industryTypeId = industryTypeId;
    }

    /**
     * @return the companyTypeCode
     */
    public String getCompanyTypeCode() {
        return companyTypeCode;
    }

    /**
     * @param companyTypeCode the companyTypeCode to set
     */
    public void setCompanyTypeCode(String companyTypeCode) {
        this.companyTypeCode = companyTypeCode;
    }

    /**
     * @return the membershipCategory
     */
    public String getMembershipCategory() {
        return membershipCategory;
    }

    /**
     * @param membershipCategory the membershipCategory to set
     */
    public void setMembershipCategory(String membershipCategory) {
        this.membershipCategory = membershipCategory;
    }

    /**
     * @return the employerCountryLocation
     */
    public String getEmployerCountryLocation() {
        return employerCountryLocation;
    }

    /**
     * @param employerCountryLocation the employerCountryLocation to set
     */
    public void setEmployerCountryLocation(String employerCountryLocation) {
        this.employerCountryLocation = employerCountryLocation;
    }

    /**
     * @return the employerCityLocation
     */
    public String getEmployerCityLocation() {
        return employerCityLocation;
    }

    /**
     * @param employerCityLocation the employerCityLocation to set
     */
    public void setEmployerCityLocation(String employerCityLocation) {
        this.employerCityLocation = employerCityLocation;
    }

    /**
     * @return the companyTypeId
     */
    public String getCompanyTypeId() {
        return companyTypeId;
    }

    /**
     * @param companyTypeId the companyTypeId to set
     */
    public void setCompanyTypeId(String companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    /**
     * @return the industryTypeCode
     */
    public String getIndustryTypeCode() {
        return industryTypeCode;
    }

    /**
     * @param industryTypeCode the industryTypeCode to set
     */
    public void setIndustryTypeCode(String industryTypeCode) {
        this.industryTypeCode = industryTypeCode;
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
}
