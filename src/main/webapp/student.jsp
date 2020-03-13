<%-- <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %> --%>

<div class="ourToutorWrapper">
    <div id="code">
        <div class="left_green_small"><h1>Student login here </h1></div>

    <html:form action="studentLogin">
        <div class="cpart"> <!-- Tutor Box Body Begins -->
            <%--<div align="center">Login to view and edit your profile.</div>--%>
            <div class="loginWrapper" >             
                <div class="fieldNameWrapper" style="margin-left: 190px;" >
                    <html:errors/>
                    <p id='studentNameOrEmailAddressId'></p>
                    <p id='studentPasswordId'></p>
                    <div class="clear"></div>
                </div>

                <div class="fieldNameWrapper" style="margin: 15px 20px;">
                    <div class="labelName" style="margin-top: 10px;">
                        <bean:message key="USERNAME_OR_EMAIL"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField">
                        <html:text property="studentNameOrEmailAddress" styleId="studentNameOrEmailAddressId" style="width:260px; margin:5px 5px 2px 10px; height:28px; border:none; background:none; font: normal 18px/28px 'Trebuchet MS'; color:#666;" />
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="labelName" style="margin-top: 10px;">
                        <bean:message key="STUDENT_PASSWORD"/>
                        <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField">
                        <html:password property="studentPassword" styleId="studentPasswordId" style="width:260px; margin:5px 5px 2px 10px; height:28px; border:none; background:none; font: normal 18px/28px 'Trebuchet MS'; color:#666;"/>
                    </div>
                    <div class="clear"></div>
                </div>

                <%
                            String tutorId = request.getParameter("tutorId");
                            String studentId = request.getParameter("studentId");
                %>
                <html:hidden property="tutorId" value="<%=tutorId%>"/>
                <html:hidden property="studentId" value="<%=studentId%>"/>
                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="errorField1">
                        <div style="float: left; width: auto;margin-right: 10px; line-height: 30px;">
                            <html:image   src="images/signin_btn.png" align="middle" alt="Submit"/>
                        </div>
                        <!--                      <div  style="float: left;margin-left: 10px;">
                                                  <input type="reset" value="" alt="" style="background:url(<%=request.getContextPath()%>/images/reset.gif) 0 0 no-repeat;width: 80px; height: 33px;text-decoration: none;border: none;"/>
                                           </div>-->
                        <div style="float: left;margin-left: 10px;">
                            <a href="forgotPass.do"><FONT COLOR="red">Forgot Password?</FONT></a>
                        </div>
                    </div>
                    <div style="height: 50px;"></div>
                        <div align="right" style="width: 455px;">
                            <font size="3" color="#007744">Don't have an account ? <a href="Link.do?method=studentRegistration">Sign up now!</a></font>
                        </div>
                    <div class="clear"></div>
                </div>
            </html:form>
        </div>
        <div class="clear"></div>    
    </div>
    <div class="clear"></div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
    </div>
</div>
