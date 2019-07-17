package lab.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.UserVO;
import lab.spring.web.service.UserService;

@Controller
public class ModifyController {
	@Autowired
	UserService service;
	
	@RequestMapping(value="modify.do",method=RequestMethod.GET)
	public ModelAndView modify(@RequestParam("userid")String uid) {
		ModelAndView mav = new ModelAndView();
		UserVO vo = null;
		
		vo = service.findUser(uid);
		
		
		mav.addObject("user",vo);
		mav.setViewName("user_modify");
		
		return mav;
	}
	@RequestMapping(value="remove.do")
	public ModelAndView remove(@RequestParam("userid")String userid) {
		ModelAndView mav = new ModelAndView();
		
		service.removeUser(userid);
		
		List<UserVO> listvo = service.findUserList();

		mav.addObject("list", listvo);
		
		mav.setViewName("user_list");
		
		return mav;
	}
	
	@RequestMapping(value="update.do",method=RequestMethod.POST)
	public ModelAndView modifygo(@ModelAttribute("user")UserVO vo)
	{
		ModelAndView mav = new ModelAndView();
		
		System.out.println(vo);
		
		vo.setJob("직업 넣음");
		System.out.println(vo);
		
		service.updateUser(vo);

		
		List<UserVO> listvo = service.findUserList();
		
		
		mav.addObject("list",listvo);
		
		mav.setViewName("user_list");
		return mav;
	}
}
