package banana;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import bang01.Bang01VO;

public class Test294{
	public static void main(String[] args) throws Exception{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
			"jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17",  "pukyung00!!1");
			
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM bang01_T");
		
		List<Bang01VO> ls = new ArrayList<Bang01VO>();
		
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
		
		for(Bang01VO vo : ls){
			System.out.println(vo.getNo() + "," + vo.getContent());
		}
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



javac -classpath c:\classes -d c:\classes Test294.java
java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.Test294


REM save as c2.bat
javac -d c:\classes %1.java
java -classpath c:\classes;c:\jars\mariadb-java-client-2.5.1.jar banana.%1
*/