<%@page import="com.pcs.ptutors.model.LovDataService" %>
<%@page import = "com.pcs.ptutors.vo.LocationVO"%>
<%@page import="com.pcs.ptutors.vo.CountryVO"%>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<%@page import="java.util.List" %>


<%
            LovDataService lovDataServiceLayoutHeaderObj = new LovDataService();
            String countryName = (String) request.getSession().getAttribute("countryName");
            String countryCode = (String) request.getSession().getAttribute("countryCode");
            if (null == countryCode) {
                request.getSession().setAttribute("countryCode", "IND");
                request.getSession().setAttribute("countryName", "India");
            }
            countryName = (String) request.getSession().getAttribute("countryName");
            countryCode = (String) request.getSession().getAttribute("countryCode");
            String cityName = (String) request.getSession().getAttribute("cityName");

            if (null == cityName) {
                LocationVO locationVO = lovDataServiceLayoutHeaderObj.populateRandomCitySelection(countryCode);
                request.getSession().setAttribute("cityName", locationVO.getCityName());
            }
%>
<script type="text/javascript" >
    function searchCountry(){
        var countryCode = document.getElementById('country').value;
        location.href = "viewCountryBasedProfessionalTutorData.do?countryCode="+countryCode;

    }
    function searchCity(){
        var cityName = document.getElementById('cityName').value;

        location.href = "viewCityBasedProfessionalTutorData.do?selectedCity="+cityName;
    }

</script>
<!--Body Section Start Here-->
<div id="logoWrapper">
    <div class="logoSection">
        <a href="Link.do?method=home" ><img src="images/logo.gif" alt="Logo" border="0" /></a>
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
            <br/>Help Line :<span>+913369975052</span> (IST 10:00 Am to 6:00 PM)
            <br/>Support Line: <span>+918697741613</span>(24*7)
            <br>E-mail : <font  color="green" style="font-weight:bold">helpdesk@theprofessionaltutors.com</font>
            <br>Send Resume : <font  color="teal" style="font-weight:bold">hr@theprofessionaltutors.com</font>

        </div>
        <div class="chooseyourCountry">
            <div class="locationName">

                <%

                            if (null != countryName && null == cityName) {
                %>
                <%=countryName%>
                <%}%>

                <% if (null != countryName && null != cityName) {%>
                <%=cityName%>,<%=countryName%>
                <%}%>


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
            <div class="dropDownSection" style="margin-left:none;">
                <select onchange="searchCountry()" name="selectedCountry" id="country" style="width:170px; border:1px solid #0777E8;" >
                    <option value="" selected>-:Select Country :-</option>
                    <option value="IND">India</option>
                    <option value="AFG">Afganistan </option>
                    <option value="AFU">African Union </option>
                    <option value="AGI">Anguilla </option>
                    <option value="AGL">Angola</option>
                    <option value="ALA">Alaska</option>
                    <option value="ALB">Albania</option>
                    <option value="ALG">Algeria</option>
                    <option value="AND">Andorra</option>
                    <option value="ANT">Antarctica</option>
                    <option value="ARG">Argentina</option>
                    <option value="ARL">Arab League</option>
                    <option value="ARM">Armenia</option>
                    <option value="ARU">Aruba</option>
                    <option value="ASE">Asean</option>
                    <option value="ATG">Antigua & Barbuda</option>
                    <option value="ATN">Netherlands Antilles</option>
                    <option value="AUS">Australia</option>
                    <option value="AUT">Austria</option>
                    <option value="AZE">Azerbaijan</option>
                    <option value="AZR">Azores</option>


                    <option value="BAH">Bahamas</option>

                    <option value="BHR">Bahrain</option>

                    <option value="BNG">Bangladesh</option>

                    <option value="BRB">Barbados</option>

                    <option value="BLR">Belarus</option>

                    <option value="BEL">Belgium</option>

                    <option value="BLZ">Belize</option>

                    <option value="BEN">Benin</option>

                    <option value="BER">Bermuda</option>

                    <option value="BHU">Bhutan</option>

                    <option value="BOL">Bolivia</option>

                    <option value="BOS">Bosnia & Herzegovina</option>

                    <option value="BOT">Botswana</option>

                    <option value="BRA">Brazil</option>

                    <option value="BRU">Brunei</option>

                    <option value="BUL">Bulgaria</option>
                    <%--
                    <option value="Burkina Faso">Burkina Faso</option>

