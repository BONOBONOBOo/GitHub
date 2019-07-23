window.addEventListener("load",function(){
	var svgHeight=300;
	var barElements;
	var dataSet =[120,140,160,180,200,220,240,260,280];
	var offsetX = 30;
	var offsetY = 0;
	
	var dataMax = 300;
	var barWidth = 20;
	var barMargin = 25;
	
	barElements = 
	d3
	.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)
	
	barElements.enter()
	.append("rect")
	.attr("class","bar")
	.attr("height",0)
	.attr("width",barWidth)
	.attr("x",function(d,i){
		return i * (barWidth+barMargin) + 10 + offsetX;
	})
	.attr("y",svgHeight-offsetY)
	.on("mouseover",function(){
		d3.select(this)
		.style("fill","red")
	})
	.on("mouseout",function(){
		d3.select(this)
		.style("fill","orange")
	})
	
	//에니메이션
	.transition()
	.duration(1000)
	.delay(function(d,i){
		return i*100;
	})
	.attr("y",function(d,i){
		return svgHeight -d - offsetY;
	})
	.attr("height",function(d,i){
		return d;
	})
	
	barElements.enter()
		.append("text")
		.attr("class","barNum")
		.attr("x",function(d,i){
			return i * (barWidth+barMargin) + 10 + offsetX;
		})
		.attr("y",svgHeight-5-offsetY)
		.text(function(d,i){
			return d;
		})
		
	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")
	.attr("width",500)
	.attr("height",1)
	//.attr("transform","translate(30,0)")
	.attr("transform","translate("+offsetX+","+(svgHeight-offsetY)+")")
		
	
	barElements.enter()
		.append("text")
		.attr("class","barName")
		.attr("x",function(d,i){
			return i * (barWidth+barMargin) + 10 + offsetX;
		})
		.attr("y",svgHeight+20)
		.text(function(d,i){
			return ["A","B","C","D","E","F","G","H","I","J"][i];
		})
		
	var yScale = d3.scaleLinear()
	.domain([0,dataMax])
	.range([dataMax,0])
	
	var axis=d3.axisLeft(yScale)
	.ticks(10)
	.tickValues([10,20,30,50,100,150,200]);
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	})
