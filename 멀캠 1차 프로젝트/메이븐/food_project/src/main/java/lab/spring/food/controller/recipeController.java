package lab.spring.food.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
		
		Random ran = new Random();
		HashMap<String, RecipeVO> hashmap = new HashMap<String, RecipeVO>();
		
		if(desireCalarray.length==2) {
			minCal = Integer.parseInt(desireCalarray[0]);
			minunit = Math.round(minCal/10);
			
			System.out.println("recipehope = "+recipehope);
			System.out.println("minunit = "+minunit);
			
			if(breakfast != null && launch != null && dinner!=null) {
				//4.4.2
				breakfastRecipe = service.getrecipeOne(minCal*4);
				hashmap.put("아침", breakfastRecipe.get(ran.nextInt(breakfastRecipe.size())));
				lunchRecipe = service.getrecipeOne(minCal*4);
				hashmap.put("점심", lunchRecipe.get(ran.nextInt(lunchRecipe.size())));
				dinnerRecipe = service.getrecipeOne(minCal*2);
				hashmap.put("저녁", dinnerRecipe.get(ran.nextInt(dinnerRecipe.size())));
				
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
			
			/*
			System.out.println("breakfastRecipe.size() = " + breakfastRecipe.size());
			System.out.println("lunchRecipe.size() = "+lunchRecipe.size());
			System.out.println("dinnerRecipe.size() = "+dinnerRecipe.size());
			*/
			System.out.println(hashmap);
				

		}
		
		else {
			System.out.println("desireCalarray.length = "+desireCalarray.length);
			System.out.println("desireCalarray[0] = "+desireCalarray[0]);
			//minCal = Integer.parseInt(desireCalarray[0]);
			//maxCal = Integer.parseInt(desireCalarray[1]);
			//minunit = Math.round(minCal/10);
			//maxunit = Math.round(maxCal/10);
			
		}
		
		/*
		for(int i = 0; i<breakfastRecipe.size();i++) {
			System.out.println("breakfastRecipe["+i+"] = " + breakfastRecipe.get(i));	
		}
		
		for(int i = 0; i<lunchRecipe.size();i++) {
			System.out.println("lunchRecipe["+i+"] = " + lunchRecipe.get(i));	
		}
		
		for(int i = 0; i<dinnerRecipe.size();i++) {
			System.out.println("dinnerRecipe["+i+"] = " + dinnerRecipe.get(i));	
		}
		*/
		
		
		
		/*
		RedirectView redirectView = new RedirectView(); // redirect url 설정
		redirectView.setUrl("recipe.jsp");
		redirectView.setExposeModelAttributes(false);
		 */
	
		mav.addObject("hashmap",hashmap);
		mav.setViewName("recipe");
		
		return mav;	
	}
	
		
		@RequestMapping(value="/detail_recipe.do")
		public ModelAndView detailView(
				@RequestParam("detailVO") String recipe
				) {
			ModelAndView mav = new ModelAndView();
			
			System.out.println(recipe);
			
			return mav;
		}
	

}
