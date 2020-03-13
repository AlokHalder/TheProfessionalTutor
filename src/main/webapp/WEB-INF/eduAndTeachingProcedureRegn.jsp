<style>
    .registrationTextField1 {
    width: 240px;
    margin: 0px 0px 0px 0px;
    height: 20px;
    border: 1px solid #0777E8;
    font: 13px/20px Arial,Helvetica,sans-serif;
    color: #666;
}
</style>

<%@taglib  uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page  import="com.tutors.model.TutorModel" %>
<%@page import="java.util.List,com.tutors.vo.LocationVO" %>
<%@page import="com.tutors.model.LovDataService" %>
<%@page import="com.tutors.vo.ListOfValuesVO"%>


<SCRIPT type="text/javascript">
            function addRow(tableID) {
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var row = table.insertRow(rowCount);
                var colCount = table.rows[0].cells.length;
                for(var i=0; i<colCount; i++) {
                    var newcell = row.insertCell(i);
                    newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                    //alert(newcell.childNodes);
                    switch(newcell.childNodes[0].type) {
                        case "text":
                            newcell.childNodes[0].value = "";
                            break;
                        case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                        case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                    }
                }
            }
            function deleteRow(tableID) {
                try {
                    var table = document.getElementById(tableID);
                    var rowCount = table.rows.length;
                    for(var i=0; i<rowCount; i++) {
                        var row = table.rows[i];
                        var chkbox = row.cells[0].childNodes[0];
                        if(null != chkbox && true == chkbox.checked) {
                            if(rowCount <= 1) {
                                alert("Cannot delete all the rows.");
                                break;
                            }
                            table.deleteRow(i);
                            rowCount--;
                            i--;
                        }
                    }
                }catch(e) {
                    alert(e);
                }
            }
        </SCRIPT>
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

    function showHideOtherUgBoardOrUniversity(ugBoardOrUniversityId){
        var ugBoardOrUniversityId = document.getElementById(ugBoardOrUniversityId).value;
        if(ugBoardOrUniversityId=='9997'){
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'block';
        }else{
            document.getElementById('otherUgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

    function showHideOtherUgSpecialization(ugSpecializationId){
        var ugSpecializationId = document.getElementById(ugSpecializationId).value;
        if(ugSpecializationId=='9997'){
            document.getElementById('otherUgSpecializationId').style.display = 'block';
        }else{
            document.getElementById('otherUgSpecializationId').style.display = 'none';
        }
        return false;
    }

   

    function showHideOtherPgQualifyingDegree(pgQualifyingDegreeId){
        var pgQualifyingDegreeId = document.getElementById(pgQualifyingDegreeId).value;
        if(pgQualifyingDegreeId=='9997'){
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'block';
        }else{
            document.getElementById('otherPgQualifyingDegreeId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgSpecialization(pgSpecializationId){
        var pgSpecializationId = document.getElementById(pgSpecializationId).value;
        if(pgSpecializationId=='9997'){
            document.getElementById('otherPgSpecializationId').style.display = 'block';
        }else{
            document.getElementById('otherPgSpecializationId').style.display = 'none';
        }
        return false;
    }
    function showHideOtherPgBoardOrUniversity(pgBoardOrUniversityId){
        var pgBoardOrUniversityId = document.getElementById(pgBoardOrUniversityId).value;
        if(pgBoardOrUniversityId=='9997'){
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'block';
        }else{
            document.getElementById('otherPgBoardOrUniversityId').style.display = 'none';
        }
        return false;
    }

   
</script>
<html:base/>
<%
            LovDataService lovDataService = new LovDataService();

            List<ListOfValuesVO> listOfBasicUgCourses = lovDataService.populateListOfBasicUgCourses();
            List<ListOfValuesVO> listOfSubjects = lovDataService.populateListOfSubjects();
            List<ListOfValuesVO> listOfUniversityInstitute = lovDataService.populateListOfUniversityInstitute("India");
            List<ListOfValuesVO> listOfBasicPgCourses = lovDataService.populateListOfBasicPgCourses();

%>
<div class="ourToutorWrapper">
    <div id="code">
    <div class="left_green_small">
        <h1> Tutor Registration Form  &nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;
        <font style="font-size: 14px;"><bean:message key="MANDATORY_FIELD"/> <bean:message key="REQUIRED_FIELDS"/></font>
        </h1>
    </div>
        <%-- <div class="cpart">
        <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="tutorRegistrationIntro">
                <P>Please Register Your Educational information & tutoring procedure details</P>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div> --%> 
        <!-- End of Tutor Box Body -->

    <html:form action="tutorEduAndTeachingProcRegistration">        
        <!-- Tutor Education Information Details -->
        <div class="cpart" style="margin-top: -20px;">
            <div class="registrationHeading">
                <bean:message key="TUTOR_EDUCATIONAL_INFORMATION"/>
            </div>
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_UGCOURSE"/>
                    </div>
                    <div>
                        <html:select  property="ugQualifyingDegree" styleClass="registrationTextField" styleId="ugQualifyingDegreeId" onchange="javascript:return showHideOtherUgQualifyingDegree('ugQualifyingDegreeId')">
                            <%-- <%@ include file = "/jsp/library/ugcoursenames.jspf"  %> --%>
                            <%-- <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfBasicUgCourses" label="labelName" value="labelValue"/> --%>
                            <html:option value="-1">-:Select Graduation:-</html:option>
                            <%
                                        if (null != listOfBasicUgCourses) {
                                            for (ListOfValuesVO listOfValuesVO : listOfBasicUgCourses) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>
                        </html:select>
                        <span class="hint"><bean:message key="BASIC_GRADUATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherUgQualifyingDegreeId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other qualification :
                            </div>
                            <html:text  property="otherUgQualifyingDegree" styleClass="registrationOtherTextField" title="Please specify other tutoring qualifying degree"/>
                            <span class="hint"><bean:message key="OTHER_BASIC_GRADUATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName" >
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                    </div>
                    <div>

                        <html:select  styleId="ugSpecializationId" styleClass="registrationTextField" property="ugSpecialization" onchange="javascript:return showHideOtherUgSpecialization('ugSpecializationId')"  title="Press Ctrl to select multiple teaching medium">

                            
                            <%-- <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfSubjects" label="labelName" value="labelValue"/> --%>
                            <html:option value="-1">-:Select Specialization:-</html:option>
                            <%
                                        if (null != listOfSubjects) {
                                            for (ListOfValuesVO listOfValuesVO : listOfSubjects) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>

                        </html:select>
                        <span class="hint"><bean:message key="UG_SPECIALISATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>


                        <div id="otherUgSpecializationId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other specialization :
                            </div>
                            <html:text  property="otherUgSpecialization"  styleClass="registrationOtherTextField" title="Please specify other specialization."/>
                            <span class="hint"><bean:message key="OTHER_UG_SPECIALISATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;" >
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="ugBoardOrUniversity" styleClass="registrationTextField" styleId="ugBoardOrUniversityId" onchange="javascript:return showHideOtherUgBoardOrUniversity('ugBoardOrUniversityId')">
                            <%--   <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                                <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfUniversityInstitute" label="labelName" value="labelValue"/>
                            --%>


                            <%
                                        if (null != listOfUniversityInstitute) {
                                            for (ListOfValuesVO listOfValuesVO : listOfUniversityInstitute) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>

                        </html:select>
                        <span class="hint"><bean:message key="BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherUgBoardOrUniversityId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other Board/University :
                            </div>
                            <html:text  property="otherUgBoardOrUniversity"  styleClass="registrationOtherTextField" title="Please specify other university/institute name"/>
                            <span class="hint"><bean:message key="OTHER_BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
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
                        <span class="hint"><bean:message key="YEAR_OF_PASSOUT_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_PGCOURSE"/>
                    </div>
                    <div>

                        <html:select property="pgQualifyingDegree" styleClass="registrationTextField" styleId="pgQualifyingDegreeId" onchange="javascript:return showHideOtherPgQualifyingDegree('pgQualifyingDegreeId')">
                            <%-- <%@ include file = "/jsp/library/pgcoursenames.jspf"  %> 
                             <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfBasicPgCourses" label="labelName" value="labelValue"/> --%>


                             <html:option value="-1">-:Select Post Graduation:-</html:option>
                            <%
                                        if (null != listOfBasicPgCourses) {
                                            for (ListOfValuesVO listOfValuesVO : listOfBasicPgCourses) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>

                        </html:select>
                        <span class="hint"><bean:message key="PG_COURSE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherPgQualifyingDegreeId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other PG Qualification :
                            </div>
                            <html:text  property="otherPgQualifyingDegree"  styleClass="registrationOtherTextField" title="Please specify other tutoring pg qualification"/>
                            <span class="hint"><bean:message key="OTHER_PG_COURSE_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_SPECIALIZATION"/>
                        <!--/Major Subject:-->
                    </div>
                    <div>

                        <html:select  styleId="pgSpecializationId" styleClass="registrationTextField" property="pgSpecialization" onchange="javascript:return showHideOtherPgSpecialization('pgSpecializationId')" >

                            <%--
                               <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfSubjects" label="labelName" value="labelValue"/> 
                            --%>
                            <html:option value="-1">-:Select Specialization :-</html:option>
                            <%
                                        if (null != listOfSubjects) {
                                            for (ListOfValuesVO listOfValuesVO : listOfSubjects) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>

                        </html:select>
                        <span class="hint"><bean:message key="UG_SPECIALISATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherPgSpecializationId" style="margin-top:10px; display: none" >
                            <div class="labelName">
                                Other PG specialization :
                            </div>
                            <html:text  property="otherPgSpecialization"  styleClass="registrationOtherTextField" title="Please specify other tutoring pg qualification"/>
                            <span class="hint"><bean:message key="OTHER_UG_SPECIALISATION_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        <bean:message key="TUTOR_BOARD_OR_INSTITUTE"/>
                    </div>
                    <div>
                        <html:select  property="pgBoardOrUniversity" styleClass="registrationTextField" styleId="pgBoardOrUniversityId" onchange="javascript:return showHideOtherPgBoardOrUniversity('pgBoardOrUniversityId')">

                            <%--
                              <%@ include file = "/jsp/library/boardUniversityOrInstitute.jspf"  %>
                              <html:optionsCollection name="tutorProfileRegistrationActionForm" property="listOfUniversityInstitute" label="labelName" value="labelValue"/>
                            --%>


                            <%
                                        if (null != listOfUniversityInstitute) {
                                            for (ListOfValuesVO listOfValuesVO : listOfUniversityInstitute) {
                            %>
                            <html:option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></html:option>
                            <%}
                                        }%>

                        </html:select>
                        <span class="hint"><bean:message key="BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        <div id="otherPgBoardOrUniversityId" style="margin-top:10px;display: none">
                            <div class="labelName">
                                Other university/institute :
                            </div>
                            <html:text  property="otherPgBoardOrUniversity"  styleClass="registrationOtherTextField"  title="Please specify other university/institute name"/>
                            <span class="hint"><bean:message key="OTHER_BOARD_UNIVERSITY_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                        </div>
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
                        <span class="hint"><bean:message key="YEAR_OF_PASSOUT_HINTS"/><span class="hint-pointer">&nbsp;</span> </span>
                    </div>
                    <div class="clear"></div>
                </div><div class="clear"></div>
                    </div> <!-- End of Login Wrapper -->
               <div class="clear"></div>
        </div>
                    <div class="cpart">
                        <div style="margin-left: 104px">
                     <table width="570px" align="center"   border="0" cellpadding="0" cellspacing="8">
                        <TR>
                            <TD width="30px">&nbsp;&nbsp;</TD>
                            <TD width="160px"> <font style="color: #800000;font-weight: bold">Classes/Level</font></TD>
                            <TD width="200px"><font style="color: #800000;font-weight: bold">Subjects</font></TD>
                            <TD width="180px"><font style="color: #800000;font-weight: bold">Board</font></TD>
                            <TD width="180px"><font style="color: #800000;font-weight: bold;padding-left: 10px;">&nbsp;Medium</font></TD>
                        </TR>
                    </table>
                  
                    <TABLE id="dataTable" width="570px" border="0" cellpadding="0" cellspacing="2"  >
                        <TR>
                            <TD><INPUT type="checkbox" name="chk"/></TD>
                            <TD>
                                <SELECT name="teachingLevelList" class="registrationTextField" style="width:120px">
                                     <OPTION value="-1">Select Class</OPTION>
                                  <%--  <OPTION value="in">India</OPTION>
                                    <OPTION value="de">Germany</OPTION>
                                    <OPTION value="fr">France</OPTION>
                                    <OPTION value="us">United States</OPTION>
                                    <OPTION value="ch">Switzerland</OPTION>
                                    --%>
                                      <%
                                        String countryName = (String) request.getSession().getAttribute("countryName");
                                        List<ListOfValuesVO> listOfTutorEducationLevel = lovDataService.populateEducationLevel(countryName);
                                       
                                        if (null != listOfTutorEducationLevel) {
                                            for (ListOfValuesVO listOfValuesVO : listOfTutorEducationLevel) {
                            %>
                            <option value="<%=listOfValuesVO.getLabelValue()%>"><%=listOfValuesVO.getLabelName()%></option>
                            <%}
                                        }%>

                                </SELECT>
                            </TD>
                            <TD><INPUT type="text" name="teachingSubjects" class="registrationTextField" style="width:120px" /></TD>
                           
                            <TD>
                               <INPUT type="text" name="teachingBoards" class="registrationTextField" style="width:120px"/>
                            </TD>
                              <TD>
                               <INPUT type="text" name="teachingMediumList" class="registrationTextField" style="width:110px"/>
                            </TD>

                        </TR>
                        
                    </TABLE>
                           <table width="500px" style="margin: 0px 0px 0px 30px;" border="0" cellspacing="5">
                          <TR>
                            <TD><input type="submit" value="Submit" style="width:113px" /></TD>
                            <TD><INPUT type="button" value="Add More Row" onclick="addRow('dataTable')" style="width:120px; margin-left:13px;"/></TD>
                            <TD><INPUT type="button" value="Delete Row" onclick="deleteRow('dataTable')" style="width:124px; margin-left:16px;" /></TD>
                            <TD><input type="reset" value="Reset Row" style="width:114px; margin-left:11px;"/></TD>

                        </TR>
                    </table> <!-- End of Tutor Box Body -->       
    </html:form>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
<div class="clear"></div>
                        </div>
                         <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="errorField">
                        <div style="float: left; width: auto;margin-left: 137px; line-height: 30px;">
                            <html:image   src="images/continue_btn.png" align="left" alt="Submit"/>
                        </div>
<!--                        <div  style="float: left;margin-left: 10px;">
                            <input type="reset" value="" alt="" style="background:url(< %=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
                        </div>-->

                    </div>
                    <div class="clear"></div>
                </div>
<div class="clear"></div>
    </div>
        <div class="clear"></div>
    </div>
</div> <!-- End of Our Tutor Wrapper -->


<%--<div class="ourToutorWrapper">
    <div class="tutorHeader">The Professional Tutors Educare &nbsp;&nbsp; <font color="orange">*</font><a href="Link.do?method=postAdvertisement" style="text-decoration: none; font-size: 11px;">Book your advertisement</a></div>
    <div class="tutorBoxBody">
        <div class="bottombanner">
            <img src="images/bottom_banner.gif" alt="Bottom Banner" />
        </div>
        <div class="bottombannerlink">
            <a href="#" class="bottombanner">Click here to view Professional Tutors Educare details </a>
        </div>
    </div> <!-- Tutor Box body div close -->

    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>--%>
