package com.pcs.ptutors.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ibm
 */
public class StudentRegistrationVO implements Serializable {
    
    private String email;
    private String userLoginName;
    private String password;
    private String secretQuestion;
    @NotEmpty
    private String secretQuestionAnswer;
    private String studentId;
    private String name;
    private String guardianname;
    private String schoolOrBoard;
    private String schoolOrBoardId;
    private String otherSchoolOrBoard;
    private String universityOrInstitute;
    private String universityOrInstituteId;
    private String otherUniversityOrInstitute;
    private String classstandard;
    private String classstandardId;
    private String otherClassstandard;
    private String medium;
    private String mediumId;
    private String otherMedium;
    private String subject;
    private String tutionRequirementId;
    private String otherSubject;
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
    private String otherTutitonRequirement;
    private String segmentLevel;
    private String segmentLevelId;
    private String otherSegmentLevel;
    private String tutionRemarks;
    private boolean imageFlag;
    private String memberStatus;
    private String registrationDate;
    private String profileVerificationStatus;
    private String profileActiveDeactiveStatus;
    private String membershipCategory;
    private String duration;
    private String modeOfPayment;
    private String paymentAmount;
    private String membershipBeginDate;
    private String membershipExpireWarningDate;
    private String membershipExpireDate;
    
    private String newPassword;
    private String cityCode;
    private String photoFileName;

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
     * @return the guardianname
     */
    public String getGuardianname() {
        return guardianname;
    }

    /**
     * @param guardianname the guardianname to set
     */
    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
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
     * @return the otherSchoolOrBoard
     */
    public String getOtherSchoolOrBoard() {
        return otherSchoolOrBoard;
    }

