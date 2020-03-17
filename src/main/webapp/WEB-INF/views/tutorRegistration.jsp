<%@page import="java.util.List"%>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO"%>
<%@page import="com.pcs.ptutors.model.LovDataService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
    function showHideOtherTutionRequirementSubject(subjectId)
    {
        var subjectId = document.getElementById(subjectId).value;
        if(subjectId == 'Other'){
            document.getElementById('subjectTextDiv').style.display = 'block';
          
        }else{
            document.getElementById('subjectTextDiv').style.display = 'none';
            // document.getElementById(openBoxId).style.visibility = 'hidden';
        }

        return false;
    }

    function showHideOtherTeachingSegmentLevel(teachingLevelId){
        var teachingLevelId = document.getElementById(teachingLevelId).value;
        if(teachingLevelId=='Other'){
            document.getElementById('otherTeachingLevelId').style.display = 'block';
        }else{
            document.getElementById('otherTeachingLevelId').style.display = 'none';
        }
        return false;
    }

    function  showHideOtherTeachingMedium(teachingMediumId){
        var teachingMediumId = document.getElementById(teachingMediumId).value;
        if(teachingMediumId=='Other'){
            document.getElementById('otherTeachingMediumId').style.display = 'block';
        }else{
            document.getElementById('otherTeachingMediumId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutorTeachingPatteren(tutorTeachingPatterenId){
        var tutorTeachingPatterenId = document.getElementById(tutorTeachingPatterenId).value;
        if(tutorTeachingPatterenId=='Other'){
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'block';
        }else{
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutoringOptions(tutoringOptionsId){
        var tutoringOptionsId = document.getElementById(tutoringOptionsId).value;
        if(tutoringOptionsId=='Other'){
            document.getElementById('otherTutoringOptionsId').style.display = 'block';
        }else{
            document.getElementById('otherTutoringOptionsId').style.display = 'none';
        }
        return false;
    }
    
    function showHideOtherUgBoardOrUniversity(ugBoardOrUniversityId){
        var ugBoardOrUniversityId = document.getElementById(ugBoardOrUniversityId).value;
        if(ugBoardOrUniversityId=='Other'){
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'block';
        }else{
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgSpecialization(ugSpecializationId){
        var ugSpecializationId = document.getElementById(ugSpecializationId).value;
        if(ugSpecializationId=='Other'){
            document.getElementById('otherUgSpecializationId').style.display = 'block';
        }else{
            document.getElementById('otherUgSpecializationId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgQualifyingDegree(ugQualifyingDegreeId){
        var ugQualifyingDegreeId = document.getElementById(ugQualifyingDegreeId).value;
        if(ugQualifyingDegreeId=='Other'){
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'block';
        }else{
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherPgQualifyingDegree(pgQualifyingDegreeId){
        var pgQualifyingDegreeId = document.getElementById(pgQualifyingDegreeId).value;
        if(pgQualifyingDegreeId=='Other'){
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'block';
        }else{
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgSpecialization(pgSpecializationId){
        var pgSpecializationId = document.getElementById(pgSpecializationId).value;
        if(pgSpecializationId=='Other'){
            document.getElementById('otherPgSpecializationId').style.display = 'block';
        }else{
            document.getElementById('otherPgSpecializationId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgBoardOrUniversity(pgBoardOrUniversityId){
        var pgBoardOrUniversityId = document.getElementById(pgBoardOrUniversityId).value;
        if(pgBoardOrUniversityId=='Other'){
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'block';
        }else{
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

    function checkUserAvailability(userLoginId){
        var userLoginName = document.getElementById(userLoginId).value;

        location.href = "checkTutorUserAvailability.do?userLoginName="+userLoginName
    }
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<div class="tutorBoxBody">
		<div class="fieldNameWrapper" style="margin-top: 10px;">
			<div class="tutorRegistrationIntro">
				<font color="orange" style="font-weight: bolder;">Please Note
					: </font> Please be careful while filling the profile information . The
				information provided here will be considered throughout the
				application process to be a successfull member of The Professional
				Tutors family .
				<p>&nbsp</p>
				Registration is very simple and it will take only a few minutes of
				your time
				<p>
					<font color="orange" style="font-weight: bold">You are also
						eligible to get benefit of assured referral bonus for each &amp;
						every paid membership reference!</font>
				</p>
				<p>
					<font color="green" style="font-weight: bold">If you face
						any problem to register your profile . Please contact helpdek no :
						+918697741613</font>
				</p>
				<p>
					<font color="blue" style="font-weight: bold">If yourself own
						required a tutor for any subject ,please perform another
						registration as a student.</font>
				</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="fieldNameWrapper" style="margin-top: 10px;">
		<div class="tutorRegistrationIntro">
			<form:errors />
		</div>
		<div class="clear"></div>
	</div>
	<!-- Getting started with the professional Tutor -->
	<div class="tutorBoxBody">
		<div class="registrationHeading">
			<bean:message key="GETTING_STARTED" />
			: Tutor login information

		</div>
		<div class="loginInfoWrapper">

			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_LOGIN_USER_NAME" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:input path="tutorLoginName"
						styleClass="registrationTextField" styleId="userLoginId"
						title="Please enter desired login name." />
					  <a href="" onclick="checkUserAvailability('userLoginId')">Check Availability</a>  
				</div>
				<div class="errorField">
					<%  if (null != (String) request.getAttribute("available")) {%>
					<font color="teal" style="font-weight: bold"><%= (String) request.getAttribute("available")%></font>
					<%} else if (null != (String) request.getAttribute("unavailable")) {%>
					<font color="red" style="font-weight: bold"><%= (String) request.getAttribute("unavailable")%></font>
					<%}%>
					<html:errors prefix="" path="tutorLoginName" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_LOGIN_PASSWORD" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:password path="tutorPassword"
						styleClass="registrationTextField" title="Please enter password." />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorPassword" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_SECRET_QUESTION" />
				</div>
				<div>
					<form:select path="tutorSecretQuestion"
						styleClass="registrationTextField">

						 <%@ include file="/jsp/library/secretQuestion.jspf"%> 
					</form:select>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_SECRET_QUESTION_ANSWER" />
				</div>
				<div>
					<form:input path="tutorSecretQuestionAnswer"
						styleClass="registrationTextField"
						title="Please enter secret answer." />
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="tutorBoxBody">
		<div class="registrationHeading">
			<bean:message key="TUTOR_PERSONAL_DETAILS" />
			<bean:message key="TUTOR_CONTACT_INFORMATION" />
		</div>
		<div class="loginInfoWrapper">
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_NAME" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:input path="tutorName" styleClass="registrationTextField"
						title="Please enter name." />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorName" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_SEX" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div class="genderandAge">
					<form:select path="tutorSex" styleClass="registrationTextField"
						style="width:90px">
						<form:option value="">-: Gender :-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
					</form:select>
				</div>
				<div class="agelabelName">
					<bean:message key="STUDENT_AGE" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div class="genderandAge">
					<form:select path="tutorAge" styleClass="registrationTextField"
						style="width:90px">
						<%@ include file="/jsp/library/ageSelection.jspf"%>
					</form:select>
				</div>
				<div class="errorField">
					<form:errors prefix="" path="tutorSex" />
					<form:errors prefix="" path="tutorAge" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_COUNTRY_LOCATION" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:select path="tutorCountryLocation"
						styleClass="registrationTextField">
						<%@ include file="../../countryNames.jspf"%>
					</form:select>
				</div>
				<div class="errorField">
					<form:errors prefix="" path="tutorCountryLocation" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_CITY_LOCATION" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:select path="tutorCityLocation"
						styleClass="registrationTextField">
						<form:option value="">-:Select your location :-</form:option>
						<%
                                        String countryValue = (String) request.getSession().getAttribute("countryName");
                                        LovDataService lovDataServiceForCity = new LovDataService();
                                        List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);
                                        for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                            %>
						<form:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></form:option>
						<%}%>
					</form:select>
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorCityLocation" />
				</div>
				<div class="clear"></div>
			</div>


			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS" />
					<bean:message key="MANDATORY_FIELD" />

				</div>
				<div>
					<form:textarea path="tutorAddress"
						styleClass="registrationTextField" style="height:50px;"
						title="Please enter addesss." />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorAddress" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					Contact Number :
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:input path="tutorContactNumber"
						styleClass="registrationTextField"
						title="Please enter contact number." />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorContactNumber" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_EMAIL_ADDDRESS" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<
					<form:input path="tutorEmailId" styleClass="registrationTextField"
						title="Please enter vaild E-mail address here" />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorEmailId" />
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- End of Login Wrapper -->
	</div>
	<!-- End of Tutor Box Body -->

	<!-- Tutor Education Information Details -->
	<div class="tutorBoxBody">
		<div class="registrationHeading">
			<bean:message key="TUTOR_EDUCATIONAL_INFORMATION" />
		</div>
		<div class="loginInfoWrapper">
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_UGCOURSE" />
				</div>
				<div>
					<form:select path="ugQualifyingDegree"
						styleClass="registrationTextField" styleId="ugQualifyingDegreeId"
						onchange="javascript:return showHideOtherUgQualifyingDegree('ugQualifyingDegreeId')">
						<%@ include file="/jsp/library/ugcoursenames.jspf"%>
					</form:select>
					<div id="otherUgQualifyingDegreeId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Other qualification :</div>
						<
						<form:input path="otherUgQualifyingDegree"
							styleClass="registrationOtherTextField"
							title="Please specify other tutoring qualifying degree" />
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_SPECIALIZATION" />
				</div>
				<div>
					<form:select path="ugSpecialization"
						styleClass="registrationTextField" styleId="ugSpecializationId"
						onchange="javascript:return showHideOtherUgSpecialization('ugSpecializationId')">
						<%@include file="/jsp/library/academicMainSubject.jspf"%>
					</form:select>
					<div id="otherUgSpecializationId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Other specialization :</div>
						<form:input path="otherUgSpecialization"
							styleClass="registrationOtherTextField"
							title="Please specify other specialization." />
					</div>
				</div>
				<div class="clear"></div>
			</div>

			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_BOARD_OR_INSTITUTE" />
				</div>
				<div>
					<form:select path="ugBoardOrUniversity"
						styleClass="registrationTextField" styleId="ugBoardOrUniversityId"
						onchange="javascript:return showHideOtherUgBoardOrUniversity('ugBoardOrUniversityId')">
						<%@ include file="/jsp/library/boardUniversityOrInstitute.jspf"%>
					</form:select>
					<div id="otherUgBoardOrUniversityId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Other Board/University :</div>
						<
						<form:input path="otherUgBoardOrUniversity"
							styleClass="registrationOtherTextField"
							title="Please specify other university/institute name" />
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_YEAR" />
				</div>
				<div>
					<form:select path="ugPassoutYear"
						styleClass="registrationTextField">
						<%@ include file="/jsp/library/yearOfPassout.jspf"%>
					</form:select>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_PGCOURSE" />
				</div>
				<div>

					<form:select path="pgQualifyingDegree"
						styleClass="registrationTextField" styleId="pgQualifyingDegreeId"
						onchange="javascript:return showHideOtherPgQualifyingDegree('pgQualifyingDegreeId')">
						<%@ include file="/jsp/library/pgcoursenames.jspf"%>
						</form:select>
						<div id="otherPgQualifyingDegreeId"
							style="margin-top: 10px; display: none">
							<div class="labelName">Other PG Qualification :</div>
							<form:input path="otherPgQualifyingDegree"
								styleClass="registrationOtherTextField"
								title="Please specify other tutoring pg qualification" />
						</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_SPECIALIZATION" />
					<!--/Major Subject:-->
				</div>
				<div>
					<form:select path="pgSpecialization"
						styleClass="registrationTextField" styleId="pgSpecializationId"
						onchange="javascript:return showHideOtherPgSpecialization('pgSpecializationId')">
						<%@include file="/jsp/library/academicMainSubject.jspf"%>
					</form:select>
					<div id="otherPgSpecializationId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Other PG specialization :</div>
						<form:input path="otherPgSpecialization"
							styleClass="registrationOtherTextField"
							title="Please specify other tutoring pg qualification" />
					</div>
				</div>
				<div class="clear"></div>
			</div>

			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_BOARD_OR_INSTITUTE" />
				</div>
				<div>
					<html:select path="pgBoardOrUniversity"
						styleClass="registrationTextField" styleId="pgBoardOrUniversityId"
						onchange="javascript:return showHideOtherPgBoardOrUniversity('pgBoardOrUniversityId')">
						<%@ include file="/jsp/library/boardUniversityOrInstitute.jspf"%>
					</html:select>
					<div id="otherPgBoardOrUniversityId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Other university/institute :</div>
						<html:text path="otherPgBoardOrUniversity"
							styleClass="registrationOtherTextField"
							title="Please specify other university/institute name" />

					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_YEAR" />
				</div>
				<div>
					<form:select path="pgPassoutYear"
						styleClass="registrationTextField">
						<%@ include file="/jsp/library/yearOfPassout.jspf"%>
					</form:select>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<!-- End of Login Wrapper -->
	</div>
	<!-- End of Tutor Box Body -->


	<!-- Tutoring Procedure Details -->
	<div class="tutorBoxBody">
		<div class="registrationHeading">
			<bean:message key="TUTOR_TUTORING_PROCEDURE" />
		</div>
		<div class="loginInfoWrapper">

			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:select styleId="subjectId" styleClass="registrationTextField"
						path="preferenceToTeachingList"
						onchange="javascript:return showHideOtherTutionRequirementSubject('subjectId')"
						style="height:70px;" multiple="true"
						title="Press Ctrl to select multiple teaching medium">
						<html:option value="">-:Select Subject :-</html:option>
						<html:optionsCollection name="linkActionForm"
							path="listOfSubjectSubCategory" label="labelName"
							value="labelValue" />
						<html:option value="Other">Other</html:option>
					</form:select>
				</div>
				<div id="subjectTextDiv" style="margin-top: 10px; display: none">
					<div class="labelName">Specify other subject</div>
					<html:text path="otherPreferenceToTeaching"
						styleClass="registrationOtherTextField"
						title="Please specify other subject name" />
				</div>

				<div class="errorField">
					<html:errors prefix="" path="preferenceToTeachingList" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">

					<bean:message key="TUTOR_TEACHING_EXPERIENCE" />
					<bean:message key="MANDATORY_FIELD" />

				</div>
				<div>
					<form:select path="tutorYearsOfExperience"
						styleClass="registrationTextField">
						<%@ include file="/jsp/library/yearOfExperience.jspf"%>
					</form:select>

				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutorYearsOfExperience" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_TUTORING_AREA_PREFERENCE" />
				</div>
				<div>
					<form:input path="preferredTutoringArea"
						styleClass="registrationTextField"
						title="Please specify area preference." />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_TEACHING_PATTERNS" />
				</div>
				<div>
					<form:select path="tutorTeachingPatteren"
						styleClass="registrationTextField"
						styleId="tutorTeachingPatterenId"
						onchange="javascript:return showHideOtherTutorTeachingPatteren('tutorTeachingPatterenId')"
						style="height:70px;" multiple="5"
						title="Press Ctrl to select multiple teaching pattern">
						<form:option value="">-:Select Teaching Patteren :-</form:option>
						<form:option value="Students Residence">
							<bean:message key="TUTOR_TUTORING_OPTIONS_STUDENTS_RESIDENCE" />
						</form:option>
						<form:option value="Own Residence">
							<bean:message key="TUTOR_TUTORING_OPTIONS_OWN_RESIDENCE" />
						</form:option>
						<form:option value="Institute/Coaching Center">
							<bean:message key="TUTOR_TUTORING_OPTIONS_INSTITUTE" />
						</form:option>
						<form:option value="Online Teaching">
							<bean:message key="TUTOR_TUTORING_OPTIONS_ONLINE_TEACHING" />
						</form:option>
						<form:option value="Vedio Tutoring">
							<bean:message key="TUTOR_TUTORING_OPTIONS_VEDIO_TUTORING" />
						</form:option>
						<form:option value="Other">Other</form:option>
					</form:select>
					<div id="otherTutorTeachingPatterenId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Specify other patteren :</div>
						<form:input path="otherTutorTeachingPatteren"
							styleClass="registrationOtherTextField"
							title="Please specify other teaching patteren name" />
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_TUTORING_OPTIONS" />
				</div>
				<div>
					<form:select path="tutoringOptionsList"
						styleClass="registrationTextField" styleId="tutoringOptionsId"
						onchange="javascript:return showHideOtherTutoringOptions('tutoringOptionsId')"
						style="height:70px;" multiple="true"
						title="Press Ctrl to select multiple tutoring options">
						<form:option value="">-:Select Tutoring Options:-</form:option>
							<form:option value="One-To-One">One-To-One</form:option>
								<form:option value="Group/Batch">Group/Batch</form:option>
									<form:option value="Other">Other</form:option>
					</form:select>
					<div id="otherTutoringOptionsId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Specify other options :</div>
						<form:input path="otherTutoringOptions"
							styleClass="registrationOtherTextField"
							title="Please specify other tutoring options name" />
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_TEACHING_MEDIUM" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:select path="teachingMediumList"
						styleClass="registrationTextField" styleId="teachingMediumId"
						onchange="javascript:return showHideOtherTeachingMedium('teachingMediumId')"
						style="height:70px;" multiple="tue"
						title="Press Ctrl to select multiple teaching medium">
						<form:option value="">-:Select Teaching Medium :-</form:option>
						<form:option value="English">English</form:option>
						<form:option value="Bengali">Bengali</form:option>
						<form:option value="Hindi">Hindi</form:option>
						<form:option value="Other">Other</form:option>
					</form:select>
					<div id="otherTeachingMediumId"
						style="margin-top: 10px; display: none">
						<div class="labelName">Specify other Medium :</div>
						<html:text path="otherTeachingMedium"
							styleClass="registrationOtherTextField"
							title="Please specify other medium name" />
					</div>
				</div>
				<div class="errorField">
					<html:errors prefix="" path="teachingMedium" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:select path="teachingLevelList"
						styleClass="registrationTextField" styleId="teachingLevelId"
						onchange="javascript:return showHideOtherTeachingSegmentLevel('teachingLevelId')"
						style="height:70px;" multiple="true"
						title="Press Ctrl to select multiple teaching level">
						<form:option value="">-:Select Teaching Level :-</form:option>
						<%
                                        String countryName = (String) request.getSession().getAttribute("countryName");
                                        LovDataService lovDataService = new LovDataService();
                                        List<ListOfValuesVO> listOfTutorEducationLevel = lovDataService.populateEducationLevel(countryName);
                                        if (null != listOfTutorEducationLevel) {
                                            for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                            %>
						<form:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></form:option>
							<%}
                                    }%>
							<form:option value="Other">Other</form:option>
						</form:select>
						<div id="otherTeachingLevelId"
							style="margin-top: 10px; display: none">
							<div class="labelName">Specify other level:</div>
							<form:input path="otherTeachingLevel"
								styleClass="registrationOtherTextField"
								title="Please specify other subject name" />
						</div>
				</div>
				<div class="errorField">
					<html:errors prefix="" path="teachingLevel" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTOR_EXPECTED_FEES" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:input path="feeExpected" styleClass="registrationTextField"
						title="Please enter expected fees value" />
				</div>

				<div class="errorField">
					<html:errors prefix="" path="feeExpected" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="labelName">
					<bean:message key="TUTORING_EXPERIENCE" />
					<bean:message key="MANDATORY_FIELD" />
				</div>
				<div>
					<form:textarea path="tutoringExperience"
						styleClass="registrationTextField" style="height:50px;"
						title="Please enter tutoring experience ." />
				</div>
				<div class="errorField">
					<html:errors prefix="" path="tutoringExperience" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="fieldNameWrapper" style="margin-top: 10px;">
				<div class="errorField">
					<img src="images/submit_button.gif" align="middle"
						alt="Submit" />
					<img src="images/reset.gif" align="middle" alt="Reset"
						onclick="javascript: return document.studentRegistrationActionForm.reset()" />
				</div>
				<div class="clear"></div>
			</div>

		</div>
		<!-- End of Login Wrapper -->
	</div>
	<!-- End of Tutor Box Body -->
</body>
</html>
