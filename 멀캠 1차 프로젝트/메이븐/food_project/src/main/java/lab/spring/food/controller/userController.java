package lab.spring.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.UserVO;
import lab.spring.food.model.userWeightVO;
import lab.spring.food.service.recipeService;
import lab.spring.food.service.userService;


@Controller
public class userController {
	
	@Autowired
	userService service;
	
	@Autowired
	recipeService recipeService;
	
	@RequestMapping(value="/myaccount.do", method=RequestMethod.GET)
	public ModelAndView goMyaccount() {
		ModelAndView mov = new ModelAndView();
		mov.setViewName("myAccount");
		return mov;	
	}
	
	@RequestMapping(value="/myaccount.do", method=RequestMethod.POST)
	public ModelAndView editMyaccount(
			@RequestParam("inputWeight")String weight,
			HttpServletRequest request
			) {
		ModelAndView mov = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("vo");
		
		vo.setWeight(Float.parseFloat(weight));
		
		service.WeightUpdate(vo);
		
		mov.setViewName("myAccount");
		return mov;	
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public ModelAndView goIndex() {
		
		ModelAndView mov = new ModelAndView();
		mov.setViewName("index");
		return mov;	
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		
		ModelAndView mov = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		
		mov.setViewName("index");
		return mov;
	}
	
	
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mov = new ModelAndView();
		mov.setViewName("login");
		return mov;
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("userid")String userid,
			@RequestParam("userpwd")String userpasswd,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charser=utf-8");
		
		ModelAndView mav = new ModelAndView();
		//PrintWriter out = response.getWriter();
		UserVO vo = service.login(userid, userpasswd);
		HttpSession session = request.getSession();
		if(vo==null) {
			
			//out.println("<script>alert('로그인 실패');</script>");
			mav.setViewName("login");
		}
		
		else {
			session.setAttribute("vo", vo);
			//out.println("<script>alert('로그인 성공');</script>");
			
			/*
			여자
			BMI = 665+(9.6*몸무게)+(1.8*키)-(4.7*나이)
			평균 몸무게 = 키 - 100 * 0.85
			남자
			BMI = 66+(13.8*몸무게)+(5*키)-(6.8*나이)
			평균 몸무게 = 키 - 100 * 0.9
			*/
			mav.addObject("vo",vo);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	public float avgCal(float height,java.sql.Date birth,String sex) {
		
		int age = getAge(birth);
		
		if(sex.equals("female")) {
			return (float)(665+(9.6*(height-100*0.85))+(1.8*height)-(4.7*age))/100;
		}
		else{
			return (float)((66+(13.8*(height-100*0.9)+(5*height)-(float)(6.8*age)))*100)/100;	
		}
		
	}
	//bmi 구하기
	public float bmi(float weight,float height) {
		return (int)(weight/((height/100)*(height/100))*100)/100;
	}
	//나이 구하기
	public int getAge(java.sql.Date date) {
		
		Calendar cal = Calendar.getInstance();
		int currYear = cal.get(Calendar.YEAR);
		int birth = 1900+date.getYear();
		int age = currYear-birth+1;
		
		return age;
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public ModelAndView join() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		return mav;
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(
			@ModelAttribute UserVO vo,
			@RequestParam("year") String year,
			@RequestParam("month") String month,
			@RequestParam("day") String day,
			HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charser=utf-8");
		
		int result;
		ModelAndView mav = new ModelAndView();
		
		PrintWriter out = response.getWriter();
		
		
		vo.setBmi(bmi(vo.getWeight(),vo.getHeight()));
		vo.setHopeKcal(0);
		
		
		if(month.length()==1) {
			month="0"+month;
		}
		if(day.length()==1) {
			day = "0"+day;
		}
		
		String dayy = year+"-"+month+"-"+day;
		java.sql.Date date = java.sql.Date.valueOf(dayy);
		vo.setBirth(date);
		
		result = service.join(vo);
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yy-MM-dd");
		Date time = new Date();
				
		String time1 = format1.format(time);
				
		service.setUserWeight(vo.getUserid(), time1, Float.toString(vo.getWeight()));
		
		if(result > 0) {
			out.println("회원가입 성공");
			out.flush();
			mav.addObject("userinfo",vo);
			mav.setViewName("join_detail");
		}
		else {
			out.println("회원가입 실패");
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/join_detail.do", method=RequestMethod.GET)
	public ModelAndView detailJoin(
			@RequestParam("userResultKcal") String hopeCal,
			@RequestParam("userid") String userid,
			HttpServletRequest request
			) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		UserVO vo = service.getUserinfo(userid);
		vo.setHopeKcal(Integer.parseInt(hopeCal));
		session.setAttribute("vo", vo);
		service.hopeUpdate(userid, hopeCal);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/getWeight.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		String userid = vo.getUserid();
		
		StringBuffer result=new StringBuffer(""); 
		result.append("{\"result\":[");
		userWeightVO recipe= service.getWeight(userid);
		result.append("{\"weight\":\""+recipe.getWeight_date()+"\"},");
		result.append("{\"date\":\""+recipe.getWeight_history()+"\"}");
		result.append("]}");
		
		return result.toString();
	}
	
	
	@RequestMapping(value="/practice.do")
	public ModelAndView practice() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("practice");
		return mav;
	}
	
	@RequestMapping(value="/addComment.do")
	public ModelAndView addComment(
			@ModelAttribute CommentVO comment
			) {
		
		ModelAndView mav = new ModelAndView();
		
		recipeService.addComment(comment);
		
		
		System.out.println(comment.toString());
		
		mav.addObject("detailVO",comment.getRecipe_name());
		mav.setViewName("redirect:/detail_recipe.do");
		
		
		
		
		return mav;
	}
	
	
	
		

	
	
	
}
