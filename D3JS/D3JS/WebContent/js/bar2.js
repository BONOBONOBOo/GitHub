window.addEventListener("load",function(){
	var svgHeight=300;
	var barElements;
	var dataSet =[120,140,160,180,200];
	
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
		return i*40 + 60;
	})
	.attr("y",function(d,i){
		return svgHeight - d;
	})
	
	barElements.enter()
		.append("text")
		.attr("class","barNum")
		.attr("x",function(d,i){
			return i * 40 + 60;
		})
		.attr("y",svgHeight-5)
		.text(function(d,i){
			return d;
		})
		
	var yScale = d3.scaleLinear()
	.domain([0,300])
	.range([300,0])
	
	var axis=d3.axisLeft(yScale);
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
		
	
	})
