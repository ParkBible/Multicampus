package banana;

import java.sql.*;

public class Test307 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			stmt = conn.createStatement();
			
			/*
				기본적으로 JDBC는 AutoCommit = TRUE 인 상황에서 execute된다.
				즉 별도의 트랜젝션 보장 코드가 없으면 뒤의 문장에서 에러가 나도 앞의 문장이 자동으로 취소되는
				일은 없다.
			*/
			
			String sql1 = "UPDATE Text_HT SET recom = recom + 1 WHERE no = 2";
			String sql2 = "INSERT Recom_HT VALUES (2, 'Apple')";
			stmt.executeUpdate(sql1);    // 바로 반영이 된다. 아까처럼 취소 못함.
			stmt.executeUpdate(sql2);
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