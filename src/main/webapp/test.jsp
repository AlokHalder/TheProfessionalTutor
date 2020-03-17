<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page  import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date" %>

<%-- <logic:redirect forward="welcome.do"/> --%>
<head>
<%--<script language="javascript" type="text/javascript" src="js/datetimepick/datetimepicker.js">

//Date Time Picker script- by TengYong Ng of http://www.rainforestnet.com
//Script featured on JavaScript Kit (http://www.javascriptkit.com)
//For this script, visit http://www.javascriptkit.com

</script>
</head>
<input id="demo1" type="text" size="25"><a href="javascript:NewCal('demo1','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>



<%

 Calendar date = Calendar.getInstance();
 SimpleDateFormat dateformatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
 dateformatter.format(date.getTime());
 Date dt = dateformatter.parse("Sun Apr 17 01:08:04 IST 2011");
 out.println("Date1 :: "+ date.getTime());
 out.println(" Date2 ::" + dt);
       // if(dateformatter.format(date.getTime()).equalsIgnoreCase("02:45:00 AM MST")){
             if(date.getTime().after(dt)){

               

%>
<br/>
<%
      out.println(" Time 2: " + dt );

             //response.sendRedirect("http://www.theprofessionaltutors.com/TheProfessionalTutors/home.jsp");
            }else{

     out.println(" Else Time 1: " + date.getTime());
      out.println(" Else Time 2: " + dt );
%> --%>

   <p>
     <font color="green" style="font-weight:bold;"> THIS PAGE IS TEMPORARILY DOWN DUE TO SOFTWARE UPGRADATION . SERVISE WILL AGAIN BACK </font> <br/>
      
      <font color="red" style="font-weight:bold;"> we apologize for the inconvenience </font>
  </p>
<!--
<select dir="top" >
    <option  >gg</option>
</select>-->