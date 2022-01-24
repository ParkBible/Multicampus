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
	방명록 만들기
	- 제목/내용 구별x, 회원가입 필요 없고, 잘 보고 갑니다 라고 남기는 정도.

CREATE TABLE bang01_T(
	no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,		// 글번호
	content VARCHAR(500),		// 내용
	the_time DATETIME,		// 날짜
	author VARCHAR(30)		// 작성자
);

CREATE TABLE bang01_T(
	no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	content VARCHAR(500),
	the_time DATETIME,
	author VARCHAR(30)
);

'방명록1', 'Apple'
'방명록2', 'Banana'
'잘 보고 갑니다', 'Orange'

INSERT INTO bang01_T VALUES(default, '방명록1', NOW(), 'Apple');
INSERT INTO bang01_T VALUES(default, '방명록2', NOW(), 'Banana');
INSERT INTO bang01_T VALUES(default, '잘 보고 갑니다', NOW(), 'Orange');
*/