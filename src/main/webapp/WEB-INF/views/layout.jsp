<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="/resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="/resources/css/chromestyle.css" rel="stylesheet"
	type="text/css">
<link href="/resources/css/controlpanel.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/csshorizontalmenu.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/inputhints.css" rel="stylesheet"
	type="text/css" />
<link href="/resources/css/screen.css" rel="stylesheet" type="text/css" />
<link href="/resources/css/controlpanel.css" rel="stylesheet" type="text/css" />
<link href="/resources/css/csshorizontalmenu.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js_ajax/ajax-dynamic-content.js"></script>
<script type="text/javascript" src="js_ajax/ajax.js"></script>
<script type="text/javascript" src="js_ajax/ajax-tooltip.js"></script>
<script type="text/javascript" src="csshorizontalmenu.js"></script>
<script type="text/javascript" src="js/inputhints.js"></script>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/easySlider1.5.js"></script>
<script type="text/javascript" src="chromejs/chrome.js"></script>

<style type="text/css">
/* body {
	font-family: arial
} */
body {
	background: #fff url(images/bg_body.gif) repeat-x;
	font: 80% Trebuchet MS, Arial, Helvetica, Sans-Serif;
	color: #333;
	line-height: 180%;
	margin: 0;
	padding: 0;
	text-align: center;
}

h1 {
	font-size: 180%;
	font-weight: normal;
	margin: 0;
	padding: 20px;
}

h2 {
	font-size: 160%;
	font-weight: normal;
}

h3 {
	font-size: 140%;
	font-weight: normal;
}

img {
	border: none;
}

pre {
	display: block;
	font: 12px "Courier New", Courier, monospace;
	padding: 10px;
	border: 1px solid #bae2f0;
	background: #e3f4f9;
	margin: .5em 0;
	width: 674px;
}

/* image replacement */
.graphic, #prevBtn, #nextBtn {
	margin: 0;
	padding: 0;
	display: block;
	overflow: hidden;
	text-indent: -8000px;
}
/* // image replacement */
#container {
	margin: 0 auto;
	position: relative;
	text-align: left;
	width: 696px;
	background: #fff;
	margin-bottom: 2em;
}

#header {
	height: 144px;
	background: #5DC9E1;
	color: #fff;
}

#content {
	position: relative;
}

/* Easy Slider */
#slider {
	margin: 0 auto;
}

#slider ul, #slider li {
	margin: 0;
	padding: 0;
	list-style: none;
}

#slider li {
	/*
                        define width and height of list item (slide)
                        entire slider area will adjust according to the parameters provided here
                */
	width: 960px;
	height: 245px;
	overflow: hidden;
	margin: 0 auto;
}

#prevBtn, #nextBtn {
	display: block;
	width: 30px;
	height: 77px;
	position: absolute;
	left: -30px;
	top: 71px;
}

#nextBtn {
	left: 696px;
}

#prevBtn a, #nextBtn a {
	display: block;
	width: 30px;
	height: 77px;
	background: url(images/btn_prev.gif) no-repeat 0 0;
}

#nextBtn a {
	background: url(images/btn_next.gif) no-repeat 0 0;
}

.clear {
	clear: both
}

#gallery {
	position: relative;
	/* height:360px */
	height: 200px
}

#gallery a {
	float: left;
	position: absolute;
}

#gallery a img {
	border: none;
}

#gallery a.show {
	z-index: 500
}

#gallery .caption {
	z-index: 600;
	background-color: #000;
	color: #ffffff;
	height: 100px;
	width: 100%;
	position: absolute;
	bottom: 0;
}

#gallery .caption .content {
	margin: 5px
}

#gallery .caption .content h3 {
	margin: 0;
	padding: 0;
	color: #1DCCEF;
}

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
/*Example CSS for the two demo scrollers*/
#pscroller1 {
	width: 180px;
	height: 320px;
	/*height:100px; */
	border-left: 1px solid #999;
	padding: 5px;
	background-color: white;
}

#pscroller2 {
	width: 350px;
	height: 20px;
	border: 1px solid black;
	padding: 3px;
}

#pscroller2 a {
	text-decoration: none;
}

.someclass {
	/* class to apply to your scroller(s) if desired */
	
}
</style>


<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<%-- <div class="header">
		<div align="center">
			<tiles:insertAttribute name="header" />
		</div>
		<tiles:insertAttribute name="header_1" />
	</div> --%>

<!-- LEFT MENU -->

	<div style="float: left; padding: 10px; width: 15%;">
		<tiles:insertAttribute name="menu" />
	</div>

	<%-- <div
		style="float: left; padding: 10px; width: 80%; border-left: 1px solid pink;">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="footer" style="">
		<tiles:insertAttribute name="footer" />
	</div> --%>
</body>
</html>