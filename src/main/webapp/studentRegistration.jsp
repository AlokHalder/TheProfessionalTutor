<%-- <%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>

<%@page import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.List,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<%--<script type="text/javascript" src="Javascript/country_state.js"></script>--%>

<style>
    .tutorRegistrationIntro112 {
    width: 540px;
    float: left;
    padding: 0px;
    margin-right: 0px;
    font: 13px/15px sans-serif;
    color: #666;
    text-align: left;
    font-style: italic;
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
    
    <%--function showCountry() {
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

    }--%>
        function showHideOtherStudentField(segmentLevelId,otherId){

            var segmentLevelId = document.getElementById(segmentLevelId).value;
            if(segmentLevelId=='9997'){
                document.getElementById(otherId).style.display = 'block';
            }else{
                document.getElementById(otherId).style.display = 'none';
            }
            return false;
        }
        function camelCaps(str) {
        var fieldValue = document.getElementById(str).value;

        var tempArray = fieldValue.split(' ');
        // Make the first character of each word upper
        for (var i = 0; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i].charAt(0).toUpperCase() + tempArray[i].substring(1);
        }
        document.getElementById(str).value = tempArray.join(' ');
    }

        /*function checkUserAvailability(userLoginId){
            var userLoginName = document.getElementById(userLoginId).value;
       
            location.href = "checkStudentUserAvailability.do?userLoginName="+userLoginName
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

            xmlhttp.open("GET", "studentRegistration_test.jsp?userLoginId=" + userLoginId, true);
            xmlhttp.send();
        }
        function callResetFields(){
            alert("Please reset all fields");
            return false;
        }
</script>

<%
    LovDataService lovDataService = new LovDataService();

    List<ListOfValuesVO> listOfSubjects = lovDataService.populateListOfSubjects();
    List<ListOfValuesVO> listOfTeachingMediums = lovDataService.populateListOfTeachingMediums();
    List<ListOfValuesVO> listOfTutorEducationLevel = lovDataService.populateEducationLevel("IND");
%>

<div class="ourToutorWrapper">
     <div id="code">
    <div class="left_green_small">
        <h1>Student Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1></div>
    <html:form action="studentRegistration">
        <!--<div class="tutorBoxBody">
            <div style="margin:10px 0px 0px 17px; width: 540px;">
                <div class="tutorRegistrationIntro112">
                    <%--   <font color="orange" style="font-weight: bolder; ">Please Note : </font>
                       Please be careful while filling the profile information . The information provided here will be considered throughout the application process to be a successfull member of The Professional Tutors family .
                       <p>&nbsp</p>
                       Registration is very simple and it will take only a few minutes of your time
                       <p><font color="orange" style="font-weight: bold">You are also eligible to get benefit of assured referral bonus for each &amp; every paid membership reference!</font></p>
                       <p><font color="green" style="font-weight: bold">If you face any problem to register your profile . Please contact helpdek no : +918697741613</font></p>
                    --%>

                    <p> Students are requested to fill in the registration form to create their respective profiles. Please be authentic while filling up the details as it will be considered throughout the application procedure.</p>
                    <p style=" font-weight: bold; margin-top: 5px;">Remember, a correct profile will enable you to get a correct teacher/tutor of your choice.</p>
                    <p> You are also eligible to get assured benefits of referral bonus for each & every paid membership reference!</p>
                    <p> Kindly contact the Helpdesk number <font color="#0094D9" style="font-weight: bold">+918697741613,033-2442-5535</font>  for further details. </p>

                </div>
                <div class="clear"></div>
            </div>
        </div>-->
<!--        <div class="cpart">            
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="tutorRegistrationIntro">
                    <%--<html:errors/>--%>
                    <%  if (null != request.getAttribute("msg")) {%>
                    <font color="red" style="font-weight: bold"> <%=request.getAttribute("msg")%></font>
                    <%}%>
                </div>
                <div class="clear"></div>
            </div>
                <div class="clear"></div>
        </div>-->
        <div class="cpart">
            <!-- Getting started with the professional Tutor -->
<!--            <div class="registrationHeading">
                <%--<bean:message key="GETTING_STARTED"/> :--%>Student login information

            </div>-->


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_LOGIN_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <%--<html:text  property="userLoginName" styleClass="registrationTextField" styleId="userLoginId" style="width:135px;" />
                    <%--<a href="#" onclick="checkUserAvailability('userLoginId')">Check Availability</a>--%>
                    <!--                    <input type="button" onclick="checkUserAvailability('userLoginId')" value="Check Availability"/>-->
                    <!--                    <span class="hint"><bean:message key="LOGIN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>-->



                    <table><tr>
                            <td><html:text property="userLoginName" styleClass="registrationTextField" styleId="userLoginId" onblur="checkUserAvailability();" style="width:135px;" size="15"/>

                            </td><td><div id="txtHint"></div></td>
                            <td><span class="hint"><bean:message key="LOGIN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                            </td></tr>
                    </table>



                    <div class="errorField">

                        <html:errors prefix="" property="userLoginName"/>
                    </div>
                </div>

                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="CHOOSE_PASSWORD"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:password  property="password" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="LOGIN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="password"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="CONFIRM_PASSWORD"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:password  property="confirmPassword" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="CONFIRM_PASSWORD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="confirmPassword"/>

                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="SECRET_QUESTION"/>
                </div>
                <div>
                    <html:select  property="secretQuestion" styleClass="registrationTextField">
                        <%@ include file = "/jsp/library/secretQuestion.jspf"  %>
                    </html:select>
                    <span class="hint"><bean:message key="SECURITY_ANSWER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="SECRET_QUESTION_ANSWER"/>
                </div>
                <div>
                    <html:text  property="secretQuestionAnswer" styleClass="registrationTextField"/>
                    <span class="hint"><bean:message key="SECURITY_ANSWER"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear" align="center"> </div>
            </div>
                    <div class="clear"></div>
            <!--  Registration heading div closed -->
        </div> <!-- Tutor Box body div close -->


        <!-- Student personal details -->
        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="STUDENT_PERSONAL_DETAILS"/>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="name" styleClass="registrationTextField" styleId="name" onblur="camelCaps('name')"/>
                    <span class="hint"><bean:message key="NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="name"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="TUTOR_SEX"/><bean:message key="MANDATORY_FIELD"/>
                </div>
                <div class="genderandAge">
                    <html:select  property="sex" styleClass="registrationTextField" style="width:90px">
                        <html:option value="" >-: Gender :-</html:option>
                        <html:option value="M">Male</html:option>
                        <html:option value="F">Female</html:option>
                    </html:select>
                    <span class="hint"><bean:message key="GENDER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="agelabelName">
                    <bean:message key="STUDENT_AGE"/><bean:message key="MANDATORY_FIELD"/>
                </div>
                <div class="genderandAge">
                    <html:select  property="age" styleClass="registrationTextField" style="width:90px" >
                       <%-- <%@ include file = "WEB-INF/views/library/ageSelection.jspf"  %>--%>
                       <%@ include file = "WEB-INF/views/library/ageSelectionStudent.jspf"  %>
                    </html:select>
                    <span class="hint"><bean:message key="AGE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="sex"/>
                    <html:errors prefix="" property="age"/>
                </div>
                <div class="clear">
                </div>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_COUNTRY_NAME"/>
                </div>
                <div>

                    <!--country list-->
                    <level style=" margin-left: 11px;color: #000;">India</level>
                    <html:hidden property="countryName" value="IND"/>
                    <%--<html:select  property="countryName" styleClass="registrationTextField" styleId="country" onchange="return showState();">
                        <optgroup id="country_td"></optgroup>
                    </html:select>  
                    <span class="hint"><bean:message key="COUNTRY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    
                    <%--<html:select  property="countryName" styleClass="registrationTextField">--%>
                    <%--<%@ include file = "countryNames.jspf"  %>--%>
                    <%--</html:select>--%>
                    <!--<span class="hint">< bean:message key="COUNTRY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>-->

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="countryName"/>
                </div>
                <div class="clear">                    
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_CITY_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <%--<html:select  property="cityName"  styleClass="registrationTextField">--%>
                    <!--<option value="">-:Select your location :-</option>-->
                    <%
//                                    String countryValue = (String) request.getSession().getAttribute("countryCode");
//                                    LovDataService lovDataServiceForCity = new LovDataService();
//                                    List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);
//
//                                    for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                    %>
                    <!--<option value="< %=listOfValuesVO.getLabelValue()%>">< %=listOfValuesVO.getLabelName()%></option>-->
                    <% //}%>
                    <%--</html:select>--%>
                    <!--<span class="hint">< bean:message key="LOCATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>-->

                    <!--location list-->
                    <%--<html:select  property="cityName"  styleClass="registrationTextField">  
                        <optgroup id="state_td"></optgroup>
                    </html:select>--%>
                    <html:select  property="cityCode"  styleClass="registrationTextField">
                        <%-- <%@ include file="indialocations.jspf" %> --%>
                        <option value="">-:Select your location :-</option>
                        <option value="1">Kolkata</option>  
                        <option value="2">Delhi</option>
                        <option value="395">Mumbai</option>
                        <option value="127">Chennai</option>
                        <option value="10">Ahmedabad</option>
                        <option value="183">Hyderabad</option>
                        <option value="75">Bangalore</option>
                        <option value="476">Pune</option>
                        <option disabled>-------------------------------------</option>
                        <%

                            String countryValue = (String) request.getSession().getAttribute("countryCode");
                            LovDataService lovDataServiceForCity = new LovDataService();
                            List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                            for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                        %>
                        <option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></option>
                        <% }%>
                    </html:select>
                    <span class="hint"><bean:message key="LOCATION_HINTS"/><span class="hint-pointer">&nbsp;</span></span>
                </div>
                <div class="errorField">
                    <html:errors prefix="" property="cityCode"/>
                </div>
                <div class="clear">                   
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_AREA_NAME"/><bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="area" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="AREA_TIPS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="area"/>
                </div>
                <div class="clear">                   
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_AREA_LANDMARK"/>
                </div>
                <div>
                    <html:text  property="landmark" styleClass="registrationTextField"/>
                    <span class="hint"><bean:message key="LANDMARK_TIPS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear">
                </div>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_ADDRESS1"/>
                    <bean:message key="MANDATORY_FIELD"/>

                </div>
                <div>
                    <html:textarea  property="address" styleClass="registrationTextField" style="height:50px;"/>
                    <span class="hint"><bean:message key="ADDRESS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="address" />
                </div>
                <div class="clear">                  
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_GURDIAN_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="guardianname" styleClass="registrationTextField" styleId="guardianname" onblur="camelCaps('guardianname')"/>
                    <span class="hint"><bean:message key="STUDENT_GURDIAN_NAME_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="guardianname"/>
                </div>
                <div class="clear" align="center">

                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    Contact Number :<bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="contactNumber" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="CONTACT_NUMBER_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="contactNumber"/>
                </div>
                <div class="clear">                   
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_EMAIL_ID"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="email" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="EMAIL_ADDRESS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="email"/>
                </div>
                <div class="clear">                   
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_PREFERRED_CALL_TIME"/>
                </div>
                <div>
                    <html:text  property="calltime" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="STUDENT_PREFERED_CALL_TIME"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear">
                </div>
            </div>
                    <div class="clear"></div>        
        </div> <!-- Tutor box body  div close -->


        <!-- Student Education details -->
        <div class="cpart">
            <div class="registrationHeading">                
                <bean:message key="STUDENT_EDUCATION_INFORMATION_DETAILS"/>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_ACADEMIC_SCHOOL_OR_BOARD"/>
                </div>
                <div>
                    <html:select property="schoolOrBoard" styleClass="registrationTextField" styleId="schoolOrBoardId"  onchange="javascript:return showHideOtherStudentField('schoolOrBoardId','otherSchoolOrBoardId')">
                        <html:optionsCollection name="linkActionForm" property="listOfSchoolBoard" label="labelName" value="labelValue"/>                      
                    </html:select>
                    <span class="hint"><bean:message key="STUDENT_ACADEMIC_SCHOOL_OR_BOARD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div id="otherSchoolOrBoardId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other School/Board:
                    </div>
                    <html:text  property="otherSchoolOrBoard"  styleClass="registrationOtherTextField" />
                    <span class="hint"><bean:message key="OTHER_STUDENT_ACADEMIC_SCHOOL_OR_BOARD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_ACADEMIC_INSTITUTE_OR_UNIVERSITY"/>
                </div>
                <div>
                    <html:select property="universityOrInstitute" styleClass="registrationTextField" styleId="universityOrInstituteId"  onchange="javascript:return showHideOtherStudentField('universityOrInstituteId','otherUniversityOrInstituteId')">
                        <html:optionsCollection name="linkActionForm" property="listOfUniversityInstitute" label="labelName" value="labelValue"/>
                    </html:select>
                    <span class="hint"><bean:message key="BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div id="otherUniversityOrInstituteId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other University/Institute :
                    </div>
                    <html:text  property="otherUniversityOrInstitute"  styleClass="registrationOtherTextField" />
                    <span class="hint"><bean:message key="OTHER_BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_CLASS_STANDARD"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>  

                    <html:select property="classstandard" styleClass="registrationTextField" styleId="classStandardId"  onchange="javascript:return showHideOtherStudentField('classStandardId','otherClassStandardId')">
                        <option value="">:- Select Studying class :-</option>
                        <%

                            if (null != listOfTutorEducationLevel) {
                                for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                        %>
                        <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                        <%}
                            }%>


                    </html:select>
                    <span class="hint"><bean:message key="STUDENT_CLASS_STANDARD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>


                </div>
                <div id="otherClassStandardId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other Class :
                    </div>
                    <html:text  property="otherClassStandard"  styleClass="registrationOtherTextField" />
                    <span class="hint"><bean:message key="OTHER_STUDENT_CLASS_STANDARD_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="classstandard"/>
                </div>
                <div class="clear">                  
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_TEACHING_MEDIUM"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>

                    <html:select property="medium" styleClass="registrationTextField" styleId="mediumId"  onchange="javascript:return showHideOtherStudentField('mediumId','otherMediumId')">
                        <html:optionsCollection name="linkActionForm" property="listOfTeachingMedium" label="labelName" value="labelValue"/>
                        <option value="">:- Select Medium :-</option>
                        <%
                            if (null != listOfTeachingMediums) {
                                for (ListOfValuesVO listOfValuesVO : listOfTeachingMediums) {
                        %>
                        <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                        <%}
                            }%>

                    </html:select>
                    <span class="hint"><bean:message key="STUDENT_TEACHING_MEDIUM_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>



                </div>
                <div id="otherMediumId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other medium :
                    </div>
                    <html:text  property="otherMedium"  styleClass="registrationOtherTextField" />
                    <span class="hint"><bean:message key="OTHER_STUDENT_TEACHING_MEDIUM_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="medium"/>
                </div>
                <div class="clear">                  
                </div>
            </div> 
            <div class="clear">                  
                </div>    
        </div> <!-- Tutor box body div close -->


        <!-- Tutor Requirement details -->
        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="STUDENT_TUTOR_REQUIREMENT_DETAILS"/>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_REQUIRED_TUTION_TILE"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="tutionTitle" styleClass="registrationTextField" />
                    <span class="hint"><bean:message key="STUDENT_REQUIRED_TUTION_TILE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="tutionTitle"/>
                </div>
                <div class="clear">                  
                </div>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_TUTION_REQUIREMENT_FOR"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div id="subjectSelectDiv">

                    <html:select property="tutionRequirement" styleId="tutionRequirementSubjectId" styleClass="registrationTextField" onchange="javascript:return showHideOtherStudentField('tutionRequirementSubjectId','otherTutionRequirementSubject')"  >
                        <%
                            if (null != listOfSubjects) {
                                for (ListOfValuesVO listOfValuesVO : listOfSubjects) {
                        %>
                        <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                        <%}
                            }%>
                    </html:select>
                    <span class="hint"><bean:message key="STUDENT_TUTION_REQUIREMENT_FOR_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div id="otherTutionRequirementSubject" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other tution requirement :
                    </div>
                    <html:text  property="otherTutionRequirementSubject"  styleClass="registrationOtherTextField" />
                    <span class="hint"><bean:message key="OTHER_STUDENT_TUTION_REQUIREMENT_FOR_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="tutionRequirement"/>
                </div>
                <div class="clear">                    
                </div>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_SEGMENT_OR_LEVEL"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>

                    <html:select  property="segmentLevel" styleId="segmentLevelId" styleClass="registrationTextField"  onchange="javascript:return showHideOtherStudentField('segmentLevelId','otherSegmentLevel')" >
                        <option value="">:- Select Segment/Level :-</option>
                        <%
                            if (null != listOfTutorEducationLevel) {
                                for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                        %>
                        <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                        <%}
                            }%>
                    </html:select>
                    <span class="hint"><bean:message key="STUDENT_SEGMENT_OR_LEVEL_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div id="otherSegmentLevel" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Specify other level:
                    </div>
                    <html:text  property="otherSegmentLevel" styleClass="registrationOtherTextField"/>
                    <span class="hint"><bean:message key="OTHER_STUDENT_SEGMENT_OR_LEVEL_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <div class="errorField">
                    <html:errors prefix="" property="segmentLevel"/>
                </div>
                <div class="clear">                    
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_TUTION_REMARKS"/>
                </div>
                <div>
                    <html:textarea  property="tutionRemarks" styleClass="registrationTextField" style="height:50px;" />
                    <span class="hint"><bean:message key="STUDENT_TUTION_REMARKS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>

                </div>
                <!--                <div class="errorField">
                                    < html:errors prefix="" property="tutionRemarks"/>
                                </div>-->
                <div class="clear">                    
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="errorField">
                    <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                        <html:image   src="images/continue_btn.png" align="left" alt="Submit"/>
                    </div>
                    <!--                        <div  style="float: left;margin-left: 10px;">
                                                <input type="reset" value="" alt="" style="background:url(< %=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
                                            </div>-->

                </div>
                <div class="clear"></div>
            </div>

            <!--            <div class="fieldNameWrapper" style="margin-top:10px;">
                            <div class="errorField">
                                <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                                    < html:image   src="images/submit_button.gif" align="middle" alt="Submit"/>
                                </div>
                                <div  style="float: left;margin-left: 10px;">
                                    <input type="reset" value="" alt="" style="background:url(<%=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
            
            
                                </div>
            
                            </div>
                            <div class="clear"></div>
                        </div>-->
<div class="clear">                  
                </div>
        </div> <!-- Login div close -->

    </html:form>
        <div class="clear"></div>
     </div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
</div> <!-- End of Our Tutor Wrapper -->


