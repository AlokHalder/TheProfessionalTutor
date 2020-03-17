<%-- <%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>



<%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.*,com.pcs.ptutors.vo.LocationVO,java.sql.*" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>

<script type="text/javascript" >
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
<form:base/>
<div class="ourToutorWrapper">
    <div class="tutorHeader">
        Tutor Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
    </div>

    <form:form action="tutorRegistration">
        <div class="tutorBoxBody">           
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="tutorRegistrationIntro">                    
                    <font color="orange" style="font-weight: bolder; ">Please Note : </font>
                    Please be careful while filling the profile information . The information provided here will be considered throughout the application process to be a successfull member of The Professional Tutors family .
                    <p>&nbsp</p>
                    Registration is very simple and it will take only a few minutes of your time
                    <p><font color="orange" style="font-weight: bold">You are also eligible to get benefit of assured referral bonus for each &amp; every paid membership reference!</font></p>
                    <p><font color="green" style="font-weight: bold">If you face any problem to register your profile . Please contact helpdek no : +918697741613</font></p>
                    <p><font color="blue" style="font-weight: bold">If yourself own required a tutor for any subject ,please perform another registration as a student.</font></p>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="tutorRegistrationIntro">
                <form:errors/>
            </div>
            <div class="clear"></div>
        </div>
        <!-- Getting started with the professional Tutor -->
        <div class="tutorBoxBody">
            <div class="registrationHeading">                
                <bean:message key="GETTING_STARTED"/> : Tutor login information

            </div>
            <div class="loginInfoWrapper">

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">                       
                        <bean:message key="TUTOR_LOGIN_USER_NAME"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text property="tutorLoginName" styleClass="registrationTextField" styleId="userLoginId" title="Please enter desired login name."/>
                        <%--   <a href="" onclick="checkUserAvailability('userLoginId')">Check Availability</a>  --%>
                    </div>
                    <div class="errorField">
                        <%  if (null != (String) request.getAttribute("available")) {%>
                        <font color="teal" style="font-weight:bold"><%= (String) request.getAttribute("available")%></font>
                        <%} else if (null != (String) request.getAttribute("unavailable")) {%>
                        <font color="red" style="font-weight:bold"><%= (String) request.getAttribute("unavailable")%></font>
                        <%}%>
                        <html:errors prefix="" property="tutorLoginName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_LOGIN_PASSWORD"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:password  property="tutorPassword"  styleClass="registrationTextField" title="Please enter password."/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorPassword"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SECRET_QUESTION"/>
                    </div>
                    <div>
                        <html:select  property="tutorSecretQuestion" styleClass="registrationTextField">

                            <%@ include file = "/jsp/library/secretQuestion.jspf"  %>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SECRET_QUESTION_ANSWER"/>
                    </div>
                    <div>
                        <html:text property="tutorSecretQuestionAnswer"  styleClass="registrationTextField" title="Please enter secret answer."/>
                    </div>
                    <div class="clear"></div>
                </div>               
            </div>
        </div>
        <div class="tutorBoxBody">
            <div class="registrationHeading">
                <bean:message key="TUTOR_PERSONAL_DETAILS"/> <bean:message key="TUTOR_CONTACT_INFORMATION"/>
            </div>             
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_NAME"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text property="tutorName" styleClass="registrationTextField" title="Please enter name."/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SEX"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="genderandAge">
                        <html:select  property="tutorSex" styleClass="registrationTextField" style="width:90px">
                            <html:option value="" >-: Gender :-</html:option>
                            <html:option value="Male" >Male</html:option>
                            <html:option value="Female">Female</html:option>
                        </html:select>
                    </div>
                    <div class="agelabelName">
                        <bean:message key="STUDENT_AGE"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="genderandAge">
                        <html:select  property="tutorAge" styleClass="registrationTextField" style="width:90px" >
                            <%@ include file = "WEB-INF/views/library/ageSelection.jspf"  %>
                        </html:select>
                    </div>
                    <div class="errorField">
                         <html:errors prefix="" property="tutorSex"/>
                        <html:errors prefix="" property="tutorAge"/>
                    </div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_COUNTRY_LOCATION"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select  property="tutorCountryLocation" styleClass="registrationTextField">
                            <%@ include file = "countryNames.jspf"  %>
                        </html:select>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorCountryLocation"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_CITY_LOCATION"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select  property="tutorCityLocation"  styleClass="registrationTextField">
                            <option value="">-:Select your location :-</option>
                            <%
                                        String countryValue = (String) request.getSession().getAttribute("countryName");
                                        LovDataService lovDataServiceForCity = new LovDataService();
                                        List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                                        for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                            %>
                            <option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></option>
                            <%}%>
                        </html:select>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorCityLocation"/></div>
                    <div class="clear"></div>
                </div>


                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
                        <bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <html:textarea  property="tutorAddress" styleClass="registrationTextField" style="height:50px;" title="Please enter addesss."/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorAddress"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Contact Number :
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text  property="tutorContactNumber" styleClass="registrationTextField" title="Please enter contact number."/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorContactNumber"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text  property="tutorEmailId" styleClass="registrationTextField" title="Please enter vaild E-mail address here"/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorEmailId"/></div>
                    <div class="clear"></div>
                </div>
            </div> <!-- End of Login Wrapper -->
        </div> <!-- End of Tutor Box Body -->

        <!-- Tutor Education Information Details -->
        <div class="tutorBoxBody">
            <div class="registrationHeading">
                <bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/>
            </div>
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_UGCOURSE"/>
                    </div>
                    <div>
                        <html:select  property="ugQualifyingDegree" styleClass="registrationTextField" styleId="ugQualifyingDegreeId" onchange="javascript:return showHideOtherUgQualifyingDegree('ugQualifyingDegreeId')">
                            <%@ include file = "/jsp/library/ugcoursenames.jspf"  %>
                        </html:select>
                        <div id="otherUgQualifyingDegreeId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other qualification :
                            </div>
                            <html:text  property="otherUgQualifyingDegree" styleClass="registrationOtherTextField" title="Please specify other tutoring qualifying degree"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                    </div>
                    <div>
                        <html:select  property="ugSpecialization" styleClass="registrationTextField" styleId="ugSpecializationId" onchange="javascript:return showHideOtherUgSpecialization('ugSpecializationId')">
                            <%@include file="/jsp/library/academicMainSubject.jspf" %>
                        </html:select>
                        <div id="otherUgSpecializationId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other specialization :
                            </div>
                            <html:text  property="otherUgSpecialization"  styleClass="registrationOtherTextField" title="Please specify other specialization."/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;" >
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="ugBoardOrUniversity" styleClass="registrationTextField" styleId="ugBoardOrUniversityId" onchange="javascript:return showHideOtherUgBoardOrUniversity('ugBoardOrUniversityId')">
                            <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                        </html:select>
                        <div id="otherUgBoardOrUniversityId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other Board/University :
                            </div>
                            <html:text  property="otherUgBoardOrUniversity"  styleClass="registrationOtherTextField" title="Please specify other university/institute name"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_YEAR"/>
                    </div>
                    <div>
                        <html:select  property="ugPassoutYear" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/yearOfPassout.jspf"  %>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PGCOURSE"/>
                    </div>
                    <div>

                        <html:select property="pgQualifyingDegree" styleClass="registrationTextField" styleId="pgQualifyingDegreeId" onchange="javascript:return showHideOtherPgQualifyingDegree('pgQualifyingDegreeId')">
                            <%@ include file = "/jsp/library/pgcoursenames.jspf"  %>
                        </html:select>
                        <div id="otherPgQualifyingDegreeId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other PG Qualification :
                            </div>
                            <html:text  property="otherPgQualifyingDegree"  styleClass="registrationOtherTextField" title="Please specify other tutoring pg qualification"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                        <!--/Major Subject:-->
                    </div>
                    <div>
                        <html:select  property="pgSpecialization" styleClass="registrationTextField" styleId="pgSpecializationId" onchange="javascript:return showHideOtherPgSpecialization('pgSpecializationId')">
                            <%@include file="/jsp/library/academicMainSubject.jspf" %>
                        </html:select>
                        <div id="otherPgSpecializationId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other PG specialization :
                            </div>
                            <html:text  property="otherPgSpecialization"  styleClass="registrationOtherTextField" title="Please specify other tutoring pg qualification"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="pgBoardOrUniversity" styleClass="registrationTextField" styleId="pgBoardOrUniversityId" onchange="javascript:return showHideOtherPgBoardOrUniversity('pgBoardOrUniversityId')">
                            <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                        </html:select>
                        <div id="otherPgBoardOrUniversityId" style="margin-top:10px;display: none">
                            <div class="labelName">
                                Other university/institute :
                            </div>
                            <html:text  property="otherPgBoardOrUniversity"  styleClass="registrationOtherTextField"  title="Please specify other university/institute name"/>

                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_YEAR"/>
                    </div>
                    <div>
                        <html:select  property="pgPassoutYear" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/yearOfPassout.jspf"  %>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
            </div> <!-- End of Login Wrapper -->
        </div> <!-- End of Tutor Box Body -->


        <!-- Tutoring Procedure Details -->
        <div class="tutorBoxBody">
            <div class="registrationHeading">
                <bean:message key="TUTOR_TUTORING_PROCEDURE"/>
            </div>
            <div class="loginInfoWrapper">

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select  styleId="subjectId" styleClass="registrationTextField" property="preferenceToTeachingList"  onchange="javascript:return showHideOtherTutionRequirementSubject('subjectId')" style="height:70px;" multiple="true" title="Press Ctrl to select multiple teaching medium">
                            <html:option value="">-:Select Subject :-</html:option>
                            <html:optionsCollection name="linkActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                            <html:option value="Other">Other</html:option>
                        </html:select>
                    </div>
                    <div id="subjectTextDiv" style="margin-top:10px;display: none">
                        <div class="labelName">
                            Specify other subject
                        </div>
                        <html:text  property="otherPreferenceToTeaching"  styleClass="registrationOtherTextField" title="Please specify other subject name"/>
                    </div>

                    <div class="errorField">
                        <html:errors prefix="" property="preferenceToTeachingList"/>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">

                        <bean:message key="TUTOR_TEACHING_EXPERIENCE" /><bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <html:select  property="tutorYearsOfExperience" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/yearOfExperience.jspf"  %>
                        </html:select>

                    </div>
                    <div class="errorField">
                        <html:errors prefix="" property="tutorYearsOfExperience"/>
                    </div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TUTORING_AREA_PREFERENCE"/>
                    </div>
                    <div>
                        <html:text property="preferredTutoringArea" styleClass="registrationTextField" title="Please specify area preference."/>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_PATTERNS"/>
                    </div>
                    <div>
                        <html:select property="tutorTeachingPatteren" styleClass="registrationTextField" styleId="tutorTeachingPatterenId" onchange="javascript:return showHideOtherTutorTeachingPatteren('tutorTeachingPatterenId')" style="height:70px;" multiple="5" title="Press Ctrl to select multiple teaching pattern">
                            <html:option value="">-:Select Teaching Patteren :-</html:option>
                            <html:option value="Students Residence"><bean:message key="TUTOR_TUTORING_OPTIONS_STUDENTS_RESIDENCE"/></html:option>
                            <html:option value="Own Residence"><bean:message key="TUTOR_TUTORING_OPTIONS_OWN_RESIDENCE"/></html:option>
                            <html:option value="Institute/Coaching Center"><bean:message key="TUTOR_TUTORING_OPTIONS_INSTITUTE"/></html:option>
                            <html:option value="Online Teaching"><bean:message key="TUTOR_TUTORING_OPTIONS_ONLINE_TEACHING"/></html:option>
                            <html:option value="Vedio Tutoring"><bean:message key="TUTOR_TUTORING_OPTIONS_VEDIO_TUTORING"/></html:option>
                            <html:option value="Other">Other</html:option>
                        </html:select>
                        <div id="otherTutorTeachingPatterenId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other patteren :
                            </div>
                            <html:text  property="otherTutorTeachingPatteren"  styleClass="registrationOtherTextField" title="Please specify other teaching patteren name"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TUTORING_OPTIONS"/>
                    </div>
                    <div>
                        <html:select property="tutoringOptionsList" styleClass="registrationTextField" styleId="tutoringOptionsId" onchange="javascript:return showHideOtherTutoringOptions('tutoringOptionsId')" style="height:70px;" multiple="true" title="Press Ctrl to select multiple tutoring options" >
                            <html:option value="">-:Select Tutoring Options:-</html:option>
                            <html:option value="One-To-One">One-To-One</html:option>
                            <html:option value="Group/Batch">Group/Batch</html:option>
                            <html:option value="Other">Other</html:option>
                        </html:select>
                        <div id="otherTutoringOptionsId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other options :
                            </div>
                            <html:text  property="otherTutoringOptions"  styleClass="registrationOtherTextField" title="Please specify other tutoring options name"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_MEDIUM"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select property="teachingMediumList" styleClass="registrationTextField"  styleId="teachingMediumId" onchange="javascript:return showHideOtherTeachingMedium('teachingMediumId')"  style="height:70px;" multiple="tue" title="Press Ctrl to select multiple teaching medium">
                            <html:option value="">-:Select Teaching Medium :-</html:option>
                            <html:option value="English">English</html:option>
                            <html:option value="Bengali">Bengali</html:option>
                            <html:option value="Hindi">Hindi</html:option>
                            <html:option value="Other">Other</html:option>
                        </html:select>
                        <div id="otherTeachingMediumId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other Medium :
                            </div>
                            <html:text  property="otherTeachingMedium" styleClass="registrationOtherTextField" title="Please specify other medium name"/>
                        </div>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="teachingMedium"/></div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select property="teachingLevelList" styleClass="registrationTextField" styleId="teachingLevelId" onchange="javascript:return showHideOtherTeachingSegmentLevel('teachingLevelId')" style="height:70px;" multiple="true" title="Press Ctrl to select multiple teaching level">
                            <html:option value="">-:Select Teaching Level :-</html:option>
                            <%
                                        String countryName = (String) request.getSession().getAttribute("countryName");
                                        LovDataService lovDataService = new LovDataService();
                                        List<ListOfValuesVO> listOfTutorEducationLevel = lovDataService.populateEducationLevel(countryName);
                                        if (null != listOfTutorEducationLevel) {
                                            for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                    }%>
                            <html:option value="Other">Other</html:option>

                        </html:select>
                        <div id="otherTeachingLevelId" style="margin-top:10px;display: none">
                            <div class="labelName">
                                Specify other level:
                            </div>
                            <html:text  property="otherTeachingLevel"  styleClass="registrationOtherTextField" title="Please specify other subject name"/>
                        </div>


                    </div>
                    <div class="errorField"> <html:errors prefix="" property="teachingLevel"/></div>
                    <div class="clear">

                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_EXPECTED_FEES"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text property="feeExpected" styleClass="registrationTextField" title="Please enter expected fees value"/>
                    </div>

                    <div class="errorField"> <html:errors prefix="" property="feeExpected"/></div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTORING_EXPERIENCE"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:textarea property="tutoringExperience" styleClass="registrationTextField" style="height:50px;" title="Please enter tutoring experience ."/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutoringExperience"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        <html:image   src="images/submit_button.gif" align="middle" alt="Submit"/>
                        <html:image   src="images/reset.gif" align="middle" alt="Reset" onclick="javascript: return document.studentRegistrationActionForm.reset()"/>
                    </div>
                    <div class="clear"></div>
                </div>

            </div> <!-- End of Login Wrapper -->
        </div> <!-- End of Tutor Box Body -->
    </form:form>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div> <!-- End of Our Tutor Wrapper -->