package com.grade.entity;

import com.grade.util.CommonUtil;

abstract public class Student {
	String studentNo;
	String studentName;
	int[] gradeArr;
	
	public Student(String studentNo, String studentName, int[] gradeArr) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.gradeArr = gradeArr;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int[] getGradeArr() {
		return gradeArr;
	}

	public void setGradeArr(int[] gradeArr) {
		this.gradeArr = gradeArr;
	}
	
	public int getTotal() {
		int sum=0;
		for(int i=0;i<gradeArr.length;i++) {
			sum+=gradeArr[i];
		}
		return sum;
	}
	abstract boolean isPass();
	
	
	@Override
	public String toString() {
		CommonUtil util = new CommonUtil();
		String result="";
		
		
		for(int i = 0;i<gradeArr.length;i++) {
			result=result.concat(gradeArr[i]+"  ");
		}
		
		double pp = (getTotal())/(double)(gradeArr.length);
		
		return result+"\t"+getTotal()+"\t"+util.round(pp);
	}
	
	
	
	

}
