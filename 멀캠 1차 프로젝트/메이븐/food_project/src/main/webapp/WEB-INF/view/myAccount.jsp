<%@page import="lab.spring.food.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>3bob</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta name="author" content="" />

	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link rel="shortcut icon" href="favicon.ico">

	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">
	
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/icomoon.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/magnific-popup.css">
	<link rel="stylesheet" href="css/flexslider.css">
	<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
	<link rel="stylesheet" href="css/bootstrap-datepicker.css">

	<link rel="stylesheet" href="css/style.css">

	<script src="js/modernizr-2.6.2.min.js"></script>
	
	<script src="js/jquery.min.js"></script>
	<script src="https://d3js.org/d3.v5.min.js"></script>
	<script src="https://d3js.org/d3-axis.v1.min.js"></script>
	<script src="js/Account.js"></script>
	
	
	<style>
	svg{
	width:500px; 
	height:300px;
	
	}
	.line{
	fill:none;
	stroke:steelblue;
	stroke-width:4px;
	}
	
	.axis text{
	font-family:sans-serif;
	font-size:11px;}
	.axis path,
	.axis line{
	fill:none;
	stroke:skyblue;
	stroke-width:4px;
	}
	.axis_x line{
	fill:none;
	stroke:green;
	}
</style>

<script>
window.addEventListener("load",function(){
	
	
	
	var weightSet;
	var dateSet;
	
	$.ajax({
		url:"getWeight.do",	
		method:"GET",
		async:false,
		success:function(data){
			
			var obj = JSON.parse(data);
			
		
			var weight = obj.result[0].weight;
			var date = obj.result[1].date;
			
			weightSet = weight.split(';');
			dateSet = date.split(';');
	}
	});	
	
		
	var svgWidth=320;
	var svgHeight=240;
	
	var WeightMax;
	var WeightMin;
	
	var tickVal =[];
	
	var rangeVal=300;
	var domainVal=150;
	
	
	console.log("weightSet = "+weightSet);
	console.log("dateSet = "+dateSet);
	
	
	WeightMax = Math.ceil((Math.max.apply(null,weightSet))/10)*10+10;
	WetightMin = Math.floor((Math.min.apply(null,weightSet))/10)*10-10;
	
	domainVal = WeightMax- WetightMin;
	
	console.log("max = "+WeightMax);
	console.log("min = "+WetightMin);
	
	for(var i = WetightMin;i<=WeightMax;i+=10){
		tickVal.push(i);
	}
	
	console.log("tickVal = "+tickVal);
	
	
	
	
	
	var margin = svgWidth/(weightSet.length-1);
	
	var line = d3.line()
	.x(function(d,i){
		return i * margin + 60
	})
	.y(function(d,i){
		return (domainVal -d+(WetightMin+10))*(rangeVal/domainVal);
	})
	//svgHeight=240
	
	var lineElements = d3.select("#myGraph")
	.append("path")
	.attr("class","line")
	.attr("d",line(weightSet))
	

	d3.select("#myGraph")
	.append("rect")
	.attr("class","axis_x")
	.attr("width",320)
	.attr("height",1)
	.attr("transform","translate(30,300)")
		
		
	
	
	
	var yScale = d3.scaleLinear()
	.domain([0,domainVal])
	.range([rangeVal,0])
	
	
	
	var axis=d3.axisLeft(yScale)
	.ticks(20)
	.tickValues(tickVal);
	
	
	d3.select("#myGraph").append("g")
	.attr("class","axis")
	.attr("transform","translate(30,0)")
	.call(axis)
	})
	
	
	
	function changeA(){
	
	var weight1=document.getElementById("weightValue").innerHTML;
	
	 $(weight).replaceWith($("<input id=inputWeight name=inputWeight onclick=EmpytInput() style='color:black;width:100px' onkeypress='if(event.keyCode==13) {ChangeWeight(); return false;}' value="+weight1+">"));
	
	}
	
	function EmpytInput(){
		document.getElementById("inputWeight").value="";
	}
	
	function ChangeWeight(){

		document.editWeightFrom.action="./myaccount.do";
		document.editWeightFrom.method="post";
		document.editWeightFrom.submit(); 
	}
	
	
	
</script>
	
	
	</head>
	<body>
	<%UserVO vo = (UserVO)session.getAttribute("vo"); %>
	<script type="text/javascript">
	
	</script>
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
							<li><a href="index.do">레시피 조회</a></li>
							
							<c:if test="${vo.userid ne null}">
							<li  class="active"><a href="myaccount.do">내 정보</a></li>
							<li><a href="logout.do">로그아웃</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</nav>
	
	
	
	<div id="colorlib-page" >
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
			   	<li style="background-image: url(images/img_bg_1.jpg);">
			   		<div class="overlay"></div>
			   			<div class="container-fluid">
   			<div class="row">
	   			<div class="col-md-6 col-sm-12 col-xs-12 col-md-offset-3 slider-text">
	   				<div class="slider-text-inner text-center">
	   					<div class="desc">
	   						<span class="icon"><i class="flaticon-cutlery"></i></span>
	   						
							
							<h2 style="color:white"><font size=6>내    정보</font></h2>
							<form name=editWeightFrom id=editWeightFrom>
							<table style="margin:auto; color:white;">  
	   						
	   						<tr>
	   						<td><font size=4>이름</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.username}</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						
	   						<tr >
	   						<td><font size=4>성별</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.sex}</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						
	   						<tr>
	   						<td><font size=4>아이디</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.userid}</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						
	   						<tr >
	   						<td><font size=4>키</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.height} cm</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						
	   						<tr>
	   						<td><font size=4>몸무게</font></td>
	   						<td width="40"></td>
	   						
	   						<td>
	   						<a id=weight onclick="changeA()" style="color:white" title="클릭하면 몸무게를 수정할 수 있습니다.">
	   						<font id=weightValue size=4>${vo.weight}</font></a>
	   						<font size=4>kg</font></td>
	   						</tr>
	   						<tr height="10"></tr>
	   						
	   						<tr >
	   						<td><font size=4>BMI</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.bmi}</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						<tr >
	   						<td><font size=4>생일</font></td>
	   						<td width="40"></td>
	   						<td><font size=4>${vo.birth}</font></td>
	   						</tr>
	   						
	   						<tr height="10"></tr>
	   						
	   						<tr>
	   						<td><font size=4>희망 칼로리</font></td>
	   						<td width="40"></td>
	   						<td>
	   						<a style="color:white"title="클릭하면 희망칼로리 설정 페이지로 이동합니다.">
	   						<font size=4>${vo.hopeKcal} kcal</font>
	   						</a>
	   						</td>
	   						</tr>
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
											  <option value="1200 1600">1200kcal~1600kcal</option>
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
		
		
	
	<div class="colorlib-reservation reservation-page">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 text-center animate-box intro-heading">
						<h1>몸무게 변화</h1>
						<svg id="myGraph"></svg>
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

