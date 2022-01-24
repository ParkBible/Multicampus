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
	SELECT 문장 : ResultSet executeQuery, INSERT DELETE UPDATE : int executeUpdate
	
	getInt, getString에는 1부터 순서를 줄 수도 있고, 필드명을 줄 수도 있다.
	int no = rs.getInt(1);
	String data = rs.getString(2);
	

+------+--------+
| no   | data   |
+------+--------+
| 2345 | AppleX |
| 2345 | AppleX |<- flag
+------+--------+

	resultset은 위와 같은 결과를 담고 있다.
	내부적으로 가로 방향을 가로지르는 flag 변수를 가지고 있다.
	flag를 뒤로 이동시키는 함수가 next(), 성공시 true / 실패시에 false를 리턴한다.
	rs.getInt("no") : 현재, flag가 가리키는 가로, no에 해당하는 세로, 교차점의 값을 int형태로 리턴한다.
	rs.getString("data") : 교차점의 값을 String 형태로 리턴한다.
*/