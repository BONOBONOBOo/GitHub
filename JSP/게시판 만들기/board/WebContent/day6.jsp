<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
/* 	$(document).ready(function(){
		$('img').css('width',200);
		$('div').append($('img').clone());
		
		$('#btn1').on("click",function(){
			$("p:first").replaceWith("Hello world!")
		})
		
		$('#btn2').click(function(){
			
		})
		
	}); */
	
	$(document).ready(function(){
		
		$('p').on("click",function(){
			$(this).html(function(index,html){
				return html + "*";
			})
		})
		
		setInterval(function(){
			$('p').last().trigger('click');
		},1000);
		/* $('h2').on({
			mouseenter : function(){$(this).addClass("reverse")},
			mouseleave : function(){$(this).removeClass("reverse")}
		}) */
		$('h2').hover(
				function(){
					$(this).addClass('reverse')
				},	
				function(){
					$(this).removeClass('reverse')
				}
				
				)
	})
	
	
		
	
</script>
</head>
<style>
.reverse{
background: black;
}

</style>
<body>
<div>
	<img src="1010.jpg"/><br>
	
	<input type=button id=btn1 value=1><br>
	<input type=button id=btn2 value=2><br>
	<input type=button id=btn3 value=3><br>
	<input type=button id=btn4 value=4><br>
	
	<p>123</p><br>
	<h2>Hello world!</h2><br>
</div>
	
</body>
</html>