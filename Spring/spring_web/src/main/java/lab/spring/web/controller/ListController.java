package lab.spring.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.SearchVO;
import lab.spring.web.model.UserVO;
import lab.spring.web.service.UserService;


@Controller
public class ListController {
	
	@Autowired
	UserService service;
	
	
	@ModelAttribute("searchconditionlist")
	public ArrayList<SearchVO> makeSearchConditionList(){
		ArrayList<SearchVO> searchconditionlist = new ArrayList<SearchVO>();
		searchconditionlist.add(new SearchVO("userid","아이디"));
		searchconditionlist.add(new SearchVO("username","비밀번호"));
		searchconditionlist.add(new SearchVO("email","이메일"));
		
		return searchconditionlist;
	}
	
	
	@RequestMapping(value="list.do")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		List<UserVO> listvo = service.findUserList();
		
		
		mav.addObject("list",listvo);
		mav.setViewName("user_list");
		
		return mav;
	}
	
	@RequestMapping(value="search.do",method=RequestMethod.POST)
	public ModelAndView search(
			@RequestParam("searchCondition")String condition,
			@RequestParam("searchKeyword")String keyword
			) {
		
		ModelAndView mav = new ModelAndView();
		List<UserVO> userList = null;
		userList = service.findUser(condition, keyword);
		
		mav.addObject("list",userList);
		mav.setViewName("user_list");
		return mav;
	}

}
