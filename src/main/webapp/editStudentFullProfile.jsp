
<%-- <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>

<%@page import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.List,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>

<script type="text/javascript" >
    window.onload = function showState() {
        var xmlhttp;
        var studentid_hidden = document.getElementById("studentid_hidden").value;
        //alert(studentid_hidden);
        //var country = document.getElementById("country").value;

        //        if (country == "")//Check if a country is not selected
        //        {
        //            document.getElementById("state_td").innerHTML = "<select><option value=''>---Select state---</option></select>";
        //            return;
        //        }
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
                document.getElementById("state_td").innerHTML = xmlhttp.responseText;
            }
            else {
                document.getElementById("state_td").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
            }
        }

        xmlhttp.open("GET", "state_test.jsp?studentid_hidden=" + studentid_hidden, true);
        xmlhttp.send();

    }
    
    function showState2() {//to display group of location for selecting a particular country
        var xmlhttp;
        var country = document.getElementById("country").value;

        if (country == "")//Check if a country is not selected
        {
            document.getElementById("state_td").innerHTML = "<select><option value=''>---Select state---</option></select>";
            return;
        }
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
                document.getElementById("state_td").innerHTML = xmlhttp.responseText;
            }
            else {
                document.getElementById("state_td").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
            }
        }

        xmlhttp.open("GET", "state.jsp?c=" + country, true);
        xmlhttp.send();

    }

    function showHideOtherStudentField(segmentLevelId,otherId){

        var segmentLevelId = document.getElementById(segmentLevelId).value;

        if(segmentLevelId=='Other'){
            document.getElementById(otherId).style.display = 'block';
        }else{
            document.getElementById(otherId).style.display = 'none';
        }
        return false;
    }
</script>
<div class="ourToutorWrapper">
    <div id="code">
    <div class="left_green_small">
        <h1>Edit Student Profile 
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1>
    </div>
    <html:form action="editStudentFullProfile">
