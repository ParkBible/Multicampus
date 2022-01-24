package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test289{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM test01_T");
		
		//stmt.close();
		//conn.close();
		
		while(rs.next()){
			int no = rs.getInt("no");
			String data = rs.getString("data");
			System.out.println(no + "," + data);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
	}
}

/*
	SELECT ���� : ResultSet executeQuery, INSERT DELETE UPDATE : int executeUpdate
	
	getInt, getString���� 1���� ������ �� ���� �ְ�, �ʵ���� �� ���� �ִ�.
	int no = rs.getInt(1);
	String data = rs.getString(2);
	

+------+--------+
| no   | data   |
+------+--------+
| 2345 | AppleX |
| 2345 | AppleX |<- flag
+------+--------+

	resultset�� ���� ���� ����� ��� �ִ�.
	���������� ���� ������ ���������� flag ������ ������ �ִ�.
	flag�� �ڷ� �̵���Ű�� �Լ��� next(), ������ true / ���нÿ� false�� �����Ѵ�.
	rs.getInt("no") : ����, flag�� ����Ű�� ����, no�� �ش��ϴ� ����, �������� ���� int���·� �����Ѵ�.
	rs.getString("data") : �������� ���� String ���·� �����Ѵ�.
*/