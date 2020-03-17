<%@page import="java.sql.*" %>


searchResultMenu.jsp

<%
try{
      Class.forName("com.mysql.jdbc.Driver"); 
      Connection conn = DriverManager.getConnection("jdbc:mysql://pcsclouddb.cglogjnuzr7s.ap-south-1.rds.amazonaws.com:3306/ptutors_db?user=pcsclouddb&password=pcsclouddb");

     
      
      if(null != conn ){
          out.println(" Connection Found");
          }else{
           out.println(" Connection Found");
          }

       Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select * from subject");
      %>
      <select>
      <%
      while(rs.next()){
%>
<option value="<%=rs.getString("subject_id")%>"><%=rs.getString("subject_name")%></option>
       
<%
       }
      %>
</select>
      <%
      }
    catch(Exception e)
       {
        out.println("Exception occurs"+e.getMessage());
        e.printStackTrace();
       }

%>