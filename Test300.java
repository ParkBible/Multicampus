package banana;

import java.sql.*;

public class Test300 {
	public static void main( String[] args ) throws Exception{
		Connection conn = null;
		//Statement stmt = null;
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		//stmt = conn.createStatement();
		
		int no = 10101;
		String data = "YZ";
		
		String sql = "INSERT INTO bang01_T VALUES (?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);    // �Լ� �̸��� �ٲ��.
		
		stmt.setInt(1, no);
		stmt.setString(2, data);    // ����ǥ�� ���� ä��
		stmt.executeUpdate();    // �պ��ϰ� �����
		
		conn.close();
		stmt.close();
	}
}

/*
		String data = null;
		// String sql = "INSERT INTO temp09_T VALUES ('" + data + "')";
		String sql = (data != null) ?
			"INSERT INTO temp09_T VALUES ('" + data + "')" :
			"INSERT INTO temp09_T VALUES (NULL)";
		
		System.out.println(sql);    // sql���� ���� ���� �ѹ� ���� �� ������ ����.
		stmt.executeUpdate(sql);
		
		
CREATE TABLE temp09_T(
	no INT(5)
	data CHAR(2)
);
*/

