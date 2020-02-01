 <%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import = "com.pcs.ptutors.vo.LocationVO"%>
<%@page import="com.pcs.ptutors.vo.CountryVO"%>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>


<%
            String countryName = (String) request.getSession().getAttribute("countryName");
            String countryCode = (String) request.getSession().getAttribute("countryCode");
            String nationalFlag = (String) request.getSession().getAttribute("nationalFlag");
            if (null == countryCode) {
                request.getSession().setAttribute("countryCode", "IND");
                request.getSession().setAttribute("countryName", "India");
            }
            countryName = (String) request.getSession().getAttribute("countryName");
            countryCode = (String) request.getSession().getAttribute("countryCode");
            String cityName = (String) request.getSession().getAttribute("cityName");


%>

<!--Body Section Start Here-->
<div id="logoWrapper">
    <div class="logoSection">
        <div><a href="Link.do?method=home" ><img src="images/logo.gif" alt="Logo" border="0" /></a></div>
        <div> 
            <%-- <marquee  direction="left" scrollamount="1" scrolldelay="1" onmouseover="stop()" onmouseout="start()">
                <font style="float: left; width: auto;margin-right: 5px; line-height: 30px;color:#0066FF;text-decoration:inherit">Tutors in India . Tutors Bhutan.   </font>
            </marquee> --%>
        </div>

        <marquee  direction="left" scrollamount="1" scrolldelay="1" onmouseover="stop()" onmouseout="start()">
            <font style="float: left; width: auto;margin-right: 5px; line-height: 30px;color:#0066FF">Kolkata Tutors(100). Delhi Tutors(50). Chennai Tutors (30). Mumbai Tutors(20). Chandigar Tutors(10). Hydrabad Tutors(5). </font>
        </marquee>
       <br/>
       <%
          Date date = new Date();
          String DATE_FORMAT = "MMM d ,yyyy";
          SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);
         String strDate =  sd.format(date);

         
       %>
       <font color="#800000" style="font-weight: bold"> On <%=strDate%> the website has been viewed <%=request.getSession().getAttribute("viewCounter")%> times from different locations</font>
    </div>
    <div class="topContactNumber">
        <div style="padding-left:12px;"> <%
                    String userCallName = (String) session.getAttribute("userCallName");
            %>
            <%if (null != userCallName) {%>
            Welcome  <%=userCallName%> !!  <a href="userSignOff.do"><input type="button" value="Sign Out" class="btn4"/></a>
            <%} else {%>
            Welcome Guest!
            <a href="userSignIn.do"><input type="button" value="Sign In" class="btn3"/></a> or
            <a href="userRegistration.do">Register</a>
            <%}%>

            <br/>Help Line :<span style="padding-left: 5px"> +913369975052.</span><span style="padding-left: 5px">+918697741613</span>
            <br>E-mail Id    : <span style="padding-left: 5px">helpdesk@theprofessionaltutors.com</span>
            <%-- <br><font style="font-size: 10px;font-family: arial,helvetica,verdana">Support Browsers:</font><span><font style="font-size: 10px;font-family: arial,helvetica,verdana">IE7 &amp; IE8. Mozila .Crome.Opera </font></span> --%>
            <br><div style="float: left; width: auto;margin-right: 0px; line-height: 30px;">Live Help :</div> <div  style="float: left;margin-left: 10px;"><a href="#"><img src="images/150x50-online.gif" alt="" border="0" style="padding-left: 0px; padding-right: 5px;width: 100px;height: 25px;" title="Direct chat feature is coming very soon !! For the time being add above e-mail id to your gtalk/gmail and start chat with helpdesk ." /> </a></div>

        </div>
        <div class="chooseyourCountry">
            <div class="locationName" style="line-height:20px;">
                 <table>
                    <tr>
                        <td>India :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        <td> <%@include file="jsp/library/indialocations.jspf" %></td>
                    </tr>
                 <%--   <tr>
                        <td>Overseas :</td>
                        <td><%@include file="Select.jsp" %></td>
                    </tr>
                 --%>
                </table>
              <%--
                <%

                            if (null != countryName && null == cityName) {
                %>
                <%=countryName%>
                <%}%>

                <% if (null != countryName && null != cityName) {%>
                <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;"><%=cityName%></div> <div  style="float: left;margin-left: 10px;"><img src="NationalFlagIcons/<%=nationalFlag%>.png" alt="" border="0" style="padding-left: 5px; padding-right: 5px" title="India" /></div>
                    <%}%>
               --%>
            </div>

            <%--
             <div class="dropDownSection" style="margin-left:none;">
                 <select onchange="searchCountry()" name="selectedCountry" id="country" style="width:170px; border:1px solid #0777E8;" >
                     <option value="" selected>-:Select Country :-</option>
                     <option value="India">India</option>
                     <option value="">-------------------------</option>
                     <%
                                 List<CountryVO> listOfCountry = null;

                                if(null != session.getAttribute("listOfCountry")){
                                     listOfCountry  = (List<CountryVO> ) session.getAttribute("listOfCountry");
                                    }else{
                                     listOfCountry =  lovDataServiceLayoutHeaderObj.populateCountryList();
                                      session.setAttribute("listOfCountry",listOfCountry);
                                    }

                                for (CountryVO country : listOfCountry) {

                    %>
                    <option  <% if (countryName.equalsIgnoreCase(country.getCountryName())) {%> selected="selected" <%}%> value="<%=country.getCountryName()%>"><%=country.getCountryName()%></option>
                    <%}%>
                </select>
            </div>
            --%>

          <%--  <%@include  file="Select.jsp" %> --%>


        </div>

         
    

    </div>


    <div class="clear"></div>
