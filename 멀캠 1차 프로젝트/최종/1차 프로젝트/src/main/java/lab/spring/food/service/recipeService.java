package lab.spring.food.service;

import java.util.HashMap;
import java.util.List;

import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.Recipe_countVO;
import lab.spring.food.model.StarsumVO;
import lab.spring.food.model.UserFavoriteRecipeVO;

public interface recipeService {
	
	
	public List<RecipeVO> getRecipeAll();
	public List<RecipeVO> getRecipeFavorite();
	public List<StarsumVO> getStarRecipe();
	public List<Recipe_countVO> getCommentOrder();
	public List<RecipeVO> getFavoriteList(String[] favolist);
	public List<RecipeVO> getHopeRecipe(int minCal,int maxCal,int selected);
	
	public List<RecipeVO> getrecipeOne(int minCal,int maxCal);
	public RecipeVO getrecipe(String recipename);
	public List<CommentVO> getstarPoint(String recipename);
	public int addComment(CommentVO commentvo);
	
	public UserFavoriteRecipeVO getFavorite(String userid);
	public int updateFavorite(String userid,String favorite_recipe);

}
