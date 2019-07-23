window.addEventListener("load",function(){
	var svgHeight=240;
	var svgWidth=320;
	var dataSet =[120,140,160,180,200];
	var margin = svgWidth/(dataSet.length -1);
	
	var line = d3.line()
	.x(function(d,i){
		return i+margin;
	})
	.y(function(d,i){
		return svgHeight-d;
	})
	
	var lineElements =
		d3
		.select("#myGraph")
		.append("path")
		.attr("class","line")
		.attr("d",line(dataSet))
	
	
	})
