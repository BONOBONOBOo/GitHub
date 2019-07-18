window.addEventListener("load",function(){
	
	//var dataSet = [300,150,10,80,230];
	
	var dataSet=[ ];
	
	d3.csv("data.csv",function(data){
		dataSet.push(data["item1"]);	
		console.log(dataSet);

	
	/*d3.csv("data.csv")
	.then(function(data){
	for(var i=0;i<data.length;i++){
		dataSet.push(data[i].item1);
	}*/
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
	});

});	


	
	
	d3
	.select("#updateButton")
	.on("click",function(){
		for(var i=0;i<dataSet.length;i++){
			dataSet[i] = Math.floor(Math.random()*320);
		}
		d3.select("#myGraph")
		.selectAll("rect")
		.data(dataSet)//데이터 설정'
		.transition()
		.attr("width",function(d,i){
			return 30+d+"px";
		});
	});
	
	




//1. 데이터 준비

