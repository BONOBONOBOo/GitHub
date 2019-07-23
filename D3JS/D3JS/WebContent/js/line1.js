window.addEventListener("load",function(){
	
	
	
	var svgWidth=320;
	var svgHeight=240;
	var dataSet =[120,20,60,160,10];
	
	var margin = svgWidth/(dataSet.length-1);
	
	var line = d3.line()
	.x(function(d,i){
		return i * margin + 30
	})
	.y(function(d,i){
		return svgHeight-d +60;
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
	.domain([0,300])
	.range([300,0])
	
	var axis=d3.axisLeft(yScale)
	.ticks(10)
	.tickValues([0,20,40,60,80,100,120,140,160,180,200]);
	
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	
	
	
	
	
	})
