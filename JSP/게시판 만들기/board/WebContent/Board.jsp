<%@page import="javax.xml.ws.RequestWrapper"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	Properties prop = new Properties();
	prop.load(new FileInputStream("F:/IT/JAVA/workspace/board/DBINFO.properties"));

	Connection conn=null;
	Statement stmt=null;
	ResultSet rs;
	
	Class.forName(prop.getProperty("driver"));
	conn=DriverManager.getConnection(
			prop.getProperty("url"),
			prop.getProperty("user"),
			prop.getProperty("pwd"));
	stmt= conn.createStatement();
	rs=stmt.executeQuery("select distinct nvl(ename,0) from emp");
	
	out.println("<table border=1>");
	
	while(rs.next()){
		out.println("<tr>");
		out.println("<td>"+rs.getString(1)+"</td>");
	}
	out.println("</table>");
	conn.close();
%>

</body>
</html>