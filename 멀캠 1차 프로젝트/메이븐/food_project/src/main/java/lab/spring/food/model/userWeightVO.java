package lab.spring.food.model;

public class userWeightVO {
	
	String userid;
	String weight_history;
	String weight_date;
	
	public String getUserid() {
		return userid;
	}
	public String getWeight_history() {
		return weight_history;
	}
	public String getWeight_date() {
		return weight_date;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setWeight_history(String weight_history) {
		this.weight_history = weight_history;
	}
	public void setWeight_date(String weight_date) {
		this.weight_date = weight_date;
	}
	@Override
	public String toString() {
		return "userWeightVO [userid=" + userid + ", weight_history=" + weight_history + ", weight_date=" + weight_date
				+ "]";
	}
}
