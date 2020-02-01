<%-- <%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%> --%>
<%@page import="java.util.List,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO"%>



<script type="text/javascript" >

    function showHideOtherUgQualifyingDegree(ugQualifyingDegreeId){
        var ugQualifyingDegreeId = document.getElementById(ugQualifyingDegreeId).value;
        if(ugQualifyingDegreeId=='9997'){
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'block';
        }else{
            document.getElementById('otherUgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }

   
</script>
<html:base/>
<%
    LovDataService lovDataService = new LovDataService();

    List<ListOfValuesVO> listOfBasicUgCourses = lovDataService.populateListOfBasicUgCourses();

%>
<div class="ourToutorWrapper">
     <div id="code">
    <div class="left_green_small">
        <h1> Tutor Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1>
    </div>
<!--    <div class="cpart" style="margin: 15px 10px -20px 10px; ">
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="tutorRegistrationIntro">
                <P>Please Register Your Educational information & tutoring procedure details</P>
            </div>
            <div class="clear"></div>
        </div>
         <div class="clear"></div>
    </div>  End of Tutor Box Body -->

    <html:form action="tutorEduAndTeachingProcUpdate">   
        <html:hidden property="tutorId" name="tutorRegistrationActionForm"/>
        <!-- Tutor Education Information Details -->
        <div class="cpart" style="margin-top: -20px;">
            <div class="registrationHeading">
                <bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/>
            </div>
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_UGCOURSE"/>
                    </div>
                    <div >
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="ugQualifyingDegree">
                            <html:option value="-1">-:Select Graduation:-</html:option>
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfBasicUgCourses" label="labelName" value="labelValue"/>
                        </html:select>
                    </div> 
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                    </div>
                    <div class="labelName">
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="ugSpecialization">
                            <html:option value="-1">-:Select Specialization :-</html:option>
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                        </html:select>
                    </div> 
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div class="labelValue">
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="ugBoardOrUniversity">
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfUniversityInstitute" label="labelName" value="labelValue"/>
                        </html:select>
                    </div> 
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11" >
                        <bean:message key="TUTOR_YEAR"/>
                    </div>
                    <div class="labelValue">
                        <html:select name="tutorRegistrationActionForm" property="ugPassoutYear" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/yearOfPassout.jspf"  %>
                        </html:select>
                        <%-- <html:text name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11" property="ugPassoutYear"/> --%>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_PGCOURSE"/>
                    </div>
                    <div class="labelValue">
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="pgQualifyingDegree">
                            <html:option value="-1">-:Select Post Graduation:-</html:option>
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfBasicPgCourses" label="labelName" value="labelValue"/>
                        </html:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                        <!--/Major Subject:-->
                    </div>
                    <div class="labelValue">
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="pgSpecialization">
                            <html:option value="-1">-:Select Specialization :-</html:option>
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                        </html:select>
                    </div> 
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div class="labelValue">
                        <html:select name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11"  property="pgBoardOrUniversity">
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfUniversityInstitute" label="labelName" value="labelValue"/>
                        </html:select>
                    </div> 
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName11">
                        <bean:message key="TUTOR_YEAR"/>
                    </div>
                    <div class="labelValue">
                        <%--  <html:text name="tutorRegistrationActionForm" styleClass="registrationOtherTextField11" property="pgPassoutYear"/> --%>
                      <html:select name="tutorRegistrationActionForm"  property="pgPassoutYear" styleClass="registrationTextField">
                            <%@ include file = "/jsp/library/yearOfPassout.jspf"  %>
                        </html:select>
                    </div>
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
                        < html:image   src="images/submit_button.gif" align="middle" alt="Submit"/>
                        < html:image   src="images/cancel_button.jpg" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>
                        <%--<html:image   src="images/reset.gif" align="middle" alt="Reset" onclick="javascript: return document.studentRegistrationActionForm.reset()"/>--%>
                    </div>
                    <div class="clear"></div>
                </div>-->
            </div>
             <div class="clear"></div>
        </div> <!-- End of Login Wrapper -->
    </html:form>
        <div class="clear"></div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
     </div>
</div> <!-- End of Our Tutor Wrapper -->

