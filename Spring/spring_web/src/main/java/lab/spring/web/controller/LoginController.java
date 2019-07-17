package lab.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.UserVO;
import lab.spring.web.service.UserService;

@Controller("login.do")
public class LoginController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {//페이지 이름만 리턴해도 괜찮기때문에 리턴타입이 스트링이다.
		return "loginForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("userid")String uid,@RequestParam("userpwd")String upwd) {
		
		ModelAndView mav = new ModelAndView();
		UserVO vo = null;
		vo = service.login(uid, upwd);
		
		mav.addObject("user",vo);
		
		if(vo!=null) {
			mav.setViewName("loginSuccess");
		}
		else {
			mav.setViewName("loginFalse");
		}
		return mav;
	}
	
	/*
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(UserVO vo) {
		
		ModelAndView mav = new ModelAndView();
		
		vo = service.login(vo.getUserid(), vo.getUserpwd());
		mav.addObject("user",vo);
		if(vo!=null) {
			mav.setViewName("loginSuccess");
		}
		else {
			mav.setViewName("loginFalse");
		}
		return mav;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		UserVO vo = null;
		String uid = request.getParameter("userid");
		String upwd = request.getParameter("userpwd");
		
		vo = service.login(uid, upwd);
		mav.addObject("user",vo);
		if(vo!=null) {
			mav.setViewName("loginSuccess");
		}
		else {
			mav.setViewName("loginFalse");
		}
		return mav;
	}
	*/
}
