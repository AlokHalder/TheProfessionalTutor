<style>
    .tutorProfileImg{ width:88px; height:105px;  padding:0; margin-left: 211px; border:1px solid #BABABA; background:#EAEAEA;}
    .tutorProfileImg img{ margin: 10px 15px; width:58px; height:82px; padding:0;}
    .fieldNameWrapper {
    width: 730px;
    float: left;
    padding: 0px;
    margin: 0px 0px 0px 20px;
}
.labelValue {
    width: 490px;
    float: left;
    padding: 0px;
    margin-bottom: 10px;
    margin-left: 20px;
    font: 12px/15px Arial,Helvetica;
    color: #666;
    text-align: left;
}

</style>

<%-- <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> --%>


<%
    HttpSession httpSession = request.getSession();
    String studentId = (String) httpSession.getAttribute("studentId");
    String tutorId = (String) httpSession.getAttribute("tutorId");
    String instituteId = (String) httpSession.getAttribute("instituteId");
%>

<div class="newWelcomeToutorWrapper"><!--ADD ON 23-1-14-->
    <div id="code">
        <div class="left_green_small"><!--ADD ON 23-1-14-->
            <h1>Tutor Profile</h1>

        </div>
       <%-- <div class="cpart"><!--ADD ON 23-1-14-->
            <div class="fieldNameWrapper" style="margin-top:0px;width: 730px; color: #999;">
                <logic:equal name="tutorRegistrationActionForm" property="documentVerificationFlag" value="1">
                    <font color="red" size="2" >*</font>  <font size="2px">Tutor documents has been verified by The Professional Tutors</font>
                </logic:equal>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>--%>

        <%

            if (null != studentId || null != tutorId || null != instituteId) {

        %>

        <%}%>
        <%--  <html:form action="tutorProfileRegistration"> --%>
        <div class="cpart">
            <div class="left_green_small">
                <h1>Tutor Profile Information</h1>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px; width: 730px;">
                <div class="profilleLabelName">
                    <bean:write name="tutorRegistrationActionForm" property="tutorName"/>
                    (<bean:write name="tutorRegistrationActionForm" property="tutorSex"/>/<bean:write name="tutorRegistrationActionForm" property="tutorAge"/>)
                </div>
                <%--<div class="labelValue">
                    <img src="tutorphotogalary/<bean:write name="tutorRegistrationActionForm" property="tutorId"/>.jpeg" width="45" height="45"><br>
                    <bean:write name="tutorRegistrationActionForm" property="tutorId"/>
                </div>
                --%>
                <div class="tutorProfileImg">                  
                    <logic:equal name="tutorRegistrationActionForm" property="imageFlag" value="true">
                        <%--<img src="<%=request.getContextPath()%>/tutorphotogalary/<bean:write name="tutorRegistrationActionForm" property="tutorId"/>.jpeg"  border="0" >--%>
                        <img src="<%=request.getContextPath()%>/Photo-Upload/<bean:write name="tutorRegistrationActionForm" property="photoFileName"/>"  border="0" width="50" height="100">
                    </logic:equal>
                    <logic:equal name="tutorRegistrationActionForm" property="imageFlag"  value="false">
                        <logic:equal name="tutorRegistrationActionForm" property="tutorSex" value="M">
                            <img src="<%=request.getContextPath()%>/tutorphotogalary/male_user_icon.png"  border="0" >
                        </logic:equal>
                        <logic:equal name="tutorRegistrationActionForm" property="tutorSex" value="F">
                            <img src="<%=request.getContextPath()%>/tutorphotogalary/female_user_icon.png" border="0">
                        </logic:equal>
                    </logic:equal>
                </div>

                <div class="clear">
                </div>
            </div>
            <!-- Subject -->
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    Tutor Id :
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="tutorId"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="clear"></div>

        </div> <!-- End of Tutor Box Body -->


        <!-- Tutor Education Information Details -->
        <div class="cpart">
            <div class="newregistrationHeading">
                <!--<bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/> -->
                Tutor Academic Background

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
            <div class="newregistrationHeading">
                <bean:message key="TUTOR_TUTORING_PROCEDURE"/>
            </div>


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <%-- <bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS"/> --%>
                    Teaching Subjects :
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="preferenceToTeaching"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="teachingLevel"/>
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
                    <bean:message key="TUTOR_TUTORING_OPTIONS"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="tutoringOptions"/>
                </div>
                <div class="clear"></div>
            </div>
            <logic:notEmpty name="tutorRegistrationActionForm"   property="tutorTeachingPatteren">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="profilleLabelName">
                        <bean:message key="TUTOR_TEACHING_PATTERNS"/>
                    </div>
                    <div class="labelValue">
                        <bean:write name="tutorRegistrationActionForm" property="tutorTeachingPatteren"/>
                    </div>
                    <div class="clear"></div>
                </div>
            </logic:notEmpty>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <%-- <bean:message key="TUTOR_TEACHING_EXPERIENCE" /> --%>
                    Years Of Experience :
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="tutorYearsOfExperience"/> Years
                    <%-- &  <bean:write name="tutorRegistrationActionForm" property="tutorMonthsOfExperience"/>  --%>
                </div>
                <div class="clear">
                </div>
            </div>
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
                    <bean:message key="TUTOR_EXPECTED_FEES"/>
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="feeExpected"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px; width: 730px;">
                <div class="profilleLabelName">
                    <bean:message key="TUTORING_EXPERIENCE"/>
                </div>
                <div class="labelValue" style="width: 490px; ">
                    <bean:write name="tutorRegistrationActionForm" property="tutoringExperience"/>
                </div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>

        </div> <!-- End of Tutor Box Body -->


        <div class="cpart">
            <logic:present name="tutorRegistrationActionForm" property="listOfTeachingArena">
                <div class="newregistrationHeading">
                    Tutor Teaching Arena
                </div>

                <!-- Subject -->
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <table width="570px" border="0" cellpadding="0" cellspacing="2" >
                        <tr>

                            <TD width="160px"> <font style="color: #800000;font-weight: bold">Classes/Level</font></TD>
                            <TD width="200px"><font style="color: #800000;font-weight: bold">Subjects</font></TD>
                            <TD width="180px"><font style="color: #800000;font-weight: bold">Board</font></TD>
                            <TD width="180px"><font style="color: #800000;font-weight: bold;">&nbsp;Medium</font></TD>
                        </tr>
                        <logic:iterate name="tutorRegistrationActionForm" property="listOfTeachingArena" id="listOfTeachingArena">
                            <tr>
                                <TD style="color: black; width:160px"> <bean:write  name="listOfTeachingArena" property="teachingClassLevel"/></TD>
                                <TD style="color: black; width:200px"><bean:write  name="listOfTeachingArena" property="teachingSubjects"/></TD>
                                <TD style="color: black; width:180px"><bean:write  name="listOfTeachingArena" property="teachingBoard"/></TD>
                                <TD style="color: black; width:180px"><bean:write  name="listOfTeachingArena" property="teachingMedium"/></TD>
                            </tr>
                        </logic:iterate>


                    </table>
                </div>
            </logic:present>
            <%


                String studentMemberShipcategory = (String) httpSession.getAttribute("studentMembershipCategory");
                String tutorMemebreShipcategory = (String) httpSession.getAttribute("tutorMembershipCategory");
                String instituteMemberShipcategory = (String) httpSession.getAttribute("instituteMembershipCategory");
                if ((null != studentMemberShipcategory && studentMemberShipcategory.equalsIgnoreCase("Paid")) || (null != instituteMemberShipcategory && instituteMemberShipcategory.equalsIgnoreCase("Paid"))) {

            %>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    Contact No :
                </div>
                <div class="labelValue">
                    <bean:write name="tutorRegistrationActionForm" property="tutorContactNumber"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <%} else if (null != studentMemberShipcategory && studentMemberShipcategory.equalsIgnoreCase("Free")) {%>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    Contact Details :
                </div>
                <div>
                    <p style="color: red">Please be a paid member to get this tutor contact details.</p>

                </div>
                <div class="clear">
                </div>
            </div>
            <%} else {%>   
            <%

                if (null != tutorId) {

            %>


            <%} else {%>  
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName">
                    <input type="hidden"  name="tutorId" value="<bean:write name="tutorRegistrationActionForm" property="tutorId"/>"/>
                </div>
                <div class="labelValue">
                    <a href="viewTutorContactDetails.do?tutorId=<bean:write name="tutorRegistrationActionForm" property="tutorId"/>">
                        <html:img src="images/view_contact_details.gif" align="middle" alt="View Contact Details"/>
                    </a>
                </div>
                <div class="clear">
                </div>
            </div>

            <%}%>
            <div class="clear"></div>

        </div> <!-- End of Tutor Box Body -->
        <%}%>

        <%-- </html:form> --%>
        <!--    <div class="tutorBoxBottom"><img src="images/new-welcome-bottom.gif" alt="" /></div>ADD ON 23-1-14-->
        <div class="clear">
        </div>
    </div>
</div> <!-- End of Our Tutor Wrapper -->








