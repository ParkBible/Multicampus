package banana;

import java.sql.*;

public class Test302 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
		/*
			프로시저를 jdbc에서 호출하는 형태로 쓸 때는 CallableStatement를 쓴다.
			실행할 때는 stmt.execute(); 를 사용하고, 채워넣을 때는 PreparedStatement와 같다.
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