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
	DAO ������ �������� �ٽ� ����
	-IA a = new A() ���� ����.
	Ŭ���� �̸��� ����ϴ� DB Ÿ���� ����Ѵ�.
	
	BangDAO dao = new BangDAO(); �ڵ带 BangDAO dao = new BangDAO_MariaImpl(); �� �ν��Ͻ��� �ٲ۴�.
	
	�� �й谡 ȸ�縶�� Ʋ������ ������ ������ �й�Ǵ� ��찡 ����.(����Ʈ����, �鿣��, ���)
	�� �� �� �ƴ� ����� �幰��.
	�鿣�� ����� ��� �����ͼ� �۾��Ѵ�.
	Database ����� DAO�� �ô´ٰ� �� ��
	�鿣��� DB ����� ���ÿ� ���� �ϰ� �Ϸ���?
	�鿣�� ����� DB ����� �� ��������� ���� �ʰ� �Ϸ���?
*/

interface BangDAO{
	public List<Bang01VO> findAll() throws Exception;
	public void add(Bang01VO pvo) throws Exception;
}

// ��¥ DAO�� �ϳ� �����.
// �������̽��� ����Ͽ� ���ư��� ����� �̰ɷ� �ϴ� �鿣�带 �����ϰ� ���ư����� �׽�Ʈ �� �ڿ� ��� ����� BangDAO_MariaImpl�� �������� �ν��Ͻ��� ��ü�Ѵ�.
class BangDAO_KaraImpl implements BangDAO{
	
	// ������ �ݷ��� �Ǿ �� �ȿ� ��� ������ �� ���󰣴�.
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
		// BangDAO dao = new BangDAO_MariaImpl();     ��񸸵�»���� �ٸ�����ٰ� �ϸ� �̰ɷ� �ٲ۴�.
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