<%--
<SCRIPT LANGUAGE="javascript">
    
    var req=false;
    function initialize()
    {

        if (window.XMLHttpRequest)  // Purpose of the current window
        {

            req = new XMLHttpRequest();  // Firefox, Safari, ...
            
        }
        else if (window.ActiveXObject) // Version Active
        {
            req = new ActiveXObject("Microsoft.XMLHTTP" ); // Internet Explorer
        }

       
    }
    function populateCity()
    {

        initialize();
        var state=document.getElementById('sname').value;

        var url="SelectData.jsp?svalue="+state;
        if(req!=null)
        {
            req.open("GET",url,true);
            req.onreadystatechange=process;
            req.send(null);
        }
    }
    function process()
    {
        if(req.readyState==4)
        {
            if(req.status==200)
            {
                var cities = req.responseText.split(',');
                //alert(cities);
                cname.options.length = 0; //clear all options
                try
                {
                    for(i=0;i<cities.length-1;i++)
                    {
                        var city = cities[i].split('~');
                        /* For IE- 7*/
                        //document.createElement("OPTION");
                        var opt = document.createElement("OPTION");
                        //alert(opt);
                        opt.label = city[1];
                        opt.value = city[0];
                        cname.options[cname.options.length] = opt;
                       /* if (window.XMLHttpRequest)  // Purpose of the current window
                        {
                            opt=
                        }
                        cname.options[cname.options.length] = new Option(city[1], city[0])

                      
                       var anOption = document.createElement("OPTION");
                       document.getElementById("category").options.add(an Option);
                       anOption.innerText = "NewElement";
                       anOption.Value = "99"; */

                    }
                }
                catch(e) {alert(e)}
            }

        }
    }

    function searchCity(){
        var countryCode = document.getElementById('sname').value;
        var locationCode = document.getElementById('cname').value;

        location.href = "populateCityOfCountryAction.do?countryCode="+countryCode+"&locationCode="+locationCode;
    }

</SCRIPT>
--%>
<div class="dropDownSection" style="margin-left:none;">
    <select name="sname" onchange="populateCity()" id="sname" style="width:170px; border:1px solid #0777E8;">
        <option value="" selected>-:Select Country :-</option>
        <option value="IND">India</option>
        <option value="AFG">Afganistan </option>
        <option value="AFU">African Union </option>
        <option value="AGI">Anguilla </option>
        <option value="AGL">Angola</option>
        <option value="ALA">Alaska</option>
        <option value="ALB">Albania</option>
        <option value="ALG">Algeria</option>
        <option value="AND">Andorra</option>
        <option value="ANT">Antarctica</option>
        <option value="ARG">Argentina</option>
        <option value="ARL">Arab League</option>
        <option value="ARM">Armenia</option>
        <option value="ARU">Aruba</option>
        <option value="ASE">Asean</option>
        <option value="ATG">Antigua & Barbuda</option>
        <option value="ATN">Netherlands Antilles</option>
        <option value="AUS">Australia</option>
        <option value="AUT">Austria</option>
        <option value="AZE">Azerbaijan</option>
        <option value="AZR">Azores</option>


        <option value="BAH">Bahamas</option>

        <option value="BHR">Bahrain</option>

        <option value="BNG">Bangladesh</option>

        <option value="BRB">Barbados</option>

        <option value="BLR">Belarus</option>

        <option value="BEL">Belgium</option>

        <option value="BLZ">Belize</option>

        <option value="BEN">Benin</option>

        <option value="BER">Bermuda</option>

        <option value="BHU">Bhutan</option>

        <option value="BOL">Bolivia</option>

        <option value="BOS">Bosnia & Herzegovina</option>

        <option value="BOT">Botswana</option>

        <option value="BRA">Brazil</option>

        <option value="BRU">Brunei</option>

        <option value="BUL">Bulgaria</option>
        <%--
        <option value="Burkina Faso">Burkina Faso</option>

<option value="Burma (Myanmar)">Burma (Myanmar)</option>
        --%>
        <option value="BDI">Burundi</option>

        <option value="CBG">Cambodia</option>

        <option value="CAM">Cameroon</option>

        <option value="CAN">Canada</option>
        <%--
        <option value="Canary Islands">Canary Islands</option>
        --%>
        <option value="CAV">Cape Verde</option>

        <option value="CYM">Cayman Islands</option>

        <option value="CAF">Central African Rep. </option>
        <%--
        <option value="Chad">Chad</option>

