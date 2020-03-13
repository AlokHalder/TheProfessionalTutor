/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.form;

import com.pcs.ptutors.vo.ListOfValuesVO;
import java.util.List;


/**
 *
 * @author ALOK
 */
public class TutorTutoringProcedureActionForm{
    
    private String tutorId;
    private String qualifyingDegree;
    private String boardOrUniversity;
    private String tutoringExperience;
    private String tutorYearsOfExperience;
    private String tutorMonthsOfExperience;
    private String feeExpected;
    private String tutoringOptions;
    private String[] tutoringOptionsList;
    private String tutoringProcedure;
    private String teachingMedium;
    private String[] teachingMediumList;
    private String mainsubject;
    private String teachingLevel;
    private String[] teachingLevelList;
    private String tutoringApproach;
    private String tutorRegistrationDate;
    private boolean imageFlag;

    private String tutorTeachingPatteren;
    private String[] tutorTeachingPatterenList;
    //  private FormFile  uploadImage;
    private String registrationDate;
    private String preferredTutoringArea;
     private String otherPreferenceToTeaching;
    private String otherTutorTeachingPatteren;
    private String otherTutoringOptions;
    private String otherTeachingMedium;
    private String otherTeachingLevel;

    private String preferenceToTeaching;
    private String[] preferenceToTeachingList;

    private List<ListOfValuesVO> listOfSubjectSubCategory;
    private List<ListOfValuesVO> listOfEducationSegmentLevel;
    private List<ListOfValuesVO> listOfLocation;


    /**
     * @return the qualifyingDegree
     */
    public String getQualifyingDegree() {
        return qualifyingDegree;
    }

    /**
     * @param qualifyingDegree the qualifyingDegree to set
     */
    public void setQualifyingDegree(String qualifyingDegree) {
        this.qualifyingDegree = qualifyingDegree;
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
     * @return the tutoringOptionsList
     */
    public String[] getTutoringOptionsList() {
        return tutoringOptionsList;
    }

    /**
     * @param tutoringOptionsList the tutoringOptionsList to set
     */
    public void setTutoringOptionsList(String[] tutoringOptionsList) {
        this.tutoringOptionsList = tutoringOptionsList;
    }

    /**
     * @return the tutoringProcedure
     */
    public String getTutoringProcedure() {
        return tutoringProcedure;
    }

    /**
     * @param tutoringProcedure the tutoringProcedure to set
     */
    public void setTutoringProcedure(String tutoringProcedure) {
        this.tutoringProcedure = tutoringProcedure;
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
     * @return the teachingMediumList
     */
    public String[] getTeachingMediumList() {
        return teachingMediumList;
    }

    /**
     * @param teachingMediumList the teachingMediumList to set
     */
    public void setTeachingMediumList(String[] teachingMediumList) {
        this.teachingMediumList = teachingMediumList;
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
     * @return the tutorTeachingPatterenList
     */
    public String[] getTutorTeachingPatterenList() {
        return tutorTeachingPatterenList;
    }

    /**
     * @param tutorTeachingPatterenList the tutorTeachingPatterenList to set
     */
    public void setTutorTeachingPatterenList(String[] tutorTeachingPatterenList) {
        this.tutorTeachingPatterenList = tutorTeachingPatterenList;
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
     * @return the listOfEducationSegmentLevel
     */
    public List<ListOfValuesVO> getListOfEducationSegmentLevel() {
        return listOfEducationSegmentLevel;
    }

    /**
     * @param listOfEducationSegmentLevel the listOfEducationSegmentLevel to set
     */
    public void setListOfEducationSegmentLevel(List<ListOfValuesVO> listOfEducationSegmentLevel) {
        this.listOfEducationSegmentLevel = listOfEducationSegmentLevel;
    }

    /**
     * @return the listOfLocation
     */
    public List<ListOfValuesVO> getListOfLocation() {
        return listOfLocation;
    }

    /**
     * @param listOfLocation the listOfLocation to set
     */
    public void setListOfLocation(List<ListOfValuesVO> listOfLocation) {
        this.listOfLocation = listOfLocation;
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

    


}
