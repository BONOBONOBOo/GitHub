<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>3bob login</title>
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


<script type="text/javascript">
function login(){
	document.loginForm.action="./login.do";
	document.loginForm.method="post";
	document.loginForm.submit();
}
</script>
</head>


<body>



<div id="colorlib-page">
	<header>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="colorlib-navbar-brand">
						<a class="colorlib-logo" href="index.html"><i class="flaticon-cutlery"></i><span>íë£¨</span><span>ì¸ë¼</span></a>
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
	   							<form name="loginForm">
									   <table style="margin:auto;">
 											<h3 style="color:white; font-family:ë°°ë¬ìë¯¼ì¡± ëí;">회원가입</h3>
					                    <tr>
					                      <td style="color:white;">아이디</td>
					                      <td><input  id="userid" name="userid" style =" opacity: 0.7;" size="15" maxlength="12"/></td>
					                    </tr>
					                    <tr>
					                      <td style="color:white;">비밀번호</td>
					                      <td><input type="password" id="userpwd" name="userpwd" style =" opacity: 0.7;" size="15" maxlength="12"/></td>
						                </tr>
						             
						                    <td colspan="3" align="center">
						                    <a onclick="join" style="color:white; margin-left: 45px"> 회원가입  </a> 
						               
						                    <a onclick="login()" style="color:white; margin-left: 20px">  &nbsp;로그인</a>
											</td>
						                </table>
						        </form>
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