<option value="Channel Islands">Channel Islands</option>
        --%>
        <option value="CHL">Chile</option>

        <option value="CHN">China</option>

        <option value="CHR">Christmas Island</option>

        <option value="COL">Colombia</option>

        <option value="COM">Comoros</option>

        <option value="COG">Congo</option>
        <%--
        <option value="Congo Dem. Rep">Congo Dem. Rep</option>
        --%>
        <option value="COK">Cook Islands</option>

        <option value="CRI">Costa Rica</option>

        <option value="CRO">Croatia</option>

        <option value="CUB">Cuba</option>

        <option value="CYP">Cyprus</option>
        <%--
        <option value="Czech Rep. ">Czech Rep. </option>
        --%>
        <option value="DNK">Denmark</option>

        <option value="DJI">Djibouti</option>

        <option value="DMA">Dominica</option>

        <option value="DOM">Dominican Rep. </option>
        <%--
        <option value="East Timor">East Timor</option>
        --%>
        <option value="ECU">Ecuador</option>

        <option value="EGY">Egypt</option>
        <%--
        <option value="Equatorial Guinea">Equatorial Guinea</option>
        --%>
        <option value="ERI">Eritrea</option>

        <option value="EST">Estonia</option>

        <option value="ETH">Ethiopia</option>

        <option value="FLK">Falkland Islands</option>

        <option value="FRO">Faroe Islands</option>

        <option value="FIJ">Fiji</option>

        <option value="FIN">Finland</option>

        <option value="FRA">France</option>

        <option value="GIA">French Guiana</option>
        <%--
        <option value="French Polynesia">French Polynesia</option>
        --%>
        <option value="GAB">Gabon</option>

        <option value="GAM">Gambia</option>

        <option value="GEO">Georgia</option>

        <option value="GER">Germany</option>

        <option value="GHA">Ghana</option>

        <option value="GIB">Gibraltar</option>

        <option value="GBR">Great Britain</option>

        <option value="GRE">Greece</option>

        <option value="GRL">Greenland</option>

        <option value="GRD">Grenada</option>

        <option value="GDL">Guadeloupe</option>

        <option value="GUM">Guam</option>

        <option value="GTM">Guatemala</option>
        <%--
        <option value="Guiana (French) ">Guiana (French) </option>
        --%>
        <option value="GUI">Guinea</option>
        <%--
        <option value="Guinea (Equat.) ">Guinea (Equat.) </option>
        --%>
        <option value="GNB">Guinea-Bissau</option>

        <option value="GUY">Guyana</option>

        <option value="HAI">Haiti</option>

        <option value="HAW">Hawaii</option>

        <option value="HND">Honduras</option>

        <option value="HUN">Hungary</option>

        <option value="ISL">Iceland</option>


        <option value="IDN">Indonesia</option>

        <option value="IRN">Iran</option>

        <option value="IRQ">Iraq</option>

        <option value="IRL">Ireland</option>
        <%--
        <option value="Isle of Man">Isle of Man</option>
        --%>
        <option value="ISR">Israel</option>

        <option value="ITA">Italy</option>
        <%--
        <option value="Ivory Coast">Ivory Coast</option>
        --%>
        <option value="JAM">Jamaica</option>

        <option value="JAP">Japan</option>
        <%--
        <option value="Jersey & Guernsey">Jersey & Guernsey</option>
        --%>
        <option value="JOR">Jordan</option>

        <option value="KAZ">Kazakhstan</option>

        <option value="KEN">Kenya</option>

        <option value="KIR">Kiribati</option>

        <option value="KOR">Korea</option>

        <option value="KUW">Kuwait</option>

        <option value="KGZ">Kyrgyzstan</option>

        <option value="LAO">Laos</option>

        <option value="LAT">Latvia</option>

        <option value="LIB">Lebanon</option>

        <option value="LSO">Lesotho</option>

        <option value="LBR">Liberia</option>

        <option value="LBY">Libya</option>

        <option value="LIE">Liechtenstein</option>

        <option value="LIT">Lithuania</option>

        <option value="LUX">Luxembourg</option>

        <option value="MAC">Macau</option>

        <option value="MKD">Macedonia</option>

        <option value="MAD">Madagascar</option>

        <option value="MDR">Madeira</option>

        <option value="MWI">Malawi</option>

        <option value="MLS">Malaysia</option>

        <option value="MLD">Maldives</option>

        <option value="MLI">Mali</option>

        <option value="MLT">Malta</option>

        <option value="MAN">Man (Isle) </option>

        <option value="MRN">Mariana Islands</option>

        <option value="MHL">Marshall Islands</option>

        <option value="MTN">Martinique</option>

        <option value="MRT">Mauritania</option>

        <option value="MRI">Mauritius</option>

        <option value="MYT">Mayotte</option>

        <option value="MEX">Mexico</option>

        <option value="MIC">Micronesia</option>

        <option value="MOL">Moldova</option>

        <option value="MCO">Monaco</option>

        <option value="MNG">Mongolia</option>

        <option value="MSR">Montserrat</option>

        <option value="MAR">Morocco</option>

        <option value="MOZ">Mozambique</option>
        <%--
        <option value="Myanmar">Myanmar</option>
        --%>
        <option value="NAM">Namibia</option>

        <option value="NRU">Nauru</option>

        <option value="NEP">Nepal</option>

        <option value="NED">Netherlands</option>
        <%--
        <option value="Netherlands Antilles">Netherlands Antilles</option>
        --%>
        <option value="NCL">New Caledonia</option>

        <option value="NZL">New Zealand</option>

        <option value="NIC">Nicaragua</option>

        <option value="NGR">Niger</option>

        <option value="NIG">Nigeria</option>

        <option value="NIU">Niue</option>

        <option value="NFK">Norfolk</option>
        <%--
        <option value="Northern Mariana Isl. ">Northern Mariana Isl. </option>
        --%>
        <option value="NOR">Norway</option>

        <option value="OMA">Oman</option>

        <option value="PAK">Pakistan</option>

        <option value="PLW">Palau</option>

        <option value="PAN">Panama</option>

        <option value="PNG">Papua New Guinea</option>

        <option value="PAR">Paraguay</option>

        <option value="PER">Peru</option>

        <option value="PHL">Philippines</option>

        <option value="PIT">Pitcairn</option>

        <option value="POL">Poland</option>

        <option value="PFR ">Polynesia (French) </option>

        <option value="PRT">Portugal</option>

        <option value="PRI">Puerto Rico</option>

        <option value="QAT">Qatar</option>

        <option value="REU">Reunion</option>

        <option value="ROM">Romania</option>

        <option value="RUS">Russia</option>

        <option value="RWA">Rwanda</option>

        <option value="SHE">Saint Helena</option>

        <option value="SKN">Saint Kitts & Nevis</option>

        <option value="SLU">Saint Lucia</option>

        <option value="SLV">Salvador</option>

        <option value="SAA)">Samoa (American)</option>

        <option value="SAM ">Samoa (Western) </option>

        <option value="SMR">San Marino</option>

        <option value="STP">Sao Tome & Principe</option>

        <option value="SAU">Saudi Arabia</option>

        <option value="SEN">Senegal</option>

        <option value="SEY">Seychelles</option>

        <option value="SLE">Sierra Leone</option>

        <option value="SGP">Singapore</option>

        <option value="SLO">Slovakia</option>

        <option value="SVN">Slovenia</option>

        <option value="SLM">Solomon</option>

        <option value="SOM">Somalia</option>

        <option value="SAF">South Africa</option>
        <%--
        <option value="Spain">Spain</option>

