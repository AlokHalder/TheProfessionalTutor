<%-- <%@ taglib uri="/WEB-INF/struts-html.tld" prefix ="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix ="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld"  prefix="logic"%> --%>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" >
    function validateTutorLoginForm(){
        var returnFlag = false;
        var tutorNameOrEmailAddress = document.tutorLoginActionForm.tutorNameOrEmailAddress.value;
        var tutorPassword = document.tutorLoginActionForm.tutorPassword.value;

        if(tutorNameOrEmailAddress =="" &&  tutorPassword ==""){
            document.getElementById('tutorNameOrEmailAddressId').innerHTML = "<font color='red'><UL><li>Tutor Name Or Email Address can not be blank !! </li></UL></font>";
            document.getElementById('tutorPasswordId').innerHTML = "<font color='red'><UL><li>Tutor Password can not be blank !! </li></UL></font>";
            document.getElementById('errorDiv').style.display = "none";
            returnFlag = false;
        }else if(tutorNameOrEmailAddress !="" &&  tutorPassword ==""){
            document.getElementById('tutorNameOrEmailAddressId').innerHTML = "";
            document.getElementById('tutorPasswordId').innerHTML = "<font color='red'><UL><li>Tutor Password can not be blank !! </li></UL></font>";
            document.getElementById('errorDiv').style.display = "none";
            returnFlag = false;
        }else if(tutorNameOrEmailAddress =="" &&  tutorPassword !=""){
            document.getElementById('tutorNameOrEmailAddressId').innerHTML = "<font color='red'><UL><li>Tutor Name Or Email Address can not be blank !! </li></UL></font>";
            document.getElementById('tutorPasswordId').innerHTML = "";
            document.getElementById('errorDiv').style.display = "none";
            returnFlag = false;
        }else if(tutorNameOrEmailAddress !="" && tutorPassword !=""){
            document.getElementById('errorDiv').style.display = "block";
            returnFlag = form.submit();
        }      
        return  returnFlag ;
    }
</script>
    <div class="ourToutorWrapper">
        <div id="code">
        <div class="left_green_small"> <h1>Tutor login here</h1></div>
        <div class="cpart">
            <div class="loginWrapper">
                <%--<div align="center"> <font style="font-family: arial ,helvetica, verdana;margin-bottom: 15px;font-size: 15px;font-weight: bold;padding-left: 175px;" >Login to view and edit your profile.</font>  </div>
                <div><p>&nbsp;</p></div>--%>
               <html:form action="tutorLogin" onsubmit="return validateTutorLoginActionForm(this);" >
                   <div class="fieldNameWrapper" style="margin-top: 20px">
                    <html:errors/>
                    <p id='tutorNameOrEmailAddressId'></p>
                    <p id='tutorPasswordId'></p>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper">
                   
                    <div class="labelName">
                        <bean:message key="USERNAME_OR_EMAIL"/>
                         <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField">                       
                        <html:text property="tutorNameOrEmailAddress" styleId="tutorNameOrEmailAddressId" style="width:260px; margin:5px 5px 2px 10px; height:28px; border:none; background:none; font: normal 18px/28px 'Trebuchet MS'; color:#666;" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="labelName"> 
                     <bean:message key="USER_LOGIN_PASSWORD"/>
                     <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField">                       
                        <html:password property="tutorPassword" styleId="tutorPasswordId" style="width:260px; margin:5px 5px 2px 10px; height:28px; border:none; background:none; font: normal 18px/28px 'Trebuchet MS'; color:#666;"/>
                    </div>
                    <div class="clear"></div>
                </div>
                <%
                            String studentId = request.getParameter("studentId");
                            String tutorId = request.getParameter("tutorId");
                %>
                <html:hidden property="studentId" value="<%=studentId%>" />
                <html:hidden property="tutorId" value="<%=tutorId%>" />

                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="errorField1">
                        <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                            <html:image   src="images/signin_btn.png" align="middle" alt="Submit"/>
                        </div>
                        <!--                      <div  style="float: left;margin-left: 10px;">
                                                  <input type="reset" value="" alt="" style="background:url(<%=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
                                           </div>-->
                        <div style="float: left;margin-left: 10px;">
                            <a href="tutorForgotPass.do"><FONT COLOR="red">Forgot Password?</FONT></a>
                        </div>
                    </div>
                     <div style="height: 50px;"></div>
                        <div align="right" style="width: 455px;">
                            <font size="3" color="#007744">Don't have an account ? <a href="Link.do?method=tutorProfileRegistration">Sign up now!</a></font>
                        </div>
                    <div class="clear"></div>
                </div>
                
               </html:form>
             
            </div> 
               <div class="clear"></div>
        </div>
<!--         <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
         <div class="clear"></div>
        </div>
    </div>







