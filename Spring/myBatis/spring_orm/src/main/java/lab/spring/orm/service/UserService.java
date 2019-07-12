package lab.spring.orm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.spring.orm.model.UserVO;

public interface UserService {
	public int addUser(UserVO user);
	public int updateUser(UserVO user);
	public int removeUser(String useid);
	public UserVO findUser(String userid);
	public UserVO login(String userid, String pwd);
	public List<UserVO> findUserList();
}
