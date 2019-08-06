package lab.spring.food.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeHope;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.Recipe_countVO;
import lab.spring.food.model.StarsumVO;
import lab.spring.food.model.UserFavoriteRecipeVO;
import lab.spring.food.model.UserVO;
import lab.spring.food.model.userWeightVO;
import lab.spring.food.service.recipeService;
import lab.spring.food.service.userService;


@Controller
public class recipeController {
	
	@Autowired
	recipeService service;
	
	
	
	@RequestMapping(value="/freeRecipe.do")
	public ModelAndView gofreeRecipe() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("freeRecipe");
		return mav;
	}
	
	@RequestMapping(value="/getRecipeAll.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getRecipeAll(HttpServletRequest request) {
		StringBuffer result=new StringBuffer("");
		List<RecipeVO> recipevo = service.getRecipeAll();
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO)session.getAttribute("vo");
		String favo = "0";
		String favoList[] = new String[] {};
		if(uservo != null) {
			favo = service.getFavorite(uservo.getUserid()).getFavorite_recipe();
			favoList = favo.split(",");
		}
		result.append("{\"result\":[");
		for(int i = 0;i<recipevo.size();i++) {
			
			String flag="0";
			
			result.append("[{\"recipename\":\""+recipevo.get(i).getRecipe_name()+"\"},");
			result.append("{\"recipecode\":\""+recipevo.get(i).getRecipe_code()+"\"},");
			result.append("{\"url\":\""+recipevo.get(i).getImg_url()+"\"},");
			
			if(uservo != null) {
				for(int p = 0;p<favoList.length;p++) {
					if(favoList[p].equals(recipevo.get(i).getRecipe_code()+"")) {
						flag="1";
					}
				}
			}
			result.append("{\"flag\":\""+flag+"\"}]");
			
			if(i!=recipevo.size()-1) {
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
	}
	
	@RequestMapping(value="/getRecipeFavorite.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getRecipeFavorite() {
		
		StringBuffer result=new StringBuffer("");
		List<RecipeVO> recipevo = service.getRecipeFavorite();
		
		result.append("{\"result\":[");
		for(int i = 0;i<recipevo.size();i++) {
			result.append("[{\"recipename\":\""+recipevo.get(i).getRecipe_name()+"\"},");
			result.append("{\"recipecode\":\""+recipevo.get(i).getRecipe_code()+"\"},");
			result.append("{\"url\":\""+recipevo.get(i).getImg_url()+"\"}]");
			if(i!=recipevo.size()-1) {
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
		
	}
	
	@RequestMapping(value="/getStarsum.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getStarRecipe(HttpServletRequest request) {
		StringBuffer result=new StringBuffer("");
		List<StarsumVO> recipevo = service.getStarRecipe();
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO)session.getAttribute("vo");
		String favo = "0";
		String favoList[] = new String[] {};
		if(uservo != null) {
			favo = service.getFavorite(uservo.getUserid()).getFavorite_recipe();
			favoList = favo.split(",");
		}

		result.append("{\"result\":[");
		for(int i = 0;i<recipevo.size();i++) {
			
			String flag="0";
			
			result.append("[{\"recipename\":\""+recipevo.get(i).getRecipe_name()+"\"},");
			result.append("{\"recipecode\":\""+recipevo.get(i).getRecipe_code()+"\"},");
			result.append("{\"url\":\""+recipevo.get(i).getUrl()+"\"},");
			
			if(uservo != null) {
				for(int p = 0;p<favoList.length;p++) {
					if(favoList[p].equals(recipevo.get(i).getRecipe_code()+"")) {
						flag="1";
					}
				}
			}
			
			result.append("{\"flag\":\""+flag+"\"}]");
			
			
			if(i!=recipevo.size()-1) {
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
	}
	
	@RequestMapping(value="/getCommentOrder.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getCommentOrder(HttpServletRequest request) {
		StringBuffer result=new StringBuffer("");
		List<Recipe_countVO> recipevo = service.getCommentOrder();
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO)session.getAttribute("vo");
		String favo = "0";
		String favoList[] = new String[] {};
		if(uservo != null) {
			favo = service.getFavorite(uservo.getUserid()).getFavorite_recipe();
			favoList = favo.split(",");
		}

		result.append("{\"result\":[");
		for(int i = 0;i<recipevo.size();i++) {
			
			String flag="0";
			
			result.append("[{\"recipename\":\""+recipevo.get(i).getRecipe_name()+"\"},");
			result.append("{\"recipecode\":\""+recipevo.get(i).getRecipe_code()+"\"},");
			result.append("{\"url\":\""+recipevo.get(i).getIMG_URL()+"\"},");
			
			if(uservo != null) {
				for(int p = 0;p<favoList.length;p++) {
					if(favoList[p].equals(recipevo.get(i).getRecipe_code()+"")) {
						flag="1";
					}
				}
			}
			
			result.append("{\"flag\":\""+flag+"\"}]");
			
			
			if(i!=recipevo.size()-1) {
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
	}
	
	@RequestMapping(value="/getfavoriteList.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String getfavoriteList(HttpServletRequest request) {
		StringBuffer result=new StringBuffer("");
		HttpSession session = request.getSession();
		UserVO uservo = (UserVO)session.getAttribute("vo");
		
		String favo = "0";
		String favoList[] = new String[] {};
		
		favo = service.getFavorite(uservo.getUserid()).getFavorite_recipe();
		favoList = favo.split(",");
		
		
		List<RecipeVO> recipevo = service.getFavoriteList(favoList);
		
		
		result.append("{\"result\":[");
		for(int i = 0;i<recipevo.size();i++) {
			
			String flag="0";
			
			result.append("[{\"recipename\":\""+recipevo.get(i).getRecipe_name()+"\"},");
			result.append("{\"recipecode\":\""+recipevo.get(i).getRecipe_code()+"\"},");
			result.append("{\"url\":\""+recipevo.get(i).getImg_url()+"\"},");
			
			if(uservo != null) {
				for(int p = 0;p<favoList.length;p++) {
					if(favoList[p].equals(recipevo.get(i).getRecipe_code()+"")) {
						flag="1";
					}
				}
			}
			result.append("{\"flag\":\""+flag+"\"}]");
			
			if(i!=recipevo.size()-1) {
				result.append(",");
			}
		}
		result.append("]}");
		return result.toString();
	}
	
	
	
	
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
				@RequestParam("detailVO") String recipe,
				HttpServletRequest request
				) {
			ModelAndView mav = new ModelAndView();
			RecipeVO recipevo = new RecipeVO();
			HttpSession session = request.getSession();
			UserVO vo = (UserVO)session.getAttribute("vo");
			
			
			
			List<CommentVO> starpoint = service.getstarPoint(recipe);
			recipevo = service.getrecipe(recipe);
			float star=(float) 0.0;
			for(int i = 0;i<starpoint.size();i++) {
				star += Float.parseFloat(starpoint.get(i).getRating());
			}
			int staravg = (int)star/starpoint.size();
			
			
			String recipeOrder[] = recipevo.getOrder_detail().split("\\. ");
			
			
			UserFavoriteRecipeVO favoriteVO = new UserFavoriteRecipeVO();
			String favorite = "0";
			if(vo != null) {
				favoriteVO = service.getFavorite(vo.getUserid());
				
				String favo = favoriteVO.getFavorite_recipe();
				String favoList[] = favo.split(",");
				
				for(int i = 0;i<favoList.length;i++) {
					if(favoList[i].equals(recipevo.getRecipe_code()+"")) {
						favorite = "1";
						break;
					}
				}
			}
			
			mav.addObject("favorite",favorite);
			mav.addObject("comment",starpoint);
			mav.addObject("ordernum",recipeOrder.length);
			mav.addObject("recipeOrder",recipeOrder);
			mav.addObject("star",staravg);
			mav.addObject("Recipe",recipevo);
			mav.setViewName("recipe_detail");
			return mav;
		}
		
		@RequestMapping(value="/addFavorite.do")
		@ResponseBody
		public void addFavorite(
				@RequestParam("userid")String userid,
				@RequestParam("recipe")String recipe) {
			
			UserFavoriteRecipeVO vo = new UserFavoriteRecipeVO();
			
			vo = service.getFavorite(userid);
			
			String favo = vo.getFavorite_recipe();
			String favoList[] = favo.split(",");
			
			boolean flag= false;
			
			for(int i =0;i<favoList.length;i++) {
				if(favoList[i].equals(recipe)) {
					favo = favo.replace(","+recipe,"");
					flag = true;
					break;
				}
			}
			if(flag == false) {
				favo+=","+recipe;
			}
			
			service.updateFavorite(userid, favo);
		}

}
