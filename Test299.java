package banana;

import java.sql.*;

public class Test299 {
	public static void main( String[] args ) throws Exception{
		Connection conn = null;
		//Statement stmt = null;
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		//stmt = conn.createStatement();
		
		/*
			statement�� conn�� �޷��ִ� �ٱ��� ���� ����. SQL���� �ƿ� ���ܳ��� �ٱ��ϰ� PreparedStatement�̴�.
			�ش� SQL���� ?��� ������� ����� ���� �� �ִ�.
			?�� ������� ������ �����͸� ä���ִ´�.
			stmt.setString(1, "XY");
			�̶��� executeUpdate �ÿ� �Ű������� �������� �ʴ´�.
			
			�ٸ� ������ ������ NULL�� ���� ó���� PrepareStatement�� ���� �ξ� ����ϴ�.
			�ӵ��� �� �� �������� ȿ���� �־ ���������� �̰� �� ���� ����.
		*/
		
		String sql = "INSERT INTO temp09_T VALUES (?)";
		PreparedStatement stmt = conn.prepareStatement(sql);    // �Լ� �̸��� �ٲ��.
		
		stmt.setString(1, null);    // ����ǥ�� ���� ä��
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
*/