/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.careercafe.vo;

import java.io.Serializable;

/**
 *
 * @author ALOK
 */
public class CareerCafeQuestionVO implements Serializable{
    private String memberId;
    private String careerQuestionId;
    private String careerQuestion;
    private String careerQuestionPostedBy;
    private String careerQuestionAnswer;
    private String careerQuestionPostedTime;
    private String careerQuestionRepliedBy;
    private String careerQuestionRepliedTime;



    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the careerQuestionId
     */
    public String getCareerQuestionId() {
        return careerQuestionId;
    }

    /**
     * @param careerQuestionId the careerQuestionId to set
     */
    public void setCareerQuestionId(String careerQuestionId) {
        this.careerQuestionId = careerQuestionId;
    }

    /**
     * @return the careerQuestion
     */
    public String getCareerQuestion() {
        return careerQuestion;
    }

    /**
     * @param careerQuestion the careerQuestion to set
     */
    public void setCareerQuestion(String careerQuestion) {
        this.careerQuestion = careerQuestion;
    }

    /**
     * @return the careerQuestionAnswer
     */
    public String getCareerQuestionAnswer() {
        return careerQuestionAnswer;
    }

    /**
     * @param careerQuestionAnswer the careerQuestionAnswer to set
     */
    public void setCareerQuestionAnswer(String careerQuestionAnswer) {
        this.careerQuestionAnswer = careerQuestionAnswer;
    }

    /**
     * @return the careerQuestionPostedTime
     */
    public String getCareerQuestionPostedTime() {
        return careerQuestionPostedTime;
    }

    /**
     * @param careerQuestionPostedTime the careerQuestionPostedTime to set
     */
    public void setCareerQuestionPostedTime(String careerQuestionPostedTime) {
        this.careerQuestionPostedTime = careerQuestionPostedTime;
    }

    /**
     * @return the careerQuestionRepliedBy
     */
    public String getCareerQuestionRepliedBy() {
        return careerQuestionRepliedBy;
    }

    /**
     * @param careerQuestionRepliedBy the careerQuestionRepliedBy to set
     */
    public void setCareerQuestionRepliedBy(String careerQuestionRepliedBy) {
        this.careerQuestionRepliedBy = careerQuestionRepliedBy;
    }

    /**
     * @return the careerQuestionRepliedTime
     */
    public String getCareerQuestionRepliedTime() {
        return careerQuestionRepliedTime;
    }

    /**
     * @param careerQuestionRepliedTime the careerQuestionRepliedTime to set
     */
    public void setCareerQuestionRepliedTime(String careerQuestionRepliedTime) {
        this.careerQuestionRepliedTime = careerQuestionRepliedTime;
    }

    /**
     * @return the careerQuestionPostedBy
     */
    public String getCareerQuestionPostedBy() {
        return careerQuestionPostedBy;
    }

    /**
     * @param careerQuestionPostedBy the careerQuestionPostedBy to set
     */
    public void setCareerQuestionPostedBy(String careerQuestionPostedBy) {
        this.careerQuestionPostedBy = careerQuestionPostedBy;
    }


}
