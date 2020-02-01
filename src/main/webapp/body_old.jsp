<style>
    .more_info{ width:90px; height: 30px; margin-top: 10px; background-color:#469AF0; text-align: center; line-height: 30px; text-decoration: none; border-radius: 5px; float: right;}
    .more_info a{ font-family: sans-serif; line-height: 30px; color: #fff; background-color: #469AF0;}
  .tutor_recently_join{
	width:780px;
	height:auto;
	float:left;
}
.tutor_recently_join h2{
	background:url(../images/tutor_icon.gif) no-repeat 0 0;
	line-height:40px;
	font-size:20px;
	text-transform:uppercase;
	color:#242424;
	margin:0 0 8px 0;
	padding:0 0 0 45px;
	display:block;
}
.tutor_recently_join h2 a{
	background:url(../images/home/small_arrow.jpg) no-repeat 0 15px;
	text-align:right;
	font-size:14px;
	text-transform:none;
	float:right;
	color:#dd4124;
	text-decoration:none;
	font-weight:bold;
	padding:0 0 0 10px;
	display:inline;
	}

.tutor_recently_join h2 a:hover{
	background:url(../images/home/small_arrow.jpg) no-repeat 2px 15px;
	text-align:right;
	font-size:14px;
	text-transform:none;
	float:right;
	color:#000;
	text-decoration:none;
	font-weight:bold;
	padding:0 0 0 10px;
	}
	
.tutor_recently_join_inner{
	background:#fff;
	border:1px solid #E2E1E1;
	height:auto;
	
	padding:1px;
}

.tutor_recently_join_inner ul{
	margin:0;
	padding:0;
	display:block;
	list-style:none;
}
.tutor_recently_join_inner ul li{
	padding:0px;
	margin:0px;
	display:block;
	color:#4c4c4c;
	font-size:15px;
	overflow:hidden;
}
.tutor_recently_join_inner ul li.odd_color{
	background:#eaeaea;
}
.tutor_recently_join_inner ul li.even_color{
	background:#fff;
}
.left_tutor_details_home{
 	width:651px;
	padding:15px 10px 10px 15px ;
	float:left;
	font-size:15px;
	color:#000;
	border-right:1px solid #E2E1E1;
}
.left_tutor_details_home a{
	display:block;
	font-size:14px;
	font-weight:bold;
	color:#1888e3;
	text-decoration:none;
}
.left_tutor_details_home a:hover{
	display:block;
	font-size:14px;
	font-weight:bold;
	color:#000;
	text-decoration:none;
}
.right_time_area{
	background:url(../image/clock_icon.png) no-repeat 36px 12px;
	width:68px;
	float:right;
	font-size:12px;
	font-style:italic;
	color:#545454;
	padding:30px 10px 10px 10px;
	text-align:center;
}

</style>


 <%--
            String counCode = (String) request.getSession().getAttribute("countryCode");
            String locId = (String) request.getSession().getAttribute("locationId");
            LovDataService lovDataServiceTeaser = new LovDataService();
                    String countryName = null;
                    HomePageServiceVO homePageServiceVO = lovDataServiceTeaser.populateOnLoadServices(counCode,locId);

                    List<TutorRegistrationVO> listOfResentRegisteredTutors = homePageServiceVO.getListOfResentRegisteredTutor();
                    int tutorCounter = 0;
                  
             List<StudentRegistrationVO> studentList  = homePageServiceVO.getListOfInstantTutorRequirements();
           
           

       --%>
<%-- <div class="welcomesectionWrapper"> --%>
<!--<div class="ourToutorWrapper">
    <div class="tutorHeader">Welcome to The Professional Tutors Family</div>
    <div class="tutorBoxBody">
        <div class="welcomeText" style="margin:0px 10px 10px 10px;">
            <p style="padding-bottom: 10px; font-family: sans-serif; ">The Professional Tutors is a unique platform which provides assistance 	and services to its members who are mainly students and tutors, by helping them find suitable tutors or students depending on their requirement, residing at any place around the globe.</p>
            <p style="padding-bottom: 10px; font-family: sans-serif;">Other services like offline students, tutors, institute's registration are also provided. For further information, kindly contact the Helpdesk number- <font color="#0094D9" style="font-weight: bold">+918697741613</font></p>
            <p>We provide <a href="#" title="Private Tutor Kolkata">Private Tutor Kolkata</a>,<a href="#" title="Home Tutor Kolkata">Home Tutor Delhi</a>,<a href="#" title="Home Tutor Mumbai">Home Tutor Mumbai</a>,<a href="#" title="Home Tutor Mumbai">Home Tutor Bangalore</a>,<a href="#" title="Home Tutor Chennai">Home Tutor Chennai</a> including all locations in India and abroad. <a href="welcomeinfo.do" class="findMore">view more...</a></p>
            <p><marquee scrollamount="2"> <font color="#800000" style="font-size: 18px; font-weight: bold;line-height: 20px"> <%-- <%=homePageServiceVO.getWeeklyMessage()%> --%></font></marquee></p>
        </div>
    </div>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>--><style>
   .tutorboxbody1{ width: 574px;
float: left;
margin: 0px;
padding: 0px;
height: auto;
   }
</style>
<!--<div class="tutorboxbody1">
        <div class="welcomeText" style="margin:0px 10px 10px 10px;">
            <marquee scrollamount="2"> <font color="#800000" style="font-size: 18px; font-weight: bold;line-height: 20px"><%-- <%=homePageServiceVO.getWeeklyMessage()%> --%></font></marquee>
        </div>
    </div>-->
<div class="left_green_small" style=" color: #fff; background-color: #469AF0; width: 765px; height: 40px; border-radius: 5px;"   ><h1 style="line-height: 40px;" >Welcome to The Professional Tutors Family</h1></div>
    
        <div class="welcomeText" style="margin: 10px 0px; padding: 10px; width: 760px; border-radius: 5px; color: #666; border: 1px solid #E2E1E1; ">
            <p style=" font-family: sans-serif; text-align: justify; ">The Professional Tutors is a unique platform which provides assistance 	and services to its members who are mainly students and tutors, by helping them find suitable tutors or students depending on their requirement, residing at any place around the globe.</p>
            
            <div class="more_info"><a href="Link.do?method=aboutus">More info</a></div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    
            <div class="tutor_recently_join">
    	<h2>New Registered Tutors </h2>
        <div id="content_1" class="tutor_recently_join_inner mCustomScrollbar _mCS_1"><div class="mCustomScrollBox mCS-light" id="mCSB_1" style="position:relative; height:100%; overflow:hidden; max-width:100%;"><div class="mCSB_container" style="position: relative; top: 0px;">
        	<ul>
	            <%--<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Shekhar Bhavsar</a>
         from <b>Mumbai</b> added his profile under Graduation Level and teaches Biochemistry, MicroBiology        
        </div>
        <div class="right_time_area">57 mins ago</div>
</li>--%>
                    <%--
                    <%int count=0;%>
                    <logic:iterate  id="listOfTutorSearchResult" collection="<%=listOfResentRegisteredTutors%>">
                        <%if(count==0 || count==2 || count==4){%>
                        <li class="even_color">
                            <%}else{%>
                        <li class="odd_color">
                            <%}%>
                        <div class="left_tutor_details_home">
                            <a href="viewTutorPartialProfile.do?tutorId=<bean:write name='listOfTutorSearchResult' property='tutorId'/>"><bean:write name='listOfTutorSearchResult' property='tutorName'/></a>
                            from <b><bean:write name="listOfTutorSearchResult" property="tutorCityLocation"/></b>,profile for
                            <logic:iterate name="listOfTutorSearchResult" property="listOfTeachingLevel" id="listOfTeachingLevel">
                            <bean:write  name="listOfTeachingLevel"/>.
                            </logic:iterate>
                        </div>
                            <div class="right_time_area"><bean:write name="listOfTutorSearchResult" property="registrationDate"/></div>
                        </li>
                        <%count++;%>
                    </logic:iterate>
                    --%>  
		</ul>
        </div><div class="mCSB_scrollTools" style="position: absolute; display: block;"><a class="mCSB_buttonUp" oncontextmenu="return false;"></a><div class="mCSB_draggerContainer"><div class="mCSB_dragger" style="position: absolute; height: 96px; top: 0px;" oncontextmenu="return false;"><div class="mCSB_dragger_bar" style="position: relative; line-height: 96px;"></div></div><div class="mCSB_draggerRail"></div></div><a class="mCSB_buttonDown" oncontextmenu="return false;"></a></div></div>
        </div>
    </div>
                    
	<%--<li class="odd_color">
		<div class="left_tutor_details_home">
        <a href="#">Ashutosh Gupta</a>
         from <b>Delhi Ncr</b> added his profile under Class XI - XII and teaches IT &amp; Computer Subjects, Mathematics, Physics        
        </div>
        <div class="right_time_area">9 hrs ago</div>
	</li>
		
		
		
	<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Saurabh Anurag</a>
         from <b>Jaipur</b> added his profile under Class I - VI and teaches All Subjects        
        </div>
        <div class="right_time_area">14 hrs ago</div>
	</li>
		
		
		
	<li class="odd_color">
		<div class="left_tutor_details_home">
        <a href="#">Vishvajeet</a>
         from <b>Mumbai</b> added his profile under Engineering Entrance / IIT JEE and teaches Mathematics        
        </div>
        <div class="right_time_area">14 hrs ago</div>
	</li>
		
		
		
	<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Gokul Kumar</a>
         from <b>Gaya</b> added his profile under Class XI - XII and teaches Mathematics        
        </div>
        <div class="right_time_area">16 hrs ago</div>
</li>--%>
		
	
	
<%-- <%@include  file="tutorsgalary.jspf" %> --%>
<%--
<div class="ourToutorWrapper">
    <div class="tutorHeader">Let us find a tutor for you !!</div>
    <div class="tutorBoxBody">
        <html:form action="searchTutor.do">
            <!-- <div class="profileListingSearch"> -->
            <div class="fieldSectionWrapper">
                <div class="labelNameSearch">Subject :</div>
                <div class="searchTextBox">
                    <%@include file="jsp/library/subject.jspf"%>
                </div>
                <div class="clear"></div>
            </div>

            <div class="fieldSectionWrapper">
                <div class="labelNameSearch">Tutor Location :</div>
                <div class="searchTextBox">
                   <select id="loctionCode" name="tutorCityLocation" style="width:125px; border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif; height:20px; margin:0 5px 0 10px;">
                   </select>                   
                </div>
                 <p style="font-size: 5;width: auto;float:right;padding-right: 10px;">Please select your country from top.</p>
                <div class="clear"></div>
            </div>

            <div class="fieldSectionWrapper">
                <div class="labelNameSearch"> Tutor Level :</div>
                <div class="searchTextBox">
                   <%@include file="jsp/library/segmentLevel.jspf"%>                   
                </div>
                <div class="clear"></div>
            </div>
            <div class="fieldSectionWrapper">
                <div class="labelNameSearch"> Tutor Id :</div>
                <div class="searchTextBox">
                    <input type="text" name="tutorId" style="width:120px; margin-left:10px;  border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif;" />
                </div>
                <div class="clear"></div>
            </div>
            <div class="searchButton">
                <input type="image" src="images/search_button.jpg" alt="" />
            </div>

            <div class="fieldSectionWrapper" align="right">
                <div class="labelNameSearch" style="width:auto"><a href="searchStudent.do">Resent Tutor Requirement job</a></div>
                <div class="clear"></div>
            </div>
            <!--  </div> -->
        </html:form>
    </div>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>

--%>

       
        <%--<div style=" float: left; width: 574px; padding-bottom: 2px;">
            <table width="100%" cellspacing="0">
             <thead>
             <th  bgcolor="powderblue" height="24px" style="padding-left: 10px">
                New Tutors
            </th>
            </thead>
            </table>
        </div> --%>
        <%--
<!--        <table width="100%" cellspacing="0" cellpadding="0" border="1">
           
            <tr>

            <td width="125px" align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Name</font>
            </td>
            <td align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Teaching Classes</font>
            </td>
          
            <td width="100px" align="center" >
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Location</font>
            </td>
            <td width="100px" align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Registration&nbsp;Date</font>
            </td>
            <td align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Contact</font>
            </td>
            </tr>
            
            <logic:iterate  id="listOfTutorSearchResult" collection="<%=listOfResentRegisteredTutors%>">
               
                <tr valign="top">

                    <td align="left" style="padding-left: 5px;font-size: 11px; line-height: 25px;">

                        <a  style="text-decoration: none;" href="viewTutorPartialProfile.do?tutorId=<bean:write name='listOfTutorSearchResult' property='tutorId'/>"> <bean:write name='listOfTutorSearchResult' property='tutorName'/></a>

                    </td>
                    <td align="left" style="padding-left: 5px;font-size: 11px; line-height: 25px;text-overflow: ellipsis">
                        <logic:iterate name="listOfTutorSearchResult" property="listOfTeachingLevel" id="listOfTeachingLevel">
                            <bean:write  name="listOfTeachingLevel"/>.
                        </logic:iterate>

                    </td>
                  
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <bean:write name="listOfTutorSearchResult" property="tutorCityLocation"/>
                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <bean:write name="listOfTutorSearchResult" property="registrationDate"/>

                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <a  href="viewTutorPartialProfile.do?tutorId=<bean:write name='listOfTutorSearchResult' property='tutorId'/>">
                            Contact
                        </a>

                    </td>

                </tr>

            </logic:iterate>
          
        </table>
        <div align="right">
                        <a href="searchTutor.do">  View All Tutors </a>
        </div>       
   <div class="clear"></div>


        <div>
            <table width="100%" cellspacing="0">
             <thead>
             <th  bgcolor="powderblue" height="24px" style="padding-left: 10px;">
                New Students
            </th>
            </thead>
            </table>
        </div>
   
        <table width="100%" cellspacing="0" cellpadding="0" border="1">

            <tr>

                <td height="24px" align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Name</font>
            </td>
            <td align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Classes</font>
            </td>
            <td align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Subjects</font>
            </td>

            <td width="100px" align="center" >
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Location</font>
            </td>
            <td width="100px" align="center">
                <font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Registration&nbsp;Date</font>
            </td>
            <td align="center"><font color="#800000" style="font-weight:bold;font-size: 12px;line-height: 25px;">Contact</font>
            </td>
            </tr>
           
            <logic:iterate  id="listOfStudentSearchResult" collection="<%=studentList%>">

                <tr valign="top" >
                    <td height="24px" align="left" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <a  style="text-decoration: none;" href="viewStudentPartialProfile.do?studentId=<bean:write name='listOfStudentSearchResult' property='studentId'/>"> <bean:write name='listOfStudentSearchResult' property='name'/></a>
                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                       <bean:write name="listOfStudentSearchResult" property="segmentLevel"/>
                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <bean:write name="listOfStudentSearchResult" property="subject"/>
                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <bean:write name="listOfStudentSearchResult" property="cityName"/>

                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                       <bean:write name="listOfStudentSearchResult" property="registrationDate"/>
                    </td>
                    <td align="center" style="padding-left: 5px;font-size: 11px; line-height: 25px;">
                        <a  href="viewStudentPartialProfile.do?studentId=<bean:write name='listOfStudentSearchResult' property='studentId'/>">
                            Contact
                        </a>

                    </td>

                </tr>

            </logic:iterate>
       
            
        </table>--> 
        --%>
        <div class="clear"></div>
            <div align="right" style="padding: 5px; margin-left: 564px; float: left; width: 200px;">
<!--                       <a href="searchStudent.do">  View All Students </a>-->

<a href="all-search-result.do?searchoptions=1&tutorCityLocation=1&mainsubject=-1&teachingLevel=-1">View All Tutors </a>
        </div>
              <div class="tutor_recently_join">
                  <%--
    	<h2>New Registered Students </h2>
        <div id="content_1" class="tutor_recently_join_inner mCustomScrollbar _mCS_1"><div class="mCustomScrollBox mCS-light" id="mCSB_1" style="position:relative; height:100%; overflow:hidden; max-width:100%;"><div class="mCSB_container" style="position: relative; top: 0px;">
        	<ul>
		<%count=0;%>
                    <logic:iterate  id="listOfStudentSearchResult" collection="<%=studentList%>">
                        <%
                        if((count==0 || count==2 || count==4)&& count<5){%>
                        <li class="even_color">
                            <%}else if(count<5){%>
                        <li class="odd_color">
                            <%}%>
                        <div class="left_tutor_details_home">
                            <a href="viewStudentPartialProfile.do?studentId=<bean:write name='listOfStudentSearchResult' property='studentId'/>"><bean:write name='listOfStudentSearchResult' property='name'/></a>
                            from <b><bean:write name="listOfStudentSearchResult" property="cityName"/></b>,for 
                            <bean:write name="listOfStudentSearchResult" property="segmentLevel"/>, want teacher for
                            <bean:write name="listOfStudentSearchResult" property="subject"/>
                            </div>
                            <div class="right_time_area"><bean:write name="listOfTutorSearchResult" property="registrationDate"/></div>
                        </li>
                        <%count++;%>
                    </logic:iterate>
                  --%>
		    <%--<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Shekhar Bhavsar</a>
         from <b>Mumbai</b> added his profile under Graduation Level and teaches Biochemistry, MicroBiology        
        </div>
        <div class="right_time_area">57 mins ago</div>
	</li>
		
		
		
	<li class="odd_color">
		<div class="left_tutor_details_home">
        <a href="#">Ashutosh Gupta</a>
         from <b>Delhi Ncr</b> added his profile under Class XI - XII and teaches IT &amp; Computer Subjects, Mathematics, Physics        
        </div>
        <div class="right_time_area">9 hrs ago</div>
	</li>
		
		
		
	<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Saurabh Anurag</a>
         from <b>Jaipur</b> added his profile under Class I - VI and teaches All Subjects        
        </div>
        <div class="right_time_area">14 hrs ago</div>
	</li>
		
		
		
	<li class="odd_color">
		<div class="left_tutor_details_home">
        <a href="#">Vishvajeet</a>
         from <b>Mumbai</b> added his profile under Engineering Entrance / IIT JEE and teaches Mathematics        
        </div>
        <div class="right_time_area">14 hrs ago</div>
	</li>
		
		
		
	<li class="even_color">
		<div class="left_tutor_details_home">
        <a href="#">Gokul Kumar</a>
         from <b>Gaya</b> added his profile under Class XI - XII and teaches Mathematics        
        </div>
        <div class="right_time_area">16 hrs ago</div>
</li>--%>
        </ul>
        </div>
        <div class="mCSB_scrollTools" style="position: absolute; display: none;"><a class="mCSB_buttonUp" oncontextmenu="return false;"></a><div class="mCSB_draggerContainer"><div class="mCSB_dragger" style="position: absolute; height: 96px; top: 0px; display: none;" oncontextmenu="return false;"><div class="mCSB_dragger_bar" style="position: relative; line-height: 96px;"></div></div><div class="mCSB_draggerRail"></div></div><a class="mCSB_buttonDown" oncontextmenu="return false;"></a></div></div>
        </div>
    </div>
<div class="clear"></div>
            <div align="right" style="padding: 5px; margin-left: 564px; float: left; width: 200px;">
<!--                       <a href="searchStudent.do">  View All Students </a>-->
<a href="all-search-result.do?searchoptions=2&tutorCityLocation=0&mainsubject=0&teachingLevel=0">View All Student </a>
        </div>
<!--<div class="ourToutorWrapper">
    <div class="tutorHeader">The Professional Tutors Educare &nbsp;&nbsp; <font color="orange">*</font><a href="Link.do?method=postAdvertisement" style="text-decoration: none; font-size: 11px;">Book your advertisement</a></div>
    <div class="tutorBoxBody">
        <div class="bottombanner">
            <%--<img src="images/bottom_banner.gif" alt="Bottom Banner" />--%>
            <img src="images/banner_body1.png" alt="Bottom Banner" />
        </div>
        <div class="bottombannerlink">
            <a href="#" class="bottombanner">Click here to view Professional Tutors Educare details </a>
        </div>
    </div>  Tutor Box body div close 

    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>-->

           