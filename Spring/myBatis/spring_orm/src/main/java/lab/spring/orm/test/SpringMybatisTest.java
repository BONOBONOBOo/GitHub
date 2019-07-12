package lab.spring.orm.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.orm.model.UserVO;
import lab.spring.orm.service.UserService;



public class SpringMybatisTest {

	public static void main(String[] args) {
String[] configs = new String[] {"application.xml"};
		
		ApplicationContext context = new ClassPathXmlApplicationContext(configs);
		
		UserService service = context.getBean("userService",UserService.class);
		
		UserVO vo = new UserVO();
		
		vo.setUserid("s3");
		vo.setUsername("이원호");
		vo.setUserpwd("1234");
		vo.setEmail("12@na.com");
		vo.setPhone("12");
		vo.setAddress("울산");
		vo.setJob("개발자");
		
		System.out.println("insertRow => "+service.addUser(vo));
		System.out.println("###########아이디 한행 검색");
		System.out.println(service.findUser("s3"));
		
		vo.setUserid("s3");
		vo.setEmail("change@naver.com");
		vo.setPhone("change");
		vo.setAddress("서울");
		vo.setJob("백수");
		
		System.out.println("updateRow :s3 =>"+service.updateUser(vo));
		System.out.println(service.findUser("s3"));
		System.out.println("delete : s3 =>"+service.removeUser(vo.getUserid()));
		System.out.println("##전체 목록");
		List<UserVO> lists = service.findUserList();
		Iterator<UserVO> iter = lists.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
		}
		

	}

}
