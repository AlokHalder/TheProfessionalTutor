<%@page import="com.pcs.ptutors.model.DbConnectionPool"%>
<%-- <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> --%>
<%@page import="com.pcs.ptutors.vo.LocationVO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcs.ptutors.model.LovDataService"%>
<%@page import="java.sql.*" %>


<!--<select name="state" Class="registrationTextField" id="state" onchange="">-->
<!--<option value="">---Select country---</option>-->
<option value="">---Select Location---</option>
<%--<html:select property="cityName"  styleClass="registrationTextField">--%>  
<%--<html:option value="">---Select Location---</html:option>--%>
<%
    String instituteid_hidden = request.getParameter("instituteid_hidden");
    //String instituteid_hidden = "BBJ12344";

    //code for selecting the existing location code.....
    String locationCode_selected = null;
    Connection conn = DbConnectionPool.dbConnectThree();
    PreparedStatement ps = conn.prepareStatement("select INSTITUTE_LOCATION_ID from tutorial_center where INSTITUTE_ID=?");
    ps.setString(1, instituteid_hidden);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        locationCode_selected = rs.getString("INSTITUTE_LOCATION_ID");
    }



    LovDataService dataService = new LovDataService();
    List<LocationVO> locationList = dataService.populateRandomCityOnCountryCode2();
    for (LocationVO locationVO : locationList) {
        String locationCode = locationVO.getCityCode();
        String locationName = locationVO.getCityName();

%>

<%--<html:option value="<%=locationCode%>"><%=locationName%></html:option>--%>
<%--</html:select>--%> 
<option value="<%=locationCode%>" 
        <%if (locationCode_selected.equals(locationCode)) {%>
        selected="selected"
        <%}%>
        ><%=locationName%></option>
<%}%>
<!--</select>-->