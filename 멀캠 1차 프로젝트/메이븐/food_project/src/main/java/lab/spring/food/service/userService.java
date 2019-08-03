package lab.spring.food.service;

import lab.spring.food.model.UserVO;


public interface userService {
	public UserVO login(String userid,String userpass);
	public UserVO getUserinfo(String userid);
	public int join(UserVO vo);
	public int hopeUpdate(String userid,String hopeKcal);
}
