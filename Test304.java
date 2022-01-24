package banana;

import java.sql.*;

public class Test304 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		CallableStatement stmt = conn.prepareCall("CALL proc_banana()");
		stmt.execute();
		
		// ���ν������� SELECT ����� �߻���Ű�� ��� getResultSet���� ResultSet�� ������ �� �ִ�.
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

