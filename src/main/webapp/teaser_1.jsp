<%@page  import="com.pcs.ptutors.model.TutorModel" %>
<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import="java.util.List"%>
<%@page import = "com.pcs.ptutors.vo.LocationVO"%>
<%@page import="com.pcs.ptutors.vo.TeaserVO"%>
<%@page import="com.pcs.ptutors.vo.CountryVO"%>
<%@page import="com.pcs.ptutors.vo.TutorRegistrationVO"%>
<%@page import="com.pcs.ptutors.vo.StudentRegistrationVO" %>


<%
            LovDataService lovDataServiceTeaser = new LovDataService();

%>

<div class="categoryWrapper">
    <div class="categoryTop" >
        Tutors on the Globe
         <%-- <img src="image/globe.gif" alt="Logo" border="0" style="padding-left: 5px; padding-right: 5px;padding-top: 5px; height:25px;width: 30px; vertical-align: middle;"> --%>
    </div>
    <div class="categoryBody">               
        <div class="loginSectionFieldNameWrapper" style="padding-bottom: 0px;">
            <marquee scrollamount="1" onmouseover="stop()" onmouseout="start()" direction="left">
                <%

                            List<CountryVO> listOfCountryNationalFlag = null;
                            if(null != session.getAttribute("listOfCountryNationalFlag")){
                                  listOfCountryNationalFlag = (List<CountryVO>)session.getAttribute("listOfCountryNationalFlag");
                                }else{
                                  listOfCountryNationalFlag = lovDataServiceTeaser.populateCountryNationalFlagList();
                                  session.setAttribute("listOfCountryNationalFlag",listOfCountryNationalFlag);
                                }

                            for (CountryVO countryVO : listOfCountryNationalFlag) {
                                if (null != countryVO.getNationalFlag() && !"".equalsIgnoreCase(countryVO.getNationalFlag())) {
                %>

                <a href="<%=countryVO.getCountryName()%>"><img src="NationalFlagIcons/<%=countryVO.getNationalFlag()%>.png" alt="" border="0" style="padding-left: 5px; padding-right: 5px" title="<%=countryVO.getCountryName()%>" ></a>
                    <%}
                                }%>

            </marquee>

        </div>

         <div class="loginSectionFieldNameWrapper" style="padding-top: 0px;">
            <%@include file="countryNameStartsWith.jspf" %>
            <div class="teaserAdvLink" style="font-size: 11px;">
               <%-- <a href="Link.do?method=postAdvertisement"> --%>
                      Find Students &amp; Tutors at your location
               <%--  </a> --%>
              </div>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
</div>


<!--- Division :: Latest News Section Begins -->
<div class="categoryWrapper">
    <div class="categoryTop">Banner Section </div>
    <div class="categoryBody">
        <div class="loginSectionFieldNameWrapper" align="center">

            <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="190" height="250" title="right_banner">
                <param name="movie" value="images/right_banner/banner_right.swf" />
                <param name="quality" value="high" />
                <embed src="<%=request.getContextPath()%>/images/right_banner/banner_right.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="190" height="250"></embed>
            </object>
            <div class="teaserAdvLink">
                  <a href="Link.do?method=postAdvertisement">Post your advertisement here</a>
              </div>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
</div>




