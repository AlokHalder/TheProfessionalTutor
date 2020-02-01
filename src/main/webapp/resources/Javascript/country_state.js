//window.onload = function showCountry() {
//    var xmlhttp;
//
//    if (window.XMLHttpRequest)//Create an XMLHttpRequest object for IE7+, Firefox, Chrome, Opera, Safari
//    {
//        xmlhttp = new XMLHttpRequest();
//    }
//    else//Create an XMLHttpRequest object for IE6, IE5
//    {
//        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//    }
//    xmlhttp.onreadystatechange = function()
//    {
//        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
//        {
//            document.getElementById("country_td").innerHTML = xmlhttp.responseText;
//        }
//        else {
//            document.getElementById("country_td").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
//        }
//    }
//
//    xmlhttp.open("GET", "country_1.jsp", true);
//    xmlhttp.send();
//
//}





function showState() {
    var xmlhttp;
    var country = document.getElementById("country").value;

    if (country == "")//Check if a country is not selected
    {
        document.getElementById("state_td").innerHTML = "<select><option value=''>---Select state---</option></select>";
        return;
    }
    if (window.XMLHttpRequest)//Create an XMLHttpRequest object for IE7+, Firefox, Chrome, Opera, Safari
    {
        xmlhttp = new XMLHttpRequest();
    }
    else//Create an XMLHttpRequest object for IE6, IE5
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            document.getElementById("state_td").innerHTML = xmlhttp.responseText;
        }
        else {
            document.getElementById("state_td").innerHTML = "<img src='ajax-loader_new.gif' width='20' height='20'>";
        }
    }

    xmlhttp.open("GET", "state.jsp?c=" + country, true);
    xmlhttp.send();

}

