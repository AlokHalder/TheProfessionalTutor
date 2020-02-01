package com.pcs.ptutors.admin.tutors.vo;
import java.io.Serializable;

/**
 *
 * @author ibm
 */
public class StudentRegistrationVO implements Serializable {
    
    private String email;
    private String userLoginName;
    private String password;
    private String secretQuestion;
    private String secretQuestionAnswer;
    private String studentId;
    private String name;
    private String guardianname;
    private String schoolOrBoard;
    private String schoolOrBoardId;
    private String universityOrInstitute;
    private String classstandard;
    private String medium;
    private String subject;
    private String address;
    private String address2;
    private String countryName;
    private String cityName;
    private String area;
    private String landmark;
    private String pin;
    private String contactNumber;
    private String calltime;    
    private String age;
    private String sex;
    private String tutionTitle;
    private String tutionRequirement;
    private String segmentLevel;
    private String tutionRemarks;
    private boolean imageFlag;
    private String memberStatus;
    private String profileverification;
    private String registrationDate;

    private String membershipCategory;
    private String duration;
    private String paymentMode;
    private String paymentAmount;
    private String membershipBegindate;
    private String membershipExpireWarningDate;
    private String membershipExpiredate;

    private String secretquestionid;
    private String countrycode;
    private String locationid;
    private String universityinstituteid;
    private String educationsegmentid;
    private String mediumid;
    private String tutionrequiredsubjectid;
    private String tutionsegmentid;


    


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    

    public String getClassstandard() {
        return classstandard;
    }

    public void setClassstandard(String classstandard) {
        this.classstandard = classstandard;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCalltime() {
        return calltime;
    }

    public void setCalltime(String calltime) {
        this.calltime = calltime;
    }

   

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

   
  

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
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
     * @return the secretQuestion
     */
    public String getSecretQuestion() {
        return secretQuestion;
    }

    /**
     * @param secretQuestion the secretQuestion to set
     */
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
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
     * @return the secretQuestionAnswer
     */
    public String getSecretQuestionAnswer() {
        return secretQuestionAnswer;
    }

    /**
     * @param secretQuestionAnswer the secretQuestionAnswer to set
     */
    public void setSecretQuestionAnswer(String secretQuestionAnswer) {
        this.secretQuestionAnswer = secretQuestionAnswer;
    }

    /**
     * @return the schoolOrBoard
     */
    public String getSchoolOrBoard() {
        return schoolOrBoard;
    }

    /**
     * @param schoolOrBoard the schoolOrBoard to set
     */
    public void setSchoolOrBoard(String schoolOrBoard) {
        this.schoolOrBoard = schoolOrBoard;
    }

    /**
     * @return the universityOrInstitute
     */
    public String getUniversityOrInstitute() {
        return universityOrInstitute;
    }

    /**
     * @param universityOrInstitute the universityOrInstitute to set
     */
    public void setUniversityOrInstitute(String universityOrInstitute) {
        this.universityOrInstitute = universityOrInstitute;
    }

    /**
     * @return the tutionTitle
     */
    public String getTutionTitle() {
        return tutionTitle;
    }

    /**
     * @param tutionTitle the tutionTitle to set
     */
    public void setTutionTitle(String tutionTitle) {
        this.tutionTitle = tutionTitle;
    }

    /**
     * @return the tutionRequirement
     */
    public String getTutionRequirement() {
        return tutionRequirement;
    }

    /**
     * @param tutionRequirement the tutionRequirement to set
     */
    public void setTutionRequirement(String tutionRequirement) {
        this.tutionRequirement = tutionRequirement;
    }

    /**
     * @return the segmentLevel
     */
    public String getSegmentLevel() {
        return segmentLevel;
    }

    /**
     * @param segmentLevel the segmentLevel to set
     */
    public void setSegmentLevel(String segmentLevel) {
        this.segmentLevel = segmentLevel;
    }

    /**
     * @return the tutionRemarks
     */
    public String getTutionRemarks() {
        return tutionRemarks;
    }

    /**
     * @param tutionRemarks the tutionRemarks to set
     */
    public void setTutionRemarks(String tutionRemarks) {
        this.tutionRemarks = tutionRemarks;
    }

    /**
     * @return the memberStatus
     */
    public String getMemberStatus() {
        return memberStatus;
    }

    /**
     * @param memberStatus the memberStatus to set
     */
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
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
     * @return the secretquestionid
     */
    public String getSecretquestionid() {
        return secretquestionid;
    }

    /**
     * @param secretquestionid the secretquestionid to set
     */
    public void setSecretquestionid(String secretquestionid) {
        this.secretquestionid = secretquestionid;
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
     * @return the universityinstituteid
     */
    public String getUniversityinstituteid() {
        return universityinstituteid;
    }

    /**
     * @param universityinstituteid the universityinstituteid to set
     */
    public void setUniversityinstituteid(String universityinstituteid) {
        this.universityinstituteid = universityinstituteid;
    }

    /**
     * @return the educationsegmentid
     */
    public String getEducationsegmentid() {
        return educationsegmentid;
    }

    /**
     * @param educationsegmentid the educationsegmentid to set
     */
    public void setEducationsegmentid(String educationsegmentid) {
        this.educationsegmentid = educationsegmentid;
    }

    /**
     * @return the mediumid
     */
    public String getMediumid() {
        return mediumid;
    }

    /**
     * @param mediumid the mediumid to set
     */
    public void setMediumid(String mediumid) {
        this.mediumid = mediumid;
    }

    /**
     * @return the tutionrequiredsubjectid
     */
    public String getTutionrequiredsubjectid() {
        return tutionrequiredsubjectid;
    }

    /**
     * @param tutionrequiredsubjectid the tutionrequiredsubjectid to set
     */
    public void setTutionrequiredsubjectid(String tutionrequiredsubjectid) {
        this.tutionrequiredsubjectid = tutionrequiredsubjectid;
    }

    /**
     * @return the tutionsegmentid
     */
    public String getTutionsegmentid() {
        return tutionsegmentid;
    }

    /**
     * @param tutionsegmentid the tutionsegmentid to set
     */
    public void setTutionsegmentid(String tutionsegmentid) {
        this.tutionsegmentid = tutionsegmentid;
    }

    /**
     * @return the schoolOrBoardId
     */
    public String getSchoolOrBoardId() {
        return schoolOrBoardId;
    }

    /**
     * @param schoolOrBoardId the schoolOrBoardId to set
     */
    public void setSchoolOrBoardId(String schoolOrBoardId) {
        this.schoolOrBoardId = schoolOrBoardId;
    }




}








