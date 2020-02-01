/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.vo;

/**
 *
 * @author Dipayan
 */
public class FeedbackVO implements java.io.Serializable  {

    private String personName;
    private String emailAddress;
    private String comments;
    private String feedbackVerificationFlag;

    /**
     * @return the personName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * @param personName the personName to set
     */
    public void setPersonName(String personName) {
        this.personName = personName;
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
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the feedbackVerificationFlag
     */
    public String getFeedbackVerificationFlag() {
        return feedbackVerificationFlag;
    }

    /**
     * @param feedbackVerificationFlag the feedbackVerificationFlag to set
     */
    public void setFeedbackVerificationFlag(String feedbackVerificationFlag) {
        this.feedbackVerificationFlag = feedbackVerificationFlag;
    }

   



}