</div>


<div id="mainBannerSection">
    <div id="slider">
        <ul>           
            <%-- <li><a href="Link.do?method=home"><img src="images/01.jpg" alt="Css Template Preview" /></a></li> --%>
            <%--<li><a href="Link.do?method=home"><img src="images/img5.jpg" alt="Css Template Preview" /></a></li> --%>
            <%--  <li><a href="Link.do?method=home" ><img src="images/04.jpg" alt="Css Template Preview" /></a></li> --%>
            <li><a href="Link.do?method=home"><img src="images/05.jpg" alt="Css Template Preview" /></a></li>
            <li><a href="http://www.redberyanimation.com"><img src="images/redbery.jpg" alt="Css Template Preview" /></a></li>
            <li><a href="Link.do?method=home" ><img src="images/03.jpg" alt="Css Template Preview" /></a></li>
        </ul>

    </div>
    <div>
        <%--
         <marquee scrollamount="1" onmouseover="stop()" onmouseout="start()" direction="left">
             <font color="red" style="font-family:verdana;font-weight: bold;font-size: 13px;"> Due to software upgradation service will be unavailable from 12.30PM to 2.30 PM . Please avoid registration during this period. we apologize for the inconvenience.</font>
         </marquee>
        --%>
    </div>
</div>

<div class="clear"></div>

