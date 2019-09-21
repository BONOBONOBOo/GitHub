package com.example.mybatisTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 빈으로 등록
@Controller
public class HelloController {
	
	//index page "/"
	@RequestMapping("/")
	public ModelAndView hello(ModelAndView mav) {
		mav.setViewName("hello");
		mav.addObject("message", "스프링 부트 애플리케이션");
		return mav;
	}
}
