package lab.spring.product.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.product.model.ProductVO;
import lab.spring.product.service.UserService;

public class SpringMybatisTest {

	public static void main(String[] args) {
		String[] configs = new String[]{"application.xml"};
		
		ApplicationContext context = 
				   new ClassPathXmlApplicationContext(configs);
		UserService service = 
				context.getBean("userService", UserService.class);
		System.out.println("#######전체 상품 목록 ###########");
		
		List<ProductVO> lists = service.getProductList();
		Iterator<ProductVO> iter = lists.iterator();
		while (iter.hasNext()) {
			ProductVO u = iter.next();
			System.out.println(u);
		}
		
		ProductVO p = new ProductVO();
/*      p.setPronum("B1000");
    	p.setPname("Spring과 MyBatis");
    	p.setCategory("Book");
    	p.setDescription("프로젝트로 배우는 프레임워크");
    	p.setFilename("spring.jpeg");
    	p.setManufacturer("멀티캠퍼스");
    	p.setUnitPrice(10000);
    	p.setUnitsInStock(300); 
    	
		 
		System.out.println("insert rows = >" + service.addProduct(p));	*/	
		System.out.println("#######s3 아이디 한행 검색 ###########"); 
		System.out.println(service.getProduct("s3"));		
		p.setPronum("1234");
		p.setUnitPrice(15000);
    	p.setUnitsInStock(200);  
    	p.setFilename("spring-mybatis.jpeg");
		System.out.println("update :s3 =>"+service.modifyProduct(p));
		System.out.println(service.getProduct("s3"));
		System.out.println("delete :s3 =>"+service.removeProduct("s3"));
		System.out.println("#######전체 상품목록 ###########");
		 lists = service.getProductList();
		 iter = lists.iterator();
		while (iter.hasNext()) {
			ProductVO u = iter.next();
			System.out.println(u);
		}

}}
