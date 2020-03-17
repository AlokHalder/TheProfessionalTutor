removeInvalidChar(this,event);
function removeInvalidChar(val,e){

   var s = val.value;
   var z = stripInvalidChar(s);
   document.getElementById('idname').value =z;

}

function stripInvalidChar(s){
   return stripCharsInBags(s,"!@#$^&()_+=:?/|{[}]\"");
}

function stripCharInBags(s,bag){
    var i;
    var returnString ="";
   for(i=0;i<s.length;i++){
     var c = s.charAt(i);
       if(bag.indexOf(c)==-1)
          returnString +=c;
       }
    return returnString
}