<!--- Division :: Latest News Section Begins -->
<div class="categoryWrapper">
    <div class="categoryTop">Recent News !</div>
    <div class="categoryBody">
        <div class="loginSectionFieldNameWrapper">           
            <marquee direction="up" height="150px" scrollamount="1" onmouseover="stop()" onmouseout="start()" >

                <div>
                    <%
                                TutorModel tutorModel = new TutorModel();
                                List<TeaserVO> listOfTeaser = null;
                                if(null != session.getAttribute("listOfTeaser")){
                                     listOfTeaser = (List<TeaserVO>) session.getAttribute("listOfTeaser");

                                    }else{

                                       listOfTeaser  = tutorModel.getTeaserData();
                                       session.setAttribute("listOfTeaser",listOfTeaser);
                                    }

                                for (TeaserVO teaserVO : listOfTeaser) {

                    %>
                    <div>
                        <a href="Link.do?method=teaser"  style="text-decoration: none;">
                            <font class="teasertitle"> <%=teaserVO.getTeaserTitle()%></font>
                        </a>
                    </div>
                    <div class="clear"></div>

                    <% if (null != teaserVO.getTeaserSubjectLine1()) {
                    %>
                    <div>
                        <a href="Link.do?method=teaser" style="text-decoration: none" >
                            <font class="teasersubjectline"><%=teaserVO.getTeaserSubjectLine1()%></font>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <%
                                                        }
                    %>


                    <% if (null != teaserVO.getTeaserSubjectLine2()) {
                    %>
                    <div>
                        <a href="Link.do?method=teaser" style="text-decoration: none">
                            <font class="teasersubjectline"> <%=teaserVO.getTeaserSubjectLine2()%> </font>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <%
                                                        }
                    %>

                    <% if (null != teaserVO.getTeaserSubjectLine3()) {
                    %>
                    <div>
                        <a href="Link.do?method=teaser" style="text-decoration: none" >
                            <font class="teasersubjectline">   <%=teaserVO.getTeaserSubjectLine3()%>  </font>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <%
                                                        }
                    %>

                    <% if (null != teaserVO.getTeaserSubjectLine4()) {
                    %>
                    <div>
                        <a href="Link.do?method=teaser"  style="text-decoration: none">
                            <font class="teasersubjectline"> <%=teaserVO.getTeaserSubjectLine4()%> </font>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <%
                                                        }
                    %>

                    <% if (null != teaserVO.getTeaserSubjectLine5()) {
                    %>
                    <div>
                        <a href="Link.do?method=teaser" style="text-decoration: none" >
                            <font class="teasercontact"> <%=teaserVO.getTeaserSubjectLine5()%> </font>
                        </a>
                    </div>
                    <div class="clear"></div>
                    <%
                                                        }
                    %>
                    <font color="#2088F8" >--------------------------------------------</font>

                    <%}%>
                </div>

            </marquee>
             
                <div class="teaserAdvLink" align="center">
                     <a href="Link.do?method=postAdvertisement">Post classified advertisement</a>
              </div>
        </div>
        <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
    </div>
</div>

<!-- Division ::  Student waiting For Tutors --->
<%--
<div class="categoryWrapper">
    <div class="categoryTop">Registered Students</div>
    <div class="categoryBody">
        <ul>
            <%                       
                        List<StudentRegistrationVO> listOfResentRegisteredStudents = lovDataServiceTeaser.populateLimitedRegisteredStudents();
                        int studentCounter = 0;
                        for (StudentRegistrationVO studentRegistrationVO : listOfResentRegisteredStudents) {
                            studentCounter += 1;
            %>

            <li>
                <a href="viewStudentPartialProfile.do?studentId=<%=studentRegistrationVO.getStudentId()%>">
                    <%=studentRegistrationVO.getName()%>
                </a>
                    <font style="font-size: 8px;color:#05318c;font-weight: bold" >(<%=studentRegistrationVO.getRegistrationDate()%>)</font>
            </li>
            <%
                            if (studentCounter > 4) {
                                break;
                            }

                        }
            %>
        </ul>
        <div class="findMore">
            <a href="viewResentRegisteredStudents.do"> Find More...</a>
        </div>
    </div>
    <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
</div>
--%>

<div class="categoryWrapper">
    <div class="categoryTop">Registered Tutors </div>
    <div class="categoryBody">

        <ul>
            <%
            List<TutorRegistrationVO> listOfResentRegisteredTutors = null;
           /* if(null !=  session.getAttribute("listOfResentRegisteredTutors")){
               listOfResentRegisteredTutors = (List<TutorRegistrationVO>)session.getAttribute("listOfResentRegisteredTutors");
             }else{ */
            
              String countryCode = (String) request.getSession().getAttribute("countryCode");
              String cityName = (String) request.getSession().getAttribute("cityName");
             
             /*  listOfResentRegisteredTutors  = lovDataServiceTeaser.populateLimitedResentRegisteredTutors(countryCode,cityName); */
            //  session.setAttribute("listOfResentRegisteredTutors", listOfResentRegisteredTutors);
            // }

              for (TutorRegistrationVO tutorRegistrationVO : listOfResentRegisteredTutors) {                           
            %>

            <li>
                <a href="viewTutorPartialProfile.do?tutorId=<%=tutorRegistrationVO.getTutorId()%>"> 
                    <%=tutorRegistrationVO.getTutorName()%>
                </a>
                
            </li>
            <div>
                  <font style="font-size: 10px;color:#05318c;font-weight: bold;padding-left: 5px;" ><%=tutorRegistrationVO.getTutorCityLocation()%>&nbsp;&nbsp;(<%=tutorRegistrationVO.getTutorRegistrationDate()%>)</font>
            </div>
            <%}%>
        </ul>

        <div class="findMore">
            <a href="resentRegisteredTutors.do"> Find More...</a>
        </div>
    </div>  

    <div class="categoryBottom"><img src="images/category_round_bottom.gif" alt="" width="201" height="9" /></div>
</div>

      