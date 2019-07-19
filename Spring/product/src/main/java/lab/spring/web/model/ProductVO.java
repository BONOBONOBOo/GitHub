package lab.spring.web.model;

public class ProductVO {
	
	String pcode;
	String pname;
	int price;
	int quant;
	String pdesc;
	
	public String getPcode() {
		return pcode;
	}
	public String getPname() {
		return pname;
	}
	public int getPrice() {
		return price;
	}
	public int getQuant() {
		return quant;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", quant=" + quant + ", pdesc="
				+ pdesc + "]";
	}
	
	

	
	

}
