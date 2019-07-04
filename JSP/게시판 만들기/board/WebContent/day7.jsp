<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript">
window.onload= function(){
	var req = new XMLHttpRequest();
	req.onloadstart=function(){
		console.log("시작");
	}
	
	req.onreadyStatechange = function(){
		if(req.readyState == 4){
			if(req.status == 200){
				document.getElementById("a").innerHTML = req.responseText;
			}
		}
	}
	req.open("GET","data.txt");
	req.send(null);
}
</script>

<p id='a'>asd</p>

</body>
</html>