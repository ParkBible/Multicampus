package banana;

import java.sql.*;
import bang01.Bang01VO;
import java.util.*;

public class Test295 {
	public static void main( String[] args )
	{
		List<Bang01VO> ls = new ArrayList<Bang01VO>();

		try {
			// 어떤 상황에서도 close()가 실행되도록 예외처리 & 에러가 나면 받고 다시 던지는 형태 포함
			// 선언은 다 밖으로 빼주기
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(
					"jdbc:mariadb://183.111.242.21:3306/pukyung17",
					"pukyung17","pukyung00!!1");
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM bang01_T");
				while( rs.next() ) {
					Bang01VO vo = new Bang01VO();
					vo.setNo( rs.getInt("no") );
					vo.setContent( rs.getString("content") );
					vo.setTheTime( rs.getString("the_time") );
					vo.setAuthor( rs.getString("author") );
					ls.add( vo );
				}
			}
		
			catch( Exception e ) {
				System.out.println( e.toString() );
			}
			
			finally{
				// 조건문 안주면 null포인트 exception 오류 뜬다.
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();		
			}
		
			for( Bang01VO vo : ls ) {
				System.out.println( vo.getNo() + "," + vo.getContent() );
			}
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
	}
}
/*
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://183.111.242.21:3306/pukyung17",
				"pukyung17","pukyung00!!1");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM bang01_T");
			while( rs.next() ) {
				Bang01VO vo = new Bang01VO();
				vo.setNo( rs.getInt("no") );
				vo.setContent( rs.getString("content") );
				vo.setTheTime( rs.getString("the_time") );
				vo.setAuthor( rs.getString("author") );
				ls.add( vo );
			}
			rs.close();
			stmt.close();
			conn.close();
*/