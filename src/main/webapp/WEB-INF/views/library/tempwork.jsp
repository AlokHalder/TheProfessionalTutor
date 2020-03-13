<%-- <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> --%>

<div style="background-color: lightblue">
    <h2> Search your tutor based upon any of following criteria </h2>
</div>
<html:form action="searchTutor">
    <div style="background-color: lightyellow">
        <table border="0">
            <tbody>
                <tr>
                    <td>Tutor Id :</td>
                    <td><html:text property="tutorId"/></td>
                    <td>Tutor Location :</td>
                    <td>
                        <html:select  property="tutorCityLocation" style="width:160px; margin:5px 5px 2px 10px; height:32px; border: 1px solid #59A7F5; font: normal 18px/28px 'Trebuchet MS'; color:#666;">
                            <html:option value="">-:Select Location :-</html:option>
                            <logic:present name="tutorRegistrationActionForm" property="listOfLocation">
                                <logic:iterate id="location" name="tutorRegistrationActionForm" property="listOfLocation" >
                                    <html:option value="${location}"> <bean:write name="location" /></html:option>
                                </logic:iterate>
                            </logic:present>
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td>Tutor Segment/Level</td>
                    <td>  <html:select  property="teachingLevel" style="width:160px; margin:5px 5px 2px 10px; height:32px; border: 1px solid #59A7F5; font: normal 18px/28px 'Trebuchet MS'; color:#666;">
                            <html:option value="">-:Select Level :-</html:option>
                            <logic:present name="tutorRegistrationActionForm" property="listOfEducationSegmentLevel">
                                <logic:iterate id="val" name="tutorRegistrationActionForm" property="listOfEducationSegmentLevel" >
                                    <html:option value="${val}"> <bean:write name="val"/></html:option>
                                </logic:iterate>
                            </logic:present>
                        </html:select>
                    </td>

                    <td>Tutor Subject :</td>
                    <td>
                        <html:select  property="mainsubject" style="width:160px; margin:5px 5px 2px 10px; height:32px; border: 1px solid #59A7F5; font: normal 18px/28px 'Trebuchet MS'; color:#666;">
                            <html:option value="">-:Select Subject :-</html:option>
                            <logic:present name="tutorRegistrationActionForm" property="listOfSubjectSubCategory">
                                <logic:iterate id="val" name="tutorRegistrationActionForm" property="listOfSubjectSubCategory" >
                                    <html:option value="${val.labelName}"> <bean:write name="val" property="labelName"/></html:option>
                                </logic:iterate>
                            </logic:present>
                        </html:select>
                    </td>


                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value=" Search "/>
                        <input type="reset" value=" Reset "/>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</html:form>
<font color="#8adoff" style="font-weight: bolder"> <bean:message key="dottedline" /></font>
<logic:present name="testList" property="listByOffsetAndLength">
    <logic:iterate name="testList" property="listByOffsetAndLength" id="resentRegisteredTutor">
        <html:form  action="viewTutorPartialProfile">
            <table border="0">
                <tr>
                    <td width="300">
                        <bean:write name="resentRegisteredTutor" property="tutorName"/>
                        (<bean:write name="resentRegisteredTutor" property="tutorSex"/>/<bean:write name="resentRegisteredTutor" property="tutorAge"/>)
                    </td>
                    <td width="300">
                        <bean:write name="resentRegisteredTutor" property="tutorId"/>
                        <table border="1">
                            <tr>
                                <td height="30" width="30">
                                    <logic:equal name="resentRegisteredTutor" property="imageFlag" value="true">
                                        <img src="<%=request.getContextPath()%>/tutorphotogalary/<bean:write name="resentRegisteredTutor" property="tutorId"/>.jpeg" width="100" height="100" border="0" >
                                    </logic:equal>
                                    <logic:equal name="resentRegisteredTutor" property="imageFlag"  value="false">
                                        <logic:equal name="resentRegisteredTutor" property="tutorSex" value="Male">
                                            <img src="<%=request.getContextPath()%>/tutorphotogalary/male_user_icon.png" width="100" height="100" border="0" >
                                        </logic:equal>
                                        <logic:equal name="resentRegisteredTutor" property="tutorSex" value="Female">
                                            <img src="<%=request.getContextPath()%>/tutorphotogalary/female_user_icon.png" width="100" height="100" border="0">
                                        </logic:equal>
                                    </logic:equal>
                                </td>
                            </tr>
                        </table>
                    </td>

                </tr>
                <tr>
                    <td>
                        Subject :  <bean:write name="resentRegisteredTutor" property="mainsubject"/>

                    </td>
                    <td>
                        <input type="hidden"  name="tutorId" value="<bean:write name="resentRegisteredTutor" property="tutorId"/>"/>

                        <html:submit value="View Tutor Profile"/>

                        <%--  <html:image onclick="javascript:submit();" src="./submit.gif" border="0"  property="method" value="viewTutorProfile"  /> --%>

                    </td>

                </tr>
                <tr>
                    <td>
                        Area : <bean:write  name="resentRegisteredTutor" property="tutorArea"/>

                    </td>
                    <td>
                        <a href="loginForUpdateTutorProfile.do?tutorId= <bean:write  name="resentRegisteredTutor" property="tutorId"/>">Tutor login  to update profile</a>

                    </td>

                </tr>
                <tr>
                    <td>
                        Qualification :

                    </td>
                    <td>
                        <a href="viewTutorContactDetails.do?tutorId=<bean:write name="resentRegisteredTutor" property="tutorId"/>">View Contact Details</a>
                    </td>
                </tr>
                <tr>
                    <td>
                        Experience : <bean:write name="resentRegisteredTutor" property="tutoringExperience"/>

                    </td>

                </tr>
                <tr>
                    <td>


                    </td>

                </tr>
            </table>
            <font color="#8adoff" style="font-weight: bolder"> <bean:message key="dottedline" /></font>

        </html:form>
    </logic:iterate>
</logic:present>
            <br/>
<logic:notPresent name="testList">
  <bean:message key="TUTOR_SEARCH_NO_RESULT_FOUND"/>
</logic:notPresent>

<div style="background-color: inherit" align="right">
<logic:present name="testList" property="pages">
    <logic:iterate name="testList" property="pages" id="varpage">
        <html:link action="/searchTutor.do" paramName="varpage" paramId="page">
            <bean:write name="varpage" />
        </html:link>
    </logic:iterate>
</logic:present>
</div>



