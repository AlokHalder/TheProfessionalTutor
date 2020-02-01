/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.admin.tutors.vo;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author ibm
 */
public class TutorRegistrationVO implements Serializable {

    private String tutorId;
    private String tutorName;
    private String tutorLoginName;
    private String tutorPassword;
    private String tutorSecretQuestion;
    private String tutorSecretQuestionAnswer;
    private String tutorAge;
    private String tutorSex;
    private String tutorAddress;
    private String tutorCountryLocation;
    private String tutorCityLocation;
    private String tutorArea;
    private String tutorEmailId;
    private String contactNumber;
    private String preferenceToTeaching;
    private String boardOrUniversity;
    private String tutoringExperience;
    private String tutorYearsOfExperience;
    private String tutorMonthsOfExperience;
    private String feeExpected;
    private String tutoringOptions;
    private String teachingMedium;
    private String mainsubject;
    private String teachingLevel;
    private String tutoringApproach;
    private String tutorRegistrationDate;
    private boolean imageFlag;
    private String preferredTutoringArea;
    private String tutorTeachingPatteren;
    private File uploadImage;
    private String registrationDate;

    private String ugQualifyingDegree;
    private String ugSpecialization;
    private String ugBoardOrUniversity;
    private String ugPassoutYear;

    private String pgQualifyingDegree;
    private String pgSpecialization;
    private String pgBoardOrUniversity;
    private String pgPassoutYear;


    private String membershipCategory;
    private String duration;
    private String paymentMode;
    private String paymentAmount;
    private String membershipBegindate;
    private String membershipExpireWarningDate;
    private String membershipExpiredate;

    private String profileverification;
    private String profilestatus;

    private String countrycode;
    private String locationid;
    private String questionid;

    private String ugsubjectid;
    private String ugcourseid;
    private String uguniversityid;


    private String pgsubjectid;
    private String pgcourseid;
    private String pguniversityid;
    

    /**
     * @return the tutorName
     */
    public String getTutorName() {
        return tutorName;
    }

    /**
     * @param tutorName the tutorName to set
     */
    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    /**
     * @return the tutorAge
     */
    public String getTutorAge() {
        return tutorAge;
    }

    /**
     * @param tutorAge the tutorAge to set
     */
    public void setTutorAge(String tutorAge) {
        this.tutorAge = tutorAge;
    }

    /**
     * @return the tutorAddress
     */
    public String getTutorAddress() {
        return tutorAddress;
    }

    /**
     * @param tutorAddress the tutorAddress to set
     */
    public void setTutorAddress(String tutorAddress) {
        this.tutorAddress = tutorAddress;
    }

    /**
     * @return the tutorArea
     */
    public String getTutorArea() {
        return tutorArea;
    }

