package lab.spring.web.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.spring.web.dao.ProductDAO;
import lab.spring.web.model.ProductVO;


@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO dao = new ProductDAO();

	@Override
	public List<ProductVO> listProduct() {
		return dao.findProductList();
	}

	@Override
	public int addProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.addProduct(vo);
	}

	@Override
	public int modifyProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return dao.modifyProduct(vo);
	}

	@Override
	public int removeProduct(String pcode) {
		// TODO Auto-generated method stub
		return dao.removeProduct(pcode);
	}

	@Override
	public ProductVO getProduct(String pcode) {
		// TODO Auto-generated method stub
		return dao.getPdocuct(pcode);
	}
}
