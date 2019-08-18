<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Luto Template</title>
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
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	
	<![endif]-->
	<script src="js/jquery.min.js"></script>
	
	
	
	<style>
	.starR{
		  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		  background-size: auto 100%;
		  width: 60px;
		  height: 60px;
		  display: inline-block;
		  text-indent: -9999px;
		  cursor: pointer;
		}
		
	.samllstarR{
		  background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
		  background-size: auto 100%;
		  width: 20px;
		  height: 20px;
		  display: inline-block;
		  text-indent: -9999px;
		  cursor: pointer;
		}
		
		
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
	
	<script type="text/javascript">
	function addcomment(){
		
		if(${vo eq null}){
			alert('로그인을 해주세요.');
			return 0;
		}
		
		document.commentForm.action="./addComment.do";
		document.commentForm.method="post";
		document.commentForm.submit();
	}
	
	function addFavorite(){
		
		if(${vo ne null}){
			var current = document.getElementById("like").className;
			var recipe_code = ${Recipe.recipe_code};
			var userid = '${vo.userid}';
			
			$.ajax({
				url:"addFavorite.do",
				type:"POST",
				data:{userid:userid,recipe:recipe_code},
				dataType:"text"
			})
			
			if(current == 'fullheart'){
				document.getElementById("like").className = "emptyheart";
			}
			else{
				document.getElementById("like").className = "fullheart";
			}
		}
		else{
			alert('로그인을 해주세요.');
		}
		
		
	}
	</script>
	
	
	</head>
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
							<li><a href="reservation.html">자유 레시피</a></li>
							<li class="active"><a href="index.do">레시피 조회</a></li>
							
							<c:if test="${vo.userid ne null}">
							<li><a href="menu.html">내 정보</a></li>
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
							<a class="colorlib-logo" href="index.do"><i class="flaticon-cutlery"></i><span>하루</span><span>세끼</span></a>
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
				   						<div style="width:25; height:25">
										
										<c:if test="${favorite eq '0' || vo eq null}">
											<span id=like onclick='addFavorite()' class="emptyheart"></span>
										</c:if>
										
										<c:if test="${favorite eq '1'}">
											<span id=like onclick='addFavorite()' class="fullheart"></span>
										</c:if>
										
										
										
				   						
				   						</div>
				   						
			
										<!-- 테이블 넣을곳 -->
										<table style="margin:auto;">
					   					<tr>
					   					<td rowspan="2" style="color:white">
					   					<img src="${Recipe.img_url}" width="100" height="200">
					   					</td >
					   					
					   					<td align="center" style="height:50%;width:400px;color:white;">
					   					<font size=6>${Recipe.recipe_name}</font>
					   					</td>
					   					</tr>
					   					
					   					<tr>
					   					<td align="center" style="height:50%;width:400px;color:white;">
											<c:forEach var="i" begin="1" end="${star}" step="1" >
											<span class="starR">별</span>
											</c:forEach>
										</td>
					   					</tr>

					   					</table>
				   					</div>
				   				</div>
				   			</div>
				   		</div>
			   		</div>
			   	</li>
			  	</ul>
		  	</div>
		</aside>

		<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<div>
						<table style="width:555px;margin:auto">
						<tr><td align="left" colspan="2"><font size=5 color=orange>기본 정보</font></td></tr>
						
						<tr style="height:30px"></tr>
						
						<tr >
						<td align="left" style="width:20%"><font size=3 style="font-weight:bolder">음식 분류 :</font></td>
						<td align="left" style="width:80%">${Recipe.food_category}</td>
						</tr>
						
						<tr>
						<td align="left" style="width:20%"><font size=3 style="font-weight:bolder">시간 :</font></td>
						<td align="left" style="width:80%">${Recipe.runtime}</td>
						</tr>
						
						<tr>
						<td align="left" style="width:20%"><font size=3 style="font-weight:bolder">열량 :</font></td>
						<td align="left" style="width:80%">${Recipe.total_cal} kacl</td>
						</tr>
						</table>
               <br>
               <br>
               		 <table style="width:555px;margin:auto">
						<tr><td align="left"><font size=5 color=orange>요리 과정</font></td></tr>
						
						<tr style="height:50px"></tr>
						
						<c:forEach var="i" begin="0" end="${ordernum}" step="1" >
								<tr><td align="left">${recipeOrder[i]}</td></tr>
								<tr style="height:15px"></tr>			
						</c:forEach>
					 </table>
               </div>
			</div>
		</div>				
	</div>
</div>

<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<div>
               		<table style="width:555px;">
               		<tr><td align="left"><font color=orange size=4>댓글</font></td></tr>
               		<tr style="height:30px"></tr>
               		
               		<c:forEach var="comment" items="${comment}" varStatus="status">
               		<tr>
               		
               		<td align="center" style="display:flex; width:150px;">
               		<c:forEach var="i" begin="1" end="${comment.rating*1}" step="1" >
					<span class="samllstarR on">별</span>
					
					</c:forEach>
               		</td>
               		<td align=left style="width:60%">${comment.recipe_comment}</td>
               		<td style="width:10%">${comment.userid }</td>
               		</tr>
					</c:forEach>
					
					<tr style="height:30px"></tr>
               		</table>
               		
               		<form id=commentForm name=commentForm>
               		<table style="width:555px;">
					<tr>
					<td align="center" style="display:flex; width:150px;">
					<select name="rating" id="rating" style="width:100px; opacity:0.9;">
                      	  <option value="5" selected="selected">★★★★★</option>
						  <option value="4">★★★★</option>
						  <option value="3">★★★</option>
						  <option value="2">★★</option>
						  <option value="1">★</option>
					</select>
					
					
					</td>
					<td align=left style="width:60%">
					<input name=recipe_comment id=recipe_comment value="">
					</td>
					
					<td style="width:20%">
					<input type=hidden name=recipe_name id=recipe_name value="${Recipe.recipe_name}">
					<c:if test="${vo ne null}">
					<input type=hidden name=userid id=userid value="${vo.userid}">
					</c:if>
					<a onclick="addcomment()">댓글작성</a>
					</td>
					</tr>
					</table>
					</form>
					
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
	<!-- Google Map -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="js/google_map.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="js/main.js"></script>

	</body>
</html>

