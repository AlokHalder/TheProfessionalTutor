<%-- <%@ taglib uri="/WEB-INF/struts-html.tld" prefix ="html"%> --%>
<%@page  import="com.pcs.ptutors.model.TutorModel,com.pcs.ptutors.model.LovDataService" %>
<%@page import="java.util.*,com.pcs.ptutors.vo.LocationVO,java.sql.*" %>
<%@page import="com.pcs.ptutors.vo.TeaserVO" %>
<%@page import="com.pcs.ptutors.vo.CountryVO" %>
<%@page import="com.pcs.ptutors.vo.ListOfValuesVO" %>
<%@page  import="com.pcs.ptutors.model.LovDataService" %>

<script type="text/javascript" >

  /*  function searchLocation(){
        //var countryName = document.documentgetElementById('country').value;
        alert(" Country name :: " +  countryName);
       // location.href = "Link.do?method=searchtutor&selectedCountry="+countryName;
    }
*/


    function searchCity(){
        var countryName = document.getElementById('country').value;
        var cityName = document.getElementById('cityName').value;
        alert(" countryName : " + countryName);

       // location.href = "Link.do?method=searchtutor&selectedCountry="+countryName+"&selectedCity="+cityName;
    }

  /*  function searchEducationLevel(){
        var countryName = document.getElementById('country').value;
        var cityName = document.getElementById('cityName').value;
        var educationLevel = document.getElementById('educationLevel').value;
        location.href = "Link.do?method=searchtutor&selectedCountry="+countryName+"&selectedCity="+cityName+"&selectedEducationLevel="+educationLevel;
    }
    */

</script>


<div class="ourToutorWrapper">
    <div class="tutorHeader">
        Search Your Tutor
    </div>

    <div class="tutorBoxBody">
        <div class="registrationHeading">
            Search Tutor at your Door Step
        </div>
        <div class="loginInfoWrapper">
            <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                    Country :
                </div>
                <div>
                    <select class="registrationTextField" onchange="searchCity()" name="selectedCountry" id="country" >
                        <option value="zss" selected>-:Select Country :-</option>
                        <%
                         LovDataService lovDataService = new LovDataService();
                         List<CountryVO> listOfCountry = lovDataService.populateCountryList();
                         for(CountryVO country:listOfCountry) {
                        %>
                        <option value="<%=country.getCountryName()%>"><%=country.getCountryName()%></option>
                        <%}%>
                    </select>
                </div>
                <div class="clear"></div>
            </div>
              <div class="fieldNameWrapper" style="margin-top:10px;">
                <div class="labelName">
                   Location :
                </div>
                <div>
                    <select class="registrationTextField" >
                        <option value="" selected>-:Select Location :-</option>
                       <option value="">Kolkata</option>

                    </select>
                </div>
                <div class="clear"></div>
            </div>

        </div> <!-- End of Login Wrapper -->
    </div> <!-- End of Tutor Box Body -->


   <%--  </html:form> --%>
    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
</div> <!-- End of Our Tutor Wrapper -->
