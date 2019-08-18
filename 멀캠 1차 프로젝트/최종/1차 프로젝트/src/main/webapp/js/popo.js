window.addEventListener("load",function(){
	
	
	$("#getList").click(function(){
		$.ajax({
			url:"${practice.do}",
			method:"GET",
			success:function(data){
				console.log(data);
			}
		});
		
	})	
})