<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>3bob index</title>
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

	</head>
	<body>


	
	<div id="colorlib-page" >
		<header>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="colorlib-navbar-brand">
							<a class="colorlib-logo" href="index.html"><i class="flaticon-cutlery"></i><span>하루</span><span>세끼</span></a>
						</div>
					</div>
				</div>
			</div>
		</header>
		<aside id="colorlib-hero">
			<div class="flexslider">
				<ul class="slides">
			   	<li style="background-image: url(images/img_bg_1.jpg);">
			   		<div class="overlay"></div>
			   			<div class="container-fluid">
   			<div class="row">
	   			<div class="col-md-6 col-sm-12 col-xs-12 col-md-offset-3 slider-text">
	   				<div class="slider-text-inner text-center">
	   					<div class="desc">
	   						<span class="icon"><i class="flaticon-cutlery"></i></span>
									   <table style="margin:auto;">
									   
									   <h3 style="color:white; font-family:배달의민족 도현;">레시피 조회</h3>
									   
					                   
					                   <tr style="padding-top: 50px;">
					                      <td style="color:white;">필요칼로리</td>
					                      
					                      <td><input  id="RequireCal" name="RequireCal"  value="${kcal}" style =" width:150px; opacity: 0.7;text-align:center;" size="15" maxlength="12" readonly/> <td style="color:white;">kcal</td> </td>
						                </tr>

	

						                </tr>

						                <tr height="5px"/>
						                <tr>
					                      <td style="color:white;">희망칼로리</td>
					                      <td>
					                      <select name="desireCal" style="width:150px">
					                          <option value="0 1200" selected="selected">1200kcal 이하</option>
											  <option value="1200 1600" selected="selected">1200kcal~1600kcal</option>
											  <option value="1600 2000">1600kcal~2000kcal</option>
											  <option value="2000 2400" >2000kcal~2400kcal</option>
											  <option value="2400">2400kcal 이상</option>
										  </select> 
					                      </td> 	
					                      	<td style="color:white;"></td> 		
						                </tr>
						                <tr height="5px"/>
						                <tr>
					                      <td style="color:white;">희망가격</td>
					                      <td>
					                      <select name="desirePrice" style="width:150px">
					                      	  <option value="0 3000" selected="selected">3000원 이하</option>
											  <option value="3000 4000" selected="selected">3000원~4000원</option>
											  <option value="4000 5000">4000원~5000원</option>
											  <option value="5000 6000" >5000원~6000원</option>
											  <option value="6000" >6000원 이상</option>
										  </select>
										  </td>
						                </tr>						                
						                <tr height="5px"/>
						                
						                <tr>
					                     <td style="color:white;">식사패턴</td>

						                <td style="color:white;" >
						                <input style="margin:auto;" type='checkbox' name='breakfast' value='breakfast' />아침
						                <input type='checkbox' name='lunch' value='lunch' />점심
						                <input type='checkbox' name='dinner' value='dinner' />저녁
						                <td>
						             	</tr>
						           
						                <tr height="10px"/>
						                
						                <tr>
						                <td colspan="2" align="center">
					   					<p><a href="recipe.html" class="btn btn-primary btn-lg btn-learn" style="font-family:HY견고딕;">레시피 조회</a></p>

										</td></tr>
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

