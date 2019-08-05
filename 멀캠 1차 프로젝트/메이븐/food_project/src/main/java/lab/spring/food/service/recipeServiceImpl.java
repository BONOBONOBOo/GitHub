package lab.spring.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.food.dao.RecipeDao;
import lab.spring.food.model.CommentVO;
import lab.spring.food.model.RecipeVO;


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
	
	

}
