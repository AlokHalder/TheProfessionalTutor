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
    <div class="ourToutorWrapper">
        <div class="tutorHeader">Be a memeber of The Professional Tututors family</div>
        <div class="tutorBoxBody">
            <div class="topParagraph">
                Welcome to be a member of The Professional Tutors family ! We are sure that there will be a lot of mutual value adds with the beginning of your association with The Professional Tutors !
            </div>
            <div class="clear"></div>
            <div class="loginWrapper" style=" padding:10px 0 10px 0; border:1px solid #DEF3FB; height:auto;">
                <html:form action="confirmTutorMemberShip" >
                    <div class="fieldNameFormembership"><strong><p>MEMBERSHIP OPTION</p>
                        </strong>
                        <div class="clear"></div>
                    </div>

                    <div class="fieldNameWrapper" style="margin-top:10px; margin-left:0">
                        <div class="clear">
                            <div class="fieldNameWrapper" style="margin-top:10px;">
                                <%
                                            String tutorId = (String) request.getAttribute("tutorId");
                                %>
                                <html:hidden property="userId" value="<%=tutorId%>"/>
                                <div class="freeMembershipRedio" style="margin-left:5px;">
                                    <label>
                                        <html:radio property="membershipCategory" value="Free Membership" onclick="javascript:return showHideFreeMemberShip()" />
                                    </label>
                                </div>
                                <div class="labelName" style="text-align:left; margin-top: 10px;">Free Membership </div>
                                <div class="freeMembershipRedio">
                                    <label>
                                        <%--   <input name="radiobutton" type="radio" value="radiobutton" /> --%>
                                        <html:radio property="membershipCategory" value="Paid Membership" onclick="javascript:return showHidePaidMemberShip()"/>
                                    </label>
                                </div>
                                <div class="labelName" style="text-align:left; margin-top: 10px;">Paid Membership </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                    </div>
                    <div class="fieldNameWrapper" style="margin-top:10px;" id="freeMembershipBenefitsDiv">
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal">Benefits Of Free Membership</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" />
                        </div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View student profile</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" /></div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View tutor requirement details of student</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" /></div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View student educational background</div>
                    </div>
                    <div class="fieldNameWrapper" style="margin-top:10px;" id="paidMembershipBenefitsDiv">
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px; color: teal">Benefits Of Paid Membership</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" />
                        </div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View student full profile</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" />
                        </div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View student contact number,email-id</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" /></div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View tutor requirement details of student</div>
                        <div class="clear"></div>
                        <div class="freeMembershipRedio" style="margin:5px;">
                            <img src="images/correct.gif" alt="" width="13" height="14" /></div>
                        <div class="labelName" style="text-align:left; line-height:20px; width: 280px;">View student educational background</div>
                        <div class="clear"></div>
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
                        <div class="clear"></div>
                    </div>
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
                            <%-- <input type="submit" name="method" value="cancel" src="images/cancel_button.jpg" alt="Cancel" style="width:84px; height: 33px;" onclick="javascript:submit()"> --%>
                            <html:reset/>
                        </div>
                        <div class="labelName" style="text-align:left; line-height:25px;">                       

                            <%--   <html:img  name="membershipUpgradationActionForm" property="method" src="images/confirm_button.jpg" alt="Confirm" style="width: 90px;height: 33px;"/> --%>
                            <input type="submit" name="method" src="./images/confirm_button.jpg" alt="Confirm" style="width: 90px;height: 33px;" onclick="javascript:return checkValidation()">
                        </div>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                </html:form>
            </div>


        </div>
        <div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>
    </div>
</div>