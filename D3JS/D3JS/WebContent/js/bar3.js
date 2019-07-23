window.addEventListener("load",function(){
	var svgHeight=300;
	var barElements;
	var dataSet =[120,140,160,180,200,220,240,260,280];
	var offsetX = 30;
	var offsetY = 0;
	
	var dataMax = 300;
	var Width = 20;
	var barMargin = 25;
	
	barElements = 
	d3
	.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)
	
	barElements.enter()
	.append("rect")
	.attr("class","bar")
	.attr("height",function(d,i){
		return d;
	})
	.attr("width",20)
	.attr("x",function(d,i){
		return i*barMargin + 60;
	})
	.attr("y",function(d,i){
		return svgHeight - d;
	})
	
	barElements.enter()
		.append("text")
		.attr("class","barNum")
		.attr("x",function(d,i){
			return i * barMargin + 60;
		})
		.attr("y",svgHeight-5)
		.text(function(d,i){
			return d;
		})
		
	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")
	.attr("width",320)
	.attr("height",1)
	//.attr("transform","translate(30,0)")
	.attr("transform","translate("+offsetX+","+(svgHeight-offsetY)+")")
		
	barElements.enter()
		.append("text")
		.attr("class","barName")
		.attr("x",function(d,i){
			return i * 40 + 60;
		})
		.attr("y",svgHeight+20)
		.text(function(d,i){
			return ["A","B","C","D","E"][i];
		})
		
	var yScale = d3.scaleLinear()
	.domain([0,300])
	.range([300,0])
	
	var axis=d3.axisLeft(yScale)
	.ticks(10)
	.tickValues([20,40,60,80,100,120,140]);
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
		
	
	})
