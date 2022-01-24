package banana;

import java.sql.*;

/*
	BatchUpdate & PreparedStatement 를 같이 쓸 때.
	   
*/

public class Test309 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
			/*
				여기서 생성한 stmt는 딱 한개다
				stmt.addBatch();를 딱 5번 했다. 이건 5개의 SQL문이 탑재되었다는 의미인데
				하나의 Statement 인스턴스로 5개의 SQL 문장을 실행시키는게 말이 되나?
				
				여러 레코드를 한꺼번에 수정하는 경우에 한꺼번에 모아서 처리하는게 성능이 좋다.
			*/
			//stmt = conn.createStatement();
			String sql2 = "INSERT temp14_T VALUES (?, 'K')";
			stmt = conn.prepareStatement(sql2);    // 인스턴스는 하나 만듦
			for(int i=10; i<15; i++){    // 5번 실행?
				stmt.setInt(1, i);  //세팅
				stmt.addBatch();     //쌓기
				stmt.clearParameters();    // 앞에서 세팅했던 setInt 값을 비우고 새롭게 값을 받도록 세팅함.
			}
			stmt.executeBatch();
			
		}
		catch(Exception e){
			throw e;
		}
		finally{
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}
		
	}
}
/*


*/