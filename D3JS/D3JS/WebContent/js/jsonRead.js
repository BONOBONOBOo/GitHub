window.addEventListener("load",function(){
	
	var dataSet=[ ];
	
		d3.json("data.json").then(function(data){
		for(var i=0;i<data.length;i++){
			dataSet.push(data[i].sales[0]);
		}
		
	console.log(dataSet)
	d3
	.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)//데이터 설정
	.enter()//데이터 수에따라 rect 요소 생성
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
		
});

