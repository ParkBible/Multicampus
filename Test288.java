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
			여기서 conn.close()하는 것은 적절하지 않다.
			stmt는 conn을 타고 SQL을 전달하고 그 결과를 받아오는 역할을 수행한다.
			conn.close() 되어버리면 정상적으로 전달할 수 없다.
			
			그래서 반드시 이 순서대로 코드 짜기.
			conn 생성 -> stmt 생성 -> SQL 오고가고 -> stmt 닫고 -> conn 닫고
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
	executeUpdate 함수의 리턴값은 해당 작업으로 인해 변경된 레코드의 개수를 의미한다.(데이터가 아니라 레코드)
	만약 데이터의 개수라면 SET no = 2345, data = appleX 에서 x2 값이 나왔어야 했다.
	
	executeUpdate 함수는 INSERT, DELETE, UPDATE 문장을 실행시킬 때 사용한다.
*/