package com.example.mybatisTest;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//현재 클래스를 spring boot app의 시작 클래스로 등록
@SpringBootApplication
//sql mapper의 위치 지정
@MapperScan("com.example.mybatisTest.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	//spring framework <bean>태그에 대응하는 코드 설정
	//SqlSessionFactory를만들고 
	//SqlSessionFactory가 SqlSessionTemplate을만들고
	//SqlSessionTemplate이 SqlSession을 만든다
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean.getObject();		
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
}
