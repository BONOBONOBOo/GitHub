package lab.spring.food.service;

import java.util.List;

import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;

public interface recipeService {
	
	public List<RecipeVO> getrecipeOne(int minCal);
	public RecipeVO getrecipe(String recipename);
	public List<CommentVO> getstarPoint(String recipename);
	public int addComment(CommentVO commentvo);

}
