package com.grade.test;

import java.sql.SQLException;

import com.grade.biz.GradeManager;
import com.grade.util.CommonUtil;

public class GradeTest {

	public static void main(String[] args) throws SQLException {
		GradeManager gr = new GradeManager();
		CommonUtil utill = new CommonUtil();
	
		
		
		while(true) {
			printMenu();
			String select = utill.getUserInput();
			
			if(select.equals("9")) {
				System.out.println("bye");
				break;
			}
			
			switch(select) {
			case "1" :
				gr.printStudents(1);
				break;
				
			case "2" :
				gr.printStudents(2);
				break;
				
			case "3" :
				gr.printStudents(3);
				break;
			case "4" :
				System.out.print("삭제할 학생 번호 입력:");
				gr.deleteStudent(Integer.parseInt(utill.getUserInput()));
				System.out.print("삭제완료");
			case "5" :
				System.out.print("검색할 학생 번호 입력:");
				gr.searchStduent(Integer.parseInt(utill.getUserInput()));
				System.out.print("검색완료");
			case "6" :
				int a,b,c,d;
				System.out.println("수정할 학생의 번호 입력 :");
				a=Integer.parseInt(utill.getUserInput());
				System.out.println("수정 c 점수 :");
				b=Integer.parseInt(utill.getUserInput());
				System.out.println("수정 java 점수 :");
				c=Integer.parseInt(utill.getUserInput());
				System.out.println("수정 linux 점수 :");
				d=Integer.parseInt(utill.getUserInput());
				
				gr.updateStudent(a, b, c, d);
			
			}	
			
		}
		
	}
	
	public static void printMenu() {
		System.out.println("==<<성적 관리 시스템 메뉴>>==");
		System.out.println("1. 전체 수강생 출력");
		System.out.println("2. 합격 수강생 출력");
		System.out.println("3. 불합격 수강생 출력");
		System.out.println("4. 학생 삭제");
		System.out.println("5. 학생 검색");
		System.out.println("6. 학생 점수 수정");
		System.out.println("9. 종료");
		System.out.println("##메뉴 입력 =>");
	}
}
