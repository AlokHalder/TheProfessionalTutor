<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.*"%>
<%@page import="java.lang.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.*"%>

<%-- <%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %> --%>
<%@page import="com.pcs.ptutors.vo.InstantTutorServiceVO" %>
<%@page import="java.util.List,java.util.ArrayList"%>
<%@page import="com.pcs.ptutors.model.LovDataService" %>

<%@ include file ="Rc4.jsp" %>
<%
	String key = "d99a3a0783b6452a76890209a2d44411"; //Your Secret Key
	StringBuffer data1 = new StringBuffer().append(request.getParameter("DR"));
      
	for (int i=0; i < data1.length(); i++){
		if(data1.charAt(i)== ' ')
			data1.setCharAt(i,'+');
	}	
	Base64 base64 = new Base64();
	byte[] data = base64.decode(data1.toString());
	RC4 rc4 = new RC4(key);
	byte[] result = rc4.rc4(data);


	ByteArrayInputStream byteIn = new ByteArrayInputStream (result, 0, result.length);
	DataInputStream dataIn = new DataInputStream (byteIn);
	String recvString1 = "";
	String recvString = "";
	recvString1 = dataIn.readLine();
	int i =0;
	while(recvString1 != null ){
		i++;
		if(i > 705) break;
		recvString += recvString1 + "\n";
		recvString1 = dataIn.readLine();
	}
recvString  = recvString.replace( "=&","=--&" )	;
%>
<%--
<HTML>
<HEAD>
<TITLE>E-Billing Solutions Pvt Ltd - Payment Page</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
<style>
	h1       { font-family:Arial,sans-serif; font-size:24pt; color:#08185A; font-weight:100; margin-bottom:0.1em}
    h2.co    { font-family:Arial,sans-serif; font-size:24pt; color:#FFFFFF; margin-top:0.1em; margin-bottom:0.1em; font-weight:100}
    h3.co    { font-family:Arial,sans-serif; font-size:16pt; color:#000000; margin-top:0.1em; margin-bottom:0.1em; font-weight:100}
    h3       { font-family:Arial,sans-serif; font-size:16pt; color:#08185A; margin-top:0.1em; margin-bottom:0.1em; font-weight:100}
    body     { font-family:Verdana,Arial,sans-serif; font-size:11px; color:#08185A;}
	th 		 { font-size:12px;background:#015289;color:#FFFFFF;font-weight:bold;height:30px;}
	td 		 { font-size:12px;background:#DDE8F3}
	.pageTitle { font-size:24px;}
</style>
</HEAD>
<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 bgcolor="#ECF1F7">
<center>
   <table width='100%' cellpadding='0' cellspacing="0" ><tr><th width='90%'><h2 class='co'>&nbsp;The Professional Tutors</h2></th></tr></table>
     <table width="600" cellpadding="2" cellspacing="2" border="0">
        <tr>
            <th colspan="2">Transaction Details</th>
        </tr>
         --%>
<%--
			StringTokenizer st = new StringTokenizer(recvString, "=&");
			String field ,val; 
		while(st.hasMoreTokens()) {
			field = st.nextToken(); 
			
			val = st.nextToken(); 
			
				%>
					<tr>
						<td class="fieldName" width="50%"><%=field%></td>
						<td class="fieldName" align="left" width="50%"><%=val%></td>
					</tr>			
				<%
			
			}
		--%>

<%--
	</table>
</center>
<table width='100%' cellpadding='0' cellspacing="0" ><tr><th width='90%'>&nbsp;</th></tr></table>
</body>
</html>

--%>



<%--
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%--
<html>
--%>

    <head>
        <SCRIPT TYPE="text/javascript">
            <!--
            //Disable right click script
            //visit http://www.rainbow.arch.scriptmania.com/scripts/
            var message="Sorry, right-click has been disabled";
            ///////////////////////////////////
            function clickIE() {if (document.all) {(message);return false;}}
            function clickNS(e) {if
                (document.layers||(document.getElementById&&!document.all)) {
                    if (e.which==2||e.which==3) {(message);return false;}}}
            if (document.layers)
            {document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;}
            else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;}
            document.oncontextmenu=new Function("return false")
            // -->
        </SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>..::Professional Tutors::..</title>

        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="chrometheme/chromestyle.css" />


        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/easySlider1.5.js"></script>
        <script type="text/javascript" src="chromejs/chrome.js"></script>


        <script type="text/javascript">
            $(document).ready(function(){
                $("#slider").easySlider({
                    auto: true,
                    continuous: true
                });
            });
        </script>
      
    </head>

    <body class="body">
        <div id="professionalMainBodyWrapper" style="border: 1px solid #999; border-top:none; border-bottom:none; padding-top:1px;">
            <div id="mainroundedBodysectionWrapper">
                <!--Navigation Section Start Here-->
               <%-- <tiles:insert attribute="header" /> --%>
                <!--Navigation Section End Here-->
                <div id="sitemainBodyWrapper">
                  <%--  <tiles:insert attribute="menu" /> --%>
                    <div id="mainBodyandRgtSectionWrapper">
                        <div class="welcomesectionWrapper">
                         

                            <!--- Begin : Body Section -->
                            <table width='100%' cellpadding='0' cellspacing="0" ><tr><th width='90%'><h2 class='co'>&nbsp;The Professional Tutors</h2></th></tr></table>
     <table width="600" cellpadding="2" cellspacing="2" border="0">
        <tr>
            <th colspan="2">Transaction Details</th>
        </tr>
             <%
			StringTokenizer st = new StringTokenizer(recvString, "=&");
			String field ,val;
		while(st.hasMoreTokens()) {
			field = st.nextToken();

			val = st.nextToken();

				%>
					<tr>
						<td class="fieldName" width="50%"><%=field%></td>
						<td class="fieldName" align="left" width="50%"><%=val%></td>
					</tr>
				<%

			}
		%>


	</table>
                            <!-- End : Body Section -->
                        </div>
                        <div id="rightpanalWrapper">
                         <%--   <tiles:insert attribute="teaser"/>  --%>
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <!--Body Section End Here-->
                </div>
            </div>
            <div class="clear"></div>
        </div>
       <%-- <tiles:insert attribute="footer" /> --%>
    </body>
</html>
