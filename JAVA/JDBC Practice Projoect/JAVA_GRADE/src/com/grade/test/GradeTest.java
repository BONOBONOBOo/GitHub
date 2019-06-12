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
				System.out.print("������ �л� ��ȣ �Է�:");
				gr.deleteStudent(Integer.parseInt(utill.getUserInput()));
				System.out.print("�����Ϸ�");
			case "5" :
				System.out.print("�˻��� �л� ��ȣ �Է�:");
				gr.searchStduent(Integer.parseInt(utill.getUserInput()));
				System.out.print("�˻��Ϸ�");
			case "6" :
				int a,b,c,d;
				System.out.println("������ �л��� ��ȣ �Է� :");
				a=Integer.parseInt(utill.getUserInput());
				System.out.println("���� c ���� :");
				b=Integer.parseInt(utill.getUserInput());
				System.out.println("���� java ���� :");
				c=Integer.parseInt(utill.getUserInput());
				System.out.println("���� linux ���� :");
				d=Integer.parseInt(utill.getUserInput());
				
				gr.updateStudent(a, b, c, d);
			
			}	
			
		}
		
	}
	
	public static void printMenu() {
		System.out.println("==<<���� ���� �ý��� �޴�>>==");
		System.out.println("1. ��ü ������ ���");
		System.out.println("2. �հ� ������ ���");
		System.out.println("3. ���հ� ������ ���");
		System.out.println("4. �л� ����");
		System.out.println("5. �л� �˻�");
		System.out.println("6. �л� ���� ����");
		System.out.println("9. ����");
		System.out.println("##�޴� �Է� =>");
	}
}
