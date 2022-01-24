package banana;

import java.sql.*;

public class Test306 {
	public static void main( String[] args ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			
			String sql1 = "UPDATE Text_HT SET recom = recom + 1 WHERE no = 2";
			String sql2 = "INSERT Recom_HT VALUES (2, 'Apple')";
			
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			conn.commit();    // COMMIT; °ú µ¿ÀÏ.
		}
		catch(Exception e){
			if(conn != null)
				conn.rollback();
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