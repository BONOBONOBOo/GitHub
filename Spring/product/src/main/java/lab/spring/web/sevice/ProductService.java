package lab.spring.web.sevice;

import java.util.List;

import org.springframework.stereotype.Service;

import lab.spring.web.model.ProductVO;


public interface ProductService {
	public List<ProductVO> listProduct();
	public int addProduct(ProductVO vo);
	public int modifyProduct(ProductVO vo);
	public int removeProduct(String pcode);
	public ProductVO getProduct(String pcode);
	
	/*
	public int updateUser(UserVO user);
	public int removeUser(String useid);
	public UserVO findUser(String userid);
	public List<UserVO> findUser(String condition,String keyword);
	public UserVO login(String userid, String pwd);
	public List<UserVO> findUserList();
	*/
	
}
