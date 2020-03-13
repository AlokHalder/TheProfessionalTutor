<%-- <%@taglib  prefix="html" uri="/WEB-INF/struts-html.tld" %>
<%@taglib prefix="bean" uri="/WEB-INF/struts-bean.tld" %> --%>

<script type="text/javascript" >
    function showHideFreeMemberShip(){
        document.getElementById('freeMembershipBenefitsDiv').style.display = 'block';
        document.getElementById('paidMembershipBenefitsDiv').style.display = 'none';
        document.getElementById('defaultBenefitsDiv').style.display = 'none';
    }

    function showHidePaidMemberShip(){
        document.getElementById('freeMembershipBenefitsDiv').style.display = 'none';
        document.getElementById('paidMembershipBenefitsDiv').style.display = 'block';
        document.getElementById('defaultBenefitsDiv').style.display = 'none';
    }

    function checkValidation(){
        var flag = false;
        // set var radio_choice to false
        var membership_radio_choice = false;
        var membership_duration_radio_choice = false;
        var counter;
        // Loop from zero to the one minus the number of radio button selections
        for (counter = 0; counter < document.membershipUpgradationActionForm.membershipCategory.length; counter++)
        {
            // If a radio button has been selected it will return true
            // (If not it will return false)
            if (document.membershipUpgradationActionForm.membershipCategory[counter].checked){
                membership_radio_choice = true;
                break;
            }
        }

        if(membership_radio_choice){

            var mebershipCategory = document.membershipUpgradationActionForm.membershipCategory[counter].value;

            if("Paid Membership"==mebershipCategory){

                for(var i=0;i<document.membershipUpgradationActionForm.duration.length; i++){

                    if(document.membershipUpgradationActionForm.duration[i].checked){
                        membership_duration_radio_choice = true;
                    }
                }

                if(!membership_duration_radio_choice){
                    // If there were no selections made display an alert box
                    alert("Please select a membership duration !")
                    return (false);
                }
            }
        }


        if (!membership_radio_choice)
        {
            // If there were no selections made display an alert box
            alert("Please select a membership!")
            return (false);
        }

        if(document.membershipUpgradationActionForm.termsAndConditions.checked == false){
            alert("Please select Terms and conditions!");
            return (false);
        }

        return true;
    }

