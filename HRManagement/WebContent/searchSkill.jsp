<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function showHint(str) {
    if (str.length == 0) { 
        document.getElementById("txtHint").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("txtHint").innerHTML = this.responseText;
            }
        };
        xmlhttp.open("GET", "SearchSkill?q=" + str, true);
        xmlhttp.send();
         
    }
}
</script>
</head>
<body>


<h3>Welcome to Skill Search Page</h3>

<br/>Enter Search Parameter 

<form action=""> 
 <input type="text" id="txt1" onkeyup="showHint(this.value)">
</form>

<span id="txtHint"></span></p> 
</body>
</html>