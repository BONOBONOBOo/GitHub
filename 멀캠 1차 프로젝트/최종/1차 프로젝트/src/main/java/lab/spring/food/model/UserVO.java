package lab.spring.food.model;

import java.sql.Date;

public class UserVO {
	
	String userid;
	String userpass;
	String username;
	float weight;
	float height;
	float bmi;
	Date birth;
	String sex;
	int hopeKcal;
	
	public int getHopeKcal() {
		return hopeKcal;
	}
	public void setHopeKcal(int hopeKcal) {
		this.hopeKcal = hopeKcal;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
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
		return "UserVO [userid=" + userid + ", userpass=" + userpass + ", username=" + username + ", weight=" + weight
				+ ", height=" + height + ", bmi=" + bmi + ", birth=" + birth + ", sex=" + sex + ", hopeKcal=" + hopeKcal
				+ "]";
	}
	
}
