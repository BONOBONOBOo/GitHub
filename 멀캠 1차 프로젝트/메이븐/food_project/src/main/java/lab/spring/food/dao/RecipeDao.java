package lab.spring.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.food.model.RecipeVO;
import lab.spring.food.model.UserVO;

@Repository
public class RecipeDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<RecipeVO> getrecipeOne(int minCal) {
		return sqlSession.selectList("lab.mybatis.mappers.RecipeMapper.getRecipeOne",minCal);
	}
	
}
