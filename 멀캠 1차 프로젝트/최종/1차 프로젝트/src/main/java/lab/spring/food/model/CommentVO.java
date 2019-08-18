package lab.spring.food.model;

import java.sql.Date;

public class CommentVO {

	   private int cid ;
	   private String recipe_name; 
	   private String userid;
	   private String recipe_comment;
	   private Date idate; 
	   private String rating;
	
	   
	   public int getCid() {
		return cid;
	}
	public String getRecipe_name() {
		return recipe_name;
	}
	public String getUserid() {
		return userid;
	}
	public String getRecipe_comment() {
		return recipe_comment;
	}
	public Date getIdate() {
		return idate;
	}
	public String getRating() {
		return rating;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setRecipe_comment(String recipe_comment) {
		this.recipe_comment = recipe_comment;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "CommentVO [cid=" + cid + ", recipe_name=" + recipe_name + ", userid=" + userid + ", recipe_comment="
				+ recipe_comment + ", idate=" + idate + ", rating=" + rating + "]";
	}
}
