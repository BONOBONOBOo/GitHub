package lab.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.web.model.ProductVO;
import lab.spring.web.sevice.ProductService;

@Controller
public class ModifyController {
	
	@Autowired
	ProductService service;
	
	
	@RequestMapping(value="modify.do",method=RequestMethod.GET)
	public ModelAndView modify(@RequestParam("pcode")String pcode) {
				
		ModelAndView mav = new ModelAndView();
		ProductVO vo = new ProductVO();
		vo = service.getProduct(pcode);

		mav.addObject("vo",vo);
				
		mav.setViewName("product_modify");
		
		return mav;
	}
	
	@RequestMapping(value="update.do")
	public ModelAndView update(
			@RequestParam("pcode")String pcode,
			@RequestParam("pname")String pname,
			@RequestParam("price")int price,
			@RequestParam("quant")int quant,
			@RequestParam("pdesc")String pdesc
			) {
				
		
		ModelAndView mav = new ModelAndView();
		
		ProductVO vo = new ProductVO();
		
		System.out.println(pcode);
		
		vo.setPcode(pcode);
		vo.setPdesc(pdesc);
		vo.setPname(pname);
		vo.setPrice(price);
		vo.setQuant(quant);
		
		System.out.println("update = "+vo.toString());
		
		service.modifyProduct(vo);
		
		List<ProductVO> listvo = service.listProduct();
		
		
		mav.addObject("list",listvo);
		mav.setViewName("product_list");
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value="delete.do")
	public ModelAndView remove(@RequestParam("pcode")String pcode) {
				
		ModelAndView mav = new ModelAndView();
		
		service.removeProduct(pcode);
		
		List<ProductVO> listvo = service.listProduct();
		
		
		mav.addObject("list",listvo);
		mav.setViewName("product_list");
		
		return mav;
	}
	
	

}
