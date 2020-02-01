<%-- <%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %> --%>

<div style="background-color: lightblue">
    <h2> Search your tutor based upon any of following criteria </h2>
</div>
<div style="background-color: lightyellow">
    <table border="0">
        <tbody>
            <tr>
                <td>Tutor Id :</td>
                <td><input type="text"/></td>
                <td>Tutor Name :</td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td>Tutor Subject :</td>
                <td>
                    <select>
                        <option>-:Select Subject :-</option>
                        <option>English</option>
                        <option>Bengali</option>
                    </select>
                </td>
                <td>Tutor Segment/Level</td>
                <td> <select>
                        <option>-:Select Level :-</option>
                        <option>Nursery</option>
                        <option>Graduation</option>
                    </select></td>
            </tr>
            <tr>
                <td>Teaching Medium</td>
                <td>
                    <select>
                        <option>-:Select Medium :-</option>
                        <option>English</option>
                        <option>Bengali</option>
                    </select>
                </td>
                <td></td>
                <td><input type="submit" value=" Search "/></td>
            </tr>
        </tbody>
    </table>
</div>
<font color="#8adoff" style="font-weight: bolder"> <bean:message key="dottedline" /></font>

<div>
    <span>
    <logic:iterate id="tutor" property="listOfSubjectWiseTutor" name="linkActionForm"> 
        <html:form  action="viewTutorPartialProfile.do">
        <table border="0">
        <tr>
            <td width="300">
                 <bean:write name="tutor" property="tutorName"/>
                 (<bean:write name="tutor" property="tutorSex"/>/<bean:write name="tutor" property="tutorAge"/>)
            </td>
            <td width="300">
                <bean:write name="tutor" property="tutorId"/>
                  <table border="1">
                      <tr>
                          <td height="30" width="30">
                               <logic:equal name="tutor" property="imageFlag" value="true">
                                   <img src="tutorphotogalary/<bean:write name="tutor" property="tutorId"/>.jpeg" width="100" height="100" border="0" >
                               </logic:equal>
                               <logic:equal name="tutor" property="imageFlag"  value="false">
                                   <logic:equal name="tutor" property="tutorSex" value="Male">
                                         <img src="tutorphotogalary/male_user_icon.png" width="100" height="100" border="0" >
                                    </logic:equal>
                                    <logic:equal name="tutor" property="tutorSex" value="Female">
                                        <img src="tutorphotogalary/female_user_icon.png" width="100" height="100" border="0">
                                    </logic:equal>
                               </logic:equal>
                          </td>
                      </tr>
                  </table>
              </td>

        </tr>
        <tr>
            <td>
                Subject :  <bean:write name="tutor" property="mainsubject"/>

            </td>
            <td>
                <input type="hidden"  name="tutorId" value="<bean:write name="tutor" property="tutorId"/>"/>
                                
                <html:submit value="View Tutor Profile"/>
               <%-- <html:image onclick="javascript:submit();" src="./submit.gif" border="0"  property="method" value="viewTutorProfile"  /> --%>
                
            </td>

        </tr>
         <tr>
            <td>
              Area : <bean:write  name="tutor" property="tutorArea"/>

            </td>
            <td>
                 <a href="Link.do?method=loginForUpdateTutorProfile&tutorId=<bean:write name="tutor" property="tutorId"/>">Tutor login  to update profile</a>
               
            </td>

        </tr>
         <tr>
            <td>
              Qualification : 

            </td>
             <td>
                  <a href="Link.do?method=loginForTutorContactDetails&tutorId=<bean:write name="tutor" property="tutorId"/>">View Contact Details</a>
            </td>
        </tr>
        <tr>
            <td>
               Experience : <bean:write name="tutor" property="tutoringExperience"/>

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


    </span>
</div>

