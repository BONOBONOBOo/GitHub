package com.example.mybatisTest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mybatisTest.model.dto.GuestbookDTO;
import com.example.mybatisTest.service.GuestbookService;

@Controller
public class GuestbookController {

	@Inject
	GuestbookService guestbookService;
	
	@RequestMapping("/list.do")
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("list");//이동할 view의 이름 설정
		List<GuestbookDTO> list = guestbookService.list();
		mav.addObject("list", list);//데이터 저장
		
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		mav.addObject("name",list.get(1).getName());
		
		return mav;//화면 출력		
	}
	
	@RequestMapping("/hi")
	public ModelAndView showList(ModelAndView mav) {
		mav.setViewName("showtest");		
		return mav;
	}
	
	@RequestMapping("/godb")
	public ModelAndView showDB(ModelAndView mav) {
		//목적지 view 설정
		mav.setViewName("showtest");
		
		//Service를 통해 DB에 저장된 데이터를 List에 저장
		List<GuestbookDTO> lst = guestbookService.list();
		
		//테스트 DTO 값 추가
		GuestbookDTO dto = new GuestbookDTO(99, "test", "test", "test", "test", new Date());
		lst.add(dto);
		
		//List를 ModelAndView 객체에 추가
		mav.addObject("listGuest", lst);
		
		//ModelAndView 객체를 목적지 view로 전당
		return mav;
	}
	
	@RequestMapping("lsttest")
	public ModelAndView showDBSec() {
		ModelAndView mav = new ModelAndView("showtest");
		List<String> lst = new ArrayList<String>();
		lst.add("123");
		lst.add("456");
		lst.add("789");
		
		mav.addObject("list", lst);
		return mav;
	}
	
	@RequestMapping("hoho")
	public ModelAndView popo() {
		ModelAndView mav = new ModelAndView("showtest");
		
		GuestbookDTO gu = guestbookService.view(1);
		
		System.out.println("1 = "+guestbookService.view(1));
		
		return mav;
	}
}
