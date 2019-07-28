



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.InputStreamReader;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;

import org.apache.http.impl.client.HttpClientBuilder;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





public class crawling {

	

	public static String getCurrentData(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        return sdf.format(new Date());

	}

	

	public static void main(String[] args) throws ClientProtocolException, IOException {

		

		// 1. 가져오기전 시간 찍기

		

		
/*
		// 2. 가져올 HTTP 주소 세팅

	    //HttpPost http = new HttpPost("http://finance.naver.com/item/coinfo.nhn?code=045510&target=finsum_more");
	    HttpPost http = new HttpPost("https://www.fatsecret.kr/칼로리-영양소/search?q=밥");



	    // 3. 가져오기를 실행할 클라이언트 객체 생성

	    HttpClient httpClient = HttpClientBuilder.create().build();

	    

	    // 4. 실행 및 실행 데이터를 Response 객체에 담음

	    HttpResponse response = httpClient.execute(http);

	    

	    // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음

	    HttpEntity entity = response.getEntity();

	    

	    // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴 

	    ContentType contentType = ContentType.getOrDefault(entity);

        Charset charset = contentType.getCharset();

        
        
        // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향) 
        
	    BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));

	    

	    // 8. 가져온 DOM 데이터를 담기위한 그릇

	    StringBuffer sb = new StringBuffer();

	    

	    // 9. DOM 데이터 가져오기

	    String line = "";
	    
	    while((line=br.readLine()) != null){
	    	sb.append(line+"\n");
	    }

	    // 10. 가져온 아름다운 DOM을 보자
	    System.out.println(sb.toString());
	   

	    System.out.println("================================================================");

	    // 11. Jsoup으로 파싱해보자.
	    
	    */
		
	    //Document doc = Jsoup.parse(sb.toString());
		String kaclo="";
	    String dang="";
	    
	    
		
		Connection conn = null;
		Connection conn2 = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from ing_cal_price";
			String sql2 ="update ing_cal_price set ING_CAL=?,ING_NUM=? where ING_NAME =?";
			conn = dbcon();
			
			stmt = conn.createStatement();
			pstmt = conn2.prepareStatement(sql2);
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String key = rs.getString("ING_NAME");
				
				
				
				
				
			}
			
		}
		catch(Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		
		
		
		Document doc = Jsoup.connect("https://www.fatsecret.kr/칼로리-영양소/search?q="+key).get();
		

	    // 참고 - Jsoup에서 제공하는 Connect 처리
	    //Document doc2 = Jsoup.connect("http://finance.naver.com/item/coinfo.nhn?code=045510&target=finsum_more").get();
	    //System.out.println(doc2.data());
	    
	    
	    Elements items = doc.select(".borderBottom a");
	    String[] kcal = new String[] {"0"};
	    for(int i = 0;i<items.size();i++) {
	    		if(items.get(i).text().equals(key)) {
	    			kcal = items.get(i).parent().select("div").text().split(" ");
	    	}
	    }
	    for(int i = 0 ;i<kcal.length;i++) {
	    	
	    	if(kcal[i].contains("당")) {
	    		for(int j=0;j<i+1;j++) {
	    			dang=dang+(kcal[j]);
	    		}
	    	}
	    	if(kcal[i].contains("칼로리")) {
	    		kaclo=kcal[i+1];
	    	}
	    }
	    System.out.println("단위  = "+dang);
	    System.out.println("kcal = "+kaclo);
	}
	
	public static Connection dbcon() {
		Connection conn = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("F:/IT/JAVA/workspace/AAAAAAAAAAAAAAAAAAAAA/DBINFO.properties"));
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pwd"));
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을수없습니다.");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {//��� ���� ����
			e.printStackTrace();
		}
		
		
		
		
		
		return conn;
	}

}
