package lab.spring.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.spring.web.model.UserVO;



public interface UserService {
	public int addUser(UserVO user);
	public int updateUser(UserVO user);
	public int removeUser(String useid);
	public UserVO findUser(String userid);
	public List<UserVO> findUser(String condition,String keyword);
	public UserVO login(String userid, String pwd);
	public List<UserVO> findUserList();
}
