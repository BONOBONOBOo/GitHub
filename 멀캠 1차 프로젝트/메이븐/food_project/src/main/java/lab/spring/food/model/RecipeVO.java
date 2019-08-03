package lab.spring.food.model;

public class RecipeVO {
	
	   private int recipe_code;
	   private String recipe_name;
	   private String intro;
	   private int type_code;
	   private String type_category;
	   private int food_code;
	   private String food_category;
	   private String runtime;
	   private String total_cal;
	   private String capac;
	   private String lev;
	   private String ing_category;
	   private String total_price;
	   private String img_url;
	   private String detail_url;
	   private String order_detail;
	public int getRecipe_code() {
		return recipe_code;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public String getIntro() {
		return intro;
	}
	public int getType_code() {
		return type_code;
	}
	public String getType_category() {
		return type_category;
	}
	public int getFood_code() {
		return food_code;
	}
	public String getFood_category() {
		return food_category;
	}
	public String getRuntime() {
		return runtime;
	}
	public String getTotal_cal() {
		return total_cal;
	}
	public String getCapac() {
		return capac;
	}
	public String getLev() {
		return lev;
	}
	public String getIng_category() {
		return ing_category;
	}
	public String getTotal_price() {
		return total_price;
	}
	public String getImg_url() {
		return img_url;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public String getOrder_detail() {
		return order_detail;
	}
	public void setRecipe_code(int recipe_code) {
		this.recipe_code = recipe_code;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public void setType_code(int type_code) {
		this.type_code = type_code;
	}
	public void setType_category(String type_category) {
		this.type_category = type_category;
	}
	public void setFood_code(int food_code) {
		this.food_code = food_code;
	}
	public void setFood_category(String food_category) {
		this.food_category = food_category;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public void setTotal_cal(String total_cal) {
		this.total_cal = total_cal;
	}
	public void setCapac(String capac) {
		this.capac = capac;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public void setIng_category(String ing_category) {
		this.ing_category = ing_category;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public void setOrder_detail(String order_detail) {
		this.order_detail = order_detail;
	}
	@Override
	public String toString() {
		return "RecipeVO [recipe_code=" + recipe_code + ", recipe_name=" + recipe_name + ", intro=" + intro
				+ ", type_code=" + type_code + ", type_category=" + type_category + ", food_code=" + food_code
				+ ", food_category=" + food_category + ", runtime=" + runtime + ", total_cal=" + total_cal + ", capac="
				+ capac + ", lev=" + lev + ", ing_category=" + ing_category + ", total_price=" + total_price
				+ ", img_url=" + img_url + ", detail_url=" + detail_url + ", order_detail=" + order_detail + "]";
	}
	   
	   
	   

}
