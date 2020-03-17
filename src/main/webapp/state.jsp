<%@page import="com.pcs.ptutors.vo.LocationVO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcs.ptutors.model.LovDataService"%>
<%@page import="java.sql.*" %>


<!--<select name="state" Class="registrationTextField" id="state" onchange="">-->
<!--<option value="">---Select country---</option>-->
<option value="">---Select Location---</option>
<%
String c = request.getParameter("c");


LovDataService dataService = new LovDataService();
    List<LocationVO> locationList = dataService.populateRandomCityOnCountryCode(c);
    for(LocationVO locationVO:locationList){
        String locationCode = locationVO.getCityCode();
        String locationName = locationVO.getCityName();

%>

<option value="<%=locationCode%>"><%=locationName%></option>

<%}%>
<!--</select>-->