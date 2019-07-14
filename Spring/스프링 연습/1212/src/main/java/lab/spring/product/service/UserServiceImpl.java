package lab.spring.product.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lab.spring.product.dao.productDAO;
import lab.spring.product.model.ProductVO;





@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private productDAO dao;

	public List<ProductVO> getProductList() {
		
		return dao.getProductList();
	}

	public ProductVO getProduct(String pronum) {
		// TODO Auto-generated method stub
		return dao.getProduct(pronum);
	}

	public ProductVO selectProduct(int start, int end) {
		// TODO Auto-generated method stub
		return dao.selectProduct(start, end);
	}

	public int modifyProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.modifyProduct(vo);
	}

	public int removeProduct(String pronum) {
		// TODO Auto-generated method stub
		return dao.removeProduct(pronum);
	}
	
	

	
	
}
