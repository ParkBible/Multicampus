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
	Statement 도 인터페이스다. ( Driver 가 아래에서 알아서 다 해주고 있음 )
	Statement 는 conn 을 타고 SQL 문을 실어 나르는 바구니라고 보면 된다. 
	
	SQL 문장을 실어 나르고 > DB 에 떨구고 > 동작 결과를 받아서 > 돌아온다.
	하나의 SQL 문장은 하나의 Statement 로 실행한다" 라고 볼 수 있다. 

-----------------------------------------------------------------------------------

	Connection 생성시 소켓접속용 정보를 주는 걸 볼 수 있다. 실제로 소켓통신을 한다.
	해서 반드시!! Connection 은 사용후에 close() 해 주어야 한다 ( 소켓 끊음 )
	
	Connection 은 굉장히 비싼 자원이다.
	
	Connection 을 비교하길 11번가의 콜센터를 생각하면 된다. > 직원들 월급주면서 채용하더라 
		11번가 콜센터에 전화를 해서 ... 8시간을 인생 하소연 하는 고객이 있다면?? 손해가 막심하다.
		전화연결 > 주문취소 > 그러면 빨리 끊어줘야 돈이 굳는다!!!
		
		11번가 콜센터에 전화해서 연결되면 그게 Connection 이 이루어진것에 비유할 수 있고,
		전화를 끊는게 conn.close() 에 해당한다. -> 용건이 끝났으면 빨랑 끊는게 최고!!
*/

