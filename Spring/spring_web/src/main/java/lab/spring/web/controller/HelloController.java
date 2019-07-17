package lab.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView sayHello() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("greet",getGreeting());
		mav.setViewName("hello");
		return mav;
	}
	
	public String getGreeting() {
		return "Heeeeello";
	}
	
}
