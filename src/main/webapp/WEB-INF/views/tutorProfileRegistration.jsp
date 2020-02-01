<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.*,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<script type="text/javascript" src="Javascript/country_state.js"></script>

<style>
    .tutorRegistrationIntro112 {
        width: 540px;
        float: left;
        padding: 0px;
        margin-right: 0px;
        font: 12px/15px sans-serif;
        font-style: italic;
        color: #666;
        text-align: left;
    }
.star1 {
    width: 255px;
    margin-top: 5px;
    margin-left: 192px;
    color: #C11A00;
}
</style>

<script type="text/javascript" >
    window.onload = function() {
        var login = '<%= session.getAttribute("userLoginName")%>';

        if (login == null || login == "null") {

            document.getElementById("userLoginId").value = "";
        }
        else
        {

            document.getElementById("userLoginId").value = '<%= session.getAttribute("userLoginName")%>';

        }
        showCountry();
    };
    
    /*function showCountry() {
    var xmlhttp;

    if (window.XMLHttpRequest)//Create an XMLHttpRequest object for IE7+, Firefox, Chrome, Opera, Safari
    {
        xmlhttp = new XMLHttpRequest();
    }
    else//Create an XMLHttpRequest object for IE6, IE5
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            document.getElementById("country_td").innerHTML = xmlhttp.responseText;
        }
        else {
            document.getElementById("country_td").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
        }
    }

    xmlhttp.open("GET", "country_1.jsp", true);
    xmlhttp.send();

}*/
    function camelCaps(str) {
        var fieldValue = document.getElementById(str).value;

        var tempArray = fieldValue.split(' ');
        // Make the first character of each word upper
        for (var i = 0; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i].charAt(0).toUpperCase() + tempArray[i].substring(1);
        }
        document.getElementById(str).value = tempArray.join(' ');
    }

    function showHideOtherTutionRequirementSubject(subjectId)
    {
        var subjectId = document.getElementById(subjectId).value;
        if (subjectId == 'Other') {
            document.getElementById('subjectTextDiv').style.display = 'block';

        } else {
            document.getElementById('subjectTextDiv').style.display = 'none';
            // document.getElementById(openBoxId).style.visibility = 'hidden';
        }

        return false;
    }

    function showHideOtherTeachingSegmentLevel(teachingLevelId) {
        var teachingLevelId = document.getElementById(teachingLevelId).value;
        if (teachingLevelId == 'Other') {
            document.getElementById('otherTeachingLevelId').style.display = 'block';
        } else {
            document.getElementById('otherTeachingLevelId').style.display = 'none';
        }
        return false;
    }

    function  showHideOtherTeachingMedium(teachingMediumId) {
        var teachingMediumId = document.getElementById(teachingMediumId).value;
        if (teachingMediumId == 'Other') {
            document.getElementById('otherTeachingMediumId').style.display = 'block';
        } else {
            document.getElementById('otherTeachingMediumId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutorTeachingPatteren(tutorTeachingPatterenId) {
        var tutorTeachingPatterenId = document.getElementById(tutorTeachingPatterenId).value;
        if (tutorTeachingPatterenId == 'Other') {
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'block';
        } else {
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutoringOptions(tutoringOptionsId) {
        var tutoringOptionsId = document.getElementById(tutoringOptionsId).value;
        if (tutoringOptionsId == 'Other') {
            document.getElementById('otherTutoringOptionsId').style.display = 'block';
        } else {
            document.getElementById('otherTutoringOptionsId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgBoardOrUniversity(ugBoardOrUniversityId) {
        var ugBoardOrUniversityId = document.getElementById(ugBoardOrUniversityId).value;
        if (ugBoardOrUniversityId == 'Other') {
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'block';
        } else {
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgSpecialization(ugSpecializationId) {
        var ugSpecializationId = document.getElementById(ugSpecializationId).value;
        if (ugSpecializationId == 'Other') {
            document.getElementById('otherUgSpecializationId').style.display = 'block';
        } else {
            document.getElementById('otherUgSpecializationId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgQualifyingDegree(ugQualifyingDegreeId) {
        var ugQualifyingDegreeId = document.getElementById(ugQualifyingDegreeId).value;
        if (ugQualifyingDegreeId == 'Other') {
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'block';
        } else {
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherPgQualifyingDegree(pgQualifyingDegreeId) {
        var pgQualifyingDegreeId = document.getElementById(pgQualifyingDegreeId).value;
        if (pgQualifyingDegreeId == 'Other') {
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'block';
        } else {
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgSpecialization(pgSpecializationId) {
        var pgSpecializationId = document.getElementById(pgSpecializationId).value;
        if (pgSpecializationId == 'Other') {
            document.getElementById('otherPgSpecializationId').style.display = 'block';
        } else {
            document.getElementById('otherPgSpecializationId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgBoardOrUniversity(pgBoardOrUniversityId) {
        var pgBoardOrUniversityId = document.getElementById(pgBoardOrUniversityId).value;
        if (pgBoardOrUniversityId == 'Other') {
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'block';
        } else {
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

    /*function checkUserAvailability(userLoginId) {
        
        var userLoginName = document.getElementById(userLoginId).value;
        if (userLoginName == "") {
            alert("User name can not be blank !");
            return false;
        }
        location.href = "checkTutorUserAvailability.do?userLoginName=" + userLoginName
    }*/
    function checkUserAvailability()
    {
        var userLoginId = document.getElementById("userLoginId").value;
        
        var xmlhttp;

        if (window.XMLHttpRequest)//Create an XMLHttpRequest object for IE7+, Firefox, Chrome, Opera, Safari
        {
            xmlhttp = new XMLHttpRequest();
        }
        else//Create an XMLHttpRequest object for IE6, IE5
        {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function()
        {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {
                document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
            }
            else {
                document.getElementById("txtHint").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
            }
        }

        xmlhttp.open("GET", "jsp/tutor/tutorProfileRegistration_test.jsp?userLoginId="+userLoginId, true);
        xmlhttp.send();
    }
    /*function validContactNumber(event){
     alert(event.keyCode);
     //document.forms[0].tutorContactNumber;
     } */
</script>
<%-- <form:base/> --%>
<div class="ourToutorWrapper">
    <div id="code"  >
    <div class="left_green_small">
        <h1> Tutor Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1>
    </div>

    <form:form action="tutorProfileRegistration" enctype="multipart/form-data">
        <!--<div class="tutorBoxBody">
            <div  style="margin:10px 0px 0px 17px; width: 540px;">
                <div class="tutorRegistrationIntro112">
                    <%-- <font color="orange" style="font-weight: bolder; ">Please Note : </font>
                     Please be careful while filling the profile information . The information provided here will be considered throughout the application process to be a successfull member of The Professional Tutors family .
                     <p>&nbsp</p>
                     Registration is very simple and it will take only a few minutes of your time
                     <p><font color="orange" style="font-weight: bold">You are also eligible to get benefit of assured referral bonus for each &amp; every paid membership reference!</font></p>
                     <p><font color="green" style="font-weight: bold">If you face any problem to register your profile . Please contact helpdek no : +918697741613</font></p>
                     <p><font color="blue" style="font-weight: bold">If yourself own required a tutor for any subject ,please perform another registration as a student.</font></p>
                    --%>
                    A basic registration is required to become a tutor member as well as display detailed respective profiles in the Professional Tutors Forum.

                    <p style=" font-weight: bold; margin-top: 5px;">Note: Please be authentic while filling up the details as it will be considered throughout the application procedure. </p>
                    <p style=" font-weight: bold; margin-top: 5px;">A correct profile will enable you to get the desired student, interested in taking tuitions. </p>
                    <p>Kindly contact the Helpdesk number <font color="#0094D9" style="font-weight: bold">+918697741613,033-2442-5535</font>  for further details. </p>

                </div>
                <div class="clear"></div>
            </div>           
        </div>-->

        <!-- Getting started with the professional Tutor -->
        <div class="cpart" style="margin-top: -20px;">
            <div class="registrationHeading">
                <%--<bean:message key="GETTING_STARTED"/> :--%> Tutor login information

            </div>
            <div class="loginInfoWrapper">

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_LOGIN_USER_NAME"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
<!--                    -->
                    <table>
                        <tr>
                            <td><form:input path="tutorLoginName" styleClass="registrationTextField" styleId="userLoginId" onblur="checkUserAvailability();"  style="width:135px;" size="15"/>
                            </td><td><div id="txtHint"></div></td>
                            <td><span class="hint"><bean:message key="LOGIN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                            </td>
                        </tr>
                    </table>


                    <%--<html:text property="tutorLoginName" styleClass="registrationTextField" onblur="checkUserAvailability();" styleId="userLoginId" style="width:135px;" size="15"/>--%>
                    <!--<span class="hint"><bean:message key="LOGIN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>--> 

                    <div class="errorField"> <html:errors prefix="" property="tutorLoginName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_LOGIN_PASSWORD"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:password  property="tutorPassword"  styleClass="registrationTextField"/>
                        <span class="hint"><bean:message key="PASSWORD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorPassword"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SECRET_QUESTION"/>
                    </div>
                    <div>
                        <form:select path="tutorSecretQuestion" styleClass="registrationTextField">

                            <%@ include file = "/jsp/library/secretQuestion.jspf"  %>
                        </form:select>
                        <span class="hint"><bean:message key="SECURITY_ANSWER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SECRET_QUESTION_ANSWER"/>
                    </div>
                    <div>
                        <form:input path="tutorSecretQuestionAnswer"  styleClass="registrationTextField"/>
                        <span class="hint"><bean:message key="SECURITY_ANSWER"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
                    <div class="clear"></div>       
        </div>
        <div class="cpart" style="margin-top: -20px;">
            <div class="registrationHeading">
                <bean:message key="TUTOR_PERSONAL_DETAILS"/> <bean:message key="TUTOR_CONTACT_INFORMATION"/>
            </div>
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_NAME"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <form:input path="tutorName" styleClass="registrationTextField"  styleId="tutorName" onblur="camelCaps('tutorName')"/>

                    </div>
                    <div class="errorField"> <form:errors prefix="" property="tutorName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SEX"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="genderandAge">
                        <html:select  property="tutorSex" styleClass="registrationTextField" style="width:90px">
                            <html:option value="" >-: Gender :-</html:option>
                            <html:option value="M" >Male</html:option>
                            <html:option value="F">Female</html:option>
                        </html:select>
                        <span class="hint"><bean:message key="GENDER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="agelabelName">
                        <bean:message key="TUTOR_AGE"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="genderandAge">
                        <form:select path="tutorAge" styleClass="registrationTextField" style="width:90px" >
                            <%@ include file = "/jsp/library/ageSelection.jspf"  %>
                        </form:select>
                        <span class="hint"><bean:message key="AGE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField">
                         <form:errors prefix="" property="tutorSex"/>
                        <form:errors prefix="" property="tutorAge"/>
                       
                    </div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_COUNTRY_LOCATION"/>

                    </div>
                    <div>
                        <!--country list-->
                        <level style=" margin-left: 11px;">India</level>
                        <form:hidden path="tutorCountryLocation" value="IND"/>
                        <%--<html:select  property="tutorCountryLocation" styleClass="registrationTextField" styleId="country" onchange="return showState();">
                            <optgroup id="country_td"></optgroup>
</html:select>--%> 
                        <%--<span class="hint"><bean:message key="COUNTRY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>--%>
                    </div>
                    <div class="errorField"> <form:errors prefix="" property="tutorCountryLocation"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_CITY_LOCATION"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <form:select path="tutorCityLocationId"  styleClass="registrationTextField">
                            <%-- <%@ include file="indialocations.jspf" %> --%>
                            <option value="">-:Select your location :-</option>--%>
                            <option value="1">Kolkata</option>  
                            <option value="2">Delhi</option>
                            <option value="395">Mumbai (formerly Bombay)</option>
                            <option value="127">Chennai</option>
                            <option value="10">Ahmedabad </option>
                            <option value="183">Hyderabad (Andhra Pradesh)</option>
                            <option value="75">Bengaluru Bangalore</option>
                            <option value="476">Pune</option>
                            <option disabled>---------------</option>
                            <%

                                String countryValue = (String) request.getSession().getAttribute("countryCode");
                                LovDataService lovDataServiceForCity = new LovDataService();
                                List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                                for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                            %>
                            <option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></option>
                            <% }%>
                        </form:select>
                        <span class="hint">< bean:message key="LOCATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                        <!--location list-->
                        <%--    <html:select  property="cityName"  styleClass="registrationTextField">  
                            <optgroup id="state_td"></optgroup>
                          </html:select>--%>
                        <span class="hint"><bean:message key="LOCATION_HINTS"/><span class="hint-pointer">&nbsp;</span></span>
                    </div>
                    <%--<div>
                    <!--location list-->
                    <html:select  property="tutorCityLocationId"  styleClass="registrationTextField">  
                        <optgroup id="state_td"></optgroup>
                    </html:select>
                    <span class="hint"><bean:message key="LOCATION_HINTS"/><span class="hint-pointer">&nbsp;</span></span>
</div>--%>
                    <div class="errorField"> <form:errors prefix="" path="tutorCityLocationId"/></div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">                    
                        Postal/Zip code :
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <form:input path="tutorPostalCode" styleClass="registrationTextField" />
                        <span class="hint"><bean:message key="POSTAL_ZIP_CODE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField"> <form:errors prefix="" property="tutorPostalCode"/></div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Area :                        
                    </div>
                    <div>
                        <form:input path="tutorArea" styleClass="registrationTextField" styleId="tutorArea" onblur="camelCaps('tutorArea')"/>
                        <span class="hint"><bean:message key="AREA_TIPS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>

                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
                        <bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <form:textarea  path="tutorAddress" styleClass="registrationTextField" style="height:50px;"/>
                        <span class="hint"><bean:message key="ADDRESS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField"> <form:errors prefix="" property="tutorAddress"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Contact Number :
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text  property="tutorContactNumber" styleClass="registrationTextField"/>
                        <span class="hint"><bean:message key="CONTACT_NUMBER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
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
                        <form:input path="tutorEmailId" styleClass="registrationTextField"/>
                        <span class="hint"><bean:message key="EMAIL_ADDRESS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField"> <form:errors prefix="" property="tutorEmailId"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Upload Photo:
                    </div>
                    <div>
                        <input type="file" styleClass="registrationTextField"  name="uploadImage" />
                    </div>
                    <div class="star1">
                        (*.jpg,*.png,*.gif)
                    </div>
                    <div class="star">
                        <font color="red">  <bean:write name="tutorProfileRegistrationActionForm" property="msg"/></font>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                            <form:image   src="images/continue_btn.png" align="left" alt="Submit"/>
                        </div>
                        <!--                        <div  style="float: left;margin-left: 10px;">
                                                    <input type="reset" value="" alt="" style="background:url(< %=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
                                                </div>-->

                    </div>
                    <div class="clear"></div>
                </div>

            </div> <!-- End of Login Wrapper -->
            <div class="clear"></div>
        </div> <!-- End of Tutor Box Body -->


    </form:form>
         <div class="clear"></div>
     </div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
</div> <!-- End of Our Tutor Wrapper -->

<%--<div class="ourToutorWrapper">
    <div class="tutorHeader">The Professional Tutors Educare &nbsp;&nbsp; <font color="orange">*</font><a href="Link.do?method=postAdvertisement" style="text-decoration: none; font-size: 11px;">Book your advertisement</a></div>
    <div class="tutorBoxBody">
        <div class="bottombanner">
            <img src="images/bottom_banner.gif" alt="Bottom Banner" />
        </div>
        <div class="bottombannerlink">
            <a href="#" class="bottombanner">Click here to view Professional Tutors Educare details </a>
        </div>
    </div> <!-- Tutor Box body div close -->

    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>--%>
