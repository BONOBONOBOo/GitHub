window.addEventListener("load",function(){
	
	
	var svgWidth=320;
	var svgHeight=240;
	var dataSet=[40,10,10,10,10]
	var color = d3.scaleOrdinal(d3.schemeCategory10);//d3.schemeCategory10 : d3에서 지원하는 10가지 색
	
	var pie=d3.pie();
	
	var arc = d3.arc().innerRadius(0).outerRadius(100);
	
	var pieElements = d3.select("#myGraph")
	.selectAll("path")
	.data(pie(dataSet));
	
	pieElements.enter()
	.append("path")
	.attr("class","pie")
	.attr("d",arc)
	.attr("transform","translate("+svgWidth/2+","+svgHeight/2+")")
	.style("fill",function(d,i){
		return color(i);
	})
	.transition()
	.duration(1000)
	.delay(function(d,i){
		return i*1000;
	})
	.ease(d3.easeLinear)
	.attrTween("d",function(d,i){		
		
		var interpolate = d3.interpolate(
			{startAngle : d.startAngle,endAngle : d.startAngle},
			{startAngle : d.startAngle,endAngle : d.endAngle}
		);
		return function(t){
			return arc(interpolate(t));
		}
	})
	
	var textElements = 
		d3
		.select("#myGraph")
		.append("text")
		.attr("class","total")
		.attr("transform","translate("+svgWidth/2+","+(svgHeight/2)+5+")")
		.text("합계 : " + d3.sum(dataSet))
	})
	
	
