<%@ page import ="java.sql.*" %>
<%@page  import="com.pcs.ptutors.model.DbConnection" %>


<%

          String stateid=request.getParameter("svalue");
         DbConnection dbConnection = new DbConnection();
          Connection con=dbConnection.dbConnect();
          Statement stmt=con.createStatement();
          //String sql="select cityname from city where stateid ="+stateid;
          String sql="select location_id,location_name from  location_name where country_code ='"+stateid+"'";

          System.out.println(sql);
          ResultSet rs=stmt.executeQuery(sql);
          response.setContentType("text/xml");
	  StringBuilder cities = new StringBuilder(50);
          cities.append("-1").append("~").append("-: Select Location :-").append(",");

          while(rs.next())
           {

             String locationId =rs.getString(1);
            String locationName=rs.getString(2);

	    cities.append(locationId).append("~").append(locationName).append(",");

            }
           out.println(cities);




%>




