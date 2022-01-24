package banana;

import java.sql.*;
import java.util.*;

class Bang01VO 
{
	private Integer no = null;
	public Integer getNo(){ return this.no; }
	public void setNo( Integer i ){ this.no = i; }
	
	private String content = null;
	public String getContent(){ return this.content; }
	public void setContent( String i ){ this.content = i; }
	
	private String theTime = null;
	public String getTheTime(){ return this.theTime; }
	public void setTheTime( String i ){ this.theTime = i; }
	
	private String author = null;
	public String getAuthor(){ return this.author; }
	public void setAuthor( String i ){ this.author = i; }
}

/*
	DAO 패턴의 결정적인 핵심 개념
	-IA a = new A() 개념 적용.
	클래스 이름에 사용하는 DB 타입을 명시한다.
	
	BangDAO dao = new BangDAO(); 코드를 BangDAO dao = new BangDAO_MariaImpl(); 로 인스턴스만 바꾼다.
	
	일 분배가 회사마다 틀리지만 빨간색 단위로 분배되는 경우가 많다.(프론트엔드, 백엔드, 디비)
	다 할 줄 아는 사람이 드물다.
	백엔드 담당은 디비를 가져와서 작업한다.
	Database 담당이 DAO를 맡는다고 할 때
	백엔드와 DB 담당이 동시에 일을 하게 하려면?
	백엔드 담당이 DB 담당이 일 끝나기까지 놀지 않게 하려면?
*/

interface BangDAO{
	public List<Bang01VO> findAll() throws Exception;
	public void add(Bang01VO pvo) throws Exception;
}

// 가짜 DAO를 하나 만든다.
// 인터페이스를 상속하여 돌아가게 만들고 이걸로 일단 백엔드를 구현하고 돌아가는지 테스트 한 뒤에 디비 담당이 BangDAO_MariaImpl를 가져오면 인스턴스만 교체한다.
class BangDAO_KaraImpl implements BangDAO{
	
	// 가베지 콜렉션 되어도 이 안에 담긴 내용은 안 날라간다.
	private static List<Bang01VO> ls = null;
	private static int count = 1;
	static{
		ls = new ArrayList<Bang01VO>();
	}
	
	public List<Bang01VO> findAll() throws Exception{
		return ls;
	}
	
	public void add(Bang01VO pvo) throws Exception{
		pvo.setNo(count++);
		pvo.setTheTime("1999-12-12 00:00:00");
		
		ls.add(pvo);
	}
}

class BangDAO_MariaImpl implements BangDAO{
	public List<Bang01VO> findAll() throws Exception 
	{
		List<Bang01VO> ls = new ArrayList<Bang01VO>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
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
			throw e;
		}
		finally {
			if( rs != null ) rs.close();
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
		
		return ls;
	}
	
	public void add( Bang01VO pvo ) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung00",
				"pukyung00","pukyung00!!1");
			stmt = conn.createStatement();

			String sql = "INSERT INTO bang01_T VALUES ( default, '"+
				pvo.getContent() + "', NOW() , '" + pvo.getAuthor() + "')";
			stmt.executeUpdate( sql );
		}
		catch ( Exception e ) {
			throw e;			
		}
		finally {
			if( stmt != null ) stmt.close();
			if( conn != null ) conn.close();
		}
	}
}

public class Test297 {
	public static void main( String[] args )
	{
		// BangDAO dao = new BangDAO_MariaImpl();     디비만드는사람이 다만들었다고 하면 이걸로 바꾼다.
		BangDAO dao = new BangDAO_KaraImpl();
		try {
			Bang01VO pvo = new Bang01VO();
			pvo.setContent("DAO Content");
			pvo.setAuthor("daoAuthor");
			
			dao.add( pvo );
			List<Bang01VO> ls = dao.findAll();
			
			for( Bang01VO vo : ls ) {
				System.out.println( vo.getNo() + "," + vo.getContent() );
			}
		}
		catch( Exception e ) {
			System.out.println( e.toString() );
		}
	}
}
/*

*/