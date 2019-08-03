<%@page import="lab.spring.food.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta charset="UTF-8">
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
	<%UserVO vo = (UserVO)session.getAttribute("vo"); %>
	<script type="text/javascript">
	function avgWeight(sex){
		var age = document.getElementById("age").value;
		var weight = document.getElementById("weight").value;
		var height = document.getElementById("height").value;
		var hopekcal;	
		
		if(sex==1){
			hopekcal = 665+(9.6*weight)+(1.8*height)-(4.7*age)
		}
		else{
			hopekcal = 66+(13.8*weight)+(5*height)-(6.8*age)
		}
		document.getElementById("RequireCal").value = hopekcal;	
	}
	
	
	function recipe(){
			document.recipeForm.action="./recipeSearch.do";
			document.recipeForm.method="get";
			document.recipeForm.submit();
	}
	</script>
	
	
	
	<div id="colorlib-page" >
		<header>
			<div class="container" >
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
	   						
							<c:if test="${vo.userid eq null}">
							<h2 style="color:white">평균 칼로리</h2>
							<table style="margin:auto; color:white;">  
	   						<tr >
	   						<td>몸무게</td>
	   						<td width="10"></td>
	   						<td><input id=weight style="opacity:0.7; color:black"></td>
	   						<td>kg</td>
	   						</tr>
	   						<tr height="10"></tr>
	   						<tr >
	   						<td>키</td>
	   						<td width="10"></td>
	   						<td><input id=height style="opacity:0.7; color:black"></td>
	   						<td>cm</td>
	   						</tr>
	   						<tr height="10"></tr>
	   						<tr >
	   						<td>나이</td>
	   						<td width="10"></td>
	   						<td><input id = age style="opacity:0.7; color:#000000"></td>
	   						<td></td>
	   						</tr>
	   						<tr height="10"></tr>
	   						<tr >
	   						<td>성별</td>
	   						<td width="10"></td>
	   						<td colspan="2" align="center" >
	   						<input type="radio" name="chk_info" style="margin-left:20px; vertical-align: middle" value="18" onclick='avgWeight(1)'>여자
							<input type="radio" name="chk_info" style="margin-left:30px;vertical-align: middle;" value="19" onclick='avgWeight(2)'>남자
							</td>
	   						</tr>
	   						</table>	
	   						</c:if>
	   						
	   						<c:if test="${vo.userid ne null}">
	   						<h2 style="color:white">레시피 조회</h2>
	   						
	   						
	   						
	   						<form name="recipeForm">
	   						<table style="margin:auto;">
					                   <tr style="padding-top: 50px;">
					                      <td style="color:white">희망 칼로리</td>
					                      <%
					                      if(vo==null){
					                    	  out.println("<td><input  id='RequireCal' name='RequireCal'  value='2000' style =' width:150px; opacity: 0.7;text-align:center;' size='15' maxlength='12' readonly/><td style='color:white'>kcal</td> </td>");
					                      }
					                      
					                      else{
					                    	  out.println("<td><input  id='RequireCal' name='RequireCal'  value='"+vo.getHopeKcal()+"' style =' width:150px; opacity: 0.7;text-align:center;' size='15' maxlength='12' readonly/><td style='color:white'>kcal</td> </td>");
					                      }
					                      %>	
					                      
						                </tr>

						                <tr height="5px"/>
						                <tr>
					                      <td style="color:white">하루 칼로리</td>
					                      <td>
					                      <select name="desireCal" style="width:150px">
					                          <option value="1200" selected="selected">1200kcal 이하</option>
											  <option value="1200 1600" selected="selected">1200kcal~1600kcal</option>
											  <option value="1600 2000">1600kcal~2000kcal</option>
											  <option value="2000 2400" >2000kcal~2400kcal</option>
											  <option value="2400">2400kcal 이상</option>
										  </select> 
					                      </td> 	
					                      	<td style="color:white;"></td> 		
						                </tr>
						                <tr height="30px"/>
						                <tr>
					                    <td style="color:white">선호재료</td>
						                <td style="color:white">
							                <input style="margin:auto;" type='checkbox' name='meat' value='meat'/>고기
							                <input type='checkbox' name='fish' value='fish'/>생선
							                <input type='checkbox' name='vege' value='vege'/>야채
						                <td>
						             	</tr>
						                <tr height="30px"/>
						                <tr>
					                    <td style="color:white">식사패턴</td>
						                <td style="color:white">
							                <input style="margin:auto;" type='checkbox' name='breakfast' value='breakfast' checked="checked"/>아침
							                <input type='checkbox' name='lunch' value='lunch' checked="checked"/>점심
							                <input type='checkbox' name='dinner' value='dinner' checked="checked"/>저녁
						                <td>
						             	</tr>
						                <tr height="10px"/>
						                <tr>
						                <td colspan="2" align="center">
						                <p>
						                <% 
						                if(vo==null){
						                	out.println("<a href='./login.do' style='margin-left: 45px'>로그인</a>");
						                }
						                else{
						                	out.println("<a href='./logout.do' style='margin-left: 45px'>로그아웃</a>");
						                }
						                %>
						                <a onclick="recipe()" style="margin-left: 15px">레피시 조회</a>
					   					</p>
										</td></tr>
						                </table>
						                </form>
						                
	   						
	   						
	   						</c:if>
	   						
	   						
	   						
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
	
	<c:if test="${vo.userid eq null}">
	
	<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<div>
						
						<form name="recipeForm">
						<h3>레시피 조회</h3>
						<table style="margin:auto;">
					                   <tr style="padding-top: 50px;">
					                      <td>희망 칼로리</td>
					                      <%
					                      if(vo==null){
					                    	  out.println("<td><input  id='RequireCal' name='RequireCal'  value='' style =' width:150px; opacity: 0.7;text-align:center;' size='15' maxlength='12' readonly/><td >kcal</td> </td>");
					                      }
					                      
					                      else{
					                    	  out.println("<td><input  id='RequireCal' name='RequireCal'  value='"+vo.getHopeKcal()+"' style =' width:150px; opacity: 0.7;text-align:center;' size='15' maxlength='12' readonly/><td >kcal</td> </td>");
					                      }
					                      %>	
					                      
						                </tr>
						                </tr>

						                <tr height="5px"/>
						                <tr>
					                      <td>하루 칼로리</td>
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
						                <tr height="30px"/>
						                
						               
						                <tr>
					                    <td style="color:white">선호재료</td>
						                <td style="color:white">
							                <input style="margin:auto;" type='checkbox' name='meat' value='meat'/>고기
							                <input type='checkbox' name='fish' value='fish'/>생선
							                <input type='checkbox' name='vege' value='vege'/>야채
						                <td>
						             	</tr>
						                
						                 <tr height="30px"/>
						                <tr>
					                    <td>식사패턴</td>
						                <td>
						                <input style="margin:auto;" type='checkbox' name='breakfast' value='breakfast' checked="checked"/>아침
						                <input type='checkbox' name='lunch' value='lunch' checked="checked"/>점심
						                <input type='checkbox' name='dinner' value='dinner' checked="checked"/>저녁
						                <td>
						             	</tr>
						                <tr height="10px"/>
						                <tr>
						                <td colspan="2" align="center">
						                <p>
						                <% 
						                if(vo==null){
						                	out.println("<a href='./login.do' style='margin-left: 45px'>로그인</a>");
						                }
						                else{
						                	out.println("<a href='./logout.do' style='margin-left: 45px'>로그아웃</a>");
						                }
						                %>
						                <a onclick="recipe()" style="margin-left: 15px">레피시 조회</a>
					   					</p>
										</td></tr>
						                </table>
						                </form>
						                </c:if>        
               <br>
               </div>
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

