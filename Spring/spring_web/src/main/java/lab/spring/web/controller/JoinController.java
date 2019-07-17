package lab.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.UserVO;
import lab.spring.web.model.UserValidate;
import lab.spring.web.service.UserService;

@Controller
public class JoinController {
	@Autowired
	UserService service;
	
	@RequestMapping(value="add.do",method=RequestMethod.GET)
	public String form() {
		return "joinForm";
	}
	
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public ModelAndView join(UserVO vo,BindingResult rs) {
		
		ModelAndView mav = new ModelAndView();
		service.addUser(vo);
		List<UserVO> listvo = service.findUserList();
		
		new UserValidate().validate(vo, rs);
		
		if(rs.hasErrors()) {
			mav.setViewName("joinForm");
		}
		else {
			mav.addObject("list",listvo);
			mav.setViewName("user_list");	
		}
		
		
		
		return mav;
	}
	
	
	
}
