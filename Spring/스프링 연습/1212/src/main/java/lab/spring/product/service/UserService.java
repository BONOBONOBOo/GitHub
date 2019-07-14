package lab.spring.product.service;

import java.util.List;
import lab.spring.product.model.ProductVO;

public interface UserService {
	public List<ProductVO> getProductList();
	public ProductVO getProduct(String pronum);
	public ProductVO selectProduct(int start,int end);
	
	public int modifyProduct(ProductVO vo);
	public int removeProduct(String pronum);
}
