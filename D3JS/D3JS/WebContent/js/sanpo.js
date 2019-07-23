window.addEventListener("load",function(){
	var svgWidth = 320;
	var svgHeight = 240;
	var offsetX = 30;
	var offsetY = 20;
	var svg = d3.select("#myGrapy");
	
	
	var dataSet=[
			[30.2,40],[120.32,115],[125.32,90],[150.11,160],[300.232,190],
			[60.32,40],[140.32,145],[165.22,110],[200.23,170],[250.222,193]]
	
	var circleElements = svg.selectAll("circle").data(dataSet);
	
	var circleElements =
		d3
		.select("#myGrapy")
		.selectAll("circle")
		.data(dataSet)
		.enter()
		.append("circle")
		.attr("class","mark")
		.attr("cx",function(d,i){
			return d[0]+offsetX;
		})
		.attr("cy",function(d,i){
			return svgHeight-d[1]-offsetY;
		})
		.attr("r",5)
		
		
	//축
	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")	
	.attr("width",500)
	.attr("height",1)
	//.attr("transform","translate(30,0)")
	.attr("transform","translate("+offsetX+","+(svgHeight-offsetY)+")")
	drawScale();	
	
	
	
	
	
	
	
	
	
	
	
	function updateData(data){
		var result = data.map(function(d,i){
			var x = Math.random()*svgWidth;
			var y = Math.random()*svgHeight;
			return [x,y];
		})
		
		return result;
	}
	
	function updateGraph(dataSet){
		d3.select("#myGraph").selectAll("*").remove();
		circleElements = d3.select("#myGraph").selectAll("circle").data(dataSet);
		circleElements.enter()
		.append("circle")
		.attr("class","mark")
		.attr("cx",function(d,i){
			return d[0]+offsetX;
		})
		.attr("cy",function(d,i){
			return svgHeight-d[1]-offsetY
		})
		.attr("r",5)	
	}
	
	function drawScale(){
		d3.select("#myGraph").selectAll("g").remove();
		var maxX = d3.max(dataSet,function(d,i){
			return d[0]
		});
		
		var maxY = d3.max(dataSet,function(d,i){
			return d[1]
		});
		
		var yScale = d3.scaleLinear().domain([0,maxY]).range([maxY,0])
		var axis = d3.axisLeft(yScale);
		
		d3.select("#myGraph")
		.append("g")
		.attr("class","axis")
		.attr("transform","translate("+offsetX+","+(svgHeight-maxY-offsetY)+")")
		.call(axis)
		
		
		
		var xScale = d3.scaleLinear().domain([0,maxX]).range([0,maxX])
		var bottomAxis = d3.axisBottom(xScale);
		
		d3.select("#myGraph")
		.append("g")
		.attr("class","axis")
		.attr("transform","translate("+offsetX+","+(svgHeight-offsetY)+")")
		.call(bottomAxis)
		
		var grid = svg.append("g")
		var rangeX = d3.range(50,maxX,50);
		var rangeY = d3.range(20,maxY,20);
	
		grid.selectAll("line.y")
		.data(rangeY)
		.append("line")
		.attr("class","grid")
		.attr("x1",offsetX)
		.attr("y1",function(d,i){
			return svgHeight - d - offsetY;
		})
		.attr("x2",maxX + offsetX)
		.attr("y2",function(d,i){
			return svgHeight -d -offsetY;
		})
		
		grid.selectAll("line.x")
		.data(rangeX)
		.enter()
		.append("line")
		.attr("class","grid")
		.attr("x1",function(d,i){
			return d + offsetX;
		})
		.attr("y1",svgHeight-offsetY)
		.attr("x2",function(d,i){
			return d + offsetX;
		})
		.attr("y2",svgHeight-offsetY-maxY)
			
		}
	
	
	var tooltip = d3.select("body")
	.append("div").attr("class","tip")
	
	function showToolTip(){
		corcleElements = d3.select("#myGraph")
		.selectAll("circle")
		
		circleElements.on("mouseover",function(d){
			var x = parseInt(d[0]);
			var y = parseInt(d[1]);
			var data = d3.select(this).datum();
			var dx = parseInt(data[0]);
			var dy = parseInt(data[1]);
			
			tooltip
			.style("left",offsetX+x+"px")
			.style("top",svgHeight+offsetY-y+"px")
			.style("visibleity","visible")
			.text(dx+","+dy)
		})
		
		circleElements.on("mouseout",function(){
			tooltip.style("visibleity","hidden")
		})
	}
	showToolTip()
	
	setInterval(function(){
		dataSet = updateData(dataSet);
		updateGraph(dataSet);
		drawScale();
		
	},2000);
	
	
})
