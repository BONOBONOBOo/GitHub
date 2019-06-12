package com.grade.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CommonUtil {
	
	private static Connection conn = null;
	//private Properties prop = new Properties();
	
	
	public static String getUserInput() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static double round(double input) {
		return Double.parseDouble(String.format("%.1f", input));
	}
	
	public Connection login() {
		
		try {
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("F:/IT/JAVA/workspace/JAVA_WORKSHOP6_GRADE/src/com/grade/util/DBINFO.properties"));
//			driver=oracle.jdbc.Prac;eDrover
//			url=jdbc::oracle:@localost:1521:rac1
//			user=scott
//			pwd=oracle
			
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd"));//드라이버로 연결 얻어내기
			//conn.setAutoCommit(false);
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("드라이브를 찾을수없습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
