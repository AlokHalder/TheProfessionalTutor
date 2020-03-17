<%-- <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-html.tld"  prefix="html"%> --%>

<html:form  action="viewTutorProfile">

    <table border="0" width="500">
        <thead>
            <tr>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <b><bean:write name="studentLoginActionForm" property="studentRegistrationVO.name"/></b>
                </td>
            </tr>
            <tr>
                <td><a href=""><bean:write name="studentLoginActionForm" property="studentRegistrationVO.email"/></a></td>
            </tr>
            <tr>
                <td><bean:write name="studentLoginActionForm" property="studentRegistrationVO.phone"/>,
                    <bean:write name="studentLoginActionForm" property="studentRegistrationVO.mobile"/>
                </td>
            </tr>

            <tr>
                <td>
                    <bean:write name="studentLoginActionForm" property="studentRegistrationVO.address"/>
                </td>
                <td>
                    <a href="viewStudentFullProfile.do?studentId=<bean:write name='studentLoginActionForm' property='studentRegistrationVO.studentId'/>">
                        [ View Full Profile ]</a>
                    <a href="viewForEditStudentFullProfile.do?studentId=<bean:write name='studentLoginActionForm' property='studentRegistrationVO.studentId'/>">[Edit]</a>

                </td>
            </tr>
        </tbody>
    </table>

    <table border="0">
        <thead>
            <tr bgcolor="silver">
                <th>Tutors Matching with your profile</th>
                <th></th>
            </tr>
        </thead>

        <logic:iterate id="tutor" property="listOfSubjectWiseTutor" name="studentLoginActionForm">

            <tr>
                <td width="300">
                    <bean:write name="tutor" property="tutorName"/>
                    (<bean:write name="tutor" property="tutorSex"/>/<bean:write name="tutor" property="tutorAge"/>)
                </td>
            </tr>
            <tr>
                <td>
                    Subject :  <bean:write name="tutor" property="mainsubject"/>

                </td>
            </tr>
            <tr>
                <td>
                    Area : <bean:write  name="tutor" property="tutorArea"/>

                </td>

            </tr>
            <tr>
                <td>
                    Qualification : <bean:write name="tutor" property="qualifyingDegree"/>

                </td>

            </tr>
            <tr>
                <td><input type="hidden"  name="tutorId"value="<bean:write name="tutor" property="tutorId"/>"/>
                    <bean:write name="tutor" property="tutoringExperience"/>

                </td>
                <td>
                    <html:image onclick="javascript:submit();" src="./submit.gif" border="0" value="View Tutor Profile"  />
                </td>

            </tr>
          </logic:iterate>
    </table>
</html:form>