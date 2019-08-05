<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>연습</title>
<script src="js/jquery.min.js"></script>
<script src="https://d3js.org/d3.v5.min.js"></script>
<script src="https://d3js.org/d3-fetch.v1.min.js"></script>
<script src="https://d3js.org/d3-dsv.v1.min.js"></script>
<script src="https://d3js.org/d3-axis.v1.min.js"></script>
</head>
<body>
<style>
	svg{
	width:320px; 
	height:300px;
	
	}
	.line{fill:none;stroke:black;}
	
	.axis text{
	font-family:sans-serif;
	font-size:11px;}
	.axis path,
	.axis line{
	fill:none;
	stroke:black;
	}
	.axis_x line{
	fill:none;
	
	stroke:black;
	}
</style>

<!-- <script src="js/popo.js"></script> -->
<script>
window.addEventListener("load",function(){
	
	
	
	var weightSet;
	var dateSet;
	$.ajax({
		url:"getWeight.do",
		method:"GET",
		async:false,
		success:function(data){
			console.log(data);
			var obj = JSON.parse(data);
			console.log(obj.result);
		
			var weight = obj.result[0].weight;
			var date = obj.result[1].date;
			
			weightSet = weight.split(';');
			dateSet = date.split(';');
	}
	});	
	
	
	console.log(weightSet[0]);
	console.log(weightSet[1]);
		
	var svgWidth=320;
	var svgHeight=240;
	var dataSet=weightSet;
	
	/* dataSet.push(weightSet[0]);
	dataSet.push(weightSet[1]); */
	
	console.log(dataSet);
	
	
	var margin = svgWidth/(dataSet.length-1);
	
	var line = d3.line()
	.x(function(d,i){
		return i * margin + 30
	})
	.y(function(d,i){
		return (svgHeight -d -90)*2;
	})
	
	
	var lineElements = d3.select("#myGraph")
	.append("path")
	.attr("class","line")
	.attr("d",line(dataSet))
	

	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")
	.attr("width",320)
	.attr("height",1)
	.attr("transform","translate(30,300)")
		
		
	var yScale = d3.scaleLinear()
	.domain([0,150])
	.range([300,0])
	
	
	
	var axis=d3.axisLeft(yScale)
	.ticks(40)
	.tickValues([0,10,20,30,40,50,60,70,80,90,100,110,120,130,140,150]);
	
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	})
</script>
<H1>${vo}</H1>
<input type=submit id='getList' />

<h1>꺽은선 그래프 표시</h1>
	<svg id="myGraph"></svg>
	
	
</body>
</html>