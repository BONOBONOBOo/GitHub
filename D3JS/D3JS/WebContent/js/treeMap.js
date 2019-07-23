window.addEventListener("load",function(){

	var width = document.querySelector("svg").clientWidth;
	var height = document.querySelector("svg").clientHeight;
	
	var data = {
			"name":"A",
				"clildren":[
					{"name":"B","value":25},
					{"name":"C",
					"clildren":[
						{"name":"D","value":10},
						{"name":"E","value":15},
						{"name":"F","value":10}
					]
					},
					{"name":"G","value":15},
					{"name":"H",
						"chileren":[
							{"name":"I","value":20},
							{"name":"J","value":10}
						]
					},
					{"name":"K","value":10}
			]
	};
			
		root = d3.hierarchy(data);
		root
		.sum(function(d){return d.value})
		.sort(function(a,b){return b.height - a.height || b.value-a.value; });
	
		var treemap = d3.treemap()
		.size([width,height])
		.padding(1)
		.round(true);
		
		treemap(root);
		
		var g = d3.select("svg")
		.selectAll(".node")
		.data(root.leaves())
		.enter()
		.append("g")
		.attr("class","node")
		.attr("transform",function(d){return "translate("+d.x0+","+d.y0+")";});
		
		g.append("rect")
		.style("width",function(d){return d.x1-d.x0;})
		.style("height",function(d){return d.y1-d.y0;})
		.style("fill",function(d){
			while(d.depth>1) d=d.parent;
			return d3.schemeCategory10[parseInt(d.value % 7)];
		})
		.style("opacity",0.6)
	
		g.append("text")
		.attr("text-anchor","start")
		.attr("x",5)
		.attr("dy",30)
		.attr("font-size","150%")
		.attr("class","node-label")
		.text(function(d){return d.data.name+":"+d.value});
		
	
});