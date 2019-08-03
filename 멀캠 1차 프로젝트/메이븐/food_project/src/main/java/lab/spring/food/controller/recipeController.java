package lab.spring.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.food.model.RecipeHope;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.service.recipeService;
import lab.spring.food.service.userService;


@Controller
public class recipeController {
	
	@Autowired
	recipeService service;
	
	@RequestMapping(value="/recipeSearch.do")
	
	
	public ModelAndView detail(
			@RequestParam("desireCal")String desireCal,
			@ModelAttribute RecipeHope recipehope
			){
		ModelAndView mav = new ModelAndView();
		
		String desireCalarray[] = desireCal.split(" ");
		int minCal;
		int maxCal;
		int minunit;
		int maxunit;
		
		String breakfast = recipehope.getBreakfast();
		String launch = recipehope.getLunch();
		String dinner = recipehope.getDinner();
		String fish = recipehope.getFish();
		String meat = recipehope.getMeat();
		String vege = recipehope.getVege();
		
		List<RecipeVO> breakfastRecipe = null;
		List<RecipeVO> lunchRecipe = null;
		List<RecipeVO> dinnerRecipe = null;
		
		
		if(desireCalarray.length==2) {
			minCal = Integer.parseInt(desireCalarray[0]);
			minunit = Math.round(minCal/10);
			
			System.out.println("recipehope = "+recipehope);
			System.out.println("minunit = "+minunit);
			
			if(breakfast != null && launch != null && dinner!=null) {
				//4.4.2
				
				breakfastRecipe = service.getrecipeOne(minCal*4);
				
				lunchRecipe = service.getrecipeOne(minCal*4);
				
				dinnerRecipe = service.getrecipeOne(minCal*2);
			} 
			else if(breakfast == null && launch != null && dinner!=null) {
				//0.6.4
				
				lunchRecipe = service.getrecipeOne(minCal*6);
				
				dinnerRecipe = service.getrecipeOne(minCal*4);
			}
			else if(breakfast != null && launch == null && dinner!=null) {
				//6.0.4
				
				breakfastRecipe = service.getrecipeOne(minCal*6);
				
				dinnerRecipe = service.getrecipeOne(minCal*4);
				
				
			}
			else if(breakfast != null && launch != null && dinner==null) {
				//6.4.0
				
				breakfastRecipe = service.getrecipeOne(minCal*6);
				
				lunchRecipe = service.getrecipeOne(minCal*4);
			}
			

		}
		
		else {
			minCal = Integer.parseInt(desireCalarray[0]);
			maxCal = Integer.parseInt(desireCalarray[1]);
			minunit = Math.round(minCal/10);
			maxunit = Math.round(maxCal/10);
			
			
		}
		
		System.out.println("breakfastRecipe = " + breakfastRecipe);
		System.out.println("lunchRecipe = "+lunchRecipe);
		System.out.println("dinnerRecipe = "+dinnerRecipe);
	
		
		mav.addObject("breakfast",breakfastRecipe);
		mav.addObject("lunch",lunchRecipe);
		mav.addObject("dinner",dinnerRecipe);
		
		return mav;	
	}
	
	

}
