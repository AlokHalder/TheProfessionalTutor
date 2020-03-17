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
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> --%>
<html:errors/>

<%
    HttpSession httpSession = request.getSession();
    String employerLoginUserName = (String) httpSession.getAttribute("login_User_Name");
    String studentLoginUserName = (String) request.getAttribute("studentLoginUserName");
%>

    <div id="code">
        <div class="left_green_small"><h1>Employer Profile</h1></div>
        
        <div class="tutorBoxBody">
            <div class="fieldNameWrapper" style="margin-top:10px;width: auto;">
                <logic:equal name="employeeActionForm" property="documentVerificationFlag" value="1">
                    <font color="red" size="2" >*</font>  <font size="2px">Tutor documents has been verified by The Professional Tutors</font>
                </logic:equal>
                <div class="clear"></div>
            </div>
        </div>

       

        <div class="cpart">
            <div class="registrationHeading">
                <bean:message key="EMPLOYEE_COMPANY_CONTACT"/> 
                <%
                    if (null != employerLoginUserName) {
                %>

                <!--            <a href="viewForEditEmployerFullProfile.do?employeeId=< bean:write name='employeeActionForm' property='employeeId'/>"style="float: right"> [Edit]</a>-->

                <%}%>

            </div>

            <div class="fieldNameWrapper1" style="margin-top:10px;">
                <div style="float: left; width: 280px;" >
                    <div class="profilleLabelName2">
                        <bean:write name="employeeActionForm" property="name"/>
                        ( <bean:write name="employeeActionForm" property="gender"/>/<bean:write name="employeeActionForm" property="age"/>)
                    </div>
                </div>
                <!--                 <div class="labelValue">
                                < bean:write name="employeeActionForm" property="name"/>
                                 </div>-->
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_ID"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="employeeId"/>
                </div>
                <div class="clear">
                </div>
            </div>



            <!--        <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="profilleLabelName">
                          Gender:
                        </div>
                             <div class="labelValue">
                            < bean:write name="employeeActionForm" property="gender"/>
                             </div>
                        </div>
                         
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="profilleLabelName">
                           Age:
                        </div>
                             <div class="labelValue">
                            < bean:write name="employeeActionForm" property="age"/>
                             </div>
                        </div>-->


            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_COUNTRY"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="countryCode"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_LOCATION"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="locationId"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_ADDRESS"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="address"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    Contact Number :
                </div>
                <div class="labelValue2">              
                    <bean:write name="employeeActionForm" property="contactNumber"/>             
                </div>
                <div class="clear">
                </div>
            </div>     

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="TUTOR_EMAIL_ADDDRESS"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="emailAddress"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_COMPANY_NAME"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="companyName"/>
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_INDUSTRY_TYPE"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="industryTypeId"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_COMPANY_TYPE"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="companyTypeCode"/>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_CONTACT_PERSON"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="contactPerson"/>
                </div>
                <div class="clear">
                </div>
            </div>

            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_STATE"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="stateProvince"/>
                </div>
                <div class="clear">
                </div>
            </div> 
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="profilleLabelName2">
                    <bean:message key="EMPLOYEE_POSTAL_CODE"/>
                </div>
                <div class="labelValue2">
                    <bean:write name="employeeActionForm" property="postalCode"/>
                </div>
                <div class="clear">
                </div>
            </div> 
                 <div class="clear"></div>
        </div>
        <div class="clear"></div>
        <!-- End of Tutor Box Body -->
    </div>   
    <!-- End of Our Tutor Wrapper -->











