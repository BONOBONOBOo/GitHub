package lab.spring.orm.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lab.spring.orm.dao.UserDAO;
import lab.spring.orm.model.UserVO;



@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userdao;
	
	@Override
	public int addUser(UserVO user) {
		return userdao.addUser(user);
	}

	@Override
	public int updateUser(UserVO user) {
		return userdao.updateUser(user);
	}

	@Override
	public int removeUser(String userid) {
		return userdao.removeUser(userid);
	}

	@Override
	public UserVO findUser(String userid) {
		return userdao.findUser(userid);
	}

	@Override
	public UserVO login(String userid, String pwd) {
		return userdao.login(userid, pwd);
	}

	@Override
	public List<UserVO> findUserList() {
		return userdao.findUserList();
	}

	
	
}
