<%-- <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> --%>

<div class="ourToutorWrapper">
    <div id="code">
        <div class="left_green_small"><h1>Upload Educational Certificates </h1></div>
    <div class="cpart">
        <div class="fieldNameWrapper" style="margin: 20px 100px;">
            <html:form action="tutorCertificate" enctype="multipart/form-data">
                <div class="labelName">
                     <% 
                        String tutorId=request.getParameter("tutorId");
                     %>
                     <%--<input name="tutorId" value="<%=request.getParameter("tutorId")%>">--%>
                     <html:hidden name="tutorCertificateRegistrationActionForm" property="tutorId" value="<%=tutorId%>"/>
                   
                </div>
                     <%--<div class="fieldNameWrapper">
                   
                        <%--<html:errors/>--%>
                        <% if (null != request.getAttribute("uploadfail")) {%>
                        <font color="red"  style="widows: 250px;"> <%=request.getAttribute("uploadfail")%></font>
                        <%}%>
                        <html:errors/>
                   
                        <%--<div class="clear"></div>
</div>--%>
                <div class="fieldNameWrapper">
                    <div class="labelName" style="margin-top:5px;">
                         Certificate Title:
                         <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField">                       
                        <html:text property="certificateTitle"  styleId="jobseekerNameOrEmailAddress" style="width:260px; margin:0px 5px 2px 10px;  background:none; border:none; font: normal 18px/28px 'Trebuchet MS'; color:#666;" />
                    </div>
                        <%--<div class="errorField"><html:errors property="jobSeekerLoginName"></html:errors></div>--%>
                    <div class="clear"></div>
                </div>
                        
                <div class="fieldNameWrapper" style="margin-top:20px;">
                    <div class="labelName"> 
                       Upload Certificate:
                     <bean:message key="MANDATORY_FIELD"/>
                    </div>
                    <div class="textField" style="background: none;">                       
                        <html:file property="uploadCertificate" styleId="jobseekerPassword" style="width:260px; height:35px; border:none; background:none; font: normal 13px/28px 'Trebuchet MS'; color:#666;"/>
                    </div>
                     <div class="star1">
                    (*.jpg,*.png,*.gif)
                </div>
                        <%-- <div class="errorField"><html:errors property="jobSeekerPassword"></html:errors></div>--%>
                    <div class="errorField">
                    </div>
                    <div class="clear"></div>
                </div>
               
                   <div style="margin: 10px 0px 0px 185px;" width: auto; line-height: 30px;">
                          <html:image     src="images/upload1.png" align="middle"  style=" margin-top:15px; margin-left:23px;" alt="Submit"/>
                      </div>
            </html:form>
        </div>
        <div class="clear"></div>
    </div>
<!--    <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
     <div class="clear"></div>
                </div>
</div>
