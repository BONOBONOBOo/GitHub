# JDBC 초기 환경설정





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

Statement

* 완전한 sql문장을 전송할때 사용한다.
  * 동일한 문장의 파라미터만 변할 때에도 하드패싱을 수행한다.
  * 반복문을 사용 할 경우 성능이 안좋아질수있다.

Prepared Statement

* 인자를 따로 설정해서 완성된 구문을 실행한다.