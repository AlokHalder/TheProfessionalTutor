package com.pcs.ptutors.model;

import org.hibernate.validator.constraints.NotEmpty;

public class studentRegistration {

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
	    private String age;
	    private String sex;
	    private String tutionTitle;
	    private String tutionRequirement;
	    private String tutionRemarks;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUserLoginName() {
			return userLoginName;
		}
		public void setUserLoginName(String userLoginName) {
			this.userLoginName = userLoginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSecretQuestion() {
			return secretQuestion;
		}
		public void setSecretQuestion(String secretQuestion) {
			this.secretQuestion = secretQuestion;
		}
		public String getSecretQuestionAnswer() {
			return secretQuestionAnswer;
		}
		public void setSecretQuestionAnswer(String secretQuestionAnswer) {
			this.secretQuestionAnswer = secretQuestionAnswer;
		}
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
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
		public String getSchoolOrBoard() {
			return schoolOrBoard;
		}
		public void setSchoolOrBoard(String schoolOrBoard) {
			this.schoolOrBoard = schoolOrBoard;
		}
		public String getSchoolOrBoardId() {
			return schoolOrBoardId;
		}
		public void setSchoolOrBoardId(String schoolOrBoardId) {
			this.schoolOrBoardId = schoolOrBoardId;
		}
		public String getOtherSchoolOrBoard() {
			return otherSchoolOrBoard;
		}
		public void setOtherSchoolOrBoard(String otherSchoolOrBoard) {
			this.otherSchoolOrBoard = otherSchoolOrBoard;
		}
		public String getUniversityOrInstitute() {
			return universityOrInstitute;
		}
		public void setUniversityOrInstitute(String universityOrInstitute) {
			this.universityOrInstitute = universityOrInstitute;
		}
		public String getUniversityOrInstituteId() {
			return universityOrInstituteId;
		}
		public void setUniversityOrInstituteId(String universityOrInstituteId) {
			this.universityOrInstituteId = universityOrInstituteId;
		}
		public String getOtherUniversityOrInstitute() {
			return otherUniversityOrInstitute;
		}
		public void setOtherUniversityOrInstitute(String otherUniversityOrInstitute) {
			this.otherUniversityOrInstitute = otherUniversityOrInstitute;
		}
		public String getClassstandard() {
			return classstandard;
		}
		public void setClassstandard(String classstandard) {
			this.classstandard = classstandard;
		}
		public String getClassstandardId() {
			return classstandardId;
		}
		public void setClassstandardId(String classstandardId) {
			this.classstandardId = classstandardId;
		}
		public String getOtherClassstandard() {
			return otherClassstandard;
		}
		public void setOtherClassstandard(String otherClassstandard) {
			this.otherClassstandard = otherClassstandard;
		}
		public String getMedium() {
			return medium;
		}
		public void setMedium(String medium) {
			this.medium = medium;
		}
		public String getMediumId() {
			return mediumId;
		}
		public void setMediumId(String mediumId) {
			this.mediumId = mediumId;
		}
		public String getOtherMedium() {
			return otherMedium;
		}
		public void setOtherMedium(String otherMedium) {
			this.otherMedium = otherMedium;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getTutionRequirementId() {
			return tutionRequirementId;
		}
		public void setTutionRequirementId(String tutionRequirementId) {
			this.tutionRequirementId = tutionRequirementId;
		}
		public String getOtherSubject() {
			return otherSubject;
		}
		public void setOtherSubject(String otherSubject) {
			this.otherSubject = otherSubject;
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
		public String getCountryName() {
			return countryName;
		}
		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}
		public String getCityName() {
			return cityName;
		}
		public void setCityName(String cityName) {
			this.cityName = cityName;
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
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
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
		public String getTutionTitle() {
			return tutionTitle;
		}
		public void setTutionTitle(String tutionTitle) {
			this.tutionTitle = tutionTitle;
		}
		public String getTutionRequirement() {
			return tutionRequirement;
		}
		public void setTutionRequirement(String tutionRequirement) {
			this.tutionRequirement = tutionRequirement;
		}
		public String getTutionRemarks() {
			return tutionRemarks;
		}
		public void setTutionRemarks(String tutionRemarks) {
			this.tutionRemarks = tutionRemarks;
		}
	    
}
