package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test293{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17",  "pukyung00!!1");
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM bang01_T");
		
		while(rs.next()){
			Integer no = rs.getInt("no");
			String content = rs.getString("content");
			String theTime = rs.getString("the_time");
			String author = rs.getString("author");
			
			System.out.println(no + "," + content);
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
}

/*
	���� �����
	- ����/���� ����x, ȸ������ �ʿ� ����, �� ���� ���ϴ� ��� ����� ����.

CREATE TABLE bang01_T(
	no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,		// �۹�ȣ
	content VARCHAR(500),		// ����
	the_time DATETIME,		// ��¥
	author VARCHAR(30)		// �ۼ���
);

CREATE TABLE bang01_T(
	no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(500),
	the_time DATETIME,
	author VARCHAR(30)
);

'����1', 'Apple'
'����2', 'Banana'
'�� ���� ���ϴ�', 'Orange'

INSERT INTO bang01_T VALUES(default, '����1', NOW(), 'Apple');
INSERT INTO bang01_T VALUES(default, '����2', NOW(), 'Banana');
INSERT INTO bang01_T VALUES(default, '�� ���� ���ϴ�', NOW(), 'Orange');
*/