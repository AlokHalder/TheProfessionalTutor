<%-- <%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>
<%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.List,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<style>
     .hint {
                display: none;
                position: absolute;
                /*right: -50px;*/

                width: 200px;
                margin-top: -4px;
                border: 1px solid #c93;
                padding: 10px 12px;
                z-index: 999;
                /* to fix IE6, I can't just declare a background-color,
                I must do a bg image, too!  So I'm duplicating the pointer.gif
                image, and positioning it so that it doesn't show up
                within the box */
                background: #ffc url(../images/pointer.gif) no-repeat -10px 5px;
                color: #000;
            }
</style>

<script type="text/javascript" >

    function camelCaps(str) {
        var fieldValue = document.getElementById(str).value;
        var tempArray = fieldValue.split(',');
        // Make the first character of each word upper
        for (var i = 0; i < tempArray.length; i++) {
            tempArray[i] = tempArray[i].charAt(0).toUpperCase() + tempArray[i].substring(1);
        }
        document.getElementById(str).value = tempArray.join(',');
    }

    function limitText(limitField, limitCount, limitNum) {
        var limitFieldVar = document.getElementById(limitField).value;
        var limitCountVar = document.getElementById(limitCount).value;
        // alert("limitField 1:  "+ limitFieldVar + " limitCount : "+ limitCountVar + "limitNum : "+ limitNum);
        if (limitFieldVar> limitNum) {
            document.getElementById(limitField).value = limitFieldVar.value.substring(0, limitNum);
            // alert("Case-1 :"+ document.getElementById(limitField).value );
        } else {
            document.getElementById(limitCount).value = limitNum - limitFieldVar.length;
            // alert("Case-2 :"+ document.getElementById(limitCount).value );
        }
   
    }

    function showHideOtherTutionRequirementSubject(subjectId)
    {
        var subjectId = document.getElementById(subjectId).value;
        if(subjectId == '9997'){
            document.getElementById('subjectTextDiv').style.display = 'block';

        }else{
            document.getElementById('subjectTextDiv').style.display = 'none';
            // document.getElementById(openBoxId).style.visibility = 'hidden';
        }

        return false;
    }

    function showHideOtherTeachingSegmentLevel(teachingLevelId){
        var teachingLevelId = document.getElementById(teachingLevelId).value;
        if(teachingLevelId=='9997'){
            document.getElementById('otherTeachingLevelId').style.display = 'block';
        }else{
            document.getElementById('otherTeachingLevelId').style.display = 'none';
        }
        return false;
    }

    function  showHideOtherTeachingMedium(teachingMediumId){
        var teachingMediumId = document.getElementById(teachingMediumId).value;
        if(teachingMediumId=='9997'){
            document.getElementById('otherTeachingMediumId').style.display = 'block';
        }else{
            document.getElementById('otherTeachingMediumId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutorTeachingPatteren(tutorTeachingPatterenId){
        var tutorTeachingPatterenId = document.getElementById(tutorTeachingPatterenId).value;
        if(tutorTeachingPatterenId=='9997'){
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'block';
        }else{
            document.getElementById('otherTutorTeachingPatterenId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherTutoringOptions(tutoringOptionsId){
        var tutoringOptionsId = document.getElementById(tutoringOptionsId).value;
        if(tutoringOptionsId=='9997'){
            document.getElementById('otherTutoringOptionsId').style.display = 'block';
        }else{
            document.getElementById('otherTutoringOptionsId').style.display = 'none';
        }
        return false;
    }

    function checkUserAvailability(userLoginId){
        var userLoginName = document.getElementById(userLoginId).value;

        location.href = "checkTutorUserAvailability.do?userLoginName="+userLoginName
    }
</script>
<%
            LovDataService lovDataService = new LovDataService();

            List<ListOfValuesVO> listOfSubjects = lovDataService.populateListOfSubjects();
            List<ListOfValuesVO> listOfTeachingMediums = lovDataService.populateListOfTeachingMediums();

%>
<div class="ourToutorWrapper">
    <div id="code">
    <div class="left_green_small">
        <h1> Tutor Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1>
    </div>
<!--    <div class="cpart">
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="tutorRegistrationIntro">
                <P>Please Register Your Educational information & tutoring procedure details</P>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>  End of Tutor Box Body -->

    <html:form action="editTutoringprocedureDetailsValue">
        <%

                    String tutorId = (String) request.getAttribute("tutorId");
                    String tutorId1 = (String) request.getParameter("tutorId");

        %>

        <input type="hidden" name="studentId" value="<%=tutorId%>"/>
        <input type="hidden" name="tutorId" value="<%=tutorId1%>"/>

        <!-- Tutoring Procedure Details -->
        <div class="cpart" >
            <div class="registrationHeading">
                <bean:message key="TUTOR_TUTORING_PROCEDURE"/>
            </div>
            
            
                <%-- <div class="fieldNameWrapper" style="margin-top:10px;">--%>
                <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="labelName">
                <bean:message key="TUTOR_PREFERENCE_SUBJECTS_TO_TEACH_TO_STUDENTS"/>
            </div>
            <div>

                <html:select name="tutorRegistrationActionForm"  property="preferenceToTeachingList" styleId="subjectId" styleClass="registrationTextField"  onchange="javascript:return showHideOtherTutionRequirementSubject('subjectId')" style="height:70px;" multiple="true">
                    <html:optionsCollection name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                            <%-- <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/> 
                            <%-- <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfSubjects" label="labelName" value="labelValue"/> 
                          <%-- <%
                                        if (null != listOfSubjects) {
                                            for (ListOfValuesVO listOfValuesVO : listOfSubjects) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>--%>

                        </html:select>
                        <span class="hint"><bean:message key="PREF_TEACHING_SUBJECT_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
            <div class="clear"></div>
        </div>
                    
                    
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">

                        <bean:message key="TUTOR_TEACHING_EXPERIENCE" /><bean:message key="MANDATORY_FIELD"/>

                    </div>
                    <div>
                        <html:text name="tutorRegistrationActionForm" property="tutorYearsOfExperience" styleClass="registrationTextField">
                        </html:text>
                        <span class="hint"><bean:message key="TUTORING_EXPERIENCE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
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
                        <html:text name="tutorRegistrationActionForm" property="preferredTutoringArea" styleId="preferredTutoringArea"  styleClass="registrationTextField" onblur="camelCaps('preferredTutoringArea')">
                        </html:text>   
                        <span class="hint"><bean:message key="PREFERED_TUTORING_AREA_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="clear"></div>
                </div>
                    
                    
                    
                     <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_PATTERNS"/>
                    </div>
                    <div>
                        <html:select name="tutorRegistrationActionForm" property="tutorTeachingPatterenList" styleClass="registrationTextField" styleId="tutorTeachingPatterenId" onchange="javascript:return showHideOtherTutorTeachingPatteren('tutorTeachingPatterenId')" style="height:70px;" multiple="5">
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfTeachingParten" label="labelName" value="labelValue"/>
                        </html:select>
                        <span class="hint"><bean:message key="TEACHING_PATTEREN_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherTutorTeachingPatterenId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other pattern :
                            </div>
                            <html:text  property="otherTutorTeachingPatteren"  styleClass="registrationOtherTextField"/>
                            <span class="hint"><bean:message key="OTHER_TEACHING_PATTEREN_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                    
                    
                    
                  <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TUTORING_OPTIONS"/>
                    </div>
                    <div>
                        <html:select name="tutorRegistrationActionForm" property="tutoringOptionsList" styleClass="registrationTextField" styleId="tutoringOptionsId" onchange="javascript:return showHideOtherTutoringOptions('tutoringOptionsId')" style="height:70px;" multiple="true" >
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfTeachingOption" label="labelName" value="labelValue"/>
                        </html:select>
                        <span class="hint"><bean:message key="TUTORING_OPTIONS_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherTutoringOptionsId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other options :
                            </div>
                            <html:text  property="otherTutoringOptions"  styleClass="registrationOtherTextField" title="Please specify other tutoring options name"/>
                            <span class="hint"><bean:message key="OTHER_TUTORING_OPTION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                    
                    
                    
                    
                 <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_MEDIUM"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select name="tutorRegistrationActionForm" property="teachingMediumList" styleClass="registrationTextField"  styleId="teachingMediumId" onchange="javascript:return showHideOtherTeachingMedium('teachingMediumId')"  style="height:70px;" multiple="tue" title="Press Ctrl to select multiple teaching medium">
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfMedium" label="labelName" value="labelValue"/>
                        </html:select>
                        <span class="hint"><bean:message key="TEACHING_MEDIUM_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                         <div class="errorField"> <html:errors prefix="" property="teachingMediumList"/></div>
                        
                        <div id="otherTeachingMediumId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Specify other Medium :
                            </div>
                            <html:text name="tutorRegistrationActionForm" property="otherTeachingMedium" styleClass="registrationOtherTextField"/>
                            <span class="hint"><bean:message key="OTHER_TEACHING_MEDIUM_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="listOfMedium"/></div>
                    <div class="clear">
                    </div>
                </div>
                           
                   
                    
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_TEACHING_SEGMENT_LEVEL"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:select name="tutorRegistrationActionForm" property="teachingLevelList" styleClass="registrationTextField" styleId="teachingLevelId" onchange="javascript:return showHideOtherTeachingSegmentLevel('teachingLevelId')" style="height:70px;" multiple="true">
                            <html:optionsCollection name="tutorRegistrationActionForm" property="listOfTeachingLevel" label="labelName" value="labelValue" />

                           <%-- <%
                                        String countryName = (String) request.getSession().getAttribute("countryName");
                                        List<ListOfValuesVO> listOfTutorEducationLevel = lovDataService.populateEducationLevel(countryName);
                                        if (null != listOfTutorEducationLevel) {
                                            for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
}%>--%>
                        </html:select>
                        <span class="hint"><bean:message key="TEACHING_LEVEL_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherTeachingLevelId" style="margin-top:10px;display: none">
                            <div class="labelName">
                                Specify other level:
                            </div>
                            <html:text  property="otherTeachingLevel"  styleClass="registrationOtherTextField"/>
                            <span class="hint"><bean:message key="OTHER_TEACHING_LEVEL_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="teachingLevelList"/></div>
                    <div class="clear">

                    </div>
                    </div>
                
              
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_EXPECTED_FEES"/><bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <html:text name="tutorRegistrationActionForm" property="feeExpected" styleClass="registrationTextField" />
                        <span class="hint"><bean:message key="EXPECTED_FEES_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
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
                        <html:textarea name="tutorRegistrationActionForm" property="tutoringExperience" styleId="tutoringExperience" styleClass="registrationTextField" style="height:120px;" onkeydown="limitText('tutoringExperience','countdown',600);" onkeyup="limitText('tutoringExperience','countdown',600);"/>
                        <span class="hint"><bean:message key="TUTORING_EXPERIENCE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="errorField"> <html:errors prefix="" property="tutoringExperience"/></div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:2px; color: #000; margin-right: 5px;">
                    <div class="labelName">
                        &nbsp;
                    </div>
                    <div style="margin-top:2px; float: left; color: #000; margin-left: 12px;">
                        (Maximum characters: 600)</div>
                    <div class="clear"></div>                    
                </div>
                <div class="fieldNameWrapper" style="margin-top:2px; color: #000; margin-right: 5px;">
                    <div class="labelName">
                        &nbsp;
                    </div>
                    <div style=" float: left; color: #000; margin-left: 15px;"><font size="1">
                            You have <input readonly type="text" name="countdown" id="countdown" size="1" value="600"> characters left.</font>
                    </div>
                </div>
                     <div class="fieldNameWrapper" style="margin-top:20px;">
                <div class="errorField">
                    <html:image   src="images/save_changes_btn.png" align="middle" alt="Submit" style="margin-right:10px;"/>
                    <html:image   src="images/cancel_btn.png" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>

                </div>
                <div class="clear"></div>
            </div>
<!--                  <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        < html:image   src="images/submit_button.gif" align="middle" alt="Submit"/>
                        < html:image   src="images/cancel_button.jpg" align="middle" alt="Cancel" property="org.apache.struts.taglib.html.CANCEL"/>
                        <%--<html:image   src="images/reset.gif" align="middle" alt="Reset" onclick="javascript: return document.studentRegistrationActionForm.reset()"/>--%>
                    </div>
                    <div class="clear"></div>
                </div>-->

            
    </html:form>
<div class="clear"></div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
</div> <!-- End of Our Tutor Wrapper -->
<div class="clear"></div>
</div>
</div>
