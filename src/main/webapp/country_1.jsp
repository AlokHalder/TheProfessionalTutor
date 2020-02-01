<%--<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>--%>
<%@page import="com.pcs.ptutors.vo.CountryVO"%>
<%@page import="java.util.List"%>
<%@page import="com.pcs.ptutors.model.LovDataService"%>
<%@page import="java.sql.*" %>


<%--<html:select property="tutorCountryLocation" styleClass="registrationTextField" styleId="country" onchange="return showState();">--%>
<!--<select name="country" Class="registrationTextField" id="country" onchange="return showState();">-->
<option value="">---Select country---</option>
<%
    LovDataService dataService = new LovDataService();
    List<CountryVO> countryList = dataService.populateCountryList();
    for(CountryVO countryVO:countryList){
        String countryCode = countryVO.getCountryCode();
        String countryName = countryVO.getCountryName();

%>

<option value="<%=countryCode%>"><%=countryName%></option>

<%}%>
<!--</select>-->
<%--
</html:select>--%>