<option value="Burma (Myanmar)">Burma (Myanmar)</option>
                    --%>
                    <option value="BDI">Burundi</option>

                    <option value="CBG">Cambodia</option>

                    <option value="CAM">Cameroon</option>

                    <option value="CAN">Canada</option>
                    <%--
                    <option value="Canary Islands">Canary Islands</option>
                    --%>
                    <option value="CAV">Cape Verde</option>

                    <option value="CYM">Cayman Islands</option>

                    <option value="CAF">Central African Rep. </option>
                    <%--
                    <option value="Chad">Chad</option>

<option value="Channel Islands">Channel Islands</option>
                    --%>
                    <option value="CHL">Chile</option>

                    <option value="CHN">China</option>

                    <option value="CHR">Christmas Island</option>

                    <option value="COL">Colombia</option>

                    <option value="COM">Comoros</option>

                    <option value="COG">Congo</option>
                    <%--
                    <option value="Congo Dem. Rep">Congo Dem. Rep</option>
                    --%>
                    <option value="COK">Cook Islands</option>

                    <option value="CRI">Costa Rica</option>

                    <option value="CRO">Croatia</option>

                    <option value="CUB">Cuba</option>

                    <option value="CYP">Cyprus</option>
                    <%--
                    <option value="Czech Rep. ">Czech Rep. </option>
                    --%>
                    <option value="DNK">Denmark</option>

                    <option value="DJI">Djibouti</option>

                    <option value="DMA">Dominica</option>

                    <option value="DOM">Dominican Rep. </option>
                    <%--
                    <option value="East Timor">East Timor</option>
                    --%>
                    <option value="ECU">Ecuador</option>

                    <option value="EGY">Egypt</option>
                    <%--
                    <option value="Equatorial Guinea">Equatorial Guinea</option>
                    --%>
                    <option value="ERI">Eritrea</option>

                    <option value="EST">Estonia</option>

                    <option value="ETH">Ethiopia</option>

                    <option value="FLK">Falkland Islands</option>

                    <option value="FRO">Faroe Islands</option>

                    <option value="FIJ">Fiji</option>

                    <option value="FIN">Finland</option>

                    <option value="FRA">France</option>

                    <option value="GIA">French Guiana</option>
                    <%--
                    <option value="French Polynesia">French Polynesia</option>
                    --%>
                    <option value="GAB">Gabon</option>

                    <option value="GAM">Gambia</option>

                    <option value="GEO">Georgia</option>

                    <option value="GER">Germany</option>

                    <option value="GHA">Ghana</option>

                    <option value="GIB">Gibraltar</option>

                    <option value="GBR">Great Britain</option>

                    <option value="GRE">Greece</option>

                    <option value="GRL">Greenland</option>

                    <option value="GRD">Grenada</option>

                    <option value="GDL">Guadeloupe</option>

                    <option value="GUM">Guam</option>

                    <option value="GTM">Guatemala</option>
                    <%--
                    <option value="Guiana (French) ">Guiana (French) </option>
                    --%>
                    <option value="GUI">Guinea</option>
                    <%--
                    <option value="Guinea (Equat.) ">Guinea (Equat.) </option>
                    --%>
                    <option value="GNB">Guinea-Bissau</option>

                    <option value="GUY">Guyana</option>

                    <option value="HAI">Haiti</option>

                    <option value="HAW">Hawaii</option>

                    <option value="HND">Honduras</option>

                    <option value="HUN">Hungary</option>

                    <option value="ISL">Iceland</option>

                  
                    <option value="IDN">Indonesia</option>

                    <option value="IRN">Iran</option>

                    <option value="IRQ">Iraq</option>

                    <option value="IRL">Ireland</option>
                    <%--
                    <option value="Isle of Man">Isle of Man</option>
                    --%>
                    <option value="ISR">Israel</option>

                    <option value="ITA">Italy</option>
                    <%--
                    <option value="Ivory Coast">Ivory Coast</option>
                    --%>
                    <option value="JAM">Jamaica</option>

                    <option value="JAP">Japan</option>
                    <%--
                    <option value="Jersey & Guernsey">Jersey & Guernsey</option>
                    --%>
                    <option value="JOR">Jordan</option>

                    <option value="KAZ">Kazakhstan</option>

                    <option value="KEN">Kenya</option>

                    <option value="KIR">Kiribati</option>

                    <option value="KOR">Korea</option>

                    <option value="KUW">Kuwait</option>

                    <option value="KGZ">Kyrgyzstan</option>

                    <option value="LAO">Laos</option>

                    <option value="LAT">Latvia</option>

                    <option value="LIB">Lebanon</option>

                    <option value="LSO">Lesotho</option>

                    <option value="LBR">Liberia</option>

                    <option value="LBY">Libya</option>

                    <option value="LIE">Liechtenstein</option>

                    <option value="LIT">Lithuania</option>

                    <option value="LUX">Luxembourg</option>

                    <option value="MAC">Macau</option>

                    <option value="MKD">Macedonia</option>

                    <option value="MAD">Madagascar</option>

                    <option value="MDR">Madeira</option>

                    <option value="MWI">Malawi</option>

                    <option value="MLS">Malaysia</option>

                    <option value="MLD">Maldives</option>

                    <option value="MLI">Mali</option>

                    <option value="MLT">Malta</option>

                    <option value="MAN">Man (Isle) </option>

                    <option value="MRN">Mariana Islands</option>

                    <option value="MHL">Marshall Islands</option>

                    <option value="MTN">Martinique</option>

                    <option value="MRT">Mauritania</option>

                    <option value="MRI">Mauritius</option>

                    <option value="MYT">Mayotte</option>

                    <option value="MEX">Mexico</option>

                    <option value="MIC">Micronesia</option>

                    <option value="MOL">Moldova</option>

                    <option value="MCO">Monaco</option>

                    <option value="MNG">Mongolia</option>

                    <option value="MSR">Montserrat</option>

                    <option value="MAR">Morocco</option>

                    <option value="MOZ">Mozambique</option>
                    <%--
                    <option value="Myanmar">Myanmar</option>
                    --%>
                    <option value="NAM">Namibia</option>

                    <option value="NRU">Nauru</option>

                    <option value="NEP">Nepal</option>

                    <option value="NED">Netherlands</option>
                    <%--
                    <option value="Netherlands Antilles">Netherlands Antilles</option>
                    --%>
                    <option value="NCL">New Caledonia</option>

                    <option value="NZL">New Zealand</option>

                    <option value="NIC">Nicaragua</option>

                    <option value="NGR">Niger</option>

                    <option value="NIG">Nigeria</option>

                    <option value="NIU">Niue</option>

                    <option value="NFK">Norfolk</option>
                    <%--
                    <option value="Northern Mariana Isl. ">Northern Mariana Isl. </option>
                    --%>
                    <option value="NOR">Norway</option>

                    <option value="OMA">Oman</option>

                    <option value="PAK">Pakistan</option>

                    <option value="PLW">Palau</option>

                    <option value="PAN">Panama</option>

                    <option value="PNG">Papua New Guinea</option>

                    <option value="PAR">Paraguay</option>

                    <option value="PER">Peru</option>

                    <option value="PHL">Philippines</option>

                    <option value="PIT">Pitcairn</option>

                    <option value="POL">Poland</option>

                    <option value="PFR ">Polynesia (French) </option>

                    <option value="PRT">Portugal</option>

                    <option value="PRI">Puerto Rico</option>

                    <option value="QAT">Qatar</option>

                    <option value="REU">Reunion</option>

                    <option value="ROM">Romania</option>

                    <option value="RUS">Russia</option>

                    <option value="RWA">Rwanda</option>

                    <option value="SHE">Saint Helena</option>

                    <option value="SKN">Saint Kitts & Nevis</option>

                    <option value="SLU">Saint Lucia</option>

                    <option value="SLV">Salvador</option>

                    <option value="SAA)">Samoa (American)</option>

                    <option value="SAM ">Samoa (Western) </option>

                    <option value="SMR">San Marino</option>

                    <option value="STP">Sao Tome & Principe</option>

                    <option value="SAU">Saudi Arabia</option>

                    <option value="SEN">Senegal</option>

                    <option value="SEY">Seychelles</option>

                    <option value="SLE">Sierra Leone</option>

                    <option value="SGP">Singapore</option>

                    <option value="SLO">Slovakia</option>

                    <option value="SVN">Slovenia</option>

                    <option value="SLM">Solomon</option>

                    <option value="SOM">Somalia</option>

                    <option value="SAF">South Africa</option>
                    <%--
                    <option value="Spain">Spain</option>

