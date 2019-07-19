package lab.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.jrockit.jfr.Producer;

import lab.spring.web.model.ProductVO;
import lab.spring.web.sevice.ProductService;

@Controller
public class AddController {
	
	@Autowired
	ProductService service;
	
	
	@RequestMapping(value="add.do",method=RequestMethod.GET)
	public ModelAndView addProduct() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product_form");
		
		
		return mav;
		
	}
	
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	public ModelAndView addProduct2(
			@RequestParam("pcode")String pcode,
			@RequestParam("pname")String pname,
			@RequestParam("price")String price,
			@RequestParam("quant")String quant,
			@RequestParam("pdesc")String pdesc
			) {
		
		ModelAndView mav = new ModelAndView();
		ProductVO vo = new ProductVO();
		
		vo.setPcode(pcode);
		vo.setPdesc(pdesc);
		vo.setPname(pname);
		vo.setPrice(Integer.parseInt(price));
		vo.setQuant(Integer.parseInt(quant));
		
		service.addProduct(vo);
		
		List<ProductVO> listvo = service.listProduct();
		
		
		mav.addObject("list",listvo);
		mav.setViewName("product_list");
		
		
		return mav;
		
	}

}