<div id="navigationSectionWrapper">


    <div class="navMiddle chromestyle" id="chromemenu">

        <ul>

            <li>
                <a href="Link.do?method=tutorsArena" rel="dropmenu1">Tutors Arena</a>
            </li>
            <li>
                <a href="Link.do?method=studentsArena" rel="dropmenu2">Student Arena</a>
            </li>
             <li>
               <a href="aboutjobintro.do" rel="dropmenu4">Jobs</a>
            </li>
            <li>
                <a href="Link.do?method=tutorialCentersArena" rel="dropmenu3">Tutorial Center</a>
            </li>
             <li>
                <a href="Link.do?method=academia" rel="dropmenu5">Academia</a>
            </li>
            <li>
                <a href="actingModelingLayout.do?method=actingModelingHome" rel="dropmenu6">CCA</a>
            </li>
            <li>
                <a href="Link.do?method=booksHome" rel="dropmenu7">Books</a>
            </li>
            <li>
                <a href="Link.do?method=payment" rel="dropmenu8">Payment</a>
            </li>
            <li>
                <a href="search.do" rel="dropmenu9">Search</a>

            </li>
            <li>
                <a href="Link.do?method=contactus" rel="dropmenu10">Classified</a>
            </li>
            <li>
                <a href="Link.do?method=contactus" rel="dropmenu11">Contact</a>
            </li>
            <!-- <li>
               <a href="Link.do?method=help" rel="dropmenu11">FAQ</a>
           </li> -->
        </ul>
        <!--1st drop down menu -->
        <div id="dropmenu1" class="dropmenudiv">
            <a href="tutorsBenefits.do">Regn. Proc. &amp; Benefits</a>
            <a href="Link.do?method=tutorProfileRegistration" >Tutor Registration</a>
            <a href="paidRegisteredTutors.do">Premium Tutors</a>
            <a href="resentRegisteredTutors.do">General Tutors</a>
           <a href="jsp/tutor/downloadTutorRegistrationForm.jsp">Download tutor regn form</a>
        </div>

        <div id="dropmenu2" class="dropmenudiv">
            <a href="studentBenefits.do">Regn. Proc. &amp; Benefits</a>
            <a href="Link.do?method=studentRegistration">Student Registration</a>
            <a href="viewResentRegisteredStudents.do">View Students Profile</a>
            <!-- <a href="instantTutorService.do">View Students Profile</a> -->
            <a href="Link.do?method=postTution">Post Tution Requirement</a>
            <a href="homeWorkHelp.do" >Home Work Help</a>
            <a href="jsp/student/downloadStudentRegistrationForm.jsp">Download student regn form</a>

        </div>

        <div id="dropmenu3" class="dropmenudiv">
            <a href="tutorialCenter.do?method=instituteLoginPage">Tutorial Center Login</a>
            <a href="tutorialCenter.do?method=tutorialCenterRegistration">Institute Registration</a>
            <a href="viewResentRegisteredInstitutes.do">View Institutes Profile</a>
            <a href="tutorialcenter/downloadInstituteRegistationForm.jsp">Download inst. regn form</a>
        </div>

        <div id="dropmenu4" class="dropmenudiv">           
                   <a href="jobseekerRegn.do">Job Seekers Registration</a>
                   <a href="employerRegn.do">Employers Registration</a>
                   <a href="facultyJobs.do">Faculty Jobs</a>
        </div>
        <div id="dropmenu5" class="dropmenudiv">
            <a href="academicJobs.do">Academic Jobs</a>
            <a href="Link.do?method=studyMaterials">Study Materials</a>
            <a href="Link.do?method=educationalResources">Educational Resources</a>
            <a href="Link.do?method=academicNewsLetter">Academic Newsletter</a>
        </div>
        <div id="dropmenu6" class="dropmenudiv">
            <a href="Link.do?method=actingModelingHome">Co-curricular activities</a>
            <a href="Link.do?method=educationalResources">Dance</a>
            <a href="Link.do?method=academicNewsLetter">Auditions</a>
        </div>
        <div id="dropmenu7" class="dropmenudiv">
            <a href="Link.do?method=studyMaterials">Online Books</a>
            <a href="Link.do?method=educationalResources">Online Journal</a>
            <a href="Link.do?method=academicNewsLetter">Books Resounces</a>
        </div>

        <div id="dropmenu8" class="dropmenudiv">
            <a href="Link.do?method=payment">Mode Of Payment</a>
            <a href="instantPayment.do">Instant Online Payment</a>
            <a href="Link.do?method=upgradeMembership">Upgrade Membership Now</a>
        </div>

        <div id="dropmenu9" class="dropmenudiv">
            <%-- <a href="Link.do?method=searchingProcedure">How It Works</a>  --%>
            <a href="searchTutor.do">Tutors</a>
            <a href="paidRegisteredStudents.do">Students</a>            
            <a href="paidRegisteredStudents.do">Job-Seekers</a>
            <a href="paidRegisteredStudents.do">Institutes/Courses</a>
            <a href="search.do">All Search Page</a>
            <%--   <a href="Link.do?method=viewTutorsInYourArea">Search Tutors at doorstep (Advanced Search)</a> --%>
        </div>

        <div id="dropmenu10" class="dropmenudiv">
            <a href="classifieds.do?method=educlassified">Education</a>
            <a href="classifieds.do?method=computer">Computer</a>

        </div>

        <div id="dropmenu11" class="dropmenudiv">
            <a href="Link.do?method=frequentlyAskedQuestion">FAQ</a>
            <a href="Link.do?method=howItWorks">How It Works</a>
            <a href="Link.do?method=feedback">Your Feedback</a>
            <a href="Link.do?method=assistance">How Can We Assist You?</a>
            <a href="Link.do?method=referral">Awards/Referral Bonus</a>
            <a href="Link.do?method=postAdvertisement">Book Your Advertisement</a>
            <a href="Link.do?method=franchisee">Contact For Franchisee</a>
        </div>
        <%--
                <div id="dropmenu9" class="dropmenudiv">
                    <a href="Link.do?method=frequentlyAskedQuestion">FAQ</a>
                    <a href="Link.do?method=howItWorks">How It Works</a>
                    <a href="Link.do?method=feedback">Your Feedback</a>
                    <a href="Link.do?method=assistance">How Can We Assist You?</a>
                </div>
        --%>

        <script type="text/javascript">

            cssdropdown.startchrome("chromemenu")

        </script>
    </div>

    <%-- <div class="navMiddle">
         <ul>
             <li>
                 <a href="Link.do?method=home" >Home</a>
             </li>
             <li><a href="Link.do?method=aboutus">About Us</a></li>
             <li>
                 <a href="Link.do?method=tutorRegistration">Tutors Arena</a>
             </li>
             <li><a href="Link.do?method=studentRegistration">Student Arena</a></li>
              <li><a href="tutorialCenterProfile.do?method=tutorialCenterRegistration">Tutorial Center</a></li>
             <li><a href="Link.do?method=postTution">Post Tution</a></li>
             <li><a href="Link.do?method=payment">Academic World</a></li>
             <li><a href="Link.do?method=payment">Payment</a></li>
             <li><a href="Link.do?method=searchtutor">Search</a></li>
             <li><a href="Link.do?method=contactus">Contact us</a></li>
             <li><a href="Link.do?method=help">Help</a></li>
         </ul>
     </div>
    --%>
</div>


