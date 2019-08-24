import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling8 {
	public static void main(String[] args) {
   		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Properties prop = new Properties();
		
		int count =0;
		
		try {
			prop.load(new FileInputStream("F:/IT/JAVA/workspace/AAAAAAAAAAAAAAAAAAAAA/DBINFO.properties"));
			
			/*DB*/
			String sql = "select * from recipe where rownum < 196 order by rownum desc";
			String sql2 ="update recipe set ORDER_DETAIL = ? where RECIPE_NAME = ? ";
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd"));
			
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql2);
			
			
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				//크롤링 사용하는 부분
				Document doc = Jsoup.connect(rs.getString("DETAIL_URL")).timeout(300000).get();
				
				Elements items = doc.select(".cookProcess");
				//크롤링 끝
			    
			    pstmt.setString(1,items.text());
			    pstmt.setString(2,rs.getString("RECIPE_NAME"));
			    
			    pstmt.addBatch();
			    pstmt.clearParameters();
			    
			    count++;
			    
			    System.out.println(count);
				//배치로 DB에데이터 한번에 넣기
			    if(count%100 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();
					conn.commit();
					System.out.println("넣");
				}
			}
			
			pstmt.executeBatch();
			pstmt.clearBatch();
			conn.commit();
			System.out.println("끝");
		}
		catch(Exception e) {
			System.out.println("Error(main): "+e.getMessage());
		}	    
	}
}
