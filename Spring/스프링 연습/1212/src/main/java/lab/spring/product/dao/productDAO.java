package lab.spring.product.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.product.model.ProductVO;

@Repository
public class productDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<ProductVO> getProductList(){
		return sqlSession.selectList("lab.mybatis.user.UserMapper.getProductList");
	}
	
	public ProductVO getProduct(String pronum) {
		
		return sqlSession.selectOne("lab.mybatis.user.UserMapper.getProduct",pronum);
	}
	
	public ProductVO selectProduct(int start,int end) {
		Object vo = null;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		
		hm.put("start", start);
		hm.put("end", end);
		
		vo = sqlSession.selectOne("lab.mybatis.user.UserMapper.selectProduct",hm);
		return (ProductVO) vo;
	}
	
	public int modifyProduct(ProductVO vo) {
		return sqlSession.update("lab.mybatis.user.UserMapper.modifyProduct",vo);
	}
	
	public int removeProduct(String pronum) {
		return sqlSession.delete("lab.mybatis.user.UserMapper.removeProduct",pronum);
	}
}
