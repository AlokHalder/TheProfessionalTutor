<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcs.ptutors.vo.HomePageServiceVO"%>
<%@page import="com.pcs.ptutors.model.LovDataService"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    String counCode = (String) request.getSession().getAttribute("countryCode");
    String locId = (String) request.getSession().getAttribute("locationId");
    LovDataService lovDataServiceTeaser = new LovDataService();
    HomePageServiceVO homePageServiceVO = lovDataServiceTeaser.populateOnLoadServices(counCode, locId);

    List<TutorialCenterDataVO> tutorialCenterList = homePageServiceVO.getListOfResentRegisteredInstitutes();

%>


<div id="leftSectionWrapper">
    <% if (null != session.getAttribute("tutorLoginUserName")) {%>
    <div class="categoryWrapper">
        <div class="categoryTop">Tutor Profile</div>
        <div class="categoryBody">
            <ul>
                <%
                    String tutorId = session.getAttribute("tutorId").toString();
                %>
                <li>
                    <a href="viewTutorProfile.do?tutorId=<%=tutorId%>">View Profile</a>
                </li>
                <li>
                    <a href="edittutorprofile.do?tutorId=<%=tutorId%>">Edit Profile</a>
                </li>
                <li>
                    <a href="tutorchangePassword.do?tutorId=<%=tutorId%>">Change Password</a>
                </li>
                <li>
                    <a href="tutorUploadphoto.do?tutorId=<%=tutorId%>">Upload Photo</a>
                </li>
                <li>
                    <a href="uploadCetificate.do?tutorId=<%=tutorId%>">Upload Certificate</a>
                </li>
                <li>
                    <a href="tutorUpgradeMembership.do?tutorId=<%=tutorId%>">Upgrade Membership</a>
                </li>
            </ul>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
    <%} else if (null != session.getAttribute("studentLoginUserName")) {%>

    <div class="categoryWrapper">
        <div class="categoryTop">Student Profile</div>
        <div class="categoryBody">
            <ul>
                <%
                    String studId = session.getAttribute("studentId").toString();
                %>
                <li>
                    <a href="ViewStudentProfile.do?studentId=<%=studId%>">View Profile</a>     

                </li>
                <li>
                    <a href="viewForEditStudentFullProfile.do?studentId=<%=studId%>">Edit Profile</a>
                </li>

                <li>
                    <a href="changePassword.do?studentId=<%=studId%>">Change Password</a>            

                </li> 
                <li>
                    <a href="uploadphoto.do?studentId=<%=studId%>">Upload Photo</a>
                </li>
                <li>
                    <a href="upggradeMembership.do?studentId=<%=studId%>">Upgrade Membership</a>
                </li>
            </ul>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>

    <%} else if (null != session.getAttribute("instituteId")
            && !session.getAttribute("instituteId").toString().equals("")
            && null != session.getAttribute("instituteLoginUserName")) {%>

    <div class="categoryWrapper">
        <div class="categoryTop">Institute Profile</div>
        <div class="categoryBody">
            <ul>
                <%
                    String instituteId = session.getAttribute("instituteId").toString();
                %>
                <li>
                    <a href="viewInstituteProfile.do?instituteId=<%=instituteId%>" >View Profile </a>      

                </li>
                <li>
                    <a href="editInstituteProfile.do?instituteId=<%=instituteId%>">Edit Profile</a>      

                </li>
                <li>
                    <a href="CenterchangePassword.do?instituteId=<%=instituteId%>">Change Password</a>          

                </li>
                <li>
                    <a href="instituteuploadphoto.do?instituteid=<%=instituteId%>">Upload Photo</a>
                </li>
                <li>
                    <a href="instituteUpgradeMembership.do?instituteid=<%=instituteId%>">Upgrade Membership</a>
                </li>
            </ul>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
    <%} else if (null != session.getAttribute("JobSeekerId")
            && !session.getAttribute("JobSeekerId").toString().equals("")) {%>

    <div class="categoryWrapper">
        <div class="categoryTop">Job Seeker Profile</div>
        <div class="categoryBody">
            <ul>
                    String jobSeekerId = session.getAttribute("JobSeekerId").toString();
                %>
                <li>
                    <a href="viewJobseekersProfile.do?jobSeekerId=<%=jobSeekerId%>">View Profile</a>
                </li>
                <li>
                    <a href="viewForEditJobSeekersProfile.do?tutorId=<%=jobSeekerId%>">Edit Profile</a>
                </li>
                <li>
                    <a href="jobseekerchangePassword.do?jobSeekerId=<%=jobSeekerId%>">Change Password</a>
                </li>
                <li>
                    <a href="jobseekersUploadphoto.do?jobSeekerId=<%=jobSeekerId%>">Upload Photo</a>
                </li>
            </ul>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
    <%} else if (null != session.getAttribute("EmployeeId")
            && !session.getAttribute("EmployeeId").toString().equals("")) {%>

    <div class="categoryWrapper">
        <div class="categoryTop">Employer Profile</div>
        <div class="categoryBody">
            <ul>
                <%
                    String employerId = session.getAttribute("EmployeeId").toString();
                %>
                <li>
                    <a href="viewEmployerProfile.do?employeeId=<%=employerId%>">View Profile</a>          

                </li>
                <li>
                    <a href="viewForEditEmployerFullProfile.do?employeeId=<%=employerId%>">Edit Profile</a>      

                </li>
                <li>
                    <a href="EmpchangePassword.do?employeeId=<%=employerId%>">Change Password</a>          

                </li>
                <li>
                    <a href="employerUploadphoto.do?employeeId=<%=employerId%>">Upload Photo</a>
                </li>
                <%--<li>
                    <a href="employeeUpgradeMembership.do?employeeId=<bean:write name="employeeActionForm" property="employeeId"/>">Upgrade Membership      
                    </a>
                </li>--%>
            </ul>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>

    <%} else {%>
    <div class="categoryWrapper">
        <div class="categoryTop">Login Section</div>
        <div class="categoryBody">
            <ul>
                <li>
                    <a href="Link.do?method=tutorLogin">Tutor Sign-In                       
                    </a></li>
                <li>
                    <a href="Link.do?method=studentLogin">Student Sign-In 
                        <%-- <sup style="color:#DB214C">Free</sup> --%>
                    </a></li>
                <li>
                    <a href="tutorialCenter.do?method=instituteLoginPage">Tutorial Center Sign-In</a>

                </li>
                <li>
                    <a href="jobSeekerLogin.do">Job Seeker Sign-In</a>
                </li>
                <li>
                    <a href="employeeLoginLink.do">Employer Sign-In</a>
                </li>
                <%--<li>
                    <a href="aboutCareerCafe.do">Career Cafe Members</a>
                </li>--%>
            </ul>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>

    <%}%>    
    <div class="categoryWrapper">
        <div class="categoryTop">Tutor Categories</div>
        <div class="categoryBody">
            <ul>
                <li><a href="findYourTutor.do?tutorCategories=1">Nursery Level</a></li>
                <li><a href="findYourTutor.do?tutorCategories=2">Class I- IV</a></li>
                <li><a href="findYourTutor.do?tutorCategories=3">Class V-X</a></li>
                <li><a href="findYourTutor.do?tutorCategories=4">Class XI-XII</a></li>
                <li><a href="findYourTutor.do?tutorCategories=5">Graduation</a></li>
                <li><a href="findYourTutor.do?tutorCategories=6">Post Graduation</a></li>
                <li><a href="findYourTutor.do?tutorCategories=7">JEE/IIT/AIEEE</a></li>
                <li><a href="findYourTutor.do?tutorCategories=8">BCA/MCA</a></li>
                <li><a href="findYourTutor.do?tutorCategories=9">BBA/MBA</a></li>
                <li><a href="findYourTutor.do?tutorCategories=10">Computer/IT</a></li>
                <li><a href="findYourTutor.do?tutorCategories=17">CAT/MAT</a></li>
            </ul>
            <div class="findMore"> <html:link href="/result.do">Find more..</html:link> </div>

        </div>
        <div class="categoryBottom"><img src="../../images/category_round_bottom.gif" alt="" /></div>
    </div>


    <div class="categoryWrapper" style="padding-top: 5px;">
        <div class="categoryTop">Tutorial Center</div>
        <div class="categoryBody">
            <ul>
                <%-- <%@include file="../../currentTutorialCenter.jspf" %>--%>
                <logic:iterate  id="listOfTutorialCenter" collection="<%=tutorialCenterList%>">
                    <li><a href="tutorialCenterProfile.do?instituteId=<bean:write name='listOfTutorialCenter' property='instituteId'/>"><bean:write name='listOfTutorialCenter' property='instituteName'/></a></li>
                    <font style='font-size: 12px;color:#05318c;font-weight: bold;padding-left: 30px;'><bean:write name="listOfTutorialCenter" property="instituteArea"/></font>

                </logic:iterate>
            </ul>
            <div class="findMore"> <a href="all-search-result.do?searchoptions=6&tutorCityLocation=IND"> Find More...</a> </div>

        </div>
        <div class="categoryBottom"><img src="../../images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
    <!--<div class="categoryWrapper">
        <div class="categoryTop">Co-curricular Activities</div>
        <div class="categoryBody">
            <ul>
                <li><a href="findYourTutor.do?tutorCategories=18">Music Tutor</a></li>
                <li><a href="findYourTutor.do?tutorCategories=31">Dance Tutor</a></li>
                <li><a href="findYourTutor.do?tutorCategories=32">Spoken English</a></li>
                <li><a href="findYourTutor.do?tutorCategories=33">Foreign Language</a></li>
                <li><a href="findYourTutor.do?tutorCategories=34">Acting Trainer</a></li>
                <li><a href="findYourTutor.do?tutorCategories=35">Modeling Trainer</a></li>
                <li><a href="findYourTutor.do?tutorCategories=36">Handwriting Courses</a></li>
            </ul>
            <div class="findMore"> <a href="#"> Find More...</a> </div>

        </div>
        <div class="categoryBottom"><img src="../../images/category_round_bottom.gif" alt="" /></div>
    </div>-->

    <!--    <div class="categoryWrapper" style="padding-top: 5px;">
            <div class="categoryTop">Member Feedback </div>
            <div class="categoryBody">
                <ul>
    <%--     <%@include file="../../feedback.jspf" %> --%>
     </ul>
     <div class="findMore"> <a href="#"> Find More...</a></div>

 </div>
 <div class="categoryBottom"><img src="../../images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
</div>-->


</div>


</body>
</html>