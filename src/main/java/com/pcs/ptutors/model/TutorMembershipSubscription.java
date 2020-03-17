package com.pcs.ptutors.model;

public class TutorMembershipSubscription {

	 private String userId; 
	    private String userLoginName;
	    private String password;
	    private String emailAddress;
	    private String membershipCategory;
	    private String duration;
	    private String paymentMode;
	    private String paymentAmount;
	    private String membershipBegindate;
	    private String membershipExpireWarningDate;
	    private String membershipExpiredate;



	    /**
	     * @return the userId
	     */
	    public String getUserId() {
	        return userId;
	    }

	    /**
	     * @param userId the userId to set
	     */
	    public void setUserId(String userId) {
	        this.userId = userId;
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
}
