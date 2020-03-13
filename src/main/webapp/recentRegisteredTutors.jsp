<%-- 
    Document   : recentRegisteredTutors
    Created on : Jan 13, 2020, 1:41:14 PM
    Author     : priya
--%>

<%@page contentType="text/form" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="ourToutorWrapper">
    <div class="tutorHeader">Find Tutor based upon following criteria</div>
    <div class="tutorBoxBody">
        <form:form action="searchTutor">
            <div class="profileListingSearch">
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Id :</div>
                    <div class="searchTextBox">
                        <form:textarea path="tutorId" style="width:120px; margin-left:10px;  border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif;" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Tutor Location :</div>
                    <div class="searchTextBox">

                   <form:select path="tutorCityLocation" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                        <form:option value="">-:Select Location :-</form:option>
                        <html:optionsCollection name="tutorRegiformstrationActionForm" property="listOfLocation" label="labelName" value="labelValue"/>
                        <form:option value="9997">Other</form:option>
                    </form:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Subject</div>
                    <div class="searchTextBox">
                        <form:select  path="mainsubject" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                            <form:option value="">-:Select Subject :-</form:option>
                            <form:optionsCollection name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" label="labelName" value="labelValue"/>
                           <form:option value="9997">Other</form:option>
                        </form:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Level :</div>
                    <div class="searchTextBox">
                        <form:select  path="teachingLevel" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                            <form:option value="">-:Select Level :-</form:option>
                             <form:optionsCollection name="tutorRegistrationActionForm" property="listOfEducationSegmentLevel" label="labelName" value="labelValue"/>
                            <form:option value="9997">Other</form:option>
                        </form:select>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="searchButton">
                    <form:image src="images/search_button.jpg" alt="" />
                </div>

            </div>
        </form:form>
        <div class="clear"></div>   
        <div class="clear"></div>
        <div align="center" style="margin-top:10px;">View the different profiles of tutors belonging to the Professional Tutor family. </div>
        <logic:iterate name="testList" property="listByOffsetAndLength" id="resentRegisteredTutor">
            <form:form  action="viewTutorPartialProfile">
                <div class="loginWrapper" style="padding:10px 0 10px 0; border:1px solid #999; height:auto;">
                    <div class="tutorProfileImgWrapper">
                        <div class="tutorProfileImg" style="padding:10px 0 10px 10px;">
                         <logic:equal name="resentRegisteredTutor" property="imageFlag" value="true">
                            <img src="<%=request.getContextPath()%>/tutorphotogalary/<bean:write name="resentRegisteredTutor" property="tutorId"/>.jpeg" border="0" >
                        </logic:equal>
                        <logic:equal name="resentRegisteredTutor" property="imageFlag"  value="false">
                            <logic:equal name="resentRegisteredTutor" property="tutorSex" value="M">
                                <img src="<%=request.getContextPath()%>/tutorphotogalary/male_user_icon.png"  border="0" >
                            </logic:equal>
                            <logic:equal name="resentRegisteredTutor" property="tutorSex" value="F">
                                <img src="<%=request.getContextPath()%>/tutorphotogalary/female_user_icon.png"  border="0">
                            </logic:equal>
                        </logic:equal>
                        </div>
                        <div class="profileButton" align="center">
                            <font style="font-weight: bold; font-size:  13px/20px Arial, Helvetica, sans-serif; color:#999;">
                            <bean:write name="resentRegisteredTutor" property="tutorId"/>
                            </font>
                        </div>
                        <div class="profileButton">
                             <input type="hidden"  name="tutorId" value="<bean:write name="resentRegisteredTutor" property="tutorId"/>"/>
                            <form:image   src="images/view_tuor_profile.jpg" alt="" style="width:137px;height:29px"/>
                        </div>
                       
                    </div>
                    <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName"><bean:write name="resentRegisteredTutor" property="tutorName"/></div>
                        <div class="profileNameAns">
                             (<bean:write name="resentRegisteredTutor" property="tutorSex"/>/<bean:write name="resentRegisteredTutor" property="tutorAge"/>)
                        </div>
                    </div>
                    <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName">Subject :</div>
                        <div class="profileNameAns">
                          <bean:write name="resentRegisteredTutor" property="preferenceToTeaching"/>
                          <input type="hidden"  name="tutorId" value="<bean:write name="resentRegisteredTutor" property="tutorId"/>"/>
                        </div>
                    </div>
                     <logic:notEmpty name="resentRegisteredTutor" property="preferredTutoringArea">
                    <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName">Area :</div>
                        <div class="profileNameAns">
                           
                               <bean:write  name="resentRegisteredTutor" property="preferredTutoringArea"/>
                                                 </div>
                    </div>
                    </logic:notEmpty>
                    <logic:notEmpty  name="resentRegisteredTutor" property="ugQualifyingDegree">
                      <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName">Ug Qulifacition :</div>
                        <div class="profileNameAns">
                           <bean:write  name="resentRegisteredTutor" property="ugQualifyingDegree"/>,
                           <bean:write  name="resentRegisteredTutor" property="ugSpecialization"/> <br/>                          
                        </div>
                      </div>
                    </logic:notEmpty>
                     <logic:notEmpty  name="resentRegisteredTutor" property="pgQualifyingDegree">
                     <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName">Pg Qulifacition :</div>
                        <div class="profileNameAns">
                           <bean:write  name="resentRegisteredTutor" property="pgQualifyingDegree"/>,
                           <bean:write  name="resentRegisteredTutor" property="pgSpecialization"/> <br/>
                        </div>                           
                    </div>
                     </logic:notEmpty>
                     <div class="tutorDetailsWrapper">
                        <div class="profileDetailsLabelName">Exprience :</div>
                        <div class="profileNameAns">
                            <bean:write name="resentRegisteredTutor" property="tutoringExperience"/>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </form:form>
        </logic:iterate>
        <%--  <div class="findMore"> --%>
        <div>
        <logic:iterate name="testList" property="pages" id="varpage">
            <form:link action="/resentRegisteredTutors.do" paramName="varpage" paramId="page"  paramId="page">
                <bean:write name="varpage" />
            </form:link>
        </logic:iterate>
             </div>
    </div> <!-- Tutor Box body div close -->
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div> <!-- End of Our Tutor Wrapper -->
