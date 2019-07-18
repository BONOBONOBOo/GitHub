window.addEventListener("load",function(){
	
	var dataSet = [300,150,10,80,230];
	d3
	.select("#myGraph")
	.selectAll("rect")
	.data(dataSet)//데이터 설정
	.enter()//데이터 수에따라 rect 요소 생성
	.append("rect")
	.attr("x",0)
	.attr("y",function(d,i){//순서에따라 데이터의 인자를 구분한다.
		return i*30;
	})
	.attr("width",function(d,i){
		return d+"px"
	})
	.attr("height","20px");
})

//1. 데이터 준비

