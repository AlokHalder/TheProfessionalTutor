<script>
function openWin()
{
window.open("http://basicchatapplication.pcsglobal.cloudbees.net/jsp/ChatWindow.jsp","_blank","toolbar=yes, scrollbars=yes, resizable=no, top=50, left=500, width=700px, height=600px");
}
</script>

<div id="ContentPlaceHolderDefault_chatwidget_pnlChatWidget"> 
      <script type="text/javascript">
    (function () {
        var head = document.getElementsByTagName("head").item(0);
        var script = document.createElement("script");
        //var src = (document.location.protocol == 'https:' ? 'js/feedback.js' : 'js/feedback.js');
		var src = 'js/feedback.js';
        script.setAttribute("type", "text/javascript"); script.setAttribute("src", src); script.setAttribute("async", true);
        var complete = false;

        script.onload = script.onreadystatechange = function () {
            if (!complete && (!this.readyState || this.readyState == 'loaded' || this.readyState == 'complete')) {
                complete = true;
                Formilla.guid = '9ee220a8-eea8-42ad-b974-06612a3f6510';
                Formilla.loadFormillaChatButton();
            }
        };

        head.appendChild(script);
    })();
    </script> 
    </div>
<div id="formilla-chat-button"  >
      <div onClick="Formilla.initFormillaChat(); " style="z-index:2147483645; position:fixed !important;position:absolute;right:20px;bottom:0px;cursor:pointer; background: url('../images/email-1.png') no-repeat scroll 10px 8px #191970; height: 30px; padding: 0 7px 0 9px; line-height: 17px; border-radius: 5px 5px 0 0; text-align: center;">
    <div style=" width:150px;color: #FFFFFF; font-weight: bold; background:url(images/chat-.png) 0px 7px no-repeat;  font-family: Arial; text-align:center; font-size: 14px; padding: 7px 0px 0px 0px;">Chat Now</div>
  </div>
    </div>
