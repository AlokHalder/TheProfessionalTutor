/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.vo;

import java.io.File;
import java.io.Serializable;
import java.util.List;


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
    private String tutorCountryCode;
    private String tutorCityLocationId;
    private String tutorArea;
    private String tutorPostalCode;
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
    private String documentVerificationFlag;
    private String tutorSubscriptionDuration;
    private String tutorSubscriptionAmount;
    private String tutorSubscriptionMode;


    private String ugQualifyingDegree;
    private String ugSpecialization;
    private String ugBoardOrUniversity;
    private String ugPassoutYear;

    private String pgQualifyingDegree;
    private String pgSpecialization;
    private String pgBoardOrUniversity;
    private String pgPassoutYear;

    private String otherUgQualifyingDegree;
    private String otherUgSpecialization;
    private String otherUgBoardOrUniversity;
    
    private String otherPgQualifyingDegree;
    private String otherPgSpecialization;
    private String otherPgBoardOrUniversity;

    private String otherPreferenceToTeaching;
    private String otherTutorTeachingPatteren;
    private String otherTutoringOptions;
    private String otherTeachingMedium;
    private String otherTeachingLevel;

    private String[] preferenceToTeachingList;
    private String[] teachingPatterenList;
    private String[] tutoringOptionList;
    private String[] teachingMediumLis;
    private String[] teachingLevelList;

    private List<String> listOfTeachingLevel;
    private List<String> listOfTeachingSubjects;
    private  List<TutorTeachingArenaVO> listOfTeachingArena;

    private String tutorTeachingLevel;
    private String tutorTeachingParten;
    private String tutorTeachingOption;
    
    private String[] teachingSubjectList;
    private String[] teachingBoardList;
    


    private String membershipCategory;
    private String newPassword;
    
    private String teachingSubject;
    private String photoFileName;

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
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
     * @return the otherUgQualifyingDegree
     */
    public String getOtherUgQualifyingDegree() {
        return otherUgQualifyingDegree;
    }

    /**
     * @param otherUgQualifyingDegree the otherUgQualifyingDegree to set
     */
    public void setOtherUgQualifyingDegree(String otherUgQualifyingDegree) {
        this.otherUgQualifyingDegree = otherUgQualifyingDegree;
    }

    /**
     * @return the otherUgSpecialization
     */
    public String getOtherUgSpecialization() {
        return otherUgSpecialization;
    }

    /**
     * @param otherUgSpecialization the otherUgSpecialization to set
     */
    public void setOtherUgSpecialization(String otherUgSpecialization) {
        this.otherUgSpecialization = otherUgSpecialization;
    }

    /**
     * @return the otherUgBoardOrUniversity
     */
    public String getOtherUgBoardOrUniversity() {
        return otherUgBoardOrUniversity;
    }

    /**
     * @param otherUgBoardOrUniversity the otherUgBoardOrUniversity to set
     */
    public void setOtherUgBoardOrUniversity(String otherUgBoardOrUniversity) {
        this.otherUgBoardOrUniversity = otherUgBoardOrUniversity;
    }

    /**
     * @return the otherPgQualifyingDegree
     */
    public String getOtherPgQualifyingDegree() {
        return otherPgQualifyingDegree;
    }

    /**
     * @param otherPgQualifyingDegree the otherPgQualifyingDegree to set
     */
    public void setOtherPgQualifyingDegree(String otherPgQualifyingDegree) {
        this.otherPgQualifyingDegree = otherPgQualifyingDegree;
    }

    /**
     * @return the otherPgSpecialization
     */
    public String getOtherPgSpecialization() {
        return otherPgSpecialization;
    }

    /**
     * @param otherPgSpecialization the otherPgSpecialization to set
     */
    public void setOtherPgSpecialization(String otherPgSpecialization) {
        this.otherPgSpecialization = otherPgSpecialization;
    }

    /**
     * @return the otherPgBoardOrUniversity
     */
    public String getOtherPgBoardOrUniversity() {
        return otherPgBoardOrUniversity;
    }

    /**
     * @param otherPgBoardOrUniversity the otherPgBoardOrUniversity to set
     */
    public void setOtherPgBoardOrUniversity(String otherPgBoardOrUniversity) {
        this.otherPgBoardOrUniversity = otherPgBoardOrUniversity;
    }

    /**
     * @return the otherPreferenceToTeaching
     */
    public String getOtherPreferenceToTeaching() {
        return otherPreferenceToTeaching;
    }

    /**
     * @param otherPreferenceToTeaching the otherPreferenceToTeaching to set
     */
    public void setOtherPreferenceToTeaching(String otherPreferenceToTeaching) {
        this.otherPreferenceToTeaching = otherPreferenceToTeaching;
    }

    /**
     * @return the otherTutorTeachingPatteren
     */
    public String getOtherTutorTeachingPatteren() {
        return otherTutorTeachingPatteren;
    }

    /**
     * @param otherTutorTeachingPatteren the otherTutorTeachingPatteren to set
     */
    public void setOtherTutorTeachingPatteren(String otherTutorTeachingPatteren) {
        this.otherTutorTeachingPatteren = otherTutorTeachingPatteren;
    }

    /**
     * @return the otherTutoringOptions
     */
    public String getOtherTutoringOptions() {
        return otherTutoringOptions;
    }

    /**
     * @param otherTutoringOptions the otherTutoringOptions to set
     */
    public void setOtherTutoringOptions(String otherTutoringOptions) {
        this.otherTutoringOptions = otherTutoringOptions;
    }

    /**
     * @return the otherTeachingMedium
     */
    public String getOtherTeachingMedium() {
        return otherTeachingMedium;
    }

    /**
     * @param otherTeachingMedium the otherTeachingMedium to set
     */
    public void setOtherTeachingMedium(String otherTeachingMedium) {
        this.otherTeachingMedium = otherTeachingMedium;
    }

    /**
     * @return the otherTeachingLevel
     */
    public String getOtherTeachingLevel() {
        return otherTeachingLevel;
    }

    /**
     * @param otherTeachingLevel the otherTeachingLevel to set
     */
    public void setOtherTeachingLevel(String otherTeachingLevel) {
        this.otherTeachingLevel = otherTeachingLevel;
    }

    /**
     * @return the preferenceToTeachingList
     */
    public String[] getPreferenceToTeachingList() {
        return preferenceToTeachingList;
    }

    /**
     * @param preferenceToTeachingList the preferenceToTeachingList to set
     */
    public void setPreferenceToTeachingList(String[] preferenceToTeachingList) {
        this.preferenceToTeachingList = preferenceToTeachingList;
    }

    /**
     * @return the teachingPatterenList
     */
    public String[] getTeachingPatterenList() {
        return teachingPatterenList;
    }

    /**
     * @param teachingPatterenList the teachingPatterenList to set
     */
    public void setTeachingPatterenList(String[] teachingPatterenList) {
        this.teachingPatterenList = teachingPatterenList;
    }

    /**
     * @return the tutoringOptionList
     */
    public String[] getTutoringOptionList() {
        return tutoringOptionList;
    }

    /**
     * @param tutoringOptionList the tutoringOptionList to set
     */
    public void setTutoringOptionList(String[] tutoringOptionList) {
        this.tutoringOptionList = tutoringOptionList;
    }

    /**
     * @return the teachingMediumLis
     */
    public String[] getTeachingMediumLis() {
        return teachingMediumLis;
    }

    /**
     * @param teachingMediumLis the teachingMediumLis to set
     */
    public void setTeachingMediumLis(String[] teachingMediumLis) {
        this.teachingMediumLis = teachingMediumLis;
    }

    /**
     * @return the teachingLevelList
     */
    public String[] getTeachingLevelList() {
        return teachingLevelList;
    }

    /**
     * @param teachingLevelList the teachingLevelList to set
     */
    public void setTeachingLevelList(String[] teachingLevelList) {
        this.teachingLevelList = teachingLevelList;
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
     * @return the tutorPostalCode
     */
    public String getTutorPostalCode() {
        return tutorPostalCode;
    }

    /**
     * @param tutorPostalCode the tutorPostalCode to set
     */
    public void setTutorPostalCode(String tutorPostalCode) {
        this.tutorPostalCode = tutorPostalCode;
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
     * @return the listOfTeachingLevel
     */
    public List<String> getListOfTeachingLevel() {
        return listOfTeachingLevel;
    }

    /**
     * @param listOfTeachingLevel the listOfTeachingLevel to set
     */
    public void setListOfTeachingLevel(List<String> listOfTeachingLevel) {
        this.listOfTeachingLevel = listOfTeachingLevel;
    }

    /**
     * @return the listOfTeachingSubjects
     */
    public List<String> getListOfTeachingSubjects() {
        return listOfTeachingSubjects;
    }

    /**
     * @param listOfTeachingSubjects the listOfTeachingSubjects to set
     */
    public void setListOfTeachingSubjects(List<String> listOfTeachingSubjects) {
        this.listOfTeachingSubjects = listOfTeachingSubjects;
    }

    /**
     * @return the listOfTeachingArena
     */
    public List<TutorTeachingArenaVO> getListOfTeachingArena() {
        return listOfTeachingArena;
    }

    /**
     * @param listOfTeachingArena the listOfTeachingArena to set
     */
    public void setListOfTeachingArena(List<TutorTeachingArenaVO> listOfTeachingArena) {
        this.listOfTeachingArena = listOfTeachingArena;
    }

    /**
     * @return the tutorCountryCode
     */
    public String getTutorCountryCode() {
        return tutorCountryCode;
    }

    /**
     * @param tutorCountryCode the tutorCountryCode to set
     */
    public void setTutorCountryCode(String tutorCountryCode) {
        this.tutorCountryCode = tutorCountryCode;
    }

    /**
     * @return the tutorCityLocationId
     */
    public String getTutorCityLocationId() {
        return tutorCityLocationId;
    }

    /**
     * @param tutorCityLocationId the tutorCityLocationId to set
     */
    public void setTutorCityLocationId(String tutorCityLocationId) {
        this.tutorCityLocationId = tutorCityLocationId;
    }

    /**
     * @return the documentVerificationFlag
     */
    public String getDocumentVerificationFlag() {
        return documentVerificationFlag;
    }

    /**
     * @param documentVerificationFlag the documentVerificationFlag to set
     */
    public void setDocumentVerificationFlag(String documentVerificationFlag) {
        this.documentVerificationFlag = documentVerificationFlag;
    }

    /**
     * @return the tutorTeachingLevel
     */
    public String getTutorTeachingLevel() {
        return tutorTeachingLevel;
    }

    /**
     * @param tutorTeachingLevel the tutorTeachingLevel to set
     */
    public void setTutorTeachingLevel(String tutorTeachingLevel) {
        this.tutorTeachingLevel = tutorTeachingLevel;
    }

    /**
     * @return the tutorTeachingParten
     */
    public String getTutorTeachingParten() {
        return tutorTeachingParten;
    }

    /**
     * @param tutorTeachingParten the tutorTeachingParten to set
     */
    public void setTutorTeachingParten(String tutorTeachingParten) {
        this.tutorTeachingParten = tutorTeachingParten;
    }

    /**
     * @return the tutorTeachingOption
     */
    public String getTutorTeachingOption() {
        return tutorTeachingOption;
    }

    /**
     * @param tutorTeachingOption the tutorTeachingOption to set
     */
    public void setTutorTeachingOption(String tutorTeachingOption) {
        this.tutorTeachingOption = tutorTeachingOption;
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
     * @return the teachingSubject
     */
    public String getTeachingSubject() {
        return teachingSubject;
    }

    /**
     * @param teachingSubject the teachingSubject to set
     */
    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    /**
     * @return the teachingSubjectList
     */
    public String[] getTeachingSubjectList() {
        return teachingSubjectList;
    }

    /**
     * @param teachingSubjectList the teachingSubjectList to set
     */
    public void setTeachingSubjectList(String[] teachingSubjectList) {
        this.teachingSubjectList = teachingSubjectList;
    }

    /**
     * @return the teachingBoardList
     */
    public String[] getTeachingBoardList() {
        return teachingBoardList;
    }

    /**
     * @param teachingBoardList the teachingBoardList to set
     */
    public void setTeachingBoardList(String[] teachingBoardList) {
        this.teachingBoardList = teachingBoardList;
    }

 
    
}
