package lab.spring.food.service;

import lab.spring.food.model.UserVO;
import lab.spring.food.model.userWeightVO;


public interface userService {
	public UserVO login(String userid,String userpass);
	public UserVO getUserinfo(String userid);
	public int join(UserVO vo);
	public int hopeUpdate(String userid,String hopeKcal);
	public int setUserWeight(String userid,String date,String weight);
	public userWeightVO getWeight(String userid);
	public int WeightUpdate(UserVO vo);
}
