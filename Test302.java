package banana;

import java.sql.*;

public class Test302 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
		/*
			���ν����� jdbc���� ȣ���ϴ� ���·� �� ���� CallableStatement�� ����.
			������ ���� stmt.execute(); �� ����ϰ�, ä������ ���� PreparedStatement�� ����.
		*/
			
		String sql = "CALL proc_apple(?, ?)";
		CallableStatement stmt = conn.prepareCall(sql);
		
		stmt.setInt(1, 401);
		stmt.setString(2, "WorldHello");
		stmt.execute();
		
		stmt.close();
		conn.close();
	}
}
/*

	DELETE FROM temp11_T;

*/