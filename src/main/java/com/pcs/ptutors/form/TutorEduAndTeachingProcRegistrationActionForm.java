/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.form;

import com.pcs.ptutors.vo.ListOfValuesVO;
import java.util.List;



/**
 *
 * @author ibm
 */
public class TutorEduAndTeachingProcRegistrationActionForm{

    private String tutorId;

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
    private String[] teachingSubjects;
    private  String[] teachingBoards;

    public String[] getTeachingSubjects() {
        return teachingSubjects;
    }

    public void setTeachingSubjects(String[] teachingSubjects) {
        this.teachingSubjects = teachingSubjects;
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

    /**
     * @return the teachingBoards
     */
    public String[] getTeachingBoards() {
        return teachingBoards;
    }

    /**
     * @param teachingBoards the teachingBoards to set
     */
    public void setTeachingBoards(String[] teachingBoards) {
        this.teachingBoards = teachingBoards;
    }

    

}
