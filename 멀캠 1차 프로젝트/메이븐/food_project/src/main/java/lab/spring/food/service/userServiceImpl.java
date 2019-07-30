package lab.spring.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.food.dao.UserDao;
import lab.spring.food.model.UserVO;

@Service("userService")
public class userServiceImpl implements userService{

	@Autowired
	private UserDao dao;
	
	
	@Override
	public UserVO login(String userid, String userpass) {
		
		return dao.login(userid, userpass);
	}
	
	

}