</script>
<html:base/>
<div class="welcomesectionWrapper">
    <div id="code">
    <div class="ourToutorWrapper">
        <div class="left_green_small"><h1>Be a memeber of The Professional Tutors family</h1></div>
        <div class="cpart">
            <div class="topParagraph">
                Welcome to be a member of The Professional Tutors family ! We are sure that there will be a lot of mutual value adds with the beginning of your association with The Professional Tutors !
            </div>
            <div class="clear"></div>
        </div>
            <div class="cpart">
            <div class="loginWrapper" style=" padding:10px 0 10px 0;  height:auto;">
                <html:form action="confirmStudentMembership" >
                    <div class="fieldNameFormembership"><strong><p>MEMBERSHIP OPTION</p>
                        </strong>
                        <div class="clear"></div>
                    </div>

                    <div class="fieldNameWrapper" style="margin-top:10px; margin-left:0">
                        <div class="clear">
                            <div class="fieldNameWrapper" style="margin-top:10px;">
                                <%
                                            String studentId = (String) request.getAttribute("studentIdValue");
                                            if (null != studentId) {
                                               
                                            
                                %>
                               
                                <font color="#800000" style="font-weight: bold"> Student Id :</font> <%=studentId%> <br/>
                                 <%} else{%>
                                     Your Registration failed.
                                 <%}%>
                               <div class="labelName" style="width:300px;text-align:left; margin-top: 10px;">Student Membership is completely free !! </div>
                               <%--
                                <div class="freeMembershipRedio" style="margin-left:5px;">
                                   
                                     <label>
                                        <html:radio property="membershipCategory" value="Free Membership" onclick="javascript:return showHideFreeMemberShip()"/>
                                    </label>
                                   
                                </div>
                                <div class="labelName" style="text-align:left; margin-top: 10px;">Student Membership is completely free !! </div>
                              <div class="freeMembershipRedio">
                                    <label>
                                      
                                        <html:radio property="membershipCategory" value="Paid Membership" onclick="javascript:return showHidePaidMemberShip()"/>
                                    </label>
                                </div>
                                <div class="labelName" style="text-align:left; margin-top: 10px;">Paid Membership </div>
                                <div class="clear"></div>
                             --%>
                            </div>
                        </div>
                    </div>
                    <%--
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal">
                             <a href="#" onclick="window.open('http://localhost:8080/TheProfessionalTutors/success.jsp', 'Choose Membership Help', 'Help Features')"> Help to choose membership </a>
                            <a href="chooseMembershipHelp.do?studentId=<%=studentId%>"> Help to choose membership </a>
                        </div>
                        <div class="clear"></div>
                    </div>
                    --%>
                    <%--
                    <div class="fieldNameWrapper" style="margin-top:10px;" id="paidMembershipBenefitsDiv">
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal">Service Charge Of Paid Membership</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="duration" value="3"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Duration 3 Months.   Subscription Rate : 300.00 INR </div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="duration" value="6"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Duration 6 Months.   Subscription Rate : 600.00 INR </div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="duration" value="9"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Duration 9 Months.   Subscription Rate : 900.00 INR </div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="duration" value="12"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Duration 12 Months.  Subscription Rate : 1000.00 INR </div>

                         <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal"><br/></div>
                        <div class="clear"></div>
                         <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal">Select Payment Mode of Paid Membership</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="paymentMode" value="cash"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Payment By Cash (For Kolkata location only)</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="paymentMode" value="cheque"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Payment By Cheque</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="paymentMode" value="account transfer"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Payment By Bank Transfer</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <html:radio property="paymentMode" value="payment getway"/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px; width: 350px;">Payment By Debit/Credit card using payment gateway <font color="grey" style="font-size: 10px"> (payment getway mode will be activated very soon)</font></div>
                        <div class="clear"></div>
                       
                    </div>
                     --%>
                    <div class="fieldNameWrapper" style="margin-top:10px;">
                        <div class="freeMembershipRedio" style="margin-left:5px;">
                            <label>
                                <html:checkbox property="termsAndConditions" styleId="termsAndConditionsId" value="on"/>
                            </label>
                        </div>
                        <div class="labelName" style="text-align:left; width:auto; margin-top: 10px;">I agree with the terms and conditions.  </div>
                        <div class="clear"></div>
                    </div>
                    <div class="fieldNameWrapper" style="margin-top:10px; margin-left:0">
                        <div class="labelName" style="text-align:left; margin-left:20px; line-height:25px; width:80px;">
                            <%--   <html:img name="membershipUpgradationActionForm" property="method"  src="images/cancel_button.jpg" alt="Cancel" style="width:84px; height: 33px;" /> --%>
                            <%--   <input type="submit" name="method" value="cancel" src="images/cancel_button.jpg" alt="Cancel" style="width:84px; height: 33px;" onclick="javascript:submit()"> --%>
                            <html:reset/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px;">

                            <%--   <html:img  name="membershipUpgradationActionForm" property="method" src="images/confirm_button.jpg" alt="Confirm" style="width: 90px;height: 33px;"/> --%>
                            <%-- <input type="submit" name="method"  src="./images/confirm_button.jpg" alt="Confirm" style="width: 90px;height: 33px;" onclick="javascript:return checkValidation()"> --%>
                             <html:image   src="images/confirm_button.jpg" align="middle" alt="Submit" onclick="javascript:return checkValidation()"/>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </html:form>
            </div>

<div class="clear"></div>
        </div>
<!--        <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
    </div>
        <div class="clear"></div>
</div>
     <div class="clear"></div>
                    </div>