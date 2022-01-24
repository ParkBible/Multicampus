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

interface BangDAO 
{
	public List<Bang01VO> findAll() throws Exception ;
	public void add( Bang01VO pvo ) throws Exception ;
}

class BangDAO_MariaImpl implements BangDAO
{
	public List<Bang01VO> findAll() throws Exception 
	{
		List<Bang01VO> ls = new ArrayList<Bang01VO>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(
				"jdbc:mariadb://183.111.242.21:3306/pukyung17",
				"pukyung17","pukyung00!!1");
				
			String sql = "SELECT * FROM bang01_T";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
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
		PreparedStatement stmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://183.111.242.21:3306/pukyung17",
				"pukyung17","pukyung00!!1");
			
			// String sql = "INSERT INTO temp10_T VALUES (?, ?)";
			// String sql = "INSERT INTO bang01_T VALUES ( default, '"+ pvo.getContent() + "', NOW() , '" + pvo.getAuthor() + "')";
			String sql = "INSERT INTO bang01_T VALUES (default, ?, NOW(), ?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, pvo.getContent());
			stmt.setString(2, pvo.getAuthor());
			
			stmt.executeUpdate();
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

public class Test301 {
	public static void main( String[] args )
	{
		BangDAO dao = new BangDAO_MariaImpl();
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

	statement를 prepareStatement로 바꿔보는 예제.
	
*/