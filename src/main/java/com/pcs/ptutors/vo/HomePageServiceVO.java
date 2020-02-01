/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcs.ptutors.vo;

import com.pcs.ptutors.careercafe.vo.CareerCafeQuestionVO;
import com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO;
import java.util.*;

/**
 *
 * @author ALOK
 */
public class HomePageServiceVO {

    private List<StudentRegistrationVO> listOfInstantTutorRequirements;
    private List<TutorRegistrationVO> listOfResentRegisteredTutor;
    private List<CareerCafeQuestionVO> careerCafeQuestionList;
    private List<TutorialCenterDataVO> listOfResentRegisteredInstitutes;
    private String viewCounter;
    private String weeklyMessage;


    /**
     * @return the listOfResentRegisteredTutor
     */
    public List<TutorRegistrationVO> getListOfResentRegisteredTutor() {
        return listOfResentRegisteredTutor;
    }

    /**
     * @param listOfResentRegisteredTutor the listOfResentRegisteredTutor to set
     */
    public void setListOfResentRegisteredTutor(List<TutorRegistrationVO> listOfResentRegisteredTutor) {
        this.listOfResentRegisteredTutor = listOfResentRegisteredTutor;
    }

    /**
     * @return the viewCounter
     */
    public String getViewCounter() {
        return viewCounter;
    }

    /**
     * @param viewCounter the viewCounter to set
     */
    public void setViewCounter(String viewCounter) {
        this.viewCounter = viewCounter;
    }

    /**
     * @return the listOfInstantTutorRequirements
     */
    public List<StudentRegistrationVO> getListOfInstantTutorRequirements() {
        return listOfInstantTutorRequirements;
    }

    /**
     * @param listOfInstantTutorRequirements the listOfInstantTutorRequirements to set
     */
    public void setListOfInstantTutorRequirements(List<StudentRegistrationVO> listOfInstantTutorRequirements) {
        this.listOfInstantTutorRequirements = listOfInstantTutorRequirements;
    }

    /**
     * @return the careerCafeQuestionList
     */
    public List<CareerCafeQuestionVO> getCareerCafeQuestionList() {
        return careerCafeQuestionList;
    }

    /**
     * @param careerCafeQuestionList the careerCafeQuestionList to set
     */
    public void setCareerCafeQuestionList(List<CareerCafeQuestionVO> careerCafeQuestionList) {
        this.careerCafeQuestionList = careerCafeQuestionList;
    }

    /**
     * @return the weeklyMessage
     */
    public String getWeeklyMessage() {
        return weeklyMessage;
    }

    /**
     * @param weeklyMessage the weeklyMessage to set
     */
    public void setWeeklyMessage(String weeklyMessage) {
        this.weeklyMessage = weeklyMessage;
    }

    /**
     * @return the listOfResentRegisteredInstitutes
     */
    public List<TutorialCenterDataVO> getListOfResentRegisteredInstitutes() {
        return listOfResentRegisteredInstitutes;
    }

    /**
     * @param listOfResentRegisteredInstitutes the listOfResentRegisteredInstitutes to set
     */
    public void setListOfResentRegisteredInstitutes(List<TutorialCenterDataVO> listOfResentRegisteredInstitutes) {
        this.listOfResentRegisteredInstitutes = listOfResentRegisteredInstitutes;
    }
}
