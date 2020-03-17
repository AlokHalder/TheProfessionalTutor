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
<%-- <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:errors/> --%>

<%
    String tutorLoginUserName = (String) request.getAttribute("tutorLoginUserName");
    String studentLoginUserName = (String) request.getAttribute("studentLoginUserName");
%>
<div id="code">
    <div class="left_green_small"><h1>Tutor Profile</h1></div>
    
    <div class="tutorBoxBody">
        <div class="fieldNameWrapper1" style="margin-top:10px;width: auto;">
            <logic:equal name="tutorRegistrationActionForm" property="documentVerificationFlag" value="1">
                <font color="red" size="2" >*</font>  <font size="2px">Tutor documents has been verified by The Professional Tutors</font>
            </logic:equal>
            <div class="clear"></div>
        </div>

    </div>

    <div class="cpart">
        <div class="registrationHeading">
            <bean:message key="TUTOR_PERSONAL_DETAILS"/><bean:message key="TUTOR_CONTACT_INFORMATION"/>
            <!--This section is used for view tutor contact details-->
            <%
                if (null != tutorLoginUserName) {

            %>

            <!--            <a href="viewForEditTutorFullProfile.do?tutorId=< bean:write name='tutorRegistrationActionForm' property='tutorId'/>"style="float: right"> [Edit]
            
                        </a>-->

            <%}%>

        </div>

        <div class="fieldNameWrapper1" style="margin-top:10px;">
             <div style="float: left; width: 280px;" >
            <div class="profilleLabelName2">
                <bean:write name="tutorRegistrationActionForm" property="tutorName"/>
                (<bean:write name="tutorRegistrationActionForm" property="tutorSex"/>/<bean:write name="tutorRegistrationActionForm" property="tutorAge"/>)
            </div>
        </div>
        </div>
            <logic:equal name="tutorRegistrationActionForm" property="imageFlag" value="true">
                <div style="float: right; width: 100px;height: 80px; margin-right: 10px;">
                    <img src="<%=request.getContextPath()%>/Photo-Upload/<bean:write name="tutorRegistrationActionForm" property="photoFileName"/>" align="right" height="80"  width="100" >
                </div>
            </logic:equal>
            <logic:equal name="tutorRegistrationActionForm" property="imageFlag" value="false">
                <div style="float: right; width: 100px;height: 80px; margin-right: 10px;">
                    <logic:equal name="tutorRegistrationActionForm" property="tutorSex" value="M">
                        <img src="<%=request.getContextPath()%>/tutorphotogalary/male_user_icon.png" align="right" height="80"  width="100" >
                    </logic:equal>
                    <logic:equal name="tutorRegistrationActionForm" property="tutorSex" value="F">
                        <img src="<%=request.getContextPath()%>/tutorphotogalary/female_user_icon.png" align="right" height="80"  width="100">
                    </logic:equal>
                </div>
            </logic:equal>
        
        <div class="fieldNameWrapper1" style="margin-top:10px;">
            <div class="profilleLabelName2">
                <bean:message key="TUTOR_ID"/>
            </div>
            <div class="labelValue2">
                <bean:write name="tutorRegistrationActionForm" property="tutorId"/>
            </div>
            
        </div>

        <div class="fieldNameWrapper1" style="margin-top:10px;">
            <div class="profilleLabelName2">
                <bean:message key="TUTOR_COUNTRY_LOCATION"/>
            </div>
            <div class="labelValue2">
                <bean:write name="tutorRegistrationActionForm" property="tutorCountryLocation"/>
            </div>
           
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName2">
                <bean:message key="TUTOR_CITY_LOCATION"/>
            </div>
            <div class="labelValue2">
                <bean:write name="tutorRegistrationActionForm" property="tutorCityLocation"/>
            </div>
            <div class="clear">
            </div>
        </div>

        <%
          String tutorMembershipCategory = (String) request.getAttribute("tutorMembershipCategory");
          String studentMembershipCategory = (String) request.getAttribute("studentMembershipCategory");
           if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Paid") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Paid")) {
        %>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorAddress"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                Contact Number :
            </div>
            <div>              
                <bean:write name="tutorRegistrationActionForm" property="tutorContactNumber"/>             
            </div>
            <div class="clear">
            </div>
        </div>     

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorEmailId"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <%                         } else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Paid") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Free")) {
        %>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorAddress"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                Contact Number :
            </div>
            <div>               
                <bean:write name="tutorRegistrationActionForm" property="tutorContactNumber"/>     
            </div>
            <div class="clear">
            </div>
        </div>     

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorEmailId"/>
            </div>
            <div class="clear">
            </div>
        </div>



        <%                           } else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Free") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Paid")) {
        %>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorAddress"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                Contact Number :
            </div>
            <div>
                <bean:write name="tutorRegistrationActionForm" property="tutorContactNumber"/>
            </div>
            <div class="clear">
            </div>
        </div>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorEmailId"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <%} else if (null != tutorMembershipCategory && tutorMembershipCategory.equalsIgnoreCase("Free") && null != studentMembershipCategory && studentMembershipCategory.equalsIgnoreCase("Free")) {%>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                Contact Details :
            </div>
            <div>
                Please be a paid member to get this tutor contact details.

            </div>
            <div class="clear">
            </div>
        </div>

        <%} else {%>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_PRESENT_RESIDENCIAL_ADDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorAddress"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                Contact Number :
            </div>
            <div>
                <bean:write name="tutorRegistrationActionForm" property="tutorContactNumber"/>
            </div>
            <div class="clear">
            </div>
        </div>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorEmailId"/>
            </div>
            <div class="clear">
            </div>
        </div>

        <%}%>


        <div class="clear"></div>
    </div> <!-- End of Tutor Box Body -->
    

    <!-- Tutor Education Information Details -->
    <div class="cpart">
        <div class="registrationHeading">
            <bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/>
            <!--This section is used for view tutor contact details-->
            <%
                                        if (null != tutorLoginUserName) {
            %>

            <!--            <a href="viewForEditTutorEducationalInformation.do?tutorId=< bean:write name='tutorRegistrationActionForm' property='tutorId'/>"style="float: right"> [Edit]
            
                        </a>-->

            <%}%>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_UGCOURSE"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="ugQualifyingDegree"/>
            </div>
            <div class="clear"></div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_SPECIALIZATION"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="ugSpecialization"/>
            </div>
            <div class="clear"></div>
        </div>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="ugBoardOrUniversity"/>
            </div>
            <div class="clear"></div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_YEAR"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="ugPassoutYear"/>
            </div>
            <div class="clear"></div>
        </div>
        <logic:notEqual name="tutorRegistrationActionForm" property="pgQualifyingDegree" value="">

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTOR_PGCOURSE"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="pgQualifyingDegree"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTOR_SPECIALIZATION"/>
                    <!--/Major Subject:-->
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="pgSpecialization"/>
                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="pgBoardOrUniversity"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTOR_YEAR"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="pgPassoutYear"/>

                </div>
                <div class="clear"></div>
            </div>
        </logic:notEqual>
            <div class="clear"></div>

    </div> <!-- End of Tutor Box Body -->


    <!-- Tutoring Procedure Details -->
    <div class="cpart">
        <div class="registrationHeading">
            <bean:message key="TUTOR_TUTORING_PROCEDURE"/>
            <!--This section is used for view tutor contact details-->
            <%
                                        if (null != tutorLoginUserName) {
            %>

            <!--            <a href="viewForEditTutorTutoringProcedureInformation.do?tutorId=< bean:write name='tutorRegistrationActionForm' property='tutorId'/>"style="float: right"> [Edit]
                        </a>-->
            <%}%>
        </div>


        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="preferenceToTeaching"/>
            </div>
            <div class="clear"></div>
        </div>

        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TEACHING_EXPERIENCE" />
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorYearsOfExperience"/> Years
                <%-- &  <bean:write name="tutorRegistrationActionForm" property="tutorMonthsOfExperience"/>  --%>
            </div>
            <div class="clear">
            </div>
        </div>
            <div >
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TUTORING_AREA_PREFERENCE"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="preferredTutoringArea"/>
            </div>
            <div class="clear"></div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TEACHING_PATTERNS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutorTeachingPatteren"/>
            </div>
            <div class="clear"></div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TUTORING_OPTIONS"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutoringOptions"/>
            </div>
            <div class="clear"></div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TEACHING_MEDIUM"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="teachingMedium"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="teachingLevel"/>
            </div>
            <div class="clear">
                <html:errors prefix="" property="teachingLevel"/>
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTOR_EXPECTED_FEES"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="feeExpected"/>
            </div>
            <div class="clear">
            </div>
        </div>
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="profilleLabelName">
                <bean:message key="TUTORING_EXPERIENCE"/>
            </div>
            <div class="labelValue">
                <bean:write name="tutorRegistrationActionForm" property="tutoringExperience"/>
            </div>
            <div class="clear"></div>
        </div>

    </div> <!-- End of Tutor Box Body -->
     <div class="clear"></div>
    </div>
            <div class="clear"></div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
</div> <!-- End of Our Tutor Wrapper -->








