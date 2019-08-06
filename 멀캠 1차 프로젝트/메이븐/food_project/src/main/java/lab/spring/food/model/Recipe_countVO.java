package lab.spring.food.model;

public class Recipe_countVO {
	String recipe_name;
	String recipe_code;
	String IMG_URL;
	int comment_count;
	
	public String getRecipe_name() {
		return recipe_name;
	}
	public String getRecipe_code() {
		return recipe_code;
	}
	public String getIMG_URL() {
		return IMG_URL;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public void setRecipe_code(String recipe_code) {
		this.recipe_code = recipe_code;
	}
	public void setIMG_URL(String iMG_URL) {
		IMG_URL = iMG_URL;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	@Override
	public String toString() {
		return "Recipe_countVO [recipe_name=" + recipe_name + ", recipe_code=" + recipe_code + ", IMG_URL=" + IMG_URL
				+ ", comment_count=" + comment_count + "]";
	}
	
	
}
