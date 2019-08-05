package lab.spring.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.food.dao.UserDao;
import lab.spring.food.model.UserVO;
import lab.spring.food.model.userWeightVO;

@Service("userService")
public class userServiceImpl implements userService{

	@Autowired
	private UserDao dao;
	
	
	@Override
	public UserVO login(String userid, String userpass) {
		return dao.login(userid, userpass);
	}


	@Override
	public int join(UserVO vo) {
		return dao.join(vo);
	}


	@Override
	public int hopeUpdate(String userid, String hopeKcal) {
		
		return dao.hopeUpdate(userid, hopeKcal);
	}


	@Override
	public UserVO getUserinfo(String userid){
		return dao.getUserinfo(userid);
	}


	@Override
	public int setUserWeight(String userid, String date, String weight) {
		return dao.setUserWeight(userid, date, weight);
	}


	@Override
	public userWeightVO getWeight(String userid) {
		return dao.getWeight(userid);
	}


	@Override
	public int WeightUpdate(UserVO vo) {
		return dao.WeightUpdate(vo);
	}
	
	
	
	
	
	
	

}
