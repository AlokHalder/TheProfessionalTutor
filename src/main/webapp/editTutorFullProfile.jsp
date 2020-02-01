
<%-- <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> --%>
<%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.*,com.pcs.ptutors.vo.LocationVO,java.sql.*" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>

<script type="text/javascript" >
    window.onload = function showState() {
        var xmlhttp;
        var tutorid_hidden = document.getElementById("tutorid_hidden").value;
        //alert(tutorid_hidden);

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

        xmlhttp.open("GET", "state_test_tutor.jsp?tutorid_hidden=" + tutorid_hidden, true);
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
</script>



<div class="ourToutorWrapper">
     <div id="code">
    <div class="left_green_small">
        <h1>  Edit tutor personal and contact details
        <font style="font-size: 14px; text-align: right"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
 </h1>   
    </div>

<!-- <div class="cpart" style="margin: 15px 10px -20px 10px; padding-bottom: 20px;">            
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="tutorRegistrationIntro" style="width: 730px;">
                <font color="orange" style="font-weight: bolder; ">Please Note : </font>
                Please be careful while filling the profile information . The information provided here will be considered throughout the application process to be a successfull member of The Professional Tutors family .
                <p>&nbsp;</p>
                Profile updation is very simple and it will take only a few minutes of your time
            </div>
            <div class="clear"></div>
        </div>  
        <div class="clear"></div>
    </div>-->

    <!-- Getting started with the professional Tutor -->
    <html:form action="editTutorPersonalDetails">
        <div class="cpart" style="margin-top: -20px;">
            <div class="registrationHeading">
                <%--  <bean:message key="GETTING_STARTED"/> &nbsp;&nbsp; --%>
                Edit Tutor Personal and Contact details
            </div>
            <div class="loginInfoWrapper">               
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_ID"/><bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <font class="levelValue" style="padding-left: 10px;"> <bean:write name="tutorRegistrationActionForm" property="tutorId"/> </font>
                        <html:hidden property="tutorId" name="tutorRegistrationActionForm" styleId="tutorid_hidden"/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorId"/>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_NAME"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <font class="levelValue" style="padding-left: 10px;">
                        <bean:write name="tutorRegistrationActionForm" property="tutorName"/>
                        <html:hidden property="tutorName" name="tutorRegistrationActionForm"/>
                        </font>

                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_LOGIN_USER_NAME"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <input type="text" name="tutorLoginName" class="registrationTextField" value="<bean:write name='tutorRegistrationActionForm' property='tutorLoginName'/>" readonly/>

                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorLoginName"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_LOGIN_PASSWORD"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <input type="password" name="tutorPassword" class="registrationTextField" value="<bean:write name='tutorRegistrationActionForm' property='tutorPassword'/>"/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorPassword"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SECRET_QUESTION"/>
                    </div>
                    <div>
                        <html:select  property="tutorSecretQuestion" name="tutorRegistrationActionForm" styleClass="registrationTextField">
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
                        <html:text property="tutorSecretQuestionAnswer" name="tutorRegistrationActionForm"  styleClass="registrationTextField"/>
                    </div>
                    <div class="clear"></div>
                </div>                 
            </div>

            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SEX"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="gender">
                        <font class="levelValue" style="padding-left: 5px;">  <bean:write name="tutorRegistrationActionForm" property="tutorSex"/> </font>
                        <html:hidden property="tutorSex" name="tutorRegistrationActionForm"/>
                    </div>                     
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_AGE"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select  property="tutorAge" styleClass="registrationTextField" name="tutorRegistrationActionForm">
                            <%@ include file = "/jsp/library/ageSelection.jspf"  %>
                        </html:select>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorAge"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_COUNTRY_LOCATION"/>
                    </div>
                    <div>
                        <div>
                            <level style=" margin-left: 11px;">India</level>
                            <html:hidden property="tutorCountryLocation" name="tutorRegistrationActionForm" value="IND"/>
                        </div>
                        <%-- <html:select  property="tutorCountryLocation" styleClass="registrationTextField" name="tutorRegistrationActionForm">
                             <%@ include file = "countryNames.jspf"  %>
                         </html:select>--%>
                        <!--country list-->                        
                        <%-- <html:select name="tutorRegistrationActionForm"  property="tutorCountryLocation" styleClass="registrationTextField" styleId="country" onchange="return showState2();">
                            <%@include file="country_1_test.jsp" %>
                     </html:select> --%>
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

                        <%--<html:select  property="tutorCityLocationId" name="tutorRegistrationActionForm" styleClass="registrationTextField">
                          <html:option value="">-:Select your location :-</html:option>
                          <%
                                      String countryValue = (String) request.getSession().getAttribute("countryCode");

                                        LovDataService lovDataServiceForCity = new LovDataService();
                                        List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                                        for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>" ><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}%>
                        </html:select>--%>


                        <html:select  property="tutorCityLocationId" name="tutorRegistrationActionForm"  styleClass="registrationTextField">
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

                        <%-- <html:select property="tutorCityLocationId"  styleClass="registrationTextField">
                            <optgroup id="state_td"></optgroup>
                        </html:select> --%>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorCityLocationId"/></div>
                    <div class="clear"></div>
                </div>


                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
                        <bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <html:textarea  property="tutorAddress" name="tutorRegistrationActionForm" styleClass="registrationTextField" style="height:100px;" />
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
                        <html:text  property="tutorContactNumber"  name="tutorRegistrationActionForm" styleClass="registrationTextField"/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorContactNumber"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
                    </div>
                    <div>
                        <html:text  property="tutorEmailId" name="tutorRegistrationActionForm" styleClass="registrationTextField" title="Please write vaild E-mail address here"/>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutorEmailId"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="errorField">
                        <html:image   src="images/save_changes_btn.png" align="middle" alt="Submit" style="margin-right:10px;"/>
                        <html:image   src="images/cancel_btn.png" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>

                    </div>
                    <div class="clear"></div>
                </div>
                <!--                <div class="fieldNameWrapper" style="margin-top:10px;">
                                    <div class="errorField">
                <%--<html:submit   value="Edit Personal Details"/>--%>
                < html:image   src="images/submit_button.gif" align="middle" alt="Submit"/>
                < html:image   src="images/cancel_button.jpg" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>
                
            </div>
            <div class="clear"></div>
        </div>-->
            </div> <!-- End of Login Wrapper -->
            <div class="clear"></div>
        </div> <!-- End of Tutor Box Body -->
    </html:form>
    <%--
            <!-- Tutor Education Information Details -->
            <div class="tutorBoxBody">
                <div class="registrationHeading">
                    Edit <bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/>
                </div>
                <div class="loginInfoWrapper">
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="labelName">
                            <bean:message key="TUTOR_UGCOURSE"/>
                        </div>
                        <div>
                            <html:select  property="ugQualifyingDegree" styleClass="registrationTextField">
                                <%@ include file = "/jsp/library/ugcoursenames.jspf"  %>
                            </html:select>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="labelName">
                             <bean:message key="TUTOR_SPECIALIZATION"/>
                        </div>
                        <div>
                            <html:select  property="ugSpecialization" styleClass="registrationTextField">
                                <%@include file="/jsp/library/academicMainSubject.jspf" %>
                            </html:select>
                        </div>
                        <div class="clear"></div>
                    </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="ugBoardOrUniversity" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                        </html:select>
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

                        <html:select property="pgQualifyingDegree" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/pgcoursenames.jspf"  %>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                         <bean:message key="TUTOR_SPECIALIZATION"/>
                        <!--/Major Subject:-->
                    </div>
                    <div>
                        <html:select  property="pgSpecialization" styleClass="registrationTextField">
                            <%@include file="/jsp/library/academicMainSubject.jspf" %>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="pgBoardOrUniversity" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                        </html:select>
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
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        <html:submit   value="Edit Educational Details"/>
                    </div>
                    <div class="clear"></div>
                </div>

            </div> <!-- End of Login Wrapper -->
        </div> <!-- End of Tutor Box Body -->


        <!-- Tutoring Procedure Details -->
        <div class="tutorBoxBody">
            <div class="registrationHeading">
              Edit <bean:message key="TUTOR_TUTORING_PROCEDURE"/>
            </div>
            <div class="loginInfoWrapper">
              
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS"/>
                    </div>
                    <div>
                        <html:text property="preferenceToTeaching" styleClass="registrationTextField"/>
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
                       <!-- & Years
                        <html:select  property="tutorMonthsOfExperience" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/monthOfExperience.jspf"  %>
                        </html:select>
                        &nbsp;Months -->
                    </div>
                        <div class="errorField"> <html:errors prefix="" property="tutorYearsOfExperience"/></div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TUTORING_AREA_PREFERENCE"/>
                    </div>
                    <div>
                        <html:text property="preferredTutoringArea" styleClass="registrationTextField"/>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_PATTERNS"/>
                    </div>
                    <div>
                        <html:select property="tutorTeachingPatterenList" styleClass="registrationTextField">
                            <html:option value="">-:Select Teaching Patteren :-</html:option>
                            <html:option value="Students Residence"><bean:message key="TUTOR_TUTORING_OPTIONS_STUDENTS_RESIDENCE"/></html:option>
                            <html:option value="Own Residence"><bean:message key="TUTOR_TUTORING_OPTIONS_OWN_RESIDENCE"/></html:option>
                            <html:option value="Institute/Coaching Center"><bean:message key="TUTOR_TUTORING_OPTIONS_INSTITUTE"/></html:option>
                            <html:option value="Online Teaching"><bean:message key="TUTOR_TUTORING_OPTIONS_ONLINE_TEACHING"/></html:option>
                            <html:option value="Vedio Tutoring"><bean:message key="TUTOR_TUTORING_OPTIONS_VEDIO_TUTORING"/></html:option>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TUTORING_OPTIONS"/>
                    </div>
                    <div>
                        <html:select property="tutoringOptionsList" styleClass="registrationTextField">
                            <html:option value="">-:Select Tutoring Options:-</html:option>
                            <html:option value="One-To-One">One-To-One</html:option>
                            <html:option value="Group/Batch">Group/Batch</html:option>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_MEDIUM"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select property="teachingMediumList" styleClass="registrationTextField">
                            <html:option value="">-:Select Teaching Medium :-</html:option>
                            <html:option value="English">English</html:option>
                            <html:option value="Bengali">Bengali</html:option>
                            <html:option value="Hindi">Hindi</html:option>
                        </html:select>
                    </div>
                     <div class="errorField"> <html:errors prefix="" property="teachingMediumList"/></div>
                    <div class="clear">
                    </div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select property="teachingLevelList" styleClass="registrationTextField">
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

                        </html:select>
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
                        <html:text property="feeExpected" styleClass="registrationTextField"/>
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
                        <html:textarea property="tutoringExperience" styleClass="registrationTextField" />
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutoringExperience"/></div>
                    <div class="clear"></div>
                </div>
                 <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        <html:submit value="Edit Tutoring Procedure"/>
                       
                    </div>
                    <div class="clear"></div>
                </div>

            </div> <!-- End of Login Wrapper -->
        </div> <!-- End of Tutor Box Body -->
    --%>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
<div class="clear"></div>
</div>
</div>
    <!-- End of Our Tutor Wrapper -->
