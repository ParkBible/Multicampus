package banana;

import java.sql.*;

public class Test303 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
		/*
			CREATE PROCEDURE proc_apple2(IN v_no INT, IN v_data VARCHAR(10), OUT v_uc INT)
			�Ű������� �� 3�� �ؼ� ?�� 3�� �ʿ��ϴ�.
			���� �ΰ� ������ IN�̴ϱ� �̶����� �ϴ��Ŷ� ����.
			
			OUT���� ����� �Ű������� �ȿ��� ������ �����ϴ� ���¶� �̸� �ްڴٰ� ����� �־�� �Ѵ�.
			-- stmt.registerOutParameter(3, Types.INTEGER);
			
			execute() ���Ŀ� stmt.getInt(3)���� Ȯ�� ����. 3�� 3��° ?�� ��ϵ� ���� �аڴٴ� ���.
			
			Types.INTEGER �̿ܿ� Types_CHAR, Type.VARCHAR � ������ ��Ȳ�� �°� ���� �ȴ�.
		*/
			
		String sql = "CALL proc_apple2(?, ?, ?)";
		CallableStatement stmt = conn.prepareCall(sql);
		
		stmt.setInt(1, 401);
		stmt.setString(2, "WorldHello");
		stmt.registerOutParameter(3, Types.INTEGER);
		stmt.execute();
		
		int abcd = stmt.getInt(3);
		System.out.println(abcd);
		
		stmt.close();
		conn.close();
	}
}
/*

	DELETE FROM temp11_T;

*/

