package lab.spring.food.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.Recipe_countVO;
import lab.spring.food.model.StarsumVO;
import lab.spring.food.model.UserFavoriteRecipeVO;
import lab.spring.food.model.UserVO;

@Repository
public class RecipeDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<RecipeVO> getRecipeAll() {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getRecipeAll");
	}
	public List<RecipeVO> getRecipeFavorite() {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getRecipeFavorite");
	}
	public List<StarsumVO> getStarRecipe() {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getStarOrder");
	}
	public List<Recipe_countVO> getCommentOrder() {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getCommentOrder");
	}
	
	public List<RecipeVO> getFavoriteList(String[] favolist) {
		
		List<String> list = new ArrayList<String>();
		
		
		
		for(int i = 1;i<favolist.length;i++) {
			list.add(i-1, favolist[i]);
			System.out.println(list.get(i-1));
		}
		
		
		
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getFavoriteList",list);
	}
	
	
	
	
	
	
	
	public List<RecipeVO> getrecipeOne(int minCal) {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getRecipeOne",minCal);
	}
	
	public RecipeVO getrecipe(String recipename) {
		return sqlSession.selectOne("lab.mybatis.mappers.RecipeMapper.getRecipe",recipename);
	}
	
	public List<CommentVO> getstarPoint(String recipename) {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getStarPoint",recipename);
	}
	
	public int addComment(CommentVO commentvo) {
		return sqlSession.insert("lab.mybatis.mappers.RecipeMapper.addComment",commentvo);
	}
	
	public UserFavoriteRecipeVO getFavorite(String userid){
		return sqlSession.selectOne("lab.mybatis.mappers.RecipeMapper.getFavorite",userid);
	}
	
	public int updateFavorite(String userid,String favorite_recipe) {
		HashMap<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("userid", userid);
		hashmap.put("favorite_recipe",favorite_recipe);
		
		return sqlSession.update("lab.mybatis.mappers.RecipeMapper.updateFavorite",hashmap);
	}
}
