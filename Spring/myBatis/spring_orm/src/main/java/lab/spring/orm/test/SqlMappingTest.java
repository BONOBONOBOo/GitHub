package lab.spring.orm.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lab.spring.orm.model.UserVO;
import lab.spring.orm.dao.UserManagerDAO;





public class SqlMappingTest {

	public static void main(String[] args) throws IOException {
		
		String resource ="mybats-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		
		UserManagerDAO userdao = new UserManagerDAO();
		userdao.setSqlSessionFactory(sqlSessionFactory);
		
		
		UserVO vo = new UserVO();
		
		
		System.out.println("##전체 목록##");
		List<UserVO> lists = userdao.findUserList();
		Iterator<UserVO> iter = lists.iterator();
		while(iter.hasNext()) {
			UserVO u = iter.next();
			System.out.println(u);
			}
		
		vo.setUserid("s3");
		vo.setUsername("이원호");
		vo.setUserpwd("1234");
		vo.setEmail("12@na.com");
		vo.setPhone("12");
		vo.setAddress("울산");
		vo.setJob("개발자");
		
		System.out.println("insertRow => "+userdao.addUser(vo));
		System.out.println("###########아이디 한행 검색");
		System.out.println(userdao.findUser("s3"));
		
		vo.setUserid("s3");
		vo.setEmail("change@naver.com");
		vo.setPhone("change");
		vo.setAddress("서울");
		vo.setJob("백수");
		
		System.out.println("updateRow :s3 =>"+userdao.updateUser(vo));
		System.out.println(userdao.findUser("s3"));
		System.out.println("delete : s3 =>"+userdao.removeUser("s3"));
}

}
