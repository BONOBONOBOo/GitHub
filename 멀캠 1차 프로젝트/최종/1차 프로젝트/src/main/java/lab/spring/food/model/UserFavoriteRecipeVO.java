package lab.spring.food.model;

public class UserFavoriteRecipeVO {
	
	String userid;
	String favorite_recipe;
	
	public String getUserid() {
		return userid;
	}
	public String getFavorite_recipe() {
		return favorite_recipe;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setFavorite_recipe(String favorite_recipe) {
		this.favorite_recipe = favorite_recipe;
	}
	
	@Override
	public String toString() {
		return "UserFavoriteRecipeVO [userid=" + userid + ", favorite_recipe=" + favorite_recipe + "]";
	}
	
	

}
