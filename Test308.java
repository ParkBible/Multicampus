package banana;

import java.sql.*;

/*
	트랜젝션은 한꺼번에 모아서 실행하는 개념인가요?
	-- 한꺼번에 반영하거나 취소하는 개념은 맞는데 모아서 실행한느 개념과는 좀 거리가 있다.
	   모아서 실행하는 개념 : BatchUpdate 개념.
	   
*/

public class Test308 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			stmt = conn.createStatement();
			
			String sql1 = "UPDATE Text_HT SET recom = recom + 1 WHERE no = 2";
			String sql2 = "INSERT Recom_HT VALUES (3, 'Apple')";
			// 반영이 안되고있다. 실행하는 명령이 아니라 차곡차곡 쌓는 명령이기 때문.
			stmt.addBatch(sql1);    
			stmt.addBatch(sql2);
			
			// 가서 실행하고 담아서 돌아오라는 명령. (쌓은걸 한꺼번에 실행한다.)
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