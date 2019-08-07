<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>3bob recipe</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />



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
	function detail(time){
		//hashmap['아침']
		//var vo = ${hashmap["아침"].recipe_name};
		
		
		//console.log(vo);
		
		if(time == "아침"){
			document.morningRrecipe.action="./detail_recipe.do";
			document.morningRrecipe.method="post";
			document.morningRrecipe.submit(); 
		}
		else if(time == '점심'){
			
			document.lauchRrecipe.action="./detail_recipe.do";
			document.lauchRrecipe.method="post";
			document.lauchRrecipe.submit(); 
		}
		else if(time == '저녁'){
			document.dinnerRrcipe.action="./detail_recipe.do";
			document.dinnerRrcipe.method="post";
			document.dinnerRrcipe.submit(); 
			
		}
	}
	
	function detail2(time){
		
		if(time == "아침"){
			document.morningRrecipe1.action="./detail_recipe.do";
			document.morningRrecipe1.method="post";
			document.morningRrecipe1.submit(); 
		}
		else if(time == '점심'){
			
			document.lauchRrecipe1.action="./detail_recipe.do";
			document.lauchRrecipe1.method="post";
			document.lauchRrecipe1.submit(); 
		}
		else if(time == '저녁'){
			document.dinnerRrcipe1.action="./detail_recipe.do";
			document.dinnerRrcipe1.method="post";
			document.dinnerRrcipe1.submit(); 
			
		}
	}
	
	
	</script>
	
	</head>
	<body>


	
	<div id="colorlib-page">




		<div class="goto-here"></div>


		<div class="colorlib-menu">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<span class="icon"><i class="flaticon-cutlery"></i></span>
						<h2>첫 번째 레시피 추천</h2>
						<p>${hopetext}</p>
					</div>
				</div>
				<div class="row">
				<form name=morningRrecipe1>
					<div class="col-md-4 animate-box">
					
						<h2 style="text-align:center">아침</h2>
						<div class="dish-wrap">
							<div class="wrap">
								<div class="dish-img" style="background-image: url(${hopehashmap['아침'].img_url});"></div>
								<div class="desc">
									<input type=hidden id=detailVO name=detailVO value=${hopehashmap["아침"].recipe_name} />
									<h2><a onclick='detail2("아침")' href="#">${hopehashmap["아침"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail2("아침")'>${hopehashmap["아침"].intro}</a></h2>
								</div>
							</div>
						</div>
					</div>
					</form>
					
					<form name=lauchRrecipe1>
					<div class="col-md-4 animate-box">
						<h2 style="text-align:center">점심</h2>
						<div class="dish-wrap">
						<div class="wrap">
								<div class="dish-img" style="background-image: url(${hopehashmap['점심'].img_url});"></div>
								<div class="desc">
									<input type=hidden id=detailVO name=detailVO value=${hopehashmap["점심"].recipe_name} />
									<h2><a onclick='detail2("점심")' href="#">${hopehashmap["점심"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail2("점심")'>${hopehashmap["점심"].intro}</a></h2>
								</div>
							</div>
						</div>
					</div>
					</form>
					<form name=dinnerRrcipe1>
					<div class="col-md-4 animate-box">
						<h2 style="text-align:center">저녁</h2>
						<div class="dish-wrap">
						<div class="wrap">
								<div class="dish-img" style="background-image: url(${hopehashmap['저녁'].img_url});"></div>
								<div class="desc">
									<input type=hidden id=detailVO name=detailVO value=${hopehashmap["저녁"].recipe_name} />
									<h2><a onclick='detail2("저녁")' href="#">${hopehashmap["저녁"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail2("저녁")'>${hopehashmap["저녁"].intro}</a></h2>
								</div>
							</div>
							</div>
					</div>
					</form>
				</div>
			</div>
		</div>
		
		<div class="colorlib-menu">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<span class="icon"><i class="flaticon-cutlery"></i></span>
						<h2>두 번째 레시피 추천</h2>
						<p>${text}</p>
					</div>
				</div>
				<form name=morningRrecipe>
				<div class="row">
					<div class="col-md-4 animate-box">
						<h2 style="text-align:center">아침</h2>
						<div class="dish-wrap">
							<div class="wrap">
								<div class="dish-img" style="background-image: url(${hashmap['아침'].img_url});"></div>
								<div class="desc">
								<input type=hidden id=detailVO name=detailVO value=${hashmap["아침"].recipe_name} />
									<h2><a onclick='detail("아침")' href="#">${hashmap["아침"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail("아침")' href="#">${hashmap["아침"].intro}</a></h2>
								</div>
							</div>
						</div>
					</div>
					</form>
					<form name=lauchRrecipe>
					<div class="col-md-4 animate-box">
						<h2 style="text-align:center">점심</h2>
						
						<div class="dish-wrap">
							<div class="wrap">
								<div class="dish-img" style="background-image: url(${hashmap['점심'].img_url});"></div>
								<div class="desc">
									<input type=hidden id=detailVO name=detailVO value=${hashmap["점심"].recipe_name} />
									<h2><a onclick='detail("점심")' href="#">${hashmap["점심"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail("점심")' >${hashmap["점심"].intro}</a></h2>
								</div>
							</div>
						</div>
						
					</div>
					</form>
					<form name=dinnerRrcipe>
					<div class="col-md-4 animate-box">
						<h2 style="text-align:center">저녁</h2>
						<div class="dish-wrap">
							<div class="wrap">
								<div class="dish-img" style="background-image: url(${hashmap['저녁'].img_url});"></div>
								<div class="desc">
									<input type=hidden id=detailVO name=detailVO value=${hashmap["저녁"].recipe_name} />
									<h2><a onclick='detail("저녁")' href="#">${hashmap["저녁"].recipe_name}</a></h2>
									<br><br><br>
									<h2><a onclick='detail("저녁")'>${hashmap["저녁"].intro}</a></h2>
								</div>
							</div>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>



		



	
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

