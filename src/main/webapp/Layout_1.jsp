<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>The Professional Tutors:Private Tutor Kolkata,Online Tutors,Faculty Jobs,Coaching Center,Educational Resources,Software Training</title>
        <meta name="description" content="Private Tutor Kolkata,Home Tutor Kolkata, Tutor Jobs Kolkata, Software Training , Educational Resounces,Co-Curricular Activities, Academic Jobs, Faculty Jobs ,Java Training , J2EE Training ,Delhi, India,England,UK,Canada, Us, USA" />
        <meta name="keywords" content="Private Home Tutor Kolkata,Home Tutor Delhi,Home Tutor Mumbai,Home Tutors Bangalore,Home Tutor chennai" ></meta>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

        <script type="text/javascript" src="js/googleanalytics/analytics.js"></script>
        <script type="text/javascript" src="js/diablerightclick/rightclick.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>

        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="chrometheme/chromestyle.css" />
        <script type="text/javascript" src="js/jquery-1.3.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                //Execute the slideShow
                slideShow();
            });

            function slideShow() {

                //Set the opacity of all images to 0
                $('#gallery a').css({opacity: 0.0});

                //Get the first image and display it (set it to full opacity)
                $('#gallery a:first').css({opacity: 1.0});

                //Set the caption background to semi-transparent
                $('#gallery .caption').css({opacity: 0.7});

                //Resize the width of the caption according to the image width
                $('#gallery .caption').css({width: $('#gallery a').find('img').css('width')});

                //Get the caption of the first image from REL attribute and display it
                $('#gallery .content').html($('#gallery a:first').find('img').attr('rel'))
                .animate({opacity: 0.7}, 400);

                //Call the gallery function to run the slideshow, 6000 = change to next image after 6 seconds
                setInterval('gallery()',6000);

            }

            function gallery() {

                //if no IMGs have the show class, grab the first image
                var current = ($('#gallery a.show')?  $('#gallery a.show') : $('#gallery a:first'));

                //Get next image, if it reached the end of the slideshow, rotate it back to the first image
                var next = ((current.next().length) ? ((current.next().hasClass('caption'))? $('#gallery a:first') :current.next()) : $('#gallery a:first'));

                //Get next image caption
                var caption = next.find('img').attr('rel');

                //Set the fade in effect for the next image, show class has higher z-index
                next.css({opacity: 0.0})
                .addClass('show')
                .animate({opacity: 1.0}, 1000);

                //Hide the current image
                current.animate({opacity: 0.0}, 1000)
                .removeClass('show');

                //Set the opacity to 0 and height to 1px
                $('#gallery .caption').animate({opacity: 0.0}, { queue:false, duration:0 }).animate({height: '1px'}, { queue:true, duration:300 });

                //Animate the caption, opacity to 0.7 and heigth to 100px, a slide up effect
                $('#gallery .caption').animate({opacity: 0.7},100 ).animate({height: '100px'},500 );

                //Display the content
                $('#gallery .content').html(caption);


            }

        </script>
        <style type="text/css">
            body{
                font-family:arial
            }

            .clear {
                clear:both
            }

            #gallery {
                position:relative;
                /* height:360px */
                height:200px

            }
            #gallery a {
                float:left;
                position:absolute;
            }

            #gallery a img {
                border:none;
            }

            #gallery a.show {
                z-index:500
            }

            #gallery .caption {
                z-index:600;
                background-color:#000;
                color:#ffffff;
                height:100px;
                width:100%;
                position:absolute;
                bottom:0;
            }

            #gallery .caption .content {
                margin:5px
            }

            #gallery .caption .content h3 {
                margin:0;
                padding:0;
                color:#1DCCEF;
            }
        </style>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/easySlider1.5.js"></script>
        <script type="text/javascript" src="chromejs/chrome.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#slider").easySlider({
                    auto: true,
                    continuous: true
                });
            });
        </script>
    
        <style type="text/css">

            body {
                background:#fff url(images/bg_body.gif) repeat-x;
                font:80% Trebuchet MS, Arial, Helvetica, Sans-Serif;
                color:#333;
                line-height:180%;
                margin:0;
                padding:0;
                text-align:center;
            }
            h1{
                font-size:180%;
                font-weight:normal;
                margin:0;
                padding:20px;
            }
            h2{
                font-size:160%;
                font-weight:normal;
            }
            h3{
                font-size:140%;
                font-weight:normal;
            }
            img{border:none;}
            pre{
                display:block;
                font:12px "Courier New", Courier, monospace;
                padding:10px;
                border:1px solid #bae2f0;
                background:#e3f4f9;
                margin:.5em 0;
                width:674px;
            }

            /* image replacement */
            .graphic, #prevBtn, #nextBtn{
                margin:0;
                padding:0;
                display:block;
                overflow:hidden;
                text-indent:-8000px;
            }
            /* // image replacement */


            #container{
                margin:0 auto;
                position:relative;
                text-align:left;
                width:696px;
                background:#fff;
                margin-bottom:2em;
            }
            #header{
                height:144px;
                background:#5DC9E1;
                color:#fff;
            }
            #content{
                position:relative;
            }

            /* Easy Slider */

            #slider{ margin:0 auto;}
            #slider ul, #slider li{
                margin:0;
                padding:0;
                list-style:none;
            }
            #slider li{
                /*
			define width and height of list item (slide)
			entire slider area will adjust according to the parameters provided here
		*/
                width:960px;
                height:245px;
                overflow:hidden; margin:0 auto;
            }
            #prevBtn, #nextBtn{
                display:block;
                width:30px;
                height:77px;
                position:absolute;
                left:-30px;
                top:71px;
            }
            #nextBtn{
                left:696px;
            }
            #prevBtn a, #nextBtn a{
                display:block;
                width:30px;
                height:77px;
                background:url(images/btn_prev.gif) no-repeat 0 0;
            }
            #nextBtn a{
                background:url(images/btn_next.gif) no-repeat 0 0;
            }

            /* // Easy Slider */

        </style>

        <style type="text/css">

            /*Example CSS for the two demo scrollers*/

            #pscroller1{
                width:180px;
                height: 320px;
                /*height:100px; */
                border-left: 1px solid #999;
                padding:5px;
                background-color: white;
            }

            #pscroller2{
                width: 350px;
                height: 20px;
                border: 1px solid black;
                padding: 3px;
            }

            #pscroller2 a{
                text-decoration: none;
            }

            .someclass{
                /* class to apply to your scroller(s) if desired */
            }

        </style>

    
        <script type="text/javascript">

            /*Example message arrays for the two demo scrollers*/

            var pausecontent=new Array();

            <%
                        LovDataService lovDataServiceMenu = new LovDataService();
                        List<StudentRegistrationVO> listOfInstantTutorRequirement = null;
                        List<CareerCafeQuestionVO> careerCafeQuestionList = null;
                        HomePageServiceVO homePageServiceVO = null;
                        String countryCode = null;
                        String locationId = null;
                        if (null != session.getAttribute("listOfInstantTutorRequirement")) {
                            listOfInstantTutorRequirement = (List<StudentRegistrationVO>) session.getAttribute("listOfInstantTutorRequirement");
                        } else {

                            homePageServiceVO = lovDataServiceMenu.populateOnLoadServices(countryCode, locationId);
                            listOfInstantTutorRequirement = homePageServiceVO.getListOfInstantTutorRequirements();
                            session.setAttribute("listOfInstantTutorRequirement", listOfInstantTutorRequirement);
                            session.setAttribute("viewCounter", homePageServiceVO.getViewCounter());


                        }

                        if (null != session.getAttribute("careerCafeQuestionList")) {
                            careerCafeQuestionList = (List<CareerCafeQuestionVO>) session.getAttribute("careerCafeQuestionList");
                        } else {
                            homePageServiceVO = lovDataServiceMenu.populateOnLoadServices(countryCode, locationId);
                            careerCafeQuestionList = homePageServiceVO.getCareerCafeQuestionList();
                            session.setAttribute("careerCafeQuestionList", careerCafeQuestionList);
                        }
                        String[] strArray = new String[2];
                        List<String> careerCafeQAList = new ArrayList<String>();

                        for (CareerCafeQuestionVO careerCafeQuestionVO : careerCafeQuestionList) {
                            String str = "";
                            String questionId = careerCafeQuestionVO.getCareerQuestionId();
                            String question = careerCafeQuestionVO.getCareerQuestion();
                            System.out.println(" question -->" + question);
                            String questionPostedBy = careerCafeQuestionVO.getCareerQuestionPostedBy();
                            String questionPostedTime = careerCafeQuestionVO.getCareerQuestionPostedTime();

                            str = "<div style='width:190px; height:auto;margin-top:10px; float:left; font: bold 12px/18px Arial, Helvetica, sans-serif; color:#666; border-bottom:1px dashed #999;'><a href='searchStudent.do' style ='text-decoration:none;color:#800000'>" + questionPostedBy + " posted a question " + "</a><div style='float:left; width:190px; padding:0; margin:0; font: normal 12px/20px Arial, Helvetica, sans-serif;'>" + question + "</div> <div style='float:left; width:190px; padding:0; margin:0;color:#0066FF''>" + questionPostedTime + "<div style='height:10px; float:left; width:190px;'></div></div></div>";


                            careerCafeQAList.add(str);


                        }


                        int listSize = careerCafeQuestionList.size() / 3;

                        for (int i = 1; i <= listSize; i++) {
                            strArray[i - 1] = careerCafeQAList.get(i * 3 - 3) + careerCafeQAList.get(i * 3 - 2) + careerCafeQAList.get(i * 3 - 1);

                        }
                        for (int i = 0; i < strArray.length; i++) {
            %>
                pausecontent[<%=i%>] = "<%=strArray[i]%>";

            <% }%>
        </script>
        <script type="text/javascript">          
            function pausescroller(content, divId, divClass, delay){
                this.content=content //message array content
                this.tickerid=divId //ID of ticker div to display information
                this.delay=delay //Delay between msg change, in miliseconds.
                this.mouseoverBol=0 //Boolean to indicate whether mouse is currently over scroller (and pause it if it is)
                this.hiddendivpointer=1 //index of message array for hidden div
                document.write('<div id="'+divId+'" class="'+divClass+'" style="position: relative; overflow: hidden"><div class="innerDiv" style="position: absolute; width: 100%" id="'+divId+'1">'+content[0]+'</div><div class="innerDiv" style="position: absolute; width: 100%; visibility: hidden" id="'+divId+'2">'+content[1]+'</div></div>')
                var scrollerinstance=this
                if (window.addEventListener) //run onload in DOM2 browsers
                    window.addEventListener("load", function(){scrollerinstance.initialize()}, false)
                else if (window.attachEvent) //run onload in IE5.5+
                    window.attachEvent("onload", function(){scrollerinstance.initialize()})
                else if (document.getElementById) //if legacy DOM browsers, just start scroller after 0.5 sec
                    setTimeout(function(){scrollerinstance.initialize()}, 500)
            }

            // -------------------------------------------------------------------
            // initialize()- Initialize scroller method.
            // -Get div objects, set initial positions, start up down animation
            // -------------------------------------------------------------------

            pausescroller.prototype.initialize=function(){
                this.tickerdiv=document.getElementById(this.tickerid)
                this.visiblediv=document.getElementById(this.tickerid+"1")
                this.hiddendiv=document.getElementById(this.tickerid+"2")
                this.visibledivtop=parseInt(pausescroller.getCSSpadding(this.tickerdiv))
                //set width of inner DIVs to outer DIV's width minus padding (padding assumed to be top padding x 2)
                this.visiblediv.style.width=this.hiddendiv.style.width=this.tickerdiv.offsetWidth-(this.visibledivtop*2)+"px"
                this.getinline(this.visiblediv, this.hiddendiv)
                this.hiddendiv.style.visibility="visible"
                var scrollerinstance=this
                document.getElementById(this.tickerid).onmouseover=function(){scrollerinstance.mouseoverBol=1}
                document.getElementById(this.tickerid).onmouseout=function(){scrollerinstance.mouseoverBol=0}
                if (window.attachEvent) //Clean up loose references in IE
                    window.attachEvent("onunload", function(){scrollerinstance.tickerdiv.onmouseover=scrollerinstance.tickerdiv.onmouseout=null})
                setTimeout(function(){scrollerinstance.animateup()}, this.delay)
            }


            // -------------------------------------------------------------------
            // animateup()- Move the two inner divs of the scroller up and in sync
            // -------------------------------------------------------------------

            pausescroller.prototype.animateup=function(){
                var scrollerinstance=this
                if (parseInt(this.hiddendiv.style.top)>(this.visibledivtop+5)){
                    this.visiblediv.style.top=parseInt(this.visiblediv.style.top)-5+"px"
                    this.hiddendiv.style.top=parseInt(this.hiddendiv.style.top)-5+"px"
                    setTimeout(function(){scrollerinstance.animateup()}, 50)
                }
                else{
                    this.getinline(this.hiddendiv, this.visiblediv)
                    this.swapdivs()
                    setTimeout(function(){scrollerinstance.setmessage()}, this.delay)
                }
            }

            // -------------------------------------------------------------------
            // swapdivs()- Swap between which is the visible and which is the hidden div
            // -------------------------------------------------------------------

            pausescroller.prototype.swapdivs=function(){
                var tempcontainer=this.visiblediv
                this.visiblediv=this.hiddendiv
                this.hiddendiv=tempcontainer
            }

            pausescroller.prototype.getinline=function(div1, div2){
                div1.style.top=this.visibledivtop+"px"
                div2.style.top=Math.max(div1.parentNode.offsetHeight, div1.offsetHeight)+"px"
            }

            // -------------------------------------------------------------------
            // setmessage()- Populate the hidden div with the next message before it's visible
            // -------------------------------------------------------------------

            pausescroller.prototype.setmessage=function(){
                var scrollerinstance=this
                if (this.mouseoverBol==1) //if mouse is currently over scoller, do nothing (pause it)
                    setTimeout(function(){scrollerinstance.setmessage()}, 100)
                else{
                    var i=this.hiddendivpointer
                    var ceiling=this.content.length
                    this.hiddendivpointer=(i+1>ceiling-1)? 0 : i+1
                    this.hiddendiv.innerHTML=this.content[this.hiddendivpointer]
                    this.animateup()
                }
            }

            pausescroller.getCSSpadding=function(tickerobj){ //get CSS padding value, if any
                if (tickerobj.currentStyle)
                    return tickerobj.currentStyle["paddingTop"]
                else if (window.getComputedStyle) //if DOM2
                    return window.getComputedStyle(tickerobj, "").getPropertyValue("padding-top")
                else
                    return 0
            }

        </script>
        <link rel="stylesheet" type="text/css" href="css/inputhints.css" />
        <script type="text/javascript" src="js/inputhints.js"></script>
    </head>

    <body class="body">
        <div id="professionalMainBodyWrapper" style="border: 1px solid #469AF0; border-top:none; border-bottom:none; padding-top:1px;">
            <div id="mainroundedBodysectionWrapper">  
                <!--Navigation Section Start Here-->
                <tiles:insert attribute="header" /> 
                <!--Navigation Section End Here-->
                <div id="sitemainBodyWrapper">
                    <tiles:insert attribute="menu" />
                    <div id="mainBodyandRgtSectionWrapper">
                        <div class="welcomesectionWrapper">
                            <tiles:insert attribute="body" />
                        </div>
                        <div id="rightpanalWrapper">
                            <tiles:insert attribute="teaser"/> 
                            <div class="clear"></div>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <!--Body Section End Here-->
                </div>                  
            </div>            
            <div class="clear"></div>
        </div>
        <tiles:insert attribute="footer" />
    </body>
</html>
