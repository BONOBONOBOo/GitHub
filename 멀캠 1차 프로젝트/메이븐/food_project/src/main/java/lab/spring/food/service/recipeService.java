package lab.spring.food.service;

import java.util.List;

import lab.spring.food.model.RecipeVO;

public interface recipeService {
	
	public List<RecipeVO> getrecipeOne(int minCal);

}
