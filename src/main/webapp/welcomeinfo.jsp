<%-- <%@taglib uri="/WEB-INF/struts-html.tld"  prefix="html"%> --%>
<%-- <div class="welcomesectionWrapper"> --%>
<div class="ourToutorWrapper">
    <div class="tutorHeader">Welcome to The Professional Tutors Family</div>
    <div class="tutorBoxBody">
        <div class="welcomeText">
            <p>The Professional Tutors is a unique platform which provides assistance 	and services to its members who are mainly students and tutors, by helping them find suitable tutors or students depending on their requirement, residing at any place around the globe.</p>
            <p>&nbsp;</p>
            <p>Students can go through the profiles of different tutors which include the tutor's educational qualification, proficiency in the subject concerned, experience, location etc and thereby find one suitable to their requirement. This would in turn help the member tutors/teachers to get interested students from nearby as well as from far off places.</p>
            <p></p>
            <p>Students and tutors can become a part of The Professional Tutors Family by registering their respective profiles and thereby becoming its general member for Free. This would enable the general members to visit profiles of student/tutors only.</p>
            <p>&nbsp;</p>
            <p>An upgraded version of paid membership is required in order to avail further facilities such as complete contact details of students/tutors which include address, e-mail address, phone number, mobile number and other necessary details.</p>
            <p>&nbsp;</p>
            <p>Other services like offline students, tutors, institute's registration are also provided. For further information, kindly contact the Helpdesk number- <font color="#0094D9" style="font-weight: bold">+918697741613</font> </p>
            <p style="padding-top: 5px;">You are also eligible to get referral bonus for each & every paid membership reference! </p>
            <p style="padding-top: 5px;">So what are you waiting for?  Be a part of The Professional Tutors family and experience success at every step.</p>
        </div>
    </div>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>
<%-- <%@include  file="tutorsgalary.jspf" %> --%>

<div class="ourToutorWrapper">
    <div class="tutorHeader">Search Your Tutor now !!</div>
    <div class="tutorBoxBody">
        <html:form action="searchTutor.do">
           <!-- <div class="profileListingSearch"> -->
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Id :</div>
                    <div class="searchTextBox">
                        <input type="text" name="tutorId" style="width:120px; margin-left:10px;  border:1px solid #59a7f5; color:#666; font:13px/20px Arial, Helvetica, sans-serif;" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Tutor Location :</div>
                    <div class="searchTextBox">
                        <%@include file="WEB-INF/views/library/searchindialocations.jspf"%>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch">Subject :</div>
                    <div class="searchTextBox">
                         <%@include file="WEB-INF/views/library/subject.jspf"%>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldSectionWrapper">
                    <div class="labelNameSearch"> Tutor Level :</div>
                    <div class="searchTextBox">
                          <%@include file="WEB-INF/views/library/segmentLevel.jspf"%>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="searchButton">
                    <input type="image" src="images/search_button.jpg" alt="" />
                </div>

          <!--  </div> -->
        </html:form>
    </div>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>


<div class="ourToutorWrapper">
    <div class="tutorHeader">The Professional Tutors Educare </div>
   <div class="tutorBoxBody">
       <div class="bottombanner">
             <%-- <img src="images/bottom_banner.gif" alt="Bottom Banner" /> --%>
             <img src="images/sebok_academy.jpg" alt="Bottom Banner" width="550" height="300" />
       </div>
       <div class="bottombannerlink">
          <a href="#" class="bottombanner">Click here to view Professional Tutors Educare details </a>
       </div>
    </div> <!-- Tutor Box body div close -->

    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div>
