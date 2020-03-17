<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
    String countryCode = (String) request.getSession().getAttribute("countryCode");
    String locationId = (String) request.getSession().getAttribute("locationId");
    if (null == countryCode && null == locationId) {
        request.getSession().setAttribute("countryName", "India");
        request.getSession().setAttribute("locationName", "Kolkata");
        request.getSession().setAttribute("countryCode", "IND");
        request.getSession().setAttribute("locationId", "1");
    }

%>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
</script>
   

<div  class="search_bg">
    <html:form method="post" action="allsearchresult" ModelAttribute="modelsearchh">
        <table>
            <tr>
                <td> Find </td>
                <td> <%@include file="/WEB-INF/views/library/searchoptions.jspf"%> </td>
                <td>In </td>
                <td> 
                    <%@include file="/WEB-INF/views/library/indialocations.jspf"%>

                </td>
                <td>For</td>
                <td  >  <%@include file="/WEB-INF/views/library/subject1.jspf"%>   </td>
                <td>Of</td>
                <td>
                    <%@include file="/WEB-INF/views/library/segmentLevel1.jspf"%>
                </td>
                <td>
                
                 <button type="submit" value="Submit">Submit</button>
                          
                </td>
            </tr>   
        </table>
    </html:form>
  

  
       

    <script type="text/javascript">

        $(document).ready(function() {

            $("#countryCode").change(function(){
                var coun = $("#countryCode").val();

                var url = "<%=request.getContextPath()%>/citybycountry.do?countryid="+coun;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {
        		  
                    $("#loctionId").html(data);
                    $("#loctionCode").html(data);
                }

            );

            });

            $("#loctionId").change(function(){
                var coun = $("#countryCode").val();
                var loc = $("#loctionId").val();
                var counname = $('#countryCode option:selected').text();
                var locname = $('#loctionId option:selected').text();
              
                var url = "<%=request.getContextPath()%>/storeCountryLocation.do?countryid="+coun+"&locationid="+loc+"&locationname="+locname+"&countryname="+counname;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {

                    $("#locvalid").html(data);
                }

            );

            });


            $("#loctionCode").change(function(){
                var coun = $("#countryCode").val();
                var loc = $("#loctionId").val();
                var counname = $('#countryCode option:selected').text();
                var locname = $('#loctionId option:selected').text();

                var url = "<%=request.getContextPath()%>/storeCountryLocation.do?countryid="+coun+"&locationid="+loc+"&locationname="+locname+"&countryname="+counname;
                //retrieveURL(url);
                $.get(
                url,
                function(data)
                {

                    $("#locvalid").html(data);
                }

            );

            });


        });

    </script>


    <script>

        function tick(){
            $('#ticker_01 li:first').slideUp( function () { $(this).appendTo($('#ticker_01')).slideDown(); });
        }
        setInterval(function(){ tick () }, 5000);


        function tick2(){
            $('#ticker_02 li:first').slideUp( function () { $(this).appendTo($('#ticker_02')).slideDown(); });
        }
        setInterval(function(){ tick2 () }, 2000);
       
	
        function tick22(){
            $('#ticker_022 li:first').slideUp( function () { $(this).appendTo($('#ticker_022')).slideDown(); });
        }
        setInterval(function(){ tick22 () }, 3000);


        function tick3(){
            $('#ticker_03 li:first').animate({'opacity':0}, 200, function () { $(this).appendTo($('#ticker_03')).css('opacity', 1); });
        }
        setInterval(function(){ tick3 () }, 4000);	

        function tick4(){
            $('#ticker_04 li:first').slideUp( function () { $(this).appendTo($('#ticker_04')).slideDown(); });
        }


        /**
         * USE TWITTER DATA
         */

        $.ajax ({
            url: '#',
            data: 'q=%23javascript',
            dataType: 'jsonp',
            timeout: 2000,
            success: function(data){
                if (!data.results){
                    return false;
                }

                for( var i in data.results){
                    var result = data.results[i];
                    var $res = $("<li />");
                    $res.append('<img src="' + result.profile_image_url + '" />');
                    $res.append(result.text);

                    console.log(data.results[i]);
                    $res.appendTo($('#ticker_02'));
                }
                setInterval(function(){ tick2 () }, 2000);	

                $('#example_2').show();

            }
        });


    </script> 

</div>



	</body>
</html>