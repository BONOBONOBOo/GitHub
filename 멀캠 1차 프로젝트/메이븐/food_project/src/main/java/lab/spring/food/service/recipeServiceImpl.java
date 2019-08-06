package lab.spring.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.food.dao.RecipeDao;
import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.Recipe_countVO;
import lab.spring.food.model.StarsumVO;
import lab.spring.food.model.UserFavoriteRecipeVO;


@Service("recipeService")
public class recipeServiceImpl implements recipeService{
	
	@Autowired
	private RecipeDao dao;

	@Override
	public List<RecipeVO> getrecipeOne(int minCal) {
		
		return dao.getrecipeOne(minCal);
	}

	@Override
	public RecipeVO getrecipe(String recipename) {
		return dao.getrecipe(recipename);
	}

	@Override
	public List<CommentVO> getstarPoint(String recipename) {
		return dao.getstarPoint(recipename);
	}

	@Override
	public int addComment(CommentVO commentvo) {
		return dao.addComment(commentvo);
	}

	@Override
	public UserFavoriteRecipeVO getFavorite(String userid) {
		return dao.getFavorite(userid);
	}

	@Override
	public int updateFavorite(String userid, String favorite_recipe) {
		return dao.updateFavorite(userid, favorite_recipe);
	}

	@Override
	public List<RecipeVO> getRecipeAll() {
		return dao.getRecipeAll();
	}

	@Override
	public List<RecipeVO> getRecipeFavorite() {
		return dao.getRecipeFavorite();
	}

	@Override
	public List<StarsumVO> getStarRecipe() {
		return dao.getStarRecipe();
	}

	@Override
	public List<Recipe_countVO> getCommentOrder() {
		return dao.getCommentOrder();
	}

	@Override
	public List<RecipeVO> getFavoriteList(String[] favolist) {
		return dao.getFavoriteList(favolist);
	}
	
	
}
