package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Test286{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
			
		Statement stmt = conn.createStatement();
		
		/*
		CREATE TABLE test01_T(
			no INT,
			data VARCHAR(10)
		);
		*/
		
		
		stmt.executeUpdate("INSERT INTO test01_T VALUES (10101,'Apple')");
		
		
		stmt.close();
		conn.close();
		
	
	}
}

/*
	Connection ������ �������ӿ� ������ �ִ� ���� �� �� �ִ�. ������ ��������� �Ѵ�.
	�׷��� �ݵ�� Connection�� ����Ŀ� close() ���־�� �Ѵ�.
	
	�ֳ�! Connection�� ������ ��� �۾��̴�.
	11���� �ݼ��Ϳ� ��ȭ�� �ؼ� 8�ð��� �λ� �ϼҿ��ϴ� ���� �ִٸ� ���ذ� �����ϴ�.
	������ ���ְ� ����ߴµ�...
	�׷��� ���� ������� ���� ���´�!
	
	11���� �ݼ��Ϳ� ��ȭ�ؼ� ����Ǹ� �װ� connection�� �̷���� �Ϳ� ������ �� �ְ�,
	��ȭ�� ���°� conn.close()�� �ش��Ѵ�. -> ����� �������� ���� ���� �� �ְ��!
	
	statement�� �������̽��̴�. (Driver�� �Ʒ����� �˾Ƽ� �� ���ְ� ����)
	statement �� conn�� Ÿ�� SQL���� �Ǿ� ������ �ٱ��϶�� ���� �ȴ�.
	SQL ������ �Ǿ� ������ > DB�� ������ > ���� ����� �޾Ƽ� > ���ƿ´�.
	�ϳ��� SQL ������ �ϳ��� Statement�� �����Ѵ� ��� �� �� �ִ�.


CREATE TABLE test01_T(
			no INT,
			data VARCHAR(10)
);
	
*/