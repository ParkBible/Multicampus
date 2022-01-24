package banana;

import java.sql.*;

public class Test299 {
	public static void main( String[] args ) throws Exception{
		Connection conn = null;
		//Statement stmt = null;
		
		Class.forName("org.mariadb.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
			"pukyung17","pukyung00!!1");
		//stmt = conn.createStatement();
		
		/*
			statement는 conn에 달려있는 바구니 같은 개념. SQL문을 아예 새겨넣은 바구니가 PreparedStatement이다.
			해당 SQL에는 ?라는 빈공간을 만들어 넣을 수 있다.
			?로 비워놓은 공간에 데이터를 채워넣는다.
			stmt.setString(1, "XY");
			이때는 executeUpdate 시에 매개변수가 존재하지 않는다.
			
			다른 이유도 있지만 NULL에 대한 처리가 PrepareStatement를 쓰면 훨씬 깔끔하다.
			속도도 좀 더 빨라지는 효과가 있어서 실전에서는 이걸 더 많이 쓴다.
		*/
		
		String sql = "INSERT INTO temp09_T VALUES (?)";
		PreparedStatement stmt = conn.prepareStatement(sql);    // 함수 이름도 바뀐다.
		
		stmt.setString(1, null);    // 물음표에 값을 채움
		stmt.executeUpdate();    // 왕복하게 만든다
		
		conn.close();
		stmt.close();
	}
}

/*
		String data = null;
		// String sql = "INSERT INTO temp09_T VALUES ('" + data + "')";
		String sql = (data != null) ?
			"INSERT INTO temp09_T VALUES ('" + data + "')" :
			"INSERT INTO temp09_T VALUES (NULL)";
		
		System.out.println(sql);    // sql문을 썼을 때는 한번 찍어보는 게 굉장히 좋다.
		stmt.executeUpdate(sql);
*/