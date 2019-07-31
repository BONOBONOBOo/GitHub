package lab.spring.food.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.food.model.UserVO;
import lab.spring.food.service.userService;


@Controller
public class userController {
	
	@Autowired
	userService service;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public ModelAndView login() {
		
		ModelAndView mov = new ModelAndView();
		mov.setViewName("login");
		return mov;
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("userid")String userid,
			@RequestParam("userpwd")String userpasswd) {
		
		ModelAndView mav = new ModelAndView();
		
		UserVO vo = service.login(userid, userpasswd);
		
		if(vo==null) {
			System.out.println("로그인 실패");
			mav.setViewName("login");
		}
		
		else {
			System.out.println("로그인 성공");
			/*
			여자
			BMI = 665+(9.6*몸무게)+(1.8*키)-(4.7*나이)
			평균 몸무게 = 키 - 100 * 0.85
			남자
			BMI = 66+(13.8*몸무게)+(5*키)-(6.8*나이)
			평균 몸무게 = 키 - 100 * 0.9
			*/
			
			//평균 칼로리 계산 하는부분(일단 남자만)
			mav.addObject("kcal",avgCal(vo.getHeight(), vo.getAge(),vo.isSex()));
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	public float avgCal(float height,int age,boolean sex) {
		if(sex == true) {
			return (float) (665+(9.6*(height-100*0.85))+(1.8*height)-(4.7*age))/100;
		}
		else{
			return (float) ((66+(13.8*(height-100*0.9)+(5*height)-(float)(6.8*age)))*100)/100;	
		}
		
	}
	public float bmi(float weight,float height) {
		return (float)((weight/((height/100)*(height/100))*100))/100;
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
			@RequestParam("day") String day) {
		
		
		
		vo.setBmi(bmi(vo.getWeight(),vo.getHeight()));
		
		if(month.length()==1) {
			month="0"+month;
		}
		if(day.length()==1) {
			day = "0"+day;
		}
		
		
		
		String dayy = year+"-"+month+"-"+day;
		java.sql.Date date = java.sql.Date.valueOf(dayy);
		System.out.println(date);
		vo.setBirth(date);

	
		System.out.println(vo.toString());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	
	

}
