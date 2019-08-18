package lab.spring.food.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.food.model.UserVO;
import lab.spring.food.service.userService;


@Controller
public class loginController {
	
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
			mav.setViewName("recipe");
		}
		
		
		
		
		
		
		return mav;
	}
	

}
