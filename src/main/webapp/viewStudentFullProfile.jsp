<%-- <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>
<style>

    .labelValue2 {
        padding: 0px;
        margin-left: 210px;
        font: 12px/15px Arial,Helvetica;
        color: #666;
        text-align: left;
        width: 100px;
    }

    .profilleLabelName2 {
        width: 180px;
        float: left;
        padding: 0px;
        margin-left: 10px;
        font: bold 13px/20px Arial,Helvetica;
        color: #800000;
        text-align: left;
    }
</style>


<div class="ourToutorWrapper">
    <div id="code">
        <div class="left_green_small"><h1>Student Profile</h1></div>
    <html:form action="viewForEditStudentFullProfile">
        <!-- Student personal details -->
        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="STUDENT_PERSONAL_DETAILS"/>
            </div>

            <div class="fieldNameWrapper1" style="margin-top:10px;">
                <div style="float: left; width: 280px;" >
                    <div class="profilleLabelName2">
                        <bean:write name="studentRegistrationActionForm" property="name"/>
                        (<bean:write name="studentRegistrationActionForm" property="sex"/>/<bean:write name="studentRegistrationActionForm" property="age"/>)
                    </div>
                </div>
            </div>
            <logic:equal name="studentRegistrationActionForm" property="imageFlag" value="true">
                <div style="float: right; width: 100px;height: 80px; margin-right: 10px;">
                    <img src="<%=request.getContextPath()%>/Photo-Upload/<bean:write name="studentRegistrationActionForm" property="photoFileName"/>" align="right" height="80"  width="100">
                </div>
            </logic:equal>
            <logic:equal name="studentRegistrationActionForm" property="imageFlag" value="false"> 
                <div style="float: right; width: 100px;height: 80px; margin-right: 10px;">
                    <logic:equal name="studentRegistrationActionForm" property="sex" value="M">
                        <img src="<%=request.getContextPath()%>/tutorphotogalary/male_user_icon.png" align="right" height="80"  width="100">
                    </logic:equal>
                    <logic:equal name="studentRegistrationActionForm" property="sex" value="F">
                        <img src="<%=request.getContextPath()%>/tutorphotogalary/female_user_icon.png" align="right" height="80"  width="100">
                    </logic:equal>
                </div>
            </logic:equal>


            <div class="fieldNameWrapper1" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="STUDENT_ID"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="studentRegistrationActionForm" property="studentId"/>
                </div>
            </div>          
            <div class="fieldNameWrapper1" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="STUDENT_CITY_NAME"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="studentRegistrationActionForm" property="cityName"/>,
                    <bean:write name="studentRegistrationActionForm" property="countryName"/>
                </div>

            </div>

            <%
                String tutorMembershipCategory = (String) request.getAttribute("tutorMembershipCategory");
                String studentMembershipCategory = (String) request.getAttribute("studentMembershipCategory");

                if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Paid") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Paid")) {
            %>

            <div class="fieldNameWrapper1" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="STUDENT_AREA_LANDMARK"/>
                </div>
                <div class="labelValue2">
                    <logic:notEmpty name="studentRegistrationActionForm" property="landmark">
                        <bean:write name="studentRegistrationActionForm" property="landmark"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="landmark">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ADDRESS1"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="address"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_GURDIAN_NAME"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="guardianname"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_CONTACT_NUMBER"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="contactNumber"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_PREFERRED_CALL_TIME"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="calltime">
                        <bean:write name="studentRegistrationActionForm" property="calltime"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="calltime">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_EMAIL_ID"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="email">
                        <bean:write name="studentRegistrationActionForm" property="email"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="email">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <%                         } else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Paid") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Free")) {
            %>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_AREA_LANDMARK"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="landmark">
                        <bean:write name="studentRegistrationActionForm" property="landmark"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="landmark">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ADDRESS1"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="address"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_GURDIAN_NAME"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="guardianname"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_CONTACT_NUMBER"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="contactNumber"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_PREFERRED_CALL_TIME"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="calltime">
                        <bean:write name="studentRegistrationActionForm" property="calltime"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="calltime">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_EMAIL_ID"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="email">
                        <bean:write name="studentRegistrationActionForm" property="email"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="email">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <%                           } else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Free") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Paid")) {
            %>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_AREA_LANDMARK"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="landmark">
                        <bean:write name="studentRegistrationActionForm" property="landmark"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="landmark">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ADDRESS1"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="address"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_GURDIAN_NAME"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="guardianname"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_CONTACT_NUMBER"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="contactNumber"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_PREFERRED_CALL_TIME"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="calltime">
                        <bean:write name="studentRegistrationActionForm" property="calltime"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="calltime">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_EMAIL_ID"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="email">
                        <bean:write name="studentRegistrationActionForm" property="email"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="email">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>


            <%} else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Free") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Free")) {%>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    Contact details :
                </div>
                <div class="labelValue" style="width:auto">
                    Be a paid member to get student contact details.
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <%} else {%>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_AREA_LANDMARK"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="landmark">
                        <bean:write name="studentRegistrationActionForm" property="landmark"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="landmark">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ADDRESS1"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="address"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_GURDIAN_NAME"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="guardianname"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_CONTACT_NUMBER"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="contactNumber"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_PREFERRED_CALL_TIME"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="calltime">
                        <bean:write name="studentRegistrationActionForm" property="calltime"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="calltime">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_EMAIL_ID"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="email">
                        <bean:write name="studentRegistrationActionForm" property="email"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="email">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>


            <%}%>
            <div class="clear"></div>
        </div> <!-- Tutor box body  div close -->


        <!-- Student Education details -->
        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="STUDENT_EDUCATION_INFORMATION_DETAILS"/>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ACADEMIC_SCHOOL_OR_BOARD"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="schoolOrBoard">
                        <bean:write name="studentRegistrationActionForm" property="schoolOrBoard"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="schoolOrBoard">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_ACADEMIC_INSTITUTE_OR_UNIVERSITY"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="universityOrInstitute">
                        <bean:write name="studentRegistrationActionForm" property="universityOrInstitute"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="universityOrInstitute">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_CLASS_STANDARD"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="classstandard"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_TEACHING_MEDIUM"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="medium"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>
                <div class="clear"></div>
        </div> <!-- Tutor box body div close -->


        <!-- Tutor Requirement details -->
        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="STUDENT_TUTOR_REQUIREMENT_DETAILS"/>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_REQUIRED_TUTION_TILE"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="tutionTitle"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_TUTION_REQUIREMENT_FOR"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="tutionRequirement"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_SEGMENT_OR_LEVEL"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="segmentLevel"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_TUTION_REMARKS"/>
                </div>
                <div class="labelValue">
                    <logic:notEmpty name="studentRegistrationActionForm" property="tutionRemarks">
                        <bean:write name="studentRegistrationActionForm" property="tutionRemarks"/>
                    </logic:notEmpty>
                    <logic:empty name="studentRegistrationActionForm" property="tutionRemarks">
                        <bean:message key="NO_INFORMATION"/>
                    </logic:empty>

                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="STUDENT_REGISTRATION_DATE"/>
                </div>
                <div class="labelValue">
                    <bean:write name="studentRegistrationActionForm" property="registrationDate"/>
                </div>
                <div class="clear" align="center">
                </div>
            </div>

            <!--            <div class="fieldNameWrapper" style="margin-top:10px;">
                            <div class="profilleLabelName">
            <%

                String studentLoginUserName = (String) request.getAttribute("studentLoginUserName");
                if (null != studentLoginUserName) {
            %>
            <a href="viewForEditStudentFullProfile.do?studentId=< bean:write name="studentRegistrationActionForm" property="studentId"/>" >
                < html:image   src="images/profile.png" align="middle" alt="Edit Student Profile"/>
            </a>
            <%} else {%>

            <%}%>
        </div>
    </div>-->
            <div class="clear"></div>
        </div> <!-- Login div close -->

    </html:form>
 <!-- <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
 <div class="clear"></div>
    </div>
</div> <!-- End of Our Tutor Wrapper -->



