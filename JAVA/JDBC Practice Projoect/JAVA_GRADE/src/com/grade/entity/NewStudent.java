package com.grade.entity;

public class NewStudent extends Student{
	boolean internYn;
	
	public NewStudent(String studentNo, String studentName, int[] gradeArr,boolean internYn) {
		super(studentNo, studentName, gradeArr);
		this.internYn = internYn;
	}
	

	public boolean isInternYn() {
		return internYn;
	}



	public void setInternYn(boolean internYn) {
		this.internYn = internYn;
	}

	@Override
	public boolean isPass() {
		if(super.getTotal()/super.getGradeArr().length>=80) {
			return true;
		}else
			return false;
	}

}
