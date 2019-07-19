package lab.spring.web.controller;

import java.util.List;

import javax.print.attribute.standard.Severity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.ProductVO;
import lab.spring.web.sevice.ProductService;



@Controller
public class ListController {
	
	@Autowired
	ProductService service;
	
	
	@RequestMapping(value="list.do")
	public ModelAndView list() {
				
		ModelAndView mav = new ModelAndView();
		List<ProductVO> listvo = service.listProduct();
		
		
		mav.addObject("list",listvo);
		mav.setViewName("product_list");
		
		return mav;
	}
	
	@RequestMapping(value="view.do")
	
	public ModelAndView view(@RequestParam("pcode")String pcode) {
		
		ModelAndView mav = new ModelAndView();
		ProductVO vo = new ProductVO();
		
		System.out.println(pcode);
		
		vo = service.getProduct(pcode);
		
		System.out.println(vo);
		mav.addObject("vo",vo);
		mav.setViewName("product_view");
		
		return mav;
	}
	
	

}
