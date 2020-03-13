/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.form;

import com.pcs.ptutors.vo.ListOfValuesVO;
import com.pcs.ptutors.vo.TutorRegistrationVO;
import java.util.List;
//import org.apache.struts.upload.FormFile;

/**
 *
 * @author ibm
 */
public class TutorProfileRegistrationActionForm{

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
    private String tutorPostalCode;
    private String tutorArea;
    private String tutorEmailId;
    private String tutorContactNumber;
    private String preferenceToTeaching;
    //private FormFile uploadImage;
    private String msg;

    private List<TutorRegistrationVO> listOfSubjectWiseTutor;
    private List<ListOfValuesVO> listOfSubjectSubCategory;
    private List<ListOfValuesVO> listOfTeachingMedium;
    private List<ListOfValuesVO> listOfSchoolBoard;   
    private List<ListOfValuesVO> listOfClassStandard;
    private List<ListOfValuesVO> listOfTeachingSegmentLevel;

    private List<ListOfValuesVO> listOfBasicUgCourses;
    private List<ListOfValuesVO> listOfBasicPgCourses;
    private List<ListOfValuesVO> listOfSubjects;
    private List<ListOfValuesVO> listOfUniversityInstitute;




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
     * @return the tutorContactNumber
     */
    public String getTutorContactNumber() {
        return tutorContactNumber;
    }

    /**
     * @param tutorContactNumber the tutorContactNumber to set
     */
    public void setTutorContactNumber(String tutorContactNumber) {
        this.tutorContactNumber = tutorContactNumber;
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
     * @return the listOfSubjectWiseTutor
     */
    public List<TutorRegistrationVO> getListOfSubjectWiseTutor() {
        return listOfSubjectWiseTutor;
    }

    /**
     * @param listOfSubjectWiseTutor the listOfSubjectWiseTutor to set
     */
    public void setListOfSubjectWiseTutor(List<TutorRegistrationVO> listOfSubjectWiseTutor) {
        this.listOfSubjectWiseTutor = listOfSubjectWiseTutor;
    }

    /**
     * @return the listOfSubjectSubCategory
     */
    public List<ListOfValuesVO> getListOfSubjectSubCategory() {
        return listOfSubjectSubCategory;
    }

    /**
     * @param listOfSubjectSubCategory the listOfSubjectSubCategory to set
     */
    public void setListOfSubjectSubCategory(List<ListOfValuesVO> listOfSubjectSubCategory) {
        this.listOfSubjectSubCategory = listOfSubjectSubCategory;
    }

    /**
     * @return the listOfTeachingMedium
     */
    public List<ListOfValuesVO> getListOfTeachingMedium() {
        return listOfTeachingMedium;
    }

    /**
     * @param listOfTeachingMedium the listOfTeachingMedium to set
     */
    public void setListOfTeachingMedium(List<ListOfValuesVO> listOfTeachingMedium) {
        this.listOfTeachingMedium = listOfTeachingMedium;
    }

    /**
     * @return the listOfSchoolBoard
     */
    public List<ListOfValuesVO> getListOfSchoolBoard() {
        return listOfSchoolBoard;
    }

    /**
     * @param listOfSchoolBoard the listOfSchoolBoard to set
     */
    public void setListOfSchoolBoard(List<ListOfValuesVO> listOfSchoolBoard) {
        this.listOfSchoolBoard = listOfSchoolBoard;
    }

    /**
     * @return the listOfUniversityInstitute
     */
    public List<ListOfValuesVO> getListOfUniversityInstitute() {
        return listOfUniversityInstitute;
    }

   

    /**
     * @return the listOfClassStandard
     */
    public List<ListOfValuesVO> getListOfClassStandard() {
        return listOfClassStandard;
    }

    /**
     * @param listOfClassStandard the listOfClassStandard to set
     */
    public void setListOfClassStandard(List<ListOfValuesVO> listOfClassStandard) {
        this.listOfClassStandard = listOfClassStandard;
    }

    /**
     * @return the listOfTeachingSegmentLevel
     */
    public List<ListOfValuesVO> getListOfTeachingSegmentLevel() {
        return listOfTeachingSegmentLevel;
    }

    /**
     * @param listOfTeachingSegmentLevel the listOfTeachingSegmentLevel to set
     */
    public void setListOfTeachingSegmentLevel(List<ListOfValuesVO> listOfTeachingSegmentLevel) {
        this.listOfTeachingSegmentLevel = listOfTeachingSegmentLevel;
    }

    /**
     * @return the listOfBasicUgCourses
     */
    public List<ListOfValuesVO> getListOfBasicUgCourses() {
        return listOfBasicUgCourses;
    }

    /**
     * @return the listOfBasicPgCourses
     */
    public List<ListOfValuesVO> getListOfBasicPgCourses() {
        return listOfBasicPgCourses;
    }

    /**
     * @return the listOfSubjects
     */
    public List<ListOfValuesVO> getListOfSubjects() {
        return listOfSubjects;
    }

    /**
     * @param listOfBasicUgCourses the listOfBasicUgCourses to set
     */
    public void setListOfBasicUgCourses(List<ListOfValuesVO> listOfBasicUgCourses) {
        this.listOfBasicUgCourses = listOfBasicUgCourses;
    }

    /**
     * @param listOfBasicPgCourses the listOfBasicPgCourses to set
     */
    public void setListOfBasicPgCourses(List<ListOfValuesVO> listOfBasicPgCourses) {
        this.listOfBasicPgCourses = listOfBasicPgCourses;
    }

    /**
     * @param listOfSubjects the listOfSubjects to set
     */
    public void setListOfSubjects(List<ListOfValuesVO> listOfSubjects) {
        this.listOfSubjects = listOfSubjects;
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
     * @return the uploadImage
     */
   /* public FormFile getUploadImage() {
        return uploadImage;
    }

    *//**
     * @param uploadImage the uploadImage to set
     *//*
    public void setUploadImage(FormFile uploadImage) {
        this.uploadImage = uploadImage;
    }*/

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    

}