<!--        <div class="cpart">
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="tutorRegistrationIntro" style=" width: 730px; ">
                    <font color="orange" style="font-weight: bolder; width: 730px; ">Please Note : </font>
                    Please be careful while filling the profile information . The information provided here will be considered throughout the application process to be a successfull member of The Professional Tutors family .
                    <p>&nbsp</p>
                    Registration is very simple and it will take only a few minutes of your time
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>   
        <div class="cpart">            
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="tutorRegistrationIntro">
                    <%--<html:errors/>--%>
                    <% if (null != request.getAttribute("msg")) {%>
                    <font color="red" style="font-weight: bold"> <%=request.getAttribute("msg")%></font>
                    <%}%>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>-->
        <div class="cpart">
            <!-- Getting started with the professional Tutor -->
            <div class="registrationHeading">
                <bean:message key="GETTING_STARTED"/>
            </div>      

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_ID"/>
                </div>
                <div style="color: #666;">
                    <bean:write  name="studentRegistrationActionForm" property="studentId"/>
                    <html:hidden name="studentRegistrationActionForm" property="studentId" styleId="studentid_hidden"/>
                </div>

                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="name" styleClass="registrationTextField" title="Please enter your name"/>
                </div>
                <div class="errorField">
                    <html:errors prefix="" property="name"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_LOGIN_NAME"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:text  property="userLoginName" styleClass="registrationTextField" title="Please enter desired login name " readonly="true"/>
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
                    <html:password  property="password" styleClass="registrationTextField" title="Please enter password .Password should be min 4 char length"/>
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
                    <html:select  property="secretQuestion" styleClass="registrationTextField" title="Please select secret question. It will required to retrieve lost password ">
                        <%@ include file = "WEB-INF/views/library/secretQuestion.jspf"  %>
                    </html:select>
                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="SECRET_QUESTION_ANSWER"/>
                </div>
                <div>
                    <html:text  property="secretQuestionAnswer" styleClass="registrationTextField" title="Please write security answer here. Keep it confidential."/>
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
                <div class="labelName" style="line-height:15px;">
                    <bean:message key="TUTOR_SEX"/>
                </div>
                <div class="gender">
                    <font class="levelValue" style="padding-left: 5px; color: #666;">  <bean:write name="studentRegistrationActionForm" property="sex"/> </font>
                    <html:hidden property="sex"/>
                </div>
                <div class="errorField"> <html:errors prefix="" property="sex"/></div>
                <div class="clear"></div>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_AGE"/><bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:select  property="age" styleClass="registrationTextField">
                        <%@ include file = "WEB-INF/views/library/ageSelection.jspf"  %>
                    </html:select>
                </div>
                <div class="errorField">
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
                    <%--<html:select  property="countryName" styleClass="registrationTextField">
                        <%@ include file = "countryNames.jspf"  %>
                    </html:select>--%>
                    <!--country list-->
                    <%--<html:select  property="countryName" styleClass="registrationTextField" styleId="country" onchange="return showState2();">
                        <%@include file="country_1_test.jsp" %>
                        <%--<html:option styleId="country_td" value=""></html:option>--%>
                        <%--<html:option value="BNG">Bangladesh</html:option>--%>
                        <%--<html:option value="BRB">Barbados</html:option>--%>
                    <%--</html:select>--%>
                    <level style=" margin-left: 11px; color: #000;">India</level>
                    <html:hidden property="countryName" value="IND"/>
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
                    <!--Location list-->
                    <%--<html:text  property="cityName" styleClass="registrationTextField" title="Please enter location name ."/>--%> 
                    <%--<html:select property="cityName"  styleClass="registrationTextField">
                        <optgroup id="state_td"></optgroup>
                    </html:select>--%>                    
                    <html:select  property="cityCode"  styleClass="registrationTextField">
                        <%-- <%@ include file="indialocations.jspf" %> --%>
                        <html:option value="">-:Select your location :-</html:option>
                        <html:option value="1">Kolkata</html:option>  
                        <html:option value="2">Delhi</html:option>
                        <html:option value="395">Mumbai</html:option>
                        <html:option value="127">Chennai</html:option>
                        <html:option value="10">Ahmedabad</html:option>
                        <html:option value="183">Hyderabad</html:option>
                        <html:option value="75">Bangalore</html:option>
                        <html:option value="476">Pune</html:option>
                        <option disabled>-------------------------------------</option>
                        <%

                            String countryValue = (String) request.getSession().getAttribute("countryCode");
                            LovDataService lovDataServiceForCity = new LovDataService();
                            List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                            for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                        %>
                        <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                        <% }%>
                    </html:select>
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
                    <html:text  property="area" styleClass="registrationTextField" title="Please enter area."/>
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
                    <html:text  property="landmark" styleClass="registrationTextField" title="Please enter landmark name ."/>
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
                    <html:textarea  property="address" styleClass="registrationTextField" style="height:50px;" title="Please enter address name . Address length should not exceed 300 character length"/>
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
                    <html:text  property="guardianname" styleClass="registrationTextField" title="Please enter gurdian name."/>
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
                    <html:text  property="contactNumber" styleClass="registrationTextField" title="Please enter contact number ."/>
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
                </div>
                <div>
                    <html:text  property="email" styleClass="registrationTextField" title="Please enter vaild E-mail address here"/>
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
                    <html:text  property="calltime" styleClass="registrationTextField" title="Please enter prefer call time."/>
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
                <div id="testSubjectDiv">                   
                    <html:select  property="schoolOrBoardId" styleClass="registrationTextField" styleId="schoolOrBoardId" onchange="javascript:return showHideOtherStudentField('schoolOrBoardId','otherSchoolOrBoardId')">
                        <html:option value="Other">-: Select school/board name :- </html:option>
                        <logic:present name="studentRegistrationActionForm" property="listOfSchoolBoard">
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfSchoolBoard" >
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                        </logic:present>
                        <html:option value="Other">Other</html:option>
                    </html:select>
                </div>
                <div id="otherSchoolOrBoardId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other School/Board:
                    </div>
                    <html:text  property="otherSchoolOrBoard"  styleClass="registrationTextField" title="Please specify other university/institute"/>
                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_ACADEMIC_INSTITUTE_OR_UNIVERSITY"/>
                </div>
                <div>
                    <html:select  property="universityOrInstituteId" styleClass="registrationTextField" styleId="universityOrInstituteId" onchange="javascript:return showHideOtherStudentField('universityOrInstituteId','otherUniversityOrInstituteId')">
                        <logic:present name="studentRegistrationActionForm" property="listOfUniversityInstitute">
                            <html:option value="Other">-: Select university/institute name :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfUniversityInstitute" >
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                        </logic:present>
                        <html:option value="Other">Other</html:option>
                    </html:select>

                </div>
                <div id="otherUniversityOrInstituteId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other University/Institute :
                    </div>
                    <html:text  property="otherUniversityOrInstitute"  styleClass="registrationTextField" title="Please specify other university/institute"/>
                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_CLASS_STANDARD"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:select  property="classstandard" styleClass="registrationTextField" styleId="classStandardId" onchange="javascript:return showHideOtherStudentField('classStandardId','otherClassStandardId')">
                        <logic:present name="studentRegistrationActionForm" property="listOfClassStandard">
                            <html:option value="">-: Select studying class :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfClassStandard" >
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                        </logic:present>
                        <html:option value="Other">Other</html:option>
                    </html:select>
                </div>
                <div id="otherClassStandardId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other Class :
                    </div>
                    <html:text  property="otherClassStandard"  styleClass="registrationTextField" title="Please specify other medium"/>
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
                    <html:select  property="medium" styleClass="registrationTextField" styleId="mediumId" onchange="javascript:return showHideOtherStudentField('mediumId','otherMediumId')">
                        <logic:present name="studentRegistrationActionForm" property="listOfTeachingMedium">
                            <html:option value="">-: Select medium :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfTeachingMedium" >
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                        </logic:present>
                        <html:option value="Other">Other</html:option>
                    </html:select>
                </div>
                <div id="otherMediumId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other medium :
                    </div>
                    <html:text  property="otherMedium"  styleClass="registrationTextField" title="Please specify other medium"/>
                </div>
                <div class="errorField">
                    <html:errors prefix="" property="medium"/>
                </div>
                <div class="clear">
                </div>
            </div>

            <%--<div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    <bean:message key="STUDENT_TEACHING_SUBJECT"/>
                    <bean:message key="MANDATORY_FIELD"/>
                </div>
                <div>
                    <html:select  property="subject" styleClass="registrationTextField" styleId="subjectId" onchange="javascript:return showHideOtherStudentField('subjectId','otherSubjectId')">
                        <logic:present name="studentRegistrationActionForm" property="listOfSubjectSubCategory">
                           <html:option value="">-: Select subject :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfSubjectSubCategory" >
                                <html:option value="${val.labelName}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                             <html:option value="Other">Other</html:option>
                        </logic:present>
                    </html:select>

                </div>
                <div id="otherSubjectId" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other subject :
                    </div>
                    <html:text  property="otherSubject"  styleClass="registrationTextField" title="Please specify other subject"/>
                </div>
                <div class="errorField">
                    <html:errors prefix="" property="subject"/>
                </div>
                <div class="clear">
                </div>
            </div>--%>
            <div class="clear"></div>
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
                    <html:text  property="tutionTitle" styleClass="registrationTextField" title="Please enter tution title . For e.g: Required for Mathematics"/>
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
                <div id="subjectSelectDiv" style="color:#000; ">
                    <html:select property="tutionRequirement" styleId="tutionRequirementSubjectId" styleClass="registrationTextField" onchange="javascript:return showHideOtherStudentField('tutionRequirementSubjectId','otherTutionRequirementSubject')">
                        <logic:present name="studentRegistrationActionForm" property="listOfSubjectSubCategory">
                            <html:option value="">-: Select subject :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfSubjectSubCategory">
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                        </logic:present>
                        <html:option value="Other">Other</html:option>
                    </html:select>
                </div>
                <div id="otherTutionRequirementSubject" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Other tution requirement :
                    </div>
                    <html:text  property="otherTutionRequirementSubject"  styleClass="registrationTextField" title="Please specify other tution requirement."/>
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
                    <html:select  property="segmentLevel" styleClass="registrationTextField" styleId="segmentLevelId" onchange="javascript:return showHideOtherStudentField('segmentLevelId','otherSegmentLevel')">
                        <logic:present name="studentRegistrationActionForm" property="listOfTeachingSegmentLevel">
                            <html:option value="">-: Select segment/level :- </html:option>
                            <logic:iterate id="val" name="studentRegistrationActionForm" property="listOfTeachingSegmentLevel">
                                <html:option value="${val.labelValue}"> <bean:write name="val" property="labelName"/></html:option>
                            </logic:iterate>
                            <html:option value="Other">Other</html:option>
                        </logic:present>
                    </html:select>
                </div>
                <div id="otherSegmentLevel" style="margin-top:10px;display: none">
                    <div class="labelName">
                        Specify other level:
                    </div>
                    <html:text  property="otherSegmentLevel"  styleClass="registrationTextField" title="Please specify other segment level"/>
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
                    <html:textarea  property="tutionRemarks" styleClass="registrationTextField" style="height:50px;" title="Please enter tution remarks . It should not be less minimum 200 character and maximun 300 character."/>
                </div>
                <div class="errorField">
                    <html:errors prefix="" property="tutionRemarks"/>
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:20px;">
                <div class="errorField">
                    <html:image   src="images/save_changes_btn.png" align="middle" alt="Submit" style="margin-right:10px;"/>
                    <html:image   src="images/cancel_btn.png" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>

                </div>
                <div class="clear"></div>
            </div>
                    <div class="clear"></div>
        </div> <!-- Login div close --> 

    </html:form>
         <div class="clear"></div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
    </div>
</div> <!-- End of Our Tutor Wrapper -->
