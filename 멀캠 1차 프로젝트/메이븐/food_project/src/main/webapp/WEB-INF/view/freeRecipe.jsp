<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>하루세끼</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

  <!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Flexslider  -->
	<link rel="stylesheet" href="css/flexslider.css">
	<!-- Flaticons  -->
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="css/bootstrap-datepicker.css">

	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	
	<script src="js/jquery.min.js"></script>
	
	<!-- <script src="js/Account.js"></script> -->
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
		
	<style>
	.emptyheart{
		  background: url('images2/like3.png') no-repeat right 0;
		  background-size: auto 100%;
		  width: 60px;
		  height: 60px;
		  display: inline-block;
		  text-indent: -9999px;
		  cursor: pointer;
		}
		
	.fullheart{
		  background: url('images2/like6.png') no-repeat right 0;
		  background-size: auto 100%;
		  width: 60px;
		  height: 60px;
		  display: inline-block;
		  text-indent: -9999px;
		  cursor: pointer;
		}
	</style>
	<script>
	$(document).ready(function(){
	$.ajax({
		url:"getRecipeAll.do",	
		method:"GET",
		async:false,
		
		success:function(data){
			var obj = JSON.parse(data);
			
			
			
			for(var i = 0;i<9;i++){
				var clas = document.getElementById(i+"").childNodes[1].childNodes[3];
					
				
				
				clas.childNodes[1].setAttribute('style','background-image: url('+obj.result[i][2]["url"]+')');
				clas.childNodes[3].innerHTML = "<a href='./detail_recipe.do?detailVO="+obj.result[i][0]['recipename']+"'>"+obj.result[i][0]['recipename']+"</a>";
				
				
				var star = document.getElementById(i+"").childNodes[1].childNodes[1].childNodes[0];
				if(obj.result[i][3]['flag'] == "0"){
					star.setAttribute("class","emptyheart");	
				}
				else{
					star.setAttribute("class","fullheart");
				}
				
			}
			
			}
		
	});	
	
	})
	
	
	
	function ajaxgogo(){
		$.ajax({
			url:"getfavoriteList.do",
			method:"GET",
			async:false,
			success:function(data){
				
				var obj = JSON.parse(data);
				
				console.log(data);
				
				for(var i = 0;i<9;i++){
					var clas = document.getElementById(i+"").childNodes[1].childNodes[3];
					clas.childNodes[1].setAttribute('style','background-image: url('+obj.result[i][2]["url"]+')');
					clas.childNodes[3].innerHTML = "<a href='./detail_recipe.do?detailVO="+obj.result[i][0]['recipename']+"'>"+obj.result[i][0]['recipename']+"</a>";
					
					var star = document.getElementById(i+"").childNodes[1].childNodes[1].childNodes[0];
					if(obj.result[i][3]['flag'] == "0"){
						star.setAttribute("class","emptyheart");	
					}
					else{
						star.setAttribute("class","fullheart");
					}
				}
				}
		});	
		
	}
	
	function getStarsum(){
					
			$.ajax({
				url:"getStarsum.do",
				method:"GET",
				async:false,
				success:function(data){
					
					var obj = JSON.parse(data);
					
					console.log(data);
					
					for(var i = 0;i<9;i++){
						var clas = document.getElementById(i+"").childNodes[1].childNodes[3];
						clas.childNodes[1].setAttribute('style','background-image: url('+obj.result[i][2]["url"]+')');
						clas.childNodes[3].innerHTML = "<a href='./detail_recipe.do?detailVO="+obj.result[i][0]['recipename']+"'>"+obj.result[i][0]['recipename']+"</a>";
						
						var star = document.getElementById(i+"").childNodes[1].childNodes[1].childNodes[0];
						if(obj.result[i][3]['flag'] == "0"){
							star.setAttribute("class","emptyheart");	
						}
						else{
							star.setAttribute("class","fullheart");
						}
					}
					}
			});	
		}
	
	
	function getCommentOrder(){
		console.log("들어감");		
		$.ajax({
			url:"getCommentOrder.do",
			method:"GET",
			async:false,
			success:function(data){
				
				var obj = JSON.parse(data);
				
				console.log(data);
				
				for(var i = 0;i<9;i++){
					var clas = document.getElementById(i+"").childNodes[1].childNodes[3];
					clas.childNodes[1].setAttribute('style','background-image: url('+obj.result[i][2]["url"]+')');
					clas.childNodes[3].innerHTML = "<a href='./detail_recipe.do?detailVO="+obj.result[i][0]['recipename']+"'>"+obj.result[i][0]['recipename']+"</a>";
					
					var star = document.getElementById(i+"").childNodes[1].childNodes[1].childNodes[0];
					if(obj.result[i][3]['flag'] == "0"){
						star.setAttribute("class","emptyheart");	
					}
					else{
						star.setAttribute("class","fullheart");
					}
				}
				}
		});	
	}
	
	</script>
	
	<body>

	<nav id="colorlib-main-nav" role="navigation">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle active"><i></i></a>
		<div class="js-fullheight colorlib-table">
			<div class="colorlib-table-cell js-fullheight">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<input type="text" class="form-control" id="search" placeholder="Enter any key to search...">
							<button type="submit" class="btn btn-primary"><i class="icon-search3"></i></button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 text-center">
						<ul>
							<c:if test="${vo.userid eq null}">
							<li><a href="login.do">로그인</a></li>
							<li><a href="join.do">회원가입</a></li>
							</c:if>
							<li><a href="freeRecipe.do">자유 레시피</a></li>
							<li class="active"><a href="index.do">레시피 조회</a></li>
							
							<c:if test="${vo.userid ne null}">
							<li><a href="myaccount.do">내 정보</a></li>
							<li><a href="logout.do">로그아웃</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	
	<div id="colorlib-page">
		<header>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="colorlib-navbar-brand">
							<a class="colorlib-logo" href="index.html"><i class="flaticon-cutlery"></i><span>하루</span><span>세끼</span></a>
						</div>
						<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
					</div>
				</div>
			</div>
		</header>
		<aside id="colorlib-hero">
			<div class="flexslider">
				<ul class="slides">
			   	<li style="background-image: url(images/img_bg_1.jpg);" data-stellar-background-ratio="0.5">
			   		<div class="overlay"></div>
			   		<div class="container-fluid">
			   			<div class="row">
				   			<div class="col-md-6 col-sm-12 col-xs-12 col-md-offset-3 slider-text">
				   				<div class="slider-text-inner text-center">
				   					<div class="desc">
				   						<span class="icon"><i class="flaticon-cutlery"></i></span>
					   					<h1>자유 레시피</h1>
					   					<p><span><a href="index.html">레시피</a></span> <span>를 공유해요!</span></p>
					   					<div class="desc2"></div>
				   					</div>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
			  	</ul>
		  	</div>
		</aside>

		

		<div class="colorlib-menu">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<span class="icon"><i class="flaticon-cutlery"></i></span>
						<h2>자유 레시피</h2>
						<p>다른 회원의 레시피를 구경하고 자신의 레시피를 자랑해봐요!!</p>
						<table style="margin:auto; width:555px" >
						<tr>
						<td style="width:33%"><a onclick="ajaxgogo()">즐겨찾기</a></td>
						<td style="width:33%"><a onclick="getStarsum()">별점</a></td>
						<td style="width:33%"><a onclick="getCommentOrder()">댓글</a></td>
						</tr>
						</table>
					</div>
				</div>
				
				
				<div  class="row">
					<div id="0" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-1.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Strawberry Dish</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="1" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-2.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Pizza with strawberries</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="2" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-3.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Grilled Beef</a></h2>
								</div>
							</div>
						</div>
					</div>

					<div id="3" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-4.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Strawberry Dish</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="4" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-5.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Pizza with strawberries</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="5" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-6.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Grilled Beef</a></h2>
								</div>
							</div>
						</div>
					</div>

					<div id="6" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-7.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Strawberry Dish</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="7" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-8.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Pizza with strawberries</a></h2>
								</div>
							</div>
						</div>
					</div>
					<div id="8" class="col-md-4 animate-box">
						<div class="dish-wrap">
							<p class="price"><span onclick='' class="emptyheart"></span></p>
							<div class="wrap">
								<div class="dish-img" style="background-image: url(images/dish-9.jpg);"></div>
								<div class="desc">
									<h2><a href="#">Luto Grilled Beef</a></h2>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>

		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-3 col-pb-sm">
							<h2>Lutong Bahay</h2>
							<p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind.</p>
							<p class="colorlib-social-icons">
								<a href="#"><i class="icon-facebook4"></i></a>
								<a href="#"><i class="icon-twitter3"></i></a>
								<a href="#"><i class="icon-googleplus"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
							</p>
						</div>
						<div class="col-md-3 col-pb-sm">
							<h2>Latest Blog</h2>
							<div class="f-entry">
								<a href="#" class="featured-img" style="background-image: url(images/dish-5.jpg);"></a>
								<div class="desc">
									<span>May 5, 2018</span>
									<h3><a href="#">How to cook beef Grilled with potato</a></h3>
								</div>
							</div>
							<div class="f-entry">
								<a href="#" class="featured-img" style="background-image: url(images/dish-7.jpg);"></a>
								<div class="desc">
									<span>May 5, 2018</span>
									<h3><a href="#">A Japanese Master Chef</a></h3>
								</div>
							</div>
							<div class="f-entry">
								<a href="#" class="featured-img" style="background-image: url(images/dessert-3.jpg);"></a>
								<div class="desc">
									<span>May 5, 2018</span>
									<h3><a href="#">Special Recipe for this month</a></h3>
								</div>
							</div>
						</div>
						<div class="col-md-3 col-pb-sm">
							<h2>Instagram</h2>
							<div class="instagram">
								<a href="#" class="insta-img" style="background-image: url(images/dessert-1.jpg);"></a>
								<a href="#" class="insta-img" style="background-image: url(images/dessert-2.jpg);"></a>
								<a href="#" class="insta-img" style="background-image: url(images/dish-9.jpg);"></a>
								<a href="#" class="insta-img" style="background-image: url(images/dish-2.jpg);"></a>
							</div>
						</div>
						<div class="col-md-3 col-pb-sm">
							<h2>Newsletter</h2>
							<p>A small river named Duden flows by their place and supplies it with the necessary regelialia</p>
							<div class="subscribe text-center">
								<div class="form-group">
									<input type="text" class="form-control text-center" placeholder="Enter Email address">
									<input type="submit" value="Subscribe" class="btn btn-primary btn-custom">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-center">
							<p>
								<span class="block">&copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --><br></span> 
								<span class="block">Demo Images: <a href="http://unsplash.com/" target="_blank">Unsplash</a> &amp; <a href="https://www.pexels.com/" target="_blank">Pexel</a></span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</footer>
	
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Owl Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>

	</body>
</html>