    /**
     * @param otherSchoolOrBoard the otherSchoolOrBoard to set
     */
    public void setOtherSchoolOrBoard(String otherSchoolOrBoard) {
        this.otherSchoolOrBoard = otherSchoolOrBoard;
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
     * @return the otherUniversityOrInstitute
     */
    public String getOtherUniversityOrInstitute() {
        return otherUniversityOrInstitute;
    }

    /**
     * @param otherUniversityOrInstitute the otherUniversityOrInstitute to set
     */
    public void setOtherUniversityOrInstitute(String otherUniversityOrInstitute) {
        this.otherUniversityOrInstitute = otherUniversityOrInstitute;
    }

    /**
     * @return the classstandard
     */
    public String getClassstandard() {
        return classstandard;
    }

    /**
     * @param classstandard the classstandard to set
     */
    public void setClassstandard(String classstandard) {
        this.classstandard = classstandard;
    }

    /**
     * @return the otherClassstandard
     */
    public String getOtherClassstandard() {
        return otherClassstandard;
    }

    /**
     * @param otherClassstandard the otherClassstandard to set
     */
    public void setOtherClassstandard(String otherClassstandard) {
        this.otherClassstandard = otherClassstandard;
    }

    /**
     * @return the medium
     */
    public String getMedium() {
        return medium;
    }

    /**
     * @param medium the medium to set
     */
    public void setMedium(String medium) {
        this.medium = medium;
    }

    /**
     * @return the otherMedium
     */
    public String getOtherMedium() {
        return otherMedium;
    }

    /**
     * @param otherMedium the otherMedium to set
     */
    public void setOtherMedium(String otherMedium) {
        this.otherMedium = otherMedium;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the otherSubject
     */
    public String getOtherSubject() {
        return otherSubject;
    }

    /**
     * @param otherSubject the otherSubject to set
     */
    public void setOtherSubject(String otherSubject) {
        this.otherSubject = otherSubject;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
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
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the landmark
     */
    public String getLandmark() {
        return landmark;
    }

    /**
     * @param landmark the landmark to set
     */
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    /**
     * @return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
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
     * @return the calltime
     */
    public String getCalltime() {
        return calltime;
    }

    /**
     * @param calltime the calltime to set
     */
    public void setCalltime(String calltime) {
        this.calltime = calltime;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
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
     * @return the otherTutitonRequirement
     */
    public String getOtherTutitonRequirement() {
        return otherTutitonRequirement;
    }

    /**
     * @param otherTutitonRequirement the otherTutitonRequirement to set
     */
    public void setOtherTutitonRequirement(String otherTutitonRequirement) {
        this.otherTutitonRequirement = otherTutitonRequirement;
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
     * @return the otherSegmentLevel
     */
    public String getOtherSegmentLevel() {
        return otherSegmentLevel;
    }

    /**
     * @param otherSegmentLevel the otherSegmentLevel to set
     */
    public void setOtherSegmentLevel(String otherSegmentLevel) {
        this.otherSegmentLevel = otherSegmentLevel;
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
     * @return the profileVerificationStatus
     */
    public String getProfileVerificationStatus() {
        return profileVerificationStatus;
    }

    /**
     * @param profileVerificationStatus the profileVerificationStatus to set
     */
    public void setProfileVerificationStatus(String profileVerificationStatus) {
        this.profileVerificationStatus = profileVerificationStatus;
    }

    /**
     * @return the profileActiveDeactiveStatus
     */
    public String getProfileActiveDeactiveStatus() {
        return profileActiveDeactiveStatus;
    }

    /**
     * @param profileActiveDeactiveStatus the profileActiveDeactiveStatus to set
     */
    public void setProfileActiveDeactiveStatus(String profileActiveDeactiveStatus) {
        this.profileActiveDeactiveStatus = profileActiveDeactiveStatus;
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
     * @return the modeOfPayment
     */
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    /**
     * @param modeOfPayment the modeOfPayment to set
     */
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
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
     * @return the membershipBeginDate
     */
    public String getMembershipBeginDate() {
        return membershipBeginDate;
    }

    /**
     * @param membershipBeginDate the membershipBeginDate to set
     */
    public void setMembershipBeginDate(String membershipBeginDate) {
        this.membershipBeginDate = membershipBeginDate;
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
     * @return the membershipExpireDate
     */
    public String getMembershipExpireDate() {
        return membershipExpireDate;
    }

    /**
     * @param membershipExpireDate the membershipExpireDate to set
     */
    public void setMembershipExpireDate(String membershipExpireDate) {
        this.membershipExpireDate = membershipExpireDate;
    }

    /**
     * @return the classstandardId
     */
    public String getClassstandardId() {
        return classstandardId;
    }

    /**
     * @param classstandardId the classstandardId to set
     */
    public void setClassstandardId(String classstandardId) {
        this.classstandardId = classstandardId;
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

    /**
     * @return the universityOrInstituteId
     */
    public String getUniversityOrInstituteId() {
        return universityOrInstituteId;
    }

    /**
     * @param universityOrInstituteId the universityOrInstituteId to set
     */
    public void setUniversityOrInstituteId(String universityOrInstituteId) {
        this.universityOrInstituteId = universityOrInstituteId;
    }

    /**
     * @return the mediumId
     */
    public String getMediumId() {
        return mediumId;
    }

    /**
     * @param mediumId the mediumId to set
     */
    public void setMediumId(String mediumId) {
        this.mediumId = mediumId;
    }

    /**
     * @return the tutionRequirementId
     */
    public String getTutionRequirementId() {
        return tutionRequirementId;
    }

    /**
     * @param tutionRequirementId the tutionRequirementId to set
     */
    public void setTutionRequirementId(String tutionRequirementId) {
        this.tutionRequirementId = tutionRequirementId;
    }

    /**
     * @return the segmentLevelId
     */
    public String getSegmentLevelId() {
        return segmentLevelId;
    }

    /**
     * @param segmentLevelId the segmentLevelId to set
     */
    public void setSegmentLevelId(String segmentLevelId) {
        this.segmentLevelId = segmentLevelId;
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
     * @return the cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode the cityCode to set
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return the photoFileName
     */
    public String getPhotoFileName() {
        return photoFileName;
    }

    /**
     * @param photoFileName the photoFileName to set
     */
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

 


}
