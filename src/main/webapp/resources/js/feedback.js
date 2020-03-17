//Formilla class with encapsulated vars and methods to avoid conflicts with other javascript functionality on a given site
Formilla = {
    formillaDomain: '',
    customerSiteId: 0,
    guid: '',
    customerName: '',
    customerPhone: '',
    customerEmail: '',
    customField1: '',
    customField2: '',
    customField3: '',
    isChatShown: '',
    chatMessagesContainer: '',
    lastChatMessageTimestamp: '',
    chatTextbox: '',
    spanChatEmailTextbox: '',
    chatEmailTextbox: '',
    chatEmailTextboxValidator: '',
    startChat: 0,
    emailBoxContainer: '',
    spanEmailTextbox: '',
    emailTextbox: '',
    emailTextboxValidator: '',
    spanEmailMessage: '',
    emailMessage: '',
    emailMessageValidator: '',
    emailUsButton: '',
    sendButton: '',
    startChatButton: '',
    responseBoxContainer: '',
    spanFormillaResponseMessage: '',
    userChatMessageBackgroundColor: '',
    userChatMessageTextColor: '',

    _startX: 0, // mouse starting positions 
    _startY: 0,
    _offsetX: 0, // current element offset 
    _offsetY: 0,
    _dragElement: '', // needs to be passed from OnMouseDown to OnMouseMove 
    _oldZIndex: 2147483646, // we temporarily increase the z-index during drag 
    _debug: document.getElementById('_debug'),

    contentElement: '',
    contentWidth: 0,
    contentHeight: 0,
    sctop: 0,
    scleft: 0,
    winwidth: 0,
    winheight: 0,
    buttonLocation: 0,

    pollTimer: '',
    proactiveTimer: '',

    loadFormillaChatButton: function () {
        Formilla.formillaDomain = 'livechat.';

        //var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
        //url = url + "&f=loadFormillaChatButton&Guid=" + Formilla.guid + "&ChatSessionGuid=" + Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid) + "&UserEmail=" + Formilla.customerEmail + "&callback=renderFormillaChatButton";
        Formilla.dynamicJSONTag(url);
    },

    dynamicJSONTag: function (url) {
        var head = document.getElementsByTagName("head").item(0);
        var script = document.createElement("script");
        script.setAttribute("type", "text/javascript");
        script.setAttribute("src", url);
        head.appendChild(script);
        setTimeout(function () {
            head.removeChild(script);
        }, 1000); //We wait 1 sec because IE removes the newly appended script before it has a chance to fully execute
    },

    renderFormillaChatButton: function (JSONData) {
        if (JSONData != null) {
            //Get a reference to the head tag and inject formilla styles
            var head = document.getElementsByTagName("head").item(0);
            var style = document.createElement("style");
            style.type = 'text/css';

            if (style.styleSheet) {
                style.styleSheet.cssText = JSONData.LiveChatCSS;
            } else {
                style.appendChild(document.createTextNode(JSONData.LiveChatCSS));
            }

            head.appendChild(style);

            //Get a reference to the body tag and append a new div container for the chat popup to sit in
            var body = document.getElementsByTagName("body").item(0);
            var divFormillaChatButton = document.createElement("div");
            var divFormillaChatContainer = document.createElement("div");

            divFormillaChatButton.setAttribute("id", "formilla-chat-button");
            divFormillaChatButton.innerHTML = JSONData.FormillaChatButton;
            divFormillaChatContainer.innerHTML = JSONData.ChatPopup;

            body.appendChild(divFormillaChatButton);
            body.appendChild(divFormillaChatContainer);

            //This starts the timer to auto display the chat
			
            if (JSONData.IsAutoDisplayEnabled == 'True')
                Formilla.AutoPopUpFormillaChat(JSONData.AutoDisplayTimer);

            //If there are no messages, the jsonp call will tell us to delete the cookie since it's probably stale.
            if (JSONData.DeleteChatCookie == 'True') {
                document.cookie = 'formillaChatSession' + Formilla.guid + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/';
                document.getElementById('hdnFormillaSessionId').value = "";
            }

            //We set this var to true because it's used in other areas
            if (JSONData.ShowEmailForm == 'True')
                Formilla.isChatShown = false;
            else
                Formilla.isChatShown = true;

            Formilla.buttonLocation = JSONData.ButtonLocation;
            Formilla.userChatMessageBackgroundColor = JSONData.UserChatMessageBackgroundColor;
            Formilla.userChatMessageTextColor = JSONData.UserChatMessageTextColor;

            //This checks to see if the user already has a chat session established and calls the above function as if it was clicked by the user
            if (document.getElementById('hdnFormillaSessionId').value.length > 0 && JSONData.SupressChatAutoShow != 'True') {
                Formilla.initFormillaChat();

                //If the user is in the queue, chat textbox doesn't need to display
                //We have to place this here so we have a reference to the chat textbox after the initFormillaChat function runs above
                if (JSONData.IsStatusDisplay == 'True') {
                    Formilla.chatTextbox.style.display = "none";
                }
            }

            if (document.getElementById('formilla-attn-grabber-ctr') != null && Formilla.getFormillaCookie("AttnGrabberClosed" + Formilla.guid) != "yes") {
                document.getElementById('formilla-attn-grabber-ctr').style.display = 'block';
            }

            if (document.getElementById('formilla-off-attn-grabber-ctr') != null && Formilla.getFormillaCookie("OfflineAttnGrabberClosed" + Formilla.guid) != "yes") {
                document.getElementById('formilla-off-attn-grabber-ctr').style.display = 'block';
            }
        }
    },

    resetFormillaEmailFields: function () {
        //Reset fields
        Formilla.chatTextbox.value = '';
        Formilla.emailTextbox.value = '';
        Formilla.emailMessage.value = '';
        Formilla.spanEmailTextbox.style.display = 'block';
        Formilla.spanEmailMessage.style.display = 'block';
        Formilla.responseBoxContainer.style.display = 'none';
        Formilla.emailTextbox.style.background = '#ffffff';
        Formilla.emailMessage.style.background = '#ffffff';
    },

    ShowFormillaChatBox: function () {
        Formilla.isChatShown = true;
        Formilla.chatMessagesContainer.style.display = 'block';
        Formilla.chatTextbox.style.display = 'none';
        Formilla.emailBoxContainer.style.display = 'none';
        Formilla.responseBoxContainer.style.display = 'none';
        Formilla.sendButton.style.display = 'none';
        Formilla.chatEmailTextbox.style.display = 'inline-block';

        if (Formilla.chatEmailTextbox.value.trim() == '')
            Formilla.spanChatEmailTextbox.style.display = 'block';
        else
            Formilla.spanChatEmailTextbox.style.display = 'none';

        Formilla.startChatButton.style.display = 'block';
    },

    ShowFormillaEmailBox: function () {
        Formilla.isChatShown = false;
        Formilla.chatMessagesContainer.style.display = 'none';
        Formilla.chatTextbox.style.display = 'none';
        Formilla.emailUsButton.style.display = 'none';
        Formilla.chatEmailTextbox.style.display = 'none';
        Formilla.spanChatEmailTextbox.style.display = 'none';
        Formilla.startChatButton.style.display = 'none';
        Formilla.emailBoxContainer.style.display = '';
        Formilla.sendButton.style.display = '';

        //stop the proactive timer if it's running since we don't want to start a chat while the user is about to submit an email form
        if (Formilla.proactiveTimer) {
            window.clearInterval(Formilla.proactiveTimer);
        }
    },

    FormillaValidateEmailFields: function () {
        var bValidEmailAddress = Formilla.FormillaValidateEmailAddress(true);
        var bValidEmailMessage = Formilla.FormillaValidateEmailMessage(true);

        if (bValidEmailAddress && bValidEmailMessage)
            return true
        else
            return false;
    },

    FormillaValidateEmailAddress: function (bShowError) {
        if (Formilla.FormillaIsValidEmail(Formilla.emailTextbox.value)) {
            Formilla.emailTextbox.style.border = "2px solid green";
            Formilla.emailTextboxValidator = true;
            return true;
        }
        else {
            if (Formilla.emailTextboxValidator || bShowError) {
                Formilla.emailTextbox.style.border = "2px solid red";
            }
            return false;
        }
    },

    FormillaValidateEmailMessage: function (bShowError) {
        if (!(Formilla.emailMessage.value.trim() == '' || Formilla.emailMessage.value == null)) {
            Formilla.emailMessage.style.border = "2px solid green";
            Formilla.emailMessageValidator = true;
            return true;
        }
        else {
            if (Formilla.emailMessageValidator || bShowError) {
                Formilla.emailMessage.style.border = "2px solid red";
                //Formilla.emailMessage.style.background = "#ffffff url('" + (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/images/form/error.png') no-repeat 230px 5px";
            }
            return false;
        }
    },

    FormillaValidateChatEmailAddress: function (bShowError) {
        if (Formilla.FormillaIsValidEmail(Formilla.chatEmailTextbox.value)) {
            Formilla.chatEmailTextbox.style.border = "1px solid green";
            Formilla.chatEmailTextboxValidator = true;
            return true;
        }
        else {
            if (Formilla.chatEmailTextboxValidator || bShowError) {
                Formilla.chatEmailTextbox.style.border = "1px solid red";
            }
            return false;
        }
    },

    FormillaSendEmail: function () {
        if (Formilla.FormillaValidateEmailFields()) {

            Formilla.sendButton.style.display = 'none';

            Formilla.FormillaShowResponseBoxContainer("<br /><br /><br /><br /><div style='text-align:center'><img src='" + (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "#' /></div>");

            var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
            url = url + "&f=sendFormillaEmail&Guid=" + Formilla.guid + "&txtFormillaEmail=" + encodeURIComponent(Formilla.emailTextbox.value) + "&txtFormillaEmailMessage=" + encodeURIComponent(Formilla.HTMLEncode(Formilla.emailMessage.value)) + "&pageURL=" + escape(document.location) + "&customerName=" + encodeURIComponent(Formilla.customerName) + "&customerPhone=" + encodeURIComponent(Formilla.customerPhone) + "&screenWidth=" + screen.width + "&screenHeight=" + screen.height + "&CustomField1=" + encodeURIComponent(Formilla.customField1) + "&CustomField2=" + encodeURIComponent(Formilla.customField2) + "&CustomField3=" + encodeURIComponent(Formilla.customField3) + "&callback=FormillaSendEmailCallback";
            Formilla.dynamicJSONTag(url);
        }
    },

    FormillaShowResponseBoxContainer: function (message) {
        Formilla.chatMessagesContainer.style.display = 'none';
        Formilla.emailBoxContainer.style.display = 'none';
        Formilla.responseBoxContainer.style.display = '';

        Formilla.spanFormillaResponseMessage.innerHTML = message;
    },

    FormillaSendEmailCallback: function (JSONData) {
        if (JSONData != null) {
            Formilla.FormillaShowResponseBoxContainer(JSONData.message);
        }
    },

    endFormillaChatSession: function (sessionid) {
        var hdnFormillaSessionId = document.getElementById('hdnFormillaSessionId').value;

        var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
        url = url + "&f=endFormillaChatSession" + "&hdnFormillaSessionId=" + hdnFormillaSessionId;
        Formilla.dynamicJSONTag(url);
    },

    hideFormillaChatWindow: function (obj, confirmText) {
        var sessionId = Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid);

        if (sessionId != null) {
            if (confirm(confirmText)) {
                document.getElementById(obj).style.display = 'none';

                //make a call to formilla to end the chat session
                Formilla.endFormillaChatSession(sessionId);

                //delete cookie and set hdn var to empty
                document.cookie = 'formillaChatSession' + Formilla.guid + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/';
                document.getElementById('hdnFormillaSessionId').value = "";

                //stop the poll timer that checks for new messages
                if (Formilla.pollTimer) {
                    window.clearInterval(Formilla.pollTimer);
                }

                //display to the user that the chat session has ended and call ShowFormillaChatBox to show the email and start button again.
                Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + "<div style=\"clear:both; color:red; margin-bottom: 7px;\">Your chat session has ended.  To start a new chat session, enter your email and click Start.</div>";
                Formilla.ShowFormillaChatBox();

                //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
                Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;
            }
        }
        else {
            document.getElementById(obj).style.display = 'none';

            if (Formilla.isChatShown)
                Formilla.ShowFormillaChatBox();
            else
                Formilla.ShowFormillaEmailBox();

            Formilla.resetFormillaEmailFields();

        }
    },

    AutoPopUpFormillaChat: function (timer) {
        //Check to see if we already showed the form to the user before trying to show it again
        if (Formilla.getFormillaCookie("AutoDisplayChatShown" + Formilla.guid) != "yes") {
            //stop the poll timer if it's running
            if (Formilla.pollTimer) {
                window.clearInterval(Formilla.pollTimer);
            }

            Formilla.proactiveTimer = window.setInterval("Formilla.LaunchFormillaAutoChat(" + timer + ");", timer * 1000);
        }
    },

    LaunchFormillaAutoChat: function (timer) {
        //If the popup is already open, no need to execute the code again.  Also, since the user is already considering starting a chat, 
        //set the cookie so we don't bother the user with another popup.  Just in case, we check to see if the chat was shown 
        //either automatically or manually one more time before proceeding further.
        if (document.getElementById('divFormillaChat').style.display != 'none' || Formilla.getFormillaCookie("AutoDisplayChatShown" + Formilla.guid) == "yes") {
            document.cookie = 'AutoDisplayChatShown' + Formilla.guid + '=yes; path=/';

            //stop the proactive timer
            if (Formilla.proactiveTimer) {
                window.clearInterval(Formilla.proactiveTimer);
            }

            return false;
        }

        Formilla.initFormillaChatFields();

        //This call initiates the chat and gets the ball rolling.  We send a blank message since proactive chat doesn't need to send one.
        Formilla.FormillaSendMessage("", true);
    },

    getFormillaCookie: function (c_name) {
        var i, x, y, ARRcookies = document.cookie.split(";");
        for (i = 0; i < ARRcookies.length; i++) {
            x = ARRcookies[i].substr(0, ARRcookies[i].indexOf("="));
            y = ARRcookies[i].substr(ARRcookies[i].indexOf("=") + 1);
            x = x.replace(/^\s+|\s+$/g, "");
            if (x == c_name) {
                return unescape(y);
            }
        }
    },

    getFormillaWindowHeight: function () {
        var windowHeight = 0;
        if (typeof (window.innerHeight) == 'number') {
            windowHeight = window.innerHeight;
        }
        else {
            if (document.documentElement && document.documentElement.clientHeight) {
                windowHeight = document.documentElement.clientHeight;
            }
            else {
                if (document.body && document.body.clientHeight) {
                    windowHeight = document.body.clientHeight;
                }
            }
        }
        return windowHeight;
    },

    initFormillaDragDrop: function () {
        document.onmousedown = Formilla.FormillaChatOnMouseDown;
        document.onmouseup = Formilla.FormillaChatOnMouseUp;

        Formilla.contentElement = document.getElementById('divFormillaChat');
        Formilla.contentWidth = Formilla.contentElement.offsetWidth;
        Formilla.contentHeight = Formilla.contentElement.offsetHeight;
        Formilla.sctop = parseInt(document.documentElement.scrollTop);
        Formilla.scleft = parseInt(document.documentElement.scrollLeft);
        Formilla.winwidth = parseInt(document.documentElement.clientWidth);
        Formilla.winheight = parseInt(document.documentElement.clientHeight);

        //This code places the chat window in the bottom right corner of the window depending on the size of your screen
        Formilla._dragElement = document.getElementById('divFormillaChat');

        if (Formilla.buttonLocation == 'bottom-right' || Formilla.buttonLocation == 'bottom-left') {
            if (Formilla.buttonLocation == 'bottom-right')
                Formilla._dragElement.style.left = (Formilla.winwidth - Formilla.contentWidth) + 'px';
            else
                Formilla._dragElement.style.left = '0px';
        }
        else if (Formilla.buttonLocation == 'css') {
            //If the user specified the left style, use it.  Otherwise, see if the user specified the right style, and if neither, just align to the bottom right corner.
            if (parseInt(Formilla.FormillaGetStyle(Formilla._dragElement, 'left')) >= 0)
                Formilla._dragElement.style.left = Formilla.FormillaGetStyle(Formilla._dragElement, 'left');
            else if (parseInt(Formilla.FormillaGetStyle(Formilla._dragElement, 'right')) >= 0)
                Formilla._dragElement.style.left = (Formilla.winwidth - Formilla.contentWidth - parseInt(Formilla.FormillaGetStyle(Formilla._dragElement, 'right'))) + 'px';
            else
                Formilla._dragElement.style.left = (Formilla.winwidth - Formilla.contentWidth) + 'px';
        }

        Formilla._dragElement.style.top = (Formilla.winheight - Formilla.contentHeight) + 'px';
    },

    FormillaChatOnMouseDown: function (e) {
        // IE doesn't pass the event object so we have to do it manually
        if (e == null)
            e = window.event;

        // IE uses srcElement, others use target 
        var target = e.target != null ? e.target : e.srcElement;
        //_debug.innerHTML = target.className == 'drag' 
        //? 'draggable element clicked' 
        //: 'NON-draggable element clicked'; 

        // for IE, left click == 1 
        // for Firefox, left click == 0 
        if ((e.button == 1 && window.event != null || e.button == 0) && target.className == 'formilla-drag') {
            // grab the mouse position 
            Formilla._startX = e.clientX;
            Formilla._startY = e.clientY;

            Formilla._dragElement = document.getElementById('divFormillaChat');
            target = Formilla._dragElement;

            // grab the clicked element's position 
            Formilla._offsetX = Formilla.ExtractNumber(target.style.left);
            Formilla._offsetY = Formilla.ExtractNumber(target.style.top);

            // bring the clicked element to the front while it is being dragged 
            Formilla._oldZIndex = target.style.zIndex;
            target.style.zIndex = 2147483647;

            // tell our code to start moving the element with the mouse 
            document.onmousemove = Formilla.FormillaChatOnMouseMove;

            // cancel out any text selections 
            document.body.focus();

            // prevent text selection in IE 
            document.onselectstart = function () { return false; };

            // prevent IE from trying to drag an image 
            target.ondragstart = function () { return false; };

            // prevent text selection (except IE) 
            return false;
        }
    },

    FormillaChatOnMouseMove: function (e) {
        if (e == null)
            var e = window.event;

        // this is the actual "drag code"
        Formilla._dragElement.style.left = (Formilla._offsetX + e.clientX - Formilla._startX) + 'px';
        Formilla._dragElement.style.top = (Formilla._offsetY + e.clientY - Formilla._startY) + 'px';

        //alert(Formilla._dragElement.style.left);

        if ((Formilla._offsetX + e.clientX - Formilla._startX) <= 0)
            Formilla._dragElement.style.left = '0px';
        else if ((Formilla._offsetX + e.clientX - Formilla._startX) >= (Formilla.winwidth - Formilla.contentWidth)) //max window width
            Formilla._dragElement.style.left = (Formilla.winwidth - Formilla.contentWidth) + 'px';

        if ((Formilla._offsetY + e.clientY - Formilla._startY) <= 0)
            Formilla._dragElement.style.top = '0px';
        else if ((Formilla._offsetY + e.clientY - Formilla._startY) >= (Formilla.winheight - Formilla.contentHeight))
            Formilla._dragElement.style.top = (Formilla.winheight - Formilla.contentHeight) + 'px';
    },

    FormillaChatOnMouseUp: function (e) {
        if (Formilla._dragElement != null) {
            Formilla._dragElement.style.zIndex = Formilla._oldZIndex;

            // we're done with these events until the next OnMouseDown 
            document.onmousemove = null;
            document.onselectstart = null;
            Formilla._dragElement.ondragstart = null;

            // this is how we know we're not dragging 
            Formilla._dragElement = null;
            //_debug.innerHTML = 'mouse up';
        }
    },

    FormillaStartChat: function () {
        Formilla.startChat = 1;

        if (Formilla.FormillaValidateChatEmailAddress(true)) {
            Formilla.startChatButton.style.display = 'none';
            Formilla.FormillaSendMessage(Formilla.chatEmailTextbox.value.trim(), false);
        }
    },

    handleOnEnterKey: function (self, e) {
        if (navigator.appName == 'Microsoft Internet Explorer') {
            if (event.keyCode == 13) {
                Formilla.FormillaSendMessage(Formilla.chatTextbox.value, false);
                return false;
            }
        }
        else {
            if (e.keyCode == 13) {
                Formilla.FormillaSendMessage(Formilla.chatTextbox.value, false);
                return false;
            }
        }
    },

    bindFormillaOnEnterKey: function () {
        Formilla.chatTextbox.onkeydown = function (event) {
            return Formilla.handleOnEnterKey(this, event)
        };
    },

    handleOnEnterKeyChatEmail: function (self, e) {
        if (navigator.appName == 'Microsoft Internet Explorer') {
            if (event.keyCode == 13) {
                Formilla.FormillaStartChat();
                return false;
            }
        }
        else {
            if (e.keyCode == 13) {
                Formilla.FormillaStartChat();
                return false;
            }
        }
    },

    bindFormillaOnEnterKeyChatEmail: function () {
        Formilla.chatEmailTextbox.onkeydown = function (event) {
            return Formilla.handleOnEnterKeyChatEmail(this, event)
        };
    },

    bindFormillaEmailEvents: function () {
        Formilla.chatEmailTextbox.onkeypress, Formilla.chatEmailTextbox.onkeydown, Formilla.chatEmailTextbox.onkeyup = function (e) {
            if (Formilla.chatEmailTextbox.value.trim() == '') {
                Formilla.spanChatEmailTextbox.style.display = 'block';
            }
            else {
                Formilla.spanChatEmailTextbox.style.display = 'none';
            }
            Formilla.FormillaValidateChatEmailAddress(false);
        };

        Formilla.chatEmailTextbox.onblur = function (e) {
            Formilla.FormillaValidateChatEmailAddress(true);
            if (Formilla.chatEmailTextbox.value.trim() == '') {
                Formilla.spanChatEmailTextbox.style.display == '';
                return false;
            }
        };

        Formilla.emailTextbox.onkeypress, Formilla.emailTextbox.onkeydown, Formilla.emailTextbox.onkeyup = function (e) {
            if (Formilla.emailTextbox.value.trim() == '') {
                Formilla.spanEmailTextbox.style.display = 'block';
            }
            else {
                Formilla.spanEmailTextbox.style.display = 'none';
            }
            Formilla.FormillaValidateEmailAddress(false);
        };

        Formilla.emailMessage.onkeypress, Formilla.emailMessage.onkeydown, Formilla.emailMessage.onkeyup = function (e) {
            if (Formilla.emailMessage.value.trim() == '') {
                Formilla.spanEmailMessage.style.display = 'block';
            }
            else {
                Formilla.spanEmailMessage.style.display = 'none';
            }
            Formilla.FormillaValidateEmailMessage(false);
        };

        Formilla.emailTextbox.onblur = function (e) {
            Formilla.FormillaValidateEmailAddress(true);
            if (Formilla.emailTextbox.value.trim() == '') {
                Formilla.spanEmailTextbox.style.display == '';
                return false;
            }
        };

        Formilla.emailMessage.onblur = function (e) {
            Formilla.FormillaValidateEmailMessage(true);
            if (Formilla.emailMessage.value.trim() == '') {
                Formilla.spanEmailMessage.style.display == '';
                return false;
            }
        };
    },

    initFormillaChatFields: function () {
        //Set the objects for the chat messages container, textbox, etc. to be used throughout the javascript functions
        Formilla.chatMessagesContainer = document.getElementById("divFormillaChatMessages");
        Formilla.lastChatMessageTimestamp = document.getElementById("hdnLastChatMessageTimestamp");
        Formilla.chatTextbox = document.getElementById("txtFormillaMessage");
        Formilla.spanChatEmailTextbox = document.getElementById("spanFormillaChatEmailTextbox");
        Formilla.chatEmailTextbox = document.getElementById("txtFormillaChatEmailTextbox");
        Formilla.emailBoxContainer = document.getElementById("divFormillaEmailBox");
        Formilla.spanEmailTextbox = document.getElementById("spanFormillaEmailTextbox");
        Formilla.emailTextbox = document.getElementById("txtFormillaEmailTextbox");
        Formilla.spanEmailMessage = document.getElementById("spanFormillaEmailMessage");
        Formilla.emailMessage = document.getElementById("txtFormillaEmailMessage");
        Formilla.emailUsButton = document.getElementById("formillaEmailButton");
        Formilla.sendButton = document.getElementById("formillaSendButton");
        Formilla.startChatButton = document.getElementById("formillaStartChatButton");
        Formilla.responseBoxContainer = document.getElementById("divFormillaResponseBox");
        Formilla.spanFormillaResponseMessage = document.getElementById("spanFormillaResponseMessage");
    },

    initFormillaChatShowChatWindow: function () {
        //this shows the chat window
        document.getElementById('divFormillaChat').style.display = "";

        //we init after we show the popup because otherwise the calculations will be off when placing the form in the bottom right corner.
        Formilla.initFormillaDragDrop();
        Formilla.bindFormillaOnEnterKey();
        Formilla.bindFormillaOnEnterKeyChatEmail();

        //bind the onclick events for the email and message textboxes
        Formilla.bindFormillaEmailEvents()

        Formilla.chatTextbox.focus();

        //Only start the timer if there is a chat session in progress and the timer isn't already running
        if (Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid)) {
            if (!Formilla.pollTimer)
                Formilla.startFormillaPollTimer(); //this starts the timer to check for new csr messages every few seconds
        }

        //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
        Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;
    },

    initFormillaChat: function () {
        //alert('initFormillaChat');
        Formilla.initFormillaChatFields();
        Formilla.initFormillaChatShowChatWindow();

        //Set the email textbox to the passed in email address if we received it as a custom var.
        if (Formilla.customerEmail.trim() != "") {
            Formilla.chatEmailTextbox.value = Formilla.customerEmail.trim();
            Formilla.spanChatEmailTextbox.innerHTML = "";
        }

        Formilla.chatEmailTextbox.focus();
    },

    initProactiveFormillaChat: function () {
        //alert('initProactiveFormillaChat');
        Formilla.initFormillaChatFields();
        Formilla.initFormillaChatShowChatWindow();

        //Hide the email textbox and start button and show the message textarea
        Formilla.chatEmailTextbox.style.display = 'none';
        Formilla.spanChatEmailTextbox.style.display = 'none';
        Formilla.startChatButton.style.display = 'none';
        Formilla.chatTextbox.style.display = '';
        Formilla.chatTextbox.focus();
    },

    startFormillaPollTimer: function () {
        //stop the proactive timer if it's running
        if (Formilla.proactiveTimer) {
            window.clearInterval(Formilla.proactiveTimer);
        }
        //3 second polling
        Formilla.pollTimer = window.setInterval(Formilla.GetNewFormillaMessages, 3000);
    },

    GetNewFormillaMessages: function () {
        var hdnFormillaSessionId = document.getElementById('hdnFormillaSessionId').value;
        var hdnLastChatMessageTimestamp = 0;

        if (document.getElementById('hdnLastChatMessageTimestamp')) {
            hdnLastChatMessageTimestamp = document.getElementById('hdnLastChatMessageTimestamp').value;
        }

        var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
        url = url + "&f=getFormillaChatMessages" + "&guid=" + Formilla.guid + "&hdnFormillaSessionId=" + hdnFormillaSessionId + "&hdnLastChatMessageTimestamp=" + hdnLastChatMessageTimestamp + "&callback=FormillaGetMessagesCallback";
        Formilla.dynamicJSONTag(url);
    },

    FormillaGetMessagesCallback: function (JSONData) {
        if (JSONData != null) {
            if (JSONData.error) {
                Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + JSONData.message;

                //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
                Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;
            }
            else {
                //This would normally happen just when proactive chat started and since we don't show the window unless
                //the proactive chat actually starts successfully we only know that if we successfully "get" a csr message
                if (Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid) && (document.getElementById('divFormillaChat').style.display == 'none')) {
                    Formilla.ShowFormillaChatBox();
                    Formilla.initProactiveFormillaChat();
                }

                //See if the jsonp call is telling us to delete the cookie since the chat session has ended.
                if (JSONData.DeleteChatCookie == 'True') {
                    document.cookie = 'formillaChatSession' + Formilla.guid + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/';
                    document.getElementById('hdnFormillaSessionId').value = "";
                    Formilla.chatTextbox.style.display = 'none';
                    Formilla.chatEmailTextbox.style.display = 'inline-block';

                    if (Formilla.chatEmailTextbox.value.trim() == '')
                        Formilla.spanChatEmailTextbox.style.display = 'block';
                    else
                        Formilla.spanChatEmailTextbox.style.display = 'none';

                    Formilla.startChatButton.style.display = 'block';
                }

                //Check to see if the start message is still showing.  If it is, clear it out.  Else, keep appending.
                if (Formilla.chatMessagesContainer.innerHTML.indexOf("divFormillaStartMessage") > 0 || JSONData.IsUserWaiting || JSONData.ChatSessionStarted) {
                    Formilla.chatMessagesContainer.innerHTML = JSONData.ChatMessages;

                    if (JSONData.ChatSessionStarted)
                        Formilla.chatTextbox.style.display = ""; //Show the chat textbox since the chat has started
                }
                else
                    Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + JSONData.ChatMessages;

                if (JSONData.LastChatMessageTimestamp != 0) {
                    Formilla.lastChatMessageTimestamp.value = JSONData.LastChatMessageTimestamp;
                }

                //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message
                if (JSONData.ChatMessages != "") {
                    Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;
                }
            }
        }
    },

    FormillaSendMessage: function (message, isProactive) {
        //Don't proceed further if the user hasn't typed anything and it's not a proactive chat.  If it's proactive, it's ok to proceed.
        if (message.trim() == '' && !isProactive)
            return false;

        if (!isProactive) {
            //disable the textarea temporarily so the user doesn't try to click enter multiple times and send the same message.
            Formilla.chatTextbox.disabled = true;
        }
        else {
            //stop the proactive timer since it just triggered a proactive chat
            if (Formilla.proactiveTimer) {
                window.clearInterval(Formilla.proactiveTimer);
            }
        }

        var hdnFormillaSessionId = document.getElementById('hdnFormillaSessionId').value;

        var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
        url = url + "&f=sendChatMessage" + "&guid=" + Formilla.guid + "&hdnFormillaSessionId=" + hdnFormillaSessionId + "&txtFormillaMessage=" + encodeURIComponent(Formilla.HTMLEncode(message));

        //If this chat was started after entering an email address (or if proactive), notify the server and then reset the variable.
        if (Formilla.startChat == 1 || isProactive) {
            url = url + "&startChat=1&txtFormillaChatEmailTextbox=" + encodeURIComponent(Formilla.chatEmailTextbox.value.trim());
            url = url + "&pageURL=" + escape(document.location) + "&customerName=" + encodeURIComponent(Formilla.customerName) + "&customerPhone=" + encodeURIComponent(Formilla.customerPhone) + "&screenWidth=" + screen.width + "&screenHeight=" + screen.height + "&CustomField1=" + encodeURIComponent(Formilla.customField1) + "&CustomField2=" + encodeURIComponent(Formilla.customField2) + "&CustomField3=" + encodeURIComponent(Formilla.customField3);

            Formilla.startChat = 0;

            //We set the "user xyz started a chat..." message to the textbox so it renders back to the user after they click start
            Formilla.chatTextbox.value = message;
        }

        url = url + "&IsProactive=" + isProactive + "&callback=FormillaSendMessageCallback";

        Formilla.dynamicJSONTag(url);
    },

    FormillaSendSilentMessage: function (sessionId, message) {
        var url = (document.location.protocol == 'https:' ? 'https://' : 'http://') + Formilla.formillaDomain + "/ajaxhandler.aspx?rnd=" + Math.random();
        url = url + "&f=sendSilentChatMessage" + "&hdnFormillaSessionId=" + sessionId + "&message=" + escape(message);
        Formilla.dynamicJSONTag(url);
    },

    FormillaSendMessageCallback: function (JSONData) {
        //Re-enable the textarea since we got a response back
        Formilla.chatTextbox.disabled = false;
        Formilla.chatTextbox.focus();

        if (JSONData != null) {
            if (JSONData.error) {
                //Check to see if the start message is still showing.  If it is, clear it out.  Else, keep appending.
                if (Formilla.chatMessagesContainer.innerHTML.indexOf("divFormillaStartMessage") > 0)
                    Formilla.chatMessagesContainer.innerHTML = Formilla.FormillaFirstMessagePaddingTop() + Formilla.FormillaMessageBeginWrapper() + JSONData.message + Formilla.FormillaMessageEndWrapper();
                else
                    Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + Formilla.FormillaMessageBeginWrapper() + JSONData.message + Formilla.FormillaMessageEndWrapper();

                //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
                Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;

                //If there was an error sending the message, we show the Email us button in the bottom right corner and
                //we adjust the height of the chat textbox so they don't overlap.
                Formilla.emailUsButton.style.display = '';
                Formilla.chatTextbox.style.height = '45px';
            }
            else {
                //if the cookie doesn't exist yet, that means the timer isn't running yet so let's start the timer to check for CSR messages.
                if (!Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid))
                    Formilla.startFormillaPollTimer();

                //set hidden field and cookie
                //server-side code will set the hidden field again using the cookie
                document.getElementById("hdnFormillaSessionId").value = JSONData.sessionId;
                document.cookie = 'formillaChatSession' + Formilla.guid + '=' + JSONData.sessionId + '; path=/';

                Formilla.chatTextbox.style.display = '';
                Formilla.chatEmailTextbox.style.display = 'none';

                //if this was a proactive chat, we set the cookie so that we know not to bother the user again and 
                //then no need to proceed any further since we don't plan to show their message as they didn't initiate the chat.
                if (JSONData.IsProactive) {
                    document.cookie = 'AutoDisplayChatShown' + Formilla.guid + '=yes; path=/';

                    //This would normally happen just when proactive chat started and since we don't show the window unless
                    //the proactive chat actually starts successfully we only know that if we successfully "get" a csr message
                    if (Formilla.getFormillaCookie("formillaChatSession" + Formilla.guid) && (document.getElementById('divFormillaChat').style.display == 'none')) {
                        Formilla.ShowFormillaChatBox();
                        Formilla.initProactiveFormillaChat();
                    }

                    //If this is the start of the chat, we pull the translated text server-side and render it dynamically based on the widget language preferences
                    if (JSONData.IsStartChat)
                        message = JSONData.userStartMessage;

                    //Check to see if the start message is still showing.  If it is, clear it out.  Else, keep appending.
                    if (Formilla.chatMessagesContainer.innerHTML.indexOf("divFormillaStartMessage") > 0) {
                        Formilla.chatMessagesContainer.innerHTML = Formilla.FormillaFirstMessagePaddingTop() + message;
                    }
                    else {
                        Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + message;
                    }

                    return;
                }

                //This is just a status notification of where the user is at in the queue
                if (JSONData.IsStatusDisplay) {
                    Formilla.chatMessagesContainer.innerHTML = JSONData.message + "<br />";

                    //Hide the chat textbox since the user is waiting
                    Formilla.chatTextbox.style.display = "none";
                }
                else {
                    var message = '';

                    //If this is the start of the chat, we pull the translated text server-side and render it dynamically based on the widget language preferences
                    if (JSONData.IsStartChat)
                        message = JSONData.userStartMessage;
                    else
                        message = Formilla.HTMLEncode(Formilla.chatTextbox.value);

                    //Check to see if the start message is still showing.  If it is, clear it out.  Else, keep appending.
                    if (Formilla.chatMessagesContainer.innerHTML.indexOf("divFormillaStartMessage") > 0) {
                        Formilla.chatMessagesContainer.innerHTML = Formilla.FormillaFirstMessagePaddingTop() + Formilla.FormillaMessageBeginWrapper() + message + Formilla.FormillaMessageEndWrapper();
                    }
                    else {
                        Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + Formilla.FormillaMessageBeginWrapper() + message + Formilla.FormillaMessageEndWrapper();
                    }
                }

                //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
                Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;

                //clear text box
                Formilla.chatTextbox.value = '';

                Formilla.chatTextbox.focus();
            }
        }
        else {
            var errormsg = 'There was an error with your message. Please remove any illegal characters and try again.';

            //Check to see if the start message is still showing.  If it is, clear it out.  Else, keep appending.
            if (Formilla.chatMessagesContainer.innerHTML.indexOf("divFormillaStartMessage") > 0)
                Formilla.chatMessagesContainer.innerHTML = Formilla.FormillaFirstMessagePaddingTop() + Formilla.FormillaMessageBeginWrapper() + errormsg + Formilla.FormillaMessageEndWrapper();
            else
                Formilla.chatMessagesContainer.innerHTML = Formilla.chatMessagesContainer.innerHTML + Formilla.FormillaMessageBeginWrapper() + errormsg + Formilla.FormillaMessageEndWrapper();

            //in case the div is scrolling, this will make sure to scroll to the bottom of the div to see the latest message 
            Formilla.chatMessagesContainer.scrollTop = Formilla.chatMessagesContainer.scrollHeight;

            //If there was an error sending the message, we show the Email us button in the bottom right corner and
            //we adjust the height of the chat textbox so they don't overlap.
            Formilla.emailUsButton.style.display = '';
            Formilla.chatTextbox.style.height = '45px';
        }

    },

    ExtractNumber: function (value) {
        var n = parseInt(value);
        return n == null || isNaN(n) ? 0 : n;
    },

    FormillaIsValidEmail: function (email) {
        if (email == '' || email == null) {
            return false;
        }

        var regexp = /^[A-Za-z0-9']([\.\-\+]?[a-zA-Z0-9'_])*\@([A-Za-z0-9\-]+\.)+[A-Za-z]{2,5}$/;

        if (regexp.test(email.trim()))
            return true;
        else
            return false;
    },

    FormillaFirstMessagePaddingTop: function () {
        return "";
    },

    FormillaMessageBeginWrapper: function () {
        return "<div style=\"color:" + Formilla.userChatMessageTextColor + "; float:left; clear:both; display: inline; border-radius: 4px; margin-bottom: 7px; padding: 5px; background-color: " + Formilla.userChatMessageBackgroundColor + ";\"><span style=\"color:" + Formilla.userChatMessageTextColor + "; font-weight: bold;\">Me: </span>";
    },

    FormillaMessageEndWrapper: function () {
        return "</div>";
    },

    HTMLEncode: function (text) {
        return text.replace(/</g, "&lt;").replace(/>/g, "&gt;");
    },

    showAttnGrabberCloseBtn: function (bShow) {
        if (bShow)
            document.getElementById('formilla-attn-close').style.display = 'block';
        else
            document.getElementById('formilla-attn-close').style.display = 'none';
    },

    hideAttnGrabber: function () {
        document.getElementById('formilla-attn-grabber-ctr').style.display = 'none';

        var date = new Date();
        date.setTime(date.getTime() + (24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();

        document.cookie = 'AttnGrabberClosed' + Formilla.guid + '=yes' + expires + '; path=/';
    },

    showOfflineAttnGrabberCloseBtn: function (bShow) {
        if (bShow)
            document.getElementById('formilla-off-attn-close').style.display = 'block';
        else
            document.getElementById('formilla-off-attn-close').style.display = 'none';
    },

    hideOfflineAttnGrabber: function () {
        document.getElementById('formilla-off-attn-grabber-ctr').style.display = 'none';

        var date = new Date();
        date.setTime(date.getTime() + (24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();

        document.cookie = 'OfflineAttnGrabberClosed' + Formilla.guid + '=yes' + expires + '; path=/';
    },

    FormillaGetStyle: function (el, cssprop) {
        if (el.currentStyle) //IE
            return el.currentStyle[cssprop]
        else if (document.defaultView && document.defaultView.getComputedStyle) //Firefox
            return document.defaultView.getComputedStyle(el, "")[cssprop]
        else //try and get inline style
            return el.style[cssprop]
    }

}
