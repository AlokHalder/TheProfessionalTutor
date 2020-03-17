<%-- <%@taglib uri="/WEB-INF/struts-html.tld" prefix ="html"%> --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="java.util.List"%>
<%@page import ="com.pcs.ptutors.vo.LocationVO"%>
<%@page import="com.pcs.ptutors.vo.TeaserVO"%>
<%@page import="com.pcs.ptutors.vo.TutorRegistrationVO"%>
<%@page import="com.pcs.ptutors.vo.StudentRegistrationVO" %>
<%@page import="com.pcs.ptutors.tutorialcenter.vo.TutorialCenterDataVO" %>
<%@page import="com.pcs.ptutors.model.TutorialCenterModel"%>
<%@page import="com.pcs.ptutors.vo.InstantTutorServiceVO" %>


<%
            LovDataService lovDataServiceMenu = new LovDataService();
            TutorialCenterModel tutorialCenterModel = new TutorialCenterModel();
            String countryName = (String) request.getSession().getAttribute("countryName");
%>
<div id="leftSectionWrapper">
    <div class="categoryWrapper">
        <div class="categoryTop">Login Section</div>
        <div class="categoryBody">
            <ul>
                <li>
                    <a href="Link.do?method=tutorLogin">Tutor Sign-Up
                        <%-- <sup style="color:#DB214C">Free Registration </sup> --%>
                    </a>
                </li>
                <li>
                    <a href="Link.do?method=studentLogin">Student Sign-Up
                        <%-- <sup style="color:#DB214C">Free Registration </sup> --%>
                    </a></li>
                <li>
                    <a href="tutorialCenter.do?method=instituteLoginPage">Tutorial Center Sign-Up</a>

                </li>
                <li>
                    <a href="Link.do?method=admin">Professionals Sign-up</a>
                </li>
                <li>

                    <a href="Link.do?method=admin">Administrator Sign-Up</a>
                </li>
                
            </ul>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
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
            </ul>
            <div class="findMore"> <a href="#"> Find More...</a> </div>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" /></div>
    </div>


    <div class="categoryWrapper">
        <div class="categoryTop">Tutorial Center</div>
        <div class="categoryBody">           
            <ul>               
                <%
                            List<TutorialCenterDataVO> listOfTutorialCenter = null;
                            if (null != session.getAttribute("listOfTutorialCenter")) {
                                listOfTutorialCenter = (List<TutorialCenterDataVO>) session.getAttribute("listOfTutorialCenter");
                            } else {
                                listOfTutorialCenter = tutorialCenterModel.populateLimitedListOfTutorialCenter();
                                session.setAttribute("listOfTutorialCenter", listOfTutorialCenter);
                            }

                            for (TutorialCenterDataVO tutorialCenterDataVO : listOfTutorialCenter) {
                %>
                <li>
                    <a href="tutorialCenterProfile.do?centerid=<%=tutorialCenterDataVO.getInstituteId()%>">
                        <%=tutorialCenterDataVO.getInstituteName()%>
                    </a>                  
                </li>
                <%}%>

            </ul>
            <div class="findMore"> <a href="#"> Find More...</a> </div>

        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>




    <div class="categoryWrapper">
        <div class="categoryTop">Required Home Tutors</div>
        <div class="categoryBody" >         

            <script type="text/javascript">

//new pausescroller(name_of_message_array, CSS_ID, CSS_classname, pause_in_miliseconds)

//new pausescroller(pausecontent, "pscroller1", "someclass", 3000)
                new pausescroller(pausecontent, "pscroller1", "someclass", 8000)

                document.write("<br />")
                /*new pausescroller(pausecontent2, "pscroller2", "someclass", 2000) */

            </script>

            <div class="teaserAdvLink" align="center">
                <a href="instantTutorService.do" style="color:#DB214C;">View more requirements</a>
            </div>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>


    <div class="categoryWrapper">
        <div class="categoryTop">Miscelleneous</div>
        <div class="categoryBody">           
            <ul>  
               
                <li><a href="careercourses/index.html">Career Courses &nbsp;&nbsp;<font style="color:#DB214C;font-weight: bold;font-size: 10px;text-decoration: blink;">New!</font></a></li>
                <li><a href="ios/index.html">Institute Of Science</a></li>
                <li><a href="ios/index.html">Live Project Training</a></li>
                <li><a href="ios/index.html">BCA/MCA/BTECH Final Year Project Training</a></li>
                    

            </ul>
            <%-- <div class="findMore"> <a href="#"> Find More..</a> </div> --%>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>



</div>

