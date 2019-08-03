package lab.spring.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.food.dao.RecipeDao;
import lab.spring.food.model.RecipeVO;


@Service("recipeService")
public class recipeServiceImpl implements recipeService{
	
	@Autowired
	private RecipeDao dao;

	@Override
	public List<RecipeVO> getrecipeOne(int minCal) {
		
		return dao.getrecipeOne(minCal);
	}

}
