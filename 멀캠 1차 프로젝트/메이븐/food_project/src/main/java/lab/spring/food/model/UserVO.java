package lab.spring.food.model;

public class UserVO {
	
	String userid;
	String userpass;
	float weight;
	float height;
	float bmi;
	
	public String getUserid() {
		return userid;
	}
	public String getUserpass() {
		return userpass;
	}
	public float getWeight() {
		return weight;
	}
	public float getHeight() {
		return height;
	}
	public float getBmi() {
		return bmi;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setBmi(float bmi) {
		this.bmi = bmi;
	}
	
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpass=" + userpass + ", weight=" + weight + ", height=" + height
				+ ", bmi=" + bmi + "]";
	}
	
	

}
