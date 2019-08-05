package lab.spring.food.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lab.spring.food.model.UserVO;
import lab.spring.food.model.userWeightVO;



@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public UserVO login(String userid,String userpwd) {
		UserVO vo = new UserVO();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("uid", userid);
		hm.put("upwd", userpwd);
		
		vo = sqlSession.selectOne("lab.mybatis.mappers.UserMapper.login",hm);
		
		return vo;
	}
	
	public int join(UserVO vo) {

		return sqlSession.insert("lab.mybatis.mappers.UserMapper.Join",vo);
	}
	
	public int hopeUpdate(String userid,String hopeKcal) {
		
		HashMap<String,String> hashmap = new HashMap<String, String>();
		
		hashmap.put("userid", userid);
		hashmap.put("hopeKcal",hopeKcal);
		
		return sqlSession.insert("lab.mybatis.mappers.UserMapper.HopeUpdate",hashmap);
	}
	
	public UserVO getUserinfo(String userid) {
		return sqlSession.selectOne("lab.mybatis.mappers.UserMapper.getUserinfo",userid);
	}
	
	public int setUserWeight(String userid,String date,String weight) {
		
		HashMap<String,String> hashmap = new HashMap<String, String>();
		
		System.out.println(userid);
		System.out.println(date);
		System.out.println(weight);
		
		hashmap.put("userid", userid);
		hashmap.put("userweight",date);
		hashmap.put("weightdate",weight);
		
		return sqlSession.insert("lab.mybatis.mappers.UserMapper.setUserWeight",hashmap);
	}
	
	public userWeightVO getWeight(String userid) {
		return sqlSession.selectOne("lab.mybatis.mappers.UserMapper.getWeight",userid);
	}
	
	public int WeightUpdate(UserVO vo) {
		return sqlSession.update("lab.mybatis.mappers.UserMapper.WeightUpdate",vo);
	}
	
	
	

}
