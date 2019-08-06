package lab.spring.food.model;

public class StarsumVO {
	
	String recipe_name;
	String recipe_code;
	int starnum;
	String IMG_URL;
	
	public String getRecipe_code() {
		return recipe_code;
	}
	public void setRecipe_code(String recipe_code) {
		this.recipe_code = recipe_code;
	}
	public String getUrl() {
		return IMG_URL;
	}
	public void setUrl(String IMG_URL) {
		this.IMG_URL = IMG_URL;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public int getStarnum() {
		return starnum;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public void setStarnum(int starnum) {
		this.starnum = starnum;
	}
	@Override
	public String toString() {
		return "StarsumVO [recipe_name=" + recipe_name + ", recipe_code=" + recipe_code + ", starnum=" + starnum
				+ ", IMG_URL=" + IMG_URL + "]";
	}
	
	
	
	

}
