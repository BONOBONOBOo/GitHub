
window.addEventListener("load",function(){
	
	
	
	var weightSet;
	var dateSet;
	
	$.ajax({
		url:"getWeight.do",	
		method:"GET",
		async:false,
		success:function(data){
			console.log("들어가나");
			console.log(data);
			
			var obj = JSON.parse(data);
			
		
			var weight = obj.result[0].weight;
			var date = obj.result[1].date;
			
			weightSet = weight.split(';');
			dateSet = date.split(';');
	}
	});	
	
		
	var svgWidth=320;
	var svgHeight=240;
	
	var WeightMax;
	var WeightMin;
	
	var tickVal =[];
	
	var rangeVal=300;
	var domainVal=150;
	
	
	console.log("weightSet = "+weightSet);
	console.log("dateSet = "+dateSet);
	
	
	WeightMax = Math.ceil((Math.max.apply(null,weightSet))/10)*10+10;
	WetightMin = Math.floor((Math.min.apply(null,weightSet))/10)*10-10;
	
	domainVal = WeightMax- WetightMin;
	
	console.log("max = "+WeightMax);
	console.log("min = "+WetightMin);
	
	for(var i = WetightMin;i<=WeightMax;i+=10){
		tickVal.push(i);
	}
	
	console.log("tickVal = "+tickVal);
	
	
	
	
	
	var margin = svgWidth/(weightSet.length-1);
	
	var line = d3.line()
	.x(function(d,i){
		return i * margin + 60
	})
	.y(function(d,i){
		return (domainVal -d+(WetightMin+10))*(rangeVal/domainVal);
	})
	//svgHeight=240
	
	var lineElements = d3.select("#myGraph")
	.append("path")
	.attr("class","line")
	.attr("d",line(weightSet))
	

	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")
	.attr("width",320)
	.attr("height",1)
	.attr("transform","translate(30,300)")
		
		
	
	
	
	var yScale = d3.scaleLinear()
	.domain([0,domainVal])
	.range([rangeVal,0])
	
	
	
	var axis=d3.axisLeft(yScale)
	.ticks(20)
	.tickValues(tickVal);
	
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	})
	
	
	
	function changeA(){
	var weight1=document.getElementById("weightValue").innerHTML;
	
	 $(weight).replaceWith($("<input id=inputWeight name=inputWeight onclick=EmpytInput() style='color:black;width:100px' onkeypress='if(event.keyCode==13) {ChangeWeight(); return false;}' value="+weight1+">"));
	
	}
	
	function EmpytInput(){
		document.getElementById("inputWeight").value="";
	}
	
	function ChangeWeight(){

		document.editWeightFrom.action="./myaccount.do";
		document.editWeightFrom.method="post";
		document.editWeightFrom.submit(); 
	}
	
	
	