<div>
      <div id="divFormillaChat" class="formilla-drag" style="text-shadow: none; text-align: left; box-sizing: content-box; border-radius: 10px; border: 2px solid #191970; font-family: Arial; font-size: 12px; height: 137px; width: 260px; z-index: 2147483647; background-color:#fff; position: fixed ! important; bottom: 0px; right: 0px; color: rgb(0, 0, 0); padding: 8px 0px 10px 7px; line-height: 15px; letter-spacing: 0px; right:0; bottom: 0px; display: none;">
       <a id="formilla-chat-close-link" class="formilla-chat-close" style=" background:url(images/chat-close.png) center 7px no-repeat; position:absolute; right: 10px; top: 20px; cursor:pointer; height:19px; width:20px; z-index: 10000;" onClick="Formilla.hideFormillaChatWindow('divFormillaChat', '')"></a>
       
    <div class="formilla-drag" style=" background: none repeat scroll 0 0 #191970; overflow: hidden; width: 255px; border-radius: 5px; height: 40px; line-height: 20px;">
          <div  style="margin: 10px 5px 5px 10px; font-weight: bold; font-size: 15px; color: #FFFFFF;"> Welcome to LiveChat</div>
          
        </div>
        <div style="cursor: pointer;"  ><a style="margin-left: 1px;" onclick="openWin()"> <img src="images/whatsappImg.jpg" width="350" height="105"></a></div>
    <!--<div id="divFormillaChatMessages" style="display:none; cursor: auto; overflow: auto; height: 180px; width: 245px; margin-top:7px; padding-left: 3px; padding-right: 5px; color: #000000; font-size: 12px; font-family: Arial; line-height: 20px;"> </div>-->
   <!-- <div id="divFormillaEmailBox" style="height: 150px; margin-top: 10px;">
          <div style="padding: 0px 5px 12px 2px; color:#000000; font-size: 12px">   </div>
          <span id="spanFormillaEmailTextbox" onClick="Formilla.emailTextbox.focus();" style="position: absolute; color: rgb(143, 155, 179); font-size: 13px; padding: 9px 8px 8px 7px; cursor: text; display: block;"> </span> -->
          <!--<input id="txtFormillaEmailTextbox" style="box-sizing: content-box; display: block; width: 244px; height: 30px; margin: 0px 0px 13px; padding: 0px 3px 3px; line-height: 15px; border: 2px solid red; background: none repeat scroll 0% 0% rgb(255, 255, 255); border-radius: 0px; box-shadow: none; font-family: Tahoma; font-size: 13px; color: rgb(0, 0, 0);" type="text">--> 
          <!--<span id="spanFormillaEmailMessage" onClick="Formilla.emailMessage.focus();" style="position: absolute; color: rgb(143, 155, 179); font-size: 13px; padding: 9px 8px 8px 7px; cursor: text; display: block;">Enter your message here...</span>--> 
          <!--<textarea id="txtFormillaEmailMessage" rows="3" style="box-sizing: content-box; overflow: hidden; display: block; height: 130px; width: 243px; line-height: 17px; margin: 0px; padding: 6px 4px 5px 3px; border: 2px solid red; background: none repeat scroll 0% 0% rgb(255, 255, 255); border-radius: 0px; box-shadow: none; font-family: Tahoma; font-size: 13px; color: rgb(0, 0, 0);"></textarea>--> 
      <!--  </div>-->
   <!-- <div id="divFormillaResponseBox" style="height: 237px; margin-top: 15px; padding-left: 3px; display: none;"> <span id="spanFormillaResponseMessage" style="color: black; font-size:13px"></span> </div>
    <div style="-moz-box-sizing:content-box; box-sizing: content-box; cursor: auto; width: 244px; margin-top:8px;"> -->
          <!--<textarea id="txtFormillaMessage" rows="3" style="display:none; box-shadow:none; height: 45px; width:243px; padding: 3px; background-color: #FFFFFF; border: 2px solid #CCCCCC; color: #000000;"></textarea>--> 
          <!--<span id="spanFormillaChatEmailTextbox" onClick="Formilla.chatEmailTextbox.focus();" style="display:none; -moz-box-sizing:content-box; box-sizing: content-box; position:absolute; color:#8F9BB3; font-size: 13px; padding: 22px 8px 8px 5px; cursor:text;">Enter email and click Start...</span>--> 
          <!--<input id="txtFormillaChatEmailTextbox" style="display:none; -moz-box-sizing:content-box; box-sizing: content-box; width: 244px; height: 35px; padding: 0px 3px 3px; line-height: 15px; margin: 10px 0 0 0; border: 1px solid #CCCCCC; background: none; position: inherit; border-radius:0px; box-shadow: none; font-family: Tahoma; font-size: 14px; color:#000000;" type="text">--> 
          <!--<input id="hdnFormillaSessionId" value="" type="hidden">--> 
          <!--<input id="hdnLastChatMessageTimestamp" value="0" type="hidden">--> 
      <!--  </div>-->
    <!--<div style="position:absolute; top: 300px; left: 10px; width: 248px;">
          <div id="pnlPoweredBy"> <a href="#" target="_blank" style="float: left; color:#191970; padding-top: 13px; line-height: 15px; font-size: 11px;text-decoration: none; color: #000000;"> Powered by pcsglobal.in </a> </div>
          <div style="display:inline; float:right; padding-top: 5px;">
        <div id="formillaEmailButton" onClick="Formilla.ShowFormillaEmailBox()" style="display:none;cursor: pointer; border-radius: 4px 4px 4px 4px; text-align: center; height: 22px; background: none no-repeat scroll 0px 0px #25c2e6; padding: 0 8px;" onMouseOut="this.style.backgroundColor = '#25c2e6'" onMouseOver="this.style.backgroundColor = '#122647'">
              <div style="color: #FFFFFF; font-weight: bold; font-family: Tahoma; font-size: 12px; padding: 3px 0px 0px 0px; line-height: 15px;">Email Us</div>
            </div>-->
       <!-- <div id="formillaSendButton" onClick="Formilla.FormillaSendEmail()" style="cursor: pointer; border-radius: 4px; text-align: center; height: 22px; background: none no-repeat scroll 0px 0px rgb(37, 194, 230); padding: 0px 8px;" onMouseOut="this.style.backgroundColor = '#25c2e6'" onMouseOver="this.style.backgroundColor = '#122647'">-->
             <!-- <div style="color: #FFFFFF; font-weight: bold; font-family: Tahoma; font-size: 12px; padding: 3px 0px 0px 0px; line-height: 15px;">Send</div>
            </div>-->
        <!--<!--<div id="formillaStartChatButton" onClick="Formilla.FormillaStartChat()" style="display:none;cursor: pointer; border-radius: 4px 4px 4px 4px; text-align: center; height: 22px; background: none no-repeat scroll 0px 0px #25c2e6; padding: 0 8px;" onMouseOut="this.style.backgroundColor = '#25c2e6'" onMouseOver="this.style.backgroundColor = '#122647'">
              <div style="color: #FFFFFF; font-weight: bold; font-family: Tahoma; font-size: 12px; padding: 3px 0px 0px 0px; line-height: 15px;">Start</div>
            </div>
      </div>
        </div>-->
  </div>
    </div>
<!--<div aria-labelledby="at4-share-label" role="region" class="at4-share-outer addthis-smartlayers addthis-smartlayers-desktop">
      <div class="atss at-share-open-control-left ats-transparent at4-hide" id="at4-soc">
    <div title="Show" class="at4-arrow at-right"></div>
  </div>
    </div>
<div class="addthis-smartlayers addthis-smartlayers-mobile animated fadeIn at4-show at4-hide" id="at4m-mobile-container">
      <div class="at4m-menu ats-light" id="at4m-menu">
    <div class="at4m-menu-inner">
          <div class="at4m-menu-header"> </div>
          <div id="at4m-menu-body"></div>
          <div class="at4m-menu-footer"></div>-->
        <!--</div>-->
  <!--</div>-->
  <!--  </div>-->




<script src="js/core130.js" type="text/javascript"></script>