<option value="Spain / Canary">Spain / Canary</option>
                    --%>
                    <option value="SRI">Sri Lanka</option>

                    <option value="SPM">St Pierre & Miquelon</option>
                    <%--
                    <option value="St Vincent & Grenad.">St Vincent & Grenad.</option>
                    --%>
                    <option value="SDN">Sudan</option>

                    <option value="SUR">Suriname</option>

                    <option value="SWA">Swaziland</option>

                    <option value="SWE">Sweden</option>

                    <option value="SUI">Switzerland</option>

                    <option value="SYR">Syria</option>

                    <option value="TAI">Taiwan</option>

                    <option value="TJK">Tajikistan</option>

                    <option value="TZA">Tanzania</option>

                    <option value="THA">Thailand</option>

                    <option value="TOG">Togo</option>

                    <option value="TOK">Tokelau</option>

                    <option value="TON">Tonga</option>

                    <option value="TRI">Trinidad & Tobago</option>

                    <option value="TUN">Tunisia</option>

                    <option value="TUR">Turkey</option>

                    <option value="TKM">Turkmenistan</option>

                    <option value="TCA">Turks & Caicos Isl. </option>

                    <option value="TUV">Tuvalu</option>

                    <option value="UGA">Uganda</option>

                    <option value="UKR">Ukraine</option>

                    <option value="UAE">United Arab Emirates</option>

                    <option value="UDT">United Kingdom</option>

                    <option value="URU">Uruguay</option>

                    <option value="USA">USA</option>

                    <option value="ULA">USA / Alaska</option>

                    <option value="UAW">USA / Hawaii</option>

                    <option value="UZB">Uzbekistan</option>

                    <option value="VAN">Vanuatu</option>

                    <option value="VAT">Vatican</option>

                    <option value="VEN">Venezuela</option>

                    <option value="VTN">Viet Nam</option>

                    <option value="VRG">Virgin Island GB</option>

                    <option value="VIR">Virgin Island US</option>

                    <option value="WAL">Wallis & Futuna</option>
                    <%--
                    <option value="Western Sahara">Western Sahara</option>

