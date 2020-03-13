<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%-- <script type="text/javascript">  
<s:url var="url_jqlib" value="/jsp/library/jquery-3.4.1.min.js"  />
<script src="${url_jqlib}"></script>  --%> 
<script> 
<%--  <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"> 
 --%>
 
 $(document).ready(function (){
	$("#id_check_avail").click(function(){
		$.ajax({
			url : 'check_avail',
			data :{username: $("#id_username").val()},
			success:function(data){
				$("#id_res_div").html(data);

				$(document).ready(function () {
				     setInterval(function() {
				         alert('Next alert in 30 secs'); }, 5000); //5 seconds
				});
				
				}
			});
		});
});

</script>
<style>  
.error{color:red} 
</style>
</head>
<body>
 <form:form method="post" action="tutorProfileRegistartion" modelAttribute="Register"> 
  <table >
  <h2>Tutor Login Information</h2>    
         <tr>    
          <td>Desired Username : </td>   
          <td><form:input id="id_username" path="tutorLoginName" />
           <button id="id_check_avail">Check Availability</button>
                            <div id="id_res_div" class="error"></div> 
                            </td> 
         </tr>    
          
         <tr>    
          <td>Choose password : </td>   
          <td><form:input path="tutorPassword" /></td>  
         </tr>
          <tr>    
          <td>Secret Questions : </td>   
          <td><form:input path="tutorSecretQuestion" /></td>  
         </tr>
          <tr>    
          <td>Answer : </td>   
          <td><form:input path="tutorSecretQuestionAnswer" /></td>  
         </tr>
         </table><br>
         <h2>Personal Details</h2>
         <tr>    
          <td>Name : </td>   
          <td><form:input path="tutorName" /></td>  
         </tr>
         <tr>    
          <td>Gender: </td>   
          <td><form:input path="tutorSex" /></td>  
         </tr>
         <tr>    
          <td>Age : </td>   
          <td><form:input path="tutorAge" /></td>  
         </tr>
         <tr>    
          <td>Country : </td>   
          <td><form:input path="tutorCountryLocation" /></td>  
         </tr>
         <tr>    
          <td>Location : </td>   
          <td><form:input path="tutorCityLocation" /></td>  
         </tr>
          <tr>    
          <td>Postal/Zip code : </td>   
          <td><form:input path="tutorCountryCode" /></td>  
         </tr>
          <tr>    
          <td>Area : </td>   
          <td><form:input path="tutorCityLocationId" /></td>  
         </tr>
          <tr>    
          <td>Present Address : </td>   
          <td><form:input path="tutorAddress" /></td>  
         </tr>
         <tr>    
          <td>Tutor contact : </td>   
          <td><form:input path="contactNumber" /></td>  
         </tr>
          <tr>    
          <td>Tutor Email : </td>   
          <td><form:input path="tutorEmailId" /></td>  
         </tr>
          
 </form:form>   
</body>
</html>