window.addEventListener("load",function(){
	
	
	var svgWidth=320;
	var svgHeight=240;
	var dataSet=[40,10,10,10,10]
	var color = d3.scaleOrdinal(d3.schemeCategory10);//d3.schemeCategory10 : d3에서 지원하는 10가지 색
	
	var pie=d3.pie().value(function(d,i){return d;});
	
	
	var arc = d3.arc().innerRadius(0).outerRadius(100);
	
	var pieElements = d3.select("#myGraph")
	.selectAll("g")
	.data(pie(dataSet))
	.enter()
	.append("g")
	.attr("transform","translate("+svgWidth/2+","+svgHeight/2+")")
	
	
	
	
	pieElements
	.append("path")
	.attr("class","pie")
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
		.attr("transform","translate("+svgWidth/2+","+(svgHeight/2+5)+")")
		.text("합계 : " + d3.sum(dataSet));
	
		//숫자를 부채꼴의 가운데에 표시
	
	pieElements
		.append("text")
		.attr("class","pieNum")
		.attr("transform",function(d,i){
			return "translate("+arc.centroid(d)+")";
		})
		.text(function(d,i){
			return d.value;
		});
		



})
	
	
	
