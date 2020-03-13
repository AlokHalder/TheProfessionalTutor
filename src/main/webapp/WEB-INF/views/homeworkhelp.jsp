<%@ page language="java" contentType="text/form; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="java.util.*,com.pcs.ptutors.vo.LocationVO" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<!DOCTYPE form>
<form>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script language="javascript" type="text/javascript" src="/js/datetimepick/datetimepicker.js">

//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
//Script featured on JavaScript Kit (http://www.javascriptkit.com)
//For this script, visit http://www.javascriptkit.com

</script>


<div class="ourToutorWrapper">
     <div id="code">
    <div class="left_green_small">
        <h1>Home Work Help
        <font style="font-size: 14px;"><fmt:message key="MANDATORY_FIELD"/> <fmt:message key="REQUIRED_FIELDS"/></font>
        </h1></div>
         <form:form action="posthomework" method="post" enctype="multipart/form-data" ModelAttribute="homework"> 
<!--             <div class="fieldNameWrapper" style="margin-top:10px;">
            <div class="labelName1">
                 <font color="green"> < bean:write name="studentHomeWorkHelpActionForm" property="msg"/></font>
                    </div>
             </div>-->
        <!-- Getting started with the professional Tutor -->
        <div class="cpart" style="margin-top:-20px;">
            <div class="registrationHeading">
                General Information
            </div>
            <div class="loginInfoWrapper">
                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Name :
                        <fmt:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <form:input path="name" styleClass="registrationTextField" title="Please enter your name."/>
                    </div>
                   <div class="errorField"> <form:errors prefix="" path="name"/></div>
                    <div class="clear"></div>
                </div>
               
                 <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Country Name:
                        <fmt:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <form:select  path="country" styleClass="registrationTextField">
                          <%--   <%@ include file = "/jsp/library/countryNames.jspf"  %> --%>
                        </form:select>
                    </div>
                    <div class="errorField"> <form:errors prefix="" path="country"/></div>
                    <div class="clear"></div>
                </div>
               
               

              

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Contact Number :
                    </div>
                    <div>
                        <form:input path="contactNumber"  styleClass="registrationTextField" title="Please enter contact person mobile no."/>
                    </div>
                   <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Email Address :
                    </div>
                    <div>
                        <form:input path="emailId"  styleClass="registrationTextField" title="Please enter institute email address."/>
                    </div>
                    <div class="clear"></div>
                </div>

                </div> <!-- End of Login Info Wrapper -->
            <div class="clear"></div>
        </div>

            
             <div class="loginInfoWrapper">
              <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Subject Name:
                    </div>
                    <div>
                        <form:select  path="subject" styleClass="registrationTextField">
                            <form:option value="Math"> Mathematics</form:option>
                        </form:select>
                    </div>
                    <div class="errorField"></div>
                    <div class="clear"></div>
                </div>
               <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Class/Level :
                    </div>
                    <div>
                        <form:input path="segment"  styleClass="registrationTextField" title="Please enter area name"/>
                    </div>
                   <div class="clear"></div>
                </div>
                 <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Description :
                    </div>
                    <div>
                        <form:input path="description"  styleClass="registrationTextField" style="height:100px;"  title="Please enter institute blog/community website name"/>
                    </div>
                   <div class="clear"></div>
                </div>
               
            <%-- <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Upload Home Work :
                    </div>
                    <div>
                        <form:file path="uploadHomeWork"  styleClass="registrationTextField" title="Please enter institute blog/community website name"/>
                    </div>
                   <div class="clear"></div>
                </div>
                 <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                        Budget :
                    </div>
                    <div>
                        <form:input path="budget"  styleClass="registrationTextField" title="Please enter contact person name"/>
                    </div>

                    <div class="clear"></div>
                </div>


                <div class="fieldNameWrapper" style="margin-top:10px;">
                    <div class="labelName">
                       Expected Delivery Date :
                       <fmt:message key="MANDATORY_FIELD"/>
                    </div>
                    <div>
                        <!--<input id="demo1" type="text" size="25">--><form:input path="deadline"  styleId="demo1"  styleClass="registrationTextField"/><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="/images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>



                       <form:text  property="deadline"  styleClass="registrationTextField" title="Please enter institute telephone no."/>
                    
                         <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="errorField">
                    <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                        <%-- <form:image   src="images/submit_button.gif" align="middle" alt="Submit"/> --%>
                        <input type="submit" value="Submit" />
                    </div>
                    <div  style="float: left;margin-left: 10px;">
                        <input type="reset" value="" alt="" style="background:url(<%=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>


                    </div>

                </div>
                <div class="clear"></div>
            </div>
             </div>
                        <div class="clear"></div>
        </div> <!-- End Of Tutor Body  -->


      
     </form:form> 
     </div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
</div> <!-- End of Our Tutor Wrapper -->

</body>
</form>