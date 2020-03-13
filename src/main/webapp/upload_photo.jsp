<%-- <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %> --%>
<style>
    #show
    {
        width:100px;
        height:100px;
        display:none;
        margin-left:178px;
    }
    .star1{ width: 255px; margin-top: 5px; margin-left: 179px; color:red; padding-bottom: 5px;}
</style>
<script type="text/javascript" src="jquery-1.11.0.min.js"></script>
<script src="jQuery.js" type="text/javascript"></script>
<script type="text/javascript">
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function(e) {
                $('#show').attr('src', e.target.result);
                $('#show').css("display","block");
            }

            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
<div class="ourToutorWrapper">
    <div id="code">
        <div class="left_green_small"><h1>Upload Your Photo</h1> </div>
    <div class="cpart">
        <div class="fieldNameWrapper" style="margin:20px 133px;">
            <html:form action="studentphotoupload" enctype="multipart/form-data">
                <html:errors/>
                <% String student=(String)request.getParameter("studentId"); %>
                 <% if (null != request.getAttribute("uploadfail")) {%>
                        <font color="red"  style="widows: 250px;"> <%=request.getAttribute("uploadfail")%></font>
                        <%}%>
                <div class="labelName">
                    <html:hidden name="studentphotoRegistrationActionForm" property="studentId" value="<%= student%>"/>
                    Upload Photo:
                </div>
                <div>

                    <html:file property="uploadImage" onchange="readURL(this);"/>
                    <div class="star1">
                        (Supported file format *.jpg,*.png,*.gif)
                    </div>
                    <img id="show"/>  
                </div>

                <div style="margin: 10px 0px 0px 176px;" width: auto;margin-right: 10px; line-height: 30px;">
                     <html:image src="images/photo_up.png" align="middle" alt="Submit"/>
            </div>
        </html:form>
    </div>
        <div class="clear"></div>
</div>
<!--<div class="tutorBoxBottom"><img src="images/welcome_bottom.gif" alt="" /></div>-->
<div class="clear"></div>
    </div>
</div>
