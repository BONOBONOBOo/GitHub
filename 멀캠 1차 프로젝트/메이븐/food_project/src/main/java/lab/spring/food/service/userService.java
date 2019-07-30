package lab.spring.food.service;

import lab.spring.food.model.UserVO;


public interface userService {
	public UserVO login(String userid,String userpass);
}
