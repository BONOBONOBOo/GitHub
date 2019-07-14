package lab.spring.product.model;

public class ProductVO {

	private String pronum;
	private String pname;
	private String category;
	private String description;
	private String filename;
	private String manufacturer;
	private int unitPrice;
	private int unitsInStock;
	public String getPronum() {
		return pronum;
	}
	public String getPname() {
		return pname;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public String getFilename() {
		return filename;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setPronum(String pronum) {
		this.pronum = pronum;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [pronum=" + pronum + ", pname=" + pname + ", category=" + category + ", description="
				+ description + ", filename=" + filename + ", manufacturer=" + manufacturer + ", unitPrice=" + unitPrice
				+ ", unitsInStock=" + unitsInStock + "]";
	}
	
	
	
	

}