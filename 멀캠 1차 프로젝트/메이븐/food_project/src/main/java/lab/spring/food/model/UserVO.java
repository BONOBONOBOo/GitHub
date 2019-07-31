package lab.spring.food.model;

import java.sql.Date;

public class UserVO {
	
	String userid;
	String userpass;
	float weight;
	float height;
	float bmi;
	int age;
	Date birth;
	boolean sex;
	
	
	public Date getBirth() {
		return birth;
	}
	public boolean isSex() {
		return sex;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
		return "UserVO [userid=" + userid + ", userpass=" + userpass + ", weight=" + weight + ", height=" + height
				+ ", bmi=" + bmi + ", age=" + age + ", birth=" + birth + ", sex=" + sex + "]";
	}
	
	

}