<option value="Spain / Canary">Spain / Canary</option>
        --%>
        <option value="SRI">Sri Lanka</option>

        <option value="SPM">St Pierre & Miquelon</option>
        <%--
        <option value="St Vincent & Grenad.">St Vincent & Grenad.</option>
        --%>
        <option value="SDN">Sudan</option>

        <option value="SUR">Suriname</option>

        <option value="SWA">Swaziland</option>

        <option value="SWE">Sweden</option>

        <option value="SUI">Switzerland</option>

        <option value="SYR">Syria</option>

        <option value="TAI">Taiwan</option>

        <option value="TJK">Tajikistan</option>

        <option value="TZA">Tanzania</option>

        <option value="THA">Thailand</option>

        <option value="TOG">Togo</option>

        <option value="TOK">Tokelau</option>

        <option value="TON">Tonga</option>

        <option value="TRI">Trinidad & Tobago</option>

        <option value="TUN">Tunisia</option>

        <option value="TUR">Turkey</option>

        <option value="TKM">Turkmenistan</option>

        <option value="TCA">Turks & Caicos Isl. </option>

        <option value="TUV">Tuvalu</option>

        <option value="UGA">Uganda</option>

        <option value="UKR">Ukraine</option>

        <option value="UAE">United Arab Emirates</option>

        <option value="UDT">United Kingdom</option>

        <option value="URU">Uruguay</option>

        <option value="USA">USA</option>

        <option value="ULA">USA / Alaska</option>

        <option value="UAW">USA / Hawaii</option>

        <option value="UZB">Uzbekistan</option>

        <option value="VAN">Vanuatu</option>

        <option value="VAT">Vatican</option>

        <option value="VEN">Venezuela</option>

        <option value="VTN">Viet Nam</option>

        <option value="VRG">Virgin Island GB</option>

        <option value="VIR">Virgin Island US</option>

        <option value="WAL">Wallis & Futuna</option>
        <%--
        <option value="Western Sahara">Western Sahara</option>

<option value="Western Samoa">Western Samoa</option>
        --%>
        <option value="YEM">Yemen</option>

        <option value="YUG">Yugoslavia</option>

        <option value="ZAI">Zaire (Congo D.Rep) </option>

        <option value="ZAM">Zambia</option>

        <option value="ZIM">Zimbabwe</option>

    </select>
</div>


