package lab.spring.food.model;

public class RecipeHope {
	
	String breakfast;
	String lunch;
	String dinner;
	String meat;
	String fish;
	String vege;
	public String getBreakfast() {
		return breakfast;
	}
	public String getLunch() {
		return lunch;
	}
	public String getDinner() {
		return dinner;
	}
	public String getMeat() {
		return meat;
	}
	public String getFish() {
		return fish;
	}
	public String getVege() {
		return vege;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public void setFish(String fish) {
		this.fish = fish;
	}
	public void setVege(String vege) {
		this.vege = vege;
	}
	@Override
	public String toString() {
		return "RecipeHope [breakfast=" + breakfast + ", lunch=" + lunch + ", dinner=" + dinner + ", meat=" + meat
				+ ", fish=" + fish + ", vege=" + vege + "]";
	}
	
	
}
