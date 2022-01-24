package banana;

import java.sql.*;

public class Test284 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17", "pukyung00!!1");
			
		System.out.println(conn.toString());
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NOW()");
		
		if(rs.next()){
			String l = rs.getString(1);
			System.out.println(l);
		}
		
		rs.close();
		stmt.close();
		
		conn.close();
	}
}

/*
	������ -> ��ġ���� ���� -> connection -> statement -> ResultSet
	Class.forName("org.mariadb.jdbc.Driver");
	-- ���ڿ� �̸��� Ŭ������ ã�´�.
	
	java -d c:\classes Test284
	java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test284
	classpath���� ������ ���� �Ǵ� ������ ������ �� �ְ�, ������ �������� ; ���н��� :
	
	*.jars�� ������ ? -- *.class ������ ü�������� ������ ����.
	
	�Ϲ������� ������ ����� *.jar ���·� �����ϰ� �ȴ�.
	������ jar ������ ����ϱ� ���ؼ��� -classpath���� �ش� ������ �����ϸ� �ȴ�.
	(�����Ͻ� & �����)
	
	
		Connection conn = DriverManager.getConnection(
		"jdbc:mariadb://183.111.242.21:3306/pukyung17",
		"pukyung17","pukyung00!!1");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT NOW()");
		
		if(rs.next()){
			String l = rs.getString(1);
			System.out.println(l);
		}
		
		rs.close();
		stmt.close();
		
		System.out.println(conn.toString());
		conn.close();
*/

/*
MySQL�� �ϳ��� ������ �������� database �� �� ����.
database �������� �����ϱ� ���� �ִ°� ����.
CREATE TABLE temp_02T(
	id INT NULL,
	data VARCHAR(9) NULL
);

INSERT INTO temp_02T VALUES(100, 'ȫ�浿');
--INSERT :  ���� �� �� �Է�

SELECT * FROM temp_02T;
--SELECT :  ���� ��ȸ

UPDATE temp_02T SET id = 300;
--UPDATE : �ԷµǾ� �ִ� �����͸� ����

DELETE FROM temp_02T;
--DELETE : �Էµ� �����͸� ����

VARCHAR(9) : UTF-8 ���ڼ¿����� �ѱ�1����=����3����.

���̺��� ���θ� Column / Field ��� �Ѵ�.
�̰��� �ڷ����� ���̺� ������ �ο��ϰ�, ���� �Ұ���.
���� ������ Row / Record ��� �Ѵ�.
�̰��� �Է��� ������ �ȴ�.

INSERT INTO temp_02T VALUES(123,'�ڱ浿');
-- ������ �ִ´�. �Է��� �⺻�� �� ���̴�.
�ϳ��� ���? �� ���� �ڷ��� ������ �ȴ�.

�̷��� ���ڵ�/�ʵ� ������ �ִ� ǥ ������ �������� ���̺��̶�� �Ѵ�.

���� ��Ʈ�� �̰����� ������ �� �� �ִ�

SELECT * FROM temp_02T WHERE data = '��浿';
-- WHERE�� SELECT UPDATE DELETE ����� ����Ǵ� ���ڵ带 �����Ѵ�.

SELECT * FROM temp_02T WHERE data = '��浿' OR id = 300;

DELETE FROM temp_02T WHERE id2 = 200;

UPDATE temp_02T SET id = id + 1;
-- ������Ʈ�� �� ������ ���� �̿��ϴ� �͵� �����ϴ�!
UPDATE temp_02T SET id = id + 1 WHERE id = 101;
���� �ʴٴ� !=, <> �Ѵ� �ᵵ �ȴ�.
SELECT * FROM temp_02T WHERE id BETWEEN 301 AND 401;
id >= 301 and id <= 401 �� �����ϴ�.

*/