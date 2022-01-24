package banana;

import java.sql.*;

public class Test303 {
	public static void main( String[] args ) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
			
		/*
			CREATE PROCEDURE proc_apple2(IN v_no INT, IN v_data VARCHAR(10), OUT v_uc INT)
			매개변수가 총 3개 해서 ?도 3개 필요하다.
			앞의 두개 변수는 IN이니까 이때까지 하던거랑 같다.
			
			OUT으로 선언된 매개변수는 안에서 밖으로 대입하는 형태라서 미리 받겠다고 등록해 주어야 한다.
			-- stmt.registerOutParameter(3, Types.INTEGER);
			
			execute() 이후에 stmt.getInt(3)으로 확인 가능. 3은 3번째 ?에 등록된 값을 읽겠다는 얘기.
			
			Types.INTEGER 이외에 Types_CHAR, Type.VARCHAR 등도 있으니 상황에 맞게 쓰면 된다.
		*/
			
		String sql = "CALL proc_apple2(?, ?, ?)";
		CallableStatement stmt = conn.prepareCall(sql);
		
		stmt.setInt(1, 401);
		stmt.setString(2, "WorldHello");
		stmt.registerOutParameter(3, Types.INTEGER);
		stmt.execute();
		
		int abcd = stmt.getInt(3);
		System.out.println(abcd);
		
		stmt.close();
		conn.close();
	}
}
/*

	DELETE FROM temp11_T;

*/

