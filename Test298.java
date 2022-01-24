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
		
		System.out.println(sql);    // sql문을 썼을 때는 한번 찍어보는 게 굉장히 좋다.
		stmt.executeUpdate(sql);
		
		conn.close();
		stmt.close();
	}
}

/*
// data에 null값을 넣으면 에러가 난다. not null이 아닌데 왜일까?
일단 System.out.println(sql); 로 한번 찍어본다.
>> INSERT INTO temp09_T VALUES ('null')
data는 2글자까지만 입력이 되므로, null이라는 문자열은 입력이 안 된다. 그럼 널값을 넣을 땐 어떻게 해야 할까?

CREATE TABLE temp09_T(
	data CHAR(2)
);
*/