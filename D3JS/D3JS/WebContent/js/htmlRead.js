window.addEventListener("load",function(){
	
		d3.html("data.html")
		.then(function(docFragment){
			var tr=docFragment.querySelectorAll("table tr");
			var dataSet=[ ];
		for(var i=0;i<tr.length;i++){
			var d = tr[i].querySelectorAll("td")[0].firstChild.nodeValue;
			dataSet.push(d);
		}
		//console.log(dataSet);

	d3
	.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)//데이터 설정
	.enter()	//데이터 수에따라 rect 요소 생성
	.append("rect")
	.on("click",function(){
		d3.select(this)
		.style("fill","green");
	})
	.attr("x",0)
	.attr("y",function(d,i){//순서에따라 데이터의 인자를 구분한다.
		return 30+i*30;
	})
	.attr("width",function(d,i){
		return d+"px";
	})
	.attr("height","20px")
	});//받아오기 끝
	
	var xScale = d3.scaleLinear()    //선형 스케일 설정
    .domain([0, 300])                //원래 데이터 범위
    .range([0, 300])                   //실제 출력 크기

    /*d3.select("#myGraph")
    .append("g")
    .attr("class","axis")
    .attr("transform","translate(10,"+((1+dataSet.length) * 20+5)+")")
    .call(d3.axisBottom(xScale))*/
    
    var axis = d3.axisTop(xScale);
    console.log(dataSet.length);
	
	
    d3.select("#myGraph")
    .attr("width",400)
    .attr("height",400)
    .append("g")
    .attr("class","axis")
    .attr("transform","translate(10,"+((1+dataSet.length)*200+5)+")")
    //.call(d3.axisBottom(xScale))
    .call(axis);


});

