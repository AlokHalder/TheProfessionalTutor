<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.header {
	height: 200px;
	
	font-size: 25px;
	color: green;
	border: 1px solid black;
}

.footer {
	clear: both;
	height: 50px;
}


</style>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<%-- <tiles:insertAttribute name="head" /> --%>
</head>
<body>
	<div class="header">
		<div align="center"><tiles:insertAttribute name="header" /></div>
		<tiles:insertAttribute name="header_1"/>
	</div>
	
    <div style="float: left; padding: 10px; width: 15%;">
		<tiles:insertAttribute name="menu" />
	</div>
 
	<div
		style="float: left; padding: 10px; width: 80%; border-left: 1px solid pink;">
		<tiles:insertAttribute name="body" />
	</div>
	
	 
	<div class="footer" style="">
		<tiles:insertAttribute name="footer" />
	</div>  
</body>
</html>