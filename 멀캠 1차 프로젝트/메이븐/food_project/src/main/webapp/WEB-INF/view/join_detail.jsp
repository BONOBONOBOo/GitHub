<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script type="text/javascript">
	
	function avgWeight(bmi){
		
		var height = document.getElementById("userHeight").innerHTML;
		var ine = Math.round(height*height*bmi);
		
		document.getElementById("resultWeight").innerHTML = ine;
		document.getElementById("userKg").innerHTML = ine;
	}
	function kcal(kk){
		var ine = document.getElementById("userKg").innerHTML;
		var avgkcal =  ine * kk;
		
		console.log(avgkcal);
		
		document.getElementById("userKcal").innerHTML = kk;
		document.getElementById("userResultKcal").innerHTML = avgkcal;
		document.getElementById("pp").value = avgkcal;
		
		console.log(document.getElementById("pp").value);
		
	}
	function join(){
		var pp = document.getElementById("pp").value;
		
		
		location.href="join_detail.do?userResultKcal="+pp+"&userid=${userinfo.userid}";
	}
	function cancel(){
		location.href="index.do";
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
							<li><a href="index.html">Home</a></li>
							<li><a href="menu.html">menus</a></li>
							<li><a href="specialties.html">specialties</a></li>
							<li><a href="reservation.html">Reservation</a></li>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="about.html">About us</a></li>
							<li class="active"><a href="contact.html">Contact</a></li>
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
							<a class="colorlib-logo" href="index.html"><i class="flaticon-cutlery"></i><span>Lu</span><span>to</span></a>
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
			<table style="margin:auto;">
		   
		   <h3 style="color:white; font-family:;">상세 회원가입</h3>
		   
                 
                 <tr style="padding-top: 50px;" align="center">
                 
                    	<td style="color:white;">
                    		키 : 
	                    <label style="color:white;">${userinfo.height}</label>
	                    	몸무게 : 
	               	    <label style="color:white;">${userinfo.weight}</label>
	                  		bmi : 
	                    <label style="color:white;">${userinfo.bmi}</label>
                    </td>
               </tr>
               <tr style="width:10px"></tr>
               <tr>
               <td>
               <table width="555" style="border: 1px solid #ffffff;color:white" >
               <tr style="border: 1px solid #ffffff;">
               <td>BMI에 의한 비만도 판정</td>
               <td>수치상</td>
               <td>겉보기</td>
               </tr>
               <tr>
               <td>마른편</td>
               <td>20 미만</td>
               <td>18 이하</td>
               </tr>
               <tr>
               <td>보통</td>
               <td>20~24</td>
               <td>18~22</td>
               </tr>
               <tr>
               <td>약간 비만</td>
               <td>24~26.5</td>
               <td>22~24</td>
               </tr>
               <tr>
               <td>비만</td>
               <td>26.5 이상</td>
               <td>24 이상</td>
               </tr>
               </table>
               <tr height="50px"/>
               
               <c:if test="${userinfo.sex eq 'male'}">
               <tr>
               <td width="555px">
               <img src="images/ManBMI.jpg" width="555px"/>
               </td>
               </tr>
               </c:if>
               <c:if test="${userinfo.sex eq 'female'}">
               <tr>
               <td width="555px">
               <img src="images/WomanBMI.jpg" width="555px"/>
               </td>
               </tr>
               </c:if>
               
               <tr height="50"></tr>
          		<tr>
          		<td>
          		<table style="color:white; margin:auto;" width="555">
          		
          		<tr>
          		<td width="100">키</td>
          		<td>키&nbsp;</td>
          		<td style="margin:auto;" align="center">본인이 원하는 bmi</td>
          		<td>표준 체중</td>
          		</tr>
          		<tr style="height:100px;">
          		<td><label id=userHeight value=1.8>${userinfo.height/100}</label></td>
          		
          		<td><label >${userinfo.height/100}</label></td>
          		
          		<td align="center">
          			<input type="radio" name="chk_info" style="vertical-align: middle" value="18" onclick='avgWeight(18)'>18<br>
					<input type="radio" name="chk_info" style="vertical-align: middle" value="19" onclick='avgWeight(19)'>19<br>
					<input type="radio" name="chk_info" style="vertical-align: middle" value="20" onclick='avgWeight(20)'>20<br>
					<input type="radio" name="chk_info" style="vertical-align: middle" value="21" onclick='avgWeight(21)'>21<br>
					<input type="radio" name="chk_info" style="vertical-align: middle" value="22" onclick='avgWeight(22)'>22<br>
					<input type="radio" name="chk_info" style="vertical-align: middle" value="23" onclick='avgWeight(23)'>23<br>
				</td>
          		<td><label id="resultWeight"></label></td>
          		</tr>
          		</table>
          		
               <tr height="10px"/>
               <tr>
               <td>
               
               </td>
               </tr>
             
						           </table>
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

		<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<h3>활동수준 체크</h3>
						<div>
						<table style="border: 1px solid #000000; margin:auto;" width="555" color=black>
               <tr style="border: 1px solid #000000;">
               <td align="center">활동 수준</td>
               <td align="center">활동 내용</td>
               </tr>
               <tr >
               <td align="center">가벼운 활동</td>
               <td>앉아서 하는 일<br> 운전, 타이핑, 글쓰기, 사무직원, 교사, 대부분의 전문직</td>
               </tr>
               <tr>
               <td align="center">중 정도 활동</td>
               <td>서서 하는 일 걷기<br>, 점원, 주부(가사노동)</td>
               </tr>
               <tr >
               <td align="center">중 정도의 심한 활동</td>
               <td>비교적 빠르게 하는 일<br> 댄서, 운동선수, 군인, 직업적인 가사노동</td>
               </tr>
               <tr >
               <td align="center">심한 활동</td>
               <td>심하게 움직이는 일<br> 무거운 짐 운반, 나무베기, 밭갈이 등 농업활동</td>
               </tr>
               </table>
               <br>
               <h3>활동 강도에따른 1일 에너지 요구량</h3>
               <table style="border: 1px solid #000000; margin:auto;" width="555" color=black>
               <tr style="border: 1px solid #000000;">
               <td>
               		현재 나의 비만도
               </td >
               <td>
               		가벼운 활동
               </td>
               <td>
               		중정도 활동
               </td>
               <td>
               		심한정도 활동
               </td>
               </tr>
               <td align="center">저체중</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="25" onclick='kcal(25)'>25kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="30" onclick='kcal(30)'>30kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="35" onclick='kcal(35)'>35kcal/kg</td>
               <tr>
               <td align="center">정상</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="30" onclick='kcal(30)'>30kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="35" onclick='kcal(35)'>35kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="40" onclick='kcal(40)'>40kcal/kg</td>
               </tr>
               <tr>
               <td align="center">과체중</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="35" onclick='kcal(35)'>35kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="40" onclick='kcal(40)'>40kcal/kg</td>
               <td><input type="radio" name="chk_info" style="vertical-align: middle" value="45" onclick='kcal(45)'>45kcal/kg</td>
               </tr>
               </table>
               <br>
               <form name="joinFrom">
               <table style="width:555; margin:auto;">
               <tr>
               <td align="center">표준 체중</td>
               <td align="center">활동 강도에따른 1일 에너지 요구량</td>
               <td align="center">섭취 칼로리</td>
               </tr>
               
               <tr>
               <td align="center"><label id="userKg"></label>kg</td>
               <td align="center"><label id="userKcal"></label>kcal/kg</td>
               <td align="center"><label id="userResultKcal" name="userResultKcal"></label>kcal</td>
               <td><input type="hidden" value="" id="pp"/></td>
               </tr>
               <tr height="50"></tr>
               <tr>
               <td align="center" colspan="3">
                   <a onclick="cancel()" style="color:black; margin-left: 10px">취소</a>
                   <a href="javascript:join()" style="color:black; margin-left: 200px">회원가입</a>
				</td></tr>
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

