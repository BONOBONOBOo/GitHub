package com.grade.entity;

public class CarrerStudent extends Student{
	
	int careerYears;
	
	public CarrerStudent(String studentNo, String studentName, int[] gradeArr,int carrerYears) {
		super(studentNo, studentName, gradeArr);
		this.careerYears =carrerYears;
		
	}

	

	public int getCareerYears() {
		return careerYears;
	}

	public void setCareerYears(int careerYears) {
		this.careerYears = careerYears;
	}

	@Override
	public boolean isPass() {
		if(super.getTotal()/super.getGradeArr().length>=70) {
			return true;
		}else
			return false;

	}

}
