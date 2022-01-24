package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Test288{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		
		/*
			���⼭ conn.close()�ϴ� ���� �������� �ʴ�.
			stmt�� conn�� Ÿ�� SQL�� �����ϰ� �� ����� �޾ƿ��� ������ �����Ѵ�.
			conn.close() �Ǿ������ ���������� ������ �� ����.
			
			�׷��� �ݵ�� �� ������� �ڵ� ¥��.
			conn ���� -> stmt ���� -> SQL ������ -> stmt �ݰ� -> conn �ݰ�
		*/
		
		/*
		CREATE TABLE test01_T(
			no INT,
			data VARCHAR(10)
		);
		*/
		
		
		int r = stmt.executeUpdate("INSERT INTO test01_T VALUES (101, 'Apple2')");
		r = stmt.executeUpdate("UPDATE test01_T SET no = 2345, data = 'AppleX'");
		//r = stmt.executeUpdate("DELETE FROM test01_T");
		System.out.println(r);
		
		stmt.close();
		conn.close();
		
	}
}

/*
	executeUpdate �Լ��� ���ϰ��� �ش� �۾����� ���� ����� ���ڵ��� ������ �ǹ��Ѵ�.(�����Ͱ� �ƴ϶� ���ڵ�)
	���� �������� ������� SET no = 2345, data = appleX ���� x2 ���� ���Ծ�� �ߴ�.
	
	executeUpdate �Լ��� INSERT, DELETE, UPDATE ������ �����ų �� ����Ѵ�.
*/