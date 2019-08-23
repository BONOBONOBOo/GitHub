window.addEventListener("load",function(){
	
	
	
	var svgWidth=320;
	var svgHeight=240;
	var dataSet=[];
	
	
	for(var i = 0;i<10;i++){
		dataSet[i] = Math.floor(Math.random() * 100);
	}
	
	
	var margin = svgWidth/(dataSet.length-1);
	
	var line = d3.line()
	.x(function(d,i){
		return i * margin + 30
	})
	.y(function(d,i){
		return svgHeight-d +60;
	})
	
	
	/*var lineElements = d3.select("#myGraph")
	.append("path")
	.attr("class","line")
	.attr("d",line(dataSet))
	.on("mouseover",function(d,i){
		document.getElementById('lineValue').innerHTML = d;
	})*/
	
	var lineElements = 
		d3.select("#myGraph")
		.selectAll("path")
		.data(dataSet)
		.enter()
		.append("path")
		.attr("class","line")
		.attr("d",line(dataSet))
		.on("mouseover",function(d,i){
			//d3.select(this).innerHTML = d;
			document.getElementById('lineValue').innerHTML = dataSet[i];
		
	})
	
		
	
	
		
	
	
	
	
	

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
	.ticks(6)
	.tickValues([0,20,40,60,80,100]);
	
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	
	
	
	
	
	})
