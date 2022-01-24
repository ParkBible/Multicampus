package banana;

import java.sql.*;

public class Test304 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		CallableStatement stmt = conn.prepareCall("CALL proc_banana()");
		stmt.execute();
		
		// 프로시져에서 SELECT 결과를 발생시키는 경우 getResultSet으로 ResultSet을 추출할 수 있다.
		ResultSet rs = stmt.getResultSet();
		while(rs.next()){
			Integer no = rs.getInt("no");
			String data = rs.getString("data");
			
			System.out.println(no + "," + data);
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
/*
DROP PROCEDURE IF EXISTS proc_banana;

DELIMITER //
CREATE PROCEDURE proc_banana ()
BEGIN
	SELECT no, data FROM temp11_T;
	
END;
//
DELIMITER ;

CALL proc_banana();

*/

