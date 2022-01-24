package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Test286 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung00",
			"pukyung00","pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO test01_T VALUES (10101,'Apple')");
/*
CREATE TABLE test01_T (
no INT ,
data VARCHAR(10) 
);
*/
		stmt.close();

		conn.close();
	}
}
/*	
	Statement �� �������̽���. ( Driver �� �Ʒ����� �˾Ƽ� �� ���ְ� ���� )
	Statement �� conn �� Ÿ�� SQL ���� �Ǿ� ������ �ٱ��϶�� ���� �ȴ�. 
	
	SQL ������ �Ǿ� ������ > DB �� ������ > ���� ����� �޾Ƽ� > ���ƿ´�.
	�ϳ��� SQL ������ �ϳ��� Statement �� �����Ѵ�" ��� �� �� �ִ�. 

-----------------------------------------------------------------------------------

	Connection ������ �������ӿ� ������ �ִ� �� �� �� �ִ�. ������ ��������� �Ѵ�.
	�ؼ� �ݵ��!! Connection �� ����Ŀ� close() �� �־�� �Ѵ� ( ���� ���� )
	
	Connection �� ������ ��� �ڿ��̴�.
	
	Connection �� ���ϱ� 11������ �ݼ��͸� �����ϸ� �ȴ�. > ������ �����ָ鼭 ä���ϴ��� 
		11���� �ݼ��Ϳ� ��ȭ�� �ؼ� ... 8�ð��� �λ� �ϼҿ� �ϴ� ���� �ִٸ�?? ���ذ� �����ϴ�.
		��ȭ���� > �ֹ���� > �׷��� ���� ������� ���� ���´�!!!
		
		11���� �ݼ��Ϳ� ��ȭ�ؼ� ����Ǹ� �װ� Connection �� �̷�����Ϳ� ������ �� �ְ�,
		��ȭ�� ���°� conn.close() �� �ش��Ѵ�. -> ����� �������� ���� ���°� �ְ�!!
*/

