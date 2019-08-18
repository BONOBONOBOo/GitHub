<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<meta charset="utf-8">
<head>
	<script src="js/jquery.min.js"></script>
	<script src="https://d3js.org/d3.v5.min.js"></script>
	<script src="https://d3js.org/d3-fetch.v1.min.js"></script>
	<script src="https://d3js.org/d3-dsv.v1.min.js"></script>
	<script src="https://d3js.org/d3-axis.v1.min.js"></script>
	<script type="text/javascript">	
	window.addEventListener("load",function(){
			document.getElementById("a_video").play();
	});
		</script>
</head>

<body>	
	<video width="700" id="a_video" autoplay>
		<source id="movie_src" type="video/mp4" src="sample_1.mp4" />
	</video>
</body>
</html>