    /**
     * @param tutorArea the tutorArea to set
     */
    public void setTutorArea(String tutorArea) {
        this.tutorArea = tutorArea;
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
     * @return the preferenceToTeaching
     */
    public String getPreferenceToTeaching() {
        return preferenceToTeaching;
    }

    /**
     * @param preferenceToTeaching the preferenceToTeaching to set
     */
    public void setPreferenceToTeaching(String preferenceToTeaching) {
        this.preferenceToTeaching = preferenceToTeaching;
    }

  
    /**
     * @return the tutoringExperience
     */
    public String getTutoringExperience() {
        return tutoringExperience;
    }

    /**
     * @param tutoringExperience the tutoringExperience to set
     */
    public void setTutoringExperience(String tutoringExperience) {
        this.tutoringExperience = tutoringExperience;
    }

    /**
     * @return the feeExpected
     */
    public String getFeeExpected() {
        return feeExpected;
    }

    /**
     * @param feeExpected the feeExpected to set
     */
    public void setFeeExpected(String feeExpected) {
        this.feeExpected = feeExpected;
    }

    /**
     * @return the tutoringOptions
     */
    public String getTutoringOptions() {
        return tutoringOptions;
    }

    /**
     * @param tutoringOptions the tutoringOptions to set
     */
    public void setTutoringOptions(String tutoringOptions) {
        this.tutoringOptions = tutoringOptions;
    }

    /**
     * @return the teachingMedium
     */
    public String getTeachingMedium() {
        return teachingMedium;
    }

    /**
     * @param teachingMedium the teachingMedium to set
     */
    public void setTeachingMedium(String teachingMedium) {
        this.teachingMedium = teachingMedium;
    }

    /**
     * @return the mainsubject
     */
    public String getMainsubject() {
        return mainsubject;
    }

    /**
     * @param mainsubject the mainsubject to set
     */
    public void setMainsubject(String mainsubject) {
        this.mainsubject = mainsubject;
    }

    /**
     * @return the teachingLevel
     */
    public String getTeachingLevel() {
        return teachingLevel;
    }

    /**
     * @param teachingLevel the teachingLevel to set
     */
    public void setTeachingLevel(String teachingLevel) {
        this.teachingLevel = teachingLevel;
    }

    /**
     * @return the tutorSex
     */
    public String getTutorSex() {
        return tutorSex;
    }

    /**
     * @param tutorSex the tutorSex to set
     */
    public void setTutorSex(String tutorSex) {
        this.tutorSex = tutorSex;
    }

    /**
     * @return the tutorCountryLocation
     */
    public String getTutorCountryLocation() {
        return tutorCountryLocation;
    }

    /**
     * @param tutorCountryLocation the tutorCountryLocation to set
     */
    public void setTutorCountryLocation(String tutorCountryLocation) {
        this.tutorCountryLocation = tutorCountryLocation;
    }

    /**
     * @return the tutorCityLocation
     */
    public String getTutorCityLocation() {
        return tutorCityLocation;
    }

    /**
     * @param tutorCityLocation the tutorCityLocation to set
     */
    public void setTutorCityLocation(String tutorCityLocation) {
        this.tutorCityLocation = tutorCityLocation;
    }

    /**
     * @return the tutoringApproach
     */
    public String getTutoringApproach() {
        return tutoringApproach;
    }

    /**
     * @param tutoringApproach the tutoringApproach to set
     */
    public void setTutoringApproach(String tutoringApproach) {
        this.tutoringApproach = tutoringApproach;
    }

    /**
     * @return the tutorRegistrationDate
     */
    public String getTutorRegistrationDate() {
        return tutorRegistrationDate;
    }

    /**
     * @param tutorRegistrationDate the tutorRegistrationDate to set
     */
    public void setTutorRegistrationDate(String tutorRegistrationDate) {
        this.tutorRegistrationDate = tutorRegistrationDate;
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
     * @return the imageFlag
     */
    public boolean isImageFlag() {
        return imageFlag;
    }

    /**
     * @param imageFlag the imageFlag to set
     */
    public void setImageFlag(boolean imageFlag) {
        this.imageFlag = imageFlag;
    }

    /**
     * @return the preferredTutoringArea
     */
    public String getPreferredTutoringArea() {
        return preferredTutoringArea;
    }

    /**
     * @param preferredTutoringArea the preferredTutoringArea to set
     */
    public void setPreferredTutoringArea(String preferredTutoringArea) {
        this.preferredTutoringArea = preferredTutoringArea;
    }

    /**
     * @return the tutorTeachingPatteren
     */
    public String getTutorTeachingPatteren() {
        return tutorTeachingPatteren;
    }

    /**
     * @param tutorTeachingPatteren the tutorTeachingPatteren to set
     */
    public void setTutorTeachingPatteren(String tutorTeachingPatteren) {
        this.tutorTeachingPatteren = tutorTeachingPatteren;
    }

    /**
     * @return the tutorLoginName
     */
    public String getTutorLoginName() {
        return tutorLoginName;
    }

    /**
     * @param tutorLoginName the tutorLoginName to set
     */
    public void setTutorLoginName(String tutorLoginName) {
        this.tutorLoginName = tutorLoginName;
    }

    /**
     * @return the uploadImage
     */
    public File getUploadImage() {
        return uploadImage;
    }

    /**
     * @param uploadImage the uploadImage to set
     */
    public void setUploadImage(File uploadImage) {
        this.uploadImage = uploadImage;
    }

    /**
     * @return the registrationDate
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * @return the tutorSecretQuestion
     */
    public String getTutorSecretQuestion() {
        return tutorSecretQuestion;
    }

    /**
     * @param tutorSecretQuestion the tutorSecretQuestion to set
     */
    public void setTutorSecretQuestion(String tutorSecretQuestion) {
        this.tutorSecretQuestion = tutorSecretQuestion;
    }

    /**
     * @return the tutorSecretQuestionAnswer
     */
    public String getTutorSecretQuestionAnswer() {
        return tutorSecretQuestionAnswer;
    }

    /**
     * @param tutorSecretQuestionAnswer the tutorSecretQuestionAnswer to set
     */
    public void setTutorSecretQuestionAnswer(String tutorSecretQuestionAnswer) {
        this.tutorSecretQuestionAnswer = tutorSecretQuestionAnswer;
    }

    /**
     * @return the tutorYearsOfExperience
     */
    public String getTutorYearsOfExperience() {
        return tutorYearsOfExperience;
    }

    /**
     * @param tutorYearsOfExperience the tutorYearsOfExperience to set
     */
    public void setTutorYearsOfExperience(String tutorYearsOfExperience) {
        this.tutorYearsOfExperience = tutorYearsOfExperience;
    }

    /**
     * @return the boardOrUniversity
     */
    public String getBoardOrUniversity() {
        return boardOrUniversity;
    }

    /**
     * @param boardOrUniversity the boardOrUniversity to set
     */
    public void setBoardOrUniversity(String boardOrUniversity) {
        this.boardOrUniversity = boardOrUniversity;
    }

    /**
     * @return the tutorMonthsOfExperience
     */
    public String getTutorMonthsOfExperience() {
        return tutorMonthsOfExperience;
    }

    /**
     * @param tutorMonthsOfExperience the tutorMonthsOfExperience to set
     */
    public void setTutorMonthsOfExperience(String tutorMonthsOfExperience) {
        this.tutorMonthsOfExperience = tutorMonthsOfExperience;
    }

    /**
     * @return the ugQualifyingDegree
     */
    public String getUgQualifyingDegree() {
        return ugQualifyingDegree;
    }

    /**
     * @param ugQualifyingDegree the ugQualifyingDegree to set
     */
    public void setUgQualifyingDegree(String ugQualifyingDegree) {
        this.ugQualifyingDegree = ugQualifyingDegree;
    }

    /**
     * @return the ugSpecialization
     */
    public String getUgSpecialization() {
        return ugSpecialization;
    }

    /**
     * @param ugSpecialization the ugSpecialization to set
     */
    public void setUgSpecialization(String ugSpecialization) {
        this.ugSpecialization = ugSpecialization;
    }

    /**
     * @return the ugBoardOrUniversity
     */
    public String getUgBoardOrUniversity() {
        return ugBoardOrUniversity;
    }

    /**
     * @param ugBoardOrUniversity the ugBoardOrUniversity to set
     */
    public void setUgBoardOrUniversity(String ugBoardOrUniversity) {
        this.ugBoardOrUniversity = ugBoardOrUniversity;
    }

    /**
     * @return the ugPassoutYear
     */
    public String getUgPassoutYear() {
        return ugPassoutYear;
    }

    /**
     * @param ugPassoutYear the ugPassoutYear to set
     */
    public void setUgPassoutYear(String ugPassoutYear) {
        this.ugPassoutYear = ugPassoutYear;
    }

    /**
     * @return the pgQualifyingDegree
     */
    public String getPgQualifyingDegree() {
        return pgQualifyingDegree;
    }

    /**
     * @param pgQualifyingDegree the pgQualifyingDegree to set
     */
    public void setPgQualifyingDegree(String pgQualifyingDegree) {
        this.pgQualifyingDegree = pgQualifyingDegree;
    }

    /**
     * @return the pgSpecialization
     */
    public String getPgSpecialization() {
        return pgSpecialization;
    }

    /**
     * @param pgSpecialization the pgSpecialization to set
     */
    public void setPgSpecialization(String pgSpecialization) {
        this.pgSpecialization = pgSpecialization;
    }

    /**
     * @return the pgBoardOrUniversity
     */
    public String getPgBoardOrUniversity() {
        return pgBoardOrUniversity;
    }

    /**
     * @param pgBoardOrUniversity the pgBoardOrUniversity to set
     */
    public void setPgBoardOrUniversity(String pgBoardOrUniversity) {
        this.pgBoardOrUniversity = pgBoardOrUniversity;
    }

    /**
     * @return the pgPassoutYear
     */
    public String getPgPassoutYear() {
        return pgPassoutYear;
    }

    /**
     * @param pgPassoutYear the pgPassoutYear to set
     */
    public void setPgPassoutYear(String pgPassoutYear) {
        this.pgPassoutYear = pgPassoutYear;
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
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the paymentMode
     */
    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     * @param paymentMode the paymentMode to set
     */
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    /**
     * @return the paymentAmount
     */
    public String getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * @param paymentAmount the paymentAmount to set
     */
    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * @return the membershipBegindate
     */
    public String getMembershipBegindate() {
        return membershipBegindate;
    }

    /**
     * @param membershipBegindate the membershipBegindate to set
     */
    public void setMembershipBegindate(String membershipBegindate) {
        this.membershipBegindate = membershipBegindate;
    }

    /**
     * @return the membershipExpireWarningDate
     */
    public String getMembershipExpireWarningDate() {
        return membershipExpireWarningDate;
    }

    /**
     * @param membershipExpireWarningDate the membershipExpireWarningDate to set
     */
    public void setMembershipExpireWarningDate(String membershipExpireWarningDate) {
        this.membershipExpireWarningDate = membershipExpireWarningDate;
    }

    /**
     * @return the membershipExpiredate
     */
    public String getMembershipExpiredate() {
        return membershipExpiredate;
    }

    /**
     * @param membershipExpiredate the membershipExpiredate to set
     */
    public void setMembershipExpiredate(String membershipExpiredate) {
        this.membershipExpiredate = membershipExpiredate;
    }

    /**
     * @return the profileverification
     */
    public String getProfileverification() {
        return profileverification;
    }

    /**
     * @param profileverification the profileverification to set
     */
    public void setProfileverification(String profileverification) {
        this.profileverification = profileverification;
    }

    /**
     * @return the profilestatus
     */
    public String getProfilestatus() {
        return profilestatus;
    }

    /**
     * @param profilestatus the profilestatus to set
     */
    public void setProfilestatus(String profilestatus) {
        this.profilestatus = profilestatus;
    }

    /**
     * @return the countrycode
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * @param countrycode the countrycode to set
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * @return the locationid
     */
    public String getLocationid() {
        return locationid;
    }

    /**
     * @param locationid the locationid to set
     */
    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    /**
     * @return the questionid
     */
    public String getQuestionid() {
        return questionid;
    }

    /**
     * @param questionid the questionid to set
     */
    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    /**
     * @return the ugsubjectid
     */
    public String getUgsubjectid() {
        return ugsubjectid;
    }

    /**
     * @param ugsubjectid the ugsubjectid to set
     */
    public void setUgsubjectid(String ugsubjectid) {
        this.ugsubjectid = ugsubjectid;
    }

    /**
     * @return the ugcourseid
     */
    public String getUgcourseid() {
        return ugcourseid;
    }

    /**
     * @param ugcourseid the ugcourseid to set
     */
    public void setUgcourseid(String ugcourseid) {
        this.ugcourseid = ugcourseid;
    }

    /**
     * @return the uguniversityid
     */
    public String getUguniversityid() {
        return uguniversityid;
    }

    /**
     * @param uguniversityid the uguniversityid to set
     */
    public void setUguniversityid(String uguniversityid) {
        this.uguniversityid = uguniversityid;
    }

    /**
     * @return the pgsubjectid
     */
    public String getPgsubjectid() {
        return pgsubjectid;
    }

    /**
     * @param pgsubjectid the pgsubjectid to set
     */
    public void setPgsubjectid(String pgsubjectid) {
        this.pgsubjectid = pgsubjectid;
    }

    /**
     * @return the pgcourseid
     */
    public String getPgcourseid() {
        return pgcourseid;
    }

    /**
     * @param pgcourseid the pgcourseid to set
     */
    public void setPgcourseid(String pgcourseid) {
        this.pgcourseid = pgcourseid;
    }

    /**
     * @return the pguniversityid
     */
    public String getPguniversityid() {
        return pguniversityid;
    }

    /**
     * @param pguniversityid the pguniversityid to set
     */
    public void setPguniversityid(String pguniversityid) {
        this.pguniversityid = pguniversityid;
    }

    
}
