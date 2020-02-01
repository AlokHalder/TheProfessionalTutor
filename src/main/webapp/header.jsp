<%@include file="base.jsp"%>
<%
    String countryCode = (String) request.getSession().getAttribute("countryCode");
    String locationId = (String) request.getSession().getAttribute("locationId");
    if (null == countryCode && null == locationId) {
        request.getSession().setAttribute("countryName", "India");
        request.getSession().setAttribute("locationName", "Kolkata");
        request.getSession().setAttribute("countryCode", "IND");
        request.getSession().setAttribute("locationId", "1");
    }

%>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>

<style>
    .topBar span{ font:13px/30px Verdana, Arial, Helvetica, sans-serif; color:#0F1923; margin-left:3px;}
    .facebook{ background: url(${pageContext.request.contextPath}/images/facebook.png); width: 20px; height: 20px;}
    .topBar{ width:1000px; float:left; height:33px; background:#f5f5f5; border-bottom:1px solid #ccc;}
    .newsl{ width: 340px; height: 90px; float: left; overflow: hidden; margin: 0px 0px 0px 5px; overflow: hidden;}
    .newsl ul{ list-style: none; overflow: hidden;}
    .newsl ul li{ text-decoration: none; text-align: justify; padding: 20px 0px; }
    .show img{ border-radius: 10px;}
    .search_bg{ width:100%; float:left; height:auto; background:#5ABAF3; min-height:40px; margin-top: 7px}
    .search_cot{ width:960px; margin:0 auto; font-family:Tahoma, Geneva, sans-serif; font-weight:bold; font-size:12px; color:#FFF; margin-top:5px }
    .search_cot td{  text-align:center}
    .search_cot select{ width:160px; height:30px; padding:5px; color:#666; -moz-border-radius: 5px;border-radius: 5px; border: #A6A6A6 1px solid}
    .btn{ background:url(${pageContext.request.contextPath}/images/bt.PNG) no-repeat;width:99px;height:31px; border:none; cursor:pointer}
    .btn:hover{ background:url(${pageContext.request.contextPath}/images/bt_hover.png) no-repeat; cursor:pointer}
    #mainBannerSection1 { width:970px; height:205px; float:left; padding:0; margin: 5px 0px 5px 14px; border: 1px solid #E2E1E1; border-radius: 10px;}
</style>
<!--Body Section Start Here-->
<div class="topBar">
    <div style="float: left;" >
    <span>A venture of <a href="http://www.pcsglobal.in" target="_blank">PCS Global</a> |</span>
    <span>
        <%
            String userCallName = (String) session.getAttribute("userCallName");
        %>
        <%if (null != userCallName) {%>
        Welcome  <%=userCallName%> !!  <a href="userSignOff.do"><input type="button" value="Sign Out" class="btn4"/></a>
        <%} else {%>
        Welcome Guest!
        <a href="userSignIn.do"><input type="button" value="Sign In" class="btn3"/></a>
        <%-- <a href="userRegistration.do">Register</a> --%>
        <%}%>
    </span>
<!--    <span>|Help Desk:<strong style="color:#0968C9;">033-2442-5535</strong></span>-->
    <span>|Email:<a href="#">#</a> </span>


    </div>
    <div style="float: right;">
    <%-- <span>|Live Chat<img src="images/chat_icon.gif" alt="" title="Add our Skype account 'ptutors' with your Skype account or add Gmail account ptutors@gmail.com & start chat directly with helpdesk." /><span class="hint"><bean:message key="CHAT_HINT_MESSAGE"/><span class="hint-pointer">&nbsp;</span></span>

    </span>
    <span>|<html:link action="m">Mobile</html:link></span>
        <div class="chatIcon"></div>
    </div>--%>
    <div style="z-index: 9999999; margin:0px 0px 0px 0px; float: right; width: 234px;" >
        
        <div style="float: right;" style="width: 140px;">
    <div style="z-index: 9999999; margin:6px 0px 0px 5px;" class="fb-like" data-href="https://www.facebook.com/The-Professional-Tutors-111148283567528/?modal=admin_todo_tour" data-layout="button_count" data-action="like" data-show-faces="true" data-share="true"></div>
    <%-- <span>|Live Chat<img src="images/chat_icon.gif" alt="" title="Add our Skype account 'ptutors' with your Skype account or add Gmail account ptutors@gmail.com & start chat directly with helpdesk." /><span class="hint"><bean:message key="CHAT_HINT_MESSAGE"/><span class="hint-pointer">&nbsp;</span></span>

    </span>
    <span>|<html:link action="m">Mobile</html:link></span>
        <div class="chatIcon"></div>--%>
    </div>
<!--    <div style="float: right;" style="width: 90px;">
    <div style="margin-left:  6px; margin-top: 6px; float: right; margin-right:6px; "><a href="https://www.facebook.com/ptutors"><img src="image/facebook.png " width="20px" height="20"></a></div>
    <div style="margin-left:  6px;margin-top: 6px; float: right; "><a href="https://twitter.com/ThePtutors"><img src="image/twitter.png " width="26px" height="22"></a></div>
    <div style="margin-left: 9px; margin-top: 6px; margin-right:0px; float: right; "> <a href="http://www.google.com/+PtutorsOrgKolkata"><img src="image/google_plus.png " width="20px" height="20"></a></div>
    </div>-->
</div>
    </div>
</div>
    <div id="logoWrapper">
        <div class="logoSection"><a href="Link.do?method=home"><img src="images/logon.gif" alt="" /></a> <br/>


        <%-- <font color="#800000" id="locvalid" style="font: normal 12px/12px vardana"><%=session.getAttribute("countryName")%>,<%=session.getAttribute("locationName")%></font><font style="font: normal 12px/12px vardana;float: right;color: #800000">Reviewed by <%=session.getAttribute("viewCounter")%> visitors </font> --%>
    </div>
    <div class="topAddSection">
        <%--<span><img src="images/add1.gif" alt="Home Tutor Pune" /></span>
        <span><img src="images/add2.gif" alt="Home Tutor Delhi" /></span>      
        <span><a href="http://www.lnsel.com"><img src="images/lnsel.jpg" alt="Private Tutor Kolkata" width="200px" height="93" /></a></span>--%>
<!--        <span><img src="images/bar_animate.gif" alt="Home Tutor Pune" /></span>-->
<!--        <span><img src="images/sidebar_img.gif" alt="Home Tutor Delhi" /></span>  -->
<div style="font-size: 16px; font-family: Arial; font-weight: bold; margin-right: 6px; width: 216px; text-align: right;  color: red;float: left; margin-top: 15px;  line-height: 29px;"> 24*7 Help Line
    <br/><strong style="color: #369CFF; font-weight: normal; font-size: 36px;">8335060309<br>
    6290665818
    </strong> </div>
    
<div style="float: left;"><a href="Link.do?method=postAdvertisement"> <img src="images/side_bar11.gif" alt="Private Tutor Kolkata" width="180" height="93" /></a> </div>
<div style="float: right;"> <img src="images/contuct1.gif" alt="Private Tutor Kolkata" width="200" height="93" /> </div>
          
    </div>
    <div class="clear"></div>
</div>


<div  class="search_bg">
    <html:form action="all-search-result.do">
        <table border="0" class="search_cot" cellpadding="0" cellspacing="0">
            <tr>
                <td width="40"  > Find </td>
                <td width="182" > <%@include file="jsp/library/searchoptions.jspf"%> </td>
                <td width="19" >In </td>
                <td width="190" > 
                    <%@include file="jsp/library/indialocations.jspf"%>

                </td>
                <td width="21" >For</td>
                <td width="197" >  <%@include file="jsp/library/subject1.jspf"%>   </td>
                <td width="48" >Of</td>
                <td width="190" >
                    <%@include file="jsp/library/segmentLevel1.jspf"%>
                </td>
                <td width="73" >
                    <input type="submit" class="btn"  value=""/>        
                </td>
            </tr>   
        </table>
    </html:form>
    <div class="clear"></div>
</div>

<!-- End Body section  -->

<!--Body Section Start Here-->

<div id="mainBannerSection1" style="z-index: 1;">
    <div class="bannerLftLinksWrapper">
        <!--        <span class="findanInst"><a href="http://www.pjobs.co.in">LET US FIND JOBS FOR YOU</a></span>
                <span class="findanJob"><a href="#">LET US FIND AN INSTITUTE FOR YOU</a></span>
                <span class="findanJob"><a href="#">TOP SCHOOLS IN YOUR LOCATION </a></span>   
                <span class="eduCare" style="padding-left: 5px;padding-top: 10px">
                    <select  style="width:160px;border:1px solid #000000; color:#000000; font:13px/20px Arial, Helvetica, sans-serif; height:25px; margin:0 5px 0 10px;" id="countryCode" >
        <%@ include file = "countryNames.jspf"  %>
    </select>
    <select id="loctionId" name="tutorCityLocation" style="width:160px; border:1px solid #000000; color:#000000; font:13px/20px Arial, Helvetica, sans-serif; height:25px; margin:0 5px 0 10px;">
        <%--          <jsp:include page="indialocations.jspf" flush="true"/> --%>
    </select>
</span>-->
        <div style="cursor: pointer;"><a style="margin-left: 1px;" onclick="openWin()"><img src="images/whatsappImg.jpg" width="350" style="border-radius: 5px;"></a></div>
        <div style="overflow: hidden; height: 98px;"> 
            
            <div class="newsl"  >
                <ul id="ticker_02">
                    <li>The Professional Tutors is a unique platform which provides assistance and services to its members who are mainly students and tutors, by helping them find suitable tutors or students depending on their requirement. <div align="right"><h4><font color="#5ABAF3"> Ms. Koushiki Mukherjee</font></h4></div> </li>
                    <li>The site is an excellent platform that provides wonderful opportunities for aspiring freshers. This firm also provides one of the best guidance and support a fresher needs to build on. <div align="right"><h4><font color="#5ABAF3"> Mr. Soumyadip Biswas</font></h4></div> </li>
                    <li>I owe a lot to the entire ptutors.in team which helped me to find the right job. ptutors.in is a beacon light for all job hunters. I personally feel that all Engineering graduates must give this test. It is definitely a career booster. <div align="right"><h4><font color="#5ABAF3">  Mr. Rony Dasgupta</font></h4></div> </li>
                    <li>ptutors.in is an excellent platform for people who are looking for a head start in their career. ptutors.in helped me kick start my career with a great job in National Instruments. Thanks to their excellent guidance.  <div align="right"><h4><font color="#5ABAF3"> Ms. Sahana Maity</font></h4></div>  </li>
                    <li>I would like to thank the ptutors.in team for their great efforts in helping build the careers of thousands of candidates like me. I currently work with Logica, once again thanks to ptutors.in.    <div align="right"><h4><font color="#5ABAF3"> Ms. Ishani Kashyap</font></h4></div> </li>
                    <li>I felt very happy hearing this news from you. I am very thankful to ptutors.in. Thank you very much ptutors.in team, you showed me a path to reach my dream. Once again thanking you very much.   <div align="right"><h4><font color="#5ABAF3"> Mr. Piyush Mishra</font></h4></div> </li>
                    <li>I would like to extend my gratitude to ptutors.in for I would not have been where I am right now without their wonderful system. What make ptutors.in stand out from the crowd is the exams they conduct. <div align="right"><h4><font color="#5ABAF3"> Mr. Abhinandan Jain</font></h4></div> </li>
                    <li>ptutors.in gives an excellent platform to freshers as it provides so many opportunities. I gave ptutors.in thrice and the third time got a good percentile so please have patience and prepare well. <div align="right"><h4><font color="#5ABAF3"> Mr. Kuldeep Singh Sekhawat</font></h4></div></li>
                    <li>Taking ptutors.in was the best thing i did in my college life. It is a highly regarded organization by recruiters and getting a decent score will make sure that you will end up in a very good job. <div align="right"><h4><font color="#5ABAF3"> Ms. Parween Sheikh</font></h4></div> </li>
                    <li>Though it was a brief association with ptutors.in but it will remain a memorable one. I will recommend ptutors.in to all of my friends and my juniors as it provides you an opportunity to prove yourself.   <div align="right"><h4><font color="#5ABAF3"> Mr.Omsankar Chaurasia</font></h4></div> </li> 
                </ul>
            </div>
            
        </div>
    </div>
    <div class="BannerImg">

        <div id="gallery" style="z-index: 1">

            <a class="show" >
                <img src="images/edu/ban.png"  alt="Private Tutor Kolkata" width="608" height="205" title=""  rel="<h3>Grass Blades</h3>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "/>
            </a>

            <!--            <a href="#">
                            <img src="images/edu/banner3.jpg" alt="Home Tutor Chennai" width="608" height="205" title=""  rel="<h3>Ladybug</h3>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."/>
                        </a>-->

            <a>
                <img src="images/edu/banner_1.png" alt="Home Tutor Bangalore" width="608" height="205" title=""  rel="<h3>Lightning</h3>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."/>
            </a>
            <!--
                        <a href="#">
                            <img src="images/edu/banner5.jpg" alt="Home Tutor Noida" width="608" height="205" title=""  rel="<h3>Lotus</h3>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo."/>
                        </a>-->
            <%--
        <a href="#">
                <img src="images/edu/banner6.jpg" alt="Mojave" width="608" height="205" title=""  rel="<h3>Mojave</h3>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."/>
        </a>
            --%>
            <a>
                <img src="images/edu/banner_3.png" alt="Maths Tutor Kolkata" width="608" height="205" title=""  rel="<h3>Pier</h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."/>
            </a>

            <a>
                <img src="images/edu/banner_2.png" alt="Maths Tutor Delhi" width="608" height="205" title=""  rel="<h3>Pier</h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."/>
            </a>
            <a>
                <img src="images/edu/banner_4.png" alt="Faculty Jobs Kolkata" width="608" height="205" title=""  rel="<h3>Pier</h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."/>
            </a>
            <a>
                <img src="images/edu/banner1.jpg" alt="Faculty Jobs Delhi" width="608" height="205" title=""  rel="<h3>Pier</h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."/>
            </a>


        </div>

    </div>
    <div class="clear"></div>
</div>
<div class="clear"></div>

<div id="navigationSectionWrapper">


    <div class="navMiddle chromestyle" id="chromemenu">

        <ul>
            <li>
                <a href="Link.do?method=home">Home</a>
            </li>
            <!--            <li>
                            <a href="search.do" rel="dropmenu9">Search</a>
                        </li>-->
            <li>
                <a href="Link.do?method=tutorsArena" rel="dropmenu1">Tutors</a>
            </li>
            <li>
                <a href="Link.do?method=studentsArena" rel="dropmenu2">Student</a>
            </li>
            <li>
                <a href="Link.do?method=tutorialCentersArena" rel="dropmenu3">Institutes</a>
            </li>
            <li>
                <a href="#" rel="dropmenu4">Jobs</a>
            </li>
            
            <li>
                <a href="Link.do?method=academia" rel="dropmenu5">Academia</a>
            </li>
            <li>
                <a href="facultyJobs.do" rel="dropmenu6">CCA</a>
            </li>
            <!--<li>
                <a href="facultyJobs.do" rel="dropmenu7">Books</a>
            </li>-->
            <li>
                <a href="courseModule.do">Course</a>
            </li>
            <li>
                <a href="Link.do?method=payment" rel="dropmenu8">Payment</a>
            </li>

            <li>
                <a href="#" rel="dropmenu9">Classified</a>
            </li>
            <li>
                <a href="#" rel="dropmenu10">Help</a>
            </li>
            <li>
                <a href="Link.do?method=contactus" rel="dropmenu11">Contact Us</a>
            </li>


            <!-- <li>
               <a href="Link.do?method=help" rel="dropmenu11">FAQ</a>
           </li> -->
        </ul>
        <!--1st drop down menu -->
        <div id="dropmenu1" class="dropmenudiv">
            <a href="tutorsBenefits.do">Regn. Proc. &amp; Benefits</a>
            
            <a href="Link.do?method=tutorProfileRegistration" >Tutor Registration</a>
            
            <!--            <a href="paidRegisteredTutors.do">Premium Tutors</a>
                        <a href="resentRegisteredTutors.do">General Tutors</a>-->
            <a href="jsp/tutor/downloadTutorRegistrationForm.jsp">Download Regn. Form</a>
        </div>

        <div id="dropmenu2" class="dropmenudiv">
            <a href="studentBenefits.do">Regn. Proc. &amp; Benefits</a>
            
            <a href="Link.do?method=studentRegistration">Student Registration</a>
            
            <%--<a href="viewResentRegisteredStudents.do">View Students Profile</a>--%>
            <!-- <a href="instantTutorService.do">View Students Profile</a> -->
            <a href="Link.do?method=postTution">Post Tution Requirement</a>
            <a href="homeWorkHelp.do" >Home Work Help</a>
            <a href="jsp/student/downloadStudentRegistrationForm.jsp">Download Regn. Form</a>

        </div>

        <div id="dropmenu3" class="dropmenudiv">
            <!--            <a href="searchTutorialCenter.do">Search Tutorial Center</a>-->
            <!--            <a href="tutorialCenter.do?method=instituteLoginPage">Tutorial Center Login</a>-->
            
            <a href="tutorialCenter.do?method=tutorialCenterRegistration">Institute Registration</a>
            
            <%--<a href="viewResentRegisteredInstitutes.do">View Institutes Profile</a>--%>
            <a href="tutorialcenter/downloadInstituteRegistationForm.jsp">Download inst. regn form</a>
        </div>

        <div id="dropmenu4" class="dropmenudiv">
            
            <a href="jobseekerRegn.do">Job Seekers Registration</a>
            <a href="employerRegn.do">Employers Registration</a>
            
            <a href="facultyJobs.do">Faculty Jobs</a>
        </div>
        <div id="dropmenu5" class="dropmenudiv">
            <!--            <a href="academicJobs.do">Academic Jobs</a>-->
            <a href="facultyJobs.do">Academic Jobs</a>
            <a href="Link.do?method=studyMaterials">Study Materials</a>
            <a href="Link.do?method=educationalResources">Educational Resources</a>
            <a href="Link.do?method=academicNewsLetter">Academic Newsletter</a>
            <!--<a href="aboutCareerCafe.do">Career Cafe</a>-->
            <!--            <a href="#" title="Under Construction , coming soon !">General Knowledge</a>-->
            <a href="generalKnowledge.do">General Knowledge</a>
        </div>
        <div id="dropmenu6">
            
            <!--            <a href="actingModelingLayout.do?method=actingModelingHome">Co-curricular activities</a>
            <a href="facultyJobs.do">Co-curricular activities</a>
            <a href="Link.do?method=educationalResources">Dance</a>
            <a href="Link.do?method=academicNewsLetter">Auditions</a>
            -->
        </div>
        <div id="dropmenu7" class="dropmenudiv">
            <a href="onlineBooks.do">Online Books</a>
            <a href="OnlineJournal.do">Online Journal</a>
            <a href="booksResources.do">Books Resounces</a>
        </div>

        <div id="dropmenu8" class="dropmenudiv">
            <a href="Link.do?method=payment">Payment Options</a>
<!--            <a href="instantPayment.do">Instant Online Payment</a>-->
            <a href="Link.do?method=upgradeMembership">Upgrade Membership Now</a>
        </div>
       <%--
        <div id="dropmenu9" class="dropmenudiv">
             <a href="Link.do?method=searchingProcedure">How It Works</a>  
            <a href="findfMyTutor.do">Home Tutors</a>
            <a href="searchStudent.do">Students</a>
            <a href="#">Job-Seekers</a>
            <a href="#">Institutes/Courses</a>
            <a href="search.do">All Search Page</a>
               <a href="Link.do?method=viewTutorsInYourArea">Search Tutors at doorstep (Advanced Search)</a> 
        </div>
         --%>
        <div id="dropmenu9" class="dropmenudiv">
            <a href="education.do">Education</a>
            <a href="computer.do">Computer</a>
            <!--            <a href="classifieds.do?method=educlassified">Education</a>
                        <a href="classifieds.do?method=computer">Computer</a>-->

        </div>

        <div id="dropmenu10" class="dropmenudiv">
            <a href="Link.do?method=frequentlyAskedQuestion">FAQ</a>
            <a href="Link.do?method=howItWorks">How It Works</a>
            <a href="Link.do?method=feedback">Your Feedback</a>
            <a href="Link.do?method=assistance">How Can We Assist You?</a>
            <a href="Link.do?method=referral">Awards/Referral Bonus</a>
            <a href="Link.do?method=postAdvertisement">Book Your Advertisement</a>
            <a href="Link.do?method=franchisee">Contact For Franchisee</a>
            <!--            <a href="Link.do?method=franchisee">Marketing/Advertisement</a>-->
            <a href="marketing_advertisement.do">Marketing/Advertisement</a>
        </div>
        <script type="text/javascript">
            cssdropdown.startchrome("chromemenu");
        </script>
    </div>

    <script type="text/javascript">

        $(document).ready(function() {

            $("#countryCode").change(function(){
                var coun = $("#countryCode").val();

                var url = "<%=request.getContextPath()%>/citybycountry.do?countryid="+coun;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {
        		  
                    $("#loctionId").html(data);
                    $("#loctionCode").html(data);
                }

            );

            });

            $("#loctionId").change(function(){
                var coun = $("#countryCode").val();
                var loc = $("#loctionId").val();
                var counname = $('#countryCode option:selected').text();
                var locname = $('#loctionId option:selected').text();
              
                var url = "<%=request.getContextPath()%>/storeCountryLocation.do?countryid="+coun+"&locationid="+loc+"&locationname="+locname+"&countryname="+counname;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {

                    $("#locvalid").html(data);
                }

            );

            });


            $("#loctionCode").change(function(){
                var coun = $("#countryCode").val();
                var loc = $("#loctionId").val();
                var counname = $('#countryCode option:selected').text();
                var locname = $('#loctionId option:selected').text();

                var url = "<%=request.getContextPath()%>/storeCountryLocation.do?countryid="+coun+"&locationid="+loc+"&locationname="+locname+"&countryname="+counname;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {

                    $("#locvalid").html(data);
                }

            );

            });


        });

    </script>


    <script>

        function tick(){
            $('#ticker_01 li:first').slideUp( function () { $(this).appendTo($('#ticker_01')).slideDown(); });
        }
        setInterval(function(){ tick () }, 5000);


        function tick2(){
            $('#ticker_02 li:first').slideUp( function () { $(this).appendTo($('#ticker_02')).slideDown(); });
        }
        setInterval(function(){ tick2 () }, 2000);
       
	
        function tick22(){
            $('#ticker_022 li:first').slideUp( function () { $(this).appendTo($('#ticker_022')).slideDown(); });
        }
        setInterval(function(){ tick22 () }, 3000);


        function tick3(){
            $('#ticker_03 li:first').animate({'opacity':0}, 200, function () { $(this).appendTo($('#ticker_03')).css('opacity', 1); });
        }
        setInterval(function(){ tick3 () }, 4000);	

        function tick4(){
            $('#ticker_04 li:first').slideUp( function () { $(this).appendTo($('#ticker_04')).slideDown(); });
        }


        /**
         * USE TWITTER DATA
         */

        $.ajax ({
            url: '#',
            data: 'q=%23javascript',
            dataType: 'jsonp',
            timeout: 2000,
            success: function(data){
                if (!data.results){
                    return false;
                }

                for( var i in data.results){
                    var result = data.results[i];
                    var $res = $("<li />");
                    $res.append('<img src="' + result.profile_image_url + '" />');
                    $res.append(result.text);

                    console.log(data.results[i]);
                    $res.appendTo($('#ticker_02'));
                }
                setInterval(function(){ tick2 () }, 2000);	

                $('#example_2').show();

            }
        });


    </script>

</div>


