package banana;

import java.sql.*;

public class Test298 {
	public static void main( String[] args ) throws Exception{
		Connection conn = null;
		Statement stmt = null;
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		stmt = conn.createStatement();
		
		String data = null;
		// String sql = "INSERT INTO temp09_T VALUES ('" + data + "')";
		String sql = (data != null) ?
			"INSERT INTO temp09_T VALUES ('" + data + "')" :
			"INSERT INTO temp09_T VALUES (NULL)";
		
		System.out.println(sql);    // sql���� ���� ���� �ѹ� ���� �� ������ ����.
		stmt.executeUpdate(sql);
		
		conn.close();
		stmt.close();
	}
}

/*
// data�� null���� ������ ������ ����. not null�� �ƴѵ� ���ϱ�?
�ϴ� System.out.println(sql); �� �ѹ� ����.
>> INSERT INTO temp09_T VALUES ('null')
data�� 2���ڱ����� �Է��� �ǹǷ�, null�̶�� ���ڿ��� �Է��� �� �ȴ�. �׷� �ΰ��� ���� �� ��� �ؾ� �ұ�?

CREATE TABLE temp09_T(
	data CHAR(2)
);
*/