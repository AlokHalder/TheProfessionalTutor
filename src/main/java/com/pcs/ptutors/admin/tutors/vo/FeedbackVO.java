/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pcs.ptutors.admin.tutors.vo;
/**
 *
 * @author Dipayan
 */
public class FeedbackVO implements java.io.Serializable  {

    private String feedbackId;
    private String name;
    private String email;
    private String comments;
    private String date;
    private String verificationFlag;

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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the feedbackId
     */
    public String getFeedbackId() {
        return feedbackId;
    }

    /**
     * @param feedbackId the feedbackId to set
     */
    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the verificationFlag
     */
    public String getVerificationFlag() {
        return verificationFlag;
    }

    /**
     * @param verificationFlag the verificationFlag to set
     */
    public void setVerificationFlag(String verificationFlag) {
        this.verificationFlag = verificationFlag;
    }



}
