package com.grade.biz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.grade.entity.CarrerStudent;
import com.grade.entity.NewStudent;
import com.grade.entity.Student;
import com.grade.util.CommonUtil;

public class GradeManager implements IGradeManager{
	
	Student students[]=new Student[30];
	int cnt = 0;
	
	CommonUtil db = new CommonUtil();
	private Connection conn = null;
	Statement selectPs = null;
	ResultSet rs = null;

	
	
	public GradeManager() throws SQLException{	
		
		students[0]=new NewStudent("10001","kim",new int[] {74,70,80},false);
		students[1]=new NewStudent("10005","park",new int[]{90,90,100},false);
		students[2]=new NewStudent("10009","lee",new int[] {70,62,60},true);
		students[3]=new CarrerStudent("20001", "han", new int[] {96,85,93},1);
		students[4]=new CarrerStudent("20005", "nam", new int[] {90,80,73},2);
		students[5]=new CarrerStudent("20009", "choi", new int[] {70,70,90},1);
		
//		insertStudent(students[0]);
//		insertStudent(students[2]);
//		insertStudent(students[4]);
//		insertStudent(students[5]);
		
		cnt = 6;
	}
	public void insertStudent(Student std) throws SQLException {
		conn=db.login();
		String query = "insert into student values(?,?,?,?,?,?,?)";
		PreparedStatement presql = null;
		presql = conn.prepareStatement(query); // 형식 보내기
		
		if(std instanceof NewStudent) {
			presql.setInt(1, Integer.parseInt(std.getStudentNo()));
			presql.setString(2, std.getStudentName());
			presql.setInt(3, std.getGradeArr()[0]);
			presql.setInt(4, std.getGradeArr()[1]);
			presql.setInt(5, std.getGradeArr()[2]);
			if(((NewStudent)std).isInternYn()==true) {
				presql.setString(6, "Y");
			}
			else
				presql.setString(6, "N");
			presql.setInt(7, 0);	
		}
		else {
			presql.setInt(1, Integer.parseInt(std.getStudentNo()));
			presql.setString(2, std.getStudentName());
			presql.setInt(3, std.getGradeArr()[0]);
			presql.setInt(4, std.getGradeArr()[1]);
			presql.setInt(5, std.getGradeArr()[2]);
			presql.setString(6, null);
			presql.setInt(7, ((CarrerStudent)std).getCareerYears());
		}
		presql.executeUpdate();
			
		
		
	}
	public void deleteStudent(int stdnum) throws SQLException {
		conn=db.login();
		String query = "delete from student where stnum = ?";
		PreparedStatement presql = null;
		presql = conn.prepareStatement(query); // 형식 보내기
		
		presql.setInt(1, stdnum);
		presql.executeUpdate();
	}
	public void updateStudent(int stdnum,int c,int java,int linux) throws SQLException {
		conn=db.login();
		String query = "update student set langc = ?,langli = ?,langjava=? where stnum = ?";
		PreparedStatement presql = null;
		presql = conn.prepareStatement(query);
		
		presql.setInt(1, c);
		presql.setInt(2, java);
		presql.setInt(3, linux);
		presql.setInt(4, stdnum);
		
		presql.executeUpdate();
	}
	public void searchStduent(int stdnum) throws SQLException {
		conn=db.login();
		String query = "select * from student where stnum = ?";
		PreparedStatement presql = null;
		presql = conn.prepareStatement(query); // 형식 보내기
		presql.setInt(1, stdnum);
		rs = presql.executeQuery();
		
		System.out.println("==========================================================================================");
		System.out.print("사번\t이름\t신입/경력\t인턴여부 경력년수\tc\tLinux\tJAVA\t총점\t평균 \t 합격여부\n");
		System.out.println("==========================================================================================");
		while(rs.next()){
			System.out.print(rs.getString(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			if(rs.getInt(7)==0) {
				System.out.print("신입\t");						
			}
			else
				System.out.print("경력\t");
			System.out.print(rs.getString(6)+"\t");	
			System.out.print(rs.getString(7)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.print(rs.getString(4)+"\t");
			System.out.print(rs.getString(5)+"\t");
			int sum = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
			System.out.print(sum+"\t");
			System.out.print(sum/3+"\t");
			if(sum/3>70) {
				System.out.print("합격");
			}
			else
				System.out.print("불합격");
			
			System.out.println();
			System.out.println("==========================================================================================");
	}
		
		
	}
	
	
	@Override
	public void printStudents(int printType) throws SQLException {

	
		conn=db.login();
		String query ="select stnum,stname,langC,langLi,langJava,internYn,carrerYear,(langLi+langJava+langC) as sum,(langLi+langJava+langC)/3 as avg,case when (langLi+langJava+langC)/3>80 then '합격' else '불합격' end as pass from student order by stnum";
		
		System.out.println("==========================================================================================");
		System.out.print("사번\t이름\t신입/경력\t인턴여부 경력년수\tc\tLinux\tJAVA\t총점\t평균 \t 합격여부\n");
		System.out.println("==========================================================================================");
		switch(printType) {
		case 1:
			//String query = "select stnum,stname,langC,langLi,langJava,internYn,carrerYear,(langLi+langJava+langC) as summ,(langLi+langJava+langC)/3 as avg,case when (langLi+langJava+langC)/3>80 then '합격' else '불합격' end from student;";
			
			//String query = "select * from student";
			selectPs = conn.createStatement(); // 형식 보내기
			rs = selectPs.executeQuery(query);
			
			while(rs.next()) {
				
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				if(rs.getInt(7)==0) {
					System.out.print("신입\t");						
				}
				else
					System.out.print("경력\t");
				System.out.print(rs.getString(6)+"\t");	
				System.out.print(rs.getString(7)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt(8)+"\t");
				System.out.print(rs.getInt(9)+"\t");
				System.out.print(rs.getString(10)+"\t");
				
//				int sum = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
//				System.out.print(sum+"\t");
//				System.out.print(sum/3+"\t");
//				if(sum/3>70) {
//					System.out.print("합격");
//				}
//				else
//					System.out.print("불합격");
				System.out.println();
			}
			break;
		case 2:
			//String query1 = "select * from student";
			//String query1 ="select stnum,stname,langC,langLi,langJava,internYn,carrerYear,(langLi+langJava+langC) as summ,(langLi+langJava+langC)/3 as avg,case when (langLi+langJava+langC)/3>70 then '합격' else '불합격' end from student";
			selectPs = conn.createStatement(); // 형식 보내기
			rs = selectPs.executeQuery(query);
			
			while(rs.next()){
				//int sum = rs.getInt(3)+rs.getInt(4)+rs.getInt(5);
				
				//if(sum/3>80) {
				if(rs.getInt("avg")>80) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				if(rs.getInt(7)==0) {
					System.out.print("신입\t");						
				}
				else
					System.out.print("경력\t");
				System.out.print(rs.getString(6)+"\t");	
				System.out.print(rs.getString(7)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt("sum")+"\t");
				System.out.print(rs.getInt("avg")+"\t");
				System.out.print("합격");
				System.out.println();
				}
		}
			break;
		case 3:
			selectPs = conn.createStatement(); // 형식 보내기
			rs = selectPs.executeQuery(query);
			while(rs.next()){

				if(rs.getInt("avg")<80) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				if(rs.getInt(7)==0) {
					System.out.print("신입\t");						
				}
				else
					System.out.print("경력\t");
				System.out.print(rs.getString(6)+"\t");	
				System.out.print(rs.getString(7)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getInt("sum")+"\t");
				System.out.print(rs.getInt("sum")/3+"\t");
				System.out.print("불합격");
				System.out.println();
				}
		}
			break;
		}
		System.out.println("==========================================================================================");
	}
}
