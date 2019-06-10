JDBC 초기 환경설정

```java
package lab.java.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버있음");
			DriverManager.getConnection(url,"scott","oracle");
			System.out.println("연결 성공");
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("실패");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

```

