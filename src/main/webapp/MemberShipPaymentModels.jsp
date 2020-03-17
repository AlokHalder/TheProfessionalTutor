<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="studentUpgrade" ModelAttribute="studentupgrade" > 
  <table >
 <tr>    
          <td>Membership Category : </td>   
          <td><form:input path=" membershipCategory" /></td>  
         </tr>
          <tr>    
          <td>Payment Amount : </td>   
          <td><form:input path=" paymentAmount" /></td>  
         </tr>
         <tr>    
          <td>Mode Of Payment: </td>   
          <td><form:input path="modeOfPayment" /></td>  
         </tr>
         <tr>    
          <td>MemberShip Begin Date: </td>   
          <td><form:input path="membershipBeginDate" /></td>  
         </tr>
         <tr>    
          <td>Membership Expire Warning Date : </td>   
          <td><form:input path="membershipExpireWarningDate" /></td>  
         </tr>
         <tr>    
          <td>Membership Expire Date : </td>   
          <td><form:input path="membershipExpireDate" /></td> 
          </tr>
          <tr>
        <td> <button type="submit" value="Submit">Submit</button></td>
         </tr>
         </table>
         </form:form>

</body>
</html>