<option value="Western Samoa">Western Samoa</option>
                    --%>
                    <option value="YEM">Yemen</option>

                    <option value="YUG">Yugoslavia</option>

                    <option value="ZAI">Zaire (Congo D.Rep) </option>

                    <option value="ZAM">Zambia</option>

                    <option value="ZIM">Zimbabwe</option>



                </select>
            </div>

            <div class="dropDownSection">
                <select onchange="searchCity()" name="selectedCity" id="cityName" style="width:170px; border:1px solid #0777E8;">
                    <option value="">-:Select your location :-</option>
                    <%
                                String countryValue = (String) request.getSession().getAttribute("countryCode");
                                LovDataService lovDataServiceForCity = new LovDataService();
                                List<ListOfValuesVO> listOfCityOfCountry = lovDataServiceForCity.populateLocationsOfCountry(countryValue);

                                for (ListOfValuesVO listOfValuesVO : listOfCityOfCountry) {
                    %>
                    <option value="<%=listOfValuesVO.getLabelName()%>"><%=listOfValuesVO.getLabelName()%></option>
                    <%}%>
                </select>
            </div>
        </div>
    </div>

    <div class="clear"></div>
</div>


<div id="mainBannerSection">
    <div id="slider">
        <ul>
            <li>

                <a href="Link.do?method=home">
                    <img src="images/redbery.jpg" alt="Css Template Preview" /></a>
            </li>
           <%-- <li><a href="Link.do?method=home"><img src="images/01.jpg" alt="Css Template Preview" /></a></li> --%>
                    <%--<li><a href="Link.do?method=home"><img src="images/img5.jpg" alt="Css Template Preview" /></a></li> --%>
            <li><a href="Link.do?method=home" ><img src="images/03.jpg" alt="Css Template Preview" /></a></li>
                    <%--  <li><a href="Link.do?method=home" ><img src="images/04.jpg" alt="Css Template Preview" /></a></li> --%>
           <%-- <li><a href="Link.do?method=home"><img src="images/05.jpg" alt="Css Template Preview" /></a></li> --%>

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
                <%--  <a href="Link.do?method=home" rel="dropmenu1" >Home</a> --%>
                <a href="Link.do?method=aboutus">About Us</a>
            </li>
            <li>
                <a href="Link.do?method=tutorRegistration" rel="dropmenu2">Tutors Arena</a>
            </li>
            <li>
                <a href="Link.do?method=studentRegistration" rel="dropmenu3">Student Arena</a>
            </li>
            <li>
                <a href="tutorialCenterProfile.do?method=tutorialCenterRegistration" rel="dropmenu4">Tutorial Center</a>
            </li>
            <li>
                <a href="Link.do?method=postTution" rel="dropmenu5">Post Tution</a>
            </li>
            <li>
                <a href="Link.do?method=academia" rel="dropmenu6">Academia</a>
            </li>
            <li>
                <a href="Link.do?method=payment" rel="dropmenu7">Payment</a>
            </li>
            <li>
                <a href="search.do" rel="dropmenu8">Search</a>
            </li>
            <li>
                <a href="Link.do?method=contactus" rel="dropmenu9">Contact us</a>
            </li>
            <li>
                <a href="Link.do?method=help" rel="dropmenu10">FAQ</a>
            </li>
        </ul>
        <!--1st drop down menu -->
        <div id="dropmenu1" class="dropmenudiv">

            <%--
            <a href="Link.do?method=ourservice">Services</a>
            <a href="Link.do?method=tour">A Tour To Our Website</a>
            --%>
        </div>

        <div id="dropmenu2" class="dropmenudiv">           
            <a href="Link.do?method=tutorLogin">Tutor Login</a>
            <a href="Link.do?method=tutorProfileRegistration" >Tutor Registration</a>
            <a href="resentRegisteredTutors.do">View Tutors Profile</a>
            <a href="jsp/tutor/downloadTutorRegistrationForm.jsp">Download tutor regn form</a>
        </div>

        <div id="dropmenu3" class="dropmenudiv">
            <a href="Link.do?method=studentLogin">Student Login</a>
            <a href="Link.do?method=studentRegistration">Student Registration</a>
            <%-- <a href="viewResentRegisteredStudents.do"> View Students Profile</a>   Functionali--%>
            <a href="instantTutorService.do">View Students Profile</a>
            <a href="jsp/student/downloadStudentRegistrationForm.jsp"> <font size="1px;">Download student regn form</font></a>

        </div>

        <div id="dropmenu4" class="dropmenudiv">
            <a href="tutorialCenter.do?method=instituteLoginPage">Tutorial Center Login</a>
            <a href="tutorialCenter.do?method=tutorialCenterRegistration">Institute Registration</a>
            <a href="viewResentRegisteredInstitutes.do">View Institutes Profile</a>
            <a href="tutorialcenter/downloadInstituteRegistationForm.jsp">Download inst. regn form</a>
        </div>

        <div id="dropmenu5" class="dropmenudiv">
            <a href="Link.do?method=postTution" >Post Tution Requirement</a>
            <a href="instantTutorService.do">Wanted Tutors Now</a>
            <a href="resentRegisteredTutors.do">Find Your Tutor</a>
        </div>

        <div id="dropmenu6" class="dropmenudiv">
            <a href="Link.do?method=studyMaterials">Study Materials</a>
            <a href="Link.do?method=educationalResources">Educational Resources</a>
            <a href="Link.do?method=academicNewsLetter">Academic Newsletter</a>
        </div>

        <div id="dropmenu7" class="dropmenudiv">
            <a href="Link.do?method=payment">Mode Of Payment</a>
            <a href="Link.do?method=upgradeMembership">Upgrade Membership Now</a>
        </div>

        <div id="dropmenu8" class="dropmenudiv">
            <%-- <a href="Link.do?method=searchingProcedure">How It Works</a>  --%>

            <a href="search.do">Tutors/Students/Institute</a>
            <a href="Link.do?method=viewTutorsInYourArea">Search Tutor At Doorstep</a>

        </div>

        <div id="dropmenu9" class="dropmenudiv">
            <a href="Link.do?method=contactus">Reach Us Now</a>
            <a href="Link.do?method=postAdvertisement">Book Your Advertisement</a>
            <a href="Link.do?method=franchisee">Contact For Franchisee</a>
            <a href="Link.do?method=referral">Awards/Referral Bonus</a>
        </div>

        <div id="dropmenu10" class="dropmenudiv">
            <a href="Link.do?method=frequentlyAskedQuestion">FAQ</a>
            <a href="Link.do?method=howItWorks">How It Works</a>
            <a href="Link.do?method=feedback">Your Feedback</a>
            <a href="Link.do?method=assistance">How Can We Assist You?</a>
        </div>

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
